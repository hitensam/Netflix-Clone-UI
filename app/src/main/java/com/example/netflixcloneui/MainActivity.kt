package com.example.netflixcloneui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val actionBar = actionBar
        actionBar?.hide()
        setContent {
            Column(
                modifier = Modifier
                    .fillMaxHeight()
                    .background(color = Color.Black)
                    .verticalScroll(rememberScrollState())
            ) {
                topBarUi()
                NetflixConent()
                featuredMoviewSection()
                showDiffTypes(showText = "Watch It Again")
                showDiffTypes(showText = "New Releases")
                showDiffTypes(showText = "Action")
                showDiffTypes(showText = "Thriller")
                showDiffTypes(showText = "Watch It Again")
                showDiffTypes(showText = "New Releases")

            }
        }
    }


    //@Preview(showBackground = true)
    @Composable
    fun topBarUi() {
        Row(
            modifier = Modifier
                .background(color = Color.Black)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = R.drawable.netflix_symbol),
                contentDescription = null,
                modifier = Modifier
                    .size(60.dp)
                    .padding(5.dp)
            )
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = R.drawable.search),
                    contentDescription = null,
                    modifier = Modifier
                        .size(28.dp)
                )
                Image(
                    painter = painterResource(id = R.drawable.user),
                    contentDescription = null,
                    modifier = Modifier
                        .size(55.dp)
                        .padding(start = 10.dp, top = 5.dp, end = 9.dp)
                )
            }

        }
    }


    //@Preview
    @Composable
    fun NetflixConent() {
        Row(
            modifier = Modifier
                .background(color = Color.Black)
                .fillMaxWidth()
                .padding(horizontal = 30.dp, vertical = 12.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "TV Shows",
                fontSize = 20.sp,
                color = Color.Gray
            )
            Text(
                text = "Movies",
                color = Color.Gray,
                fontSize = 20.sp,
            )
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Categories",
                    fontSize = 20.sp,
                    color = Color.Gray,
                )
                Image(
                    painter = painterResource(id = R.drawable.drop_down), contentDescription = null,
                    modifier = Modifier
                        .size(17.dp)
                        .padding(start = 6.dp)
                )
            }
        }
    }

    @Composable
//    @Preview(showBackground = true)
    fun featuredMoviewSection() {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 40.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.breaking_bad), contentDescription = null,
                modifier = Modifier.size(350.dp)
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 60.dp, start = 60.dp, end = 60.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(text = "Thriller ", color = Color.White)
                Text(text = "Crime ", color = Color.White)
                Text(text = "Action ", color = Color.White)
                Text(text = "Drama ", color = Color.White)

            }
            Row(
                modifier = Modifier
                    .padding(top = 40.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.SpaceBetween
                )
                {
                    Image(
                        painter = painterResource(id = R.drawable.plus),
                        contentDescription = null,
                        modifier = Modifier.size(25.dp)
                    )
                    Text(text = "My List", color = Color.White)
                }
                Button(onClick ={},
                    colors = ButtonDefaults.buttonColors(Color.White),
                    shape = RoundedCornerShape(4.dp)
                ){
                    Text(text = "Play", fontSize = 18.sp,
                        color = Color.Black)
                }
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.SpaceBetween
                )
                {
                    Image(
                        painter = painterResource(id = R.drawable.info),
                        contentDescription = null,
                        modifier = Modifier
                            .size(17.dp)
                            .padding(bottom = 5.dp)
                    )
                    Text(text = "Info", color = Color.White)
                }
            }
        }

    }

    @Composable
//    @Preview
    fun showDiffTypes(
        showText : String,
    )
    {


        Column(
            modifier = Modifier.fillMaxWidth()
        )
        {
            Text(text = showText, color = Color.LightGray,
                fontSize = 24.sp,fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(top = 20.dp, start = 12.dp))

            LazyRow( modifier = Modifier.padding(top=4.dp)){

                itemsIndexed(imageShuffle()){
                    index, item -> scrollUiModel(imageRes = item.Image)
                }
            }
        }
    }

    @Composable
//    @Preview
    fun scrollUiModel(
        imageRes: Int
    ){
        Image(painter = painterResource(id = imageRes),
            contentDescription = null,
            modifier = Modifier
                .height(180.dp)
                .width(132.dp))
    }


    fun imageShuffle(): List<MovieItemModel>{
        var listOfMovies = mutableListOf<MovieItemModel>()
        listOfMovies.add(MovieItemModel(R.drawable.poster_1))
        listOfMovies.add(MovieItemModel(R.drawable.poster_2))
        listOfMovies.add(MovieItemModel(R.drawable.poster_3))
        listOfMovies.add(MovieItemModel(R.drawable.poster_4))
        listOfMovies.add(MovieItemModel(R.drawable.poster_5))
        listOfMovies.add(MovieItemModel(R.drawable.poster_6))
        listOfMovies.add(MovieItemModel(R.drawable.poster_7))
        listOfMovies.add(MovieItemModel(R.drawable.poster_8))



        listOfMovies.shuffle()
        return listOfMovies

    }
}

data class MovieItemModel(
    val Image: Int
)