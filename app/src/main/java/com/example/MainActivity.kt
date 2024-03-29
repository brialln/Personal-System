package com.example

import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import android.view.Menu
import android.view.MenuItem
import android.view.Window
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val addBtn : Button = findViewById(R.id.addBtn)
        val deleteBtn : Button = findViewById(R.id.deleteBtn)
        val submitBtn : Button = findViewById(R.id.submitBtn)

        submitBtn.setOnClickListener() {
            val message : String? = "Are you sure you want to submit?"
            showCustomDialogBox(message)
        }

        addBtn.setOnClickListener() {
            Toast.makeText(this, "Added", Toast.LENGTH_LONG).show()
        }

        deleteBtn.setOnClickListener() {
            Toast.makeText(this, "Deleted", Toast.LENGTH_LONG).show()
        }
    }

    private fun showCustomDialogBox(message: String?) {
        val dialog = Dialog(this)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setCancelable(false)
        dialog.setContentView(R.layout.layout_dialog_box)
        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        val tvMessage : TextView = dialog.findViewById(R.id.tvMessage)
        val btnConfirm : Button = dialog.findViewById(R.id.btnConfirm)
        val btnCancel : Button = dialog.findViewById(R.id.btnCancel)

        tvMessage.text = message

        btnConfirm.setOnClickListener() {
            dialog.dismiss()
            Toast.makeText(this, "Submitted", Toast.LENGTH_LONG).show()
        }

        btnCancel.setOnClickListener() {
            dialog.dismiss()
        }

        dialog.show()
    }


    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        return navController.navigateUp(appBarConfiguration)
                || super.onSupportNavigateUp()
    }
}