package com.example.bottomscrollview

import android.graphics.Color
import android.graphics.drawable.PaintDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.*
import android.widget.FrameLayout
import android.widget.LinearLayout
import android.widget.ScrollView
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var scrollView: ScrollView
    private lateinit var linearLayout: LinearLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        scrollView = findViewById(R.id.scroll_view)
        linearLayout = findViewById(R.id.linear_layout)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.action_add_item) {
            addItem()
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    private fun addItem() {
        layoutInflater.inflate(R.layout.item_text_view, linearLayout, false).also { child ->

            child.findViewById<TextView>(R.id.text_view)?.run {
                text = "Sample text view ${linearLayout.childCount + 1}"
                if (linearLayout.childCount % 2 == 0) {
                    background = PaintDrawable(Color.WHITE)
                    gravity = Gravity.END
                } else {
                    background = PaintDrawable(Color.LTGRAY)
                    gravity = Gravity.START
                }

            }
            linearLayout.addView(child)
            scrollView.post {
                scrollView.fullScroll(View.FOCUS_DOWN)
            }
        }
    }
}