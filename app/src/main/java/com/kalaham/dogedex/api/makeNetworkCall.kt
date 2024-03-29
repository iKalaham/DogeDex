package com.kalaham.dogedex.api

import com.kalaham.dogedex.R
import com.kalaham.dogedex.api.responses.ApiResponseStatus
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.net.UnknownHostException

suspend fun <T> makeNetworkCall(
    call: suspend  () -> T
): ApiResponseStatus<T> = withContext(Dispatchers.IO){
        try {
            ApiResponseStatus.Success(call())
        } catch (e: UnknownHostException){
            ApiResponseStatus.Error(R.string.unknown_host_exception_error)
        } catch (e: Exception){
            ApiResponseStatus.Error(R.string.unknown_error)
        }
    }
