package lat.pam.laba_laba_sunda

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import lat.pam.laba_laba_sunda.databinding.ActivityOrderBinding
import lat.pam.laba_laba_sunda.model.MenuItem

class OrderActivity : AppCompatActivity() {
    private lateinit var binding: ActivityOrderBinding
    private var menu: MenuItem? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOrderBinding.inflate(layoutInflater)
        setContentView(binding.root)

        menu = intent.getParcelableExtra("selected_menu")
        menu?.let {
            binding.tvName.text = it.name
            binding.tvDesc.text = it.description
            binding.tvPrice.text = "Rp ${it.price}"
            binding.ivFood.setImageResource(it.drawableRes)
        }

        binding.btnAlamat.setOnClickListener {
            val i = Intent(this, AddressActivity::class.java)
            i.putExtra("selected_menu", menu)
            startActivity(i)
        }
    }
}
