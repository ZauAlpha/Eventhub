package zau.springboot.eventhub.Service

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import zau.springboot.eventhub.Model.Event
import zau.springboot.eventhub.Model.Service
import zau.springboot.eventhub.Repository.EventRepository
import zau.springboot.eventhub.Repository.ServiceRepository
@org.springframework.stereotype.Service
class EventHubServiceImpl
@Autowired constructor(
    val eventRepository: EventRepository,
    val serviceRepository: ServiceRepository
) : EventHubService{
    override fun getEventById(id: Long): Event? {
        return eventRepository.getEventById(id)
    }

    override fun getAllEvents(): List<Event> {
        return eventRepository.getAllEvents()
    }

    override fun addEvent(event: Event) : ResponseEntity<Event> {
        val createdEvent = eventRepository.addEvent(event)
        if (createdEvent) {
            return ResponseEntity.ok(event)
        } else {
            return ResponseEntity.badRequest().body(event)
        }
    }

    override fun getServiceById(id: Long): Service? {
        return serviceRepository.getServiceById(id)
    }

    override fun getAllServices(): List<Service> {
        return serviceRepository.getAllServices()
    }

    override fun addService(service: Service) : ResponseEntity<Service> {
        val createdService = serviceRepository.addService(service)
        if (createdService) {
            return ResponseEntity.ok(service)
        } else {
            return ResponseEntity.badRequest().body(service)
        }
    }
    override fun getServices(services: List<Long>) : List<Service> {
        return serviceRepository.getServices(services)
    }

    override fun subscribeToEvent(eventId: Long, serviceId: Long) : ResponseEntity<Event>{
        return  eventRepository.subscribeToEvent(eventId, serviceId)

    }
}