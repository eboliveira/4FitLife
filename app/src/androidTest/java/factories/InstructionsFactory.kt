package factories

class InstructionsFactory {
    companion object {
        fun getList(size: Int): List<String> {
            val strings = arrayListOf(
                "Get down on all fours, placing your hands slightly wider than your shoulders.",
                "Straighten your arms and legs. ",
                "Lower your body until your chest nearly touches the floor.",
                "Pause, then push yourself back up."
            )
            return (0 until size).map {
                return@map strings[(it).rem(strings.size)]
            }
        }
    }
}
