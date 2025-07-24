package com.example

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.res.ResourcesCompat

// 🔹 앱이 실행될 때 가장 먼저 보여지는 '로딩 화면' 액티비티
class LoadingActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // 🔹 레이아웃 파일 activity_loading.xml을 현재 액티비티 UI로 설정
        setContentView(R.layout.activity_loading)

        // 🔹 텍스트 뷰(ID: logoText)를 찾음 (보통 앱 이름이나 로고 텍스트가 표시됨)
        val logoText = findViewById<TextView>(R.id.logoText)

        // 🔹 'rock_salt'라는 커스텀 폰트를 res/font/rock_salt.ttf에서 불러옴
        val typeface = ResourcesCompat.getFont(this, R.font.rock_salt)

        // 🔹 logoText에 해당 폰트를 적용
        logoText.typeface = typeface

        // 🔹 2초(2000ms) 후에 MainActivity로 전환
        Handler(Looper.getMainLooper()).postDelayed({
            // 🔹 MainActivity로 화면 이동 (Intent 사용)
            startActivity(Intent(this, MainActivity::class.java))
            // 🔹 LoadingActivity는 종료하여 뒤로 가기 눌러도 다시 돌아오지 않게 함
            finish()
        }, 2000)
    }
}