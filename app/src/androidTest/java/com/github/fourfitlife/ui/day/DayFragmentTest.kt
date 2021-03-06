package com.github.fourfitlife.ui.day

import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import com.github.fourfitlife.R
import com.github.fourfitlife.data.local.DatabaseInterface
import com.github.fourfitlife.data.local.daos.UserExerciseDao
import com.github.fourfitlife.data.models.UserExercise
import factories.ExerciseFactory
import factories.UserExerciseFactory
import io.mockk.every
import io.mockk.mockk
import io.mockk.mockkStatic
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@LargeTest
class DayFragmentTest {
    lateinit var daoMock: UserExerciseDao
    lateinit var userExercises: MutableLiveData<List<UserExercise>>

    @Before
    fun setUpMocks() {
        mockkStatic(DatabaseInterface::class)
        val databaseMock = mockk<DatabaseInterface>()
        daoMock = mockk()
        val userExercise = UserExerciseFactory.getOne()
        userExercises = MutableLiveData(listOf(userExercise))

        every { DatabaseInterface.getDatabase() } returns databaseMock
        every { databaseMock.userExerciseDao() } returns daoMock
        every { daoMock.getAll() } returns userExercises
    }

    @Test
    fun launchFragmentAndCheckRecyclerViewVisibility() {
        with(launchFragmentInContainer<DayFragment>()) {
            moveToState(Lifecycle.State.RESUMED)
            onView(withId(R.id.user_exercise_recycler_view)).check(matches(isDisplayed()))
        }
    }

    @Test
    fun launchFragmentAndCheckRecyclerViewSize() {
        with(launchFragmentInContainer<DayFragment>()) {
            moveToState(Lifecycle.State.RESUMED)
            onView(withId(R.id.user_exercise_recycler_view)).check { view, _ ->
                check((view as RecyclerView).adapter?.itemCount == 1)
            }
        }
    }

    @Test
    fun launchFragmentAndCheckRecyclerCardNameExists() {
        with(launchFragmentInContainer<DayFragment>()) {
            moveToState(Lifecycle.State.RESUMED)
            val factoryExerciseName = ExerciseFactory.getOne().name
            onView(withText(factoryExerciseName)).check(matches(isDisplayed()))
        }
    }

    @Test
    fun launchFragmentAndCheckRecyclerViewWhenItsEmpty() {
        every { daoMock.getAll() } returns MutableLiveData(listOf())

        with(launchFragmentInContainer<DayFragment>()) {
            moveToState(Lifecycle.State.RESUMED)

            onView(withId(R.id.user_exercise_recycler_view)).check(matches(isDisplayed()))
            onView(withId(R.id.user_exercise_recycler_view)).check { view, _ ->
                check((view as RecyclerView).adapter?.itemCount == 0)
            }
        }
    }

    @Test
    fun launchFragmentAndWaitInsertionAndVerifyItemAddedOnRecyclerView() {
        with(launchFragmentInContainer<DayFragment>()) {
            moveToState(Lifecycle.State.RESUMED)

            val userExercise = UserExerciseFactory.getOne()
            val anotherExerciseName = "another_exercise_name"
            val exercise = ExerciseFactory.getOne(name = anotherExerciseName)
            val userExercise2 = UserExerciseFactory.getOne(exercise = exercise)
            val factoryExerciseName = ExerciseFactory.getOne().name
            runBlocking {
                withContext(Dispatchers.Main) {
                    userExercises.postValue(listOf(userExercise, userExercise2))
                }
            }

            onView(withId(R.id.user_exercise_recycler_view)).check { view, _ ->
                check((view as RecyclerView).adapter?.itemCount == 2)
            }
            onView(withText(factoryExerciseName)).check(matches(isDisplayed()))
            onView(withText(anotherExerciseName)).check(matches(isDisplayed()))
        }
    }
}
