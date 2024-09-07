package com.example.nerenmicrofinance

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.nerenmicrofinance.ui.theme.NerenMicrofinanceTheme
import com.example.nerenmicrofinance.ui.theme.NavGraph

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NerenMicrofinanceTheme {
                NavGraph()
            }
        }
    }
}