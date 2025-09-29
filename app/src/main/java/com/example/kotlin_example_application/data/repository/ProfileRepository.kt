package com.example.kotlin_example_application.data.repository

import com.example.kotlin_example_application.data.models.ProfileDataSpec

class ProfileRepository {
    suspend fun getProfileData(): ProfileDataSpec {
        return ProfileDataSpec(
            name = "Тестовый юзер",
            email = "test@mail.com",
        )
    }
}