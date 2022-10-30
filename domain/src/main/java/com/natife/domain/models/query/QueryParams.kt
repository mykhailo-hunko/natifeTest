package com.natife.domain.models.query

data class QueryParams(
    val query: String,
    val page: Int = 0,
    val limit: Int = 20
)
