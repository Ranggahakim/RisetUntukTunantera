package com.example.risetuntuktunantera

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.risetuntuktunantera.ui.theme.RisetUntukTunanteraTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RisetUntukTunanteraTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    // Contoh panggilan komponen Greeting
                    Greeting(
                        name = "Android"
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center // Memperbaiki typo di sini
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text("Hello Geys $name!", fontSize = 24.sp)
            Text("Lopyu", fontSize = 20.sp)
            ClickButton(
                onClick = ::showHiddenText)
            NotifText()

        }
    }
}

// Deklarasikan variabel state di luar composable function
var showNewUI = mutableStateOf(false)

@Composable
fun ClickButton(onClick: () -> Unit)
{
    Button(
        onClick = onClick,
        modifier = Modifier
            .padding(top = 16.dp)
            .height(60.dp)
            .fillMaxWidth(0.8f) // Mengatur lebar tombol
    ) {
        Text("Press Me!", style = TextStyle(fontSize = 20.sp))
    }
}

@Composable
fun NotifText()
{
    if(showNewUI.value)
    {
        Text(randomText(),
            modifier = Modifier.padding(top=16.dp).height(60.dp))
    }
}

fun randomText(): String {
    val newText = "halo"

    return newText
}




fun showHiddenText() {
    Log.d("MyTag", "halo")
    showNewUI.value = !showNewUI.value
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    RisetUntukTunanteraTheme {
        Greeting("Android")
    }
}
