package com.example.cryptocurrency_cleanarchitecture.mappers

interface Mapper<M, E> {
    fun mapToEntity(model: M): E
    fun mapFromEntity(entity: E): M
}