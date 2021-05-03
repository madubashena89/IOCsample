package top.stores.iocsample.ioc

import android.content.Context

@CompositeValue.Component(modules = [CatModule::class])
interface AppComponent {
    // new property, directly implemented in the interface
    val catController: CatController
        get() = CatController(catService, catRepository, mainThread, backgroundThread)

    // Existing injected properties
    val catService: CatService
    val catRepository: CatRepository
    //...
}