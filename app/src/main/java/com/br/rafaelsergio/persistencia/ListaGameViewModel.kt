package com.br.rafaelsergio.persistencia

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.LiveData
import com.br.rafaelsergio.persistencia.dao.BancoDeDados
import com.br.rafaelsergio.persistencia.model.Game

class ListaGameViewModel(application: Application): AndroidViewModel(application){
    lateinit var games:LiveData<List<Game>>

    private val bd:BancoDeDados = BancoDeDados.getDatabase(application.applicationContext)!!

    init{
        carregarDados()
    }

    private fun carregarDados(){
        games = bd.gameDAO().lerGames()
    }
}