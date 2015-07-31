/**<p>项目名：DragTopLayout</p>
 * <p>包名：	com.bob.sample.fragment</p>
 * <p>文件名：GridViewFragment.java</p>
 * <p>版本信息： 1.1.0</p>
 * <p>日期： 2015/7/2/23:59.</p>
 * Copyright (c) 2025帮你公司-版权所有
 */
package com.bob.sample.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ArrayAdapter;
import android.widget.GridView;

import com.bob.library.AttachUtil;
import com.bob.sample.DragTopLayoutEvent;
import com.bob.sample.R;

import java.util.Arrays;
import java.util.List;

/**
 * <p>名称：com.bob.sample.fragment.GridViewFragment</p>
 * <p>描述：</p>
 * <pre>
 *
 * </pre>
 *
 * @author 鲍建明
 * @version 1.1.0
 * @date 2015/7/2/23:59
 */

public class GridViewFragment extends Fragment {

    private DragTopLayoutEvent mDragTopLayoutEvent;
    private GridView mGridView;
    private List<String> datas = Arrays.asList("test2", "test2", "test2", "test2", "test2", "test2",
            "test2", "test2", "test2", "test2", "test2", "test2", "test2", "test2", "test2", "test2", "test2", "test2");


    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.grid_view_fragment, null);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        mGridView = (GridView) view.findViewById(R.id.grid_view);
        mGridView.setAdapter(new ArrayAdapter<String>(getActivity().getApplicationContext(), android.R.layout.simple_list_item_1, datas) );


        // attach top
        mGridView.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {
            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
                if( mDragTopLayoutEvent != null ){
                    mDragTopLayoutEvent.onEvent(AttachUtil.isAdapterViewAttach(view));
                }
            }
        });
    }

    public GridViewFragment setDragTopLayoutEvent( DragTopLayoutEvent mDragTopLayoutEvent){
        this.mDragTopLayoutEvent = mDragTopLayoutEvent;
        return this;
    }
}
