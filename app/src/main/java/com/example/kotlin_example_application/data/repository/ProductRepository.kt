package com.example.kotlin_example_application.data.repository

import com.example.kotlin_example_application.R
import com.example.kotlin_example_application.data.models.ProductDataSpec

class ProductRepository {
    private val mockProducts = listOf(
        ProductDataSpec(
            id = "1",
            name = "Товар 1",
            description = "Описание товара 1",
            price = 199.9,
            imageRes = R.drawable.ic_launcher_foreground
        ),
        ProductDataSpec(
            id = "2",
            name = "Товар 2",
            description = "Описание товара 2",
            price = 199.9,
            imageRes = R.drawable.ic_launcher_foreground
        ),
        ProductDataSpec(
            id = "3",
            name = "Товар 3",
            description = "Описание товара 3",
            price = 199.9,
            imageRes = R.drawable.ic_launcher_foreground
        ),
        ProductDataSpec(
            id = "4",
            name = "Товар 4",
            description = "Описание товара 4",
            price = 199.9,
            imageRes = R.drawable.ic_launcher_foreground
        )
    )

    fun getProducts(): List<ProductDataSpec> {
        return mockProducts
    }

    fun getProductById(id: String): ProductDataSpec? {
        return mockProducts.find { it.id  == id}
    }
}