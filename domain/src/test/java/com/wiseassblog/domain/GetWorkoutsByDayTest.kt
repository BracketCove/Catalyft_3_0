package com.wiseassblog.domain

import com.wiseassblog.domain.constants.DateRange
import com.wiseassblog.domain.exception.WorkoutRepositoryException
import com.wiseassblog.domain.repository.IWorkoutRepository
import com.wiseassblog.domain.usecases.GetWorkoutsByDay
import io.mockk.clearAllMocks
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.test.runBlockingTest
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class GetWorkoutsByDayTest {

    val repo: IWorkoutRepository = mockk()

    val useCase = GetWorkoutsByDay(repo)


    @BeforeEach
    fun build() {
        clearAllMocks()
    }

    /**
     * When a user opens the application, retrieve all workouts on the current day
     * 1. Request workout list from repository
     */
    @Test
    fun `On Get Workouts by day successful`() = runBlockingTest {
        val TEST_WORKOUTS = listOf(getWorkout(), getWorkout())
        val TEST_DATE = getWorkout().createdOn
        val DATERANGE_DAY = DateRange.DAY

        coEvery { repo.getWorkoutsByDate(TEST_DATE, DATERANGE_DAY) } returns ResultWrapper.build { TEST_WORKOUTS }

        useCase.execute(TEST_DATE)

        coVerify(exactly = 1) { repo.getWorkoutsByDate(TEST_DATE, DATERANGE_DAY) }
    }


    /**
     * Error case
     */
    @Test
    fun `On Get Workouts by day failure`() = runBlockingTest {
        val TEST_WORKOUTS = listOf(getWorkout(), getWorkout())
        val TEST_DATE = getWorkout().createdOn
        val DATERANGE_DAY = DateRange.DAY

        coEvery { repo.getWorkoutsByDate(TEST_DATE, DATERANGE_DAY) } returns ResultWrapper.build { throw WorkoutRepositoryException }

        val result = useCase.execute(TEST_DATE)

        assert(result is ResultWrapper.Error)
        coVerify(exactly = 1) { repo.getWorkoutsByDate(TEST_DATE, DATERANGE_DAY) }
    }

}
