package com.example.retrofit2study.api.molds.article

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.retrofit2study.Module.ToastUp
import com.example.retrofit2study.R
import com.example.retrofit2study.api.connector.ServerConnector

class ArticleActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_article)

        ServerConnector.getArticles { res ->
            if(res?.code == null)
                ToastUp.showToast("알 수 없는 오류가 발생하였습니다.")
            else if(res.code != 0)
                ToastUp.showToast(res.msg)
            else {
                res.data.forEach {
                    val idx = it.idx
                    val nickname = it.nickname
                    val username = it.username
                    val message = it.message
                    val createat = it.createat

                    Log.d("GetArticle", "idx: ${it.idx}", "nickname: ${it.nickname}")
                }
            }
        }
    }
}