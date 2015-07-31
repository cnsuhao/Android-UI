/**<p>项目名：DragTopLayout</p>
 * <p>包名：	com.bob.sample.fragment</p>
 * <p>文件名：RecyclerViewFragment.java</p>
 * <p>版本信息： 2.1.0</p>
 * <p>日期： 2015/7/1/14:05.</p>
 * Copyright (c) 2015帮你公司-版权所有
 */
package com.bob.sample.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.bob.library.AttachUtil;
import com.bob.sample.DragTopLayoutEvent;
import com.bob.sample.R;

import java.util.Arrays;
import java.util.List;

/**
 * <p>名称：com.bob.sample.fragment.RecyclerViewFragment</p>
 * <p>描述：</p>
 * <pre>
 *
 * </pre>
 *
 * @author 鲍建明
 * @version 2.1.0
 * @date 2015/7/1/14:05
 */

public class RecyclerViewFragment extends Fragment {

    private DragTopLayoutEvent mDragTopLayoutEvent;
    private RecyclerView mRecyclerView;
    private List<String> dataList = Arrays.asList("test3", "test3", "test3", "test3", "test2", "test3",
            "test2", "test2", "test2", "test2", "test2", "test2", "test2", "test2", "test2", "test2", "test2", "test2");

    public RecyclerViewFragment setDragTopLayoutEvent( DragTopLayoutEvent mDragTopLayoutEvent){
        this.mDragTopLayoutEvent = mDragTopLayoutEvent;
        return this;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.recycler_view_fragment, null);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        mRecyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);

       //创建默认的线性LayoutManager  如果不创建该布局会报空指针异常
        LinearLayoutManager layoutManager = new LinearLayoutManager(this.getActivity().getApplicationContext());
//		layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        // 设置布局管理器
        mRecyclerView.setLayoutManager(layoutManager);
        //如果可以确定每个item的高度是固定的，设置这个选项可以提高性能
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setAdapter( new MyBaseRecyclerAdapter(dataList.toArray(new String[]{})));

        // attach top listener
        mRecyclerView.setOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
            }


            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                if( mDragTopLayoutEvent != null){
                    mDragTopLayoutEvent.onEvent(AttachUtil.isRecyclerViewAttach(recyclerView));
                }
            }
        });

    }



    class MyBaseRecyclerAdapter extends RecyclerView.Adapter<MyBaseRecyclerAdapter.MyViewHolder>{


        public  class MyViewHolder extends RecyclerView.ViewHolder {

            public TextView mTextView ;

            public MyViewHolder(View itemView) {
                super(itemView);
                this.mTextView = (TextView) itemView;
            }
        }

        private String[] datas;

        public MyBaseRecyclerAdapter(String[] datas){
            this.datas = datas;
        }



        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
           View view = View.inflate(parent.getContext(), android.R.layout.simple_list_item_1, null);
            //TextView v = (TextView) LayoutInflater.from(parent.getContext()).inflate(android.R.layout.simple_list_item_1, null);
           // View view = LayoutInflater.from(parent.getContext()).inflate(android.R.layout.simple_list_item_1, parent, false);
            return new MyViewHolder(view);
        }

        @Override
        public void onBindViewHolder(MyViewHolder holder, int position) {
            holder.mTextView.setText(datas[position]);
        }


        @Override
        public int getItemCount() {
            return datas.length;
        }
    }
}
