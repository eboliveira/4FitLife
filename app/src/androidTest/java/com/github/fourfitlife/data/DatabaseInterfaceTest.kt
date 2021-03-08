package com.github.fourfitlife.data

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.room.Room
import androidx.test.platform.app.InstrumentationRegistry
import com.github.fourfitlife.data.local.DatabaseInterface
import com.github.fourfitlife.data.local.daos.UserExerciseDao
import com.github.fourfitlife.data.models.UserExercise
import factories.UserExerciseFactory
import getOrAwaitValue
import org.hamcrest.CoreMatchers.equalTo
import org.hamcrest.MatcherAssert.assertThat
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import java.io.IOException
import java.text.SimpleDateFormat
import java.util.*


class DatabaseInterfaceTest {
    private lateinit var userExerciseDao: UserExerciseDao
    private lateinit var db: DatabaseInterface

    @Rule
    @JvmField
    var executor = InstantTaskExecutorRule()

    @Before
    fun createDb() {
        val context = InstrumentationRegistry.getInstrumentation().targetContext
        db = Room.inMemoryDatabaseBuilder(
            context, DatabaseInterface::class.java).build()
        userExerciseDao = db.userExerciseDao()
    }

    @After
    @Throws(IOException::class)
    fun closeDb() {
        db.close()
    }

    @Test
    @Throws(Exception::class)
    fun writeUserExercisesGetAllAndClean() {
        val userExercises: List<UserExercise> = UserExerciseFactory.getList(3)
        userExerciseDao.insertAll(userExercises)
        var userExercisesRoom = userExerciseDao.getAll()
        userExercisesRoom.getOrAwaitValue()
        assertThat(userExercises, equalTo(userExercisesRoom.value))
        userExerciseDao.clean()
        userExercisesRoom = userExerciseDao.getAll()
        userExercisesRoom.getOrAwaitValue()
        assert(userExercisesRoom.value?.isEmpty() ?: false)
    }

    @Test
    @Throws(Exception::class)
    fun getForDay() {
        val todayCalendar = Calendar.getInstance()
        todayCalendar.add(Calendar.DATE, -1)
        val sdf = SimpleDateFormat("yyyy-MM-dd")
        val yesterday = sdf.parse(sdf.format(Date(todayCalendar.timeInMillis)))
        val yesterdayUserExercise = UserExerciseFactory.getOne(date = yesterday!!)
        val todayUserExercise = UserExerciseFactory.getOne()
        userExerciseDao.insertAll(listOf(yesterdayUserExercise, todayUserExercise))

        val userExercisesRoom = userExerciseDao.getAll()
        userExercisesRoom.getOrAwaitValue()
        assertThat(userExercisesRoom.value?.size, equalTo(2))

        val userExerciseRoom = userExerciseDao.getForDay(yesterday)
        userExerciseRoom.getOrAwaitValue()
        assertThat(userExerciseRoom.value, equalTo(listOf(yesterdayUserExercise)))
    }
}
