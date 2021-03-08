package factories

import com.github.fourfitlife.data.models.Exercise
import com.github.fourfitlife.data.models.UserExercise
import java.time.LocalDate
import java.util.*
import java.util.UUID.randomUUID


class UserExerciseFactory {
    companion object {
        fun getOne(
            id: String = randomUUID().toString(),
            date: Date = DateFactory.getCurrentAtStartDay(),
            exercise: Exercise = ExerciseFactory.getOne(),
            repetitions: Int? = null,
            secondsTime: Int? = null,
        ): UserExercise {
            return UserExercise(id, exercise, repetitions, secondsTime, date)
        }

        fun getList(size: Int): List<UserExercise> {
            return (0 until size).map { return@map getOne() }
        }
    }
}
