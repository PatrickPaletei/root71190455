package id.ac.ukdw.final_71190455v3.activity

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView
import id.ac.ukdw.final_71190455v3.R

class MyAdapter(private val userList:ArrayList<User>,private val listener:OnItemClickListener):RecyclerView.Adapter<MyAdapter.MyViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyAdapter.MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.list_item,parent,false)
        return MyViewHolder(itemView)

    }

    override fun onBindViewHolder(holder: MyAdapter.MyViewHolder, position: Int) {
        val user: User = userList[position]
        holder.judul.text = user.Judul
        holder.penerbit.text = user.penerbit
        holder.id.text = user.id
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    inner class MyViewHolder(itemView: View):RecyclerView.ViewHolder(itemView),View.OnClickListener{
        val judul :TextView = itemView.findViewById(R.id.tvJudul)
        val penerbit :TextView = itemView.findViewById(R.id.tvPenerbit)
        val id :TextView = itemView.findViewById(R.id.tvid)

        init {
            itemView.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            val position = adapterPosition
            if (position != RecyclerView.NO_POSITION) {
                listener.onItemClick(position)
            }
        }
    }
    interface OnItemClickListener{
        fun onItemClick(position: Int)
    }
}