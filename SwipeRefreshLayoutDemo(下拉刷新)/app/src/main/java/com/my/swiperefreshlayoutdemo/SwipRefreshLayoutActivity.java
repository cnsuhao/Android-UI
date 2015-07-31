/**<p>项目名：SwipeRefreshLayoutDemo</p>
 * <p>包名：	com.my.swiperefreshlayoutdemo</p>
 * <p>文件名：SwipRefreshLayoutActivity.java</p>
 * <p>版本信息： 2.1.0</p>
 * <p>日期： 2015/4/27/15:09.</p>
 * Copyright (c) 2015帮你公司-版权所有
 */
package com.my.swiperefreshlayoutdemo;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListView;

/**
 * <p>名称：com.my.swiperefreshlayoutdemo.SwipRefreshLayoutActivity</p>
 * <p>描述：</p>
 * <pre>
 *
 * </pre>
 *
 * @author 鲍建明
 * @version 2.1.0
 * @date 2015/4/27/15:09
 */
public class SwipRefreshLayoutActivity extends Activity implements SwipeRefreshLayout.OnRefreshListener{

    private SwipeRefreshLayout swipeLayout;
    private ListView listView;
    private ArrayList<String> list;
    private BaseAdapter adapter;
    private boolean isRefresh = false;//是否刷新中

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.swipe_refresh_layout);
        swipeLayout = (SwipeRefreshLayout) findViewById(R.id.swipe_container);
        swipeLayout.setOnRefreshListener(this);
        //加载颜色是循环播放的，只要没有完成刷新就会一直循环，color1>color2>color3>color4
        swipeLayout.setColorSchemeColors(android.R.color.white,
            android.R.color.holo_green_light,
            android.R.color.holo_orange_light, android.R.color.holo_red_light);

        list = new ArrayList<String>();
        list.add("fdsafsd");
        listView = (ListView) findViewById(R.id.list);
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1, list);
        listView.setAdapter(adapter);
    }

    public void onRefresh() {
        //swipeLayout.isRefreshing();
        if (!isRefresh) {
            isRefresh = true;
            new Handler().postDelayed(new Runnable() {
                public void run() {
                    swipeLayout.setRefreshing(false);
                    list.add("fds");
                    adapter.notifyDataSetChanged();
                    isRefresh = false;
                }
            }, 3000);
        }
    }
}
