package com.wiseassblog.domain

import com.wiseassblog.domain.constants.CUSTOM
import com.wiseassblog.domain.constants.ExerciseTarget
import com.wiseassblog.domain.repository.IExerciseTemplateRepository
import com.wiseassblog.domain.usecases.GetExerciseTemplates
import io.mockk.clearAllMocks
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.test.runBlockingTest
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class GetExerciseTemplatesTest {

    val repo: IExerciseTemplateRepository = mockk()

    val useCase = GetExerciseTemplates(repo)


    @BeforeEach
    fun build() {
        clearAllMocks()
    }

    /**
     * When user wishes to view custom exercise templates
     * 1. retrieve custom exercise templates
     */
    @Test
    fun `On Get exercise templates successful`() = runBlockingTest {
        val TEST_EXERCISE_TEMPLATE_LIST = listOf(getExerciseTemplate(isCustom = true))
        val FILTER = listOf(ExerciseTarget.CHEST.target, CUSTOM)


        coEvery { repo.getExerciseTemplatesByFilter(FILTER) } returns ResultWrapper.build { TEST_EXERCISE_TEMPLATE_LIST }

        useCase.execute(FILTER)

        coVerify( exactly = 1) { repo.getExerciseTemplatesByFilter(FILTER) }
    }
}
