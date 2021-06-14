package com.cars.halamotor.dataBase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.cars.halamotor.model.CCEMT;
import com.cars.halamotor.model.SimilarItem;

/*
in database not allowed to save object then well
save common item we need to show in fires
well save all type
1.USER_ADS 2.FAVOURITE 3.CALL_ITEMS 4.WATCHED_ITEMS 5.SEARCH_ITEMS
this well save as item type in data base
well use item saved to create suggested items to user depend
item table
item table we saved before user used app can tke its init items
*/

public class DBHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME="hala_motor.db";

//    public static final String TABLE_C_INFORMATION="Cars";
//    public static final String COL_C_MA_ID="ID";
//    public static final String COL_C_MA_EN="CAR_MAKE_EN";
//    public static final String COL_C_MA_AR="CAR_MAKE_AR";
//    public static final String COL_C_MA_S="CAR_MAKE_S";
//    public static final String COL_C_MO_EN="CAR_MODEL_EN";
//    public static final String COL_C_MO_AR="CAR_MODEL_AR";
//    public static final String COL_C_MO_S="CAR_MODEL_S";
//
public static final String TABLE_CITYS="cites";
    public static final String COL_CITY_COL_ID="COL_ID";
    public static final String COL_CITY_ID="ID";
    public static final String COL_CITY_CODE="CODE";
    public static final String COL_CITY_NAME="NAME";
    public static final String COL_CITY_NAME_EN="NAME_EN";
    public static final String COL_CITY_NAME_AR="NAME_AR";

    public static final String TABLE_AREAS="areas";
    public static final String COL_AREA_COL_ID="COL_ID";
    public static final String COL_AREA_ID="ID";
    public static final String COL_AREA_Name="NAME";
    public static final String COL_AREA_NAME_EN="NAME_EN";
    public static final String COL_AREA_NAME_AR="NAME_AR";
    public static final String COL_AREA_CITY_ID="CITY_ID";
    public static final String COL_AREA_CITY_CODE="CITY_CODE";
    public static final String COL_AREA_CITY_NAME="CITY_NAME";
    public static final String COL_AREA_CITY_NAME_EN="CITY_NAME_EN";
    public static final String COL_AREA_CITY_NAME_AR="CITY_NAME_AR";

    public static final String TABLE_CARS_BRAND="cars_brand";
    public static final String COL_BRAND_COL_ID="COL_ID";
    public static final String COL_BRAND_ID="ID";
    public static final String COL_BRAND_NAME="CODE";
    public static final String COL_BRAND_NAME_EN="NAME_EN";
    public static final String COL_BRAND_NAME_AR="NAME_AR";

    public static final String TABLE_CARS_MODEL="cars_model";
    public static final String COL_MODEL_COL_ID="COL_ID";
    public static final String COL_MODEL_BRAND_ID="BRAND_ID";
    public static final String COL_MODEL_BRAND_NAME="BRAND_NAME";
    public static final String COL_MODEL_BRAND_NAME_EN="BRAND_NAME_EN";
    public static final String COL_MODEL_BRAND_NAME_AR="BRAND_NAME_AR";
    public static final String COL_MODEL_ID="MODEL_ID";
    public static final String COL_MODEL_NAME="MODEL_NAME";
    public static final String COL_MODEL_NAME_EN="MODEL_NAME_EN";
    public static final String COL_MODEL_NAME_AR="MODEL_NAME_AR";

    public static final String TABLE_MODEL_SETTING="model_setting";
    public static final String TABLE_MODEL_SETTING_COL_ID="COL_ID";
    public static final String TABLE_MODEL_SETTING_ID="SETTING_ID";
    public static final String TABLE_MODEL_SETTING_CODE="SETTING_CODE";
    public static final String TABLE_MODEL_SETTING_NAME="SETTING_NAME";
    public static final String TABLE_MODEL_SETTING_NAME_EN="SETTING_NAME_EN";
    public static final String TABLE_MODEL_SETTING_NAME_AR="SETTING_NAME_AR";
    public static final String TABLE_MODEL_SETTING_CONTENT_ID="SETTING_CONTENT_ID";
    public static final String TABLE_MODEL_SETTING_CONTENT_CODE="SETTING_CONTENT_CODE";
    public static final String TABLE_MODEL_SETTING_CONTENT_NAME="SETTING_CONTENT_NAME";
    public static final String TABLE_MODEL_SETTING_CONTENT_NAME_EN="SETTING_CONTENT_NAME_EN";
    public static final String TABLE_MODEL_SETTING_CONTENT_NAME_AR="SETTING_CONTENT_NAME_AR";


    public static final String TABLE_DRIVER_INFORMATION="driver_info_table";
    public static final String COL_ITEM_DRIVER_INFORMATION_id="ID";
    public static final String COL_ITEM_DRIVER_INFORMATION_PROCESS_TYPE_S="PROCESS_TYPE_S";
    public static final String COL_ITEM_DRIVER_INFORMATION_PROCESS_TYPE="PROCESS_TYPE";
    public static final String COL_ITEM_DRIVER_INFORMATION_PROCESS_CONTENT="PROCESS_CONTENT";
    public static final String COL_ITEM_DRIVER_INFORMATION_PROCESS_CONTENT_S="PROCESS_CONTENT_S";
    public static final String COL_ITEM_DRIVER_INFORMATION_PROCESS_STATUS="PROCESS_STATUS";

    public static final String TABLE_CAR_DETAILS="car_details_table";
    public static final String COL_ITEM_CAR_DETAILS_id="ID";
    public static final String COL_ITEM_CAR_DETAILS_PROCESS_TYPE_S="PROCESS_TYPE_S";
    public static final String COL_ITEM_CAR_DETAILS_PROCESS_TYPE="PROCESS_TYPE";
    public static final String COL_ITEM_CAR_DETAILS_PROCESS_CONTENT="PROCESS_CONTENT";
    public static final String COL_ITEM_CAR_DETAILS_PROCESS_CONTENT_S="PROCESS_CONTENT_S";
    public static final String COL_ITEM_CAR_DETAILS_PROCESS_STATUS="PROCESS_STATUS";

    public static final String TABLE_ITEM="item_table";
    public static final String COL_ITEM_id="ID";
    public static final String COL_ITEM_BOOST_OR_NOT="BOOST_OR_NOT";
    public static final String COL_ITEM_BOOST_TYPE="BOOST_TYPE";
    public static final String COL_ITEM_TYPE="TYPE";
    public static final String COL_ITEM_PERSON_GALLERY="PERSON_GALLERY";
    public static final String COL_ITEM_ID_IN_SERVER="ITEM_ID_IN_SERVER";
    public static final String COL_ITEM_CAR_MAKE="ITEM_CAR_MAKE";
    public static final String COL_ITEM_CAR_MODEL="ITEM_CAR_MODEL";
    public static final String COL_ITEM_CAR_YEAR="ITEM_CAR_YEAR";
    public static final String COL_ITEM_CAR_CONDITION="ITEM_CAR_CONDITION";
    public static final String COL_ITEM_CAR_KILOMETERS="ITEM_CAR_KILOMETERS";
    public static final String COL_ITEM_CAR_TRANSMISSION="ITEM_CAR_TRANSMISSION";
    public static final String COL_ITEM_CAR_FUEL="ITEM_CAR_FUEL";
    public static final String COL_ITEM_CAR_LICENSE="ITEM_CAR_LICENSE";
    public static final String COL_ITEM_CAR_INSURANCE="ITEM_CAR_INSURANCE";
    public static final String COL_ITEM_CAR_COLOR="ITEM_CAR_COLOR";
    public static final String COL_ITEM_CAR_PAYMENT_METHOD="ITEM_CAR_PAYMENT_METHOD";
    public static final String COL_ITEM_CAR_OPTIONS="ITEM_CAR_OPTIONS";
    public static final String COL_ITEM_NUMBER_OF_COMMENT="ITEM_NUMBER_OF_COMMENT";
    public static final String COL_ITEM_NUMBER_OF_IMAGE="ITEM_NUMBER_OF_IMAGE";
    public static final String COL_ITEM_CITY="ITEM_CITY";
    public static final String COL_ITEM_NEIGHBORHOOD="ITEM_NEIGHBORHOOD";
    public static final String COL_ITEM_TIME_POST="ITEM_TIME_POST";
    public static final String COL_ITEM_USER_PHONE_NUMBER="ITEM_USER_PHONE_NUMBER";
    public static final String COL_ITEM_ITEM_NAME="ITEM_NAME";
    public static final String COL_ITEM_ITEM_IMAGE="ITEM_IMAGE";
    public static final String COL_ITEM_ITEM_DESCRIPTION="ITEM_DESCRIPTION";
    public static final String COL_ITEM_USER_IMAGE="ITEM_USER_IMAGE";
    public static final String COL_ITEM_ITEM_USER_NAME="ITEM_USER_NAME";
    public static final String COL_ITEM_ITEM_POST_EDIT="ITEM_POST_EDIT";
    public static final String COL_ITEM_ITEM_NEW_PRICE="ITEM_NEW_PRICE";
    public static final String COL_ITEM_ITEM_WHEELS_SIZE="ITEM_WHEELS_SIZE";
    public static final String COL_ITEM_ITEM_CAR_PLATES_CITY="ITEM_CAR_PLATES_CITY";
    public static final String COL_ITEM_ITEM_CAR_PLATES_NUMBER="ITEM_CAR_PLATES_NUMBER";
    public static final String COL_ITEM_ITEM_CAR_PLATES_SPECIAL_OR_NOT="ITEM_CAR_PLATES_SPECIAL_OR_NOT";
    public static final String COL_ITEM_ITEM_BURNED_PRICE="ITEM_BURNED_PRICE";
    public static final String COL_ITEM_ITEM_PRICE="ITEM_PRICE";
    public static final String COL_ITEM_USER_ID="USER_ID";
    public static final String COL_ITEM_ITEM_ACTIVE_OR_NOT="ITEM_NAME_ACTIVE_OR_NOT";

    //this table to save favorite , seen ,call ,as well as search item well give him
    //name FCS
    public static final String TABLE_ITEM_FCS="item_fcs_table";
    public static final String COL_ITEM_FCS_id="ID";
    public static final String COL_ITEM_FCS_ID_IN_SERVER="ITEM_ID_IN_SERVER";
    public static final String COL_ITEM_FCS_CATEGORY="CATEGORY";
    public static final String COL_ITEM_FCS_TYPE_FCS="FCS_TYPE";

    public static final String TABLE_CCEMT="ccemt_table";
    public static final String COL_CCEMT_id="ID";
    public static final String COL_CCEMT_BOOST_OR_NOT="BOOST_OR_NOT";
    public static final String COL_CCEMT_BOOST_TYPE="BOOST_TYPE";
    public static final String COL_CCEMT_TYPE="TYPE";
    public static final String COL_CCEMT_PERSON_GALLERY="PERSON_GALLERY";
    public static final String COL_CCEMT_ID_IN_SERVER="ITEM_ID_IN_SERVER";
    public static final String COL_CCEMT_CAR_MAKE="ITEM_CAR_MAKE";
    public static final String COL_CCEMT_CAR_MODEL="ITEM_CAR_MODEL";
    public static final String COL_CCEMT_CAR_YEAR="ITEM_CAR_YEAR";
    public static final String COL_CCEMT_CAR_CONDITION="ITEM_CAR_CONDITION";
    public static final String COL_CCEMT_CAR_KILOMETERS="ITEM_CAR_KILOMETERS";
    public static final String COL_CCEMT_CAR_TRANSMISSION="ITEM_CAR_TRANSMISSION";
    public static final String COL_CCEMT_CAR_FUEL="ITEM_CAR_FUEL";
    public static final String COL_CCEMT_CAR_LICENSE="ITEM_CAR_LICENSE";
    public static final String COL_CCEMT_CAR_INSURANCE="ITEM_CAR_INSURANCE";
    public static final String COL_CCEMT_CAR_COLOR="ITEM_CAR_COLOR";
    public static final String COL_CCEMT_CAR_PAYMENT_METHOD="ITEM_CAR_PAYMENT_METHOD";
    public static final String COL_CCEMT_CAR_OPTIONS="ITEM_CAR_OPTIONS";
    public static final String COL_CCEMT_NUMBER_OF_COMMENT="ITEM_NUMBER_OF_COMMENT";
    public static final String COL_CCEMT_NUMBER_OF_IMAGE="ITEM_NUMBER_OF_IMAGE";
    public static final String COL_CCEMT_CITY="ITEM_CITY";
    public static final String COL_CCEMT_NEIGHBORHOOD="ITEM_NEIGHBORHOOD";
    public static final String COL_CCEMT_TIME_POST="ITEM_TIME_POST";
    public static final String COL_CCEMT_USER_PHONE_NUMBER="ITEM_USER_PHONE_NUMBER";
    public static final String COL_CCEMT_ITEM_NAME="ITEM_NAME";
    public static final String COL_CCEMT_ITEM_IMAGE="ITEM_IMAGE";
    public static final String COL_CCEMT_ITEM_DESCRIPTION="ITEM_DESCRIPTION";
    public static final String COL_CCEMT_USER_IMAGE="ITEM_USER_IMAGE";
    public static final String COL_CCEMT_ITEM_USER_NAME="ITEM_USER_NAME";
    public static final String COL_CCEMT_ITEM_POST_EDIT="ITEM_POST_EDIT";
    public static final String COL_CCEMT_ITEM_NEW_PRICE="ITEM_NEW_PRICE";
    public static final String COL_CCEMT_ITEM_BURNED_PRICE="ITEM_BURNED_PRICE";
    public static final String COL_CCEMT_ITEM_PRICE="ITEM_PRICE";
    public static final String COL_CCEMT_USER_ID="USER_ID";
    public static final String COL_CCEMT_ITEM_ACTIVE_OR_NOT="ITEM_NAME_ACTIVE_OR_NOT";
    public static final String COL_CCEMT_ITEM_DATE="ITEM_DATE";
    public static final String COL_CCEMT_ITEM_TIME_STAMP="TIME_STAMP";

    public static final String TABLE_WHEELS_RIM="wheels_rim_table";
    public static final String COL_WHEELS_RIM_id="ID";
    public static final String COL_WHEELS_RIM_BOOST_OR_NOT="BOOST_OR_NOT";
    public static final String COL_WHEELS_RIM_BOOST_TYPE="BOOST_TYPE";
    public static final String COL_WHEELS_RIM_PERSON_GALLERY="PERSON_GALLERY";
    public static final String COL_WHEELS_RIM_ID_IN_SERVER="ITEM_ID_IN_SERVER";
    public static final String COL_WHEELS_RIM_WHEELS_SIZE="ITEM_WHEELS_SIZE";
    public static final String COL_WHEELS_RIM_NUMBER_OF_COMMENT="ITEM_NUMBER_OF_COMMENT";
    public static final String COL_WHEELS_RIM_NUMBER_OF_IMAGE="ITEM_NUMBER_OF_IMAGE";
    public static final String COL_WHEELS_RIM_CITY="ITEM_CITY";
    public static final String COL_WHEELS_RIM_NEIGHBORHOOD="ITEM_NEIGHBORHOOD";
    public static final String COL_WHEELS_RIM_TIME_POST="ITEM_TIME_POST";
    public static final String COL_WHEELS_RIM_USER_PHONE_NUMBER="ITEM_USER_PHONE_NUMBER";
    public static final String COL_WHEELS_RIM_ITEM_NAME="ITEM_NAME";
    public static final String COL_WHEELS_RIM_ITEM_IMAGE="ITEM_IMAGE";
    public static final String COL_WHEELS_RIM_ITEM_DESCRIPTION="ITEM_DESCRIPTION";
    public static final String COL_WHEELS_RIM_USER_IMAGE="ITEM_USER_IMAGE";
    public static final String COL_WHEELS_RIM_ITEM_USER_NAME="ITEM_USER_NAME";
    public static final String COL_WHEELS_RIM_ITEM_POST_EDIT="ITEM_POST_EDIT";
    public static final String COL_WHEELS_RIM_ITEM_NEW_PRICE="ITEM_NEW_PRICE";
    public static final String COL_WHEELS_RIM_ITEM_BURNED_PRICE="ITEM_BURNED_PRICE";
    public static final String COL_WHEELS_RIM_ITEM_PRICE="ITEM_PRICE";
    public static final String COL_WHEELS_RIM_USER_ID="USER_ID";
    public static final String COL_WHEELS_RIM_ITEM_ACTIVE_OR_NOT="ITEM_NAME_ACTIVE_OR_NOT";
    public static final String COL_WHEELS_RIM_DATE="ITEM_DATE";
    public static final String COL_WHEELS_RIM_TIME_STAMP="TIME_STAMP";

    public static final String TABLE_CAR_PLATES_RIM="car_plates_table";
    public static final String COL_CAR_PLATES_id="ID";
    public static final String COL_CAR_PLATES_BOOST_OR_NOT="BOOST_OR_NOT";
    public static final String COL_CAR_PLATES_BOOST_TYPE="BOOST_TYPE";
    public static final String COL_CAR_PLATES_PERSON_GALLERY="PERSON_GALLERY";
    public static final String COL_CAR_PLATES_ID_IN_SERVER="ITEM_ID_IN_SERVER";
    public static final String COL_CAR_PLATES_PLATES_CITY="ITEM_CAR_PLATES_CITY";
    public static final String COL_CAR_PLATES_PLATES_NUMBER="ITEM_CAR_PLATES_NUMBER";
    public static final String COL_CAR_PLATES_PLATES_SPECIAL_OR_NOT="ITEM_CAR_PLATES_SPECIAL_OR_NOT";
    public static final String COL_CAR_PLATES_NUMBER_OF_COMMENT="ITEM_NUMBER_OF_COMMENT";
    public static final String COL_CAR_PLATES_NUMBER_OF_IMAGE="ITEM_NUMBER_OF_IMAGE";
    public static final String COL_CAR_PLATES_CITY="ITEM_CITY";
    public static final String COL_CAR_PLATES_NEIGHBORHOOD="ITEM_NEIGHBORHOOD";
    public static final String COL_CAR_PLATES_TIME_POST="ITEM_TIME_POST";
    public static final String COL_CAR_PLATES_USER_PHONE_NUMBER="ITEM_USER_PHONE_NUMBER";
    public static final String COL_CAR_PLATES_ITEM_NAME="ITEM_NAME";
    public static final String COL_CAR_PLATES_ITEM_IMAGE="ITEM_IMAGE";
    public static final String COL_CAR_PLATES_ITEM_DESCRIPTION="ITEM_DESCRIPTION";
    public static final String COL_CAR_PLATES_USER_IMAGE="ITEM_USER_IMAGE";
    public static final String COL_CAR_PLATES_ITEM_USER_NAME="ITEM_USER_NAME";
    public static final String COL_CAR_PLATES_ITEM_POST_EDIT="ITEM_POST_EDIT";
    public static final String COL_CAR_PLATES_ITEM_NEW_PRICE="ITEM_NEW_PRICE";
    public static final String COL_CAR_PLATES_ITEM_BURNED_PRICE="ITEM_BURNED_PRICE";
    public static final String COL_CAR_PLATES_ITEM_PRICE="ITEM_PRICE";
    public static final String COL_CAR_PLATES_ITEM_USER_ID="USER_ID";
    public static final String COL_CAR_PLATES_ITEM_ACTIVE_OR_NOT="ITEM_NAME_ACTIVE_OR_NOT";
    public static final String COL_CAR_PLATES_DATE="ITEM_DATE";
    public static final String COL_CAR_PLATES_TIME_STAMP="TIME_STAMP";

    public static final String TABLE_AccAndJunk="accAndJunk_table";
    public static final String COL_AccAndJunk_id="ID";
    public static final String COL_AccAndJunk_BOOST_OR_NOT="BOOST_OR_NOT";
    public static final String COL_AccAndJunk_BOOST_TYPE="BOOST_TYPE";
    public static final String COL_AccAndJunk_TYPE="TYPE";
    public static final String COL_AccAndJunk_PERSON_GALLERY="PERSON_GALLERY";
    public static final String COL_AccAndJunk_ID_IN_SERVER="ITEM_ID_IN_SERVER";
    public static final String COL_AccAndJunk_NUMBER_OF_COMMENT="ITEM_NUMBER_OF_COMMENT";
    public static final String COL_AccAndJunk_NUMBER_OF_IMAGE="ITEM_NUMBER_OF_IMAGE";
    public static final String COL_AccAndJunk_CITY="ITEM_CITY";
    public static final String COL_AccAndJunk_NEIGHBORHOOD="ITEM_NEIGHBORHOOD";
    public static final String COL_AccAndJunk_TIME_POST="ITEM_TIME_POST";
    public static final String COL_AccAndJunk_USER_PHONE_NUMBER="ITEM_USER_PHONE_NUMBER";
    public static final String COL_AccAndJunk_ITEM_NAME="ITEM_NAME";
    public static final String COL_AccAndJunk_ITEM_IMAGE="ITEM_IMAGE";
    public static final String COL_AccAndJunk_ITEM_DESCRIPTION="ITEM_DESCRIPTION";
    public static final String COL_AccAndJunk_USER_IMAGE="ITEM_USER_IMAGE";
    public static final String COL_AccAndJunk_ITEM_USER_NAME="ITEM_USER_NAME";
    public static final String COL_AccAndJunk_ITEM_POST_EDIT="ITEM_POST_EDIT";
    public static final String COL_AccAndJunk_ITEM_NEW_PRICE="ITEM_NEW_PRICE";
    public static final String COL_AccAndJunk_ITEM_BURNED_PRICE="ITEM_BURNED_PRICE";
    public static final String COL_AccAndJunk_ITEM_PRICE="ITEM_PRICE";
    public static final String COL_AccAndJunk_ITEM_USER_ID="USER_ID";
    public static final String COL_AccAndJunk_ITEM_ACTIVE_OR_NOT="ITEM_NAME_ACTIVE_OR_NOT";
    public static final String COL_AccAndJunk_ITEM_DATA="ITEM_DATE";
    public static final String COL_AccAndJunk_ITEM_TIME_STAMP="TIME_STAMP";

    public static final String TABLE_SUGGESTED="item_suggested_table";
    public static final String COL_SUGGESTED_id="ID";
    public static final String COL_SUGGESTED_BOOST_OR_NOT="BOOST_OR_NOT";
    public static final String COL_SUGGESTED_BOOST_TYPE="BOOST_TYPE";
    public static final String COL_SUGGESTED_TYPE="TYPE";
    public static final String COL_SUGGESTED_PERSON_GALLERY="PERSON_GALLERY";
    public static final String COL_SUGGESTED_ID_IN_SERVER="ITEM_ID_IN_SERVER";
    public static final String COL_SUGGESTED_CAR_MAKE="ITEM_CAR_MAKE";
    public static final String COL_SUGGESTED_CAR_MODEL="ITEM_CAR_MODEL";
    public static final String COL_SUGGESTED_CAR_YEAR="ITEM_CAR_YEAR";
    public static final String COL_SUGGESTED_CAR_CONDITION="ITEM_CAR_CONDITION";
    public static final String COL_SUGGESTED_CAR_KILOMETERS="ITEM_CAR_KILOMETERS";
    public static final String COL_SUGGESTED_CAR_TRANSMISSION="ITEM_CAR_TRANSMISSION";
    public static final String COL_SUGGESTED_CAR_FUEL="ITEM_CAR_FUEL";
    public static final String COL_SUGGESTED_CAR_LICENSE="ITEM_CAR_LICENSE";
    public static final String COL_SUGGESTED_CAR_INSURANCE="ITEM_CAR_INSURANCE";
    public static final String COL_SUGGESTED_CAR_COLOR="ITEM_CAR_COLOR";
    public static final String COL_SUGGESTED_CAR_PAYMENT_METHOD="ITEM_CAR_PAYMENT_METHOD";
    public static final String COL_SUGGESTED_CAR_OPTIONS="ITEM_CAR_OPTIONS";
    public static final String COL_SUGGESTED_NUMBER_OF_COMMENT="ITEM_NUMBER_OF_COMMENT";
    public static final String COL_SUGGESTED_NUMBER_OF_IMAGE="ITEM_NUMBER_OF_IMAGE";
    public static final String COL_SUGGESTED_CITY="ITEM_CITY";
    public static final String COL_SUGGESTED_NEIGHBORHOOD="ITEM_NEIGHBORHOOD";
    public static final String COL_SUGGESTED_TIME_POST="ITEM_TIME_POST";
    public static final String COL_SUGGESTED_USER_PHONE_NUMBER="ITEM_USER_PHONE_NUMBER";
    public static final String COL_SUGGESTED_ITEM_NAME="ITEM_NAME";
    public static final String COL_SUGGESTED_ITEM_IMAGE="ITEM_IMAGE";
    public static final String COL_SUGGESTED_ITEM_DESCRIPTION="ITEM_DESCRIPTION";
    public static final String COL_SUGGESTED_USER_IMAGE="ITEM_USER_IMAGE";
    public static final String COL_SUGGESTED_USER_NAME="ITEM_USER_NAME";
    public static final String COL_SUGGESTED_ITEM_POST_EDIT="ITEM_POST_EDIT";
    public static final String COL_SUGGESTED_ITEM_NEW_PRICE="ITEM_NEW_PRICE";
    public static final String COL_SUGGESTED_ITEM_WHEELS_SIZE="ITEM_WHEELS_SIZE";
    public static final String COL_SUGGESTED_ITEM_CAR_PLATES_CITY="ITEM_CAR_PLATES_CITY";
    public static final String COL_SUGGESTED_ITEM_CAR_PLATES_NUMBER="ITEM_CAR_PLATES_NUMBER";
    public static final String COL_SUGGESTED_ITEM_CAR_PLATES_SPECIAL_OR_NOT="ITEM_CAR_PLATES_SPECIAL_OR_NOT";
    public static final String COL_SUGGESTED_ITEM_BURNED_PRICE="ITEM_BURNED_PRICE";
    public static final String COL_SUGGESTED_ITEM_PRICE="ITEM_PRICE";
    public static final String COL_SUGGESTED_ITEM_USER_ID="USER_ID";
    public static final String COL_SUGGESTED_ITEM_ACTIVE_OR_NOT="ITEM_NAME_ACTIVE_OR_NOT";

    public static final String TABLE_SIMILAR="item_similar_table";
    public static final String COL_SIMILAR_id="ID";
    public static final String COL_SIMILAR_OR_NOT="BOOST_OR_NOT";
    public static final String COL_SIMILAR_BOOST_TYPE="BOOST_TYPE";
    public static final String COL_SIMILAR_TYPE="TYPE";
    public static final String COL_SIMILAR_PERSON_GALLERY="PERSON_GALLERY";
    public static final String COL_SIMILAR_ID_IN_SERVER="ITEM_ID_IN_SERVER";
    public static final String COL_SIMILAR_CAR_MAKE="ITEM_CAR_MAKE";
    public static final String COL_SIMILAR_CAR_MODEL="ITEM_CAR_MODEL";
    public static final String COL_SIMILAR_CAR_YEAR="ITEM_CAR_YEAR";
    public static final String COL_SIMILAR_CAR_CONDITION="ITEM_CAR_CONDITION";
    public static final String COL_SIMILAR_CAR_KILOMETERS="ITEM_CAR_KILOMETERS";
    public static final String COL_SIMILAR_CAR_TRANSMISSION="ITEM_CAR_TRANSMISSION";
    public static final String COL_SIMILAR_CAR_FUEL="ITEM_CAR_FUEL";
    public static final String COL_SIMILAR_CAR_LICENSE="ITEM_CAR_LICENSE";
    public static final String COL_SIMILAR_CAR_INSURANCE="ITEM_CAR_INSURANCE";
    public static final String COL_SIMILAR_CAR_COLOR="ITEM_CAR_COLOR";
    public static final String COL_SIMILAR_CAR_PAYMENT_METHOD="ITEM_CAR_PAYMENT_METHOD";
    public static final String COL_SIMILAR_CAR_OPTIONS="ITEM_CAR_OPTIONS";
    public static final String COL_SIMILAR_NUMBER_OF_COMMENT="ITEM_NUMBER_OF_COMMENT";
    public static final String COL_SIMILAR_NUMBER_OF_IMAGE="ITEM_NUMBER_OF_IMAGE";
    public static final String COL_SIMILAR_CITY="ITEM_CITY";
    public static final String COL_SIMILAR_NEIGHBORHOOD="ITEM_NEIGHBORHOOD";
    public static final String COL_SIMILAR_TIME_POST="ITEM_TIME_POST";
    public static final String COL_SIMILAR_USER_PHONE_NUMBER="ITEM_USER_PHONE_NUMBER";
    public static final String COL_SIMILAR_ITEM_NAME="ITEM_NAME";
    public static final String COL_SIMILAR_ITEM_IMAGE="ITEM_IMAGE";
    public static final String COL_SIMILAR_ITEM_DESCRIPTION="ITEM_DESCRIPTION";
    public static final String COL_SIMILAR_USER_IMAGE="ITEM_USER_IMAGE";
    public static final String COL_SIMILAR_ITEM_USER_NAME="ITEM_USER_NAME";
    public static final String COL_SIMILAR_ITEM_POST_EDIT="ITEM_POST_EDIT";
    public static final String COL_SIMILAR_ITEM_NEW_PRICE="ITEM_NEW_PRICE";
    public static final String COL_SIMILAR_ITEM_WHEELS_SIZE="ITEM_WHEELS_SIZE";
    public static final String COL_SIMILAR_ITEM_CAR_PLATES_CITY="ITEM_CAR_PLATES_CITY";
    public static final String COL_SIMILAR_ITEM_CAR_PLATES_NUMBER="ITEM_CAR_PLATES_NUMBER";
    public static final String COL_SIMILAR_ITEM_CAR_PLATES_SPECIAL_OR_NOT="ITEM_CAR_PLATES_SPECIAL_OR_NOT";
    public static final String COL_SIMILAR_ITEM_BURNED_PRICE="ITEM_BURNED_PRICE";
    public static final String COL_SIMILAR_ITEM_PRICE="ITEM_PRICE";
    public static final String COL_SIMILAR_ITEM_USER_ID="USER_ID";
    public static final String COL_SIMILAR_ITEM_ACTIVE_OR_NOT="ITEM_NAME_ACTIVE_OR_NOT";

    public static final String TABLE_NOTIFICATION="notification_table";
    public static final String COL_NOTIFICATION_id="ID";
    public static final String COL_PROCESS= "PROCESS";
    public static final String OPEN_OR_NOT_YET= "OPEN_OR_NOT_YET";
    public static final String NOTIFICATION_TITLE= "NOTIFICATION_TITLE";
    public static final String PERSON_OR_GALLERY= "PERSON_OR_GALLERY";
    public static final String IMAGE_PATH= "IMAGE_PATH";
    public static final String PROCESS_IMAGE = "PROCESS_IMAGE";
    public static final String TIME_STAMP = "TIME_STAMP";
    public static final String ITEM_SERVER_ID = "ITEM_SERVER_ID";
    public static final String OUT_OR_COME = "OUT_OR_COME";
    public static final String AUCTION_OR_ITEM = "AUCTION_OR_ITEM";
    public static final String DATE = "DATE";

    public static final String TABLE_FOLLOWERS="following_table";
    public static final String COL_FOLLOWERS_id="ID";
    public static final String COL_FOLLOWERS_NAME= "NAME";
    public static final String COLO_FOLLOWERS_IMAGE= "IMAGE";
    public static final String COLO_FOLLOWERS_ID_IN_SERVER= "ID_IN_SERVER";
    public static final String COLO_FOLLOWERS_FOLLOWING_ID= "FOLLOWING_ID";
    public static final String COLO_FOLLOWERS_FOLLOWING_ID_IN_OTHER_SAID= "FOLLOWING_ID_IN_OTHER_SAID";


    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table "+TABLE_ITEM +" (ID INTEGER PRIMARY KEY AUTOINCREMENT," +
                "BOOST_OR_NOT TEXT" + ",BOOST_TYPE TEXT" + ",TYPE TEXT" + ",PERSON_GALLERY TEXT" + ",ITEM_ID_IN_SERVER TEXT" + ",ITEM_CAR_MAKE TEXT" + ",ITEM_CAR_MODEL TEXT" + ",ITEM_CAR_YEAR TEXT" + ",ITEM_CAR_CONDITION TEXT" + ",ITEM_CAR_KILOMETERS TEXT" + ",ITEM_CAR_TRANSMISSION TEXT" + ",ITEM_CAR_FUEL TEXT" + ",ITEM_CAR_LICENSE TEXT" + ",ITEM_CAR_INSURANCE TEXT" + ",ITEM_CAR_COLOR TEXT" + ",ITEM_CAR_PAYMENT_METHOD TEXT" + ",ITEM_CAR_OPTIONS TEXT" + ",ITEM_NUMBER_OF_COMMENT TEXT" + ",ITEM_NUMBER_OF_IMAGE TEXT" + ",ITEM_CITY TEXT" + ",ITEM_NEIGHBORHOOD TEXT" + ",ITEM_TIME_POST TEXT" + ",ITEM_USER_PHONE_NUMBER TEXT" + ",ITEM_NAME TEXT" + ",ITEM_IMAGE TEXT" + ",ITEM_DESCRIPTION TEXT" + ",ITEM_USER_IMAGE TEXT" + ",ITEM_USER_NAME TEXT" + ",ITEM_POST_EDIT TEXT" + ",ITEM_NEW_PRICE TEXT" + ",ITEM_WHEELS_SIZE TEXT" + ",ITEM_CAR_PLATES_CITY TEXT" + ",ITEM_CAR_PLATES_NUMBER TEXT" + ",ITEM_CAR_PLATES_SPECIAL_OR_NOT TEXT"+ ",ITEM_BURNED_PRICE TEXT"+ ",ITEM_PRICE TEXT"+ ",USER_ID TEXT" + ",ITEM_NAME_ACTIVE_OR_NOT TEXT)");

        db.execSQL("create table "+TABLE_SUGGESTED +" (ID INTEGER PRIMARY KEY AUTOINCREMENT," +
                "BOOST_OR_NOT TEXT" + ",BOOST_TYPE TEXT" + ",TYPE TEXT" + ",PERSON_GALLERY TEXT" + ",ITEM_ID_IN_SERVER TEXT" + ",ITEM_CAR_MAKE TEXT" + ",ITEM_CAR_MODEL TEXT" + ",ITEM_CAR_YEAR TEXT" + ",ITEM_CAR_CONDITION TEXT" + ",ITEM_CAR_KILOMETERS TEXT" + ",ITEM_CAR_TRANSMISSION TEXT" + ",ITEM_CAR_FUEL TEXT" + ",ITEM_CAR_LICENSE TEXT" + ",ITEM_CAR_INSURANCE TEXT" + ",ITEM_CAR_COLOR TEXT" + ",ITEM_CAR_PAYMENT_METHOD TEXT" + ",ITEM_CAR_OPTIONS TEXT" + ",ITEM_NUMBER_OF_COMMENT TEXT" + ",ITEM_NUMBER_OF_IMAGE TEXT" + ",ITEM_CITY TEXT" + ",ITEM_NEIGHBORHOOD TEXT" + ",ITEM_TIME_POST TEXT" + ",ITEM_USER_PHONE_NUMBER TEXT" + ",ITEM_NAME TEXT" + ",ITEM_IMAGE TEXT" + ",ITEM_DESCRIPTION TEXT" + ",ITEM_USER_IMAGE TEXT" + ",ITEM_USER_NAME TEXT" + ",ITEM_POST_EDIT TEXT" + ",ITEM_NEW_PRICE TEXT" + ",ITEM_WHEELS_SIZE TEXT" + ",ITEM_CAR_PLATES_CITY TEXT" + ",ITEM_CAR_PLATES_NUMBER TEXT" + ",ITEM_CAR_PLATES_SPECIAL_OR_NOT TEXT"+ ",ITEM_BURNED_PRICE TEXT"+ ",ITEM_PRICE TEXT"+ ",USER_ID TEXT" + ",ITEM_NAME_ACTIVE_OR_NOT TEXT)");

        db.execSQL("create table "+TABLE_NOTIFICATION +" (ID INTEGER PRIMARY KEY AUTOINCREMENT," +
                "PROCESS TEXT" + ",OPEN_OR_NOT_YET TEXT" + ",NOTIFICATION_TITLE TEXT"  + ",PERSON_OR_GALLERY TEXT" + ",IMAGE_PATH TEXT" + ",PROCESS_IMAGE TEXT" + ",TIME_STAMP TEXT"+ ",ITEM_SERVER_ID TEXT" + ",OUT_OR_COME TEXT" + ",AUCTION_OR_ITEM TEXT" + ",DATE TEXT)");

        db.execSQL("create table "+TABLE_ITEM_FCS +" (ID INTEGER PRIMARY KEY AUTOINCREMENT," +
                "ITEM_ID_IN_SERVER TEXT" +",CATEGORY TEXT" + ",FCS_TYPE TEXT)");

        db.execSQL("create table "+TABLE_CCEMT +" (ID INTEGER PRIMARY KEY AUTOINCREMENT," +
                "BOOST_OR_NOT TEXT" + ",BOOST_TYPE TEXT" + ",TYPE TEXT" + ",PERSON_GALLERY TEXT" + ",ITEM_ID_IN_SERVER TEXT" + ",ITEM_CAR_MAKE TEXT" + ",ITEM_CAR_MODEL TEXT" + ",ITEM_CAR_YEAR TEXT" + ",ITEM_CAR_CONDITION TEXT" + ",ITEM_CAR_KILOMETERS TEXT" + ",ITEM_CAR_TRANSMISSION TEXT" + ",ITEM_CAR_FUEL TEXT" + ",ITEM_CAR_LICENSE TEXT" + ",ITEM_CAR_INSURANCE TEXT" + ",ITEM_CAR_COLOR TEXT" + ",ITEM_CAR_PAYMENT_METHOD TEXT" + ",ITEM_CAR_OPTIONS TEXT" + ",ITEM_NUMBER_OF_COMMENT TEXT" + ",ITEM_NUMBER_OF_IMAGE TEXT" + ",ITEM_CITY TEXT" + ",ITEM_NEIGHBORHOOD TEXT" + ",ITEM_TIME_POST TEXT" + ",ITEM_USER_PHONE_NUMBER TEXT" + ",ITEM_NAME TEXT" + ",ITEM_IMAGE TEXT" + ",ITEM_DESCRIPTION TEXT" + ",ITEM_USER_IMAGE TEXT" + ",ITEM_USER_NAME TEXT" + ",ITEM_POST_EDIT TEXT" + ",ITEM_NEW_PRICE TEXT" + ",ITEM_BURNED_PRICE TEXT"+ ",ITEM_PRICE TEXT" + ",USER_ID TEXT" + ",ITEM_NAME_ACTIVE_OR_NOT TEXT" + ",ITEM_DATE TEXT"+",TIME_STAMP TEXT )");

        db.execSQL("create table "+TABLE_WHEELS_RIM +" (ID INTEGER PRIMARY KEY AUTOINCREMENT," +
                "BOOST_OR_NOT TEXT" + ",BOOST_TYPE TEXT" + ",PERSON_GALLERY TEXT" + ",ITEM_ID_IN_SERVER TEXT" + ",ITEM_WHEELS_SIZE TEXT" + ",ITEM_NUMBER_OF_COMMENT TEXT" + ",ITEM_NUMBER_OF_IMAGE TEXT" + ",ITEM_CITY TEXT" + ",ITEM_NEIGHBORHOOD TEXT" + ",ITEM_TIME_POST TEXT" + ",ITEM_USER_PHONE_NUMBER TEXT" + ",ITEM_NAME TEXT" + ",ITEM_IMAGE TEXT" + ",ITEM_DESCRIPTION TEXT" + ",ITEM_USER_IMAGE TEXT" + ",ITEM_USER_NAME TEXT" + ",ITEM_POST_EDIT TEXT" + ",ITEM_NEW_PRICE TEXT" + ",ITEM_BURNED_PRICE TEXT" + ",ITEM_PRICE TEXT"+ ",USER_ID TEXT" + ",ITEM_NAME_ACTIVE_OR_NOT TEXT" + ",ITEM_DATE TEXT"+",TIME_STAMP TEXT )");

        db.execSQL("create table "+TABLE_CAR_PLATES_RIM +" (ID INTEGER PRIMARY KEY AUTOINCREMENT," +
                "BOOST_OR_NOT TEXT" + ",BOOST_TYPE TEXT" + ",PERSON_GALLERY TEXT" + ",ITEM_ID_IN_SERVER TEXT" + ",ITEM_CAR_PLATES_CITY TEXT" + ",ITEM_CAR_PLATES_NUMBER TEXT" + ",ITEM_CAR_PLATES_SPECIAL_OR_NOT TEXT" + ",ITEM_NUMBER_OF_COMMENT TEXT" + ",ITEM_NUMBER_OF_IMAGE TEXT" + ",ITEM_CITY TEXT" + ",ITEM_NEIGHBORHOOD TEXT" + ",ITEM_TIME_POST TEXT" + ",ITEM_USER_PHONE_NUMBER TEXT" + ",ITEM_NAME TEXT" + ",ITEM_IMAGE TEXT" + ",ITEM_DESCRIPTION TEXT" + ",ITEM_USER_IMAGE TEXT" + ",ITEM_USER_NAME TEXT" + ",ITEM_POST_EDIT TEXT" + ",ITEM_NEW_PRICE TEXT" + ",ITEM_BURNED_PRICE TEXT" + ",ITEM_PRICE TEXT" + ",USER_ID TEXT" + ",ITEM_NAME_ACTIVE_OR_NOT TEXT" + ",ITEM_DATE TEXT"+",TIME_STAMP TEXT )");

        db.execSQL("create table "+TABLE_AccAndJunk +" (ID INTEGER PRIMARY KEY AUTOINCREMENT," +
                "BOOST_OR_NOT TEXT" + ",BOOST_TYPE TEXT" + ",TYPE TEXT" + ",PERSON_GALLERY TEXT" + ",ITEM_ID_IN_SERVER TEXT" + ",ITEM_NUMBER_OF_COMMENT TEXT" + ",ITEM_NUMBER_OF_IMAGE TEXT" + ",ITEM_CITY TEXT" + ",ITEM_NEIGHBORHOOD TEXT" + ",ITEM_TIME_POST TEXT" + ",ITEM_USER_PHONE_NUMBER TEXT" + ",ITEM_NAME TEXT" + ",ITEM_IMAGE TEXT" + ",ITEM_DESCRIPTION TEXT" + ",ITEM_USER_IMAGE TEXT" + ",ITEM_USER_NAME TEXT" + ",ITEM_POST_EDIT TEXT" + ",ITEM_NEW_PRICE TEXT" + ",ITEM_BURNED_PRICE TEXT" + ",ITEM_PRICE TEXT" + ",USER_ID TEXT" + ",ITEM_NAME_ACTIVE_OR_NOT TEXT" + ",ITEM_DATE TEXT"+",TIME_STAMP TEXT )");

        db.execSQL("create table "+TABLE_SIMILAR +" (ID INTEGER PRIMARY KEY AUTOINCREMENT," +
                "BOOST_OR_NOT TEXT" + ",BOOST_TYPE TEXT" + ",TYPE TEXT" + ",PERSON_GALLERY TEXT" + ",ITEM_ID_IN_SERVER TEXT" + ",ITEM_CAR_MAKE TEXT" + ",ITEM_CAR_MODEL TEXT" + ",ITEM_CAR_YEAR TEXT" + ",ITEM_CAR_CONDITION TEXT" + ",ITEM_CAR_KILOMETERS TEXT" + ",ITEM_CAR_TRANSMISSION TEXT" + ",ITEM_CAR_FUEL TEXT" + ",ITEM_CAR_LICENSE TEXT" + ",ITEM_CAR_INSURANCE TEXT" + ",ITEM_CAR_COLOR TEXT" + ",ITEM_CAR_PAYMENT_METHOD TEXT" + ",ITEM_CAR_OPTIONS TEXT" + ",ITEM_NUMBER_OF_COMMENT TEXT" + ",ITEM_NUMBER_OF_IMAGE TEXT" + ",ITEM_CITY TEXT" + ",ITEM_NEIGHBORHOOD TEXT" + ",ITEM_TIME_POST TEXT" + ",ITEM_USER_PHONE_NUMBER TEXT" + ",ITEM_NAME TEXT" + ",ITEM_IMAGE TEXT" + ",ITEM_DESCRIPTION TEXT" + ",ITEM_USER_IMAGE TEXT" + ",ITEM_USER_NAME TEXT" + ",ITEM_POST_EDIT TEXT" + ",ITEM_NEW_PRICE TEXT" + ",ITEM_WHEELS_SIZE TEXT" + ",ITEM_CAR_PLATES_CITY TEXT" + ",ITEM_CAR_PLATES_NUMBER TEXT" + ",ITEM_CAR_PLATES_SPECIAL_OR_NOT TEXT"+ ",ITEM_BURNED_PRICE TEXT"+ ",ITEM_PRICE TEXT" + ",USER_ID TEXT" + ",ITEM_NAME_ACTIVE_OR_NOT TEXT)");

        db.execSQL("create table "+TABLE_FOLLOWERS +" (ID INTEGER PRIMARY KEY AUTOINCREMENT," +
                "NAME TEXT" + ",IMAGE TEXT" + ",ID_IN_SERVER TEXT" + ",FOLLOWING_ID TEXT" + ",FOLLOWING_ID_IN_OTHER_SAID TEXT)");

        db.execSQL("create table "+TABLE_DRIVER_INFORMATION +" (ID INTEGER PRIMARY KEY AUTOINCREMENT," +
                "PROCESS_TYPE_S TEXT" + ",PROCESS_TYPE TEXT" + ",PROCESS_CONTENT TEXT" + ",PROCESS_CONTENT_S TEXT" + ",PROCESS_STATUS TEXT)");

        db.execSQL("create table "+TABLE_CAR_DETAILS +" (ID INTEGER PRIMARY KEY AUTOINCREMENT," +
                "PROCESS_TYPE_S TEXT" + ",PROCESS_TYPE TEXT" + ",PROCESS_CONTENT TEXT" + ",PROCESS_CONTENT_S TEXT" + ",PROCESS_STATUS TEXT)");

        db.execSQL("create table "+TABLE_CITYS +" (COL_ID INTEGER PRIMARY KEY AUTOINCREMENT," +
                "ID TEXT" + ",CODE TEXT" + ",NAME TEXT" + ",NAME_EN TEXT" + ",NAME_AR TEXT)");

        db.execSQL("create table "+TABLE_AREAS +" (COL_ID INTEGER PRIMARY KEY AUTOINCREMENT," +
                "ID TEXT" + ",NAME TEXT" + ",NAME_EN TEXT" +",NAME_AR TEXT" +",CITY_ID TEXT" +",CITY_CODE TEXT" +",CITY_NAME TEXT" +",CITY_NAME_EN TEXT" + ",CITY_NAME_AR TEXT)");

        db.execSQL("create table "+TABLE_CARS_BRAND +" (COL_ID INTEGER PRIMARY KEY AUTOINCREMENT," +
                "ID TEXT" + ",CODE TEXT" + ",NAME_EN TEXT" + ",NAME_AR TEXT)");

        db.execSQL("create table "+TABLE_CARS_MODEL +" (COL_ID INTEGER PRIMARY KEY AUTOINCREMENT," +
                "BRAND_ID TEXT" + ",BRAND_NAME TEXT" + ",BRAND_NAME_EN TEXT" +",BRAND_NAME_AR TEXT" +",MODEL_ID TEXT" +",MODEL_NAME TEXT" +",MODEL_NAME_EN TEXT" + ",MODEL_NAME_AR TEXT)");

        db.execSQL("create table "+TABLE_MODEL_SETTING +" (COL_ID INTEGER PRIMARY KEY AUTOINCREMENT," +
                "SETTING_ID TEXT" + ",SETTING_CODE TEXT" + ",SETTING_NAME TEXT" + ",SETTING_NAME_EN TEXT" + ",SETTING_NAME_AR TEXT" +",SETTING_CONTENT_ID TEXT" +",SETTING_CONTENT_CODE TEXT" +",SETTING_CONTENT_NAME TEXT" +",SETTING_CONTENT_NAME_EN TEXT" + ",SETTING_CONTENT_NAME_AR TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_ITEM);
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_SUGGESTED);
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NOTIFICATION);
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_ITEM_FCS);
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_CCEMT);
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_WHEELS_RIM);
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_CAR_PLATES_RIM);
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_AccAndJunk);
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_SIMILAR);
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_FOLLOWERS);
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_DRIVER_INFORMATION);
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_CAR_DETAILS);

        db.execSQL("DROP TABLE IF EXISTS "+TABLE_CITYS);
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_AREAS);

        db.execSQL("DROP TABLE IF EXISTS "+TABLE_CARS_BRAND);
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_CARS_MODEL);
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_MODEL_SETTING);

        onCreate(db);
    }

    ///////////////////////insert data//////////////////////////////////////////

    public boolean insertSetting(String setting_id,String setting_code,String setting_name,String setting_name_en,String setting_name_ar
            ,String setting_content_id,String setting_content_code,String setting_content_name,String setting_content_name_en,String setting_content_name_ar)
    {
        SQLiteDatabase db =this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(TABLE_MODEL_SETTING_ID,setting_id);
        contentValues.put(TABLE_MODEL_SETTING_CODE,setting_code);
        contentValues.put(TABLE_MODEL_SETTING_NAME,setting_name);
        contentValues.put(TABLE_MODEL_SETTING_NAME_EN,setting_name_en);
        contentValues.put(TABLE_MODEL_SETTING_NAME_AR,setting_name_ar);
        contentValues.put(TABLE_MODEL_SETTING_CONTENT_ID,setting_content_id);
        contentValues.put(TABLE_MODEL_SETTING_CONTENT_CODE,setting_content_code);
        contentValues.put(TABLE_MODEL_SETTING_CONTENT_NAME,setting_content_name);
        contentValues.put(TABLE_MODEL_SETTING_CONTENT_NAME_EN,setting_content_name_en);
        contentValues.put(TABLE_MODEL_SETTING_CONTENT_NAME_AR,setting_content_name_ar);


        db.insert(TABLE_MODEL_SETTING,null,contentValues);
//        if(result == -1)
//            return false;
//        else
            return true;
    }

    public boolean insertCarsBrand(String id,String name
            ,String name_en,String name_ar)
    {
        SQLiteDatabase db =this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_BRAND_ID,id);
        contentValues.put(COL_BRAND_NAME,name);
        contentValues.put(COL_BRAND_NAME_EN,name_en);
        contentValues.put(COL_BRAND_NAME_AR,name_ar);

        db.insert(TABLE_CARS_BRAND,null,contentValues);
