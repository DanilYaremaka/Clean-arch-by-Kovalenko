package com.example.clean_arch_by_kovalenko.domain.repository

import com.example.clean_arch_by_kovalenko.domain.entity.SaveUserNameParam
import com.example.clean_arch_by_kovalenko.domain.entity.UserName

interface UserRepository {

    fun saveName(saveParam: SaveUserNameParam): Boolean

    fun getName(): UserName
}