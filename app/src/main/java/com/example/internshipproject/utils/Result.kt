package com.example.internshipproject.utils

class Result<T>(val status: Status, val data: T?, val message: String?) {
    companion object {
        fun <T> success(data: T?): Result<T> {
            return Result(Status.SUCCESS, data, "Success")
        }

        fun <T> error(message: String?): Result<T> {
            return Result(Status.ERROR, null, message)
        }
    }
}

enum class Status {
    SUCCESS,
    ERROR
}
