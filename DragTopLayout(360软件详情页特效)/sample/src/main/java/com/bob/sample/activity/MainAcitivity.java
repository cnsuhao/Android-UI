/**<p>项目名：DragTopLayout</p>
 * <p>包名：	com.bob.sample.activity</p>
 * <p>文件名：MainAcitivity.java</p>
 * <p>版本信息： 2.1.0</p>
 * <p>日期： 2015/7/1/10:50.</p>
 * Copyright (c) 2015帮你公司-版权所有
 */
package com.bob.sample.activity;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.bob.library.DragTopLayout;
import com.bob.sample.DragTopLayoutEvent;
import com.bob.sample.R;
import com.bob.sample.fragment.GridViewFragment;
import com.bob.sample.fragment.ListViewFragment;
import com.bob.sample.fragment.RecyclerViewFragment;
import com.bob.sample.fragment.ScrollViewFragment;
import com.bob.sample.fragment.WebViewFragment;
import com.bob.sample.widget.PagerSlidingTabStrip;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * <p>名称：com.bob.sample.activity.MainAcitivity</p>
 * <p>描述：</p>
 * <pre>
 *
 * </pre>
 *
 * @author 鲍建明
 * @version 2.1.0
 * @date 2015/7/1/10:50
 */

public class MainAcitivity extends ActionBarActivity implements SwipeRefreshLayout.OnRefreshListener{

    private Toolbar mToolbar;
    private DragTopLayout mDragTopLayout;
    private PagerSlidingTabStrip mPagerSlidingTabStrip;
    private ViewPager mViewPager;
    private View topView;
    private SwipeRefreshLayout mSwipeRefreshLayout;
    private final List<String> tabs = Arrays.asList("ListView", "GridView", "RecyclerView", "ScrollView", "WebView");//,
    private final List<Fragment> fragments = new ArrayList<>();

    private DragTopLayoutEvent mDragTopLayoutEvent = new DragTopLayoutEvent(){
        @Override
        public void onEvent(boolean b) {
            mDragTopLayout.setTouchMode(b);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        init();
        initToolbar();
        initViewPager();

        //如果不想要点击隐藏头部布局的时候，重写这个方法
        topView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(MainAcitivity.this, "onClick...", Toast.LENGTH_LONG).show();
            }
        });
        initSwipeRefreshLayout();
    }

    //初始化组件
    private void init(){
        mToolbar = (Toolbar) findViewById(R.id.tool_bar);
        topView = findViewById(R.id.top_view);
        mSwipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.swipe_container);
        mDragTopLayout = (DragTopLayout) findViewById(R.id.drag_layout);
        mPagerSlidingTabStrip = (PagerSlidingTabStrip) findViewById(R.id.pager_tabstrip);
        mViewPager = (ViewPager) findViewById(R.id.view_pager);
    }

    //初始化ToolBar组件
    private void initToolbar(){
        mToolbar.setTitle("仿360软件详情页特效");
        mToolbar.setTitleTextColor(Color.parseColor("#FFFFFF"));
        setSupportActionBar(mToolbar);
    }

    //初始化ViewPager
    private void initViewPager(){
        fragments.add(new ListViewFragment().setDragTopLayoutEvent(mDragTopLayoutEvent));
        fragments.add(new GridViewFragment().setDragTopLayoutEvent(mDragTopLayoutEvent));
        fragments.add(new RecyclerViewFragment().setDragTopLayoutEvent(mDragTopLayoutEvent));
        fragments.add(new ScrollViewFragment().setDragTopLayoutEvent(mDragTopLayoutEvent));
        fragments.add(new WebViewFragment().setDragTopLayoutEvent(mDragTopLayoutEvent));
        MyFragmentAdapter fa = new MyFragmentAdapter(super.getSupportFragmentManager());
        mViewPager.setAdapter(fa);
        mPagerSlidingTabStrip.setViewPager(mViewPager);
        fa.notifyDataSetChanged();

    }

    //初始化下拉刷新的组件
    private void initSwipeRefreshLayout(){

        mSwipeRefreshLayout.setOnRefreshListener(this);
        mSwipeRefreshLayout.setColorSchemeColors(android.R.color.white,
                android.R.color.holo_green_light,
                android.R.color.holo_orange_light, android.R.color.holo_red_light);
    }

    @Override
    public void onRefresh() {

        if( !mSwipeRefreshLayout.isRefreshing()){
            return ;
        }
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                mSwipeRefreshLayout.setRefreshing(false);
            }
        }, TimeUnit.SECONDS.toMillis(3));
    }


    class MyFragmentAdapter extends FragmentStatePagerAdapter {


        public MyFragmentAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return fragments.get(position);
        }


        @Override
        public int getCount() {
            return fragments.size();
        }


        @Override
        public CharSequence getPageTitle(int position) {
            return tabs.get(position);
        }

        /**
         * 更新PageViewFragment
         */
        @Override
        public void notifyDataSetChanged() {
            super.notifyDataSetChanged();
            for (String title : tabs) {
                TextView v = (TextView) LayoutInflater.from(getApplicationContext()).inflate(R.layout.sliding_tab_item, null);
                v.setText(title);
                mPagerSlidingTabStrip.addTab(v);
            }
        }

    }




}
