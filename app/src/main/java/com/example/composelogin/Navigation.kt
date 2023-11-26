package com.example.composelogin

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument

@Composable
fun Navigation() {

    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.SignUp.route) {

        composable(route = Screen.SignUp.route)
        {
            SignUp(navController = navController)
        }

        composable(route = Screen.SignIn.route + "/{name}",
            arguments = listOf(
                navArgument("name") {
                    type = NavType.StringType
                    defaultValue = "Zidan"
                    nullable = true
                }
            )
        ) { entry ->
            SignIn(name = entry.arguments?.getString("name"))
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SignUp(navController: NavController) {
    var signUptext by remember {
        mutableStateOf("")
    }
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 50.dp)
    ) {

        Text(
            text = "Welcome!",
            fontWeight = FontWeight.Bold,
            style = MaterialTheme.typography.headlineLarge
        )
        Text(
            text = "Create you Account!",
            fontWeight = FontWeight.Bold,
            style = MaterialTheme.typography.headlineMedium
        )

        TextField(
            value = signUptext,
            onValueChange = {
                signUptext = it
            },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(8.dp))

        Button(
            onClick = {
                navController.navigate(Screen.SignIn.withArgs(signUptext))
            },
            modifier = Modifier.align(Alignment.End)
        ) {
            Text(text = "SignUp")
        }

    }
}

@Composable
fun SignIn(name: String?) {

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.padding(20.dp)
    ) {

        Text(
            text = "Welcome Back!",
            fontWeight = FontWeight.Bold,

            style = MaterialTheme.typography.headlineLarge
        )
        Text(
            text = "Login Here, $name",
            fontWeight = FontWeight.Bold,
            style = MaterialTheme.typography.headlineMedium
        )
        Spacer(modifier = Modifier.height(8.dp))

    }

}
