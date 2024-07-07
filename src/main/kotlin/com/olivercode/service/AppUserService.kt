package com.olivercode.service

import com.olivercode.webfluxpostgresql.model.AppUser
import com.olivercode.webfluxpostgresql.repository.AppUserRepository
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux

@Service
class AppUserService(
    val appUserRepository: AppUserRepository
) {

    fun findAll(): Flux<AppUser> = appUserRepository.findAll()
}