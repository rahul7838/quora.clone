package com.rahul.quora.clone.dto

import java.time.LocalDateTime


data class ApiResponse(
    var apiError: MutableList<ApiError> = mutableListOf(),
    var data: Any? = null,
    var header: Header = Header()
)

data class Header(
    val time: LocalDateTime = LocalDateTime.now()
)

data class ApiError(val errorMessage: String?, val errorCode: Int? = null)

