package com.wiseassblog.domain.repository

import com.wiseassblog.domain.ResultWrapper
import com.wiseassblog.domain.domainmodel.ExerciseTemplate

interface IExerciseTemplateRepository {
    fun getExerciseTemplatesByFilter(filter: String, isCustom: Boolean):ResultWrapper<Exception, List<ExerciseTemplate>>
    fun updateExerciseTemplate(template: ExerciseTemplate):ResultWrapper<Exception, Unit>
}