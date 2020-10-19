package com.example.tmdbapplication.data.mapper

interface Mapper<I, O> {
    fun map(input: I): O
    fun unmap(input: O): I
    fun mapList(input: List<I>?): List<O>
    fun unmapList(input: List<O>?): List<I>
}