package id.ac.ukdw.pertemuan10_71190455

import android.annotation.SuppressLint
import android.content.ContentValues
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.BaseColumns
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    var dbHelper:SQLiteOpenHelper? = null
    var db:SQLiteDatabase?= null
    val listPenduduk = ArrayList<String>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        dbHelper = DatabaseHelper(this)
        db = dbHelper?.writableDatabase

        val edtNama = findViewById<EditText>(R.id.edtNama)
        val edtUsia = findViewById<EditText>(R.id.edtUsia)
        val btnSimpan= findViewById<Button>(R.id.btnSimpan)
        btnSimpan.setOnClickListener {
            val values = ContentValues().apply {
                put(DatabaseContract.Penduduk.COLUMN_NAME_NAMA, edtNama.text.toString())
                put(DatabaseContract.Penduduk.COLUMN_NAME_USIA, edtUsia.text.toString())
            }
            db?.insert(DatabaseContract.Penduduk.TABLE_NAME,null,values)
            edtNama.setText("")
            edtUsia.setText("")
        }

        val rcyPenduduk = findViewById<RecyclerView>(R.id.rcyPenduduk)

        val adapter = PendudukAdapter(listPenduduk)
        rcyPenduduk.adapter= adapter
        reloadData()
    }
    @SuppressLint("Range")
    fun reloadData(){
        val columns = arrayOf(
            BaseColumns._ID,
            DatabaseContract.Penduduk.COLUMN_NAME_NAMA,
            DatabaseContract.Penduduk.COLUMN_NAME_USIA
        )
        val cursor = db?.query(
            DatabaseContract.Penduduk.TABLE_NAME,
            columns,
            null,
            null,
            null,
            null,
            null
        )

        with(cursor!!){
            while (moveToNext()){
                val nama = getString(getColumnIndex(DatabaseContract.Penduduk.COLUMN_NAME_NAMA))
                val usia = getString(getColumnIndex(DatabaseContract.Penduduk.COLUMN_NAME_USIA))
                listPenduduk.add("${nama}(${usia})")
            }
        }
    }
}