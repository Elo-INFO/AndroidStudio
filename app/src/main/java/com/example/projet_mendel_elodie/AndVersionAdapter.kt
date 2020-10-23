package com.example.projet_mendel_elodie


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.item_and_version.*
import org.jetbrains.anko.alert
import org.jetbrains.anko.browse

class AndVersionAdapter(private val items: Array<AndVersion>) : RecyclerView.Adapter<AndVersionAdapter.ViewHolder>() {
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view), LayoutContainer {
        override val containerView: View?
            get() = itemView
        
        fun bindAndVersion(andVersion: AndVersion) {
            with(andVersion) {
                andVersionTxt.text = name
                andVersionImg.setImageResource(img)
                andVersionImg.setOnClickListener {
                    itemView.context.alert(this.details) {
                        title = "Details"
                        positiveButton("Aller sur Wikipedia") { itemView.context.browse("https://www.chillcoding.com/")}
                        negativeButton("OK" ) { }
                    }.show()
                }
            }
        }
    }

    private fun ViewGroup.inflate(@LayoutRes layoutRes: Int, attachToRoot: Boolean = false): View {
        return LayoutInflater.from(context).inflate(layoutRes, this, attachToRoot)
    }

    override fun getItemCount(): Int = items.size
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(parent.inflate(R.layout.item_and_version))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindAndVersion(items[position])
    }
}