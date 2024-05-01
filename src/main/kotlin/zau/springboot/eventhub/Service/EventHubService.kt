package zau.springboot.eventhub.Service

import org.springframework.http.ResponseEntity
import zau.springboot.eventhub.Model.Event
import zau.springboot.eventhub.Model.Service

interface EventHubService {

    fun getEventById(id: Long): Event?
    fun getAllEvents(): List<Event>
    fun addEvent(event: Event) : ResponseEntity<Event>
    fun getServiceById(id: Long): Service?
    fun getAllServices(): List<Service>
    fun addService(service: Service) : ResponseEntity<Service>
    fun getServices(services: List<Long>) : List<Service>
    fun subscribeToEvent(eventId: Long, userId: Long) : ResponseEntity<Event>

}