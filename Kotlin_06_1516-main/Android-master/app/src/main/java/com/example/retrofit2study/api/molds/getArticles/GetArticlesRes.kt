package com.example.retrofit2study.api.molds.getArticles

data class GetArticlesRes (
    val code: Int,
    val msg: String,
    val data: List<Data>
)