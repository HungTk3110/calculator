/*
 * *
 *  * Created by Nguyen Van Thai on 9/7/22, 4:43 PM
 *  * Copyright (c) 2022 . All rights reserved.
 *  * Last modified 9/7/22, 4:43 PM
 *
 */

package com.bangcodin.calculator.ui.fragment


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bangcodin.calculator.R
import com.bangcodin.calculator.databinding.FragmentTermConditionBinding
import java.io.*


class TermFragment : Fragment() {
    private lateinit var binding: FragmentTermConditionBinding


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTermConditionBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        readFile()
        onBackStack()
    }

    private fun readFile() {
        var string: String? = ""
        val stringBuilder = StringBuilder()
        val file: InputStream = resources.openRawResource(R.raw.term)
        val reader = BufferedReader(InputStreamReader(file))
        while (true){
            try {
                if(reader.readLine().also {
                    string = it
                    } == null)
                    break
            }catch (e: IOException){
                e.printStackTrace()
            }
            stringBuilder.append(string).append("\n")
            binding.readFile.text = stringBuilder
        }
        file.close()
    }

    private fun onBackStack(){
        binding.imageButtonBack.setOnClickListener{
            activity?.onBackPressed()
        }
    }


}
