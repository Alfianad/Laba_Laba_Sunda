package lat.pam.laba_laba_sunda

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import lat.pam.laba_laba_sunda.databinding.ActivityFinishBinding
import lat.pam.laba_laba_sunda.model.MenuItem

class FinishActivity : AppCompatActivity() {
    private lateinit var binding: ActivityFinishBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFinishBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val menu = intent.getParcelableExtra<MenuItem>("selected_menu")
        val custName = intent.getStringExtra("cust_name")
        val custAddress = intent.getStringExtra("cust_address")

        binding.tvHello.text = "Halo, $custName"
        binding.tvInfo.text = if (menu != null) {
            "Terima kasih sudah memesan ${menu.name}. Pesanan akan dikirim ke: \n$custAddress"
        } else {
            "Terima kasih. Pesanan akan segera diproses."
        }

        binding.btnDone.setOnClickListener {
            finishAffinity()
        }
    }
}
