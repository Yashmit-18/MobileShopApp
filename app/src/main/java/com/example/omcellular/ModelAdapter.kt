package com.example.omcellular5

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ModelAdapter(private val modelList: List<String>) : RecyclerView.Adapter<ModelAdapter.ModelViewHolder>() {

    class ModelViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val modelName: TextView = itemView.findViewById(android.R.id.text1)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ModelViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(android.R.layout.simple_list_item_1, parent, false)
        return ModelViewHolder(view)
    }

    override fun onBindViewHolder(holder: ModelViewHolder, position: Int) {
        val model = modelList[position]
        holder.modelName.text = model

        holder.itemView.setOnClickListener {
            val context = holder.itemView.context
            // When a model is clicked, open the evaluation page
            val intent = Intent(context, DeviceEvaluationActivity::class.java).apply {
                putExtra("MODEL_NAME", model)
            }
            context.startActivity(intent)
        }
    }

    override fun getItemCount() = modelList.size
}