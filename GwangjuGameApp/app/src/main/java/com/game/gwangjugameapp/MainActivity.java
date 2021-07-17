package com.game.gwangjugameapp;

import android.content.DialogInterface;
import android.content.Intent;
import android.media.Image;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.widget.Toolbar;
import android.view.MenuInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.widget.NestedScrollView;

public class MainActivity extends AppCompatActivity {
    private View decorView;
    private int    uiOption;

    TextView main_title;
    TextView progress;
//    ImageButton answer_btn;
    QuizMaker quiz;
    NestedScrollView scrlView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        main_title = findViewById(R.id.main_title);

        quiz = new QuizMaker();
        String[] answerCase = new String[13];
        answerCase[0] = "loveblossom";
        answerCase[1] = "광주충장로우체국";
        answerCase[2] = "971225";
        answerCase[3] = "datestart";
        answerCase[4] = "late";
        answerCase[5] = "sorry";
        answerCase[6] = "23106";
        answerCase[7] = "인생샷성공";
        answerCase[8] = "전화";
        answerCase[9] = "3002";
        answerCase[10] = "TALK";
        answerCase[11] = "바람?";
        answerCase[12] = "비밀의화원";

        scrlView = (NestedScrollView) findViewById(R.id.main_nest);
        progress = findViewById(R.id.progress);
        AlertDialog.Builder alert = new AlertDialog.Builder(MainActivity.this);
        AlertDialog.Builder hint = new AlertDialog.Builder(MainActivity.this);
        ImageButton answer_btn = (ImageButton)findViewById(R.id.answer_button);
        answer_btn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                switch(quiz.iCurQuiz){
                    case 0 :
                        alert.setTitle("영어 11자리");
                        break;
                    case 1 :
                        alert.setTitle("한글 8자리");
                        break;
                    case 2 :
                        alert.setTitle("숫자 6자리");
                        break;
                    case 3 :
                        alert.setTitle("영어 9자리");
                        break;
                    case 4 :
                    case 10 :
                        alert.setTitle("영어 4자리");
                        break;
                    case 5 :
                        alert.setTitle("영어 5자리");
                        break;
                    case 6 :
                        alert.setTitle("숫자 5자리");
                        break;
                    case 7 :
                        alert.setTitle("한글 5자리");
                        break;
                    case 8 :
                        alert.setTitle("한글 2자리");
                        break;
                    case 9 :
                        alert.setTitle("숫자 4자리");
                        break;
                    case 11 :
                        alert.setTitle("한글, 특수문자 포함 3자리");
                        break;
                    case 12 :
                        alert.setTitle("한글 5자리, 붙여쓰기");
                        break;
                }

                final EditText answer = new EditText(MainActivity.this);
                answer.setGravity(View.TEXT_ALIGNMENT_CENTER);
                alert.setView(answer);

                alert.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int whichButton) {
                        Toast toast;
                        if(answer.getText().toString().equals(answerCase[quiz.iCurQuiz])){
                            scrlView.fullScroll(ScrollView.FOCUS_UP);
                            quiz.iCurQuiz++;
                        } else {
                            toast = Toast.makeText(getApplicationContext(), "오답이예요!", Toast.LENGTH_SHORT);
                            toast.setGravity(Gravity.CENTER|Gravity.CENTER, 0, 0);
                            toast.show();
                        }
                    }
                });
                alert.setNegativeButton("취소",new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int whichButton) {
                        Toast toast = Toast.makeText(getApplicationContext(), "다시 도전해 보세요!", Toast.LENGTH_SHORT);
                        toast.setGravity(Gravity.CENTER|Gravity.CENTER, 0, 0);
                        toast.show();
                    }
                });

                alert.setNeutralButton("힌트", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int whichButton) {
                        switch(quiz.iCurQuiz){
                            case 0 :
                                hint.setMessage("지문에 나온 대로 ‘Love Blossom’을 입력하세요.");
                                break;
                            case 1 :
                                hint.setMessage("1. B로 이동하세요.\n" +
                                        "\n" +
                                        "2. 카카오톡 대화에서 민성(남)이 보낸 사진의 간판 이름이 비어있습니다. 이름을 찾아주세요.");
                                break;
                            case 2 :
                                hint.setMessage("1. H로 이동하세요.\n" +
                                        "\n" +
                                        "2. 사진처럼 생긴 조형물을 찾아주시고, 조형물을 세운 날짜를 찾아주세요.");
                                break;
                            case 3 :
                                hint.setMessage("1. J로 이동하세요.\n" +
                                        "\n" +
                                        "2. 사진처럼 생긴 조형물을 찾아주세요. 영어가 숫자로 바뀌어 있습니다." +
                                        "\n" + "a는 1이고, c는 3입니다. 위 순서를 참고하셔서, 지문의 숫자를 영어로 바꾸어주세요.");
                                break;
                            case 4 :
                                hint.setMessage("1. E로 이동하세요.\n" +
                                        "\n" +
                                        "2. 사진처럼 생긴 조형물을 찾아주세요. 이름 아래 영어가 네모로 바뀌었습니다." +
                                        "\n" +
                                        "숫자는 해당 네모의 몇 번째 알파벳인지 나타내는 것입니다.");
                                break;
                            case 5 :
                                hint.setMessage("1. S로 이동하세요.\n" +
                                        "\n" +
                                        "2. 둘의 대화에 특정 지역이 강조되어 있습니다." +
                                        "\n" +
                                        "지도를 켜서, 다이아몬드 모양 속 알파벳을 찾아주세요.");
                                break;
                            case 6 :
                                hint.setMessage("1. C로 이동하세요.\n" +
                                        "\n" +
                                        "2. 사진처럼 생긴 조형물을 찾아주세요. 둘의 대화에 특정 문구가 강조되어 있습니다." +
                                        "\n" +
                                        "그림 속 내용과 문구를 비교해서, 알맞은 그림 위치의 숫자를 찾아주세요.");
                                break;
                            case 7 :
                                hint.setMessage("1. P로 이동하세요.\n" +
                                        "\n" +
                                        "2. 사진을 매장 핸드폰 번호로 보내주세요.");
                                break;
                            case 8 :
                                hint.setMessage("1. Z로 이동하세요.\n" +
                                        "\n" +
                                        "2. 전광판을 찾아주세요. 특정 아이콘에 3-1=ㅈ이라고 되어있는데,"+
                                        "\n" +
                                        "3번째 단어(정)의 자음 모음 중 첫 번째를 의미합니다." +
                                        "\n" +
                                        "이렇게 6개의 자음 모음을 찾고, 그림처럼 배열해주세요.");
                                break;
                            case 9 :
                                hint.setMessage("1. T로 이동하세요.\n" +
                                        "\n" +
                                        "2. 사진처럼 생긴 조형물을 찾아주세요. 조형물에서 빈칸의 단어를 확인해주세요. " +
                                        "\n" +
                                        "한글 단어가 나옵니다. 이를 숫자로 생각해주세요.");
                                break;
                            case 10 :
                                hint.setMessage("1. W로 이동하세요.\n" +
                                        "\n" +
                                        "2. 사진에 나온 카페로 들어가서, 주문을 해주세요.");
                                break;
                            case 11 :
                                hint.setMessage("1. 카카오톡 메시지와 아래 6개 문장을 비교해주세요." +
                                        "\n" +
                                        "비어있는 것이 있습니다. 6개를 찾아 한 단어로 합쳐주세요.");

                                break;
                            case 12 :
                                hint.setMessage("1. 카페에서 나와, 사진을 따라 이동해주세요." +
                                        "\n" +
                                        "이동하면 매장 건물 아래에 도착하게 됩니다. 그곳에서 사진의 빈칸에 들어갈 글자를 찾아주세요.");
                                break;
                        }
                        hint.setNegativeButton("닫기", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int whichButton) {
                                // close
                            }
                        });
                        hint.show();
                    }
                });
                alert.show();