//        if(result == -1)
//            return false;
//        else
            return true;
    }

    public boolean insertCarsModel(String id,String name
            ,String name_en,String name_ar,String model_id,String model_name,String model_name_en,String model_name_ar)
    {
        SQLiteDatabase db =this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_MODEL_BRAND_ID,id);
        contentValues.put(COL_MODEL_BRAND_NAME,name);
        contentValues.put(COL_MODEL_BRAND_NAME_EN,name_en);
        contentValues.put(COL_MODEL_BRAND_NAME_AR,name_ar);
        contentValues.put(COL_MODEL_ID,model_id);
        contentValues.put(COL_MODEL_NAME,model_name);
        contentValues.put(COL_MODEL_NAME_EN,model_name_en);
        contentValues.put(COL_MODEL_NAME_AR,model_name_ar);

        db.insert(TABLE_CARS_MODEL,null,contentValues);
//        if(result == -1)
//            return false;
//        else
            return true;
    }

    public boolean insertCites(String id,String code
            ,String name,String name_en,String name_ar)
    {
        SQLiteDatabase db =this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_CITY_ID,id);
        contentValues.put(COL_CITY_CODE,code);
        contentValues.put(COL_CITY_NAME,name);
        contentValues.put(COL_CITY_NAME_EN,name_en);
        contentValues.put(COL_CITY_NAME_AR,name_ar);

        db.insert(TABLE_CITYS,null,contentValues);
