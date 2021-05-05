package com.anantduhan.firebookmessenger

import android.app.Dialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.core.widget.addTextChangedListener
import com.hbb20.CountryCodePicker
import kotlinx.android.synthetic.main.activity_phone_number_verification.*

const val PHONE_NUMBER = "phone"

class PhoneNumberVerificationActivity : AppCompatActivity() {

    val phoneNoEt:EditText by lazy {
        findViewById<EditText>(R.id.phoneNumberEt)
    }

    val button: Button by lazy {
        findViewById<Button>(R.id.nextButton)
    }

    lateinit var countryCode: String
    lateinit var phoneNumber: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_phone_number_verification)

        phoneNoEt.addTextChangedListener { value ->
            button.isEnabled = !(value.isNullOrEmpty() || value.length < 10)
        }

        nextButton.setOnClickListener {
            checkNumber()
        }
    }

    private fun checkNumber() {
        countryCode = findViewById<CountryCodePicker>(R.id.ccp).selectedCountryCodeWithPlus
        phoneNumber = countryCode + phoneNoEt.text.toString()

        // Add some validation here
        startActivity(Intent(this, OtpActivity::class.java).putExtra(PHONE_NUMBER, phoneNumber))
    }

//    private fun customDialogForPhoneNumberVerification() {
//        val customDialog = Dialog(this)
//        customDialog.setContentView(R.layout.dialog_custom_phone_number_confirmation)
//        customDialog.tvOK.setOnClickListener {
//            finish()
//            customDialog.dismiss()
//        }
//        customDialog.tvEDIT.setOnClickListener {
//            customDialog.dismiss()
//        }
//        customDialog.show()
//    }
}