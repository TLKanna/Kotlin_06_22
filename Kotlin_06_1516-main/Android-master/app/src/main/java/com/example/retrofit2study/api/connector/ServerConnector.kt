package com.example.retrofit2study.api.connector

import android.util.Log
import com.example.retrofit2study.Module.ToastUp
import com.example.retrofit2study.api.ServerRetrofit
import com.example.retrofit2study.api.molds.SingIn.GetSingInRes
import com.example.retrofit2study.api.molds.Singup.GetSingUpRes
import com.example.retrofit2study.api.molds.getArticles.GetArticlesRes
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

object ServerConnector {

    const val TAG = "ServerConnector"

    fun getSignIn(username: String, password: String, onResponse: (GetSingInRes?) -> Unit){

        ServerRetrofit.server.getSingIn(username, password).enqueue(object : Callback<GetSingInRes> {
            override fun onResponse(call: Call<GetSingInRes>, response: Response<GetSingInRes>) {
                onResponse(response.body())
//                val bod = response.body()!!
//                Log.d(TAG,"onResponse-getSingIn: ${response.body()?.msg}")
            }

            override fun onFailure(call: Call<GetSingInRes>, t: Throwable) {
                Log.d(TAG,"onFailure: ${t.message}")
            }
        })
    }

    fun getArticles(onResponse: (GetArticlesRes?) -> Unit){
        ServerRetrofit.server.getArticle().enqueue(object : Callback<GetArticlesRes> {
            override fun onResponse(
                call: Call<GetArticlesRes>,
                response: Response<GetArticlesRes>
            ) {
                onResponse(response.body())
            }

            override fun onFailure(call: Call<GetArticlesRes>, t: Throwable) {
                ToastUp.showToast(t.message.toString())
            }
        })
    }

    fun getSignUp(nickname: String, username: String, password: String, onResponse: (GetSingUpRes?) -> Unit){
        ServerRetrofit.server.getSingUp(nickname, username, password).enqueue(object : Callback<GetSingUpRes>{
            override fun onResponse(call: Call<GetSingUpRes>, response: Response<GetSingUpRes>) {
                onResponse(response.body())
                Log.d(TAG, "onResponse: ${response.body()!!.msg}")
            }

            override fun onFailure(call: Call<GetSingUpRes>, t: Throwable) {
                Log.d(TAG, "onFailure: ${t.message}")
            }
        })

        }
}