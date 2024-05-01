package zau.springboot.eventhub.Repository

import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Repository
import zau.springboot.eventhub.Model.Event
import java.time.LocalDate
import java.util.*

@Repository
class EventRepositoryImpl : EventRepository {
    //add events to the list
    private val events = mutableListOf<Event>(
        Event("Fiesta de pedro", LocalDate.now(), "Fiesta", 1000, listOf(1, 2)),
        Event("Fiesta de juan", LocalDate.of(2024, 3,10), "Fiesta", 2000, listOf(2, 3)),
        Event("Fiesta de maria", LocalDate.of(2024, 9,25), "Fiesta", 3000, listOf(3, 1))
    )

    override fun getEventById(id: Long): Event?{
        return events.find { it.id == id }
    }

    override fun getAllEvents(): List<Event> {
        return events
    }
    override fun addEvent(event: Event): Boolean{
        return events.add(event)
    }
    override fun subscribeToEvent(eventId: Long, userId: Long): ResponseEntity<Event>{
        val event = events.find { it.id == eventId }
        if (event != null){
            event.idServices = event.idServices.plus(userId)
            event.idServices.plus(userId)
            return ResponseEntity.ok(event)
        }else {
            return ResponseEntity.notFound().build()
        }

    }

}