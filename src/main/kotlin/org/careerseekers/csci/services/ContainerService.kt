package org.careerseekers.csci.services

import org.springframework.scheduling.annotation.Async
import org.springframework.stereotype.Service

@Service
class ContainerService {

    @Async
    fun updateContainers(container: String) {
        try {
            ProcessBuilder("docker-compose", "stop", container)
                .inheritIO().start().waitFor()

            ProcessBuilder("docker-compose", "rm", "-f", container)
                .inheritIO().start().waitFor()

            ProcessBuilder("docker-compose", "up", "-d", container)
                .inheritIO().start().waitFor()

        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}