package com.olivercode.webfluxpostgresql.controller

import com.olivercode.webfluxpostgresql.error.NotFoundException
import com.olivercode.webfluxpostgresql.service.AppUserService
import com.olivercode.webfluxpostgresql.model.AppUser
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@RestController
@RequestMapping("/api")
class AppUserController (
    private val appUserService: AppUserService
){
    @GetMapping("/users")
    fun getAll() : Flux<AppUser> {
        return appUserService.findAll()
    }

    @GetMapping("/users/{id}")
    fun getById(@PathVariable id:Long) =
        appUserService.findAppUserById(id)
            .switchIfEmpty(
                Mono.error(
                    NotFoundException("User with if $id doenst exist")
                )
            )
}