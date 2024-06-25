package com.example.clean_arch_by_kovalenko.data.repository

import com.example.clean_arch_by_kovalenko.data.storage.entity.User
import com.example.clean_arch_by_kovalenko.data.storage.UserStorage
import com.example.clean_arch_by_kovalenko.domain.entity.SaveUserNameParam
import com.example.clean_arch_by_kovalenko.domain.entity.UserName
import com.example.clean_arch_by_kovalenko.domain.repository.UserRepository

class UserRepositoryImpl(private val userStorage: UserStorage) : UserRepository {

    override fun saveName(saveParam: SaveUserNameParam): Boolean {

        return userStorage.save(mapToStorage(saveParam))
    }

    override fun getName(): UserName {

        val user = userStorage.get()

        return mapToDomain(user)
    }

    private fun mapToStorage(saveParam: SaveUserNameParam): User {
        return User(firstName = saveParam.name, lastName = "")
    }

    private fun mapToDomain(user: User):UserName {
        return UserName(user.firstName, user.lastName)
    }
}