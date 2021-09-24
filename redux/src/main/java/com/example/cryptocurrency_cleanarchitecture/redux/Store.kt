package com.example.cryptocurrency_cleanarchitecture.redux

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.onEach

class Store<S: State, A: Action>(
    initialState: S,
    private val reducer: Reducer<A, S>,
    private val middlewares: List<Middleware<A, S>> = emptyList()
) {

    private val _state = MutableStateFlow(initialState)
    val state: StateFlow<S> = _state

    suspend fun dispatch(action: A) {
        middlewares.forEach {
            it.process(state.value, action).onEach { middlewareState ->
                _state.value = reducer.reduce(middlewareState, action)
            }
        }

        _state.value = reducer.reduce(_state.value, action)
    }
}