package utils.aesencrypt

import java.io.File
import java.time.Instant
import java.time.ZoneId
import java.time.ZoneOffset
import java.time.format.DateTimeFormatter

class CreateFileOrPath {

    fun createPath(path: String ="/existingdir/dir"){
        val directory = File(path)
        try {
            if (directory.mkdir()) {
                println("Directory created successfully")
            }
        } catch (e: Exception){
            throw IllegalArgumentException("Erro to created Directory:  $e")
        }
    }

    fun createFile(fileName: String, fileContent: String, pathToCreate: String){
        try {
            File(pathToCreate + fileName).bufferedWriter().use { out -> out.write(fileContent) }
        } catch (e: Exception){
            throw IllegalArgumentException("Erro to created File:  $e")
        }
    }

    fun getDateTime(): String? {
        DateTimeFormatter.ISO_INSTANT.format(Instant.now())
        return DateTimeFormatter
            .ofPattern("dd-MM-yyyy--HH-mm-ss")
            .withZone(ZoneId.systemDefault())
            .format(Instant.now())
    }

}

fun main() {
    println("Teste de criptografia AES!")
    val teste = CreateFileOrPath()
    teste.createPath("ReinaldoTest")
    teste.createFile("Reinaldo123.txt", "Teste", "ReinaldoTest/")
    println(teste.getDateTime())
}