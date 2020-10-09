package com.example.tmdbapplication.data.mapper

interface Mapper<I, O> {
    fun map(input: I): O
}