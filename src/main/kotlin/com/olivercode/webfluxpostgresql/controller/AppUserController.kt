package com.olivercode.webfluxpostgresql.controller

import com.olivercode.webfluxpostgresql.service.AppUserService
import com.olivercode.webfluxpostgresql.model.AppUser
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Flux

@RestController
@RequestMapping("/api")
class AppUserController (
    private val appUserService: AppUserService
){
    @GetMapping("/users")
    fun getAll() : Flux<AppUser> {
        println(">>>>>>>>>")
        return appUserService.findAll()
    }
}