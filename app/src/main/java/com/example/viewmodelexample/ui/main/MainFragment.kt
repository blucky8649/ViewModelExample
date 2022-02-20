package com.example.viewmodelexample.ui.main

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.viewmodelexample.R
import com.example.viewmodelexample.databinding.MainFragmentBinding
import com.example.viewmodelexample.BR.myViewModel

class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    //private var _binding: MainFragmentBinding? = null
    //private val binding get() = _binding!!
    lateinit var binding: MainFragmentBinding

    private lateinit var viewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        //_binding = MainFragmentBinding.inflate(inflater, container, false)
        binding = DataBindingUtil.inflate(inflater, R.layout.main_fragment, container, false)
        // 프래그먼트가 소멸될 때 바인딩 객체도 소멸되로록 바인딩 객체의 생명주기 소유자를 현재 프래그먼트로 선언
        binding.lifecycleOwner = this
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        binding.setVariable(myViewModel, viewModel)
        //binding.resultText.text = viewModel.getResult().toString()
        /*
        // UI 컨트롤러 내부에 옵저버를 생성한다.
        val resultObserver = Observer<Float> {
            // 현재의 결과값을 반아 resultText에 저장한다.
            result -> binding.resultText.text = result.toString()
        }
        // 아래 코드를 추가하면 resultObserver의 onChanged() 콜백 함수가 실행되어 resultText값이 바뀐다.
        viewModel.getResult().observe(viewLifecycleOwner, resultObserver)

        binding.convertButton.setOnClickListener {
            // 입력창이 비어있지 않다면, 뷰모델의 setAmount 함수를 호출한다.
            if (binding.dollerText.text.isNotEmpty()) {
                viewModel.setAmount(binding.dollerText.text.toString())
                // setAmount로 입력된 값을 토대로, 결과값을 뷰모델에 요청한다.
                // binding.resultText.text = viewModel.getResult().toString()
            } else {
                // 만약 비어있다면 No Value 라는 문구를 띄운다.
                binding.resultText.text = "No Value"
            }
        }
         */
    }

}