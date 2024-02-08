package com.zmaryalai_ali.dianat;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import android.app.UiModeManager;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;
import com.zmaryalai_ali.dianat.our_child_app.Date;
import com.zmaryalai_ali.dianat.our_child_app.Tasbih;
import com.zmaryalai_ali.dianat.our_child_app.Zakate;
import com.zmaryalai_ali.dianat.worship.Decency;
import com.zmaryalai_ali.dianat.worship.Doctrine;
import com.zmaryalai_ali.dianat.worship.Zajirate;
import com.zmaryalai_ali.dianat.worship.work;
import com.zmaryalai_ali.dianat.worship.worship;

public class MainActivity extends AppCompatActivity {
    DrawerLayout drawerLayout;
    ActionBarDrawerToggle actionBarDrawerToggle;
    Toolbar toolbar;
    NavigationView navigationView;
    TextView tv_home, tv_work, tv_doctrine, tv_worship, tv_decency, tv_zajirate;
    Switch My_Mode;
    private UiModeManager OurManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        object_iniatialize();

        // our appbar color is  here
        getWindow().setStatusBarColor(getResources().getColor(R.color.my_child));

        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
        getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, new Home()).commit();

        //our home fragment text color is here change

        tv_home.setTextColor(getResources().getColor(R.color.my_child));


        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.home:
                        Toast.makeText(MainActivity.this, "you selected jan", Toast.LENGTH_SHORT).show();
                }
                return true;
            }
        });

    }

    public void close(View view) {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.close();
        }
    }

    public void onclick(@NonNull View view) {
        Fragment fragment = null;
        switch (view.getId()) {
            case R.id.home:
                fragment = new Home();

                tv_home.setTextColor(getResources().getColor(R.color.my_child));
                tv_work.setTextColor(getResources().getColor(R.color.black));
                tv_worship.setTextColor(getResources().getColor(R.color.black));
                tv_zajirate.setTextColor(getResources().getColor(R.color.black));
                tv_doctrine.setTextColor(getResources().getColor(R.color.black));
                tv_decency.setTextColor(getResources().getColor(R.color.black));
                toolbar.setVisibility(View.VISIBLE);
                break;
            case R.id.zajirate:
                fragment = new Zajirate();
                tv_home.setTextColor(getResources().getColor(R.color.black));
                tv_work.setTextColor(getResources().getColor(R.color.black));
                tv_worship.setTextColor(getResources().getColor(R.color.black));
                tv_zajirate.setTextColor(getResources().getColor(R.color.my_child));
                tv_doctrine.setTextColor(getResources().getColor(R.color.black));
                tv_decency.setTextColor(getResources().getColor(R.color.black));
                toolbar.setVisibility(View.GONE);


                break;
            case R.id.doctrine:
                fragment = new Doctrine();
                tv_home.setTextColor(getResources().getColor(R.color.black));
                tv_work.setTextColor(getResources().getColor(R.color.black));
                tv_worship.setTextColor(getResources().getColor(R.color.black));
                tv_zajirate.setTextColor(getResources().getColor(R.color.black));
                tv_doctrine.setTextColor(getResources().getColor(R.color.my_child));
                tv_decency.setTextColor(getResources().getColor(R.color.black));
                toolbar.setVisibility(View.GONE);
                break;
            case R.id.work:
                fragment = new work();
                tv_home.setTextColor(getResources().getColor(R.color.black));
                tv_work.setTextColor(getResources().getColor(R.color.my_child));
                tv_worship.setTextColor(getResources().getColor(R.color.black));
                tv_zajirate.setTextColor(getResources().getColor(R.color.black));
                tv_doctrine.setTextColor(getResources().getColor(R.color.black));
                tv_decency.setTextColor(getResources().getColor(R.color.black));
                toolbar.setVisibility(View.GONE);
                break;
            case R.id.decency:
                fragment = new Decency();
                tv_home.setTextColor(getResources().getColor(R.color.black));
                tv_work.setTextColor(getResources().getColor(R.color.black));
                tv_worship.setTextColor(getResources().getColor(R.color.black));
                tv_zajirate.setTextColor(getResources().getColor(R.color.black));
                tv_doctrine.setTextColor(getResources().getColor(R.color.black));
                tv_decency.setTextColor(getResources().getColor(R.color.my_child));
                toolbar.setVisibility(View.GONE);
                break;
            case R.id.worship:
                fragment = new worship();
                tv_home.setTextColor(getResources().getColor(R.color.black));
                tv_work.setTextColor(getResources().getColor(R.color.black));
                tv_worship.setTextColor(getResources().getColor(R.color.my_child));
                tv_zajirate.setTextColor(getResources().getColor(R.color.black));
                tv_doctrine.setTextColor(getResources().getColor(R.color.black));
                tv_decency.setTextColor(getResources().getColor(R.color.black));
                toolbar.setVisibility(View.GONE);
                break;

        }

        getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, fragment).commit();
    }

    private void object_iniatialize() {
        drawerLayout = findViewById(R.id.drawer);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        actionBarDrawerToggle = new ActionBarDrawerToggle(MainActivity.this, drawerLayout, toolbar, R.string.open, R.string.close);
        navigationView = findViewById(R.id.navigation);
        tv_home = findViewById(R.id.tv_home);
        tv_decency = findViewById(R.id.tv_decency);
        tv_doctrine = findViewById(R.id.tv_doctrine);
        tv_zajirate = findViewById(R.id.tv_zajirate);
        tv_worship = findViewById(R.id.tv_worship);
        tv_work = findViewById(R.id.tv_work);
        My_Mode=findViewById(R.id.my_mode);
        OurManager= (UiModeManager) getSystemService(UI_MODE_SERVICE);
    }

    public void drawer_close(View view) {
        drawerLayout.close();
    }

    public void switch_on_off(View view) {
        if(My_Mode.isChecked()){

            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
        }
        else{
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        }

    }

}