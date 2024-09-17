package org.example.lolseplltimerserver.testclassfile

import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/test")
class TMyController {
    @PostMapping("/sendPost")
    fun handlePostRequest(@RequestBody message: String): String {
        // 메시지를 처리하고, 필요한 로직 수행
        return "Message received: $message"
    }
}
