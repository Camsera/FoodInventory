package com.camjam.tabtest;

import android.os.Bundle;
import android.widget.EditText;

public interface IMainActivity {
    void inflateFragment(String tag, String label, String brand, String food_id);
    //void setData(EditText labelEdit, EditText brandEdit, EditText foodIdView, String label, String brand, String food_id);

}
