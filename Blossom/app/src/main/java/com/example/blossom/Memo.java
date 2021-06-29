package com.example.blossom;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import com.kyanogen.signatureview.SignatureView;

public class Memo extends AppCompatActivity {
    private View decorView;
    private int uiOption;
    ImageButton eraser_btn;
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
        decorView.setSystemUiVisibility( uiOption ); // 소프트버튼 없애기

        ImageButton eraser_btn = (ImageButton) findViewById(R.id.eraser) ;

        eraser_btn.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder ad = new AlertDialog.Builder(Memo.this);
                ad.setTitle("모두 지우기");
                ad.setMessage("지워진 메모는 되돌릴 수 없어요!");

                ad.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        SignatureView signatureView = (SignatureView) findViewById(R.id.signature_view);
                        signatureView.clearCanvas();
                    }
                });

                ad.setNegativeButton("취소", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                ad.show();
            }
        });

        eraser_btn = (ImageButton)findViewById(R.id.eraser);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.memo_toolbar, menu);
        decorView.setSystemUiVisibility( uiOption );
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
            default:
                break;
        }
        return true;
    }
}