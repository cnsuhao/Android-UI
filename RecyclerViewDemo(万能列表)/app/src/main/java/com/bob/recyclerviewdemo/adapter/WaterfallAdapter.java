/**<p>项目名：RecyclerViewDemo</p>
 * <p>包名：	com.bob.recyclerviewdemo.adapter</p>
 * <p>文件名：WaterfallAdapter.java</p>
 * <p>版本信息： 2.1.0</p>
 * <p>日期： 2015/7/5/15:58.</p>
 * Copyright (c) 2015帮你公司-版权所有
 */
package com.bob.recyclerviewdemo.adapter;

import android.content.Context;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * <p>名称：com.bob.recyclerviewdemo.adapter.WaterfallAdapter</p>
 * <p>描述：</p>
 * <pre>
 *
 * </pre>
 *
 * @author 鲍建明
 * @version 2.1.0
 * @date 2015/7/5/15:58
 */

public class WaterfallAdapter extends SimpleAdapter {

    private List<Integer> mHeights;

    public WaterfallAdapter(Context mContext, List<String> datas) {
        super(mContext, datas);
        mHeights = new ArrayList<>();
        for (int i = 0; i < mDatas.size(); i++){
            int height = (int) (100 + Math.random() * 300);
            mHeights.add(height);
        }
    }

    @Override
    public void onBindViewHolder(MyViewHolder myViewHolder, int i) {
        ViewGroup.LayoutParams mLayoutParams = myViewHolder.itemView.getLayoutParams();     //这里的子布局只能使用相对布局才有效
        mLayoutParams.height = mHeights.get(i);
        myViewHolder.itemView.setLayoutParams(mLayoutParams);
        super.onBindViewHolder(myViewHolder, i);
    }
}
