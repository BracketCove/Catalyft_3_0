package com.wiseassblog.domain.domainmodel

import com.wiseassblog.domain.constants.ExerciseTarget
import com.wiseassblog.domain.constants.ExerciseType

data class ExerciseTemplate(
    val name: String,
    val targets: List<ExerciseTarget>,
    val isCustom: Boolean,
    val type: ExerciseType
)