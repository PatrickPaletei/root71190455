package id.ac.ukdw.pertemuan7_71190455

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val listContact = arrayListOf<Contact>()
        listContact.add(Contact("085156892075","patrick",R.mipmap.ncs))
        listContact.add(Contact("085156892075","patrick",R.mipmap.ncs1))
        listContact.add(Contact("085156892075","patrick",R.mipmap.ncs))

        val rcyContact = findViewById<RecyclerView>(R.id.rcyCont)
        rcyContact.layoutManager = LinearLayoutManager(this)
        val adapter = ContactAdapter(listContact,this)
        rcyContact.adapter = adapter
    }
}