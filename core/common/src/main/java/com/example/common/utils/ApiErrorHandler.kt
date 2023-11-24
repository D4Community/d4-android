package com.example.common.utils

import com.example.common.R


open class ApiErrorHandler {
    //    open fun <T> fetchStatusCodeMessage(status: Response.Status): ResponseState<T> {
//        val resId = when (status.code) {
//            1 -> {
//                R.string.failed_to_create
//            }
//
//            2 -> {
//                R.string.failed_to_update
//            }
//
//            3 -> {
//                R.string.failed_to_delete
//            }
//
//            4 -> {
//                R.string.no_records_found
//            }
//
//            5 -> {
//                R.string.server_error
//            }
//
//            6 -> {
//                R.string.failed_to_upload_to_our_server
//            }
//
//            7 -> {
//                R.string.online_weather_error
//            }
//
//            9 -> {
//                R.string.conversion_error
//            }
//
//            400 -> {
//                R.string.bad_request
//            }
//
//            else -> {
//                R.string.unknown_error
//            }
//        }
//        return if (status.retry) {
//            ResponseState.ErrorRetry(resId)
//        } else {
//            ResponseState.ErrorMessage(resId)
//        }
//    }
//
    open fun <T> fetchHTTPExceptionMessage(msg: String): ResponseState<T> {
        val errors = listOf("400", "500", "304", "404", "413")
        return ResponseState.ErrorMessage(
            when (errors.find { it in msg }) {
//                "400" -> {
//                    R.string.bad_request
//                }
//
//                "500" -> {
//                    R.string.server_error
//                }
//
//                "304" -> {
//                    R.string.failed_to_update
//                }
//
//                "404" -> {
//                    R.string.no_records_found
//                }
//
//                "413" -> {
//                    R.string.file_not_found
//                }

                else -> {
                    R.string.unknown_error
                }
            }
        )
    }
}