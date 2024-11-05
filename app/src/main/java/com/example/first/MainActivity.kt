package com.example.first


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.first.ui.theme.FirstTheme
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.Alignment
import androidx.compose.ui.res.painterResource
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextAlign.Companion.Justify

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FirstTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    GreetingPreview()
                }
            }
        }
    }
}
// Greating
@Composable
fun Greeting(message: String, from: String, modifier: Modifier = Modifier) {
    val image = painterResource(R.drawable.androidparty)
    Box(modifier = modifier) {
        Image(
            painter = image,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            alpha = 0.7F
        )
        GreetingText(message = message, from = from)

    }
}
@Composable
fun GreetingText(message: String, from: String, modifier: Modifier = Modifier) {
    Column(verticalArrangement = Arrangement.Center, modifier = modifier.padding(8.dp)) {
        Text(
            text = message,
            fontSize = 100.sp,
            lineHeight = 116.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .padding(start = 20.dp, end = 0.dp, top = 35.dp, bottom = 0.dp)
        )
        Text(
            text = from,
            fontSize = 46.sp,
            modifier = Modifier
                .padding(start = 200.dp, end = 0.dp, top = 15.dp, bottom = 30.dp)
                .align(alignment = Alignment.CenterHorizontally)
                .background(color = Color.Green)
        )
    }
}
// Compose Articles
@Composable
fun ArticleImage(message: String, from: String, end: String, modifier: Modifier = Modifier) {
    val image = painterResource(R.drawable.bg_compose_background)
    Column(modifier = modifier) {
        Image(
            painter = image,
            contentDescription = null,
        )
        ArticleText(message, from, end, modifier)
    }
}
@Composable
fun ArticleText(message: String, from: String, end: String, modifier: Modifier = Modifier) {
    Column(verticalArrangement = Arrangement.Center, modifier = modifier.padding(8.dp)) {
        Text(
            text = message,
            fontSize = 24.sp,
            modifier = Modifier
                .padding(16.dp)
        )
        Text(
            text = from,
            fontSize = 16.sp,
            textAlign = TextAlign.Justify,
            modifier = Modifier
                .padding(start = 16.dp, end = 16.dp, top = 0.dp, bottom = 0.dp)
        )
        Text(
            text = end,
            fontSize = 16.sp,
            textAlign = TextAlign.Justify,
            modifier = Modifier
                .padding(start = 16.dp, end = 16.dp, top = 16.dp, bottom = 16.dp)
        )
    }
}
@Composable
fun ComposeArticles(message: String, from: String, end: String, modifier: Modifier = Modifier) {
    ArticleImage(message, from, end, modifier)
}

// Task Manager
@Composable
fun TaskManager(first: String, second: String, modifier: Modifier = Modifier) {
    Box(contentAlignment = Alignment.Center, modifier = modifier) {
        Column(horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center, modifier = modifier) {
            TaskManagerImage(modifier)
            TaskManagerText(first, second, modifier)
        }
    }
}
@Composable
fun TaskManagerImage(modifier: Modifier = Modifier) {
    val image = painterResource(R.drawable.ic_task_completed)
    Image(
        painter = image,
        contentDescription = null,
    )
}
@Composable
fun TaskManagerText(first: String, second: String, modifier: Modifier = Modifier) {

    Text(
        text = first,
        fontSize = 16.sp,
        fontWeight = FontWeight.Bold,
        modifier = Modifier
            .padding(start = 0.dp, end = 0.dp, top = 24.dp, bottom = 8.dp)
    )
    Text(
        text = second,
        fontSize = 16.sp
    )
}

// Compose quardrant
@Composable
fun EveryCompose(text: String, backgroundColor: Color) {

}

@Composable
fun ComposeQuardrant() {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Row(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth()
        ) {
            Box(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight()
                    .background(Color.Red),
                contentAlignment = Alignment.Center
            ) {
                Text("Widget 1")
            }
            Box(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight()
                    .background(Color.Green),
                contentAlignment = Alignment.Center
            ) {
                Text("Widget 2")
            }
        }
        Row(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth()
        ) {
            Box(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight()
                    .background(Color.Blue),
                contentAlignment = Alignment.Center
            ) {
                Text("Widget 3")
            }
            Box(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight()
                    .background(Color.Yellow),
                contentAlignment = Alignment.Center
            ) {
                Text("Widget 4")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    FirstTheme {
//        Greeting(message = "Hello", from = "Madara")

        // Compose Articles
        var message = "Jetpack Compose tutorial"
        var from = "Jetpack Compose is a modern toolkit for building native Android UI. Compose simplifies and accelerates UI development on Android with less code, powerful tools, and intuitive Kotlin APIs."
        var end = "In this tutorial, you build a simple UI component with declarative functions. You call Compose functions to say what elements you want and the Compose compiler does the rest. Compose is built around Composable functions. These functions let you define your app\\'s UI programmatically because they let you describe how it should look and provide data dependencies, rather than focus on the process of the UI\\'s construction, such as initializing an element and then attaching it to a parent. To create a Composable function, you add the @Composable annotation to the function name."
//        ComposeArticles(message = message, from = from, end = end)

        // Task Manager
        val first = "All tasks completed"
        val second = "Nice work!"
//        TaskManager(first = first, second = second)

        // Compose quardrant
        ComposeQuardrant()
    }
}
