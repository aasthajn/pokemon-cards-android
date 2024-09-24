package com.app.data.di

import com.app.core.utils.Mapper
import com.app.data.datasource.local.LocalDataSource
import com.app.data.datasource.local.LocalDataSourceImpl
import com.app.data.datasource.mapper.CardDetailsRemoteToDomainMapper
import com.app.data.datasource.mapper.LocalToDomainMapper
import com.app.data.datasource.mapper.RemoteToDomainMapper
import com.app.data.datasource.mapper.RemoteToLocalMapper
import com.app.data.datasource.remote.RemoteDataSource
import com.app.data.datasource.remote.RemoteDataSourceImpl
import com.app.data.datasource.remote.model.detail.Data
import com.app.data.datasource.remote.model.list.CardsNetworkEntity
import com.app.data.repositoryimpl.RepositoryImpl
import com.app.database.entity.CardsDBEntity
import com.app.domain.model.CardData
import com.app.domain.repository.Repository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface RepositoryModule {

    @Binds
    @Singleton
    fun bindRepository(repository: RepositoryImpl): Repository

    @Binds
    @Singleton
    fun bindRemoteDataSource(impl: RemoteDataSourceImpl): RemoteDataSource

    @Singleton
    @Binds
    fun bindLocalDataSource(impl: LocalDataSourceImpl): LocalDataSource

    @Singleton
    @Binds
    fun bindRemoteToUIMapper(impl: RemoteToDomainMapper): Mapper<CardsNetworkEntity, CardData>

    @Singleton
    @Binds
    fun bindRemoteToLocalMapper(impl: RemoteToLocalMapper): Mapper<CardsNetworkEntity, CardsDBEntity>


    @Singleton
    @Binds
    fun bindCardDetailsRemoteToDomainMapper(impl: CardDetailsRemoteToDomainMapper): Mapper<Data, CardData>

    @Singleton
    @Binds
    fun bindLocalToDomainMapper(impl: LocalToDomainMapper): Mapper<CardsDBEntity, CardData>
}
