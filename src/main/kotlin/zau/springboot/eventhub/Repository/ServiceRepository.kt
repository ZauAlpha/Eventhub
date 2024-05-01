package zau.springboot.eventhub.Repository

import zau.springboot.eventhub.Model.Service

interface ServiceRepository {
    fun getServiceById(id: Long): Service?
    fun getAllServices(): List<Service>
    fun addService(service: Service) : Boolean
    fun getServices(services: List<Long>) : List<Service>
}