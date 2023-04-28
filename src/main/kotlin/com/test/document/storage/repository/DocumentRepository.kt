package com.test.document.storage.repository

import com.test.document.storage.models.DocumentEntity
import org.springframework.data.repository.CrudRepository

interface DocumentRepository : CrudRepository<DocumentEntity, Long>