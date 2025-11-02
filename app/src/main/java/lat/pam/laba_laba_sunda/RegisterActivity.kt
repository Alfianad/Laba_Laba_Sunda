package lat.pam.laba_laba_sunda

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import lat.pam.laba_laba_sunda.databinding.ActivityRegisterBinding

class RegisterActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRegisterBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnRegister.setOnClickListener {
            // mock register -> langsung ke Home
            startActivity(Intent(this, HomeActivity::class.java))
            finish()
        }
    }
}
