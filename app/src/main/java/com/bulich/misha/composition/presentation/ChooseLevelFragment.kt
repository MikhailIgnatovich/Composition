package com.bulich.misha.composition.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.bulich.misha.composition.R
import com.bulich.misha.composition.databinding.FragmentChooseLevelBinding
import com.bulich.misha.composition.domain.entity.Level
import java.lang.RuntimeException


class ChooseLevelFragment : Fragment() {

    private var _binding: FragmentChooseLevelBinding? = null
    private val binding: FragmentChooseLevelBinding
        get() = _binding ?: throw RuntimeException("FragmentChooseBinding == null")


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentChooseLevelBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(binding) {
            buttonLevelTest.setOnClickListener {
                launchGameFragment(Level.TEST)
            }

            buttonLevelEasy.setOnClickListener {
                launchGameFragment(Level.EASY)
            }

            buttonLevelNormal.setOnClickListener {
                launchGameFragment(Level.NORMAL)
            }

            buttonLevelHard.setOnClickListener {
                launchGameFragment(Level.HARD)
            }
        }
    }

    private fun launchGameFragment(level: Level) {
        val args = Bundle().apply {
            putParcelable(GameFragment.KEY_LEVEL, level)
        }
        findNavController().navigate(R.id.action_chooseLevelFragment_to_gameFragment, args)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {

        const val NAME = "ChooseLevelFragment"

        fun newInstance(): ChooseLevelFragment {
            return ChooseLevelFragment()
        }
    }
}