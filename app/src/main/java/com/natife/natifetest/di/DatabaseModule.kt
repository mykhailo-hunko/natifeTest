package com.natife.natifetest.di

import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@InstallIn(SingletonComponent::class)
@Module
object DatabaseModule {

    /*  @Singleton
      @Provides
      fun provideAppDatabase(@ApplicationContext appContext: Context): MigrationTestDao {
          val database = Room
              .databaseBuilder(appContext, MigrationTestDatabase::class.java, "testDB")
              //.addMigrations(MigrationTestDatabase.MIGRATION_1_2)
              .allowMainThreadQueries()
              .build()
          return database.getMigrationTestDao()
      }*/

}
