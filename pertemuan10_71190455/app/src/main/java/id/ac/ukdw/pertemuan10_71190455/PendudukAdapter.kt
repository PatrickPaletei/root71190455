package id.ac.ukdw.pertemuan10_71190455

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import java.util.ArrayList

class PendudukAdapter(var listPenduduk:ArrayList<String>):RecyclerView.Adapter<PendudukAdapter.PendudukHolder>() {
    class PendudukHolder(val v: View):RecyclerView.ViewHolder(v){
        fun bindView(data: String){
            val txtInfo = v.findViewById<TextView>(R.id.txtInfo)
            txtInfo.setText(data)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PendudukHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_penduduk,parent,false)
        return PendudukHolder(view)
    }

    override fun onBindViewHolder(holder: PendudukHolder, position: Int) {
        holder.bindView(listPenduduk.get(position))
    }

    override fun getItemCount(): Int = listPenduduk.size
}