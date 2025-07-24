package com.example

import android.graphics.Color
import android.graphics.PorterDuff
import android.os.Bundle
import android.widget.EditText
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.SearchView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.graphics.toColorInt
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 🔹 장바구니 버튼 색상 변경 (검정색 아이콘으로 보이도록 설정)
        val cartButton = findViewById<ImageButton>(R.id.cartButton)
        cartButton.setColorFilter(Color.BLACK, PorterDuff.Mode.SRC_IN)

        // 🔹 SearchView 커스터마이징
        val searchView = findViewById<SearchView>(R.id.searchView)

        // 검색창 내부 EditText 접근: 텍스트 색상 및 힌트 색상 설정
        val searchEditText = searchView.findViewById<EditText>(androidx.appcompat.R.id.search_src_text)
        searchEditText.setTextColor(Color.BLACK)              // 입력 텍스트 색상 (앱 사용자가 입력하는 텍스트)
        searchEditText.setHintTextColor(Color.GRAY)           // 힌트 색상 (개발자가 입력하는 텍스트)

        // 검색창 배경색 설정 (연한 회색)
        searchView.setBackgroundColor("#F0F0F0".toColorInt())

        // 돋보기 아이콘 색상 변경 (진한 회색)
        val searchMagIcon = searchView.findViewById<ImageView>(androidx.appcompat.R.id.search_mag_icon)
        searchMagIcon.setColorFilter(Color.DKGRAY, PorterDuff.Mode.SRC_IN)

        class OnQueryTextListener : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                // 입력 후 검색 버튼 누르면 Toast 메시지 출력
                Toast.makeText(applicationContext, "검색: $query", Toast.LENGTH_SHORT).show()
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                // 텍스트가 변경될 때 별도 동작은 없음
                return false
            }
        }
        searchView.run {
            searchMagIcon.setColorFilter(Color.DKGRAY, PorterDuff.Mode.SRC_IN)

            // 🔹 검색창 동작 정의 (검색 버튼 눌렀을 때 처리)
            setOnQueryTextListener(/* listener = */ OnQueryTextListener())
        }
        // 🔹 BottomNavigationView(하단바) 설정
        val bottomNav = findViewById<BottomNavigationView>(R.id.bottomNavigation)

        // 하단 네비게이션 아이템 클릭 이벤트 처리
        bottomNav.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_home -> {
                    val fragment = supportFragmentManager.findFragmentById(R.id.mainContainer)
                    if (fragment != null) {
                        supportFragmentManager.beginTransaction()
                            .remove(fragment)
                            .commit()
                    }
                    true
                }
                R.id.nav_closet -> {
                    // 옷걸이 메뉴 클릭 시 ClosetFragment로 전환
                    replaceFragment(ClosetFragment())
                    true
                }
                R.id.nav_like -> {
                    // 좋아요 메뉴 클릭 시 LikeFragment로 전환
                    replaceFragment(LikeFragment())
                    true
                }
                R.id.nav_login -> {
                    // 사람/로그인 메뉴 클릭 시 LoginFragment로 전환
                    replaceFragment(LoginFragment())
                    true
                }
                else -> false
            }
        }
    }
    // 🔹 Fragment 교체 함수: 메인 콘텐츠 영역(mainContainer)에 프래그먼트 삽입
    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.mainContainer, fragment)
            .commit()
    }
}
