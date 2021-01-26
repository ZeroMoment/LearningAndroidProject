package cn.lzm.prac.learn

import android.app.Application
import io.flutter.embedding.engine.FlutterEngine
import io.flutter.embedding.engine.FlutterEngineCache
import io.flutter.embedding.engine.dart.DartExecutor

class MyApplication : Application() {

    lateinit var flutterOneEngine: FlutterEngine

    lateinit var flutterTwoEngine: FlutterEngine

    override fun onCreate() {
        super.onCreate()

        flutterOneEngine = FlutterEngine(this)
        //缓存引擎，只能初始化的时候指定路由，运行时调用不可指定
        flutterOneEngine.navigationChannel.setInitialRoute("one_page")
        flutterOneEngine.dartExecutor.executeDartEntrypoint(
                DartExecutor.DartEntrypoint.createDefault()
        )

        flutterTwoEngine = FlutterEngine(this)
        flutterTwoEngine.navigationChannel.setInitialRoute("two_page")
        flutterTwoEngine.dartExecutor.executeDartEntrypoint(
                DartExecutor.DartEntrypoint.createDefault()
        )

        FlutterEngineCache
                .getInstance()
                .put("one_engiend_id", flutterOneEngine)

        FlutterEngineCache
                .getInstance()
                .put("two_engiend_id", flutterTwoEngine)

    }
}