package com.faithfulolaleru.phonebooksystem.controller

import com.faithfulolaleru.phonebooksystem.dto.ContactRequest
import com.faithfulolaleru.phonebooksystem.dto.ContactResponse
import com.faithfulolaleru.phonebooksystem.service.ContactService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("api/v1/contacts")
class ContactController(private val contactService: ContactService) {

    @PostMapping("/")
    fun createNewContact(
        @RequestBody contactRequest: ContactRequest
    ): ResponseEntity<ContactResponse> {
        val createdContact = contactService.createNewContact(contactRequest)

        return ResponseEntity.ok(createdContact)
    }

    @GetMapping("/")
    fun getAllContacts(): ResponseEntity<List<ContactResponse>> {
        val contacts = contactService.getAllContacts()

        return ResponseEntity.ok(contacts)
    }

    @GetMapping("/{id}")
    fun getContactById(
        @PathVariable id: Long,
    ): ResponseEntity<ContactResponse> {
        val contact = contactService.getContactById(id)

        return ResponseEntity.ok(contact)
    }

    @PutMapping("/{id}")
    fun updateById(
        @PathVariable id: Long,
        @RequestBody contactRequest: ContactRequest
    ): ResponseEntity<ContactResponse> {
        val updated = contactService.updateContactById(id, contactRequest)

        return ResponseEntity.ok(updated)
    }

    @DeleteMapping("/{id}")
    fun deleteById(@PathVariable id: Long): ResponseEntity<String> {
        val deleted = contactService.deleteContactById(id)

        return ResponseEntity.ok(deleted)
    }
}