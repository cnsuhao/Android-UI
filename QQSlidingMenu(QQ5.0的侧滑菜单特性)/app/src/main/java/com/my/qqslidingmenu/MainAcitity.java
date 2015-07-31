/**<p>项目名：QQSlidingMenu</p>
 * <p>包名：	com.my.qqslidingmenu</p>
 * <p>文件名：MainAcitity.java</p>
 * <p>版本信息： 2.1.0</p>
 * <p>日期： 2015/5/4/13:36.</p>
 * Copyright (c) 2015帮你公司-版权所有
 */
package com.my.qqslidingmenu;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

/**
 * <p>名称：com.my.qqslidingmenu.MainAcitity</p>
 * <p>描述：</p>
 * <pre>
 *
 * </pre>
 *
 * @author 鲍建明
 * @version 2.1.0
 * @date 2015/5/4/13:36
 */
public class MainAcitity extends Activity implements View.OnClickListener{


    private SlidingMenu mSlidingMenu;

    private Button mBtn;
    private ListView mListView;
    private MyListAdapter mMyListAdapter;
    private String[] data = {"菜单一", "菜单二", "菜单三", "菜单四","菜单五","菜单六","菜单七","菜单八","菜单九","菜单十","菜单十一","菜单十二"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.main);
        mSlidingMenu = (SlidingMenu) findViewById(R.id.siliding_menu);
        mBtn = (Button) findViewById(R.id.sliding_btn);
        mBtn.setOnClickListener(this);

        mListView = (ListView) findViewById(R.id.listView);
        mMyListAdapter = new MyListAdapter(this, R.layout.left_menu, data);
        mListView.setAdapter(mMyListAdapter);

    }

    public void toggleMenu(View view)
    {
        mSlidingMenu.toggle();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.sliding_btn :
                toggleMenu(v);
                break;
        }
    }


    /**
     * 监听物理返回键的操作
     */
    @Override
    public void onBackPressed() {
        if( mSlidingMenu.isOpen() ){
            mSlidingMenu.toggle();
        }else{
            super.onBackPressed();
        }
    }


    /**
     * 左边菜单的ListView菜单
     */
    class MyListAdapter extends ArrayAdapter<String>{

        private int resource;

        public MyListAdapter(Context context, int resource, String[] objects) {
            super(context, resource, objects);
            this.resource = resource;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            String str = getItem(position);
            Hodler hodler = null;
            if( convertView == null ){
                hodler = new Hodler();
                convertView = LayoutInflater.from(getContext()).inflate(resource, null);
                hodler.tv = (TextView) convertView.findViewById(R.id.list_text_view);
                convertView.setTag(hodler);
            }else {
                hodler = (Hodler) convertView.getTag();
            }
            hodler.tv.setText(str);
            return convertView;
        }

        class Hodler {
            TextView tv;
        }
    }

}
