package com.example.cryptocurrency_cleanarchitecture.redux

import kotlinx.coroutines.flow.Flow

interface Middleware<A: Action, S: State> {
    suspend fun process(currentState: S, action: A): Flow<S>
}