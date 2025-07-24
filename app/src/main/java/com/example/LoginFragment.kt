package com.example

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.R.*

class LoginFragment : Fragment(layout.fragment_login) {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(layout.fragment_login, container, false)

        val emailEditText = view.findViewById<EditText>(R.id.editTextEmail)
        val passwordEditText = view.findViewById<EditText>(R.id.editTextPassword)
        val loginButton = view.findViewById<Button>(R.id.buttonLogin)
        val findIdButton = view.findViewById<Button>(R.id.buttonFindId)
        val findPasswordButton = view.findViewById<Button>(R.id.buttonFindPassword)
        val signupButton = view.findViewById<Button>(R.id.buttonSignup)
        val kakaoButton = view.findViewById<Button>(R.id.buttonKakaoLogin)

        // 로그인 버튼 클릭 시
        loginButton.setOnClickListener {
            val email = emailEditText.text.toString()
            val password = passwordEditText.text.toString()

            if (email == "android@test.com" && password == "1234") {
                val intent = Intent(requireContext(), MainActivity::class.java)
                startActivity(intent)
                requireActivity().finish()
            } else {
                Toast.makeText(context, "이메일 또는 비밀번호가 틀렸습니다", Toast.LENGTH_SHORT).show()
            }
        }
        // 아이디 찾기 버튼 클릭 시
        findIdButton.setOnClickListener {
            Toast.makeText(context, "아이디 찾기 화면으로 이동", Toast.LENGTH_SHORT).show()
            // 예: replaceFragment(FindIdFragment()) 또는 startActivity(Intent(...))
        }

        // 비밀번호 찾기 버튼 클릭 시
        findPasswordButton.setOnClickListener {
            Toast.makeText(context, "비밀번호 찾기 화면으로 이동", Toast.LENGTH_SHORT).show()
            // 예: replaceFragment(FindPasswordFragment()) 또는 startActivity(Intent(...))
        }

        // 회원가입 버튼 클릭 시
        signupButton.setOnClickListener {
            Toast.makeText(context, "회원가입 화면으로 이동", Toast.LENGTH_SHORT).show()
            // 예: replaceFragment(SignUpFragment()) 또는 startActivity(Intent(...))
        }
        // 카카오로 로그인하기 버튼 클릭 시
        kakaoButton.setOnClickListener {
            Toast.makeText(context, "카카오 로그인 실행", Toast.LENGTH_SHORT).show()
        }
        return view
    }
}