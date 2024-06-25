package com.example.clean_arch_by_kovalenko.domain.usecase

import com.example.clean_arch_by_kovalenko.domain.entity.SaveUserNameParam
import com.example.clean_arch_by_kovalenko.domain.repository.UserRepository

class SaveUserNameUseCase(private val userRepository: UserRepository) {

    operator fun invoke(param: SaveUserNameParam): Boolean {

        val oldUserName = userRepository.getName()

        if(oldUserName.firstName == param.name) {
            return true
        }

        return userRepository.saveName(param)
    }

}