package org.hyperskill.calculator.tip

import android.opengl.Visibility
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.core.widget.addTextChangedListener
import androidx.core.widget.doAfterTextChanged
import androidx.core.widget.doOnTextChanged
import com.google.android.material.slider.Slider
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val ed: EditText = findViewById(R.id.edit_text)
        ed.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {

            }

            override fun afterTextChanged(s: Editable) {
                val text: TextView = findViewById(R.id.text_view)
                if (ed.text.isEmpty() || ed.text.isBlank()) {
                    text.visibility = View.GONE
                } else {
                    text.visibility = View.VISIBLE
                    val tip: Double = ed.text.toString().toDouble() * slider.value / 100
                    text.text = "Tip amount: ${String.format("%.2f", tip)}"
                }
            }
        })

        val slider: Slider = findViewById(R.id.slider)
        slider.addOnChangeListener { slider, value, fromUser ->
            val text: TextView = findViewById(R.id.text_view)
            if (ed.text.isEmpty() || ed.text.isBlank()) {
                text.visibility = View.GONE
            } else {
                text.visibility = View.VISIBLE
                val tip: Double = ed.text.toString().toDouble() * slider.value / 100
                text.text = "Tip amount: ${String.format("%.2f", tip)}"
            }
        }
    }

}