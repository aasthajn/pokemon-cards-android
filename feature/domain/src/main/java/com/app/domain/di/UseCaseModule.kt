package com.app.domain.di

import com.app.domain.repository.Repository
import com.app.domain.usecase.GetCardDetailUseCase
import com.app.domain.usecase.GetCardListUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
class UseCaseModule {

    @Provides
    fun provideGetCardListUseCase(repository: Repository): GetCardListUseCase {
        return GetCardListUseCase(repository)
    }

    @Provides
    fun provideGetCardDetailUseCase(repository: Repository): GetCardDetailUseCase {
        return GetCardDetailUseCase(repository)
    }
}
