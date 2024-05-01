package zau.springboot.eventhub.Repository

import org.springframework.http.ResponseEntity
import zau.springboot.eventhub.Model.Event

interface EventRepository {
    fun getEventById(id: Long): Event?
    fun getAllEvents(): List<Event>
    fun addEvent(event: Event) : Boolean
    fun subscribeToEvent(eventId: Long, userId: Long) : ResponseEntity<Event>
}