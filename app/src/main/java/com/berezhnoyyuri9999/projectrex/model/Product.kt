package com.berezhnoyyuri9999.projectrex.model

import android.accounts.AuthenticatorDescription

data class Product (
        val title: String,
        val photoUrl: String,
        val detail: String,
        val description1: String,
        val description2: String,

        val taken: String,


        val isOnSale: Boolean
)