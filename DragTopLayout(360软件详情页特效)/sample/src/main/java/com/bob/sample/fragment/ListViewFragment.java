/**<p>项目名：DragTopLayout</p>
 * <p>包名：	com.bob.sample.fragment</p>
 * <p>文件名：ListViewFragment.java</p>
 * <p>版本信息： 2.1.0</p>
 * <p>日期： 2015/7/1/11:15.</p>
 * Copyright (c) 2015帮你公司-版权所有
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
import android.widget.ListView;

import com.bob.library.AttachUtil;
import com.bob.sample.DragTopLayoutEvent;
import com.bob.sample.R;

import java.util.Arrays;
import java.util.List;

/**
 * <p>名称：com.bob.sample.fragment.ListViewFragment</p>
 * <p>描述：</p>
 * <pre>
 *
 * </pre>
 *
 * @author 鲍建明
 * @version 2.1.0
 * @date 2015/7/1/11:15
 */

public class ListViewFragment extends Fragment {

    private DragTopLayoutEvent mDragTopLayoutEvent;

    public ListViewFragment setDragTopLayoutEvent( DragTopLayoutEvent mDragTopLayoutEvent){
        this.mDragTopLayoutEvent = mDragTopLayoutEvent;
        return this;
    }

    private List<String> datas = Arrays.asList("test1", "test1", "test1", "test1", "test1", "test1",
            "test1", "test1", "test1", "test1","test1","test1","test1","test1","test1","test1","test1","test1");
    private ListView mListView;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.list_view_fragment, null);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        mListView = (ListView) view.findViewById(R.id.list_view);
        mListView.setAdapter(new ArrayAdapter<String>(getActivity().getApplicationContext(), android.R.layout.simple_list_item_1, datas));


        // attach top
        mListView.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {
            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount,
                                 int totalItemCount) {
                if(mDragTopLayoutEvent != null){
                    mDragTopLayoutEvent.onEvent(AttachUtil.isAdapterViewAttach(view));
                }
            }
        });
    }

}
