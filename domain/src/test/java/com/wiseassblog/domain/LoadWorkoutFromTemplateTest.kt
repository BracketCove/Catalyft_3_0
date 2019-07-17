package com.wiseassblog.domain

import com.wiseassblog.domain.constants.DateRange
import com.wiseassblog.domain.exception.WorkoutRepositoryException
import com.wiseassblog.domain.repository.IWorkoutRepository
import com.wiseassblog.domain.usecases.GetWorkoutsByDay
import com.wiseassblog.domain.usecases.LoadWorkoutFromTemplate
import io.mockk.clearAllMocks
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.test.runBlockingTest
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class LoadWorkoutFromTemplateTest {

    val repo: IWorkoutRepository = mockk()

    val useCase = LoadWorkoutFromTemplate(repo)


    @BeforeEach
    fun build() {
        clearAllMocks()
    }

    /**
     * When a user wants to load a workout from a template, take the workout object out of  the template and give it to the IWorkoutRepository
     * 1. Pull Workout object from WorkoutTemplate
     * 2. Right Workout to the IWorkoutRepository
     */
    @Test
    fun `On Get Workouts by day successful`() = runBlockingTest {
        val TEST_WORKOUT_TEMPLATE = getWorkoutTemplate()
        val TEST_WORKOUT = TEST_WORKOUT_TEMPLATE.workout


        coEvery { repo.updateWorkout(TEST_WORKOUT) } returns ResultWrapper.build { Unit }

        useCase.execute(TEST_WORKOUT_TEMPLATE)

        coVerify(exactly = 1) { repo.updateWorkout(TEST_WORKOUT) }
    }

}
