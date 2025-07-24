package com.example

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

class LikeFragment : Fragment(R.layout.fragment_like) {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // 🔹 올바른 뷰 인플레이트 코드
        val view = inflater.inflate(R.layout.fragment_like, container, false)

        // 🔹 view 반환 (이게 없어서 에러가 났던 것!)
        return view
    }
}