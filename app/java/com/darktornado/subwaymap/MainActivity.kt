package com.darktornado.subwaymap

import android.app.Activity
import android.app.AlertDialog
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.webkit.WebView
import android.widget.LinearLayout
import android.widget.Toast

class MainActivity : Activity() {

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menu.add(0, 0, 0, "깃허브")
        menu.add(0, 1, 0, "앱 정보")
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
            when (item.itemId) {
                0 -> startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/DarkTornado/SubwayMap")))
                1 -> showDialog("앱 정보", "노선도 앱 예제입니다. 앱 아이콘은 안드로이드 스튜디오에 있는 아이콘을, 노선도 이미지는 서울교통공사 홈페이지에 있는 것을 사용하였습니다.")
            }
        return super.onOptionsItemSelected(item)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val layout = LinearLayout(this)
        layout.orientation = 1
        val web = WebView(this)
        web.loadUrl("file:///android_asset/map.png");
        web.settings.builtInZoomControls = true
        layout.addView(web)
        setContentView(layout)
    }

    fun showDialog(title: String, msg: String){
        try{
            val dialog = AlertDialog.Builder(this)
            dialog.setTitle(title);
            dialog.setMessage(msg);
            dialog.setNegativeButton("닫기", null)
            dialog.show()
        }catch (e: Exception){
            toast(e.toString());
        }
    }

    fun toast(msg: String){
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show()
    }
}
