package id.ac.ukdw.pertemuan7_71190455

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class ContactAdapter(var listContact: ArrayList<Contact>, var context : Context): RecyclerView.Adapter<ContactAdapter.ContactHolder>() {
    class ContactHolder(val view: View): RecyclerView.ViewHolder(view){
        fun bind(contact: Contact, context : Context){
            view.findViewById<ImageView>(R.id.cntCover).setImageResource(contact.cover)
            view.findViewById<TextView>(R.id.txtTitle).setText(contact.title)
            view.findViewById<TextView>(R.id.txtSinger).setText(contact.noTelp)
            view.setOnClickListener {
                Toast.makeText(context,"${contact.title}: ${contact.title}",Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_contact, parent , false)
        return ContactHolder(v)
    }

    override fun onBindViewHolder(holder: ContactHolder, position: Int) {
        holder.bind(listContact[position],context)
    }

    override fun getItemCount(): Int {
        return listContact.size
    }
}