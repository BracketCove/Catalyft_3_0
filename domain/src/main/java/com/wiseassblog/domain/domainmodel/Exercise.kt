package com.wiseassblog.domain.domainmodel

import com.wiseassblog.domain.constants.ExerciseType

data class Exercise(
    val name: String,
    val sets: List<Set>,
    val type: ExerciseType
)