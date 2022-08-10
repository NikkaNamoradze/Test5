package com.example.test5.ui

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.app.DatePickerDialog
import android.os.Bundle
import android.util.Log.d
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.RadioButton
import android.widget.Toast
import androidx.appcompat.widget.AppCompatButton
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.test5.R
import com.example.test5.adapter.RegisterAdapter
import com.example.test5.databinding.ActivityMainBinding.bind
import com.example.test5.databinding.ActivityMainBinding.inflate
import com.example.test5.databinding.FragmentBlankBinding
import com.example.test5.model.ListItems
import com.example.test5.model.Person
import kotlinx.coroutines.launch
import java.lang.NumberFormatException
import java.text.SimpleDateFormat
import java.util.*

class BlankFragment : Fragment() {

    private var _binding: FragmentBlankBinding? = null
    private val binding get() = _binding!!

    private lateinit var mapOfInputValue: MutableMap<Int, Person>
    private val listItems: List<ListItems> = listOf()

    private val viewModel: RegisterViewModel by viewModels()

    private val adapter: RegisterAdapter by lazy {
        RegisterAdapter()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentBlankBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        setUpRecycler()
        setUpDatePicker()
        listeners()
        viewModel.parser()
        parsedData()
    }

//    private fun setUpRecycler() {
//        binding.registerRecycler.layoutManager = LinearLayoutManager(context)
//        binding.registerRecycler.adapter = adapter
//        adapter.setData(listOfItems)
//    }

    private fun listeners() {

        binding.btnRegister.setOnClickListener {

            val username = binding.etUserName.text.toString()
            val email = binding.etEmail.text.toString()
            val phone = binding.etPhone.text.toString()
            val fullName = binding.etFullName.text.toString()

            val person = Person(username, email, phone.toInt(), fullName)

            viewLifecycleOwner.lifecycleScope.launch {
                viewModel.check(person)
                viewModel.isValid.collect{
                    when {
                        it -> {
                            mapOfInputValue[mapOfInputValue.size + 1] = person
                        }
                        else -> {
                            Toast.makeText(context, "error", Toast.LENGTH_SHORT).show()
                        }
                    }
                }
            }

        }

        binding.TvGender.setOnClickListener {
            buildDialog()
        }
    }

    private fun parsedData(){
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED){
                viewModel.parsedData.collect{
                    adapter.setData(listItems)
                }
            }
        }
    }

    private fun setUpDatePicker() {

        val calendar = Calendar.getInstance()
        val datePicker = DatePickerDialog.OnDateSetListener { view, year, month, dayOfMonth ->
            calendar.set(Calendar.YEAR, year)
            calendar.set(Calendar.MONTH, month)
            calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth)
            updateTextView(calendar)
        }

        binding.tvBirthday.setOnClickListener {
            context?.let { it1 ->
                DatePickerDialog(
                    it1,
                    datePicker,
                    calendar.get(Calendar.YEAR),
                    calendar.get(Calendar.MONTH),
                    calendar.get(Calendar.DAY_OF_MONTH),
                ).show()
            }
        }

    }


    private fun updateTextView(calendar: Calendar) {
        val format = "dd-mm-yyyy"
        val simpleFormat = SimpleDateFormat(format, Locale.UK)
        binding.tvBirthday.text = simpleFormat.format(calendar.time)
    }

    @SuppressLint("SetTextI18n")
    private fun buildDialog() {
        val dialog = LayoutInflater.from(context).inflate(R.layout.dialog_layout, null)
        val dialogBuilder = AlertDialog.Builder(context)
            .setView(dialog)
        val alertDialog = dialogBuilder.show()

        val maleGender = dialog.findViewById<RadioButton>(R.id.rbMale)
        val femaleGender = dialog.findViewById<RadioButton>(R.id.rbFemale)

        dialog.findViewById<AppCompatButton>(R.id.btnSubmit).setOnClickListener {
            if (maleGender.isChecked) {
                binding.TvGender.text = "Male"
                alertDialog.dismiss()
            } else if (femaleGender.isChecked) {
                binding.TvGender.text = "Female"
                alertDialog.dismiss()
            }
        }
    }

}
