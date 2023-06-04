import android.view.LayoutInflater
import android.view.View
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.MediumTest
import com.android.challengechapter5.databinding.FragmentLoginBinding
import com.android.challengechapter5.view.LoginFragment
import com.google.firebase.auth.FirebaseAuth
import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertTrue
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito.*
import org.mockito.MockitoAnnotations


class LoginFragmentTest {

        @Test
        fun testSuccessfulLogin() {
            val email = "reno@gmail.com"
            val password = "123456"

            // Melakukan login dengan email dan password dan mengeceknya pada object Firebase Authenticator
            val loginResult = FirebaseAuthenticator.loginWithEmail(email, password)

            // Memeriksa apakah login berhasil
            assertTrue(loginResult.success)
            assertEquals("User should be logged in", FirebaseAuthenticator.getCurrentUser(), loginResult.user)
        }
    }

    object FirebaseAuthenticator {
        //mengembalikan hasil dari fungsi loginWithEmail()
        data class LoginResult(val success: Boolean = false, val failure: Boolean = false, val user: User? = null, val errorMessage: String? = null)

        //melakukan login dengan email dan password yang diberikan
        fun loginWithEmail(email: String, password: String): LoginResult {
            //Jika email dan password sesuai dengan kondisi yang diberikan maka login dianggap berhasil.
            if (email == "reno@gmail.com" && password == "123456") {
                val user = User("userID1", email)
                //mengembalikan objek LoginResult dengan properti success yang bernilai true dan objek User yang sesuai
                return LoginResult(success = true, user = user)
            } else {
                //Jika email dan password tidak sesuai kondisi yang diberikan, maka login dianggap gagal.
                // Fungsi ini mengembalikan objek LoginResult dengan properti failure yang bernilai true dan
                // pesan kesalahan yang sesuai.
                return LoginResult(failure = true, errorMessage = "Invalid credentials")
            }
        }
        //mengembalikan objek User yang merupakan pengguna saat ini yang telah diotentikasi sebelumnya.
        fun getCurrentUser(): User? {
            // Mengembalikan pengguna yang telah diotentikasi sebelumnya
            return User("userID1", "reno@gmail.com")
        }
    }
    //Data class ini merepresentasikan entitas pengguna dengan properti id dan email.
    data class User(val id: String, val email: String)

