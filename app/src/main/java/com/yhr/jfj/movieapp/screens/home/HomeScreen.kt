package com.yhr.jfj.movieapp.screens.home

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.yhr.jfj.movieapp.MovieRow
import com.yhr.jfj.movieapp.navigation.MovieScreens

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavController) {
    Scaffold(topBar = {
        Surface(
            shadowElevation = 5.dp, modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
        ) {
            CenterAlignedTopAppBar(
                colors = TopAppBarDefaults.smallTopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    titleContentColor = MaterialTheme.colorScheme.background
                ),
                title = { Text(text = "Anime & Movie") },
            )
        }

    }) {
        MainContent(navController = navController)
    }
}

@Composable
fun MainContent(
    navController: NavController, movieList: List<String> = listOf(
        "Attack On Titan",
        " One Piece",
        "Death Note",
        "Dragon Ball Z",
        "Avatar",
        "300",
        "Harry Potter",
        "Life Of Pie"
    )
) {
    Column {
        LazyColumn(
            modifier = Modifier.padding(
                start = 8.dp, top = 60.dp, end = 8.dp, bottom = 16.dp
            )
        ) {
            items(items = movieList) {
                MovieRow(movie = it) { movie ->
                    navController.navigate(route = MovieScreens.DetailsScreen.name + "/$movie")
                }
            }
        }
    }
}
