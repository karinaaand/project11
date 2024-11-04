package com.example.project11

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import com.example.project11.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    // Deklarasi variabel binding yang digunakan untuk mengakses view dari layout activity_main.xml
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Mengaktifkan edge-to-edge mode untuk tampilan yang lebih luas
        enableEdgeToEdge()

        // Inisialisasi binding dengan layout inflater untuk mengakses komponen di activity_main.xml
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Membuat instance DisasterAdapter dan mengirimkan data dummy untuk ditampilkan
        // Ketika item diklik, Toast akan muncul dengan nama bencana yang diklik
        val adapterDisaster = DisasterAdapter(generateDummy()) { disaster ->
            Toast.makeText(this@MainActivity, "You click on ${disaster.nameDisaster}", Toast.LENGTH_SHORT).show()
        }

        // Mengatur RecyclerView di layout dengan adapter dan layout manager Grid
        with(binding) {
            rvDisaster.apply {
                adapter = adapterDisaster
                layoutManager = GridLayoutManager(this@MainActivity, 3) // Menyusun item dalam grid 3 kolom
            }
        }

        // Menyesuaikan padding agar tampilan responsif sesuai dengan insets dari sistem (seperti status bar)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    // Fungsi untuk menghasilkan daftar dummy data bencana dengan nama dan tipe
    fun generateDummy(): List<Disaster> {
        return listOf(
            Disaster("Tsunami", "Natural"),
            Disaster("Flood", "Natural"),
            Disaster("Earthquake", "Man made"),
            Disaster("Fire", "Man made"),
            Disaster("Nuclear Accident", "Man made"),
            Disaster("Wildfire", "Natural"),
            Disaster("Volcanic Eruption", "Natural"),
            Disaster("Drought", "Natural"),
            Disaster("Hurricane", "Natural"),
            Disaster("Blizzard", "Natural"),
            Disaster("Chemical Spill", "Man made"),
            Disaster("Oil Spill", "Man made")

        )
    }
}
