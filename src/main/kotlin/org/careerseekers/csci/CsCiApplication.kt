package org.careerseekers.csci

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.scheduling.annotation.EnableAsync

@SpringBootApplication
@EnableAsync
class CsCiApplication

fun main(args: Array<String>) {
    runApplication<CsCiApplication>(*args)
}
