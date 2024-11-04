package com.example.project11

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.project11.databinding.ItemImageBinding

// Type alias untuk mendefinisikan fungsi klik pada item
typealias OnClickDisaster = (Disaster) -> Unit

// Adapter untuk menampilkan daftar objek Disaster dalam RecyclerView
class DisasterAdapter(
//    `typealias` diletakkan di awal untuk memperjelas struktur kode dan meningkatkan keterbacaan.
//    Dengan menempatkannya di luar kelas, fungsinya sebagai tipe data pendukung `DisasterAdapter`
//    lebih mudah dikenali, sehingga kode lebih terorganisir dan mudah dipahami.
    private val listDisaster: List<Disaster>,  // Daftar data bencana yang akan ditampilkan
    private val onClickDisaster: OnClickDisaster  // Fungsi yang dipanggil saat item diklik
) : RecyclerView.Adapter<DisasterAdapter.ItemDisasterViewHolder>() {

    // ViewHolder untuk setiap item yang ditampilkan dalam RecyclerView
    inner class ItemDisasterViewHolder(private val binding: ItemImageBinding) :
        RecyclerView.ViewHolder(binding.root) {

        // Fungsi untuk mengikat data Disaster ke tampilan di dalam ViewHolder
        fun bind(data: Disaster) {
            with(binding) {
                // Menampilkan nama bencana pada TextView
                txtDisasterName.text = data.nameDisaster

                // Menampilkan gambar bencana sesuai tipe bencana
                imageDisaster.setImageResource(data.getDisasterDrawable())

                // Mengatur klik pada item, memanggil fungsi onClickDisaster dengan data bencana
                itemView.setOnClickListener {
                    onClickDisaster(data)
                }
            }
        }
    }

    // Fungsi untuk membuat ViewHolder baru saat diperlukan
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemDisasterViewHolder {
        // Menggunakan binding untuk meng-inflate layout item_image.xml sebagai item tampilan
        val binding = ItemImageBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ItemDisasterViewHolder(binding)
    }

    // Mendapatkan ukuran daftar data untuk mengetahui jumlah item dalam RecyclerView
    override fun getItemCount(): Int {
        return listDisaster.size
    }

    // Mengikat data Disaster pada posisi tertentu ke ViewHolder
    override fun onBindViewHolder(holder: ItemDisasterViewHolder, position: Int) {
        holder.bind(listDisaster[position])
    }
}
