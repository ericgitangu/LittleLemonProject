package com.example.littlelemon

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.littlelemon.ui.theme.LittleLemonColor
import androidx.compose.material3.Card as MenuCard

@ExperimentalMaterial3Api
@Composable
fun LowerPanel(navController: NavHostController, dishes: List<Dish> = listOf()) {
    LazyVerticalGrid (columns = GridCells.Fixed(1)) {
        items(dishes) { dish ->
            MenuDish(navController, dish)
        }
    }
}

@Composable
fun WeeklySpecialCard() {
    Column {
        MenuCard(
            modifier = Modifier
                .fillMaxWidth()
                .width(20.dp)
        ) {
            Text(
                text = stringResource(R.string.weekly_special),
                style = MaterialTheme.typography.h1,
                modifier = Modifier
                    .padding(16.dp)
            )
        }
    }
}


@ExperimentalMaterial3Api
@Composable
fun MenuDish(navController: NavHostController? = null, dish: Dish) {
    MenuCard(
        onClick = {
            Log.d("AAA", "Click ${dish.id}")
            navController?.navigate(DishDetails.route + "/${dish.id}")

        },
    ) {
        Row(
            modifier = Modifier
                .padding(start = 12.dp, end = 12.dp, top = 16.dp, bottom = 16.dp)
        ) {
            Column(
                modifier = Modifier
                    .padding(start = 12.dp, end = 12.dp, top = 16.dp, bottom = 16.dp)
            ) {
                Text(
                    text = dish.name,
                    style = MaterialTheme.typography.h2,
                )
                Text(
                    text = dish.description,
                    modifier = Modifier
                        .fillMaxWidth(.75f)
                        .padding(top = 5.dp, bottom = 5.dp),
                    style = MaterialTheme.typography.body1
                )
                Text(
                    text = "$${dish.price}",
                    style = MaterialTheme.typography.body2
                )
            }
            Image(
                painter = painterResource(id = dish.imageResource),
                contentDescription = dish.description,
                modifier = Modifier.clip(RoundedCornerShape((10.dp)))
            )
        }
    }
    Divider(
        modifier = Modifier.padding(start = 8.dp, end = 8.dp),
        thickness = 1.dp,
        color = LittleLemonColor.yellow
    )
}