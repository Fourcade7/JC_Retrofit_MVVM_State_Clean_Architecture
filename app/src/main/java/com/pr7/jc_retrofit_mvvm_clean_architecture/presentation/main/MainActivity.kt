package com.pr7.jc_retrofit_mvvm_clean_architecture.presentation.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.pr7.jc_retrofit_mvvm_clean_architecture.presentation.main.ui.theme.JC_Retrofit_MVVM_Clean_ArchitectureTheme
import com.pr7.jc_retrofit_mvvm_clean_architecture.utils.showlogd
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    val mainViewModel:MainViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
           mainViewModel.getAllPosts()
           showlogd(mainViewModel.mutableStateflow.size.toString())
           showlogd(mainViewModel.errorStateflow)
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

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    JC_Retrofit_MVVM_Clean_ArchitectureTheme {
        Greeting("Android")
    }
}