//        if(result == -1)
//            return false;
//        else
            return true;
    }

    public boolean insertAreas(String id,String name
            ,String name_en,String name_ar,String city_id,String city_code,String city_name,String city_name_en,String city_name_ar)
    {
        SQLiteDatabase db =this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_AREA_ID,id);
        contentValues.put(COL_AREA_Name,name);
        contentValues.put(COL_AREA_NAME_EN,name_en);
        contentValues.put(COL_AREA_NAME_AR,name_ar);
        contentValues.put(COL_AREA_CITY_ID,city_id);
        contentValues.put(COL_AREA_CITY_CODE,city_code);
        contentValues.put(COL_AREA_CITY_NAME,city_name);
        contentValues.put(COL_AREA_CITY_NAME_EN,city_name_en);
        contentValues.put(COL_AREA_CITY_NAME_AR,city_name_ar);

        db.insert(TABLE_AREAS,null,contentValues);
//        if(result == -1)
//            return false;
//        else
            return true;
    }

    public boolean insertDataItem(String boostOrNot,String itemBoostType
            ,String itemType,String itemPersonGallery,String itemIdInServer,String itemCarMake,String itemCarModel,String itemCarYear,String itemCarCondition,String itemCarKilometers,String itemCarTransmission,String itemCarFuel,String itemCarLicense,String itemCarInsurance,String itemCarColor,String itemCarPaymentMethod,String itemCarOptions,String itemNumberOfComment,String itemNumberOfImage,String itemCity,String itemNeighborhood,String itemTimePost,String itemUserPhoneNumber,String itemName,String itemImage,String itemDescription,String userImage,String userName,String itemPostEdit,String itemNewPrice,String itemWheelsSize,String itemCarPlatesCity,String itemCarPlatesNumber,String itemCarPlatesSpecial,String itemBurnedPrice,String itemPrice,String userID,String itemActiveOrNot)
    {
        SQLiteDatabase db =this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_ITEM_BOOST_OR_NOT,boostOrNot);
        contentValues.put(COL_ITEM_BOOST_TYPE,itemBoostType);
        contentValues.put(COL_ITEM_TYPE,itemType);
        contentValues.put(COL_ITEM_PERSON_GALLERY,itemPersonGallery);
        contentValues.put(COL_ITEM_ID_IN_SERVER,itemIdInServer);
        contentValues.put(COL_ITEM_CAR_MAKE,itemCarMake);
        contentValues.put(COL_ITEM_CAR_MODEL,itemCarModel);
        contentValues.put(COL_ITEM_CAR_YEAR,itemCarYear);
        contentValues.put(COL_ITEM_CAR_CONDITION,itemCarCondition);
        contentValues.put(COL_ITEM_CAR_KILOMETERS,itemCarKilometers);
        contentValues.put(COL_ITEM_CAR_TRANSMISSION,itemCarTransmission);
        contentValues.put(COL_ITEM_CAR_FUEL,itemCarFuel);
        contentValues.put(COL_ITEM_CAR_LICENSE,itemCarLicense);
        contentValues.put(COL_ITEM_CAR_INSURANCE,itemCarInsurance);
        contentValues.put(COL_ITEM_CAR_COLOR,itemCarColor);
        contentValues.put(COL_ITEM_CAR_PAYMENT_METHOD,itemCarPaymentMethod);
        contentValues.put(COL_ITEM_CAR_OPTIONS,itemCarOptions);
        contentValues.put(COL_ITEM_NUMBER_OF_COMMENT,itemNumberOfComment);
        contentValues.put(COL_ITEM_NUMBER_OF_IMAGE,itemNumberOfImage);
        contentValues.put(COL_ITEM_CITY,itemCity);
        contentValues.put(COL_ITEM_NEIGHBORHOOD,itemNeighborhood);
        contentValues.put(COL_ITEM_TIME_POST,itemTimePost);
        contentValues.put(COL_ITEM_USER_PHONE_NUMBER,itemUserPhoneNumber);
        contentValues.put(COL_ITEM_ITEM_NAME,itemName);
        contentValues.put(COL_ITEM_ITEM_IMAGE,itemImage);
        contentValues.put(COL_ITEM_ITEM_DESCRIPTION,itemDescription);
        contentValues.put(COL_ITEM_USER_IMAGE,userImage);
        contentValues.put(COL_ITEM_ITEM_USER_NAME,userName);
        contentValues.put(COL_ITEM_ITEM_POST_EDIT,itemPostEdit);
        contentValues.put(COL_ITEM_ITEM_NEW_PRICE,itemNewPrice);
        contentValues.put(COL_ITEM_ITEM_WHEELS_SIZE,itemWheelsSize);
        contentValues.put(COL_ITEM_ITEM_CAR_PLATES_CITY,itemCarPlatesCity);
        contentValues.put(COL_ITEM_ITEM_CAR_PLATES_NUMBER,itemCarPlatesNumber);
        contentValues.put(COL_ITEM_ITEM_CAR_PLATES_SPECIAL_OR_NOT,itemCarPlatesSpecial);
        contentValues.put(COL_ITEM_ITEM_BURNED_PRICE,itemBurnedPrice);
        contentValues.put(COL_ITEM_ITEM_PRICE,itemPrice);
        contentValues.put(COL_ITEM_USER_ID,userID);
        contentValues.put(COL_ITEM_ITEM_ACTIVE_OR_NOT,itemActiveOrNot);

