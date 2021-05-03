package top.stores.iocsample.ioc

class AndroidModule(val app: Context) : AndroidComponent {

    private val preferences: SharedPreferences =
        app.getSharedPreferences(app.packageName, Context.MODE_PRIVATE)


    // Our properties are singleton by default
    // but we are by no mean limited to it
    // we can simply implement the property with a getter method
    override val now: Instant
        get() = Instant.now()

    // Need to delay an expensive initialization? No problem
    override val catApi by lazy { retrofit.create(CatApi::class.java) }

    // and if that was not enough, we can use any delegated properties
    // https://kotlinlang.org/docs/reference/delegated-properties.html
    // For example with kotlin-jetpack we can trivially bind a property
    // to a shared preference or an android resource
    override val userId: String by preferences.bindPreference(key = "userId", default = "")
    override val primaryTextColor: Int by app.bindResource(R.color.primaryText)
}