package top.stores.iocsample.ioc

import top.stores.iocsample.ioc.ApiModule.app

class Usage(){
    fun usage() {
        // Just a normal call to the constructor
        // with the convention that we don’t pass any values for the optional arguments
        val controller = CatController(catId = 42)
    }

    fun main() {
        val controller = app().catController
    }

}