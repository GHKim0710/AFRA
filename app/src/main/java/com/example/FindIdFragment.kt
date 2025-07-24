package com.example

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import android.widget.Button
import android.widget.Toast

class FindIdFragment : Fragment(R.layout.fragment_find_id) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // 예: 버튼 클릭 이벤트 처리 (fragment_find_id.xml에 Button의 id가 buttonFindId라 가정)
        val findIdButton = view.findViewById<Button>(R.id.buttonFindId)

        findIdButton.setOnClickListener {
            Toast.makeText(requireContext(), "아이디 찾기 버튼 클릭됨", Toast.LENGTH_SHORT).show()
            // TODO: 아이디 찾기 로직 구현
        }
    }
}
