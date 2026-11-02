package chavez.alma.pokedexlist.model.data

import android.content.Context
import chavez.alma.pokedexlist.model.domain.User
import chavez.alma.pokedexlist.model.preferences.ARCHIVO
import chavez.alma.pokedexlist.model.preferences.USER
import chavez.alma.pokedexlist.model.preferences.USERNAME
import kotlin.apply

class Users(context: Context){
    val validUser = listOf<User>(
        User("gamma@mail.com", "123321", "Gammael Escalante"),
        User("emiliano@mail.com", "123321", "Emiliano Marquez"),
        User("dana@mail.com", "123321", "Dana Rios"),
        User("majo@mail.com", "123321", "Majo Enrriquez"),
    )
        val shared = context.getSharedPreferences(
            ARCHIVO, Context.MODE_PRIVATE
        )


        fun saveUser(user: String, name: String) {
            val editor = shared.edit()
            editor.putString(USER, user)
            editor.putString(USERNAME, name)
            editor.apply()
        }

        fun getCurrentUser():User?{
            val user = shared.getString(USER,null)
            if (user!= null){
                return getUserByMail(user)
            }
            return null
        }


        fun logout() {
            val editor = shared.edit()
            editor.putString(USER, null)
            editor.putString(USERNAME, null)
            editor.apply()
        }

        fun isLoggein(): Boolean {
            val user = shared.getString(USER, null)
            val username = shared.getString(USERNAME, null)
            if (user != null && username != null) {
                return true
            }
            return false
        }


        fun getUserByMail(mail: String): User? {
            val users = validUser.filter { it.email.equals(mail, ignoreCase = true) }
            return if (users.isEmpty()) null else users.first()
        }

        fun loginServices(user: String, password: String): User? {
            val user = getUserByMail(user)
            user?.let {
                if (user.password.equals(password)) {
                    return user
                }
            }
            return null

        }

    }


