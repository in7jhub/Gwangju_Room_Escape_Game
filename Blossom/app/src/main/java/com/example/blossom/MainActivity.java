package com.example.blossom;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import androidx.appcompat.widget.Toolbar;
import android.view.MenuInflater;
import android.view.View;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private View decorView;
    private int    uiOption;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        Toolbar toolbar1 = (Toolbar) findViewById(R.id.main_toolbar);
        setSupportActionBar(toolbar1);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        //toolbar.setNavigationIcon(R.drawable.ic_toolbar);
        toolbar1.setTitle("");
        toolbar1.setSubtitle("");
        //toolbar.setLogo(R.drawable.ic_toolbar);
        decorView = getWindow().getDecorView();
        uiOption = getWindow().getDecorView().getSystemUiVisibility();
        if( Build.VERSION.SDK_INT >= Build.VERSION_CODES.ICE_CREAM_SANDWICH )
            uiOption |= View.SYSTEM_UI_FLAG_HIDE_NAVIGATION;
        if( Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN )
            uiOption |= View.SYSTEM_UI_FLAG_FULLSCREEN;
        if( Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT )
            uiOption |= View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY;
        decorView.setSystemUiVisibility( uiOption );
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.main_toolbar, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.main_menu_map:
                Intent NewActivity = new Intent(getApplicationContext(), Map.class);
                startActivity(NewActivity);
                break;
            case R.id.main_menu_quiz:
                Intent NewActivity2 = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(NewActivity2);
                break;
            case R.id.main_menu_memo:
                Intent NewActivity3 = new Intent(getApplicationContext(), Memo.class);
                startActivity(NewActivity3);
                break;
            default:
                break;
        }
        return true;
    }
}