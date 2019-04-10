package net.serkanozaydin.hsmnzaydn.ui.adapters

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import net.serkanozaydin.hsmnzaydn.R
import net.serkanozaydin.hsmnzaydn.data.entity.Category


class CategoryRecylerviewAdapter( private var myListener: ItemListener?) :
    RecyclerView.Adapter<CategoryRecylerviewAdapter.ViewHolder>() {

    lateinit var myItems:List<Category>

    fun setListener(listener: ItemListener) {
        myListener = listener
    }

    fun setData(myItems: List<Category>?){
        this.myItems= myItems!!
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.row_category, parent, false)
        ) // TODO
    }

    override fun getItemCount(): Int {
        return myItems.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
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
                                