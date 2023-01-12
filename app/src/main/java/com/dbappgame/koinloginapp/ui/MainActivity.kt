package com.dbappgame.koinloginapp.ui

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.view.inputmethod.EditorInfo
import android.widget.EditText
import android.widget.Toast
import androidx.annotation.StringRes
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.commit
import androidx.lifecycle.Observer
import com.dbappgame.koinloginapp.BuildConfig
import com.dbappgame.koinloginapp.R
import com.dbappgame.koinloginapp.databinding.ActivityMainBinding
import com.dbappgame.koinloginapp.ui.login.LoggedInUserView
import com.dbappgame.koinloginapp.ui.login.LoginFragment
import com.dbappgame.koinloginapp.ui.login.LoginViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


    }

}

