package id.ac.ukdw.final_71190455v3.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import id.ac.ukdw.final_71190455v3.R

class HomeActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        auth = FirebaseAuth.getInstance()
        var btn_logout = findViewById<Button>(R.id.btnLogOut)
        var btn_insert = findViewById<Button>(R.id.save_btn)
        var read_data = findViewById<Button>(R.id.btnLihatData)
        var judul = findViewById<TextView>(R.id.edtJudul)
        var penerbit = findViewById<TextView>(R.id.edtPenerbit)
        var id= findViewById<TextView>(R.id.edtId)
        btn_logout.setOnClickListener {
            auth.signOut()
            Intent(this@HomeActivity, LoginActivity::class.java).also {
                it.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                startActivity(it)
            }
        }

        btn_insert.setOnClickListener {
            val judul = judul.text.toString()
            val penerbit = penerbit.text.toString()
            val id = id.text.toString()
            saveFirestore(judul,penerbit,id)
        }
        read_data.setOnClickListener {
            val intent = Intent(this,ShowActivity::class.java)
            startActivity(intent)
        }

    }

    private fun saveFirestore(judul: String, penerbit: String, id: String) {
        val db = FirebaseFirestore.getInstance()
        val user:MutableMap<String,Any> = HashMap()
        user["Judul"] = judul
        user["penerbit"] = penerbit
        user["id"] = id

        db.collection("buku")
            .add(user).addOnSuccessListener {
                Toast.makeText(this,"Record Added !",Toast.LENGTH_SHORT).show()
            }.addOnFailureListener {
                Toast.makeText(this,"Fail To add data!",Toast.LENGTH_SHORT).show()
            }
    }

//    private fun readFirestore(){
//        var txt = findViewById<TextView>(R.id.txtResult)
//        val db = FirebaseFirestore.getInstance()
//        db.collection("buku").get().addOnCompleteListener{
//            val result:StringBuffer= StringBuffer()
//            if(it.isSuccessful){
//                for (document in it.result!!){
//                    result.append(document.data.getValue("Judul")).append(" ").append(document.data.getValue("id")).append(" ")
//                        .append(document.data.getValue("penerbit")).append("\n\n")
//                }
//                txt.setText(result)
//            }
//        }
//    }


}


