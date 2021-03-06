package com.github.fourfitlife.ui.day

import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import com.github.fourfitlife.R
import com.github.fourfitlife.data.models.UserExercise
import com.github.fourfitlife.data.repositories.UserExerciseRepository
import factories.ExerciseFactory
import factories.UserExerciseFactory
import io.mockk.*
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@LargeTest
class DayFragmentTest {
    @Before
    fun setUpMocks() {
        mockkStatic(UserExerciseRepository::class)
    }

    @Test
    fun launchFragmentAndCheckRecyclerViewSize() {
        setRepositoryMock(MutableLiveData())

        with(launchFragmentInContainer<DayFragment>()) {
            moveToState(Lifecycle.State.RESUMED)

            onView(withId(R.id.user_exercise_recycler_view)).check(matches(isDisplayed()))
            onView(withId(R.id.user_exercise_recycler_view)).check { view, _ ->
                check((view as RecyclerView).adapter?.itemCount == 0)
            }
        }
    }

    @Test
    fun launchFragmentAndCheckRecyclerCardNameExists() {
        val userExercise = UserExerciseFactory.getOne()
       setRepositoryMock(MutableLiveData(listOf(userExercise)))

        with(launchFragmentInContainer<DayFragment>()) {
            moveToState(Lifecycle.State.RESUMED)

            onView(withId(R.id.user_exercise_recycler_view)).check { view, _ ->
                check((view as RecyclerView).adapter?.itemCount == 1)
            }
            onView(withText(userExercise.exercise.name)).check(matches(isDisplayed()))
        }
    }

    @Test
    fun launchFragmentAndWaitInsertionAndVerifyItemAddedOnRecyclerView() {
        val listSize = 2
        val userExercises = UserExerciseFactory.getList(listSize)
        setRepositoryMock(MutableLiveData(userExercises))


        with(launchFragmentInContainer<DayFragment>()) {
            moveToState(Lifecycle.State.RESUMED)
            onView(withId(R.id.user_exercise_recycler_view)).check { view, _ ->
                check((view as RecyclerView).adapter?.itemCount == listSize)
            }
            onView(withText(userExercises[0].exercise.name)).check(matches(isDisplayed()))
            onView(withText(userExercises[1].exercise.name)).check(matches(isDisplayed()))
        }
    }


    private fun setRepositoryMock(userExercises: MutableLiveData<List<UserExercise>>) {
        every { UserExerciseRepository.userExercises } returns userExercises
    }
}
