package com.leblebi.alone.model

data class UserResponse(
    val `data`: List<User>,
    val page: Int,
    val per_page: Int,
    val total: Int,
    val total_pages: Int
)