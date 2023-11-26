package com.example.composelogin

sealed class Screen(val route: String) {
    object SignIn : Screen("signIn_screen")
    object SignUp : Screen("signUp_screen")

    fun withArgs(vararg args: String): String {
        return buildString {
            append(route)
            args.forEach { args ->
                append("/$args")
            }
        }
    }
}
