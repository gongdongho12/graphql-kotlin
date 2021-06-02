package com.expediagroup.graphql.examples.server.spring.query

import com.expediagroup.graphql.generator.annotations.GraphQLDescription
import com.expediagroup.graphql.server.operations.Query
import org.springframework.stereotype.Component

@Component
class ConferenceQuery: Query {
    fun conference() = Conference("KotlinConf", 2019)
}

data class Conference(
    @GraphQLDescription("Awesome place to learn 'things'")
    val name: String,
    @Deprecated("no needed anymore")
    val year: Int?)
