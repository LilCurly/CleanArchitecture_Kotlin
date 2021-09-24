package com.example.cryptocurrency_cleanarchitecture.redux

interface Reducer<A: Action, S: State> {
    fun reduce(previousState: S, currentAction: A): S
}