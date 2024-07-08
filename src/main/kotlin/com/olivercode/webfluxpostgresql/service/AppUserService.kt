package com.olivercode.webfluxpostgresql.service

import com.olivercode.webfluxpostgresql.error.NotFoundException
import com.olivercode.webfluxpostgresql.model.AppUser
import com.olivercode.webfluxpostgresql.repository.AppUserRepository
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@Service
class AppUserService(
    val appUserRepository: AppUserRepository
) {

    fun findAll(): Flux<AppUser> = appUserRepository.findAll()

    fun findAppUserById(id: Long): Mono<AppUser> =
        appUserRepository.findById(id)
            .switchIfEmpty(
                Mono.error(NotFoundException("User wirh $id not found"))
            )
}