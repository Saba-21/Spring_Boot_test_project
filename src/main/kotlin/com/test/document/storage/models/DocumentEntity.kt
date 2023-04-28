package com.test.document.storage.models

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table

@Table(name = "FILES")
class DocumentEntity(
    @Id var id: Long? = null,
    val fileName: String,
    val data: ByteArray,
    val contentType: String
)