package factories

import androidx.annotation.VisibleForTesting
import com.github.fourfitlife.data.models.AffectedMuscle
import com.github.fourfitlife.data.models.Exercise

@VisibleForTesting
class ExerciseFactory {
    companion object {
        fun getOne(
            id: String = "",
            name: String = "an_exercise_name",
            affectedMuscles: ArrayList<AffectedMuscle> =
                AffectedMuscleFactory.getList(1).toCollection(ArrayList()),
            instructions: ArrayList<String> =
                InstructionsFactory.getList(4).toCollection(ArrayList()),
        ): Exercise {
            return Exercise(id, name, instructions, affectedMuscles)
        }
    }
}
