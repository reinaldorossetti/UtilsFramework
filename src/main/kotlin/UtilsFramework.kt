import utils.aesencrypt.AESEncrypt

fun main() {
    println("Teste de criptografia AES!")
    val aesEncrypt = AESEncrypt()
    val textCrifrado = aesEncrypt.encrypt("Reinaldo")
    val textDescritofrado = aesEncrypt.decrypt(textCrifrado)
    println("Criptografando AES: $textCrifrado")
    println("Descriptografando AES: $textDescritofrado")
 }