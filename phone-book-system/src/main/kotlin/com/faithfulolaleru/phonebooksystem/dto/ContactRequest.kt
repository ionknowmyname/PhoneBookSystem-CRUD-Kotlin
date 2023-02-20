package com.faithfulolaleru.phonebooksystem.dto

import com.faithfulolaleru.phonebooksystem.entity.Contact

data class ContactRequest(
    val name: String,
    val phone: String,
    val address: String
)

fun ContactRequest.toEntity() = Contact(
    name = name,
    phone = phone,
    address = address,
    id = 0
)
