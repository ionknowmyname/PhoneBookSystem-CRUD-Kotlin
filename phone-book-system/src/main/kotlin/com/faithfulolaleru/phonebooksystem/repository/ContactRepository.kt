package com.faithfulolaleru.phonebooksystem.repository

import com.faithfulolaleru.phonebooksystem.entity.Contact
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface ContactRepository : JpaRepository<Contact, Long> {

    fun findContactByPhone(phone: String): Optional<Contact>
}