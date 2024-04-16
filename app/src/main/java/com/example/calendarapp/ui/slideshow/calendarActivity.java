package com.example.calendarapp.ui.slideshow;

import android.content.Intent;
import android.os.Bundle;
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
        Date currentTime = Calendar.getInstance().getTime();

        Button home = findViewById(R.id.home2);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { //changes screen to menu
                Intent notificationScreen = new Intent(calendarActivity.this, notificationsActivity.class);
                startActivity(notificationScreen);

            }
        });
        calendarView = (CalendarView) findViewById(R.id.calendarContentMain);
        calendarView.setDate(System.currentTimeMillis(), false, true);
        calendar = Calendar.getInstance();



        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener(){
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int day, int month, int year){
                String Date = month + 1 + "-" + day + "-" + year;
                //date_view.setText(Date);
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


        Button todayButton = findViewById(R.id.Today);
        todayButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { //changes to current date
                calendarView.setDate(System.currentTimeMillis(), false, true);
            }
        });

        //Text-to-speech button, creates notification indicating "Recording..."

        Button texttospeechButton = findViewById(R.id.Text_To_Speech);
        texttospeechButton.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Toast.makeText(getBaseContext(), "Recording...", Toast.LENGTH_SHORT).show();
                //implement code here where user is recorded
                return true;
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