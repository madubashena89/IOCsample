package top.stores.iocsample.ioc

class ComponentsImplementation(
    override val moshi: Moshi,
    override val context: Context
) : CommonComponent, AppComponent

class CustomApplication: Application() {

    override fun onCreate() {
        // component is both a CommonComponent and a AppComponent
        val component = ComponentsImplementation(
            moshi = Moshi.Builder().build(),
            context = this
        )
        // take care of those lateinit var instance
        AppComponent.instance = component
        CommonComponent.instance = component

    }

}