package com.example.camera

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {

    val REQUSET_IMAGE_CAPTURE =1 // 사진 촬영 요청코드
    lateinit var  curPhotoPath:String // 문자열 형태의 사진 경로 값 //  늦게 초기화된다는 lateinit

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}