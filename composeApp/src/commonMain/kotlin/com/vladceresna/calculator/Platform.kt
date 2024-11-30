package com.vladceresna.calculator

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform