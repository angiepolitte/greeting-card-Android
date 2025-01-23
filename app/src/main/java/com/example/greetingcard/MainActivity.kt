//package com.example.greetingcard
//
//import android.os.Bundle
//import androidx.activity.ComponentActivity
//import androidx.activity.compose.setContent
//import androidx.activity.enableEdgeToEdge
//import androidx.compose.foundation.layout.fillMaxSize
//import androidx.compose.foundation.layout.padding
//import androidx.compose.material3.Scaffold
//import androidx.compose.material3.Surface
//import androidx.compose.material3.Text
//import androidx.compose.runtime.Composable
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.tooling.preview.Preview
//import androidx.compose.ui.unit.dp
//import com.example.greetingcard.ui.theme.GreetingCardTheme
//
//class MainActivity : ComponentActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
//        setContent {
//            GreetingCardTheme {
//                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
//                    Greeting(
//                        name = "Angie",
//                        modifier = Modifier.padding(innerPadding)
//                    )
//                }
//            }
//        }
//    }
//}
//
//@Composable
//fun Greeting(name: String, modifier: Modifier = Modifier) {
//    Surface(color = Color.Cyan) {
//        Text(
//            text = "Hello, my name is $name!",
//            modifier = modifier.padding(24.dp)
//        )
//    }
//}
//
//@Preview(showBackground = true)
//@Composable
//fun GreetingPreview() {
//    GreetingCardTheme {
//        Greeting("Angie")
//    }
//}

package com.example.greetingcard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.greetingcard.ui.theme.GreetingCardTheme
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            GreetingCardTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    MainContent(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

//@Composable
//fun MainContent(modifier: Modifier = Modifier) {
//    var backgroundColor by remember { mutableStateOf(Color.Cyan) }
//
//    Surface(
//        color = backgroundColor,
//        modifier = modifier.fillMaxSize()
//    ) {
//        Column(
//            modifier = Modifier.fillMaxSize(),
//            verticalArrangement = Arrangement.Center,
//            horizontalAlignment = Alignment.CenterHorizontally
//        ) {
//            Greeting(name = "Angie")
//            Spacer(modifier = Modifier.height(16.dp))
//            Button(onClick = {
//                backgroundColor = randomColor()
//            }) {
//                Text(text = "Click Me")
//            }
//        }
//    }
//}
@Composable
fun MainContent(modifier: Modifier = Modifier) {
    var backgroundColor by remember { mutableStateOf(Color.Cyan) }
    var clickCount by remember { mutableStateOf(0) } // State for click count

    Surface(
        color = backgroundColor,
        modifier = modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Greeting(name = "Angie")
            Spacer(modifier = Modifier.height(16.dp))
            Text(text = "Button clicked $clickCount times") // Display the click count
            Spacer(modifier = Modifier.height(16.dp))
            Button(onClick = {
                backgroundColor = randomColor() // Change background color
                clickCount++ // Increment the click count
            }) {
                Text(text = "Click Me")
            }
        }
    }
}


@Composable
fun Greeting(name: String) {
    Text(
        text = "Hello, my name is $name!",
        modifier = Modifier.padding(24.dp)
    )
}

fun randomColor(): Color {
    return Color(
        red = Random.nextFloat(),
        green = Random.nextFloat(),
        blue = Random.nextFloat(),
        alpha = 1f
    )
}

@Preview(showBackground = true)
@Composable
fun MainContentPreview() {
    GreetingCardTheme {
        MainContent()
    }
}
