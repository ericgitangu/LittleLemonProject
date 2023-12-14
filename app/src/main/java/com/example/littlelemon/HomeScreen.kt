package com.example.littlelemon

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController

@ExperimentalMaterial3Api
@Composable
fun HomeScreen(navController: NavHostController) {
    Column (Modifier.fillMaxWidth().fillMaxHeight()){
        TopAppBar()
        UpperPanel()
        WeeklySpecialCard()
        LowerPanel(navController, DishRepository.dishes)
    }
}
