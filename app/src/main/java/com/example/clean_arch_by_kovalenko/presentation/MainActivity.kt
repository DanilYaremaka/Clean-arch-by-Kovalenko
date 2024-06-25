package com.example.clean_arch_by_kovalenko.presentation

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.clean_arch_by_kovalenko.R
import com.example.clean_arch_by_kovalenko.data.repository.UserRepositoryImpl
import com.example.clean_arch_by_kovalenko.domain.entity.SaveUserNameParam
import com.example.clean_arch_by_kovalenko.domain.entity.UserName
import com.example.clean_arch_by_kovalenko.domain.usecase.GetUserNameUseCase
import com.example.clean_arch_by_kovalenko.domain.usecase.SaveUserNameUseCase

class MainActivity : AppCompatActivity() {

    private val userRepository by lazy(LazyThreadSafetyMode.NONE) { UserRepositoryImpl(applicationContext) }
    private val getUserNameUseCase by lazy(LazyThreadSafetyMode.NONE) { GetUserNameUseCase(userRepository) }
    private val saveUserNameUseCase by lazy(LazyThreadSafetyMode.NONE) { SaveUserNameUseCase(userRepository) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val dataTextView = findViewById<TextView>(R.id.dataTextView)
        val dataEditView = findViewById<TextView>(R.id.dataEditText)
        val sendButton = findViewById<Button>(R.id.sendButton)
        val receiveButton = findViewById<Button>(R.id.receiveButton)

        sendButton.setOnClickListener {
            val text = dataEditView.text.toString()
            val result = saveUserNameUseCase(SaveUserNameParam(text))
            dataTextView.text = "Save result = $result"
            dataEditView.text = ""
        }

        receiveButton.setOnClickListener {
            val userName: UserName = getUserNameUseCase()
            dataTextView.text = "${userName.lastName} ${userName.firstName}"
        }
    }
}