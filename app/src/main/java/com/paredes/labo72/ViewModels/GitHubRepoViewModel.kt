package com.paredes.labo72.ViewModels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.paredes.labo72.Database.GithubRepo
import com.paredes.labo72.Database.RoomDB
import com.paredes.labo72.Repository.GithubRepoRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class GitHubRepoViewModel (app: Application):AndroidViewModel(app){

    private val repository:GithubRepoRepository

    init {
        val  repoDao = RoomDB.getInstance(app).repoDao()
        repository = GithubRepoRepository(repoDao)
    }

    fun insert(repo: GithubRepo)= viewModelScope.launch(Dispatchers.IO){
        repository.insert(repo)
    }

    fun getAll():LiveData<List<GithubRepo>> = repository.getAll()

    fun nukeAll() = repository.nuke()

}