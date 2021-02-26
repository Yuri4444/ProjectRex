package com.berezhnoyyuri9999.projectrex.ui.screens.main

class MainPresenter : MainContract.MainPresenter {

    private var view : MainContract.MainView? = null

    override fun bindView(view: MainContract.MainView) {
        this.view = view
    }

    override fun unBind() {
        this.view = null
    }
}