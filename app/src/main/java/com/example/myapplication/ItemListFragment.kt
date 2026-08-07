package com.example.myapplication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.RecyclerView

class ItemListFragment : Fragment() {

    private val viewModel: ItemViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_item_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val recyclerView = view.findViewById<RecyclerView>(R.id.item_list)
        
        viewModel.items.observe(viewLifecycleOwner) { items ->
            recyclerView.adapter = ItemAdapter(items) { item ->
                // TODO: SET CONDITIONAL BREAKPOINT HERE
                // Condition: item.name == "Android"
                viewModel.selectItem(item)
                
                // Open detail pane if in single-pane mode
                (activity as? MainActivity)?.openDetail()
            }
        }
    }

    private class ItemAdapter(
        private val items: List<Item>,
        private val onItemClick: (Item) -> Unit
    ) : RecyclerView.Adapter<ItemAdapter.ViewHolder>() {

        class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
            val textView: TextView = view.findViewById(R.id.item_text)
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_row, parent, false)
            return ViewHolder(view)
        }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            val item = items[position]
            holder.textView.text = item.name
            holder.itemView.setOnClickListener { onItemClick(item) }
        }

        override fun getItemCount() = items.size
    }
}
