package br.com.vinicius.financeapp.data.local.repository

import kotlinx.coroutines.flow.Flow

interface Repository<T> {
    suspend fun getAll(): Flow<List<T>>

    suspend fun insert(item: T): Flow<Unit>
}