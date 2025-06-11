package org.careerseekers.csci.controllers

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class BasicController {
    @GetMapping("/")
    fun hello(): String {
        return "Hello, world! Service working correctly. Attempt 6"
    }
}