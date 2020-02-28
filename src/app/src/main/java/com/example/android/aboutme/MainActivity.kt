package com.example.android.aboutme

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View.GONE
import android.view.View.VISIBLE
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import com.example.android.aboutme.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.view.*

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private var myName: MyName = MyName("Mattias Bäck")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.myName = myName

        binding.saveNicknameButton.setOnClickListener {
            saveNickname()
        }
    }

    private fun saveNickname()
    {
        val nicknameEdit: EditText = binding.nicknameEdit
        val nickname: TextView = binding.nicknameText
        val saveButton = binding.saveNicknameButton

        myName?.nickname = nicknameEdit.text.toString()
        binding.invalidateAll()
        saveButton.visibility = GONE
        nicknameEdit.visibility = GONE
        nickname.visibility = VISIBLE

        // Hide the keyboard.
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(saveButton.windowToken, 0)
    }
}
