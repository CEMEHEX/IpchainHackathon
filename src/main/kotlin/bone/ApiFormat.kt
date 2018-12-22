package bone

abstract class TranstactionData

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

data class AstFormat(val sources: String)

data class Creazion(
    val crCodes: List<Int>,
    val nameIP: String,
    val typeIP: String,
    val description: String,
    val actorIP: List<Actor>?,
    val trOthAttr: AstFormat

) : TranstactionData()

data class Action(
        val member: String,
        val memberID: String,
        val type: String
)

data class TransactionRegistred(
        val transactionID: String,
        val timestamp: String,
        val actions: List<Action>
)

typealias ObjectId = String

