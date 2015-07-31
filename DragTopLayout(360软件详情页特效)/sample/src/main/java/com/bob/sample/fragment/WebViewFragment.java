/**<p>项目名：DragTopLayout</p>
 * <p>包名：	com.bob.sample.fragment</p>
 * <p>文件名：WebViewFragment.java</p>
 * <p>版本信息： 2.1.0</p>
 * <p>日期： 2015/7/2/11:15.</p>
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
import android.webkit.WebView;

import com.bob.library.AttachUtil;
import com.bob.sample.DragTopLayoutEvent;
import com.bob.sample.R;

/**
 * <p>名称：com.bob.sample.fragment.WebViewFragment</p>
 * <p>描述：</p>
 * <pre>
 *
 * </pre>
 *
 * @author 鲍建明
 * @version 2.1.0
 * @date 2015/7/2/11:15
 */

public class WebViewFragment extends Fragment {

    private WebView mWebView;
    private DragTopLayoutEvent mDragTopLayoutEvent;

    public WebViewFragment setDragTopLayoutEvent( DragTopLayoutEvent mDragTopLayoutEvent){
        this.mDragTopLayoutEvent = mDragTopLayoutEvent;
        return this;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_webview, null);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        mWebView = (WebView) view.findViewById(R.id.web_view);
        mWebView.loadUrl("http://www.baidu.com");
        mWebView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if( mDragTopLayoutEvent != null){
                    mDragTopLayoutEvent.onEvent(AttachUtil.isWebViewAttach(mWebView));
                }
                return false;
            }
        });
    }
}
