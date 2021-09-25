package com.example.cryptocurrency_cleanarchitecture.di.components

import android.content.Context
import com.example.cryptocurrency_cleanarchitecture.MyApplication
import com.example.cryptocurrency_cleanarchitecture.di.ReduxModuleDependencies
import dagger.BindsInstance
import dagger.Component

@Component(dependencies = [ReduxModuleDependencies::class])
interface ReduxComponent {
    fun inject(application: MyApplication)

    @Component.Builder
    interface Builder {
        fun context(@BindsInstance context: Context): Builder
        fun appDependencies(reduxModuleDependencies: ReduxModuleDependencies): Builder
        fun build(): ReduxComponent
    }
}