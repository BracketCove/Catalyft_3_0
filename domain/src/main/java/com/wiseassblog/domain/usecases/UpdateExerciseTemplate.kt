package com.wiseassblog.domain.usecases

import com.wiseassblog.domain.ResultWrapper
import com.wiseassblog.domain.domainmodel.ExerciseTemplate
import com.wiseassblog.domain.repository.IExerciseTemplateRepository

/**
 * When user wishes to update or create a new exercise template
 * 1. write template to repo
 */
class UpdateExerciseTemplate(private val repository: IExerciseTemplateRepository) :
    UseCaseWithParams<ExerciseTemplate, ResultWrapper<Exception, Unit>>() {
    override suspend fun buildUseCase(params: ExerciseTemplate): ResultWrapper<Exception, Unit> {
        return repository.updateExerciseTemplate(params)
    }
}