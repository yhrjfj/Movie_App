package com.yhr.jfj.movieapp.navigation

import android.health.connect.datatypes.ExerciseRoute
import java.lang.IllegalArgumentException

enum class MovieScreens{
    HomeScreen,
    DetailsScreen;
    companion object{
        fun fromRoute(route: String?): MovieScreens = when (route?.substringBefore("/")){
            HomeScreen.name -> HomeScreen
            DetailsScreen.name -> DetailsScreen
            null -> HomeScreen
            else -> throw IllegalArgumentException("Route $route is not recognized")
        }
    }
}