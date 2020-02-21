package com.example.company.myapplication

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener  {

    val toChooseList: List<String> = listOf("","X","0")
    val duration = Toast.LENGTH_SHORT
    val spi: Spinner? = null
    val arraySpinner: MutableList<MutableList<Spinner?>> = MutableList(3) { MutableList(3, {spi})}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        arraySpinner[0][0] = spinner11
        arraySpinner[0][1] = spinner12
        arraySpinner[0][2] = spinner13
        arraySpinner[1][0] = spinner21
        arraySpinner[1][1] = spinner22
        arraySpinner[1][2] = spinner23
        arraySpinner[2][0] = spinner31
        arraySpinner[2][1] = spinner32
        arraySpinner[2][2] = spinner33

        for (row in arraySpinner){
            for (cell in row) {
                setSettingsSpinner(cell!!)
            }
        }
    }

    private fun setSettingsSpinner (sp: Spinner) {
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, toChooseList)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        sp.adapter = adapter
        sp.onItemSelectedListener = this
    }

    override fun onNothingSelected(p0: AdapterView<*>?) {

    }

    override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {

        val toast = Toast.makeText(applicationContext,"${toChooseList[p2]}", duration)
        toast.show()
    }

    private fun checkMatrix (m:MutableList<MutableList<Spinner?>>) {



    }

    private fun checkWin (m:MutableList<MutableList<Spinner?>>, str:String):Boolean {
        var dot: String = str
        for (i in 0 until 3) {
            if (((m[i][0]!!.selectedItem.toString()==dot) && (m[i][1]!!.selectedItem.toString()==dot) && (m[i][2]!!.selectedItem.toString()==dot))
                || ((m[0][i]!!.selectedItem.toString()==dot)&&(m[1][i]!!.selectedItem.toString()==dot)&&(m[2][i]!!.selectedItem.toString()==dot))) {
                return true
            }
            if (((m[0][0]!!.selectedItem.toString()==dot) && (m[1][1]!!.selectedItem.toString()==dot) && (m[2][2]!!.selectedItem.toString()==dot))
                    || ((m[2][0]!!.selectedItem.toString()==dot)&&(m[1][1]!!.selectedItem.toString()==dot)&&(m[0][2]!!.selectedItem.toString()==dot))) {
                return true
            }
        }
         return false
    }

//    private fun checkWin ():Boolean {
//        for (int i = 0; i < 3; i++)
//        if ((table[i][0] == dot && table[i][1] == dot &&
//                        table[i][2] == dot) ||
//                (table[0][i] == dot && table[1][i] == dot &&
//                        table[2][i] == dot))
//            return true;
//        if ((table[0][0] == dot && table[1][1] == dot &&
//                        table[2][2] == dot) ||
//                (table[2][0] == dot && table[1][1] == dot &&
//                        table[0][2] == dot))
//            return true;
//        return false;
//    }
}
