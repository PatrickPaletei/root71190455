package id.ac.ukdw.pertemuan9_71190455


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import id.ac.ukdw.pertemuan9_71190455.helper.Constant
import id.ac.ukdw.pertemuan9_71190455.helper.PrefrencesHelper


class MainActivity : AppCompatActivity() {

    lateinit var sharedpref: PrefrencesHelper


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        sharedpref = PrefrencesHelper(this)

        val btnLogin = findViewById<Button>(R.id.btnLogin)
        val username = findViewById<EditText>(R.id.editUsername)
        val pass = findViewById<EditText>(R.id.editPassword)
        btnLogin.setOnClickListener {
            if (username.text.isNotEmpty() && pass.text.isNotEmpty()){
                saveSession(username.text.toString(),pass.text.toString())
                Toast.makeText(applicationContext,"berhasil masuk",Toast.LENGTH_SHORT).show()
                moveIntent()
            }
        }



    }

    override fun onStart() {
        super.onStart()
        if (sharedpref.getBoolean(Constant.PREF_IS_LOGIN)){
            moveIntent()
        }
    }

    private fun moveIntent(){
        startActivity(Intent(this,LoginActivity::class.java))
        finish()
    }
    private fun saveSession(username:String,password:String){
        sharedpref.put(Constant.PREF_USERNAME,username)
        sharedpref.put(Constant.PREF_PASSWORD,password)
        sharedpref.put(Constant.PREF_IS_LOGIN,true)

    }
}