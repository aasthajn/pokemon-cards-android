package com.app.data.repositoryimpl

import android.util.Log
import com.app.core.utils.DataState
import com.app.data.datasource.local.LocalDataSource
import com.app.data.datasource.mapper.CardDetailsRemoteToDomainMapper
import com.app.data.datasource.mapper.CardDetailsRemoteToLocalMapper
import com.app.data.datasource.mapper.LocalToDomainMapper
import com.app.data.datasource.mapper.RemoteToDomainMapper
import com.app.data.datasource.mapper.RemoteToLocalMapper
import com.app.data.datasource.remote.RemoteDataSource
import com.app.di.IoDispatcher
import com.app.domain.model.CardData
import com.app.domain.repository.Repository
import com.app.network.APIResponseHandler.resolveError
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject


class RepositoryImpl @Inject constructor(
    private val remoteDataSource: RemoteDataSource,
    private val remoteToDomainMapper: RemoteToDomainMapper,
    private val localDataSource: LocalDataSource,
    private val remoteToLocalMapper: RemoteToLocalMapper,
    private val localToDomainMapper: LocalToDomainMapper,
    private val cardDetailsRemoteToDomainMapper: CardDetailsRemoteToDomainMapper,
    private val cardDetailsRemoteToLocalMapper: CardDetailsRemoteToLocalMapper,
    @IoDispatcher private val ioDispatcher: CoroutineDispatcher
) : Repository {

    override suspend fun getTrendingCards() = flow {
        try {
           // kotlinx.coroutines.delay(500)
            emit(DataState.Loading)
            val result = remoteDataSource.getTrendingCards().cards
            if(result.isNotEmpty()){
                emit(DataState.Success(result.map {
                    remoteToDomainMapper.map(it)
                }))
                localDataSource.delete()
                localDataSource.insertCards(result.map { remoteToLocalMapper.map(it) })
            }
        } catch (exception: Exception) {
            emit(resolveError(exception))
            localDataSource.getTrendingCards()?.let { cardDbList ->
                if(cardDbList.isNotEmpty()){
                    emit(DataState.Success(cardDbList.map { localToDomainMapper.map(it) }))
                }
            }
        }}.flowOn(ioDispatcher)


    override suspend fun getCardDetails(id: String) = flow {
        try {
            emit(DataState.Loading)
            val result = remoteDataSource.getCardDetails(id)
            emit(DataState.Success(cardDetailsRemoteToDomainMapper.map(result.cardDetails)))
            localDataSource.insertCard(cardDetailsRemoteToLocalMapper.map(result.cardDetails))
        } catch (exception: Exception) {
            emit(resolveError(exception))
            localDataSource.getCardDetails(id)?.let { cardDBEntity->
                emit(DataState.Success(localToDomainMapper.map(cardDBEntity)))
            }
        }
    }.flowOn(ioDispatcher)

}
