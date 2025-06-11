package org.careerseekers.csci.services

import org.springframework.scheduling.annotation.Async
import org.springframework.stereotype.Service

@Service
class ContainerService {

    @Async
    fun updateContainers(container: String) {
        try {
            ProcessBuilder("docker", "compose", "up", "-d", "--force-recreate", container)
                .inheritIO().start().waitFor()
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}