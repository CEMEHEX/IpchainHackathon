package bone

import com.google.gson.Gson
import khttp.responses.Response
import kotlinx.serialization.json.JSON
import kotlinx.serialization.stringify
import java.io.IOException
import java.lang.Exception

private val LOG_LEVEL = 1

class ApiException(msg: String) : IOException(msg)

object ApiClient {
    val api_key = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJleHAiOjE1NjEwNzUyMDAsInJvbGUiOiJ3cml0ZXIifQ.r2QrkXesExFmufc4d1LEQo_rRryWJbsmAAghPqc8zMY"
    val base_url = "https://org1.hackathon1.ipchain.ru/"
    val member_id = "a6f7b97d018dcdb8572a4f46234e67d0ead216e2055f7f4ed762ed57336d2902";

    fun defaultHeaders(): Map<String, String> {
        return mapOf("Authorization" to "Bearer $api_key")
    }
    fun postRequest(url_add: String, data: String): Response {
        return checkResp(khttp.post(base_url + url_add, data=data, headers = defaultHeaders()))
    }

    fun checkResp(resp: Response): Response {
        if (resp.statusCode == 401) {
            throw ApiException("Unauthorized")
        }
        if (resp.statusCode == 404) {
            throw ApiException("Not found")
        }
        return resp
    }

    fun getRequest(url_add: String, data: String): Response {
        return checkResp(khttp.post(base_url + url_add, data=data, headers = defaultHeaders()))
    }

    fun debug(msg: String) {
        if (LOG_LEVEL > 1) {
            println(msg)
        }
    }

    fun info(msg: String) {
        if (LOG_LEVEL > 0) {
            println(msg)
        }
    }

    fun createObject(description: String): ObjectId {
        val actor = Actor("Иван Иванов", "Автор")
        val transtaction = Transtaction("C", "C1", "general", null,
                data=Creazion(listOf(0), "New algorithm", "algorithm", description, listOf(actor)))
        val gson = Gson()
        val resp = postRequest("proto/transactions", gson.toJson(transtaction))
        if (resp.statusCode == 200) {
            info(resp.text)
            val respData = gson.fromJson<TransactionRegistred>(resp.text, TransactionRegistred::class.java)
            if (respData.actions.size != 1) {
                throw ApiException("Actions size is ${respData.actions.size}")
            }
            return respData.actions[0].memberID
        }
        throw ApiException("No response from server")
    }

    fun acceptRules(objectId: ObjectId) : ObjectId {
        return objectId
    }

    fun zaebis(sources:String, description:String): String {
        val objectId = createObject(description)
        val o2 = acceptRules(objectId)
        return o2
    }

}