package com.example.viewmodelexample.ui.main

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.viewmodelexample.R
import com.example.viewmodelexample.databinding.MainFragmentBinding

class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private var _binding: MainFragmentBinding? = null
    private val binding get() = _binding!!

    private lateinit var viewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = MainFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        binding.resultText.text = viewModel.getResult().toString()

        binding.convertButton.setOnClickListener {
            // 입력창이 비어있지 않다면, 뷰모델의 setAmount 함수를 호출한다.
            if (binding.dollerText.text.isNotEmpty()) {
                viewModel.setAmount(binding.dollerText.text.toString())
                // setAmount로 입력된 값을 토대로, 결과값을 뷰모델에 요청한다.
                binding.resultText.text = viewModel.getResult().toString()
            } else {
                // 만약 비어있다면 No Value 라는 문구를 띄운다.
                binding.resultText.text = "No Value"
            }
        }
    }

}