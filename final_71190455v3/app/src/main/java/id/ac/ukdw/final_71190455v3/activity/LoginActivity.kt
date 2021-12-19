package id.ac.ukdw.final_71190455v3.activity


import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import id.ac.ukdw.final_71190455v3.R


class LoginActivity : AppCompatActivity() {

    private lateinit var auth:FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        auth = FirebaseAuth.getInstance()
        var btn_login = findViewById<Button>(R.id.btnLogin)
        var btn_reg = findViewById<Button>(R.id.btnRegister)
        val email = findViewById<TextView>(R.id.etEmail)
        val pass = findViewById<TextView>(R.id.etPassword)

        btn_login.setOnClickListener {
            val email = email.text.toString().trim()
            val pass = pass.text.toString().trim()

            if (email.isEmpty()){
                Toast.makeText(this,"EMAIL HARUS DIISI!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
                Toast.makeText(this,"EMAIL TIDAK VALID!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            if (pass.isEmpty() || pass.length <6){
                Toast.makeText(this,"password harus lebih dari 6 karakter", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            loginUser(email,pass)
        }


        btn_reg.setOnClickListener {
            Intent(this@LoginActivity, RegisterActivity::class.java).also {
                startActivity(it)
            }
        }
    }

    private fun loginUser(email: String, pass: String) {
        auth.signInWithEmailAndPassword(email,pass).addOnCompleteListener(this){
            if (it.isSuccessful){
                Intent(this@LoginActivity, HomeActivity::class.java).also {
                    it.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                    startActivity(it)
                }
            }else{
                Toast.makeText(this,it.exception?.message,Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onStart() {
        super.onStart()
        if (auth.currentUser != null){
            Intent(this@LoginActivity, HomeActivity::class.java).also {
                it.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                startActivity(it)
            }
        }
    }
}