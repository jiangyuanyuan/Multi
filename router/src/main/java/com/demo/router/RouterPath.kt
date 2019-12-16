package com.demo.router

object RouterPath {
    class Home {
        companion object {
            const val PATH_MAIN_ACTIVITY = "/Home/MainActivity"
            const val PATH_MAIN = "/Home/MainFragment"
            const val PATH_HOME = "/Home/HomeFragment"
        }
    }
    class User {
        companion object {
            const val PATH_TEST = "/User/TestFragment"
            const val PATH_LOGIN = "/User/LoginFragment"
        }
    }
    class Order {
        companion object {
            const val PATH_TEST = "/Order/TestFragment"
            const val PATH_ORDER = "/Order/OrderFragment"
        }
    }

    /**
     * 很多个模块的声明   仿照如上
     */



}