package com.demo

import android.content.ComponentName
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.demo.databinding.ActivityMainBinding
import com.demo.databinding.TestChangeIconBinding
import kotlinx.coroutines.*
import java.util.logging.Logger
import kotlin.system.measureTimeMillis

class MainActivity : AppCompatActivity() {
    private lateinit var binding: TestChangeIconBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = TestChangeIconBinding.inflate(layoutInflater)
        setContentView(binding.root)
        /*binding.btnReset.setOnClickListener {
            changeIconApp()
        }*/
        getEvent()
        runBlocking {
            //autoRun()
        }
    }

    @OptIn(DelicateCoroutinesApi::class)
    private fun getEvent() {
        binding.apply {
            btnNew.setOnClickListener {
                changeIconAppNew()
            }
            btnOld.setOnClickListener {
                changeIconAppOld()
            }
        }
    }

    private fun changeIconAppNew() {
        //icon old
        val packageManager: PackageManager = packageManager
        packageManager.setComponentEnabledSetting(
            ComponentName(this@MainActivity,"com.demo.MainActivity"),
            PackageManager.COMPONENT_ENABLED_STATE_DISABLED,
            PackageManager.DONT_KILL_APP)
        //icon new
        packageManager.setComponentEnabledSetting(ComponentName(this@MainActivity,"com.demo.MainActivityAlias"),
            PackageManager.COMPONENT_ENABLED_STATE_ENABLED,
            PackageManager.DONT_KILL_APP)
    }
    private fun changeIconAppOld() {
        //icon new
        val packageManager: PackageManager? = packageManager
        packageManager?.setComponentEnabledSetting(
            ComponentName(this@MainActivity,"com.demo.MainActivity"),
            PackageManager.COMPONENT_ENABLED_STATE_ENABLED,
            PackageManager.DONT_KILL_APP)
        //icon old
        packageManager?.setComponentEnabledSetting(ComponentName(this@MainActivity,"com.demo.MainActivityAlias"),
            PackageManager.COMPONENT_ENABLED_STATE_DISABLED,
            PackageManager.DONT_KILL_APP)
    }
   /* private fun getEvent(){
        var count = 0
        binding.apply {
            btnNext.setOnClickListener {
                count++
                tvCount.text = "$count"
            }
            btnBack.setOnClickListener {
                count--;
                if(count < 0){
                    count = 0
                    tvCount.text = "0"
                }
                else
                    tvCount.text = "$count"
            }
            btnReset.setOnClickListener {
                //requestData(count)
                count = 0
                runBlocking {
                    launch {
                        requestDataCor(count)
                    }
                }
            }
        }
    }
    private fun requestData(count: Int){
        Log.e("TAG", "requestData on ${Thread.currentThread().name}")
        Thread.sleep(2000L)
        binding.pbLoad.visibility = View.GONE
        binding.tvCount.text = "---"
    }
    private suspend fun requestDataCor(count: Int){
        Log.e("TAG", "requestData on ${Thread.currentThread().name}")
        GlobalScope.launch (Dispatchers.Main){
            delay(2000L)
            binding.pbLoad.visibility = View.GONE
            binding.tvCount.text = "0"
        }
        *//*runBlocking {
            //delay(2000L)
            binding.pbLoad.visibility = View.GONE
            binding.tvCount.text = "0"
        }*//*
    }
    private suspend fun autoRun(){
        var num = 0
        var status = true
        val time = measureTimeMillis {
            GlobalScope.launch{
            repeat(9){
                delay(1000)
                ++num
                withContext(Dispatchers.Main){
                    binding.tvCount.text = num.toString()
                }
                if(num == 9)
                    status = false
            }
            if(!status){
                //--num
                autoRun()
            }
            //binding.tvCount.text = "Done!"
            }
        }
        Log.e("TAG", "autoRun time: $time")
    }*/
}