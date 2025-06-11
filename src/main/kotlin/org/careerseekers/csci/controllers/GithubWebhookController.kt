package org.careerseekers.csci.controllers

import org.careerseekers.csci.services.ContainerService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestHeader
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/webhook/github")
class GithubWebhookController(private val containerService: ContainerService) {
    @PostMapping("/users-service")
    fun onPushUsers(
        @RequestBody payload: Map<String, Object>,
        @RequestHeader("X-GitHub-Event") event: String
    ): ResponseEntity<String?> {
        return onPush(payload, event, "cs-users-service")
    }

    @PostMapping("/events-service")
    fun onPushEvents(
        @RequestBody payload: Map<String, Object>,
        @RequestHeader("X-GitHub-Event") event: String
    ): ResponseEntity<String?> {
        return onPush(payload, event, "cs-events-service")
    }

    private fun onPush(payload: Map<String, Object>, event: String, container: String): ResponseEntity<String?> {
        if ("push" == event) {
            val ref = payload["ref"] as String?

            if ("refs/heads/main" == ref) {
                containerService.updateContainers(container)
                return ResponseEntity.ok<String?>("Containers updated")
            }
        }
        return ResponseEntity.ok("No action taken")
    }
}