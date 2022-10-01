package uk.ac.stir.cs.assignment

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.provider.BaseColumns

val DBName = "convertDB.db"

class ConvertDB (var context: Context): SQLiteOpenHelper(context, DBName, null, 1) {

    /**
     * SQL statement to create the conversion database
     */
    var SQL_CREATE_ENTRIES =
        "CREATE TABLE IF NOT EXISTS ${DBReader.UnitEntry.TABLE_NAME} (" +
                "${BaseColumns._ID} INTEGER PRIMARY KEY," +
                "${DBReader.UnitEntry.COLUMN_NAME_TYPE} TEXT," +
               "${DBReader.UnitEntry.COLUMN_NAME_UNIT_FROM} TEXT," +
                "${DBReader.UnitEntry.COLUMN_NAME_UNIT_TO} TEXT," +
               "${DBReader.UnitEntry.COLUMN_NAME_RATIO} TEXT)"

    /**
     * Creating the database for the first time, ensuring that there are no duplicates
     *
     * @param database the database instance to use
     */

    override fun onCreate(database: SQLiteDatabase) {
        database.execSQL(SQL_CREATE_ENTRIES);
        initializeDB(database);
    }

    /**
     * Called when the database needs to be upgraded
     * Can be used to drop or add tables
     */
   override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {}

