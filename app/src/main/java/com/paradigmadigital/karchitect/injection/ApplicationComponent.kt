package com.paradigmadigital.karchitect.injection

import android.content.Context
import com.paradigmadigital.karchitect.api.ApiModule
import com.paradigmadigital.karchitect.domain.DomainModule
import com.paradigmadigital.karchitect.domain.db.ChannelsDao
import com.paradigmadigital.karchitect.domain.db.ItemsDao
import com.paradigmadigital.karchitect.platform.ApplicationModule
import com.paradigmadigital.karchitect.ui.main.ChannelsViewModel
import dagger.Component
import okhttp3.OkHttpClient
import java.util.concurrent.Executor
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(
        ApplicationModule::class,
        ApiModule::class,
        DomainModule::class))
interface ApplicationComponent {

    fun inject(into: ChannelsViewModel)

    //Exposed to sub-graphs
    fun provideContext(): Context

    fun provideOkHttpClient(): OkHttpClient

    fun provideChannelsDao(): ChannelsDao

    fun provideItemsDao(): ItemsDao

    fun provideExecutor(): Executor
}
