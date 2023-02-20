package com.faithfulolaleru.phonebooksystem.entity

import com.faithfulolaleru.phonebooksystem.dto.ContactResponse
import jakarta.persistence.*
import lombok.AllArgsConstructor
import lombok.Builder
import lombok.Data
import lombok.NoArgsConstructor

@Entity(name = "contacts")
//@Data
//@Builder
//@Entity
//@Table(name = "tb_player")
@AllArgsConstructor
@NoArgsConstructor
class Contact(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long = 0,
    var name: String = "",
    var phone: String = "",
    var address: String = ""
)


