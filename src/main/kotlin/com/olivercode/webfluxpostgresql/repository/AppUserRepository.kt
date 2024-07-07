package com.olivercode.webfluxpostgresql.repository

import com.olivercode.webfluxpostgresql.model.AppUser
import org.springframework.data.repository.reactive.ReactiveCrudRepository

interface AppUserRepository : ReactiveCrudRepository<AppUser,Long> {
}