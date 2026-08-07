package com.example.myapplication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels

class ItemDetailFragment : Fragment() {

    private val viewModel: ItemViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_item_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        
        // TODO: PLACE A BREAKPOINT HERE
        // Observe Fragment lifecycle, local variables, and call stack
        
        val nameTextView = view.findViewById<TextView>(R.id.item_name)
        val descriptionTextView = view.findViewById<TextView>(R.id.item_description)

        viewModel.selectedItem.observe(viewLifecycleOwner) { item ->
            nameTextView.text = item.name
            descriptionTextView.text = item.description
        }
    }
}
