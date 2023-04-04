package com.example.lektion_12_compose

import android.os.Bundle
import android.transition.CircularPropagation
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue        // MANUALLY IMPORT
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue        // MANUALLY IMPORT
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.layout
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.lektion_12_compose.ui.theme.Lektion_12_ComposeTheme
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOf

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            Lektion_12_ComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    // TODO - UI
                    UsernameScreen()
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(name)
}

@Preview(showBackground = true)
@Composable
fun UsernameScreen() {
    var username: String by rememberSaveable {
        mutableStateOf("")
    }

    var testState = rememberSaveable { MutableStateFlow("") }
    val test by testState.collectAsStateWithLifecycle(initialValue = "")

    UsernameInput(username = test, onUsernameChange = { testState.value = it} )



}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UsernameInput(username: String, onUsernameChange: (String) -> Unit) {
    Column(modifier = Modifier.padding(16.dp)) {
        
        Text(
            text = username,
            modifier = Modifier.padding(bottom = 8.dp),
            style = MaterialTheme.typography.bodyMedium
        )
        OutlinedTextField(
            value = username,
            onValueChange = onUsernameChange,
            label = { Text("Name") }
        )
    }

}
























@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Lektion_12_ComposeTheme {


        Row(verticalAlignment = Alignment.CenterVertically
            ) {
            Image(
                painterResource(R.drawable.ic_launcher_background),
                "",
                Modifier
                    .padding(5.dp)
                    .size(75.dp)
                    .clip(CircleShape)
            )

            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Greeting("Hello")
                Greeting("Short Description")
            }

        }

    }
}

