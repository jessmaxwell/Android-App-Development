package uk.ac.stir.cs.assignment

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel

/**
 * This class holds the data selected in the first fragment
 * The data can then be read in to the second fragment in order to complete the correct conversion
 */

// Notify Fragment 2 of any changes - unit type, units converting between
class ViewModel(private val state: SavedStateHandle) : ViewModel() {

    //Live Data to hold the selected unit and from and to units
    val inputType = MutableLiveData<String>()
    val fromUnit = MutableLiveData<String>()
    val toUnit =  MutableLiveData<String>()
    //Attempt to restore the state of the type picker on rotation of the first fragment
    val typeSaved = MutableLiveData<String>()

    /**
     * This function will get the input unit from the first fragment picker and set it the inputType variable
     */
    fun getInput(text: String) {
        inputType.value = text
    }

    /**
     * This function will get the input from unit from the first fragment picker and set it the fromUnit variable
     */
    fun fromUnit(text: String) {
        fromUnit.value = text
    }

    /**
     * This function will get the input to unit from the first fragment picker and set it the toUnit variable
     */
    fun toUnit(text: String) {
        toUnit.value = text
    }

    /**
     * These functions are an attempt to save the state of the type picker from the first fragment
     * on rotation of the screen
     */
//    fun getType(type1: String)
//    {
//        inputType.value = type1
//    }
//
//    fun setType(type2: String){
//        if(type2 != null){
//            inputType.value = type2
//        }
//    }
//
////    fun getTypeSaved(): MutableLiveData<String>
////    {
////        return typeSaved
////    }
//
//    fun setTypeSaved(type1: MutableLiveData<String>){
//        if(type1 != null){
//            inputType.value = type1.toString()
//        }
//    }

//    val savedType = MutableLiveData<String>()
//    val saved_Type: LiveData<String> = saved_Type
//
//    fun setSavedType(type: String) {
//        savedType.value = type
//    }
}