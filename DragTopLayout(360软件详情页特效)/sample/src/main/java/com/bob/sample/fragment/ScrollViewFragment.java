/**<p>项目名：DragTopLayout</p>
 * <p>包名：	com.bob.sample.fragment</p>
 * <p>文件名：ScrollViewFragment.java</p>
 * <p>版本信息： 2.1.0</p>
 * <p>日期： 2015/7/2/11:08.</p>
 * Copyright (c) 2015帮你公司-版权所有
 */
package com.bob.sample.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;

import com.bob.library.AttachUtil;
import com.bob.sample.DragTopLayoutEvent;
import com.bob.sample.R;

/**
 * <p>名称：com.bob.sample.fragment.ScrollViewFragment</p>
 * <p>描述：</p>
 * <pre>
 *
 * </pre>
 *
 * @author 鲍建明
 * @version 2.1.0
 * @date 2015/7/2/11:08
 */

public class ScrollViewFragment extends Fragment {

    private ScrollView mScrollView;


    private DragTopLayoutEvent mDragTopLayoutEvent;

    public ScrollViewFragment setDragTopLayoutEvent( DragTopLayoutEvent mDragTopLayoutEvent){
        this.mDragTopLayoutEvent = mDragTopLayoutEvent;
        return this;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_scrollview, null);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        mScrollView = (ScrollView) view.findViewById(R.id.scroll_view);

        mScrollView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if( mDragTopLayoutEvent != null){
                    mDragTopLayoutEvent.onEvent(AttachUtil.isScrollViewAttach(mScrollView));
                }
                return false;
            }
        });
    }
}
