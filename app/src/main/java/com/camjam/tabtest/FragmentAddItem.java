package com.camjam.tabtest;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.Objects;

public class FragmentAddItem extends Fragment {

    public static final String TAG = "FragmentAddItem";
    public static final String LABEL_ARG = "Label";
    public static final String BRAND_ARG = "Brand";
    public static final String FOODID_ARG = "food_id";

    View view; //layout viewer
    Spinner classificationSpinner;
    String label = "";
    String brand = "";
    String food_id = "";
    private double qty = 0;
    InsertSQL dbHelper = null;
    EditText labelEdit, brandEdit, expDateEdit, qtyEdit;
    TextView foodIdView;
    Button addBtn, loadBtn;
    Bundle b2;



    public FragmentAddItem() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.add_item_fragment_layout, container, false);

        //Spinner Components
        classificationSpinner = view.findViewById(R.id.classifSpinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(Objects.requireNonNull(getActivity()),
                R.array.classification, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        classificationSpinner.setAdapter(adapter);
        //classificationSpinner.getSelectedItemPosition();

        //Components
        dbHelper = new InsertSQL(getActivity());
        labelEdit = (EditText) view.findViewById(R.id.labeleditview);
        brandEdit = (EditText) view.findViewById(R.id.editBrand);
        expDateEdit = (EditText) view.findViewById(R.id.editExpirationDate);
        qtyEdit = (EditText) view.findViewById(R.id.quantityEdit);
        foodIdView = (TextView) view.findViewById(R.id.foodIdView);
        addBtn = (Button) view.findViewById(R.id.addBtn);


        /*Bundle bundle = getArguments();
        if(bundle != null){

            this.label = bundle.getString(LABEL_ARG);
            this.brand = bundle.getString(BRAND_ARG);
            this.food_id = bundle.getString(FOODID_ARG);
            labelEdit.setText(this.label);
            brandEdit.setText(this.brand);
            foodIdView.setText(this.food_id);
            //DB HELPER SETS

            //dbHelper.setQuanity(Double.parseDouble(String.valueOf(qtyEdit.getText())));
        }*/

        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dbHelper.setLabel(labelEdit.getText().toString());
                dbHelper.setBrand(brandEdit.getText().toString());
                dbHelper.setFood_id(foodIdView.getText().toString());
                dbHelper.setExpirationDate(expDateEdit.getText().toString());
                dbHelper.insertFood();
            }
        });

        return view;
        //end of onCreate
    }

    public void setValues(String label, String brand, String food_id) {
        this.label = label;
        this.brand = brand;
        this.food_id = food_id;
        labelEdit.setText(label);
        brandEdit.setText(brand);
        foodIdView.setText(food_id);
    }


    @Override
    public void onResume() {
        super.onResume();


    }
    public static FragmentAddItem newInstance(String label, String brand, String food_id){
        FragmentAddItem fragment = new FragmentAddItem();
        Bundle bundle = new Bundle();
        bundle.putString(LABEL_ARG, label);
        bundle.putString(BRAND_ARG, brand);
        bundle.putString(FOODID_ARG, food_id);
        fragment.setArguments(bundle);
        return fragment;
    }
    /*public void onClickInsert(View v){
        if(v.getId() == R.id.addBtn) {
            getContext();
            dbHelper.insertFood();
        }
    }*/

}
