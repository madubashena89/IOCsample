package top.stores.iocsample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class CatActivity: AppCompatActivity() {

    // plain normal injection
    val catRepository: CatRepository =
            api().catRepository

    // lazy injection
    val catApi : CatApi by lazy {
        api().catApi
    }

    // an alternative simpler lazy injection
    // for when the component property itself is a singleton
    val moshi: Moshi
        get() = app().moshi

    fun usage() {
        // or directly inside an activity method
        val repository: CatRepository = app().catRepository
    }

}