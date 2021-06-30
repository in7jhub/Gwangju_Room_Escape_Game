package com.game.blossom;

import android.app.Application;

public class Page extends Application {
    private int mGlobalPageCurr;
    private int mGlobalPageUnlocked;
    private String[] titles = new String[13];

    Page(){
        this.mGlobalPageCurr = 0;
        this.mGlobalPageUnlocked = 0;
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
        return mGlobalPageCurr;
    }
    public void setCurr(int globalPageCurr) {
        this.mGlobalPageCurr = globalPageCurr;
    }

    public int getUnlocked() {
        return mGlobalPageUnlocked;
    }
    public void setLimit(int globalPageUnlocked) {
        this.mGlobalPageUnlocked = globalPageUnlocked;
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