package com.googlehuawei

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatTextView
import com.googlehuawei.constant.BuildTypeFlavorKey
import com.googlehuawei.constant.BuildTypeKey
import com.googlehuawei.constant.FlavorKey
import com.googlehuawei.push.PushService
import com.googlehuawei.util.BuildTypeUtil
import com.googlehuawei.util.FlavorUtil

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        //Key based on buildType(Staging/Production), irrelevant of flavor(Google/Huawei)
        findViewById<AppCompatTextView>(R.id.buildTypeKey).text = BuildTypeKey.baseUrl
        //Key based on flavor(Google/Huawei), irrelevant of buildType(Staging/Production)
        findViewById<AppCompatTextView>(R.id.flavorKey).text = FlavorKey.mapKey
        //Key based on flavor(Google/Huawei), irrelevant of buildType(Staging/Production)
        findViewById<AppCompatTextView>(R.id.buildTypeFlavorKey).text = BuildTypeFlavorKey.key
    }

    fun open(view: View) {
        when(BuildConfig.FLAVOR) {
            FlavorUtil.google ->
                when (BuildConfig.BUILD_TYPE) {
                    BuildTypeUtil.debug -> Toast.makeText(this, PushService.message(), Toast.LENGTH_SHORT).show()
                    BuildTypeUtil.release -> Toast.makeText(this, PushService.message(), Toast.LENGTH_SHORT).show()
                }
            FlavorUtil.huawei ->
                when (BuildConfig.BUILD_TYPE) {
                    BuildTypeUtil.debug -> Toast.makeText(this, PushService.message(), Toast.LENGTH_SHORT).show()
                    BuildTypeUtil.release -> Toast.makeText(this, PushService.message(), Toast.LENGTH_SHORT).show()
                }
        }
    }
}
