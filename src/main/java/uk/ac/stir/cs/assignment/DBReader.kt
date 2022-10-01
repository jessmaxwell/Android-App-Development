package uk.ac.stir.cs.assignment

import android.provider.BaseColumns

/**
 * The DBReader class allows the database to be referenced elsewhere within the project
 */

class DBReader private constructor() {
    object UnitEntry : BaseColumns {
        const val TABLE_NAME = "Conversions"
        const val COLUMN_NAME_TYPE = "Type"
        const val COLUMN_NAME_UNIT_FROM = "unitFrom"
        const val COLUMN_NAME_UNIT_TO = "unitTo"
        const val COLUMN_NAME_RATIO = "Ratio"
    }
}