package id.ac.ukdw.pertemuan9_71190455

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.TypedValue
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import id.ac.ukdw.pertemuan9_71190455.helper.Constant
import id.ac.ukdw.pertemuan9_71190455.helper.PrefrencesHelper

class LoginActivity : AppCompatActivity() {

    lateinit var sharedpref: PrefrencesHelper

    private var fontsize =14f

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        sharedpref = PrefrencesHelper(this)

        val textUsername = sharedpref.getString(Constant.PREF_USERNAME)
        val username = findViewById<TextView>(R.id.username)
        val btnLogin = findViewById<Button>(R.id.btnOut)
        username.setText(textUsername)
        btnLogin.setOnClickListener {
            sharedpref.clear()
            Toast.makeText(applicationContext,"berhasil logout", Toast.LENGTH_SHORT).show()
            moveIntent()
        }
        val dwn = findViewById<Button>(R.id.btnDwn)
        val up = findViewById<Button>(R.id.btnUp)
        val txt = findViewById<TextView>(R.id.textView2)

        dwn.setOnClickListener {
            fontsize -=4f
            txt.setTextSize(TypedValue.COMPLEX_UNIT_SP,fontsize)
        }
        up.setOnClickListener {
            fontsize +=4f
            txt.setTextSize(TypedValue.COMPLEX_UNIT_SP,fontsize)
        }
    }
    private fun moveIntent(){
        startActivity(Intent(this,MainActivity::class.java))
        finish()
    }
}