package com.shahad.vat
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.shahad.vat.databinding.ActivityMainBinding
import java.text.NumberFormat

class MainActivity : AppCompatActivity() {


    //first create binding object
    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        // make interaction to calculate VAT
        binding.buttonPanel.setOnClickListener {
            calculateVat()
        }


    }// end onCreate
    // calculateVat function
    private fun calculateVat() {
        val stringInTextField = binding.editTextText.text.toString()
        val cost = stringInTextField.toDouble()

        val userchoice = binding.radioGroup1.checkedRadioButtonId

        // Radio Button Selected
        val vatPercentage = when(userchoice){
            R.id.RB_1 -> 0.10
            R.id.RB_2 -> 0.15
            else -> 0.20
        }

        val vat = vatPercentage * cost
        var total = cost + vat


        val roundedVat = binding.swich.isChecked

        if (roundedVat){
            total = kotlin.math.ceil(total)
        }

        // Total Formatting
        val formattedTotal = NumberFormat.getCurrencyInstance().format(total)
        binding.totalAmountext.text = getString(R.string.total_amount, formattedTotal)

    }

}