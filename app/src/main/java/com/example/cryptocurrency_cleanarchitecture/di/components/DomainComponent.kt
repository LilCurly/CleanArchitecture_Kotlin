package com.example.cryptocurrency_cleanarchitecture.di.components

import android.content.Context
import com.example.cryptocurrency_cleanarchitecture.MyApplication
import com.example.cryptocurrency_cleanarchitecture.di.DomainModuleDependencies
import dagger.BindsInstance
import dagger.Component

@Component(dependencies = [DomainModuleDependencies::class])
interface DomainComponent {
    fun inject(application: MyApplication)

    @Component.Builder
    interface Builder {
        fun context(@BindsInstance context: Context): Builder
        fun appDependencies(domainModuleDependencies: DomainModuleDependencies): Builder
        fun build(): DomainComponent
    }
}