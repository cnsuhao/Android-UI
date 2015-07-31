/**<p>项目名：ParallaxViewPager</p>
 * <p>包名：	com.bob.parallaxviewpager</p>
 * <p>文件名：FragmentTest.java</p>
 * <p>版本信息： 2.1.0</p>
 * <p>日期： 2015/6/23/13:48.</p>
 * Copyright (c) 2015帮你公司-版权所有
 */
package com.bob.parallaxviewpager;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * <p>名称：com.bob.parallaxviewpager.FragmentTest</p>
 * <p>描述：</p>
 * <pre>
 *
 * </pre>
 *
 * @author 鲍建明
 * @version 2.1.0
 * @date 2015/6/23/13:48
 */

public class FragmentTest extends Fragment {

    public static FragmentTest newInstance(String text){
        Bundle b = new Bundle();
        b.putString("text", text);
        FragmentTest f = new FragmentTest();
        f.setArguments(b);
        return f;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment, null);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        TextView tv = (TextView) view.findViewById(R.id.tv);
        if( savedInstanceState != null ){
            String str = savedInstanceState.getString("text");
            tv.setText(str);
        }else{
            tv.setText("默认");
        }
    }
}
