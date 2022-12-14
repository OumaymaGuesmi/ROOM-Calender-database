package com.example.roomdatabaseproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Calendar;

public class NewWordActivity extends AppCompatActivity {
    public static final String EXTRA_REPLY = "com.example.android.roomwordssample.REPLY";
    public static final String EXTRA_REPLY2 = "com.example.android.roomwordssample.REPLY2";
    public static final String EXTRA_REPLY3 = "com.example.android.roomwordssample.REPLY3";

    private EditText mEditWordView;
    private EditText mEditWordView2;
    private String dateMessage;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_word);
        mEditWordView = findViewById(R.id.edit_word);
        mEditWordView2 = findViewById(R.id.edit_word2);


        final Button button = findViewById(R.id.button_save);
        final Button dateButton = findViewById(R.id.date_btn);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent replyIntent = new Intent();
                if (TextUtils.isEmpty(mEditWordView.getText())) {
                    setResult(RESULT_CANCELED, replyIntent);
                } else {
                    String word = mEditWordView.getText().toString();
                    String word2 = mEditWordView2.getText().toString();

                    replyIntent.putExtra(EXTRA_REPLY, word);
                    replyIntent.putExtra(EXTRA_REPLY2, word2);
                    replyIntent.putExtra(EXTRA_REPLY3, dateMessage);


                    setResult(RESULT_OK, replyIntent);
                }
                finish();
            }
        });


        dateButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                showDatePicker(view);
            }
        });


    }

    public void showDatePicker(View view) {
        DialogFragment newFragment = new DatePickerFragment();
        newFragment.show(getSupportFragmentManager(), "datePicker");
    }

    public void processDatePickerResult(int year, int month, int day) {
        String month_string = Integer.toString(month + 1);
        String day_string = Integer.toString(day);
        String year_string = Integer.toString(year);
        dateMessage = (month_string + "/" + day_string + "/" + year_string);
    }


}