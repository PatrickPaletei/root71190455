package id.ac.ukdw.pertemuan6_71190455

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment

class FirstFragment: Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val v = inflater.inflate(R.layout.fragment_first,container,false)
        val txtSatu = v.findViewById<TextView>(R.id.txtSatu)
        txtSatu.setOnClickListener {
            Toast.makeText(context,"ini hal 1",Toast.LENGTH_SHORT).show()
        }

        return v
    }
}