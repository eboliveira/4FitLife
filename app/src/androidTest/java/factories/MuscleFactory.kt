package factories

import com.github.fourfitlife.data.models.Exercise
import com.github.fourfitlife.data.models.Muscle
import com.github.fourfitlife.data.models.MuscleGroup
import java.util.*

class MuscleFactory {
    companion object {
        fun getOne(
            id: String = "",
            name: String = "",
            group: MuscleGroup = MuscleGroup.biceps,): Muscle {
            return Muscle(id, name, group)
        }
    }
}
