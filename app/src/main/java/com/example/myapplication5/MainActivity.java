package com.example.myapplication5;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.sc_title)
    LinkageScrollView scTitle;
    @BindView(R.id.left_list)
    MyListView leftList;
    @BindView(R.id.left_container)
    LinearLayout leftContainer;
    @BindView(R.id.content_list)
    MyListView contentList;
    @BindView(R.id.sc_content)
    LinkageScrollView scContent;

    @BindView(R.id.right_list)
    MyListView rightList;
    @BindView(R.id.right_container)
    LinearLayout rightContainer;

    @BindView(R.id.ll_title)
    LinearLayout llTitle;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {
        for (int i = 0; i < 20; i++) {
            View inflate = View.inflate(this, R.layout.item_child_layout2, null);
            TextView name = inflate.findViewById(R.id.tv);
            name.setText("类别" + i);
            llTitle.addView(inflate);
        }

        scContent.setScrollView(scTitle);
        scTitle.setScrollView(scContent);
        leftList.setAdapter(new LeftAdapter(this));
        contentList.setAdapter(new RightAdapter(this, new RightAdapter.OnMyClickListener() {
            @Override
            public void onClick(int index, int line,String str) {
                Log.e("debug","index line str ---- "+index+" "+line+" "+str);
            }
        }));

        rightList.setAdapter(new LeftAdapter(this));
    }
}
