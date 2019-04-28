package com.camjam.tabtest;

import android.database.sqlite.*;
import android.database.*;
import android.content.ContentValues;
import android.content.Context;
import android.util.Log;

import java.util.ArrayList;

import static com.camjam.tabtest.FragmentAddItem.TAG;

public class InsertSQL extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "FoodInventorySystem.db";
    private static int DATABASE_VERSION = 1;

    public String label = "";
    public String upc = null;
    public double quanity = 0;
    public String food_id = null;
    public String expirationDate = null;
    public String beverageType = null;
    public String bottleMaterial = null;
    public boolean hasAlcohol = false;
    public double fl_oz = 0;
    public double oz = 0;
    public String container = null;
    public boolean isFrozen = false;
    public String brand = null;
    public String foodContentsLabel = null;
    public String classification = null;

    public int checkAlcohol = 0;
    public int checkFrozen = 0;
    private String queryParameter = "%";
    /*
     * Default constructor.
     */
    public InsertSQL (Context context) {
        super(context, DATABASE_NAME , null, DATABASE_VERSION);
    }

    //BEGIN SETTERS

    public void setLabel(String label) {
        this.label = label;
    }


    public void setUpc(String upc) {
        this.upc = upc;
    }


    public void setQuanity(double quanity) {
        this.quanity = quanity;
    }


    public void setFood_id(String food_id) {
        this.food_id = food_id;
    }


    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }


    public void setBeverageType(String beverageType) {
        this.beverageType = beverageType;
    }


    public void setBottleMaterial(String bottleMaterial) {
        this.bottleMaterial = bottleMaterial;
    }


    public void setHasAlcohol(boolean hasAlcohol) {
        this.hasAlcohol = hasAlcohol;
    }


    public void setFl_oz(double fl_oz) {
        this.fl_oz = fl_oz;
    }


    public void setOz(double oz) {
        this.oz = oz;
    }


    public void setContainer(String container) {
        this.container = container;
    }


    public void setFrozen(boolean isFrozen) {
        this.isFrozen = isFrozen;
    }

    public void setFoodContentsLabel(String foodContentsLabel) {
        this.foodContentsLabel = foodContentsLabel;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setClassification(String classification) {
        this.classification = classification;
    }
    //END SETTERS

    //BEGIN GETTERS

    public String getLabel() {
        return label;
    }

    public String getClassification() {
        String classCheck;
        if (classification == null) {
            classCheck = "NULL";
            return classCheck;
        }
        else {
            classCheck = ("'" + classification + "'");
            return classCheck;
        }
    }

    public String getBrand() {
        String brandCheck;
        if (brand == null) {
            brandCheck = "NULL";
            return brandCheck;
        }
        else {
            brandCheck = ("'" + brand + "'");
            return brandCheck;
        }

    }

    public String getFoodContentsLabel() {
        String foodConCheck;
        if (foodContentsLabel == null) {
            foodConCheck = "NULL";
            return foodConCheck;
        }
        else {
            foodConCheck = ("'" + brand + "'");
            return foodConCheck;
        }
    }


    public String getUpc() {
        String upcCheck;
        if (upc == null) {
            upcCheck = "NULL";
            return upcCheck;
        }
        else {
            upcCheck = ("'" + upc + "'");
            return upcCheck;
        }
    }

    public double getQuanity() {
        return quanity;
    }

    public String getFood_id() {
        String food_idCheck;
        if (food_id == null) {
            food_idCheck = "NULL";
            return food_idCheck;
        }
        else {
            food_idCheck = ("'" + food_id+ "'");
            return food_idCheck;
        }
    }

    public String getExpirationDate() {
        String expCheck;
        if (expirationDate == null) {
            expCheck = "NULL";
            return expCheck;
        }
        else {
            expCheck = ("'" + expirationDate + "'");
            return expCheck;
        }
    }

    public String getBeverageType() {
        String bevCheck;
        if (beverageType == null) {
            bevCheck = "NULL";
            return bevCheck;
        }
        else {
            bevCheck = ("'" + beverageType + "'");
            return bevCheck;
        }
    }

    public String getBottleMaterial() {
        String bottCheck;
        if (bottleMaterial == null) {
            bottCheck = "NULL";
            return bottCheck;
        }
        else {
            bottCheck = ("'" + bottleMaterial + "'");
            return bottCheck;
        }
    }

    public int getCheckAlcohol() {
        if(hasAlcohol != false){
            checkAlcohol = 1;
            return checkAlcohol;
        }
        else {
            return checkAlcohol;
        }
    }

    public double getFl_oz() {
        return fl_oz;
    }

    public double getOz() {
        return oz;
    }

    public String getContainer() {
        String conCheck;
        if (container == null) {
            conCheck = "NULL";
            return conCheck;
        }
        else {
            conCheck = ("'" + container + "'");
            return conCheck;
        }
    }

    public int getCheckFrozen() {
        if(isFrozen != false){
            checkFrozen = 1;
            return checkFrozen;
        }
        else
        {
            return checkFrozen;
        }
    }
    /*
     * method to get query parameter.
     */
    public String getQueryParameter() {
        return queryParameter;
    }

    /*
     * method to set query parameter.  This will wildcard search the label field.
     */
    public void setQueryParameter(String queryParameter) {
        this.queryParameter = queryParameter;
    }

    //END GETTERS
    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql =("CREATE TABLE foodinventory(" +
                "uid INTEGER PRIMARY KEY," +
                "label varchar(500) NOT NULL," +
                "upc VARCHAR(40)," +
                "quanity FLOAT," +
                "food_id VARCHAR(200)," +
                "expirationDate VARCHAR(50)," +
                "beverageType VARCHAR(200)," +
                "bottleMaterial VARCHAR(200)," +
                "hasAlcohol BOOLEAN," +
                "fl_oz FLOAT," +
                "oz FLOAT," +
                "container VARCHAR(200)," +
                "isFrozen BOOLEAN," +
                "brand varchar(500)," +
                "foodContentsLabel varchar(1000)," +
                "classification varchar(100))");


            db.execSQL(sql);


        /*catch(Exception e){
            String message = ("Error " + e.getMessage());
            System.out.println(message);
        }*/
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }

    /*
     * insertFood() will commit all field values as an entry in the database.
     */
    public String insertFood() {
        String message;
        String sql = ("INSERT INTO foodinventory (label, upc, quanity, food_id, expirationDate, beverageType, bottleMaterial, " +
                "hasAlcohol, fl_oz, oz, container, isFrozen, brand, foodContentsLabel, classification ) VALUES (" +
                "'"+ this.getLabel() + "'" + ", " +
                this.getUpc() + ", " +
                "'"+ this.getQuanity() + "'" + ", " +
                this.getFood_id() + ", " +
                this.getExpirationDate() + ", " +
                this.getBeverageType() + ", " +
                this.getBottleMaterial() + ", " +
                this.getCheckAlcohol() + ", " +
                "'"+ this.getFl_oz() + "'" + ", " +
                "'"+ this.getOz() + "'" + ", " +
                this.getContainer() + ", " +
                this.getCheckFrozen() + ", " +
                this.getBrand()	+ ", " +
                this.getFoodContentsLabel() + ", " +
                this.getClassification() + ");");
        try {
            SQLiteDatabase database = this.getWritableDatabase();
            database.execSQL(sql);
            database.close();
            message = ("Success!");
            Log.d(TAG, "insertFood: " + sql);
            Log.d(TAG, "insertFood: " + message);
            return message;
        }catch (Exception e){
            message = ("Error " + e.getMessage());
            Log.d(TAG, "insertFood: " + message);
            return message;
        }

    }
    public ArrayList<Food> keywordDBSearch() {
        String message;
        String sql = ("SELECT * FROM foodinventory WHERE label like '%" + queryParameter + "%' COLLATE NOCASE;");
        ArrayList<Food> selectFood = new ArrayList<Food>();
        try (SQLiteDatabase database = this.getWritableDatabase();
             Cursor rs = database.rawQuery(sql,null)){
            while (rs.moveToNext()) {
                Food foodItem = new Food();
                foodItem.setUid(rs.getInt(rs.getColumnIndex("uid")));
                foodItem.setLabel(rs.getString(rs.getColumnIndex("label")));
                foodItem.setUpc(rs.getString(rs.getColumnIndex("upc")));
                foodItem.setQuantity(rs.getDouble(rs.getColumnIndex("quanity")));
                foodItem.setFood_id(rs.getString(rs.getColumnIndex("food_id")));
                foodItem.setExpirationDate(rs.getString(rs.getColumnIndex("expirationDate")));
                foodItem.setBrand(rs.getString(rs.getColumnIndex("brand")));
                foodItem.setFoodContentsLabel(rs.getString(rs.getColumnIndex("foodContentsLabel")));
                selectFood.add(foodItem);
            }
            database.close();
            message = ("Select Success!");
            System.out.println(message);
        } catch (SQLException e) {
            message = ("Error " + e.getMessage());
            System.out.println(message);

        }
        return selectFood;
    }
}