    /**
     * Populate the database and the rows (Type, Unit From, Unit to, Ratio)
     *
     * @param db the database to be used
     */
    fun initializeDB (db: SQLiteDatabase) {
        var values = ContentValues();

        //This feature is not fully functioning and caused a FATAL EXCEPTION ERROR if selected from the picker
        /*
       set up default item in pickers - need to set same number of defaults
        */
       /* values = ContentValues();
        values.put(DBReader.UnitEntry.COLUMN_NAME_TYPE, "Select Unit Type")
        values.put(DBReader.UnitEntry.COLUMN_NAME_UNIT_FROM, "-")
        values.put(DBReader.UnitEntry.COLUMN_NAME_UNIT_TO, "-")
        values.put(DBReader.UnitEntry.COLUMN_NAME_RATIO, "0.00")
        db.insert(DBReader.UnitEntry.TABLE_NAME, null, values)

        values = ContentValues();
        values.put(DBReader.UnitEntry.COLUMN_NAME_TYPE, "Select Unit Type")
        values.put(DBReader.UnitEntry.COLUMN_NAME_UNIT_FROM, "-")
        values.put(DBReader.UnitEntry.COLUMN_NAME_UNIT_TO, "--")
        values.put(DBReader.UnitEntry.COLUMN_NAME_RATIO, "0.00")
        db.insert(DBReader.UnitEntry.TABLE_NAME, null, values)

        values = ContentValues();
        values.put(DBReader.UnitEntry.COLUMN_NAME_TYPE, "Select Unit Type")
        values.put(DBReader.UnitEntry.COLUMN_NAME_UNIT_FROM, "-")
        values.put(DBReader.UnitEntry.COLUMN_NAME_UNIT_TO, "---")
        values.put(DBReader.UnitEntry.COLUMN_NAME_RATIO, "0.00")
        db.insert(DBReader.UnitEntry.TABLE_NAME, null, values)

        values = ContentValues();
        values.put(DBReader.UnitEntry.COLUMN_NAME_TYPE, "Select Unit Type")
        values.put(DBReader.UnitEntry.COLUMN_NAME_UNIT_FROM, "--")
        values.put(DBReader.UnitEntry.COLUMN_NAME_UNIT_TO, "-")
        values.put(DBReader.UnitEntry.COLUMN_NAME_RATIO, "0.00")
        db.insert(DBReader.UnitEntry.TABLE_NAME, null, values) */

        //-------------------------------------------------------------------------------
        // WEIGHT RATIOS
        //----WEIGHT----
        values = ContentValues();
        values.put(DBReader.UnitEntry.COLUMN_NAME_TYPE, "Weight")
        values.put(DBReader.UnitEntry.COLUMN_NAME_UNIT_FROM, "Kilograms")
        values.put(DBReader.UnitEntry.COLUMN_NAME_UNIT_TO, "Grams")
        values.put(DBReader.UnitEntry.COLUMN_NAME_RATIO, "1000")
        db.insert(DBReader.UnitEntry.TABLE_NAME, null, values)

        values = ContentValues();
        values.put(DBReader.UnitEntry.COLUMN_NAME_TYPE, "Weight");
        values.put(DBReader.UnitEntry.COLUMN_NAME_UNIT_FROM, "Kilograms");
        values.put(DBReader.UnitEntry.COLUMN_NAME_UNIT_TO, "Pounds");
        values.put(DBReader.UnitEntry.COLUMN_NAME_RATIO, "1234");
        db.insert(DBReader.UnitEntry.TABLE_NAME, null, values);

        values = ContentValues();
        values.put(DBReader.UnitEntry.COLUMN_NAME_TYPE, "Weight");
        values.put(DBReader.UnitEntry.COLUMN_NAME_UNIT_FROM, "Kilograms");
        values.put(DBReader.UnitEntry.COLUMN_NAME_UNIT_TO, "Ounces");
        values.put(DBReader.UnitEntry.COLUMN_NAME_RATIO, "1093.61");
        db.insert(DBReader.UnitEntry.TABLE_NAME, null, values)

        values = ContentValues();
        values.put(DBReader.UnitEntry.COLUMN_NAME_TYPE, "Weight");
        values.put(DBReader.UnitEntry.COLUMN_NAME_UNIT_FROM, "Grams");
        values.put(DBReader.UnitEntry.COLUMN_NAME_UNIT_TO, "Kilograms");
        values.put(DBReader.UnitEntry.COLUMN_NAME_RATIO, "0.621");
        db.insert(DBReader.UnitEntry.TABLE_NAME, null, values)

        values = ContentValues();
        values.put(DBReader.UnitEntry.COLUMN_NAME_TYPE, "Weight");
        values.put(DBReader.UnitEntry.COLUMN_NAME_UNIT_FROM, "Grams");
        values.put(DBReader.UnitEntry.COLUMN_NAME_UNIT_TO, "Pounds");
        values.put(DBReader.UnitEntry.COLUMN_NAME_RATIO, "0.00220462");
        db.insert(DBReader.UnitEntry.TABLE_NAME, null, values)

        values = ContentValues();
        values.put(DBReader.UnitEntry.COLUMN_NAME_TYPE, "Weight");
        values.put(DBReader.UnitEntry.COLUMN_NAME_UNIT_FROM, "Grams");
        values.put(DBReader.UnitEntry.COLUMN_NAME_UNIT_TO, "Ounces");
        values.put(DBReader.UnitEntry.COLUMN_NAME_RATIO, "0.621");
        db.insert(DBReader.UnitEntry.TABLE_NAME, null, values)

        values = ContentValues();
        values.put(DBReader.UnitEntry.COLUMN_NAME_TYPE, "Weight");
        values.put(DBReader.UnitEntry.COLUMN_NAME_UNIT_FROM, "Ounces");
        values.put(DBReader.UnitEntry.COLUMN_NAME_UNIT_TO, "Kilograms");
        values.put(DBReader.UnitEntry.COLUMN_NAME_RATIO, "0.0283495");
        db.insert(DBReader.UnitEntry.TABLE_NAME, null, values)

        values = ContentValues();
        values.put(DBReader.UnitEntry.COLUMN_NAME_TYPE, "Weight");
        values.put(DBReader.UnitEntry.COLUMN_NAME_UNIT_FROM, "Ounces");
        values.put(DBReader.UnitEntry.COLUMN_NAME_UNIT_TO, "Pounds");
        values.put(DBReader.UnitEntry.COLUMN_NAME_RATIO, "0.621");
        db.insert(DBReader.UnitEntry.TABLE_NAME, null, values)

        values = ContentValues();
        values.put(DBReader.UnitEntry.COLUMN_NAME_TYPE, "Weight");
        values.put(DBReader.UnitEntry.COLUMN_NAME_UNIT_FROM, "Ounces");
        values.put(DBReader.UnitEntry.COLUMN_NAME_UNIT_TO, "Grams");
        values.put(DBReader.UnitEntry.COLUMN_NAME_RATIO, "0.621");
        db.insert(DBReader.UnitEntry.TABLE_NAME, null, values)

        values = ContentValues();
        values.put(DBReader.UnitEntry.COLUMN_NAME_TYPE, "Weight");
        values.put(DBReader.UnitEntry.COLUMN_NAME_UNIT_FROM, "Pounds");
        values.put(DBReader.UnitEntry.COLUMN_NAME_UNIT_TO, "Kilograms");
        values.put(DBReader.UnitEntry.COLUMN_NAME_RATIO, "0.621");
        db.insert(DBReader.UnitEntry.TABLE_NAME, null, values)

        values = ContentValues();
        values.put(DBReader.UnitEntry.COLUMN_NAME_TYPE, "Weight");
        values.put(DBReader.UnitEntry.COLUMN_NAME_UNIT_FROM, "Pounds");
        values.put(DBReader.UnitEntry.COLUMN_NAME_UNIT_TO, "Ounces");
        values.put(DBReader.UnitEntry.COLUMN_NAME_RATIO, "16.0");
        db.insert(DBReader.UnitEntry.TABLE_NAME, null, values)

        values = ContentValues();
        values.put(DBReader.UnitEntry.COLUMN_NAME_TYPE, "Weight");
        values.put(DBReader.UnitEntry.COLUMN_NAME_UNIT_FROM, "Pounds");
        values.put(DBReader.UnitEntry.COLUMN_NAME_UNIT_TO, "Grams");
        values.put(DBReader.UnitEntry.COLUMN_NAME_RATIO, "0.621");
        db.insert(DBReader.UnitEntry.TABLE_NAME, null, values)

        // SPEED RATIOS

        values = ContentValues();
        values.put(DBReader.UnitEntry.COLUMN_NAME_TYPE, "Speed");
        values.put(DBReader.UnitEntry.COLUMN_NAME_UNIT_FROM, "Miles Per Hour");
        values.put(DBReader.UnitEntry.COLUMN_NAME_UNIT_TO, "Kilometers Per Hour");
        values.put(DBReader.UnitEntry.COLUMN_NAME_RATIO, "1.60934");
        db.insert(DBReader.UnitEntry.TABLE_NAME, null, values)

        values = ContentValues();
        values.put(DBReader.UnitEntry.COLUMN_NAME_TYPE, "Speed");
        values.put(DBReader.UnitEntry.COLUMN_NAME_UNIT_FROM, "Miles Per Hour");
        values.put(DBReader.UnitEntry.COLUMN_NAME_UNIT_TO, "Meters Per Second");
        values.put(DBReader.UnitEntry.COLUMN_NAME_RATIO, "1000");
        db.insert(DBReader.UnitEntry.TABLE_NAME, null, values);

        values = ContentValues();
        values.put(DBReader.UnitEntry.COLUMN_NAME_TYPE, "Speed");
        values.put(DBReader.UnitEntry.COLUMN_NAME_UNIT_FROM, "Miles Per Hour");
        values.put(DBReader.UnitEntry.COLUMN_NAME_UNIT_TO, "Knot");
        values.put(DBReader.UnitEntry.COLUMN_NAME_RATIO, "1093.61");
        db.insert(DBReader.UnitEntry.TABLE_NAME, null, values)

        values = ContentValues();
        values.put(DBReader.UnitEntry.COLUMN_NAME_TYPE, "Speed");
        values.put(DBReader.UnitEntry.COLUMN_NAME_UNIT_FROM, "Kilometers Per Hour");
        values.put(DBReader.UnitEntry.COLUMN_NAME_UNIT_TO, "Miles Per Hour");
        values.put(DBReader.UnitEntry.COLUMN_NAME_RATIO, "0.277778");
        db.insert(DBReader.UnitEntry.TABLE_NAME, null, values)

        values = ContentValues();
        values.put(DBReader.UnitEntry.COLUMN_NAME_TYPE, "Speed");
        values.put(DBReader.UnitEntry.COLUMN_NAME_UNIT_FROM, "Kilometers Per Hour");
        values.put(DBReader.UnitEntry.COLUMN_NAME_UNIT_TO, "Knot");
        values.put(DBReader.UnitEntry.COLUMN_NAME_RATIO, "0.621");
        db.insert(DBReader.UnitEntry.TABLE_NAME, null, values)

        values = ContentValues();
        values.put(DBReader.UnitEntry.COLUMN_NAME_TYPE, "Speed");
        values.put(DBReader.UnitEntry.COLUMN_NAME_UNIT_FROM, "Kilometers Per Hour");
        values.put(DBReader.UnitEntry.COLUMN_NAME_UNIT_TO, "Meters Per Second");
        values.put(DBReader.UnitEntry.COLUMN_NAME_RATIO, "0.621");
        db.insert(DBReader.UnitEntry.TABLE_NAME, null, values)

        values = ContentValues();
        values.put(DBReader.UnitEntry.COLUMN_NAME_TYPE, "Speed");
        values.put(DBReader.UnitEntry.COLUMN_NAME_UNIT_FROM, "Knot");
        values.put(DBReader.UnitEntry.COLUMN_NAME_UNIT_TO, "Kilometers Per Second");
        values.put(DBReader.UnitEntry.COLUMN_NAME_RATIO, "0.621");
        db.insert(DBReader.UnitEntry.TABLE_NAME, null, values)

        values = ContentValues();
        values.put(DBReader.UnitEntry.COLUMN_NAME_TYPE, "Speed");
        values.put(DBReader.UnitEntry.COLUMN_NAME_UNIT_FROM, "Knot");
        values.put(DBReader.UnitEntry.COLUMN_NAME_UNIT_TO, "Miles Per Hour");
        values.put(DBReader.UnitEntry.COLUMN_NAME_RATIO, "0.514444");
        db.insert(DBReader.UnitEntry.TABLE_NAME, null, values)

        values = ContentValues();
        values.put(DBReader.UnitEntry.COLUMN_NAME_TYPE, "Speed");
        values.put(DBReader.UnitEntry.COLUMN_NAME_UNIT_FROM, "Knot");
        values.put(DBReader.UnitEntry.COLUMN_NAME_UNIT_TO, "Meters Per Second");
        values.put(DBReader.UnitEntry.COLUMN_NAME_RATIO, "0.621");
        db.insert(DBReader.UnitEntry.TABLE_NAME, null, values)

        values = ContentValues();
        values.put(DBReader.UnitEntry.COLUMN_NAME_TYPE, "Speed");
        values.put(DBReader.UnitEntry.COLUMN_NAME_UNIT_FROM, "Meters Per Second");
        values.put(DBReader.UnitEntry.COLUMN_NAME_UNIT_TO, "Kilometers Per Second");
        values.put(DBReader.UnitEntry.COLUMN_NAME_RATIO, "0.621");
        db.insert(DBReader.UnitEntry.TABLE_NAME, null, values)

        values = ContentValues();
        values.put(DBReader.UnitEntry.COLUMN_NAME_TYPE, "Speed");
        values.put(DBReader.UnitEntry.COLUMN_NAME_UNIT_FROM, "Meters Per Second");
        values.put(DBReader.UnitEntry.COLUMN_NAME_UNIT_TO, "Miles Per Hour");
        values.put(DBReader.UnitEntry.COLUMN_NAME_RATIO, "2.23694");
        db.insert(DBReader.UnitEntry.TABLE_NAME, null, values)

        values = ContentValues();
        values.put(DBReader.UnitEntry.COLUMN_NAME_TYPE, "Speed");
        values.put(DBReader.UnitEntry.COLUMN_NAME_UNIT_FROM, "Meters Per Second");
        values.put(DBReader.UnitEntry.COLUMN_NAME_UNIT_TO, "Knot");
        values.put(DBReader.UnitEntry.COLUMN_NAME_RATIO, "0.621");
        db.insert(DBReader.UnitEntry.TABLE_NAME, null, values)

        //DISTANCE RATIOS

        values = ContentValues();
        values.put(DBReader.UnitEntry.COLUMN_NAME_TYPE, "Distance");
        values.put(DBReader.UnitEntry.COLUMN_NAME_UNIT_FROM, "Kilometers");
        values.put(DBReader.UnitEntry.COLUMN_NAME_UNIT_TO, "Miles");
        values.put(DBReader.UnitEntry.COLUMN_NAME_RATIO, "0.621");
        db.insert(DBReader.UnitEntry.TABLE_NAME, null, values);

        values = ContentValues();
        values.put(DBReader.UnitEntry.COLUMN_NAME_TYPE, "Distance");
        values.put(DBReader.UnitEntry.COLUMN_NAME_UNIT_FROM, "Kilometers");
        values.put(DBReader.UnitEntry.COLUMN_NAME_UNIT_TO, "Meters");
        values.put(DBReader.UnitEntry.COLUMN_NAME_RATIO, "1000");
        db.insert(DBReader.UnitEntry.TABLE_NAME, null, values);

        values = ContentValues();
        values.put(DBReader.UnitEntry.COLUMN_NAME_TYPE, "Distance");
        values.put(DBReader.UnitEntry.COLUMN_NAME_UNIT_FROM, "Kilometers");
        values.put(DBReader.UnitEntry.COLUMN_NAME_UNIT_TO, "Yards");
        values.put(DBReader.UnitEntry.COLUMN_NAME_RATIO, "1093.61");
        db.insert(DBReader.UnitEntry.TABLE_NAME, null, values)

        values = ContentValues();
        values.put(DBReader.UnitEntry.COLUMN_NAME_TYPE, "Distance");
        values.put(DBReader.UnitEntry.COLUMN_NAME_UNIT_FROM, "Meters");
        values.put(DBReader.UnitEntry.COLUMN_NAME_UNIT_TO, "Yards");
        values.put(DBReader.UnitEntry.COLUMN_NAME_RATIO, "1.09361");
        db.insert(DBReader.UnitEntry.TABLE_NAME, null, values)

        values = ContentValues();
        values.put(DBReader.UnitEntry.COLUMN_NAME_TYPE, "Distance");
        values.put(DBReader.UnitEntry.COLUMN_NAME_UNIT_FROM, "Meters");
        values.put(DBReader.UnitEntry.COLUMN_NAME_UNIT_TO, "Kilometers");
        values.put(DBReader.UnitEntry.COLUMN_NAME_RATIO, "0.001");
        db.insert(DBReader.UnitEntry.TABLE_NAME, null, values)

        values = ContentValues();
        values.put(DBReader.UnitEntry.COLUMN_NAME_TYPE, "Distance");
        values.put(DBReader.UnitEntry.COLUMN_NAME_UNIT_FROM, "Meters");
        values.put(DBReader.UnitEntry.COLUMN_NAME_UNIT_TO, "Miles");
        values.put(DBReader.UnitEntry.COLUMN_NAME_RATIO, "1093.61");
        db.insert(DBReader.UnitEntry.TABLE_NAME, null, values)

        values = ContentValues();
        values.put(DBReader.UnitEntry.COLUMN_NAME_TYPE, "Distance");
        values.put(DBReader.UnitEntry.COLUMN_NAME_UNIT_FROM, "Yards");
        values.put(DBReader.UnitEntry.COLUMN_NAME_UNIT_TO, "Meters");
        values.put(DBReader.UnitEntry.COLUMN_NAME_RATIO, "1093.61");
        db.insert(DBReader.UnitEntry.TABLE_NAME, null, values)

        values = ContentValues();
        values.put(DBReader.UnitEntry.COLUMN_NAME_TYPE, "Distance");
        values.put(DBReader.UnitEntry.COLUMN_NAME_UNIT_FROM, "Yards");
        values.put(DBReader.UnitEntry.COLUMN_NAME_UNIT_TO, "Kilometers");
        values.put(DBReader.UnitEntry.COLUMN_NAME_RATIO, "1093.61");
        db.insert(DBReader.UnitEntry.TABLE_NAME, null, values)

        values = ContentValues();
        values.put(DBReader.UnitEntry.COLUMN_NAME_TYPE, "Distance");
        values.put(DBReader.UnitEntry.COLUMN_NAME_UNIT_FROM, "Yards");
        values.put(DBReader.UnitEntry.COLUMN_NAME_UNIT_TO, "Miles");
        values.put(DBReader.UnitEntry.COLUMN_NAME_RATIO, "0.000568182");
        db.insert(DBReader.UnitEntry.TABLE_NAME, null, values)

        values = ContentValues();
        values.put(DBReader.UnitEntry.COLUMN_NAME_TYPE, "Distance");
        values.put(DBReader.UnitEntry.COLUMN_NAME_UNIT_FROM, "Miles");
        values.put(DBReader.UnitEntry.COLUMN_NAME_UNIT_TO, "Meters");
        values.put(DBReader.UnitEntry.COLUMN_NAME_RATIO, "1093.61");
        db.insert(DBReader.UnitEntry.TABLE_NAME, null, values)

        values = ContentValues();
        values.put(DBReader.UnitEntry.COLUMN_NAME_TYPE, "Distance");
        values.put(DBReader.UnitEntry.COLUMN_NAME_UNIT_FROM, "Miles");
        values.put(DBReader.UnitEntry.COLUMN_NAME_UNIT_TO, "Kilometers");
        values.put(DBReader.UnitEntry.COLUMN_NAME_RATIO, "1.6093");
        db.insert(DBReader.UnitEntry.TABLE_NAME, null, values)

        values = ContentValues();
        values.put(DBReader.UnitEntry.COLUMN_NAME_TYPE, "Distance");
        values.put(DBReader.UnitEntry.COLUMN_NAME_UNIT_FROM, "Miles");
        values.put(DBReader.UnitEntry.COLUMN_NAME_UNIT_TO, "Yards");
        values.put(DBReader.UnitEntry.COLUMN_NAME_RATIO, "1093.61");
        db.insert(DBReader.UnitEntry.TABLE_NAME, null, values)

        // TIME RATIOS
        values = ContentValues();
        values.put(DBReader.UnitEntry.COLUMN_NAME_TYPE, "Time");
        values.put(DBReader.UnitEntry.COLUMN_NAME_UNIT_FROM, "Days");
        values.put(DBReader.UnitEntry.COLUMN_NAME_UNIT_TO, "Hours");
        values.put(DBReader.UnitEntry.COLUMN_NAME_RATIO, "24.0");
        db.insert(DBReader.UnitEntry.TABLE_NAME, null, values)

        values = ContentValues();
        values.put(DBReader.UnitEntry.COLUMN_NAME_TYPE, "Time");
        values.put(DBReader.UnitEntry.COLUMN_NAME_UNIT_FROM, "Days");
        values.put(DBReader.UnitEntry.COLUMN_NAME_UNIT_TO, "Minutes");
        values.put(DBReader.UnitEntry.COLUMN_NAME_RATIO, "1000");
        db.insert(DBReader.UnitEntry.TABLE_NAME, null, values);

        values = ContentValues();
        values.put(DBReader.UnitEntry.COLUMN_NAME_TYPE, "Time");
        values.put(DBReader.UnitEntry.COLUMN_NAME_UNIT_FROM, "Days");
        values.put(DBReader.UnitEntry.COLUMN_NAME_UNIT_TO, "Seconds");
        values.put(DBReader.UnitEntry.COLUMN_NAME_RATIO, "1093.61");
        db.insert(DBReader.UnitEntry.TABLE_NAME, null, values)

        values = ContentValues();
        values.put(DBReader.UnitEntry.COLUMN_NAME_TYPE, "Time");
        values.put(DBReader.UnitEntry.COLUMN_NAME_UNIT_FROM, "Hours");
        values.put(DBReader.UnitEntry.COLUMN_NAME_UNIT_TO, "Seconds");
        values.put(DBReader.UnitEntry.COLUMN_NAME_RATIO, "1093.61");
        db.insert(DBReader.UnitEntry.TABLE_NAME, null, values)

        values = ContentValues();
        values.put(DBReader.UnitEntry.COLUMN_NAME_TYPE, "Time");
        values.put(DBReader.UnitEntry.COLUMN_NAME_UNIT_FROM, "Hours");
        values.put(DBReader.UnitEntry.COLUMN_NAME_UNIT_TO, "Minutes");
        values.put(DBReader.UnitEntry.COLUMN_NAME_RATIO, "60.00");
        db.insert(DBReader.UnitEntry.TABLE_NAME, null, values)

        values = ContentValues();
        values.put(DBReader.UnitEntry.COLUMN_NAME_TYPE, "Time");
        values.put(DBReader.UnitEntry.COLUMN_NAME_UNIT_FROM, "Hours");
        values.put(DBReader.UnitEntry.COLUMN_NAME_UNIT_TO, "Days");
        values.put(DBReader.UnitEntry.COLUMN_NAME_RATIO, "1093.61");
        db.insert(DBReader.UnitEntry.TABLE_NAME, null, values)

        values = ContentValues();
        values.put(DBReader.UnitEntry.COLUMN_NAME_TYPE, "Time");
        values.put(DBReader.UnitEntry.COLUMN_NAME_UNIT_FROM, "Minutes");
        values.put(DBReader.UnitEntry.COLUMN_NAME_UNIT_TO, "Seconds");
        values.put(DBReader.UnitEntry.COLUMN_NAME_RATIO, "60.00");
        db.insert(DBReader.UnitEntry.TABLE_NAME, null, values)

        values = ContentValues();
        values.put(DBReader.UnitEntry.COLUMN_NAME_TYPE, "Time");
        values.put(DBReader.UnitEntry.COLUMN_NAME_UNIT_FROM, "Minutes");
        values.put(DBReader.UnitEntry.COLUMN_NAME_UNIT_TO, "Hours");
        values.put(DBReader.UnitEntry.COLUMN_NAME_RATIO, "1093.61");
        db.insert(DBReader.UnitEntry.TABLE_NAME, null, values)

        values = ContentValues();
        values.put(DBReader.UnitEntry.COLUMN_NAME_TYPE, "Time");
        values.put(DBReader.UnitEntry.COLUMN_NAME_UNIT_FROM, "Minutes");
        values.put(DBReader.UnitEntry.COLUMN_NAME_UNIT_TO, "Days");
        values.put(DBReader.UnitEntry.COLUMN_NAME_RATIO, "1093.61");
        db.insert(DBReader.UnitEntry.TABLE_NAME, null, values)

        values = ContentValues();
        values.put(DBReader.UnitEntry.COLUMN_NAME_TYPE, "Time");
        values.put(DBReader.UnitEntry.COLUMN_NAME_UNIT_FROM, "Seconds");
        values.put(DBReader.UnitEntry.COLUMN_NAME_UNIT_TO, "Minutes");
        values.put(DBReader.UnitEntry.COLUMN_NAME_RATIO, "1093.61");
        db.insert(DBReader.UnitEntry.TABLE_NAME, null, values)

        values = ContentValues();
        values.put(DBReader.UnitEntry.COLUMN_NAME_TYPE, "Time");
        values.put(DBReader.UnitEntry.COLUMN_NAME_UNIT_FROM, "Seconds");
        values.put(DBReader.UnitEntry.COLUMN_NAME_UNIT_TO, "Hours");
        values.put(DBReader.UnitEntry.COLUMN_NAME_RATIO, "1093.61");
        db.insert(DBReader.UnitEntry.TABLE_NAME, null, values)

        values = ContentValues();
        values.put(DBReader.UnitEntry.COLUMN_NAME_TYPE, "Time");
        values.put(DBReader.UnitEntry.COLUMN_NAME_UNIT_FROM, "Seconds");
        values.put(DBReader.UnitEntry.COLUMN_NAME_UNIT_TO, "Days");
        values.put(DBReader.UnitEntry.COLUMN_NAME_RATIO, "1.15741e-5");
        db.insert(DBReader.UnitEntry.TABLE_NAME, null, values)
    }
}
