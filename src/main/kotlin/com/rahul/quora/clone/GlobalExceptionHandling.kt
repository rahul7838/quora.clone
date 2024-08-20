package com.rahul.quora.clone

import com.rahul.quora.clone.dto.ApiResponse
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class GlobalExceptionHandling {

    @ExceptionHandler(Exception::class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    fun handleException(exception: Exception): ApiResponse {
        val apiResponse = ApiResponse().apply {
            apiError.add(com.rahul.quora.clone.dto.ApiError(exception.message))
        }
        return apiResponse
    }
}