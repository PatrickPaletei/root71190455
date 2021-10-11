package id.ac.ukdw.pertemuan5_71190455

import android.os.Bundle
import android.os.PersistableBundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class HasilActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hasil)

        val nama = intent.getStringExtra("nama")

        val txtHasil = findViewById<TextView>(R.id.txtHasil)
        txtHasil.text = "Selamat Datang ${nama}"
    }
}