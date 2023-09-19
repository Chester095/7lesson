package com.example.a7lesson

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.a7lesson.ui.theme._7lessonTheme
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            _7lessonTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    Greeting("Android")
                }
            }
        }

        val du = DelegatePropUser()
        du.v = "!!!"
        println("VVV ${du.v}")
    }
}

class Delegate {
    var v = "123"

    operator fun getValue(thisRef: Any?, property: KProperty<*>): String {
        return "VVV $v, thank do delegating '${property.name}' to me"
    }

    operator fun setValue(thisRef: Any?, property: KProperty<*>, value: String) {
        println("VVV $value has been assign to '${property.name}' in $thisRef.")
        this.v = value
    }
}


class DelegatePropUser {
    var v: String by getDelegate()
}

fun getDelegate() = Delegate()

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    _7lessonTheme {
        Greeting("Android")
    }
}