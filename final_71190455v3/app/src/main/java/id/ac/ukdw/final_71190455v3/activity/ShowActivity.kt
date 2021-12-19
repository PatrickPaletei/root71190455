package id.ac.ukdw.final_71190455v3.activity

import android.graphics.Insets.add
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
//import android.widget.SearchView
import androidx.appcompat.widget.SearchView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.firestore.*
import com.google.firebase.firestore.EventListener
import id.ac.ukdw.final_71190455v3.R
import id.ac.ukdw.final_71190455v3.R.id.recyclerView
import java.util.*
import kotlin.collections.ArrayList

class ShowActivity : AppCompatActivity(),MyAdapter.OnItemClickListener {
    private lateinit var recyclerView: RecyclerView
    private lateinit var userArrayList: ArrayList<User>
    private lateinit var tempArrayList : ArrayList<User>
    private lateinit var newArrayList : ArrayList<User>
    private lateinit var myAdapter: MyAdapter
    private lateinit var db: FirebaseFirestore

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show)
        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)

        userArrayList = arrayListOf()
        tempArrayList = arrayListOf<User>()

        myAdapter= MyAdapter(userArrayList,this)

        recyclerView.adapter = myAdapter

        EventChangeListener()


    }



    override fun onItemClick(position: Int) {
        Toast.makeText(this, "Item $position clicked", Toast.LENGTH_SHORT).show()
//        var dialog = CustomDialogFragment()
//        dialog.show(supportFragmentManager,"custom dialog")

    }

    private fun EventChangeListener() {
         db = FirebaseFirestore.getInstance()
        db.collection("buku").orderBy("Judul",Query.Direction.ASCENDING).addSnapshotListener(object :EventListener<QuerySnapshot>{
            override fun onEvent(value: QuerySnapshot?, error: FirebaseFirestoreException?) {
                 if (error != null){
                     Log.e("FireStore Error",error.message.toString())
                     return
                 }
                for(dc:DocumentChange in value?.documentChanges!!){
                    if (dc.type == DocumentChange.Type.ADDED){
                        userArrayList.add(dc.document.toObject(User::class.java))
//                        //new
//                        tempArrayList.add(dc.document.toObject(User::class.java))
                    }
                }
                myAdapter.notifyDataSetChanged()
            }

        })
    }
}


