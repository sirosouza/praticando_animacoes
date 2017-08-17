package br.com.dev_sirox.praticandoanimacoes;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private boolean isShow = false;

    private TextView mTextMessage;
    private ImageView img_filter;
    private ImageView img_image_test;
    private ListView lv_data;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    mTextMessage.setText(R.string.title_home);
                    return true;
                case R.id.navigation_dashboard:
                    mTextMessage.setText(R.string.title_dashboard);
                    return true;
                case R.id.navigation_notifications:
                    mTextMessage.setText(R.string.title_notifications);
                    return true;
            }
            return false;
        }

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextMessage = (TextView) findViewById(R.id.message);
        img_filter = (ImageView) findViewById(R.id.img_filter);
        img_image_test = (ImageView) findViewById(R.id.img_image_test);
        lv_data = (ListView) findViewById(R.id.lv_data);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        img_filter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isShow != true) {
                    Animation animationListView = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slide_down);
                    Animation animationView = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.move_down);
                    lv_data.setVisibility(View.VISIBLE);
                    lv_data.setAnimation(animationListView);
                    img_image_test.setAnimation(animationView);
                    isShow = true;
                } else {
                    Animation animationListView = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slide_up);
                    Animation animationView = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.move_up);
                    lv_data.setVisibility(View.GONE);
                    lv_data.setAnimation(animationListView);
                    img_image_test.setAnimation(animationView);
                    isShow = false;
                }
            }
        });
    }

}
