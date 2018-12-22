package ast

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.stream.Collectors


fun generateAstJsonResponse(code: String): String {
    val getAstCmd = "astexport -i - -p"
    println("Command: $getAstCmd")
    val process = Runtime.getRuntime().exec(getAstCmd)

    process.outputStream.use {
        it.bufferedWriter().append(code).flush()
    }
    process.waitFor()

    val reader = BufferedReader(InputStreamReader(process.inputStream))

    return reader.lines().collect(Collectors.joining("\n"))
}

fun main(args: Array<String>) {
    val code = "a = 2"
    print(generateAstJsonResponse(code))
}