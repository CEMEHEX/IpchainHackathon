package ast

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.stream.Collectors

fun invokeVisualizer(code: String) {
    val command = "python3 visualize_ast.py"
    println("Command: $command")
    val process = Runtime.getRuntime().exec(command)

    process.outputStream.write(code.toByteArray(Charsets.UTF_8))
    process.outputStream.close()

    process.waitFor()
    val reader = BufferedReader(InputStreamReader(process.errorStream))
    val message = reader.lines().collect(Collectors.joining("\n"))
    println(message)
}

fun main(args: Array<String>) {
    invokeVisualizer("if 2 == 2:\n\tprint(1)\nelse:\n\tprint(2)")
}