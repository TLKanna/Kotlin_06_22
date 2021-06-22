package com.example.retrofit2study.sub.signin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.Toast
import com.example.retrofit2study.Module.ToastUp.showToast
import com.example.retrofit2study.R
import com.example.retrofit2study.api.connector.ServerConnector
import com.example.retrofit2study.api.molds.Singup.SignUpActivity
import com.example.retrofit2study.api.molds.article.ArticleActivity

class SigninActivity : AppCompatActivity() {
    private lateinit var edtUsername: EditText
    private lateinit var edtPassword: EditText
    private lateinit var btnSignin: Button
    private lateinit var llSignup: LinearLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signin)

        initUI()
        initListener()
    }

    private fun initUI() {
        edtUsername = findViewById(R.id.edt_signIn_username)
        edtPassword = findViewById(R.id.edt_signIn_password)
        btnSignin = findViewById(R.id.btn_signIn_login)
        llSignup = findViewById(R.id.ll_signIn_signup)
    }

    private fun initListener() {
        btnSignin.setOnClickListener {
            val username = edtUsername.text.toString()
            val password = edtPassword.text.toString()

            ServerConnector.getSignIn(username, password) {
                if(it == null)
                    showToast("서버 오류가 발생하였습니다.")
                else if(it?.code != 0)
                    showToast(it?.msg)
                else
                    showToast("로그인 성공")
                    startActivity(Intent(this, ArticleActivity::class.java))
                    finish()
            }
            llSignup.setOnClickListener {
                startActivity(Intent(this, SignUpActivity::class.java))
            }
        }
    }


}