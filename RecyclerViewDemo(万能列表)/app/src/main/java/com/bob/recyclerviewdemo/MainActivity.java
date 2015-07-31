/**<p>项目名：RecyclerViewDemo</p>
 * <p>包名：	com.bob.recyclerviewdemo</p>
 * <p>文件名：MainActivity.java</p>
 * <p>版本信息： 2.1.0</p>
 * <p>日期： 2015/7/5/11:41.</p>
 * Copyright (c) 2015帮你公司-版权所有
 */
package com.bob.recyclerviewdemo;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.bob.recyclerviewdemo.adapter.SimpleAdapter;
import com.bob.recyclerviewdemo.adapter.WaterfallAdapter;
import com.bob.recyclerviewdemo.decoration.DividerItemDecoration;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>名称：com.bob.recyclerviewdemo.MainActivity</p>
 * <p>描述：</p>
 * <pre>
 *
 * </pre>
 *
 * @author 鲍建明
 * @version 2.1.0
 * @date 2015/7/5/11:41
 */

public class MainActivity extends ActionBarActivity {
    private RecyclerView mRecyclerView;
    private List<String> mDatas;
    private Toolbar mToolbar;
    private SimpleAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        initDatas();
        initView();

        initSimpleAdapter();
        LinearLayoutManager manager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        mRecyclerView.setLayoutManager(manager);

       // mRecyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL_LIST)); 添加自定义分隔线
       // mRecyclerView.addItemDecoration();   添加间隙分隔线
       // mRecyclerView.setLayoutManager();   添加布局结构
        //mRecyclerView.setItemAnimator();            添加Item增加与删除的动画
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());       //使用默认添加删除动画
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.add:
                adapter.addItem(1);
                break;
            case R.id.delete:
                adapter.deleteItem(1);
                break;
            case R.id.recycler_list_view:           //ListView
                LinearLayoutManager manager = new LinearLayoutManager(this);
                mRecyclerView.setLayoutManager(manager);
                initSimpleAdapter();
                break;
            case R.id.recycler_grid_view:       //纵向GridView
                GridLayoutManager mGridLayoutManager = new GridLayoutManager(this, 3);
                mRecyclerView.setLayoutManager(mGridLayoutManager);
                initSimpleAdapter();
                break;
            case R.id.recycler_grid_view_hor:           //横向GridView
                StaggeredGridLayoutManager mStaggeredGridLayoutManager = new StaggeredGridLayoutManager(5, StaggeredGridLayoutManager.HORIZONTAL);
                mRecyclerView.setLayoutManager(mStaggeredGridLayoutManager);
                initSimpleAdapter();
                break;
            case R.id.waterfall:                    //瀑布流
                initWaterFallAdapter();
                StaggeredGridLayoutManager waterfall = new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL);
                mRecyclerView.setLayoutManager(waterfall);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private void initWaterFallAdapter(){
        adapter = new WaterfallAdapter(this, mDatas);
        mRecyclerView.setAdapter(adapter);
    }

    private void initSimpleAdapter(){
        adapter = new SimpleAdapter(this, mDatas);
        mRecyclerView.setAdapter(adapter);
    }

    private void initView() {
        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mToolbar.setTitle("RecyclerView Demo");
        mToolbar.setTitleTextColor(Color.parseColor("#FFFFFF"));
        setSupportActionBar(mToolbar);
    }

    private void initDatas() {
        mDatas = new ArrayList<>();
        for( int i = 'A'; i < 'z'; i++){
            mDatas.add( (char)i + "");
        }
    }

}
