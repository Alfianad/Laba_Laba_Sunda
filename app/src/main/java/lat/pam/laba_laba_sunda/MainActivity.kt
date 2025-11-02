package lat.pam.laba_laba_sunda

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import lat.pam.laba_laba_sunda.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnStart.setOnClickListener {
            startActivity(Intent(this, WelcomeActivity::class.java))
        }
    }
}
