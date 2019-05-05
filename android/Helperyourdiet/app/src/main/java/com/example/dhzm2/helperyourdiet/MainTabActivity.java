package com.example.dhzm2.helperyourdiet;

import android.app.TabActivity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Icon;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TabHost;

public class MainTabActivity extends TabActivity {
    User member;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_tab);

        Intent input_intent = getIntent();
        member = (User)input_intent.getSerializableExtra("member");

        // 이 탭액티비티에서 사용할 수 있는 TabHost 객체를 얻는다.
        TabHost tab_host = getTabHost();
        // 각 탭에 사용할 TabSpec 객체.
        // 탭호스트에 TabWidget 과 FrameLayout 이 사용할 정보를 넘겨주는 역할을 한다.
        TabHost.TabSpec spec;
        // 각 탭의 FrameLayout 이 사용하는 액티비티를 구성하는 객체
        Intent intent;

        // 탭에서 액티비티를 사용할 수 있도록 인텐트를 생성한다.
        intent = new Intent().setClass(this, KcalInquiryActivity.class);
        // "Kcal Inquiry" 이라는 태그 값을 가진 TabSpec 객체를 생성한다.
        spec = tab_host.newTabSpec("Kcal Inquiry");
        // TabSpec 객체에 TabWidget 객체가 출력할 탭의 이름을 설정한다.
        Drawable ic_char = getResources().getDrawable(R.drawable.ic_action_char);
        spec.setIndicator("",ic_char);
        // TabSpec 객체에 FrameLayout 이 출력할 페이지를 설정한다.
        spec.setContent(intent);
        // 탭호스트에 해당 정보를 가진 탭을 추가한다.
        tab_host.addTab(spec);

        // 탭에서 액티비티를 사용할 수 있도록 인텐트를 생성한다.
        intent = new Intent().setClass(this, MenuUpdateActivity.class);
        // "Menu Update" 이라는 태그 값을 가진 TabSpec 객체를 생성한다.
        spec = tab_host.newTabSpec("Menu Update");
        // TabSpec 객체에 TabWidget 객체가 출력할 탭의 이름을 설정한다.
        Drawable ic_menu = getResources().getDrawable(R.drawable.ic_action_menu);
        spec.setIndicator("",ic_menu);
        // TabSpec 객체에 FrameLayout 이 출력할 페이지를 설정한다.
        spec.setContent(intent);
        // 탭호스트에 해당 정보를 가진 탭을 추가한다.
        tab_host.addTab(spec);

        // 탭에서 액티비티를 사용할 수 있도록 인텐트를 생성한다.
        intent = new Intent().setClass(this, UserInfoUpdateActivity.class);
        // "User Info Update" 이라는 태그 값을 가진 TabSpec 객체를 생성한다.
        spec = tab_host.newTabSpec("User Info Update");
        // TabSpec 객체에 TabWidget 객체가 출력할 탭의 이름을 설정한다.
        Drawable ic_account = getResources().getDrawable(R.drawable.ic_action_account);
        spec.setIndicator("",ic_account);
        // TabSpec 객체에 FrameLayout 이 출력할 페이지를 설정한다.
        spec.setContent(intent);
        // 탭호스트에 해당 정보를 가진 탭을 추가한다.
        tab_host.addTab(spec);


        // 첫번째 탭을 선택한 상태로 지정한다.
        tab_host.setCurrentTab(1);

    }
}
