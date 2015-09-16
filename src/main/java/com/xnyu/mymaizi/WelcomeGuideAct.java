package com.xnyu.mymaizi;

import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class WelcomeGuideAct extends AppCompatActivity {

    @Bind(R.id.welcome_guide_btn)
     Button mWelcomeGuideBtn;
    @Bind(R.id.welcome_pager)
     ViewPager mWelcomePager;
    private List<View> mViewList ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcomeguide);
        ButterKnife.bind(this);
        init();

    }

    public void init() {
        mViewList = new ArrayList<View>();
        ImageView iv = new ImageView(this);
        iv.setImageResource(R.drawable.guide_01);
        mViewList.add(iv);
        ImageView iv2 = new ImageView(this);
        iv2.setImageResource(R.drawable.guide_02);
        mViewList.add(iv2);
        ImageView iv3 = new ImageView(this);
        iv3.setImageResource(R.drawable.guide_03);
        mViewList.add(iv3);
        mWelcomePager.setAdapter(new MyViewPagerAdapter());
        //监听ViewPager滑动事件
        mWelcomePager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if (position==2){
                    mWelcomeGuideBtn.setVisibility(View.VISIBLE);
                }else {
                    mWelcomeGuideBtn.setVisibility(View.GONE);
                }

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }

    @OnClick(R.id.welcome_guide_btn)
    public void Onclick(View view){

    }

    class MyViewPagerAdapter extends PagerAdapter{

        @Override
        public int getCount() {
            return mViewList.size();
        }

        //初始化item方法
        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view==object;
        }
        //销毁item方法
        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            container.addView(mViewList.get(position));
            return mViewList.get(position);
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
//            super.destroyItem(container, position, object);
            container.removeView(mViewList.get(position));
        }
    }


}
