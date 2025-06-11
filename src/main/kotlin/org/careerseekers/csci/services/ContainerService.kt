package org.careerseekers.csci.services

import org.springframework.scheduling.annotation.Async
import org.springframework.stereotype.Service

@Service
class ContainerService {

    @Async
    fun updateContainers(container: String) {
        try {
            val pb = ProcessBuilder("/usr/bin/docker", "restart", container)
            pb.inheritIO().start().waitFor()
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}