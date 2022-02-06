package com.cars.halamotor_obeidat.dataBase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

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

    //this table to save favorite , seen ,call ,as well as search item well give him
    //name FCS
    public static final String TABLE_ITEM_FCS="item_fcs_table";
    public static final String COL_ITEM_FCS_id="ID";
    public static final String COL_ITEM_FCS_ID_IN_SERVER="ITEM_ID_IN_SERVER";
    public static final String COL_ITEM_FCS_CATEGORY="CATEGORY";
    public static final String COL_ITEM_FCS_TYPE_FCS="FCS_TYPE";

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
    public static final String CREATOR_NAME = "CREATOR_NAME";
    public static final String CREATOR_IMAGE = "CREATOR_IMAGE";
    public static final String ADS_DES = "ADS_DES";
    public static final String CATEGORY_ID = "CATEGORY_ID";
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
        db.execSQL("create table "+TABLE_NOTIFICATION +" (ID INTEGER PRIMARY KEY AUTOINCREMENT," +
                "PROCESS TEXT" + ",OPEN_OR_NOT_YET TEXT" + ",NOTIFICATION_TITLE TEXT"  + ",PERSON_OR_GALLERY TEXT" + ",IMAGE_PATH TEXT" + ",PROCESS_IMAGE TEXT" + ",TIME_STAMP TEXT"+ ",ITEM_SERVER_ID TEXT" + ",OUT_OR_COME TEXT"+ ",CREATOR_NAME TEXT"+ ",CREATOR_IMAGE TEXT"+ ",ADS_DES TEXT" + ",CATEGORY_ID TEXT" + ",DATE TEXT)");

        db.execSQL("create table "+TABLE_ITEM_FCS +" (ID INTEGER PRIMARY KEY AUTOINCREMENT," +
                "ITEM_ID_IN_SERVER TEXT" +",CATEGORY TEXT" + ",FCS_TYPE TEXT)");

        db.execSQL("create table "+TABLE_FOLLOWERS +" (ID INTEGER PRIMARY KEY AUTOINCREMENT," +
                "NAME TEXT" + ",IMAGE TEXT" + ",ID_IN_SERVER TEXT" + ",FOLLOWING_ID TEXT" + ",FOLLOWING_ID_IN_OTHER_SAID TEXT)");

        db.execSQL("create table "+TABLE_DRIVER_INFORMATION +" (ID INTEGER PRIMARY KEY AUTOINCREMENT," +
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
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NOTIFICATION);
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_ITEM_FCS);
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_FOLLOWERS);
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_DRIVER_INFORMATION);

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


    public boolean insertNotification(String process,String openOrNotYet
            ,String notificationTitle,String personOrGallery,String imagePath
            ,String processImage,String timeStamp,String itemIdInServer,String com_or_out
            ,String creator_name,String creator_image,String ads_des,String category_id,String date)
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
        contentValues.put(CREATOR_NAME,creator_name);
        contentValues.put(CREATOR_IMAGE,creator_image);
        contentValues.put(ADS_DES,ads_des);
        contentValues.put(CATEGORY_ID,category_id);
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

    //////////////////////////////////////get single object//////////

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

    //////////////////////////////////////delete data "single row" ////////////////

    public Integer deleteNotification(String id){
        SQLiteDatabase db =this.getWritableDatabase();
        return db.delete(TABLE_NOTIFICATION, " ID = ?",new String[] {id});
    }

    public Integer deleteFCS(String itemID){
        SQLiteDatabase db =this.getWritableDatabase();
        return db.delete(TABLE_ITEM_FCS, " ITEM_ID_IN_SERVER = ?",new String[] {itemID});
    }

    public Integer deleteFollowing(String userID){
        SQLiteDatabase db =this.getWritableDatabase();
        return db.delete(TABLE_FOLLOWERS, " ID_IN_SERVER = ?",new String[] {userID});
    }

    public Integer deleteDriverInfo(String processTypeS){
        SQLiteDatabase db =this.getWritableDatabase();
        return db.delete(TABLE_DRIVER_INFORMATION, " PROCESS_TYPE_S = ?",new String[] {processTypeS});
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

    public void deleteAllNotifications(){
        SQLiteDatabase db =this.getWritableDatabase();
        db.execSQL("DELETE FROM notification_table"); //delete all rows in a table
        db.close();
    }

}