//        long result= db.insert(TABLE_ITEM,null,contentValues);
//        if(result == -1)
//            return false;
//        else
            return true;
    }

    public boolean insertDataSuggested(String boostOrNot,String itemBoostType
            ,String itemType,String itemPersonGallery,String itemIdInServer,String itemCarMake,String itemCarModel,String itemCarYear,String itemCarCondition,String itemCarKilometers,String itemCarTransmission,String itemCarFuel,String itemCarLicense,String itemCarInsurance,String itemCarColor,String itemCarPaymentMethod,String itemCarOptions,String itemNumberOfComment,String itemNumberOfImage,String itemCity,String itemNeighborhood,String itemTimePost,String itemUserPhoneNumber,String itemName,String itemImage,String itemDescription,String userImage,String userName,String itemPostEdit,String itemNewPrice,String itemWheelsSize,String itemCarPlatesCity,String itemCarPlatesNumber,String itemCarPlatesSpecial,String itemBurnedPrice,String itemPrice,String userID,String itemActiveOrNot)
    {
        SQLiteDatabase db =this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_SUGGESTED_BOOST_OR_NOT,boostOrNot);
        contentValues.put(COL_SUGGESTED_BOOST_TYPE,itemBoostType);
        contentValues.put(COL_SUGGESTED_TYPE,itemType);
        contentValues.put(COL_SUGGESTED_PERSON_GALLERY,itemPersonGallery);
        contentValues.put(COL_SUGGESTED_ID_IN_SERVER,itemIdInServer);
        contentValues.put(COL_SUGGESTED_CAR_MAKE,itemCarMake);
        contentValues.put(COL_SUGGESTED_CAR_MODEL,itemCarModel);
        contentValues.put(COL_SUGGESTED_CAR_YEAR,itemCarYear);
        contentValues.put(COL_SUGGESTED_CAR_CONDITION,itemCarCondition);
        contentValues.put(COL_SUGGESTED_CAR_KILOMETERS,itemCarKilometers);
        contentValues.put(COL_SUGGESTED_CAR_TRANSMISSION,itemCarTransmission);
        contentValues.put(COL_SUGGESTED_CAR_FUEL,itemCarFuel);
        contentValues.put(COL_SUGGESTED_CAR_LICENSE,itemCarLicense);
        contentValues.put(COL_SUGGESTED_CAR_INSURANCE,itemCarInsurance);
        contentValues.put(COL_SUGGESTED_CAR_COLOR,itemCarColor);
        contentValues.put(COL_SUGGESTED_CAR_PAYMENT_METHOD,itemCarPaymentMethod);
        contentValues.put(COL_SUGGESTED_CAR_OPTIONS,itemCarOptions);
        contentValues.put(COL_SUGGESTED_NUMBER_OF_COMMENT,itemNumberOfComment);
        contentValues.put(COL_SUGGESTED_NUMBER_OF_IMAGE,itemNumberOfImage);
        contentValues.put(COL_SUGGESTED_CITY,itemCity);
        contentValues.put(COL_SUGGESTED_NEIGHBORHOOD,itemNeighborhood);
        contentValues.put(COL_SUGGESTED_TIME_POST,itemTimePost);
        contentValues.put(COL_SUGGESTED_USER_PHONE_NUMBER,itemUserPhoneNumber);
        contentValues.put(COL_SUGGESTED_ITEM_NAME,itemName);
        contentValues.put(COL_SUGGESTED_ITEM_IMAGE,itemImage);
        contentValues.put(COL_SUGGESTED_ITEM_DESCRIPTION,itemDescription);
        contentValues.put(COL_SUGGESTED_USER_IMAGE,userImage);
        contentValues.put(COL_SUGGESTED_USER_NAME,userName);
        contentValues.put(COL_SUGGESTED_ITEM_POST_EDIT,itemPostEdit);
        contentValues.put(COL_SUGGESTED_ITEM_NEW_PRICE,itemNewPrice);
        contentValues.put(COL_SUGGESTED_ITEM_WHEELS_SIZE,itemWheelsSize);
        contentValues.put(COL_SUGGESTED_ITEM_CAR_PLATES_CITY,itemCarPlatesCity);
        contentValues.put(COL_SUGGESTED_ITEM_CAR_PLATES_NUMBER,itemCarPlatesNumber);
        contentValues.put(COL_SUGGESTED_ITEM_CAR_PLATES_SPECIAL_OR_NOT,itemCarPlatesSpecial);
        contentValues.put(COL_SUGGESTED_ITEM_BURNED_PRICE,itemBurnedPrice);
        contentValues.put(COL_SUGGESTED_ITEM_PRICE,itemPrice);
        contentValues.put(COL_SUGGESTED_ITEM_USER_ID,userID);
        contentValues.put(COL_SUGGESTED_ITEM_ACTIVE_OR_NOT,itemActiveOrNot);

        long result= db.insert(TABLE_SUGGESTED,null,contentValues);
        if(result == -1)
            return false;
        else
            return true;
    }

    public boolean insertSimilarAds(String boostOrNot,String itemBoostType
            ,String itemType,String itemPersonGallery,String itemIdInServer,String itemCarMake,String itemCarModel,String itemCarYear,String itemCarCondition,String itemCarKilometers,String itemCarTransmission,String itemCarFuel,String itemCarLicense,String itemCarInsurance,String itemCarColor,String itemCarPaymentMethod,String itemCarOptions,String itemNumberOfComment,String itemNumberOfImage,String itemCity,String itemNeighborhood,String itemTimePost,String itemUserPhoneNumber,String itemName,String itemImage,String itemDescription,String userImage,String userName,String itemPostEdit,String itemNewPrice,String itemWheelsSize,String itemCarPlatesCity,String itemCarPlatesNumber,String itemCarPlatesSpecial,String itemBurnedPrice,String itemPrice,String userID,String itemActiveOrNot)
    {
        SQLiteDatabase db =this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_SIMILAR_OR_NOT,boostOrNot);
        contentValues.put(COL_SIMILAR_BOOST_TYPE,itemBoostType);
        contentValues.put(COL_SIMILAR_TYPE,itemType);
        contentValues.put(COL_SIMILAR_PERSON_GALLERY,itemPersonGallery);
        contentValues.put(COL_SIMILAR_ID_IN_SERVER,itemIdInServer);
        contentValues.put(COL_SIMILAR_CAR_MAKE,itemCarMake);
        contentValues.put(COL_SIMILAR_CAR_MODEL,itemCarModel);
        contentValues.put(COL_SIMILAR_CAR_YEAR,itemCarYear);
        contentValues.put(COL_SIMILAR_CAR_CONDITION,itemCarCondition);
        contentValues.put(COL_SIMILAR_CAR_KILOMETERS,itemCarKilometers);
        contentValues.put(COL_SIMILAR_CAR_TRANSMISSION,itemCarTransmission);
        contentValues.put(COL_SIMILAR_CAR_FUEL,itemCarFuel);
        contentValues.put(COL_SIMILAR_CAR_LICENSE,itemCarLicense);
        contentValues.put(COL_SIMILAR_CAR_INSURANCE,itemCarInsurance);
        contentValues.put(COL_SIMILAR_CAR_COLOR,itemCarColor);
        contentValues.put(COL_SIMILAR_CAR_PAYMENT_METHOD,itemCarPaymentMethod);
        contentValues.put(COL_SIMILAR_CAR_OPTIONS,itemCarOptions);
        contentValues.put(COL_SIMILAR_NUMBER_OF_COMMENT,itemNumberOfComment);
        contentValues.put(COL_SIMILAR_NUMBER_OF_IMAGE,itemNumberOfImage);
        contentValues.put(COL_SIMILAR_CITY,itemCity);
        contentValues.put(COL_SIMILAR_NEIGHBORHOOD,itemNeighborhood);
        contentValues.put(COL_SIMILAR_TIME_POST,itemTimePost);
        contentValues.put(COL_SIMILAR_USER_PHONE_NUMBER,itemUserPhoneNumber);
        contentValues.put(COL_SIMILAR_ITEM_NAME,itemName);
        contentValues.put(COL_SIMILAR_ITEM_IMAGE,itemImage);
        contentValues.put(COL_SIMILAR_ITEM_DESCRIPTION,itemDescription);
        contentValues.put(COL_SIMILAR_USER_IMAGE,userImage);
        contentValues.put(COL_SIMILAR_ITEM_USER_NAME,userName);
        contentValues.put(COL_SIMILAR_ITEM_POST_EDIT,itemPostEdit);
        contentValues.put(COL_SIMILAR_ITEM_NEW_PRICE,itemNewPrice);
        contentValues.put(COL_SIMILAR_ITEM_WHEELS_SIZE,itemWheelsSize);
        contentValues.put(COL_SIMILAR_ITEM_CAR_PLATES_CITY,itemCarPlatesCity);
        contentValues.put(COL_SIMILAR_ITEM_CAR_PLATES_NUMBER,itemCarPlatesNumber);
        contentValues.put(COL_SIMILAR_ITEM_CAR_PLATES_SPECIAL_OR_NOT,itemCarPlatesSpecial);
        contentValues.put(COL_SIMILAR_ITEM_BURNED_PRICE,itemBurnedPrice);
        contentValues.put(COL_SIMILAR_ITEM_PRICE,itemPrice);
        contentValues.put(COL_SIMILAR_ITEM_USER_ID,userID);
        contentValues.put(COL_SIMILAR_ITEM_ACTIVE_OR_NOT,itemActiveOrNot);

        long result= db.insert(TABLE_SIMILAR,null,contentValues);
        if(result == -1)
            return false;
        else
            return true;
    }

    public boolean insertNotification(String process,String openOrNotYet
            ,String notificationTitle,String personOrGallery,String imagePath,String processImage,String timeStamp,String itemIdInServer,String com_or_out,String auctionOrItem,String date)
    {
        SQLiteDatabase db =this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_PROCESS,process);
        contentValues.put(OPEN_OR_NOT_YET,openOrNotYet);
        contentValues.put(NOTIFICATION_TITLE,notificationTitle);
        contentValues.put(PERSON_OR_GALLERY,personOrGallery);
        contentValues.put(IMAGE_PATH,imagePath);
        contentValues.put(PROCESS_IMAGE,processImage);
        contentValues.put(TIME_STAMP,timeStamp);
        contentValues.put(ITEM_SERVER_ID,com_or_out);
        contentValues.put(OUT_OR_COME,itemIdInServer);
        contentValues.put(AUCTION_OR_ITEM,auctionOrItem);
        contentValues.put(DATE,date);

        long result= db.insert(TABLE_NOTIFICATION,null,contentValues);
        if(result == -1)
            return false;
        else
            return true;
    }

    public boolean insertDataFCSItem(String itemIdInServer,String category,String fcsType)
    {
        SQLiteDatabase db =this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_ITEM_FCS_ID_IN_SERVER,itemIdInServer);
        contentValues.put(COL_ITEM_FCS_CATEGORY,category);
        contentValues.put(COL_ITEM_FCS_TYPE_FCS,fcsType);

        long result= db.insert(TABLE_ITEM_FCS,null,contentValues);
        if(result == -1)
            return false;
        else
            return true;
    }

    public boolean CheckIsDataAlreadyInDBorNot(String fieldValue) {
        SQLiteDatabase db =this.getWritableDatabase();
        String Query = "Select * from " + TABLE_ITEM_FCS + " where " + COL_ITEM_FCS_ID_IN_SERVER
                + " = ?;" + fieldValue;
        Cursor cursor = db.rawQuery(Query,  new String[]{fieldValue});
        if(cursor.getCount() <= 0){
            cursor.close();
            return false;
        }
        cursor.close();
        return true;
    }

    public boolean insertDataCCEMTItem(String boostOrNot,String itemBoostType
            ,String itemType,String itemPersonGallery,String itemIdInServer,String itemCarMake,String itemCarModel,String itemCarYear,String itemCarCondition,String itemCarKilometers,String itemCarTransmission,String itemCarFuel,String itemCarLicense,String itemCarInsurance,String itemCarColor,String itemCarPaymentMethod,String itemCarOptions,String itemNumberOfComment,String itemNumberOfImage,String itemCity,String itemNeighborhood,String itemTimePost,String itemUserPhoneNumber,String itemName,String itemImage,String itemDescription,String userImage,String userName,String itemPostEdit,String itemNewPrice,String itemBurnedPrice,String itemPrice,String userID,String itemActiveOrNot,String date,String timeStamp)
    {
        SQLiteDatabase db =this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_CCEMT_BOOST_OR_NOT,boostOrNot);
        contentValues.put(COL_CCEMT_BOOST_TYPE,itemBoostType);
        contentValues.put(COL_CCEMT_TYPE,itemType);
        contentValues.put(COL_CCEMT_PERSON_GALLERY,itemPersonGallery);
        contentValues.put(COL_CCEMT_ID_IN_SERVER,itemIdInServer);
        contentValues.put(COL_CCEMT_CAR_MAKE,itemCarMake);
        contentValues.put(COL_CCEMT_CAR_MODEL,itemCarModel);
        contentValues.put(COL_CCEMT_CAR_YEAR,itemCarYear);
        contentValues.put(COL_CCEMT_CAR_CONDITION,itemCarCondition);
        contentValues.put(COL_CCEMT_CAR_KILOMETERS,itemCarKilometers);
        contentValues.put(COL_CCEMT_CAR_TRANSMISSION,itemCarTransmission);
        contentValues.put(COL_CCEMT_CAR_FUEL,itemCarFuel);
        contentValues.put(COL_CCEMT_CAR_LICENSE,itemCarLicense);
        contentValues.put(COL_CCEMT_CAR_INSURANCE,itemCarInsurance);
        contentValues.put(COL_CCEMT_CAR_COLOR,itemCarColor);
        contentValues.put(COL_CCEMT_CAR_PAYMENT_METHOD,itemCarPaymentMethod);
        contentValues.put(COL_CCEMT_CAR_OPTIONS,itemCarOptions);
        contentValues.put(COL_CCEMT_NUMBER_OF_COMMENT,itemNumberOfComment);
        contentValues.put(COL_CCEMT_NUMBER_OF_IMAGE,itemNumberOfImage);
        contentValues.put(COL_CCEMT_CITY,itemCity);
        contentValues.put(COL_CCEMT_NEIGHBORHOOD,itemNeighborhood);
        contentValues.put(COL_CCEMT_TIME_POST,itemTimePost);
        contentValues.put(COL_CCEMT_USER_PHONE_NUMBER,itemUserPhoneNumber);
        contentValues.put(COL_CCEMT_ITEM_NAME,itemName);
        contentValues.put(COL_CCEMT_ITEM_IMAGE,itemImage);
        contentValues.put(COL_CCEMT_ITEM_DESCRIPTION,itemDescription);
        contentValues.put(COL_CCEMT_USER_IMAGE,userImage);
        contentValues.put(COL_CCEMT_ITEM_USER_NAME,userName);
        contentValues.put(COL_CCEMT_ITEM_POST_EDIT,itemPostEdit);
        contentValues.put(COL_CCEMT_ITEM_NEW_PRICE,itemNewPrice);
        contentValues.put(COL_CCEMT_ITEM_BURNED_PRICE,itemBurnedPrice);
        contentValues.put(COL_CCEMT_ITEM_PRICE,itemPrice);
        contentValues.put(COL_CCEMT_USER_ID,userID);
        contentValues.put(COL_CCEMT_ITEM_ACTIVE_OR_NOT,itemActiveOrNot);
        contentValues.put(COL_CCEMT_ITEM_DATE,date);
        contentValues.put(COL_CCEMT_ITEM_TIME_STAMP,timeStamp);

        long result= db.insert(TABLE_CCEMT,null,contentValues);
        if(result == -1)
            return false;
        else
            return true;
    }

    public boolean insertDataWheels_RimItem(String boostOrNot,String itemBoostType
            ,String itemPersonGallery,String itemIdInServer,String wheelsSize,String itemNumberOfComment,String itemNumberOfImage,String itemCity,String itemNeighborhood,String itemTimePost,String itemUserPhoneNumber,String itemName,String itemImage,String itemDescription,String userImage,String userName,String itemPostEdit,String itemNewPrice,String itemBurnedPrice,String itemPrice,String userID,String itemActiveOrNot,String date,String timeStamp)
    {
        SQLiteDatabase db =this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_WHEELS_RIM_BOOST_OR_NOT,boostOrNot);
        contentValues.put(COL_WHEELS_RIM_BOOST_TYPE,itemBoostType);
        contentValues.put(COL_WHEELS_RIM_PERSON_GALLERY,itemPersonGallery);
        contentValues.put(COL_WHEELS_RIM_ID_IN_SERVER,itemIdInServer);
        contentValues.put(COL_WHEELS_RIM_WHEELS_SIZE,wheelsSize);
        contentValues.put(COL_WHEELS_RIM_NUMBER_OF_COMMENT,itemNumberOfComment);
        contentValues.put(COL_WHEELS_RIM_NUMBER_OF_IMAGE,itemNumberOfImage);
        contentValues.put(COL_WHEELS_RIM_CITY,itemCity);
        contentValues.put(COL_WHEELS_RIM_NEIGHBORHOOD,itemNeighborhood);
        contentValues.put(COL_WHEELS_RIM_TIME_POST,itemTimePost);
        contentValues.put(COL_WHEELS_RIM_USER_PHONE_NUMBER,itemUserPhoneNumber);
        contentValues.put(COL_WHEELS_RIM_ITEM_NAME,itemName);
        contentValues.put(COL_WHEELS_RIM_ITEM_IMAGE,itemImage);
        contentValues.put(COL_WHEELS_RIM_ITEM_DESCRIPTION,itemDescription);
        contentValues.put(COL_WHEELS_RIM_USER_IMAGE,userImage);
        contentValues.put(COL_WHEELS_RIM_ITEM_USER_NAME,userName);
        contentValues.put(COL_WHEELS_RIM_ITEM_POST_EDIT,itemPostEdit);
        contentValues.put(COL_WHEELS_RIM_ITEM_NEW_PRICE,itemNewPrice);
        contentValues.put(COL_WHEELS_RIM_ITEM_BURNED_PRICE,itemBurnedPrice);
        contentValues.put(COL_WHEELS_RIM_ITEM_PRICE,itemPrice);
        contentValues.put(COL_WHEELS_RIM_USER_ID,userID);
        contentValues.put(COL_WHEELS_RIM_ITEM_ACTIVE_OR_NOT,itemActiveOrNot);
        contentValues.put(COL_WHEELS_RIM_DATE,date);
        contentValues.put(COL_WHEELS_RIM_TIME_STAMP,timeStamp);

        long result= db.insert(TABLE_WHEELS_RIM,null,contentValues);
        if(result == -1)
            return false;
        else
            return true;
    }

    public boolean insertDataCarPlatesItem(String boostOrNot,String itemBoostType
            ,String itemPersonGallery,String itemIdInServer,String platesCity,String platesNumber,String specialOrNot,String itemNumberOfComment,String itemNumberOfImage,String itemCity,String itemNeighborhood,String itemTimePost,String itemUserPhoneNumber,String itemName,String itemImage,String itemDescription,String userImage,String userName,String itemPostEdit,String itemNewPrice,String itemBurnedPrice,String itemPrice,String userID,String itemActiveOrNot,String date,String timeStamp)
    {
        SQLiteDatabase db =this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_CAR_PLATES_BOOST_OR_NOT,boostOrNot);
        contentValues.put(COL_CAR_PLATES_BOOST_TYPE,itemBoostType);
        contentValues.put(COL_CAR_PLATES_PERSON_GALLERY,itemPersonGallery);
        contentValues.put(COL_CAR_PLATES_ID_IN_SERVER,itemIdInServer);

        contentValues.put(COL_CAR_PLATES_PLATES_CITY,platesCity);
        contentValues.put(COL_CAR_PLATES_PLATES_NUMBER,platesNumber);
        contentValues.put(COL_CAR_PLATES_PLATES_SPECIAL_OR_NOT,specialOrNot);

        contentValues.put(COL_CAR_PLATES_NUMBER_OF_COMMENT,itemNumberOfComment);
        contentValues.put(COL_CAR_PLATES_NUMBER_OF_IMAGE,itemNumberOfImage);
        contentValues.put(COL_CAR_PLATES_CITY,itemCity);
        contentValues.put(COL_CAR_PLATES_NEIGHBORHOOD,itemNeighborhood);
        contentValues.put(COL_CAR_PLATES_TIME_POST,itemTimePost);
        contentValues.put(COL_CAR_PLATES_USER_PHONE_NUMBER,itemUserPhoneNumber);
        contentValues.put(COL_CAR_PLATES_ITEM_NAME,itemName);
        contentValues.put(COL_CAR_PLATES_ITEM_IMAGE,itemImage);
        contentValues.put(COL_CAR_PLATES_ITEM_DESCRIPTION,itemDescription);
        contentValues.put(COL_CAR_PLATES_USER_IMAGE,userImage);
        contentValues.put(COL_CAR_PLATES_ITEM_USER_NAME,userName);
        contentValues.put(COL_CAR_PLATES_ITEM_POST_EDIT,itemPostEdit);
        contentValues.put(COL_CAR_PLATES_ITEM_NEW_PRICE,itemNewPrice);
        contentValues.put(COL_CAR_PLATES_ITEM_BURNED_PRICE,itemBurnedPrice);
        contentValues.put(COL_CAR_PLATES_ITEM_PRICE,itemPrice);
        contentValues.put(COL_CAR_PLATES_ITEM_USER_ID,userID);
        contentValues.put(COL_CAR_PLATES_ITEM_ACTIVE_OR_NOT,itemActiveOrNot);
        contentValues.put(COL_CAR_PLATES_DATE,date);
        contentValues.put(COL_CAR_PLATES_TIME_STAMP,timeStamp);

        long result= db.insert(TABLE_CAR_PLATES_RIM,null,contentValues);
        if(result == -1)
            return false;
        else
            return true;
    }

    public boolean insertDataAccAndJunkItem(String boostOrNot,String itemBoostType
            ,String type,String itemPersonGallery,String itemIdInServer,String itemNumberOfComment,String itemNumberOfImage,String itemCity,String itemNeighborhood,String itemTimePost,String itemUserPhoneNumber,String itemName,String itemImage,String itemDescription,String userImage,String userName,String itemPostEdit,String itemNewPrice,String itemBurnedPrice,String itemPrice,String userID,String itemActiveOrNot,String date,String timeStamp)
    {
        SQLiteDatabase db =this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_AccAndJunk_BOOST_OR_NOT,boostOrNot);
        contentValues.put(COL_AccAndJunk_BOOST_TYPE,itemBoostType);

        contentValues.put(COL_AccAndJunk_TYPE,type);

        contentValues.put(COL_AccAndJunk_PERSON_GALLERY,itemPersonGallery);
        contentValues.put(COL_AccAndJunk_ID_IN_SERVER,itemIdInServer);
        contentValues.put(COL_AccAndJunk_NUMBER_OF_COMMENT,itemNumberOfComment);
        contentValues.put(COL_AccAndJunk_NUMBER_OF_IMAGE,itemNumberOfImage);
        contentValues.put(COL_AccAndJunk_CITY,itemCity);
        contentValues.put(COL_AccAndJunk_NEIGHBORHOOD,itemNeighborhood);
        contentValues.put(COL_AccAndJunk_TIME_POST,itemTimePost);
        contentValues.put(COL_AccAndJunk_USER_PHONE_NUMBER,itemUserPhoneNumber);
        contentValues.put(COL_AccAndJunk_ITEM_NAME,itemName);
        contentValues.put(COL_AccAndJunk_ITEM_IMAGE,itemImage);
        contentValues.put(COL_AccAndJunk_ITEM_DESCRIPTION,itemDescription);
        contentValues.put(COL_AccAndJunk_USER_IMAGE,userImage);
        contentValues.put(COL_AccAndJunk_ITEM_USER_NAME,userName);
        contentValues.put(COL_AccAndJunk_ITEM_POST_EDIT,itemPostEdit);
        contentValues.put(COL_AccAndJunk_ITEM_NEW_PRICE,itemNewPrice);
        contentValues.put(COL_AccAndJunk_ITEM_BURNED_PRICE,itemBurnedPrice);
        contentValues.put(COL_AccAndJunk_ITEM_PRICE,itemPrice);
        contentValues.put(COL_AccAndJunk_ITEM_USER_ID,userID);
        contentValues.put(COL_AccAndJunk_ITEM_ACTIVE_OR_NOT,itemActiveOrNot);
        contentValues.put(COL_AccAndJunk_ITEM_DATA,date);
        contentValues.put(COL_AccAndJunk_ITEM_TIME_STAMP,timeStamp);

        long result= db.insert(TABLE_AccAndJunk,null,contentValues);
        if(result == -1)
            return false;
        else
            return true;
    }

    public boolean insertFollowing(String name,String image
            ,String userID,String followingID,String followingIDOtherSaid)
    {
        SQLiteDatabase db =this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_FOLLOWERS_NAME,name);
        contentValues.put(COLO_FOLLOWERS_IMAGE,image);
        contentValues.put(COLO_FOLLOWERS_ID_IN_SERVER,userID);
        contentValues.put(COLO_FOLLOWERS_FOLLOWING_ID,followingID);
        contentValues.put(COLO_FOLLOWERS_FOLLOWING_ID_IN_OTHER_SAID,followingIDOtherSaid);

        long result= db.insert(TABLE_FOLLOWERS,null,contentValues);
        if(result == -1)
            return false;
        else
            return true;
    }

    public boolean insertDriverInfo(String processTypeS,String processType,String processContent
            ,String processContentS,String processStatus)
    {
        SQLiteDatabase db =this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_ITEM_DRIVER_INFORMATION_PROCESS_TYPE_S,processTypeS);
        contentValues.put(COL_ITEM_DRIVER_INFORMATION_PROCESS_TYPE,processType);
        contentValues.put(COL_ITEM_DRIVER_INFORMATION_PROCESS_CONTENT,processContent);
        contentValues.put(COL_ITEM_DRIVER_INFORMATION_PROCESS_CONTENT_S,processContentS);
        contentValues.put(COL_ITEM_DRIVER_INFORMATION_PROCESS_STATUS,processStatus);

        long result= db.insert(TABLE_DRIVER_INFORMATION,null,contentValues);
        if(result == -1)
            return false;
        else
            return true;
    }

    public boolean insertCarDetails(String processTypeS,String processType,String processContent
            ,String processContentS,String processStatus)
    {
        SQLiteDatabase db =this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_ITEM_CAR_DETAILS_PROCESS_TYPE_S,processTypeS);
        contentValues.put(COL_ITEM_CAR_DETAILS_PROCESS_TYPE,processType);
        contentValues.put(COL_ITEM_CAR_DETAILS_PROCESS_CONTENT,processContent);
        contentValues.put(COL_ITEM_CAR_DETAILS_PROCESS_CONTENT_S,processContentS);
        contentValues.put(COL_ITEM_CAR_DETAILS_PROCESS_STATUS,processStatus);

         db.insert(TABLE_CAR_DETAILS,null,contentValues);
