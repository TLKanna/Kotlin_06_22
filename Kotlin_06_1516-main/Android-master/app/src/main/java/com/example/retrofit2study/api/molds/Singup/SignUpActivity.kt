package com.example.retrofit2study.api.molds.Singup

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.example.retrofit2study.Module.ToastUp.showToast
import com.example.retrofit2study.R
import com.example.retrofit2study.api.connector.ServerConnector

class SignUpActivity : AppCompatActivity() {
    private lateinit var edtNickname: EditText
    private lateinit var edtUsername: EditText
    private lateinit var edtPassword: EditText
    private lateinit var btnSignup: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        initUI()
        initListener()
    }

    private fun initUI() {
        edtNickname = findViewById(R.id.edt_signUp_nickname)
        edtUsername = findViewById(R.id.edt_signUp_username)
        edtPassword = findViewById(R.id.edt_signUp_password)
        btnSignup = findViewById(R.id.btn_signUp_signUp)
    }

    private fun initListener() {
        btnSignup.setOnClickListener {
            val nickname = edtNickname.text.toString()
            val username = edtUsername.text.toString()
            val password = edtPassword.text.toString()


            ServerConnector.getSignUp(nickname, username, password) {
                when(it?.code){
                    null -> showToast("알 수 없는 오류가 발생하였습니다.")
                    0 -> {
                        showToast("회원가입 성공")
                        finish()
                    }
                    else -> {
                        showToast("오류 발생: ${it.msg}")
                    }
                }
            }
        }
    }
}