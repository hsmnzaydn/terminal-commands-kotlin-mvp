package net.serkanozaydin.hsmnzaydn.ui.adapters

import android.content.Context
import android.content.Context.LAYOUT_INFLATER_SERVICE
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.CompoundButton
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import net.serkanozaydin.hsmnzaydn.R
import net.serkanozaydin.hsmnzaydn.data.entity.Category
import net.serkanozaydin.hsmnzaydn.data.entity.WritableTable
import org.jetbrains.anko.find

class WritableTitleRecylerViewAdapter( private var context: Context,private var myListener: ItemListener?) :
    RecyclerView.Adapter<WritableTitleRecylerViewAdapter.ViewHolder>() {

    lateinit var myItems:List<Category>
    lateinit var selectedItems:ArrayList<Category>

    fun setListener(listener: ItemListener) {
        myListener = listener
    }

    fun setData(myItems: List<Category>?){
        this.myItems= myItems!!
        selectedItems= ArrayList<Category>()
    }

    open fun getSelectedItems():List<Category>{
        return selectedItems
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.row_writable_category, parent, false)
        ) // TODO
    }

    override fun getItemCount(): Int {
        return myItems.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.setData(myItems.get(position))
    }

    interface ItemListener {
        fun onItemClick(item: Category,position: Int)
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {

        // TODO - Your view members
        var item: Category? =null
        lateinit var titleTextView:TextView
        lateinit var checkBox: CheckBox
        init {
            itemView.setOnClickListener(this)
            titleTextView=itemView.findViewById(R.id.row_writable_category_title_textview)
            checkBox=itemView.find(R.id.row_writable_category_check_box)

            // TODO instantiate/assign view members
        }

        fun setData(item: Category) {
            this.item = item
            titleTextView.text=item.title

            checkBox.setOnCheckedChangeListener(object : CompoundButton.OnCheckedChangeListener{
                override fun onCheckedChanged(buttonView: CompoundButton?, isChecked: Boolean) {
                    if (isChecked){
                        selectedItems.add(item)
                    }else{
                        selectedItems.remove(item)
                    }
                }

            })

        }

        override fun onClick(v: View) {
            if (myListener != null) {
                myListener!!.onItemClick(myItems[adapterPosition],adapterPosition)
            }
        }
    }


}
