package zau.springboot.eventhub.Model

import org.springframework.boot.autoconfigure.amqp.RabbitConnectionDetails.Address

data class Service(
    val name: String,
    val description: String,
    val email: String,
    val telephone: String,
    val webPage : String,
    val twitter : String,
    val facebook : String,
    val price : Int,
    val type : String,
    val address: String
) {
    companion object {
        var idCounter = 1L
    }

    val id: Long = idCounter++
}
