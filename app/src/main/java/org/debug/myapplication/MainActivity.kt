package org.debug.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.Icons.Default
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                Column {
                    Greeting("Android")
                    var toggle by remember {
                        mutableStateOf(false)
                    }

                    AnimatedVisibility(visible = toggle) {
                        Icon(imageVector = Icons.Default.ArrowBack, contentDescription = null)
                    }
                    AnimatedVisibility(visible = !toggle) {
                        Icon(imageVector = Default.AddCircle, contentDescription = null)
                    }
                    Button(onClick = { toggle = !toggle }) {
                        Text("Toggle")
                    }
                    NavigationBar {
                        NavigationBarItem(
                            icon = {
                                Icon(
                                    painter = rememberVectorPainter(image = Icons.Default.AccountBox),
                                    contentDescription = "item.options.title",
                                    modifier = Modifier.size(28.dp),
                                )
                            },
                            label = null,
                            alwaysShowLabel = false,
                            selected = false,
                            onClick = {
                                //onNavigate(item)
                            },
                        )
                        NavigationBarItem(
                            icon = {
                                AnimatedVisibility(visible = !toggle, enter = fadeIn(), exit = fadeOut()) {
                                    Icon(
                                        painter = rememberVectorPainter(image = Icons.Default.AccountBox),
                                        contentDescription = "item.options.title",
                                        modifier = Modifier.size(28.dp),
                                    )
                                }
                                AnimatedVisibility(visible = toggle, enter = fadeIn(), exit = fadeOut()) {
                                    Icon(
                                        painter = rememberVectorPainter(image = Icons.Default.Add),
                                        contentDescription = "item.options.title",
                                        modifier = Modifier
                                            .size(28.dp),
                                    )
                                }
                            },
                            label = null,
                            alwaysShowLabel = false,
                            selected = toggle,
                            onClick = {

                            },
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}
