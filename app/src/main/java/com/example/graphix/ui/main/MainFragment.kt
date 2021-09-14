package com.example.graphix.ui.main

import android.content.Context
import android.graphics.Color
import android.graphics.Paint
import android.opengl.Visibility
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.provider.Settings.Secure.putInt
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import androidx.core.graphics.toColor
import androidx.fragment.app.FragmentTransaction
import com.example.graphix.R

class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }
    var Fragment1:Fragment? = fragmentManager?.findFragmentById(R.id.main)
    var Fragment2:Fragment? = fragmentManager?.findFragmentById(R.id.settings)
    private lateinit var viewModel: MainViewModel
    private var button: Button? = null
    private var button1: Button? = null
    private var cortesian: KortesianView? = null
    private var viewstate: Boolean = true
    private var radio1:RadioButton? = null
    private var radio2:RadioButton? = null
    private var radio3:RadioButton? = null
    private var text1:EditText?=null
    private var text2:EditText?=null
    private var text3:EditText?=null
    private var text4:EditText?=null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.main_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        button = activity?.findViewById(R.id.settingbtn)
        cortesian = activity?.findViewById(R.id.plane)
        radio1 = activity?.findViewById(R.id.radioButton)
        radio2 = activity?.findViewById(R.id.colorradio1)
        radio3 = activity?.findViewById(R.id.tolsh)
        text1 = activity?.findViewById(R.id.xmin)
        text2 = activity?.findViewById(R.id.xmax)
        text3 = activity?.findViewById(R.id.ymin)
        text4 = activity?.findViewById(R.id.ymax)
        button?.setOnClickListener {
            if(viewstate) {
                cortesian?.visibility = View.GONE
                button?.text = "Показать"
                viewstate = !viewstate
            }
            else
            {
                if (radio1!!.isChecked)
                    cortesian?.f = 0
                else
                    cortesian?.f = 1
                if(radio2!!.isChecked)
                    cortesian?.grafcolor = cortesian?.color1!!
                else
                    cortesian?.grafcolor = cortesian?.color2!!
                if (radio3!!.isChecked)
                    cortesian?.grafcolor?.strokeWidth = 1F
                else
                    cortesian?.grafcolor?.strokeWidth = 3F
                cortesian?.xmin = text1?.text.toString().toInt()
                cortesian?.xmax = text2?.text.toString().toInt()
                cortesian?.ymin = text3?.text.toString().toInt()
                cortesian?.ymax = text4?.text.toString().toInt()
                cortesian?.visibility = View.VISIBLE
                button?.text = "Настроить"
                viewstate = !viewstate
            }
        }
        button1 = activity?.findViewById(R.id.showbtn)
        button1?.setOnClickListener {
            val ft: FragmentTransaction = fragmentManager!!.beginTransaction()
            ft.show(Fragment1!!)
            ft.hide(Fragment2!!)
        }
        // TODO: Use the ViewModel
    }
    fun OnStop()
    {
        val prefs = activity?.getSharedPreferences("com.example.graphix",Context.MODE_PRIVATE)
        prefs?.run {
            edit().run {
                putInt("xmin",text1?.text.toString().toInt())
                putInt("xmax",text2?.text.toString().toInt())
                putInt("ymin",text3?.text.toString().toInt())
                putInt("ymax",text4?.text.toString().toInt())
                if (radio1!!.isChecked)
                    putBoolean("graf",true)
                else
                    putBoolean("graf",false)
                if(radio2!!.isChecked)
                    putBoolean("color",true)
                else
                    putBoolean("color",false)
                if (radio3!!.isChecked)
                    putBoolean("tolsh",true)
                else
                    putBoolean("tolsh",false)
                apply()
            }
        }
        super.onStop()
    }

    fun OnStar()
    {
        super.onStart()
        val prefs = activity?.getSharedPreferences("com.example.graphix",Context.MODE_PRIVATE)
        prefs?.run {
            if(getBoolean("graf",true))
                cortesian?.f=0
            else
                cortesian?.f=1
            if(getBoolean("color",true))
                cortesian?.grafcolor = cortesian?.color1!!
            else
                cortesian?.grafcolor = cortesian?.color2!!
            if(getBoolean("tolsh",true))
                cortesian?.grafcolor?.strokeWidth = 1F
            else
                cortesian?.grafcolor?.strokeWidth = 3F
            cortesian?.xmin = getInt("xmin",-7)
            cortesian?.xmax = getInt("xmax",7)
            cortesian?.ymin = getInt("ymin",0)
            cortesian?.ymax = getInt("ymax",10)
        }
    }

}