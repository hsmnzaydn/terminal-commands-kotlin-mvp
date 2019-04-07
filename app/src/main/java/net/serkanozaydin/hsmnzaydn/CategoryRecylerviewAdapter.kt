package net.serkanozaydin.hsmnzaydn

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import net.serkanozaydin.hsmnzaydn.data.entity.Category


class CategoryRecylerviewAdapter(private val myItems: List<Category>, private var myListener: net.serkanozaydin.hsmnzaydn.CategoryRecylerviewAdapter.ItemListener?) :
    RecyclerView.Adapter<net.serkanozaydin.hsmnzaydn.CategoryRecylerviewAdapter.ViewHolder>() {



    fun setListener(listener: net.serkanozaydin.hsmnzaydn.CategoryRecylerviewAdapter.ItemListener) {
        myListener = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): net.serkanozaydin.hsmnzaydn.CategoryRecylerviewAdapter.ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.row_category, parent, false)
        ) // TODO
    }

    override fun getItemCount(): Int {
        return myItems.size
    }

    override fun onBindViewHolder(holder: net.serkanozaydin.hsmnzaydn.CategoryRecylerviewAdapter.ViewHolder, position: Int) {
        holder.setData(myItems[position])
    }

    interface ItemListener {
        fun onItemClick(item: Category)
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {

        // TODO - Your view members
         var item: Category? =null

        init {
            itemView.setOnClickListener(this)

            // TODO instantiate/assign view members
        }

        fun setData(item: Category) {
            this.item = item
            itemView.findViewById<TextView>(R.id.row_category_title_text_view).text=item.title
            // TODO set data to view
        }

        override fun onClick(v: View) {
            if (myListener != null) {
                myListener!!.onItemClick(item!!)
            }
        }
    }


}
                                