package com.example.clean_arch_by_kovalenko.data.storage

import com.example.clean_arch_by_kovalenko.data.storage.entity.User

interface UserStorage {

    fun save(user: User): Boolean

    fun get(): User
}