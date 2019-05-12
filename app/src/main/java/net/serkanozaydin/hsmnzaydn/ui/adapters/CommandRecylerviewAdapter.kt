package net.serkanozaydin.hsmnzaydn.ui.adapters

import android.media.Image
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import net.serkanozaydin.hsmnzaydn.R
import net.serkanozaydin.hsmnzaydn.data.entity.Category
import net.serkanozaydin.hsmnzaydn.data.entity.Command


class CommandRecylerviewAdapter(private var myListener: ItemListener?, var isEdit: Boolean) :
    RecyclerView.Adapter<CommandRecylerviewAdapter.ViewHolder>() {

    var myItems: List<Command>? = ArrayList<Command>()

    fun setListener(listener: ItemListener) {
        myListener = listener
    }

    fun setData(myItems: List<Command>?) {
        if (myItems != null) {
            this.myItems = myItems
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.row_command, parent, false)
        ) // TODO
    }

    override fun getItemCount(): Int {
        return myItems!!.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.setData(myItems?.get(position))
    }

    interface ItemListener {
        fun onEditClick(item: Command)
        fun onItemClick(item: Command)
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {

        // TODO - Your view members
        var item: Command? = null

        init {
            itemView.setOnClickListener(this)

            // TODO instantiate/assign view members
        }

        fun setData(item: Command?) {
            this.item = item

            itemView.findViewById<AppCompatTextView>(R.id.row_command_command_title_text_view).text = item!!.title
            itemView.findViewById<AppCompatTextView>(R.id.row_command_description_text_view).text = item!!.description
            if (isEdit) {
                var editImage: ImageView = itemView.findViewById<ImageView>(R.id.row_command_edit_image_view)
                editImage.visibility = View.VISIBLE
                editImage.setOnClickListener {
                    myListener!!.onEditClick(item)
                }
            }

            // TODO set data to view
        }

        override fun onClick(v: View) {
            if (myListener != null) {
                myListener!!.onItemClick(item!!)
            }
        }
    }


}
