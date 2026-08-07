package com.example.myapplication

import android.os.Bundle
import android.view.View
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AppCompatActivity
import androidx.slidingpanelayout.widget.SlidingPaneLayout

class MainActivity : AppCompatActivity() {

    private lateinit var slidingPaneLayout: SlidingPaneLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        slidingPaneLayout = findViewById(R.id.sliding_pane_layout)
        
        // Custom BackPressedCallback to close the pane
        val onBackPressedCallback = object : OnBackPressedCallback(slidingPaneLayout.isSlideable && slidingPaneLayout.isOpen) {
            override fun handleOnBackPressed() {
                slidingPaneLayout.closePane()
            }
        }
        onBackPressedDispatcher.addCallback(this, onBackPressedCallback)

        slidingPaneLayout.addPanelSlideListener(object : SlidingPaneLayout.PanelSlideListener {
            override fun onPanelSlide(panel: View, slideOffset: Float) {}
            override fun onPanelOpened(panel: View) {
                onBackPressedCallback.isEnabled = true
            }
            override fun onPanelClosed(panel: View) {
                onBackPressedCallback.isEnabled = false
            }
        })
    }

    fun openDetail() {
        slidingPaneLayout.openPane()
    }
}
