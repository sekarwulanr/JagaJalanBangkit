package com.example.data

import com.example.data.source.RemoteDataSource
import com.example.data.utils.DataMapper
import com.example.domain.model.User
import com.example.domain.repository.IRepository
import javax.inject.Inject
import javax.sql.CommonDataSource

class Repository @Inject constructor(private val remoteDataSource: RemoteDataSource) : IRepository{

    override suspend fun getUsers(): List<User>? {
        val users = arrayListOf<User>()
        remoteDataSource.getUsers()
        return users
    }

}