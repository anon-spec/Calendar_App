package com.example.calendarapp.ui.gallery;

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
import com.example.calendarapp.ui.slideshow.calendarActivity;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class notificationsActivity extends MainActivity{
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.notifications);

        //BackButton leads back to menu
        Button backButton = findViewById(R.id.backButtonNotifications);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { //changes screen to menu
                NavController navController = Navigation.findNavController(notificationsActivity.this, R.id.nav_host_fragment_content_main);
                navController.navigate(R.id.nav_home);
            }
        });

    }
}