//        if(result == -1)
//            return false;
//        else
            return true;
    }

    ////////////////////tester to check if table EXISTS/////////

//    public boolean doesTableExist() {
//        SQLiteDatabase db =this.getWritableDatabase();
//        Cursor cursor = db.rawQuery("select DISTINCT tbl_name from sqlite_master where tbl_name = '" + TABLE_FOLLOWERS + "'", null);
//
//        if (cursor != null) {
//            if (cursor.getCount() > 0) {
//                cursor.close();
//                return true;
//            }
//            cursor.close();
//        }
//        return false;
//    }


    //////////////////////////to get data /////////////////////

    public Cursor descendingItem(){
        SQLiteDatabase db =this.getWritableDatabase();
        Cursor cursor = db.query(TABLE_ITEM, null, null,
                null, null, null, COL_ITEM_id + " DESC", null);
        return cursor;
    }

    public Cursor descendingDataSuggested(){
        SQLiteDatabase db =this.getWritableDatabase();
        Cursor cursor = db.query(TABLE_SUGGESTED, null, null,
                null, null, null, COL_SUGGESTED_id + " DESC", null);
        return cursor;
    }

    public Cursor descendingSimilarAds(){
        SQLiteDatabase db =this.getWritableDatabase();
        Cursor cursor = db.query(TABLE_SIMILAR, null, null,
                null, null, null, COL_SIMILAR_id + " DESC", null);
        return cursor;
    }


    public Cursor descendingNotification(){
        SQLiteDatabase db =this.getWritableDatabase();
        Cursor cursor = db.query(TABLE_NOTIFICATION, null, null,
                null, null, null, COL_NOTIFICATION_id + " DESC", null);
        return cursor;
    }

    public Cursor descendingFCS(){
        SQLiteDatabase db =this.getWritableDatabase();
        Cursor cursor = db.query(TABLE_ITEM_FCS, null, null,
                null, null, null, COL_ITEM_FCS_id + " DESC", null);
        return cursor;
    }

    public Cursor descendingCCEMT(){
        SQLiteDatabase db =this.getWritableDatabase();
        Cursor cursor = db.query(TABLE_CCEMT, null, null,
                null, null, null, COL_CCEMT_id + " DESC", null);
        return cursor;
    }

    public Cursor descendingWheelsSize(){
        SQLiteDatabase db =this.getWritableDatabase();
        Cursor cursor = db.query(TABLE_WHEELS_RIM, null, null,
                null, null, null, COL_WHEELS_RIM_id + " DESC", null);
        return cursor;
    }

    public Cursor descendingCarPlates(){
        SQLiteDatabase db =this.getWritableDatabase();
        Cursor cursor = db.query(TABLE_CAR_PLATES_RIM, null, null,
                null, null, null, COL_CAR_PLATES_id + " DESC", null);
        return cursor;
    }

    public Cursor descendingAccAndJunk(){
        SQLiteDatabase db =this.getWritableDatabase();
        Cursor cursor = db.query(TABLE_AccAndJunk, null, null,
                null, null, null, COL_AccAndJunk_id + " DESC", null);
        return cursor;
    }

    public Cursor descendingFollowing(){
        SQLiteDatabase db =this.getWritableDatabase();
        Cursor cursor = db.query(TABLE_FOLLOWERS, null, null,
                null, null, null, COL_FOLLOWERS_id + " DESC", null);
        return cursor;
    }

    public Cursor descendingDriverInfo(){
        SQLiteDatabase db =this.getWritableDatabase();
        Cursor cursor = db.query(TABLE_DRIVER_INFORMATION, null, null,
                null, null, null, COL_ITEM_DRIVER_INFORMATION_id + " DESC", null);
        return cursor;
    }

    public Cursor descendingCarDetails(){
        SQLiteDatabase db =this.getWritableDatabase();
        Cursor cursor = db.query(TABLE_CAR_DETAILS, null, null,
                null, null, null, COL_ITEM_CAR_DETAILS_id + " DESC", null);
        return cursor;
    }

    public Cursor descendingCities(){
        SQLiteDatabase db =this.getWritableDatabase();
        Cursor cursor = db.query(TABLE_CITYS, null, null,
                null, null, null, COL_CITY_COL_ID + " DESC", null);
        return cursor;
    }

    public Cursor descendingAreas(){
        SQLiteDatabase db =this.getWritableDatabase();
        Cursor cursor = db.query(TABLE_AREAS, null, null,
                null, null, null, COL_AREA_COL_ID + " DESC", null);
        return cursor;
    }

    public Cursor descendingBrands(){
        SQLiteDatabase db =this.getWritableDatabase();
        Cursor cursor = db.query(TABLE_CARS_BRAND, null, null,
                null, null, null, COL_BRAND_COL_ID + " DESC", null);
        return cursor;
    }

    public Cursor descendingBrandsModel(){
        SQLiteDatabase db =this.getWritableDatabase();
        Cursor cursor = db.query(TABLE_CARS_MODEL, null, null,
                null, null, null, COL_MODEL_COL_ID + " DESC", null);
        return cursor;
    }

    public Cursor descendingSetting(){
        SQLiteDatabase db =this.getWritableDatabase();
        Cursor cursor = db.query(TABLE_MODEL_SETTING, null, null,
                null, null, null, TABLE_MODEL_SETTING_COL_ID + " DESC", null);
        return cursor;
    }

    //////////////////////////////////////update/////////////////////

    public void updateNotification(String itemServerID,String openOrNotYet)
    {
        SQLiteDatabase db =this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(OPEN_OR_NOT_YET,openOrNotYet);

        db.update(TABLE_NOTIFICATION,contentValues," ITEM_SERVER_ID = ?",new String[] {itemServerID});
    }

    public void updateDriverInfo(String processTypeS,String processType,String processContent,String processContentS,String processStatus)
    {
        SQLiteDatabase db =this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_ITEM_DRIVER_INFORMATION_PROCESS_TYPE,processType);
        contentValues.put(COL_ITEM_DRIVER_INFORMATION_PROCESS_CONTENT,processContent);
        contentValues.put(COL_ITEM_DRIVER_INFORMATION_PROCESS_CONTENT_S,processContentS);
        contentValues.put(COL_ITEM_DRIVER_INFORMATION_PROCESS_STATUS,processStatus);

        db.update(TABLE_DRIVER_INFORMATION,contentValues," PROCESS_TYPE_S = ?",new String[] {processTypeS});
    }

    public void updateCarDetails(String processTypeS,String processType,String processContent,String processContentS,String processStatus)
    {
        SQLiteDatabase db =this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_ITEM_CAR_DETAILS_PROCESS_TYPE,processType);
        contentValues.put(COL_ITEM_CAR_DETAILS_PROCESS_CONTENT,processContent);
        contentValues.put(COL_ITEM_CAR_DETAILS_PROCESS_CONTENT_S,processContentS);
        contentValues.put(COL_ITEM_CAR_DETAILS_PROCESS_STATUS,processStatus);

        db.update(TABLE_CAR_DETAILS,contentValues," PROCESS_TYPE_S = ?",new String[] {processTypeS});
    }

    //////////////////////////////////////get single object//////////

    public Cursor getCCEMTObject(String itemServerID)
    {
        SQLiteDatabase database = getWritableDatabase();
        Cursor cursor = database.rawQuery("SELECT * FROM " + TABLE_CCEMT + " WHERE " + COL_CCEMT_ID_IN_SERVER + " = ? ", new String[]{itemServerID});
        cursor.moveToFirst();

        return cursor;
    }

    public Cursor getWheelsRimObject(String itemServerID)
    {
        SQLiteDatabase database = getWritableDatabase();
        Cursor cursor = database.rawQuery("SELECT * FROM " + TABLE_WHEELS_RIM + " WHERE " + COL_WHEELS_RIM_ID_IN_SERVER + " = ? ", new String[]{itemServerID});
        cursor.moveToFirst();

        return cursor;
    }

    public Cursor getCarPlatesObject(String itemServerID)
    {
        SQLiteDatabase database = getWritableDatabase();
        Cursor cursor = database.rawQuery("SELECT * FROM " + TABLE_CAR_PLATES_RIM + " WHERE " + COL_CAR_PLATES_ID_IN_SERVER + " = ? ", new String[]{itemServerID});
        cursor.moveToFirst();

        return cursor;
    }

    public Cursor getAccAndJunkObject(String itemServerID)
    {
        SQLiteDatabase database = getWritableDatabase();
        Cursor cursor = database.rawQuery("SELECT * FROM " + TABLE_AccAndJunk + " WHERE " + COL_AccAndJunk_ID_IN_SERVER + " = ? ", new String[]{itemServerID});
        cursor.moveToFirst();

        return cursor;
    }

    public Cursor getFollowing(String itemServerID)
    {
        SQLiteDatabase database = getWritableDatabase();
        Cursor cursor = database.rawQuery("SELECT * FROM " + TABLE_FOLLOWERS + " WHERE " + COLO_FOLLOWERS_ID_IN_SERVER + " = ? ", new String[]{itemServerID});
        cursor.moveToFirst();

        return cursor;
    }

    public Cursor getDriverInfo(String processTypeS)
    {
        SQLiteDatabase database = getWritableDatabase();
        Cursor cursor = database.rawQuery("SELECT * FROM " + TABLE_DRIVER_INFORMATION + " WHERE " + COL_ITEM_DRIVER_INFORMATION_PROCESS_TYPE_S + " = ? ", new String[]{processTypeS});
        cursor.moveToFirst();

        return cursor;
    }

    public Cursor getCarDetails(String processTypeS)
    {
        SQLiteDatabase database = getWritableDatabase();
        Cursor cursor = database.rawQuery("SELECT * FROM " + TABLE_CAR_DETAILS + " WHERE " + COL_ITEM_CAR_DETAILS_PROCESS_TYPE_S + " = ? ", new String[]{processTypeS});
        cursor.moveToFirst();

        return cursor;
    }

    //////////////////////////////////////delete data "single row" ////////////////

    public Integer deleteItem(String id){
        SQLiteDatabase db =this.getWritableDatabase();
        return db.delete(TABLE_ITEM, " ID = ?",new String[] {id});
    }

    public Integer deleteDataSuggested(String id){
        SQLiteDatabase db =this.getWritableDatabase();
        return db.delete(TABLE_SUGGESTED, " ID = ?",new String[] {id});
    }

    public Integer deleteNotification(String id){
        SQLiteDatabase db =this.getWritableDatabase();
        return db.delete(TABLE_NOTIFICATION, " ID = ?",new String[] {id});
    }

    public Integer deleteFCS(String itemID){
        SQLiteDatabase db =this.getWritableDatabase();
        return db.delete(TABLE_ITEM_FCS, " ITEM_ID_IN_SERVER = ?",new String[] {itemID});
    }

    public Integer deleteCCEMT(String id){
        SQLiteDatabase db =this.getWritableDatabase();
        return db.delete(TABLE_CCEMT, " ID = ?",new String[] {id});
    }

    public Integer deleteWheelsSize(String id){
        SQLiteDatabase db =this.getWritableDatabase();
        return db.delete(TABLE_WHEELS_RIM, " ID = ?",new String[] {id});
    }

    public Integer deleteCarPlates(String id){
        SQLiteDatabase db =this.getWritableDatabase();
        return db.delete(TABLE_CAR_PLATES_RIM, " ID = ?",new String[] {id});
    }

    public Integer deleteAccAndJunk(String id){
        SQLiteDatabase db =this.getWritableDatabase();
        return db.delete(TABLE_AccAndJunk, " ID = ?",new String[] {id});
    }

    public Integer deleteFollowing(String userID){
        SQLiteDatabase db =this.getWritableDatabase();
        return db.delete(TABLE_FOLLOWERS, " ID_IN_SERVER = ?",new String[] {userID});
    }

    public Integer deleteDriverInfo(String processTypeS){
        SQLiteDatabase db =this.getWritableDatabase();
        return db.delete(TABLE_DRIVER_INFORMATION, " PROCESS_TYPE_S = ?",new String[] {processTypeS});
    }

    public Integer deleteCarDetails(String processTypeS){
        SQLiteDatabase db =this.getWritableDatabase();
        return db.delete(TABLE_CAR_DETAILS, " PROCESS_TYPE_S = ?",new String[] {processTypeS});
    }

    //////////////////////////////////////delete data "All line" ////////////////

    public void deleteAllItem(){
        SQLiteDatabase db =this.getWritableDatabase();
        db.execSQL("DELETE FROM item_table"); //delete all rows in a table
        db.close();
    }

    public void deleteCCEMTItem(){
        SQLiteDatabase db =this.getWritableDatabase();
        db.execSQL("DELETE FROM ccemt_table"); //delete all rows in a table
        db.close();
    }

    public void deleteWheels_RimItem(){
        SQLiteDatabase db =this.getWritableDatabase();
        db.execSQL("DELETE FROM wheels_rim_table"); //delete all rows in a table
        db.close();
    }

    public void deleteCarPlatesItem(){
        SQLiteDatabase db =this.getWritableDatabase();
        db.execSQL("DELETE FROM car_plates_table"); //delete all rows in a table
        db.close();
    }

    public void deleteAccAndJunkItem(){
        SQLiteDatabase db =this.getWritableDatabase();
        db.execSQL("DELETE FROM accAndJunk_table"); //delete all rows in a table
        db.close();
    }

    public void deleteSimilarAds(){
        SQLiteDatabase db =this.getWritableDatabase();
        db.execSQL("DELETE FROM item_similar_table"); //delete all rows in a table
        db.close();
    }

    public void deleteNotifications(){
        SQLiteDatabase db =this.getWritableDatabase();
        db.execSQL("DELETE FROM notification_table"); //delete all rows in a table
        db.close();
    }

    public void deleteAllFSC(){
        SQLiteDatabase db =this.getWritableDatabase();
        db.execSQL("DELETE FROM item_fcs_table"); //delete all rows in a table
        db.close();
    }

    public void deleteAllDriverInfo(){
        SQLiteDatabase db =this.getWritableDatabase();
        db.execSQL("DELETE FROM driver_info_table"); //delete all rows in a table
        db.close();
    }

    public void deleteAllCarDetails(){
        SQLiteDatabase db =this.getWritableDatabase();
        db.execSQL("DELETE FROM car_details_table"); //delete all rows in a table
        db.close();
    }

    public void deleteAllCities(){
        SQLiteDatabase db =this.getWritableDatabase();
        db.execSQL("DELETE FROM cites"); //delete all rows in a table
        db.close();
    }

    public void deleteAllAreas(){
        SQLiteDatabase db =this.getWritableDatabase();
        db.execSQL("DELETE FROM areas"); //delete all rows in a table
        db.close();
    }

    public void deleteAllCarsBrands(){
        SQLiteDatabase db =this.getWritableDatabase();
        db.execSQL("DELETE FROM cars_brand"); //delete all rows in a table
        db.close();
    }

    public void deleteAllCarsModel(){
        SQLiteDatabase db =this.getWritableDatabase();
        db.execSQL("DELETE FROM cars_model"); //delete all rows in a table
        db.close();
    }

    public void deleteAllSetting(){
        SQLiteDatabase db =this.getWritableDatabase();
        db.execSQL("DELETE FROM model_setting"); //delete all rows in a table
        db.close();
    }

}
