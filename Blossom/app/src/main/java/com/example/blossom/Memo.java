package com.example.blossom;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;

public class Memo extends AppCompatActivity {
    private View decorView;
    private int    uiOption;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memo);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        Toolbar toolbar3 = (Toolbar) findViewById(R.id.memo_toolbar);
        setSupportActionBar(toolbar3);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        //toolbar.setNavigationIcon(R.drawable.ic_toolbar);
        toolbar3.setTitle("");
        toolbar3.setSubtitle("");
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
        menuInflater.inflate(R.menu.memo_toolbar, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.memo_menu_map:
                Intent NewActivity7 = new Intent(Memo.this, Map.class);
                startActivity(NewActivity7);
                break;
            case R.id.memo_menu_quiz:
                Intent NewActivity8 = new Intent(Memo.this, MainActivity.class);
                startActivity(NewActivity8);
                break;
            case R.id.memo_menu_memo:
                Intent NewActivity9 = new Intent(Memo.this, Memo.class);
                startActivity(NewActivity9);

                break;
            default:
                break;
        }
        return true;
    }
}