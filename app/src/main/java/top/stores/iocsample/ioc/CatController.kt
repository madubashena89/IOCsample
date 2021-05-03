package top.stores.iocsample.ioc

class CatController(
    // a normal property
    val catId : Int,
    // injected properties
    val catService: CatService = app().catService,
    val catRepository: CatRepository = app().catRepository,
    val backgroundThread: Scheduler = app().backgroundThreadScheduler,
    val mainThread: Scheduler = app().mainThreadScheduler
)