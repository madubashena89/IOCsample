package top.stores.iocsample.ioc

object ApiModule : ApiComponent {
    val loggingInterceptor = HttpLoggingInterceptor()
        .setLevel(HttpLoggingInterceptor.Level.BODY)

    val okHttpClient = OkHttpClient.Builder()
        .addNetworkInterceptor(loggingInterceptor)
        .build()

    val moshi = Moshi.Builder().build()

    val retrofit = Retrofit.Builder()
        .client(okHttpClient)
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .addConverterFactory(MoshiConverterFactory.create(moshi))
        .baseUrl("http://httpbin.org")
        .build()

    val catApi = retrofit.create(CatApi::class.java)

    fun app() = AppComponent.instance
}
    interface AppComponent {
        val moshi: Moshi
        val context: Context

        companion object {
            lateinit var instance: AppComponent
        }

    }