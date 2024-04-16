package com.example.calendarapp.ui.slideshow;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.CalendarView;
import android.widget.TextView;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.example.calendarapp.MainActivity;
import com.example.calendarapp.R;
import com.example.calendarapp.ui.gallery.notificationsActivity;
import com.example.calendarapp.ui.home.EventActivity;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;


public class calendarActivity extends AppCompatActivity {

    CalendarView calendarView;
    TextView date_view;
    Calendar calendar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calendarlayout);

        Button home = findViewById(R.id.home2);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { //changes screen to menu
                Intent notificationScreen = new Intent(calendarActivity.this, notificationsActivity.class);
                startActivity(notificationScreen);

            }
        });
        calendarView = (CalendarView) findViewById(R.id.calendarContentMain);
        calendar = Calendar.getInstance();
        setDate(1, 1, 2023);

        getDate();
        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener(){
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int day, int month, int year){
                String Date = month + 1 + "-" + day + "-" + year;
                date_view.setText(Date);
                Toast.makeText(getBaseContext(), Date, Toast.LENGTH_SHORT).show();
            }
        });



        //Event button, navigates to create event screen
        Button newEvent = findViewById(R.id.New_Event);
        newEvent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { //changes screen to menu
                Intent eventScreen = new Intent(calendarActivity.this, EventActivity.class);
                startActivity(eventScreen);
            }
        });

        Date currentTime = Calendar.getInstance().getTime();
        Button todayButton = findViewById(R.id.Today);
        todayButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { //changes to current date
                //setDate(currentTime);
                Intent eventScreen = new Intent(calendarActivity.this, EventActivity.class);
                startActivity(eventScreen);
            }
        });

        //Text-to-speech button, creates notification indicating "Recording..."

        Button texttospeechButton = findViewById(R.id.Text_To_Speech);
        texttospeechButton.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                while (event.getAction() == MotionEvent.ACTION_DOWN){
                    Toast.makeText(getBaseContext(), "Recording...", Toast.LENGTH_SHORT).show();
                }

                return false;
            }
        });



    }

    public void getDate(){
        long date = calendarView.getDate();
        SimpleDateFormat simpledateformat = new SimpleDateFormat("dd/MM/yy", Locale.getDefault());
        calendar.setTimeInMillis(date);
        String selected_date = simpledateformat.format(calendar.getTime());
        Toast.makeText(this, selected_date, Toast.LENGTH_SHORT).show();
    }
    public void setDate(int day, int month, int year) {
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, month - 1);
        calendar.set(Calendar.DAY_OF_MONTH, day);
        long milli = calendar.getTimeInMillis();
        calendarView.setDate(milli);

    }


}