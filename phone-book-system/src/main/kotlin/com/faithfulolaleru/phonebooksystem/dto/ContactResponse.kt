package com.faithfulolaleru.phonebooksystem.dto

import com.faithfulolaleru.phonebooksystem.entity.Contact

data class ContactResponse(
    var id: Long,
    val name: String,
    val phone: String,
    val address: String
)

fun Contact.toContactResponse() = ContactResponse(
    id = id,
    name = name,
    phone = phone,
    address = address
)
