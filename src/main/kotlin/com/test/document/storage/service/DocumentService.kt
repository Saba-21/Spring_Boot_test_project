package com.test.document.storage.service

import com.test.document.storage.models.DocumentDTO
import com.test.document.storage.models.DocumentEntity
import com.test.document.storage.repository.DocumentRepository
import org.springframework.stereotype.Service

@Service
class DocumentService(private val documentRepository: DocumentRepository) {

    fun getById(id: Long): DocumentDTO? {
        val entity = documentRepository.findById(id).orElse(null)
        return entity?.toDto()
    }

    fun getAll(): List<DocumentDTO> {
        val entities = documentRepository.findAll().toList()
        return entities.map { it.toDto() }
    }

    fun save(documentModel: DocumentDTO) {
        documentRepository.save(documentModel.toEntity())
    }

    fun remove(id: Long) {
        documentRepository.deleteById(id)
    }

    fun DocumentEntity.toDto(): DocumentDTO {
        requireNotNull(id) {
            "'id' must not be null when object is returned from database"
        }
        return DocumentDTO(id = id!!, fileName = fileName, contentType = contentType, data = data)
    }

    fun DocumentDTO.toEntity(): DocumentEntity {
        return DocumentEntity(fileName = fileName, contentType = contentType, data = data)
    }

}