package com.codepunk.codepunk.util

import com.squareup.moshi.Json
import retrofit2.Converter
import retrofit2.Retrofit
import java.lang.reflect.Type

/**
 * A utility class that uses Moshi's [Json] annotation to convert enums to Strings for use in
 * Retrofit API calls.
 */
class MoshiJsonEnumConverterFactory : Converter.Factory() {

    // region Inherited methods

    override fun stringConverter(
        type: Type?,
        annotations: Array<out Annotation>?,
        retrofit: Retrofit?
    ): Converter<*, String>? {
        return when {
            type is Class<*> && type.isEnum -> {
                Converter<Any?, String> { value ->
                    try {
                        val enum = value as Enum<*>
                        val field = enum.javaClass.getField(enum.name)
                        field.getAnnotation(Json::class.java)?.name ?: value.toString()
                    } catch (e: NoSuchFieldException) {
                        value.toString()
                    }
                }
            }
            else -> null
        }
    }

    // endregion Inherited methods

}