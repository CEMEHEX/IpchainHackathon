package bone

import kotlinx.serialization.Serializable

@Serializable
abstract class TranstactionData

@Serializable
data class Transtaction(
    val type: String,
    val ccID: String,
    val formatID: String,
    val objID: String?,
    val data: TranstactionData
    )

data class Actor(
        val name: String,
        val type: String
)

@Serializable
data class Creazion(
    val crCodes: List<Int>,
    val nameIP: String,
    val typeIP: String,
    val description: String,
    val actorIP: List<Actor>?
) : TranstactionData()

@Serializable
data class Action(
        val member: String,
        val memberID: String,
        val type: String
)

@Serializable
data class TransactionRegistred(
        val transactionID: String,
        val timestamp: String,
        val actions: List<Action>
)

typealias ObjectId = String

