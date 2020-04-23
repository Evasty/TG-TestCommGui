package com.example.commtestnode.ui.big;

public class ActionItem {

    private String mText1, mText2 ,mText3;

    public ActionItem(){
        mText1 = "this is text 1";
        mText2 = "this is text 2";
        mText3 = "this is text 3";

    }
    public ActionItem( String text1, String text2 , String text3 ){
        mText1 = text1;
        mText2 = text2;
        mText3 = text3;

    }

    public String getText1() {
        return mText1;
    }

    public String getText2() {
        return mText2;
    }

    public String getText3() {
        return mText3;
    }

    public void setmText1(String mText1) {
        this.mText1 = mText1;
    }

    public void setmText2(String mText2) {
        this.mText2 = mText2;
    }

    public void setmText3(String mText3) {
        this.mText3 = mText3;
    }
}

