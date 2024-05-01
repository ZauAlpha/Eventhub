package zau.springboot.eventhub.Controller
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.HttpStatusCode
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import zau.springboot.eventhub.Model.Event
import zau.springboot.eventhub.Model.Service
import zau.springboot.eventhub.Service.EventHubService

@RestController
@RequestMapping("/api")
class API
@Autowired constructor(val eventHubService : EventHubService){

    @GetMapping("/events")
    fun getAllEvents(): List<Event> {
        return eventHubService.getAllEvents()
    }
    @GetMapping("/events/{id}")
    fun getEventById(@PathVariable id: Long): ResponseEntity<Event> {

        val event = eventHubService.getEventById(id)
        val response = if (event != null) {

            ResponseEntity.ok(event)

        } else {
            println("event not found")
            ResponseEntity.notFound().build()
        }
        return response
    }
    @PostMapping("/events")
    fun addEvent(@RequestBody event: Event): ResponseEntity<Event> {
        println(event)
        return eventHubService.addEvent(event)
    }
    @GetMapping("/services")
    fun getAllServices(): List<zau.springboot.eventhub.Model.Service> {
        return eventHubService.getAllServices()
    }
    @GetMapping("/services/{id}")
    fun getServiceById(@PathVariable id: Long): ResponseEntity<zau.springboot.eventhub.Model.Service> {
        val service = eventHubService.getServiceById(id)
        return if (service != null) {
            ResponseEntity.ok(service)
        } else {
            ResponseEntity.notFound().build()
        }
    }
    @PostMapping("/services")
    fun addService( @RequestBody service: zau.springboot.eventhub.Model.Service): HttpStatusCode {

        return eventHubService.addService(service).statusCode
    }
    @GetMapping("/services/list")
    fun getServices(@RequestParam services: List<Long>): List<zau.springboot.eventhub.Model.Service> {

        return eventHubService.getServices(services)
    }
    @PostMapping("/events/{id}/subscribe/{serviceId}")
    fun subscribeToEvent(@PathVariable id: Long, @PathVariable serviceId : Long ): ResponseEntity<Event> {
        return eventHubService.subscribeToEvent(id, serviceId)

    }



}