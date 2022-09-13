package com.demo.labpracticals;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.demo.labpracticals.databinding.ActivityMainBinding;
import com.google.android.material.navigation.NavigationView;

import java.util.Map;
import java.util.Objects;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    public static final String DATA_VALUE = "getter_id";
    public static final String CLASS_NAME = "class name";
    protected ActivityMainBinding activityMainBinding;
    protected ActionBarDrawerToggle toggle;
    protected DrawerLayout drawerLayout;
    protected NavigationView navigationView;
    protected Map<Integer, Class<?>> activityRefMap = Map.ofEntries(
            Map.entry(R.id.practical01, DialogMessage.class),
            Map.entry(R.id.practical02, GridViewDemoActivity.class),
            Map.entry(R.id.practical03, ListViewDemoActivity.class),
            Map.entry(R.id.practical04, TodoListDemoView.class),
            Map.entry(R.id.practical05, RecyclerViewDemoView.class),
            Map.entry(R.id.practical06, ScrollViewDemoActivity.class),
            Map.entry(R.id.practical07, DialogMessage.class),
            Map.entry(R.id.practical08, DialogMessage.class),
            Map.entry(R.id.practical09, DialogMessage.class),
            Map.entry(R.id.practical10, DialogMessage.class),
            Map.entry(R.id.practical11, DialogMessage.class),
            Map.entry(R.id.practical12, DialogMessage.class)
    );

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityMainBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(activityMainBinding.getRoot());

        drawerLayout = activityMainBinding.drawer;
        navigationView = activityMainBinding.navView;

        toggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.drawer_open, R.string.drawer_close);

        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        navigationView.setNavigationItemSelectedListener(this);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);

        activityMainBinding.practical1.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, DialogMessage.class);
            startActivity(intent);
        });
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(toggle.onOptionsItemSelected(item)){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Class<?> selectedElm = activityRefMap.get(item.getItemId());
        Intent intent = new Intent(this, selectedElm);
        assert selectedElm != null;
        intent.putExtra(DATA_VALUE, item.getItemId());
        intent.putExtra(CLASS_NAME, selectedElm.getName());
        startActivity(intent);
        return false;
    }
}