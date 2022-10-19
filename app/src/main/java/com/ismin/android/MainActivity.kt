package com.ismin.android

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    lateinit var txtResult: TextView
    val EXTRA_BOOK= "extra-book"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnCreateBook = findViewById<Button>(R.id.a_main_btn_create_book)
        btnCreateBook.setOnClickListener(this::createBookAction)

        txtResult = findViewById<TextView>(R.id.a_main_txtV_returned_txt)
    }

    private val startForResult = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
            result: ActivityResult ->
        if (result.resultCode == Activity.RESULT_OK) {
            val book = result.data?.getSerializableExtra(EXTRA_BOOK) as? Book
            txtResult.text = "title: ${book?.title} \nauthor : ${book?.author} \ndate: ${book?.date}"
        }
    }

    fun createBookAction(view: View?){
        val intent = Intent(this, CreateBookActivity::class.java)
        startForResult.launch(intent)
    }
}