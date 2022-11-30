package ru.myitschool.lab23

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider

public class MainActivity: AppCompatActivity() {

    lateinit var btn: Button
    lateinit var mean_text: EditText
    lateinit var variance_text: EditText
    lateinit var res_text: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn = findViewById(R.id.get_random_num)
        mean_text = findViewById(R.id.mean_val)
        variance_text = findViewById(R.id.variance_value)
        res_text = findViewById(R.id.random_number_result)

        val modelProvider = ViewModelProvider(this)
        val anyViewModel = modelProvider[AnyViewModel::class.java]


        findViewById<Button>(R.id.get_random_num).setOnClickListener {
            try {

                anyViewModel.mean.value = mean_text.text.toString().toFloat()
                anyViewModel.variance.value = variance_text.text.toString().toFloat()
            } catch (_: Exception) {} finally {
                anyViewModel.onGetResultClick()
            }
        }

        anyViewModel.result.observe(this) {
            res_text.text = it?.toString() ?: "Неправильный ввод"
        }
    }
}
