package top.stores.iocsample.ioc

object Program {
    fun Main(args: Array<String?>?) {
        //dependancy injection
        val user = User(MySQLDAL())
        user.Add()
    }
}

internal class User(dalType: Idal) {
    var dal: Idal = MySQLDAL()
    fun IsValid(): Boolean {
        return true
    }

    fun Add() {
        if (IsValid()) {
            dal.Add(this)
        }
    }

    init {
        // Inversion of Control
        dal = dalType
    }
}

internal interface Idal {
    fun Add(user: User?)
}

internal class MySQLDAL : Idal {
    override fun Add(user: User?) {
        // do nothing
    }
}

internal class SqlServerDAL : Idal {
    override fun Add(user: User?) {}
}