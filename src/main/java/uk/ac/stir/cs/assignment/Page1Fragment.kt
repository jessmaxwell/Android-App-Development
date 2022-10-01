package uk.ac.stir.cs.assignment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.NumberPicker
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.page1_fragment.*

/**
 * This class is the first fragment of the application
 *  - allows the user to select the type of uni and the units to convert between via pickers
 *  - then confirm this choice via a button
 */

class Page1Fragment : Fragment() {

    //Model used to pass data between the fragments
    private lateinit var model: ViewModel
    //Arrays to hold the current from and to options based on the type selected
    private lateinit var fromUnitArray: Array<String>
    private lateinit var toUnitArray: Array<String>
    //The pickers used to select unit type and units
    private lateinit var typePicker: NumberPicker
    private lateinit var fromPicker: NumberPicker
    private lateinit var toPicker: NumberPicker
    //The array of type to be chosen from
    private lateinit var types: Array<String>
    //Strings to hold the type and units selected
    private lateinit var typeSelected: String
    private var fromUnit: String = ""
    private var toUnit: String = ""
    //Type saved from onSavedInstanceState
    private var typeSaved: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //Attempting to restore the type picker's current value from onSavedInstanceState
        if (savedInstanceState != null) {
            typeSelected = savedInstanceState.getString("typeSaved").toString()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.page1_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val fm: FragmentManager = (activity as AppCompatActivity?)!!.supportFragmentManager

        //Initialising the View Model
        model = ViewModelProvider(requireActivity()).get(ViewModel::class.java)

        //Initialising the picker variables to read from their associated picker
        //TYPE PICKER
        typePicker = view.findViewById(R.id.typePicker) as NumberPicker
        fromPicker = view.findViewById(R.id.unitPicker) as NumberPicker
        toPicker = view.findViewById(R.id.toUnit) as NumberPicker

        //If type picker exists - read in this array to it
        if (typePicker != null) {
            types = arrayOf("Weight", "Speed", "Distance", "Time")
            typePicker.minValue = 0
            typePicker.maxValue = types.size - 1
            typePicker.displayedValues = types
            typePicker.wrapSelectorWheel = true


            //Listen for change in selected Unit Type
            typePicker.setOnValueChangedListener { picker, oldVal, newVal ->

                //New type selected is newly selected value
                typeSelected = types[newVal]

                //Attempting to set a default value within the picker
//                if (typeSelected == "Select Unit Type") {
//                    setUnitFrom(typeSelected)
//                    setUnitTo(typeSelected)}

                //Read in unit to the from and to pickers based on the type selected
                //Using the setUnitFrom and setUnitTo methods that acquire information from the DB
                if (typeSelected.equals("Weight")) {
                    setUnitFrom(typeSelected)
                    setUnitTo(typeSelected)
                } else if (typeSelected.equals("Speed")) {
                    setUnitFrom(typeSelected)
                    setUnitTo(typeSelected)
                } else if (typeSelected.equals("Distance")) {
                    setUnitFrom(typeSelected)
                    setUnitTo(typeSelected)
                } else if (typeSelected.equals("Time")) {
                    setUnitFrom(typeSelected)
                    setUnitTo(typeSelected)
                }

                //Listen for a change in the from picker and set new value to the chosen from unit
                //The array is gathered from the setUnitFrom method and pooulated based on the unit type
                fromPicker.setOnValueChangedListener { picker, oldVal, newVal ->
                    fromUnit = fromUnitArray[newVal]
                }

                //Listen for a change in the to picker and set new value to the chosen to unit
                //The array is gathered from the setUnitFrom method and pooulated based on the unit type
                toPicker.setOnValueChangedListener { picker, oldVal, newVal ->
                    toUnit = toUnitArray[newVal]
                }

                //SAVE BUTTON - SEND DATA TO FRAGMENT 2
                if (saveBtn != null) {
                    saveBtn.setOnClickListener {

                        //Attempting to make use of the default value
//                        if (typeSelected == "Select") {
//                            Toast.makeText(context, "Select Units", Toast.LENGTH_SHORT).show()
//                        }

                        //If the From and To Units selected are the same
                        //Toast message appears to tell the user this cannot be done and units are not passed
                        //  through in to the View Model
                        if (!toUnit.equals("")) {
                            if (fromUnit.equals(toUnit)) {
                                Toast.makeText(
                                    context,
                                    "Select 2 Different Conversion Units",
                                    Toast.LENGTH_SHORT
                                ).show()
                            } else {
                                //If selected units are different, pass to the View Model (therefore to fragment 2)
                                model.getInput(typeSelected)
                                model.fromUnit(fromUnit)
                                model.toUnit(toUnit)
                            }
                        }
                    }
                }
            }
        }
    }

    /**
     * This function will gather all possible 'From' units that can be selected from based on the type that has been selected
     * It uses the database to select all units from the 'Type' column with the same name as the type chosen
     */

    private fun setUnitFrom(selectedValue: String) {
        val projection = arrayOf(DBReader.UnitEntry.COLUMN_NAME_UNIT_FROM)
        val selection = DBReader.UnitEntry.COLUMN_NAME_TYPE + "= ?"
        val selectionArgs = arrayOf(selectedValue)
        val fromArray = (activity as MainActivity).selectSQLStatement(
            true,
            projection,
            selection,
            selectionArgs
        )
        //Pass the array in to our fromUnitArray to be used by the picker
        fromUnitArray = fromArray.toTypedArray()

        //Setting up the from picker
        fromPicker.minValue = 0
        fromPicker.maxValue = fromUnitArray.size - 1
        fromPicker.displayedValues = fromUnitArray
    }

    /**
     * This function will gather all possible 'To' units that can be selected from based on the type that has been selected
     * It uses the database to select all units from the 'Type' column with the same name as the type chosen
     */

    private fun setUnitTo(selectedValue: String) {
        val projection = arrayOf(DBReader.UnitEntry.COLUMN_NAME_UNIT_TO)
        val selection = DBReader.UnitEntry.COLUMN_NAME_TYPE + "= ?"
        val selectionArgs = arrayOf(selectedValue)
        val toArray = (activity as MainActivity).selectSQLStatement(
            true,
            projection,
            selection,
            selectionArgs
        )
        //Pass the array in to our toUnitArray to be used by the picker
        toUnitArray = toArray.toTypedArray()

        //Setting up the to picker
        toPicker.minValue = 0
        toPicker.maxValue = toUnitArray.size - 1
        toPicker.displayedValues = toUnitArray
    }

    /**
     * This function should save the state of the pickers to then be recreated when onCreate is
     * called after a screen rotation
     */
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)

        //Attempting to save the state of the type picker to return after rotation
        val currentType = typePicker.getValue()
        outState.putString("typeSaved", types[currentType])
    }
}
