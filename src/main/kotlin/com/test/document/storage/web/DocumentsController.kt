package com.test.document.storage.web

import com.test.document.storage.models.DocumentDTO
import com.test.document.storage.service.DocumentService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import org.springframework.web.multipart.MultipartFile
import org.springframework.web.server.ResponseStatusException

@RestController
class DocumentsController(private val documentService: DocumentService) {

    @GetMapping("/documents")
    fun getAllDocuments(): List<DocumentDTO> {
        return documentService.getAll()
    }

    @GetMapping("/documents/{id}")
    fun getDocumentById(@PathVariable id: Long): DocumentDTO {
        return documentService.getById(id) ?: throw ResponseStatusException(HttpStatus.NOT_FOUND)
    }

    @DeleteMapping("/documents/{id}")
    fun deleteDocumentById(@PathVariable id: Long) {
        documentService.remove(id)
    }

    @PostMapping("/documents")
    fun saveDocument(@RequestPart("file") file: MultipartFile) {
        val document = DocumentDTO(
            fileName = file.originalFilename.orEmpty(),
            data = file.bytes,
            contentType = file.contentType.orEmpty(),
            id = -1
        )
        documentService.save(document)
    }
}