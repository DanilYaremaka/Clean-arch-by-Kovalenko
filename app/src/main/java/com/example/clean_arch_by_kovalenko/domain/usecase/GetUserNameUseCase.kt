package com.example.clean_arch_by_kovalenko.domain.usecase

import com.example.clean_arch_by_kovalenko.domain.entity.UserName
import com.example.clean_arch_by_kovalenko.domain.repository.UserRepository

class GetUserNameUseCase(private val userRepository: UserRepository) {

    operator fun invoke(): UserName {

        return userRepository.getName()
    }
}