package br.com.vinicius.financeapp.data.local.repository

import androidx.lifecycle.LiveData
import kotlinx.coroutines.flow.Flow

interface Repository<T> {
    suspend fun getAll(): Flow<LiveData<List<T>>>
}