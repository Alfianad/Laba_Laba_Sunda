package lat.pam.laba_laba_sunda

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import lat.pam.laba_laba_sunda.adapter.MenuAdapter
import lat.pam.laba_laba_sunda.databinding.ActivityHomeBinding
import lat.pam.laba_laba_sunda.model.MenuItem

class HomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding
    private lateinit var adapter: MenuAdapter
    private lateinit var menus: List<MenuItem>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        menus = getMenus()
        adapter = MenuAdapter(menus) { selected ->
            // enable button jika ada yang dipilih
            binding.btnNext.isEnabled = selected != null
        }

        binding.recycler.apply {
            layoutManager = LinearLayoutManager(this@HomeActivity)
            adapter = this@HomeActivity.adapter
        }

        binding.btnNext.setOnClickListener {
            val selected = adapter.getSelected()
            if (selected != null) {
                val intent = Intent(this, OrderActivity::class.java)
                intent.putExtra("selected_menu", selected)
                startActivity(intent)
            }
        }
    }

    private fun getMenus(): List<MenuItem> {
        // ganti drawableRes dengan file gambar yang kamu tambahkan di res/drawable
        return listOf(
            MenuItem(1, "Nasi Timbel", "Nasi yang dibungkus daun pisang, lengkap lalapan.", 25000, R.drawable.food_timbel),
            MenuItem(2, "Karedok", "Sayur mentah dengan bumbu kacang khas Sunda.", 18000, R.drawable.food_karedok),
            MenuItem(3, "Lotek", "Sayur rebus dengan sambal kacang.", 17000, R.drawable.food_lotek),
            MenuItem(4, "Soto Bandung", "Soto daging sapi dengan kuah gurih.", 22000, R.drawable.food_sotobandung),
            MenuItem(5, "Sayur Asem", "Sayur asem segar khas Sunda.", 16000, R.drawable.food_sayurasem),
            MenuItem(6, "Pepes Ikan", "Ikan dibungkus daun pisang dibumbui.", 20000, R.drawable.food_pepes),
            MenuItem(7, "Nasi Liwet", "Nasi gurih dimasak bersama santan.", 24000, R.drawable.food_nasiliwet),
            MenuItem(8, "Empal Gentong", "Semur daging sapi khas Cirebon/Bandung.", 30000, R.drawable.food_empalgentong),
            MenuItem(9, "Sate Maranggi", "Sate daging dengan bumbu manis-pedas.", 28000, R.drawable.food_satemaranggi),
            MenuItem(10, "Tutug Oncom", "Nasi tumbuk dengan oncom dan sambal.", 15000, R.drawable.food_tutugoncom)
        )
    }
}
