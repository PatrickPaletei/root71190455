package id.ac.ukdw.pertemuan11_71190455

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.google.firebase.firestore.FirebaseFirestore
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {
    var firesotre:FirebaseFirestore? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        firesotre = FirebaseFirestore.getInstance()

        val edtId = findViewById<EditText>(R.id.edtId)
        val edtNama = findViewById<EditText>(R.id.edtNama)
        val edtUsia = findViewById<EditText>(R.id.edtUsia)
        val btnSimpan = findViewById<Button>(R.id.btnSimpan)
        val btnCari = findViewById<Button>(R.id.btnCari)
        val txtOutput = findViewById<TextView>(R.id.txtOutput)

        btnSimpan.setOnClickListener {
            val penduduk = Penduduk(edtNama.text.toString(),edtUsia.text.toString().toInt())
            edtNama.setText("")
            edtUsia.setText("")
            firesotre?.collection("penduduk")?.document(penduduk.nama)?.set(penduduk)
        }
        btnCari.setOnClickListener {
            firesotre?.collection("penduduk")?.get()!!
                .addOnSuccessListener { docs ->
                    var output = ""
//                    txtOutput.setText(doc.data.toString())
                    for(doc in docs){
                        output += "\n${doc.data}"
                    }
                    txtOutput.setText(output)
                }
        }

    }
}