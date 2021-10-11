package id.ac.ukdw.pertemuan5_71190455

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val edtNama = findViewById<EditText>(R.id.edtNama)
        val btnSubmit = findViewById<Button>(R.id.btnSumbit)

        btnSubmit.setOnClickListener {
            val intent = Intent(this,HasilActivity::class.java)
            intent.putExtra("nama",edtNama.text.toString())
            startActivity(intent)
        }
    }

}