//                alert.getWindow().setGravity(Gravity.TOP);
            }
        });

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

        main_loop();
    }

    public class QuizMaker {
        private int iCurQuiz;
        private int iUnlockedQuiz;
        private String[] titles = new String[14];

        QuizMaker (){
            this.iCurQuiz = 0;
            this.iUnlockedQuiz = 0;
            this.titles[0] = "테마 시작 전 안내 사항";
            this.titles[1] = "약속장소";
            this.titles[2] = "만남";
            this.titles[3] = "시작";
            this.titles[4] = "기다림";
            this.titles[5] = "선택";
            this.titles[6] = "주의사항";
            this.titles[7] = "인생샷";
            this.titles[8] = "기분 나빠";
            this.titles[9] = "식사";
            this.titles[10] = "디저트";
            this.titles[11] = "발각";
            this.titles[12] = "의심";
            this.titles[13] = "이벤트";
        }

        public int getCurr() {
            return iCurQuiz;
        }
        public void setCurr(int iSet) {
            this.iCurQuiz = iSet;
        }

        public int getUnlocked() {
            return iUnlockedQuiz;
        }
        public void setUnlocked(int iUnlock) {
            this.iUnlockedQuiz = iUnlock;
        }

        public boolean isUnlocked(int _page_num){
            if(_page_num == this.getUnlocked()){
                return true;
            } else {
                return false;
            }
        }

        public String getTitle(){
            return this.titles[getCurr()];
        }
    }

    boolean main_loop_flag = true;
    void main_loop() {
        if(main_loop_flag) {
            Handler mainloophandler = new Handler();
            Thread mainloopThd = new Thread(new Runnable() {
                @Override
                public void run() {
                    while (true) {
                        try {
                            mainloophandler.post(new Runnable() {
                                @Override
                                public void run() {
                                    main_loop_content();
                                }
                            });
                            Thread.sleep(1);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            });
            mainloopThd.start();
            main_loop_flag = false;
        }
    }
    int iPage = 0;
    void main_loop_content(){
        progress.setText(quiz.iCurQuiz+" / 15");
        main_title.setText(quiz.titles[quiz.iCurQuiz]);
        switch(iPage){
            case 0 :
                break;
            case 1 :
                break;
            case 2 :
                break;
            case 3 :
                break;
            case 4 :
                break;
            case 5 :
                break;
            case 6 :
                break;
            case 7 :
                break;
            case 8 :
                break;
            case 9 :
                break;
            case 10 :
                break;
            case 11 :
                break;
            case 12 :
                break;
        }
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
                Intent NewActivity = new Intent(MainActivity.this, Map.class);
                startActivity(NewActivity);
                break;
            case R.id.main_menu_memo:
                Intent NewActivity3 = new Intent(MainActivity.this, Memo.class);
                startActivity(NewActivity3);
                break;
            default:
                break;
        }
        return true;
    }
}