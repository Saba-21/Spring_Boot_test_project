package com.test.document.storage.models

import com.fasterxml.jackson.annotation.JsonIgnore

class DocumentDTO(
    val id: Long,
    val fileName: String,
    @JsonIgnore
    val data: ByteArray,
    val contentType: String
)
