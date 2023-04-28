package com.test.document.storage.web

import com.test.document.storage.service.DocumentService
import org.springframework.http.*
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.server.ResponseStatusException

@RestController
class DownloadController(private val documentService: DocumentService) {

    @GetMapping("/download/{id}")
    fun download(@PathVariable id: Long): ResponseEntity<ByteArray> {
        val data = documentService.getById(id) ?: throw ResponseStatusException(HttpStatus.NOT_FOUND)
        val headers = HttpHeaders().apply {
            contentType = MediaType.valueOf(data.contentType)
            contentDisposition = ContentDisposition.builder("attachment").filename(data.fileName).build()
        }
        return ResponseEntity(data.data, headers, HttpStatus.OK)
    }

}