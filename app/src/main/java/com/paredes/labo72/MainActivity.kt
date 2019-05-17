package com.paredes.labo72

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.paredes.labo72.Database.GithubRepo
import com.paredes.labo72.ViewModels.GitHubRepoViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val viewModel= ViewModelProviders.of(this).get(GitHubRepoViewModel::class.java)
        btn_add.setOnClickListener{
            val name = et_main.text.toString()
            if(name.isNotEmpty() && name.isNotBlank()){
                viewModel.insert(GithubRepo(name))
            }
        }
        viewModel.getAll().observe(this, Observer { repos->
            Log.d("LISTA DE REPOS", "----------------------------------")
            for(repo in repos){
                Log.d("LISTA DE REPOS", repo.name)
            }
        })
    }
}
