package com.natife.ui

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.ui.viewinterop.AndroidViewBinding
import com.natife.ui.databinding.ActivityMainBinding
import com.natife.ui.theme.TestNatifeTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TestNatifeTheme {
                AndroidViewBinding(ActivityMainBinding::inflate)
            }
        }
    }
}