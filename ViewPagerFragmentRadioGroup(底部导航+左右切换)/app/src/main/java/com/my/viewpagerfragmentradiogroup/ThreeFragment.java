/**<p>项目名：ViewPagerFragmentRadioGroup</p>
 * <p>包名：	com.my.viewpagerfragmentradiogroup</p>
 * <p>文件名：ThreeFragemtn.java</p>
 * <p>版本信息： 2.1.0</p>
 * <p>日期： 2015/5/14/13:04.</p>
 * Copyright (c) 2015帮你公司-版权所有
 */
package com.my.viewpagerfragmentradiogroup;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * <p>名称：com.my.viewpagerfragmentradiogroup.ThreeFragemtn</p>
 * <p>描述：</p>
 * <pre>
 *
 * </pre>
 *
 * @author 鲍建明
 * @version 2.1.0
 * @date 2015/5/14/13:04
 */
public class ThreeFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment, container, false);
        TextView tv = (TextView) v.findViewById(R.id.fragment_tv);
        tv.setText("ThreeFragment.....");
        return v;
    }
}
