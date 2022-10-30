package com.natife.natifetest.di

import com.natife.data.repositories.PagingRepositoryImpl
import com.natife.data.repositories.RemoteRepositoryImpl
import com.natife.domain.repositories.PagingRepository
import com.natife.domain.repositories.RemoteRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
interface AppBindModule {

    @Binds
    fun bindRemoteRepositoryImplToRemoteRepository(
        remoteRepositoryImpl: RemoteRepositoryImpl
    ): RemoteRepository

    @Binds
    fun bindPagingRepositoryImplToPagingRepository(
        pagingRepository: PagingRepositoryImpl
    ): PagingRepository

}
