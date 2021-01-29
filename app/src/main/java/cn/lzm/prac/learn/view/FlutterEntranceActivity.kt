package cn.lzm.prac.learn.view

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import cn.lzm.prac.learn.R
import io.flutter.embedding.android.FlutterActivity
import io.flutter.embedding.engine.FlutterEngine
import io.flutter.plugins.GeneratedPluginRegistrant

class FlutterEntranceActivity : FlutterActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_flutter_entrance)

        findViewById<Button>(R.id.to_one_btn).setOnClickListener {
//            gotoFlutter("one_page")
            gotoFlutterWithCache("one_engiend_id")
        }

        findViewById<Button>(R.id.to_two_btn).setOnClickListener {
//            gotoFlutter("two_page")
            gotoFlutterWithCache("two_engiend_id")
        }
    }

    override fun configureFlutterEngine(flutterEngine: FlutterEngine) {
        super.configureFlutterEngine(flutterEngine)
        GeneratedPluginRegistrant.registerWith(flutterEngine)
    }

    fun gotoFlutter(pageRoute: String) {
        startActivity(
                FlutterActivity
                        .withNewEngine()
                        .initialRoute(pageRoute)
                        .build(this@FlutterEntranceActivity)
        )
    }

    fun gotoFlutterWithCache(engineId: String) {
        startActivity(
                FlutterActivity
                        .withCachedEngine(engineId)
                        .build(this@FlutterEntranceActivity)
        )
    }
}