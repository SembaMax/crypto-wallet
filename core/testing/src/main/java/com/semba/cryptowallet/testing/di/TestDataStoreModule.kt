package com.semba.cryptowallet.testing.di

import androidx.datastore.core.DataStore
import androidx.datastore.core.DataStoreFactory
import com.semba.cryptowallet.datastore.di.DataStoreModule
import com.semba.cryptowallet.datastore.serializer.UserPreferencesSerializer
import com.semba.cryptowallet.datastore.data.UserPreferences
import dagger.Module
import dagger.Provides
import dagger.hilt.components.SingletonComponent
import dagger.hilt.testing.TestInstallIn
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.test.TestCoroutineScope
import org.junit.rules.TemporaryFolder
import javax.inject.Singleton

@Module
@TestInstallIn(
    components = [SingletonComponent::class],
    replaces = [DataStoreModule::class]
)
object TestDataStoreModule {

    @Provides
    fun providesTestDataSoreModule(serializer: UserPreferencesSerializer): DataStore<UserPreferences> =
         DataStoreFactory.create(
            serializer = serializer
        ) {
             TemporaryFolder().newFile("test-user-preferences.pb")
        }

}