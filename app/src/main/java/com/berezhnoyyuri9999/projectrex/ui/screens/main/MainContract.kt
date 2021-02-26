package com.berezhnoyyuri9999.projectrex.ui.screens.main

interface MainContract {

    interface MainView {

    }

    interface MainPresenter {

        fun bindView(view : MainContract.MainView)
        fun unBind()
    }

}