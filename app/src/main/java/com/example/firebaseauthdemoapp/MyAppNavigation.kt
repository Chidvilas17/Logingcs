package com.example.firebaseauthdemoapp

import androidx.compose.runtime.Composable

import androidx.compose.ui.Modifier

import androidx.navigation.compose.NavHost

import androidx.navigation.compose.composable

import androidx.navigation.compose.rememberNavController

import com.example.firebaseauthdemoapp.pages.HomePage

import com.example.firebaseauthdemoapp.pages.LoginPage

import com.example.firebaseauthdemoapp.pages.SignupPage

@Composable
fun MyAppNavigtion(modifier: Modifier = Modifier, authViewModel: AuthViewModel){
    val navController = rememberNavController()


    NavHost(navController = navController, startDestination = "login", builder = {
        composable(route = "login") {
            LoginPage(modifier, navController,authViewModel)
        }

        composable(route = "signup") {
            SignupPage(modifier, navController,authViewModel)

        }
        composable(route = "home") {

            HomePage(modifier, navController,authViewModel)

        }
    })





}