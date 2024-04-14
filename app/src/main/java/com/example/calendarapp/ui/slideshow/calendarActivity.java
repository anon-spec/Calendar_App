package com.example.calendarapp.ui.slideshow;

import android.os.Bundle;
import android.view.View;
import android.widget.CalendarView;
import android.widget.TextView;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.example.calendarapp.MainActivity;
import com.example.calendarapp.R;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class calendarActivity extends MainActivity{

    CalendarView calendarView;
    TextView date_view;
    Calendar calendar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calendarlayout);
        calendarView = (CalendarView) findViewById(R.id.calendarContentMain);
        calendar = Calendar.getInstance();
        setDate(1, 1, 2023);

        getDate();
        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener(){
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int day, int month, int year){
                String Date = month + 1 + "-" + day + "-" + year;
                date_view.setText(Date);

                //Toast.makeText(this, Date, Toast.LENGTH_SHORT).show();

            }
    });



        //Home button that navigates to home
        Button home = findViewById(R.id.nav_home);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { //changes screen to menu
                NavController navController = Navigation.findNavController(calendarActivity.this, R.id.nav_host_fragment_content_main);
                navController.navigate(R.id.nav_home);
            }
        });

    }

    public void checkEvent(){

    }


    public void getDate(){
        long date = calendarView.getDate();
        SimpleDateFormat simpledateformat = new SimpleDateFormat("dd/MM/yy", Locale.getDefault());
        calendar.setTimeInMillis(date);
        String selected_date = simpledateformat.format(calendar.getTime());
        Toast.makeText(this, selected_date, Toast.LENGTH_SHORT).show();
    }
    public void setDate(int day, int month, int year){
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, month - 1);
        calendar.set(Calendar.DAY_OF_MONTH, day);
        long milli = calendar.getTimeInMillis();
        calendarView.setDate(milli);
    }
}


