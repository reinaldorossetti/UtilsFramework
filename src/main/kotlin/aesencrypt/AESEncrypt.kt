package aesencrypt

import javax.crypto.Cipher
import javax.crypto.KeyGenerator
import javax.crypto.SecretKey
import javax.crypto.spec.IvParameterSpec

class AESEncrypt {

    private var mySecretKey: SecretKey? = null
    private var myInitializationVector: ByteArray? = null

    fun encrypt(strToEncrypt: String): ByteArray {
        val plainText = strToEncrypt.toByteArray(Charsets.UTF_8)
        val keygen = KeyGenerator.getInstance("AES")
        keygen.init(256)

        val key = keygen.generateKey()
        mySecretKey = key

        val cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING")
        cipher.init(Cipher.ENCRYPT_MODE, key)
        val cipherText = cipher.doFinal(plainText)
        myInitializationVector = cipher.iv

        return cipherText
    }

    fun decrypt(dataToDecrypt: ByteArray): String {
        val cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING")
        val ivSpec = IvParameterSpec(myInitializationVector)
        cipher.init(Cipher.DECRYPT_MODE, mySecretKey, ivSpec)
        val bytes = cipher.doFinal(dataToDecrypt)
        return String(bytes)
    }
}
