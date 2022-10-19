package com.ismin.android

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts

class CreateBookActivity : AppCompatActivity() {
    lateinit var txtTitle: EditText
    lateinit var txtAuthor: EditText
    lateinit var txtPubDate: EditText
    lateinit var book: Book
    val CREATED_BOOK = "extra-book"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_book)

        val btnCreateBook = findViewById<Button>(R.id.a_create_book_btn_save)
        btnCreateBook.setOnClickListener(this::addBookAction)

        txtTitle = findViewById<EditText>(R.id.a_create_book_txt_title)
        txtAuthor = findViewById<EditText>(R.id.a_create_book_txt_auth_name)
        txtPubDate = findViewById<EditText>(R.id.a_create_book_txt_pub_date)
    }

    fun addBookAction(view: View?){
        val returnIntent = Intent()
        book = Book(txtTitle.text.toString(), txtAuthor.text.toString(), txtPubDate.text.toString())
        returnIntent.putExtra(CREATED_BOOK, book)
        setResult(Activity.RESULT_OK, returnIntent)
        finish()
    }
}