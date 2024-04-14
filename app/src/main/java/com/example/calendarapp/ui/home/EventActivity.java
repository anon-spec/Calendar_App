package com.example.calendarapp.ui.home;

import com.example.calendarapp.MainActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.view.View;
import com.example.calendarapp.R;
import android.widget.Spinner;


import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import java.time.LocalDate;
import java.time.LocalTime;


public class EventActivity extends AppCompatActivity{
    TextView textview;
    EditText nameinputText;
    EditText locationinputText;
    EditText descriptioninputText;
    EditText urlinputText;
    EditText notesinputText;



    private LocalTime time;
    private LocalDate date;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_events); //sets screen to events page

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

        time = LocalTime.now();
        date = LocalDate.now();

        //spinner for start time
        Spinner startEventSpinner = findViewById(R.id.timeStartEventsSpinner);
        ArrayAdapter<CharSequence>startAdapter = ArrayAdapter.createFromResource(this, R.array.timeEventsData, android.R.layout.simple_spinner_item);
        startAdapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        startEventSpinner.setAdapter(startAdapter);

        //spinner for end time
        Spinner endEventSpinner = findViewById(R.id.timeEndEventsSpinner);
        ArrayAdapter<CharSequence>endAdapter = ArrayAdapter.createFromResource(this, R.array.timeEventsData, android.R.layout.simple_spinner_item);
        endAdapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        endEventSpinner.setAdapter(endAdapter);

        //spinner to repeat events
        Spinner repeatEventSpinner = findViewById(R.id.repeatEventsSpinner);
        ArrayAdapter<CharSequence>repeatAdapter = ArrayAdapter.createFromResource(this, R.array.repeatEventsData, android.R.layout.simple_spinner_item);
        repeatAdapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        endEventSpinner.setAdapter(repeatAdapter);

        //spinner for event alerts
        Spinner alertEventSpinner = findViewById(R.id.alertEventsSpinner);
        ArrayAdapter<CharSequence>alertAdapter = ArrayAdapter.createFromResource(this, R.array.alertEventsData, android.R.layout.simple_spinner_item);
        alertAdapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        endEventSpinner.setAdapter(alertAdapter);

        //back button
        Button backButton = findViewById(R.id.backButtonEvent);
        // Set listener for button click
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //change screen. This wont work since file is fragment and not activity
                NavController backButtonController = Navigation.findNavController(EventActivity.this, R.id.nav_host_fragment_content_main);
                backButtonController.navigate(R.id.nav_calendar);
            }
        });

        //Add event button
        Button addEventButton = findViewById(R.id.createButtonEvent);
        addEventButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //saveEventAction(v);
                NavController addEventController = Navigation.findNavController(EventActivity.this, R.id.nav_host_fragment_content_main);
                addEventController.navigate(R.id.nav_calendar);
            }
        });

    }

/*public void saveEventAction(View view){
    Event newEventTitle = new Event(nameinputText, calendarActivity.setDate, time);
    Event newEventLocation = new Event(nameinputText, calendarActivity.selectedDate, time);
    Event newEventDescription = new Event(nameinputText, calendarActivity.selectedDate, time);
    Event newEventURL = new Event(nameinputText, calendarActivity.selectedDate, time);
    Event newEventNotes = new Event(nameinputText, calendarActivity.selectedDate, time);
    Event.eventsList.add(newEventTitle);
    Event.eventsList.add(newEventLocation);
    Event.eventsList.add(newEventDescription);
    Event.eventsList.add(newEventURL);
    Event.eventsList.add(newEventNotes);
    finish();

}
 */




}
