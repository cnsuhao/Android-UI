/**<p>项目名：RecyclerViewDemo</p>
 * <p>包名：	com.bob.recyclerviewdemo.adapter</p>
 * <p>文件名：SimpleAdapter.java</p>
 * <p>版本信息： 2.1.0</p>
 * <p>日期： 2015/7/5/11:43.</p>
 * Copyright (c) 2015帮你公司-版权所有
 */
package com.bob.recyclerviewdemo.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.bob.recyclerviewdemo.R;

import java.util.List;

/**
 * <p>名称：com.bob.recyclerviewdemo.adapter.SimpleAdapter</p>
 * <p>描述：</p>
 * <pre>
 *
 * </pre>
 *
 * @author 鲍建明
 * @version 2.1.0
 * @date 2015/7/5/11:43
 */

public class SimpleAdapter extends RecyclerView.Adapter<MyViewHolder> {

    protected Context mContext;
    protected List<String> mDatas;
    private LayoutInflater mLayoutInflater;

    public SimpleAdapter(Context mContext, List<String> datas){
        this.mContext = mContext;
        this.mDatas = datas;
        mLayoutInflater = LayoutInflater.from(mContext);
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = mLayoutInflater.inflate(R.layout.recycler_view_item, viewGroup, false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder myViewHolder, final int position) {
        myViewHolder.tv.setText(mDatas.get(position));


        myViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int pos = myViewHolder.getPosition();           //获取当前元素最新的position onBindViewHolder方法传入的position有些问题
                Toast.makeText(mContext, "click postion-->" + pos , Toast.LENGTH_SHORT).show();
            }
        });

        myViewHolder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                int pos = myViewHolder.getPosition();
                Toast.makeText(mContext, "long postion-->" + pos, Toast.LENGTH_SHORT).show();
                return false;
            }
        });


    }

    @Override
    public int getItemCount() {
        return mDatas.size();
    }



    public void addItem(int position){
        mDatas.add(position, "插入一个元素");
        notifyItemInserted(position);
    }

    public void deleteItem(int position){
        mDatas.remove(position);
        notifyItemRemoved(position);
    }


}

class MyViewHolder extends RecyclerView.ViewHolder {

    public TextView tv;

    public MyViewHolder(View itemView) {
        super(itemView);
        tv = (TextView) itemView.findViewById(R.id.tv);
    }

}
