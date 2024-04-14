package com.example.calendarapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Menu;
import android.widget.CalendarView;
import android.widget.Button;

import com.example.calendarapp.ui.slideshow.calendarActivity;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;

import com.example.calendarapp.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;
    private ActivityMainBinding binding;

    private CalendarView calendarView;

    //private Button button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        setSupportActionBar(binding.appBarMain.toolbar);
        binding.appBarMain.toolbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null)
                        .setAnchorView(R.id.toolbar).show();
            }
        });
        DrawerLayout drawer = binding.drawerLayout;
        NavigationView navigationView = binding.navView;
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_calendar, R.id.nav_events, R.id.nav_notifications, R.id.nav_sync, R.id.nav_settings)
                .setOpenableLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);

        //Calendar
        Button buttonCalendar = findViewById(R.id.nav_calendar);
        // Set listener for button click
        buttonCalendar.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            viewCalendar();
        }
        });

        //Events
        Button buttonEvents = findViewById(R.id.nav_events);
        // Set listener for button click
        buttonEvents.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewEvents();
            }
        });

        //Notifications
        Button buttonNotifications = findViewById(R.id.nav_notifications);
        // Set listener for button click
        buttonNotifications.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewNotifications();
            }
        });

        //Settings
        Button buttonSettings = findViewById(R.id.nav_settings);
        // Set listener for button click
        buttonSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewSettings();
            }
        });
        }


   //changes screen to Calendar
    public void viewCalendar(){
        // Navigate to th e calendar screen.xml screen
        NavController navController = Navigation.findNavController(MainActivity.this, R.id.nav_host_fragment_content_main);
        navController.navigate(R.id.nav_calendar);
        setContentView(R.layout.calendarlayout);
    }



    //changes screen to Events
    public void viewEvents() {
        NavController navController = Navigation.findNavController(MainActivity.this, R.id.nav_host_fragment_content_main);
        navController.navigate(R.id.nav_events);
    }

    //changes screen to notifications
    public void viewNotifications() {
        NavController navController = Navigation.findNavController(MainActivity.this, R.id.nav_host_fragment_content_main);
        navController.navigate(R.id.nav_notifications); //change these nav screens to new notification screen that has not been made yet
    }

    //changes screen to settings
    public void viewSettings() {
        NavController navController = Navigation.findNavController(MainActivity.this, R.id.nav_host_fragment_content_main);
        navController.navigate(R.id.nav_settings); //change these nav screens to new settings screen that has not been made yet
    }


        @Override
        public boolean onCreateOptionsMenu (Menu menu){
            // Inflate the menu; this adds items to the action bar if it is present.
            getMenuInflater().inflate(R.menu.main, menu);
            return true;
        }


        @Override
        public boolean onSupportNavigateUp () {
            NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
            return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                    || super.onSupportNavigateUp();
        }


}
