package zau.springboot.eventhub.Model

import java.time.LocalDate
import java.util.Date

data class Event (
    val name : String,
    val date: LocalDate,
    val type : String,
    val actualCost : Long,
    var idServices : List<Long>
){
    val id : Long = idCounter++
    companion object {
        var idCounter = 1L
    }
}