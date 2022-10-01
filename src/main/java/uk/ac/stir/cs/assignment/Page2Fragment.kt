package uk.ac.stir.cs.assignment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.page2_fragment.*
import java.text.DecimalFormat

/**
 * This class is the second screen of the application
 * The unit information is passed here via the View Model from fragment 1
 * The user can then input a value to convert and confirm this via a button
 */

class Page2Fragment : Fragment() {

    //The text views to display the unit information
    private lateinit var convertedView: TextView
    private lateinit var inputTV: TextView
    private lateinit var selectedUnit:TextView
    //The value that is input by the user to be converted
    private lateinit var inputValue : String
    //Variable used to put the value in the correct format
    private val decimal = DecimalFormat("###.#####")
    //Boolean variable to become true if the clear button is been clicked
    private var clearClicked: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.page2_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val fm: FragmentManager = (activity as AppCompatActivity?)!!.supportFragmentManager

        //Initialise the view model
        val model = ViewModelProvider(requireActivity()).get(ViewModel::class.java)

        //Initialise the String to read the data of the chosen type
        selectedUnit = view.findViewById(R.id.typeInput) as TextView


        //Gathering the selected Unit data from the View Model - passed from fragment 1
        //Unit Type
        model.inputType.observe(viewLifecycleOwner, Observer {
            typeInput.text = it
        })
        //From Unit
        model.fromUnit.observe(viewLifecycleOwner, Observer {
            fromUnit.text = it
        })
        //To Unit
        model.toUnit.observe(viewLifecycleOwner, Observer {
            toUnit.text = it
        })

        //CLEAR BUTTON
        //Listener for a click of the button
        //Set text views to blank and set the Boolean variable to true
        clearBtn.setOnClickListener {
            fromValue.setText(" ")
            toValue.text = ""
            clearClicked = true
        }

        //CONVERT BUTTON
        //Listener for a click of the button
        if (convertBtn != null) {
            convertBtn.setOnClickListener {

                //If any of the unit choices have been left blank, print message to the user
                if (typeInput.text == ("") || fromUnit.text == ("") || toUnit.text == ("")) {
                    Toast.makeText(context, "Please ensure all fields are fulfilled", Toast.LENGTH_SHORT).show()
                }

                //Text View to display the converted value
                convertedView = view.findViewById(R.id.toValue) as TextView

                //Identify the input value text view
                inputTV = view.findViewById(R.id.fromValue) as TextView

                //Convert the value to a String
                inputValue = inputTV.text.toString()

                //If there is a value input then the clear boolean is set back false
                if(inputValue != "")
                {
                    clearClicked = false
                }

                //If no value is input or the clear button has been clicked, print message to the user
                if (clearClicked || inputValue == ("")) {
                    Toast.makeText(context, "Please Enter A Value To Convert", Toast.LENGTH_SHORT).show()
                }
                //If no values have been input or the clear button has been clicked, print message to the user
                if (clearClicked && inputValue == ("") && convertedView.text == ("")) {
                    Toast.makeText(context, "TEST", Toast.LENGTH_SHORT).show()
                }

                // ----GATHER CONVERSIONS----

                    //DISTANCE CONVERSIONS
                    if (selectedUnit.text == ("Distance")) {
                        convertInput()
                    }
                    //WEIGHT CONVERSIONS
                    else if (selectedUnit.text == ("Weight")) {
                        convertInput()
                    }
                    //SPEED CONVERSIONS
                    else if (selectedUnit.text == ("Speed")) {
                        convertInput()
                    }
                    //TIME CONVERSIONS
                    else if (selectedUnit.text == ("Time")) {
                        convertInput()
                    }
                //Attempt to set default value
//                    else if (selectedUnit.text == ("Select Unit Type")) {
//                        convertInput()
//                    }
                }
        }
    }

    /**
     * This function will convert the input value using the ratio generated from the getRatio function
     */
    private fun convertInput() {
        val rate = getRatio()

        //If there is a value input
        if(inputValue.isNotEmpty())
        {
            //Display the converted value to the text view
            //Both the input and the ratio are converted to doubles to ensure they can be multiplied together
            convertedView.text = decimal.format(inputValue.toDouble() * rate.toDouble())
        }
        //If there is not a value input
        else if(inputValue.isEmpty())
        {
            //Text view is blank
            convertedView.text = ("")
        }
    }

    /**
     * This function will collect the correct ratio from the database to be passed to the convertInput() function
     *  - the ratio is found using the unit type and from and to units, as the ratio will change based on what units
     *  are being converted between
     */
    private fun getRatio():String{
        val projection = arrayOf(DBReader.UnitEntry.COLUMN_NAME_RATIO)
        val selection: String = DBReader.UnitEntry.COLUMN_NAME_UNIT_FROM + " = ? AND " + DBReader.UnitEntry.COLUMN_NAME_UNIT_TO + " = ? "
        val selectionArgs = arrayOf(fromUnit.text.toString(), toUnit.text.toString())
        val rate: ArrayList<String> = (activity as MainActivity).selectSQLStatement(true, projection, selection, selectionArgs)
        return rate[0]
    }
}

