package com.example.kotlin_example_application.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.kotlin_example_application.data.models.ProfileDataSpec
import com.example.kotlin_example_application.data.repository.ProfileRepository

@Composable
fun ProfileScreen(navControlller: NavController) {

    var refreshing by remember { mutableStateOf(true) }
    var profile by remember { mutableStateOf<ProfileDataSpec?>(null) }
    val repository = remember { ProfileRepository() }

    LaunchedEffect(Unit) {
        refreshing = true
        profile = repository.getProfileData()
        refreshing = false
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        profile?.let { data ->
            Text("Профиль", style = MaterialTheme.typography.headlineMedium)
            Text("Пользователь: ${data.name}")
            Text("Почта: ${data.email}")
        }
    }
}
