package factories

import com.github.fourfitlife.data.models.AffectedMuscle

class AffectedMuscleFactory {
    companion object {
        fun getList(size: Int): List<AffectedMuscle> {
            return (0 until size).map {
                return@map AffectedMuscle((1..5).random().toFloat(), MuscleFactory.getOne())
            }
        }
    }
}
