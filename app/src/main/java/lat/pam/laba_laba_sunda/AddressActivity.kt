package lat.pam.laba_laba_sunda

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import lat.pam.laba_laba_sunda.databinding.ActivityAddressBinding
import lat.pam.laba_laba_sunda.model.MenuItem

class AddressActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAddressBinding
    private var menu: MenuItem? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddressBinding.inflate(layoutInflater)
        setContentView(binding.root)

        menu = intent.getParcelableExtra("selected_menu")

        binding.btnOrder.setOnClickListener {
            val name = binding.etName.text.toString().trim()
            val alamat = binding.etAddress.text.toString().trim()
            if (name.isEmpty() || alamat.isEmpty()) {
                if (name.isEmpty()) binding.etName.error = "Nama diperlukan"
                if (alamat.isEmpty()) binding.etAddress.error = "Alamat diperlukan"
                return@setOnClickListener
            }

            val i = Intent(this, FinishActivity::class.java)
            i.putExtra("selected_menu", menu)
            i.putExtra("cust_name", name)
            i.putExtra("cust_address", alamat)
            startActivity(i)
            finishAffinity()
        }
    }
}
