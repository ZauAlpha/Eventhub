package zau.springboot.eventhub.Repository

import zau.springboot.eventhub.Model.Service

@org.springframework.stereotype.Repository
class ServiceRepositoryImpl : ServiceRepository {
    private val services = mutableListOf<Service>(Service(name = "Service 1", description = "Description 1", email = "email1", telephone = "telephone1", webPage = "webPage1", twitter = "twitter1", facebook = "facebook1", price = 1, type = "type1", address = "address1"),
        Service(name = "Service 2", description = "Description 2", email = "email2", telephone = "telephone2", webPage = "webPage2", twitter = "twitter2", facebook = "facebook2", price = 2, type = "type2", address = "address2"),
        Service(name = "Service 3", description = "Description 3", email = "email3", telephone = "telephone3", webPage = "webPage3", twitter = "twitter3", facebook = "facebook3", price = 3, type = "type3", address = "address3"))

    override fun getServiceById(id: Long): Service? {
        return services.find { it.id == id }
    }

    override fun getAllServices(): List<Service> {
        return services
    }

    override fun addService(service: Service) : Boolean {
       return services.add(service)
    }

    override fun getServices(servicesIds: List<Long>): List<Service> {
        val result = mutableListOf<Service>()
        for (service in services) {
            if (servicesIds.contains(service.id)) {
                result.add(service)
            }
        }
        return result
    }
}