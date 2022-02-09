package com.toluleke.mktfy.core

import android.content.ContentResolver
import android.content.Context
import android.content.ContextWrapper
import android.graphics.Bitmap
import android.graphics.ImageDecoder
import android.net.Uri
import android.os.Build
import android.provider.MediaStore
import androidx.activity.ComponentActivity
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.lazy.LazyGridScope
import androidx.compose.foundation.lazy.LazyItemScope
import androidx.compose.runtime.Composable
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.paging.compose.LazyPagingItems
import com.google.gson.Gson
import com.toluleke.mktfy.models.remote.Response
import kotlinx.coroutines.runBlocking
import retrofit2.HttpException


fun Uri.toBitmap(contentResolver: ContentResolver): Bitmap {
    return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
        ImageDecoder.decodeBitmap(ImageDecoder.createSource(contentResolver, this))
    }else{
        MediaStore.Images.Media.getBitmap(contentResolver, this)
    }
}

fun HttpException.getErrorResponse(): Response {
    return try {
        var json: String?
        runBlocking{
            json = response()?.errorBody()?.string()
        }
        Gson().fromJson(json, Response::class.java)
    }catch (e: Exception){
        e.printStackTrace()
        Response("Something went wrong", emptyList())
    }
}
@Suppress("UNCHECKED_CAST")
inline fun <reified VM: ViewModel?> viewModelFactory(
    crossinline getViewModel: () -> VM
): ViewModelProvider.Factory{
    return object: ViewModelProvider.Factory{
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            if(modelClass.isAssignableFrom(VM::class.java)){
                return getViewModel() as T
            }
            throw IllegalArgumentException("Unknown ViewModel")
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
fun <T: Any> LazyGridScope.items(
    lazyPagingItems: LazyPagingItems<T>,
    itemContent: @Composable LazyItemScope.(value: T?) -> Unit
) {
    items(lazyPagingItems.itemCount) { index ->
        itemContent(lazyPagingItems[index])
    }
}

fun Context.getComponentActivity(): ComponentActivity? = when (this) {
    is ComponentActivity -> this
    is ContextWrapper -> baseContext.getComponentActivity()
    else -> null
}