package com.example.camera

import android.location.GnssAntennaInfo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import java.security.Permission
import com.gun0912.tedpermission.PermissionListener;
import com.gun0912.tedpermission.TedPermission;
class MainActivity : AppCompatActivity() {

    val REQUSET_IMAGE_CAPTURE =1 // 사진 촬영 요청코드
    lateinit var  curPhotoPath:String // 문자열 형태의 사진 경로 값 //  늦게 초기화된다는 lateinit

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setPermission()

    }
    private fun setPermission() {
        val permission = object : PermissionListener{
            override fun onPermissionGranted() {//설정해 놓은 위험권한(카메라 접근 등)이 허용된 경우 이곳을 실행
                Toast.makeText(this@AddMemoryActivity,"요청하신 권한이 허용되었습니다.",Toast.LENGTH_SHORT).show()

            }

            override fun onPermissionDenied(deniedPermissions: MutableList<String>?) {//설정해 놓은 위험권한이 거부된 경우 이곳을 실행
                Toast.makeText(this@AddMemoryActivity,"요청하신 권한이 거부되었습니다.",Toast.LENGTH_SHORT).show()
            }
        }

        TedPermission.with(this)
            .setPermissionListener(permission)
            .setRationaleMessage("카메라 앱을 사용하시려면 권한을 허용해주세요.")
            .setDeniedMessage("권한을 거부하셨습니다.앱을 사용하시려면 [앱 설정]-[권한] 항목에서 권한을 허용해주세요.")
            .setPermissions(android.Manifest.permission.WRITE_EXTERNAL_STORAGE, android.Manifest.permission.CAMERA)
            .check()
    }
}
