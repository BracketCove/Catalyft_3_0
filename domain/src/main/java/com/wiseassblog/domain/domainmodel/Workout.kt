package com.wiseassblog.domain.domainmodel

data class Workout(
    val name:String,
    val createdOn: String,
    val exercies: List<Exercise>
)