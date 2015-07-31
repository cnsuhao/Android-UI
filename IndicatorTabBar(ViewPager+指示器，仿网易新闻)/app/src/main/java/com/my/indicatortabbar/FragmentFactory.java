/**<p>项目名：IndicatorTabBar</p>
 * <p>包名：	com.my.indicatortabbar</p>
 * <p>文件名：FragmentTest.java</p>
 * <p>版本信息： 2.1.0</p>
 * <p>日期： 2015/5/27/13:15.</p>
 * Copyright (c) 2015帮你公司-版权所有
 */
package com.my.indicatortabbar;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * <p>名称：com.my.indicatortabbar.FragmentTest</p>
 * <p>描述：</p>
 * <pre>
 *
 * </pre>
 *
 * @author 鲍建明
 * @version 2.1.0
 * @date 2015/5/27/13:15
 */
public class FragmentFactory  extends Fragment {

    private String mText;
    private final String mText_key = "FragmentFactory";

    public static FragmentFactory newInstance(String mText){
        FragmentFactory mFragmentTest = new FragmentFactory();
        mFragmentTest.mText = mText;
        return mFragmentTest;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if( savedInstanceState != null && savedInstanceState.containsKey(mText_key) ){
            mText = savedInstanceState.getString(mText_key);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        TextView text = new TextView(getActivity());
        text.setGravity(Gravity.CENTER);
        text.setText(mText);
        text.setTextSize(10 * getResources().getDisplayMetrics().density);
        text.setTextColor(Color.GRAY);
        text.setPadding(20, 20, 20, 20);

        LinearLayout layout = new LinearLayout(getActivity());
        layout.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
            LinearLayout.LayoutParams.MATCH_PARENT));
        layout.setGravity(Gravity.CENTER);
        layout.addView(text);
        return layout;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(mText_key, mText);
    }




}
