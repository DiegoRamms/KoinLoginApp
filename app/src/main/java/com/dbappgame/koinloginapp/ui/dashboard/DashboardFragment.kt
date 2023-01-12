package com.dbappgame.koinloginapp.ui.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.dbappgame.koinloginapp.databinding.FragmentDashboardBinding
import com.dbappgame.koinloginapp.ui.login.LoggedInUserView

class DashboardFragment : Fragment() {


    private var _binding: FragmentDashboardBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDashboardBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val user: LoggedInUserView? = requireArguments().getParcelable("KEY_USER")

        user.let {
            binding.name.text = "Welcome Koin login app ${it?.displayName}"
            binding.token.text = it?.jwt ?: "No token"
        }

    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}