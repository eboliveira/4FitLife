package factories

import java.text.SimpleDateFormat
import java.util.*

class DateFactory {
    companion object {
        fun getCurrentAtStartDay(): Date {
            val sdf = SimpleDateFormat("yyyy-MM-dd")
            val date = Date()
            return Date(sdf.parse(sdf.format(date))!!.time)
        }
    }
}
