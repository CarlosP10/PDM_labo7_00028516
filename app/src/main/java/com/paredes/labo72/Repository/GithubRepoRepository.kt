package com.paredes.labo72.Repository

import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData
import com.paredes.labo72.Database.GithubDAO
import com.paredes.labo72.Database.GithubRepo

class GithubRepoRepository (private val repoDao:GithubDAO){

    @WorkerThread
    suspend fun insert(repo:GithubRepo){
        repoDao.insert(repo)
    }

    fun getAll():LiveData<List<GithubRepo>> = repoDao.getAllRepos()

    fun nuke() = repoDao.nukeTable()
}