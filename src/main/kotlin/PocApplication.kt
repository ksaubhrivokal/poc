import io.ktor.serialization.kotlinx.protobuf.*
import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import io.ktor.server.plugins.contentnegotiation.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.encodeToHexString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kotlinx.serialization.protobuf.ProtoBuf


class PocApplication {
}


//class ProtobufConverter : ContentConverter {
////    suspend fun convertForReceive(context: PipelineContext<Unit, ApplicationCall>): Any? {
////        val request = context.
////        val channel = request.value as? ByteReadChannel ?: return null
////        return channel.readRemaining().readBytes()
////            .let {
////                request.type.javaObjectType.getMethod("parseFrom", ByteArray::class.java).invoke(null, it)
////            }
////    }
//
////    suspend fun convertForSend(
////        context: PipelineContext<Any, ApplicationCall>,
////        contentType: ContentType,
////        value: Any
////    ): Any? {
////        if (value !is MessageLite) return null
////        return ByteArrayContent(value.toByteArray(), contentType)
////    }
//
//    override suspend fun deserialize(charset: Charset, typeInfo: TypeInfo, content: ByteReadChannel): Any? {
//
//    }
//
//    override suspend fun serialize(
//        contentType: ContentType,
//        charset: Charset,
//        typeInfo: TypeInfo,
//        value: Any
//    ): OutgoingContent? {
//
//        TODO("Not yet implemented")
//    }
//}



@OptIn(ExperimentalSerializationApi::class)
fun Application.routes() {
    routing {
        get("/poc") {
//            call.respond("kalpesh")
            val protoResult = PersonDelivery().deliverPerson().build()
            val normalResult = PersonDelivery().deliverPersonV2()
            val result = protoResult.toByteArray()
            val finalResult = result.map { it.toString().toInt() }
            val serializedInstance = Json.encodeToString(result)
            val protoResultForPersonV2 = ProtoBuf.encodeToHexString(protoResult.toByteArray())
            call.respond(protoResultForPersonV2)
        }

        get("/read/poc") {
            val data = call.receive<String>()
            call.respond(data)
//            val person = ProtoBuf.decodeFromHexString<Person>(data)
//            call.respond(person.email)
        }

    }
}


@OptIn(ExperimentalSerializationApi::class)
fun main(args: Array<String>) {


    embeddedServer(Netty, port = 8080) {
        install(ContentNegotiation) {
//            jackson()
            protobuf()
//            protobuf(ProtoBuf {
//                encodeDefaults = false
////                serializersModule = SerializersModule {
////                    val type = PersonV2::class.java
////
////                    contextual(PersonV2::class.java, ByteArraySerializer())
////                }
//            })
////            protobuf(ProtoBuf {
////                encodeDefaults = true
//////                serializersModule = SerializersModule {
//////                    contextual(PersonOrBuilder::class.java, NumberSerializers.LongSerializer)
//////                }
////            })
//
        }


//        KtorCommonPackage(appMicrometerRegistry, this)
        routes()
    }.start(wait = true)

}