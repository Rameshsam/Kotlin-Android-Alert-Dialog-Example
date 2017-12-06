package com.kotlinalertdialogexample

import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import android.widget.Toast
import org.jetbrains.anko.alert
import org.jetbrains.anko.toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnSimpleAlert = findViewById<Button>(R.id.simpleAlert)
        val btnTwo = findViewById<Button>(R.id.alertTwoButton)
        val btnThree = findViewById<Button>(R.id.alertThreeButton)
        val btnAnkoSimpleAlert = findViewById<Button>(R.id.ankoSimpleAlert)
        val btnAnkoTwo = findViewById<Button>(R.id.ankoAlertTwoButton)
        val btnAnkoThree = findViewById<Button>(R.id.ankoAlertThreeButton)

        btnSimpleAlert.setOnClickListener {
            showSimpleAlert()
        }

        btnTwo.setOnClickListener {
            showAlertWithTwoButton()
        }

        btnThree.setOnClickListener {
            showAlertWithThreeButton()
        }

        //Anko Example Button here
        btnAnkoSimpleAlert.setOnClickListener {
            ankoShowSimpleAlert()
        }

        btnAnkoTwo.setOnClickListener {
            ankoShowAlertWithTwoButton()
        }

        btnAnkoThree.setOnClickListener {
            ankoShowAlertWithThreeButton()
        }
    }

    //Anko Library Example code here
    private fun ankoShowAlertWithThreeButton() {
        alert("Show Alert with three Button", "Alert") {
            positiveButton("POSITIVE") {
                toast("You clicked on POSITIVE Button")
            }
            negativeButton("NEGATIVE") {
                toast("You clicked on NEGATIVE Button")
            }
            neutralPressed("NEUTRAL") {
                toast("You clicked on NEUTRAL Button")
            }
        }.show()
    }

    private fun ankoShowAlertWithTwoButton() {
        alert("how Alert with two Button", "Alert") {
            positiveButton("YES") {
                toast("You clicked on YES")
            }
            negativeButton("NO") {
                toast("You clicked on NO")
            }
        }.show()
    }

    private fun ankoShowSimpleAlert() {
        alert("Show simple Alert", "Alert") {
            positiveButton("OK") {
                toast("You clicked on OK")
            }
        }.show()
    }

    //General code here
    private fun showAlertWithThreeButton() {
        val alertDilog = AlertDialog.Builder(this@MainActivity).create()
        alertDilog.setTitle("Alert")
        alertDilog.setMessage("Show Alert with three Button")

        alertDilog.setButton(AlertDialog.BUTTON_POSITIVE, "POSITIVE", { dialogInterface, i ->
            Toast.makeText(applicationContext, "You clicked on POSITIVE Button", Toast.LENGTH_SHORT).show()
        })

        alertDilog.setButton(AlertDialog.BUTTON_NEGATIVE, "NEGATIVE", { dialogInterface, j ->
            Toast.makeText(applicationContext, "You clicked on NEGATIVE Button", Toast.LENGTH_SHORT).show()
        })
        alertDilog.setButton(AlertDialog.BUTTON_NEUTRAL, "NEUTRAL", { dialogInterface, k ->
            Toast.makeText(applicationContext, "You clicked on NEUTRAL Button", Toast.LENGTH_SHORT).show()
        })

        alertDilog.show()
    }

    private fun showAlertWithTwoButton() {
        val alertDilog = AlertDialog.Builder(this@MainActivity).create()
        alertDilog.setTitle("Alert")
        alertDilog.setMessage("Show Alert with two Button")

        alertDilog.setButton(AlertDialog.BUTTON_POSITIVE, "YES", { dialogInterface, i ->
            Toast.makeText(applicationContext, "You clicked on YES", Toast.LENGTH_SHORT).show()
        })

        alertDilog.setButton(AlertDialog.BUTTON_NEGATIVE, "NO", { dialogInterface, i ->
            Toast.makeText(applicationContext, "You clicked on NO", Toast.LENGTH_SHORT).show()
        })

        alertDilog.show()
    }

    private fun showSimpleAlert() {

        val simpleAlert = AlertDialog.Builder(this@MainActivity).create()
        simpleAlert.setTitle("Alert")
        simpleAlert.setMessage("Show simple Alert")

        simpleAlert.setButton(AlertDialog.BUTTON_POSITIVE, "OK", { dialogInterface, i ->
            Toast.makeText(applicationContext, "You clicked on OK", Toast.LENGTH_SHORT).show()
        })

        simpleAlert.show()
    }
}
