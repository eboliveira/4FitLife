package factories

import com.github.fourfitlife.data.models.Exercise
import com.github.fourfitlife.data.models.UserExercise
import java.util.*


class UserExerciseFactory {
    companion object {
        fun getOne(
            id: String = "",
            date: Date = Date(),
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
