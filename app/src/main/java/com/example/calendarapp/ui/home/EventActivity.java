package com.example.calendarapp.ui.home;

import com.example.calendarapp.MainActivity;

import android.content.Intent;
import android.media.metrics.Event;
import android.net.Uri;
import android.os.Bundle;
import android.provider.CalendarContract;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.TextView;
import android.view.View;
import com.example.calendarapp.R;
import com.example.calendarapp.ui.slideshow.calendarActivity;

import android.widget.Spinner;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;


public class EventActivity extends calendarActivity {
    TextView textview;
    EditText nameinputText;
    EditText locationinputText;
    EditText descriptioninputText;
    EditText urlinputText;
    EditText notesinputText;


    private LocalTime time;
    private LocalDate date;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_events); //sets screen to events page

/*
        TextView nametextview = (TextView) findViewById(R.id.eventNameView);
        nameinputText = (EditText) findViewById(R.id.eventNameInput);

        String eventName = (String) nameinputText.getText().toString();

        TextView locationtextview = (TextView) findViewById(R.id.eventLocationView);
        locationinputText = (EditText) findViewById(R.id.eventLocationInput);

        String eventLocation = (String) locationinputText.getText().toString();

        TextView descriptiontextview = (TextView) findViewById(R.id.eventDescriptionView);
        descriptioninputText = (EditText) findViewById(R.id.eventDescriptionInput);

        String eventDescription = (String) descriptioninputText.getText().toString();

        TextView urltextview = (TextView) findViewById(R.id.eventURLView);
        urlinputText = (EditText) findViewById(R.id.eventURLInput);

        String eventURL = (String) urlinputText.getText().toString();

        TextView notestextview = (TextView) findViewById(R.id.eventNotesView);
        notesinputText = (EditText) findViewById(R.id.eventNotesInput);

        String eventNotes = (String) notesinputText.getText().toString();
*/

        nameinputText = (EditText) findViewById(R.id.eventNameInput);
        String fieldValue = nameinputText.getText().toString();






        //spinner for start time
        Spinner startEventSpinner = findViewById(R.id.timeStartEventsSpinner);
        ArrayAdapter<CharSequence> startAdapter = ArrayAdapter.createFromResource(this, R.array.timeEventsData, android.R.layout.simple_spinner_item);
        startAdapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        startEventSpinner.setAdapter(startAdapter);
        //gets data from selected item in spinner
        String startEventSpinnerData = startEventSpinner.getSelectedItem().toString();



        //spinner for end time
        Spinner endEventSpinner = findViewById(R.id.timeEndEventsSpinner);
        ArrayAdapter<CharSequence> endAdapter = ArrayAdapter.createFromResource(this, R.array.timeEventsData, android.R.layout.simple_spinner_item);
        endAdapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        endEventSpinner.setAdapter(endAdapter);
        //gets data from selected item in spinner
        String endEventSpinnerData = endEventSpinner.getSelectedItem().toString();


        //spinner to repeat events
        Spinner repeatEventSpinner = findViewById(R.id.repeatEventsSpinner);
        ArrayAdapter<CharSequence> repeatAdapter = ArrayAdapter.createFromResource(this, R.array.repeatEventsData, android.R.layout.simple_spinner_item);
        repeatAdapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        repeatEventSpinner.setAdapter(repeatAdapter);

        //spinner for event alerts
        Spinner alertEventSpinner = findViewById(R.id.alertEventsSpinner);
        ArrayAdapter<CharSequence> alertAdapter = ArrayAdapter.createFromResource(this, R.array.alertEventsData, android.R.layout.simple_spinner_item);
        alertAdapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        alertEventSpinner.setAdapter(alertAdapter);

        //back button
        Button backButton = findViewById(R.id.backButtonEvent);
        // Set listener for button click
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent eventScreen = new Intent(EventActivity.this, calendarActivity.class);
                startActivity(eventScreen);
            }
        });

        //Add event button
        Button addEventButton = findViewById(R.id.createButtonEvent);
        addEventButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //save event info to at specific date
                String fieldValue = nameinputText.getText().toString();
                //addEvent(fieldValue);

                Intent test = new Intent(EventActivity.this, calendarActivity.class);
                test.putExtra("key", fieldValue);
                test.putExtra("timeKey", startEventSpinnerData);
                startActivity(test);
                finish();

            }
        });
        /*calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int day, int month, int year) {
                String Date = month + 1 + "-" + year + "-" + day;
                addEvent(Date, fieldValue);

            }


        });
        */



    }

    public void addEvent(String key, String value){
        Intent test = new Intent(EventActivity.this, calendarActivity.class);
        test.putExtra(key, value);
        startActivity(test);
        finish();
    }
}
