package com.example.ozuclubs.adapter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.ozuclubs.R
import com.example.ozuclubs.data.MyList

class MyListAdapter (private val myList:ArrayList<MyList>):RecyclerView.Adapter<MyListAdapter.MyViewHolder>(){
    class MyViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        val myeventName: TextView =itemView.findViewById(R.id.my_event)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.list_mylist,parent,false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem =myList[position]
        holder.myeventName.text=currentItem.clubName



    }

    override fun getItemCount(): Int {
        return myList.size
    }
}
