package soto.gamma.biometricauth.data

private val USER = "Gamma@gmail.com"
private val PASSWORD = "123321"

fun authenticate(user: String, password: String): Boolean{
    if(user.equals(USER, ignoreCase = true) && password.equals(PASSWORD)){
        return true
    }
    return false
}