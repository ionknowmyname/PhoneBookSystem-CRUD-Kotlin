package com.faithfulolaleru.phonebooksystem.service

import com.faithfulolaleru.phonebooksystem.dto.ContactRequest
import com.faithfulolaleru.phonebooksystem.dto.ContactResponse
import com.faithfulolaleru.phonebooksystem.dto.toContactResponse
import com.faithfulolaleru.phonebooksystem.dto.toEntity
import com.faithfulolaleru.phonebooksystem.entity.Contact

import com.faithfulolaleru.phonebooksystem.repository.ContactRepository
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException

@Service
class ContactService(private val contactRepository: ContactRepository) {

    fun getAllContacts(): List<ContactResponse> {
        val allContacts = contactRepository.findAll();

        return allContacts.map { it.toContactResponse() }
    }

    fun getContactById(id: Long): ContactResponse {
        val found = contactRepository.findById(id)

        if(!found.isPresent) throw ResponseStatusException(HttpStatus.NOT_FOUND)

        return found.get().toContactResponse();
    }

    fun createNewContact(contactRequest: ContactRequest): ContactResponse {
        val alreadyExists = contactRepository.findContactByPhone(contactRequest.phone)
        if (alreadyExists.isPresent) {
            throw ResponseStatusException(HttpStatus.CONFLICT)
        }
        val contact = Contact()
        contact.name = contactRequest.name
        contact.phone = contactRequest.phone
        contact.address = contactRequest.address

        return contactRepository.save(contact).toContactResponse();
    }

    fun updateContactById(id: Long, contactRequest: ContactRequest): ContactResponse {
        val found = contactRepository.findById(id)

        if(!found.isPresent) throw ResponseStatusException(HttpStatus.NOT_FOUND)

        found.get().name = contactRequest.name
        found.get().phone = contactRequest.phone
        found.get().address = contactRequest.address

        return contactRepository.save(found.get()).toContactResponse()
    }

    fun deleteContactById(id: Long): String {
        if (contactRepository.existsById(id)) {
            contactRepository.deleteById(id)

            return "Successfully deleted entry with id $id"
        } else throw ResponseStatusException(HttpStatus.NOT_FOUND)
    }
}