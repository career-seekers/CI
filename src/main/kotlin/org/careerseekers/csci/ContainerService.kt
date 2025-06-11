package org.careerseekers.csci

import org.springframework.scheduling.annotation.Async
import org.springframework.stereotype.Service

@Service
class ContainerService {

    @Async
    fun updateContainers(container: String) {
        try {
            val pb = ProcessBuilder("docker", "restart", container)
            pb.inheritIO().start().waitFor()
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}