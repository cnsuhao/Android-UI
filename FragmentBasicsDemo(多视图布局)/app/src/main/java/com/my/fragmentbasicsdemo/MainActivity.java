/**<p>项目名：FragmentBasicsDemo</p>
 * <p>包名：	com.my.fragmentbasicsdemo</p>
 * <p>文件名：MainActivity.java</p>
 * <p>版本信息： 2.1.0</p>
 * <p>日期： 2015/4/27/16:51.</p>
 * Copyright (c) 2015帮你公司-版权所有
 */
package com.my.fragmentbasicsdemo;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;

/**
 * <p>名称：com.my.fragmentbasicsdemo.MainActivity</p>
 * <p>描述：</p>
 * <pre>
 *
 *  手机加载layout下的news_articles.xml文件，该文件加载完之后只有一个FragmentLayout 在初始化的时候，只有一个HeadlinesFragment(菜单)被加入，因此在手机中显示时，只有菜单看的到
 *  平板加载layout-large下的news_articles.xml文件，该文件中有2个Fragment, 初始化话的时候只加载了HeadlinesFragment(菜单),因此右边是空的
 *  只有左边的菜单被点击的时候，才触发右边的Fragment显示
 *
 *
 * </pre>
 *
 * @author 鲍建明
 * @version 2.1.0
 * @date 2015/4/27/16:51
 */
public class MainActivity extends FragmentActivity implements HeadlinesFragment.OnHeadlineSelectedListener {

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.news_articles);

        // Check whether the activity is using the layout version with
        // the fragment_container FrameLayout. If so, we must add the first fragment
        if (findViewById(R.id.fragment_container) != null) {

            // However, if we're being restored from a previous state,
            // then we don't need to do anything and should return or else
            // we could end up with overlapping fragments.
            if (savedInstanceState != null) {
                return;
            }

            // Create an instance of ExampleFragment
            HeadlinesFragment firstFragment = new HeadlinesFragment();          //初始化左边的菜单

            // In case this activity was started with special instructions from an Intent,
            // pass the Intent's extras to the fragment as arguments
            firstFragment.setArguments(getIntent().getExtras());

            // Add the fragment to the 'fragment_container' FrameLayout
            getSupportFragmentManager().beginTransaction()
                .add(R.id.fragment_container, firstFragment).commit();
        }
    }

    public void onArticleSelected(int position) {
        // The user selected the headline of an article_view from the HeadlinesFragment

        // Capture the article_view fragment from the activity layout
        ArticleFragment articleFrag = (ArticleFragment)
            getSupportFragmentManager().findFragmentById(R.id.article_fragment);

        if (articleFrag != null) {
            // If article_view frag is available, we're in two-pane layout...

            // Call a method in the ArticleFragment to update its content
            articleFrag.updateArticleView(position);

        } else {
            // If the frag is not available, we're in the one-pane layout and must swap frags...

            // Create fragment and give it an argument for the selected article_view
            ArticleFragment newFragment = new ArticleFragment();
            Bundle args = new Bundle();
            args.putInt(ArticleFragment.ARG_POSITION, position);
            newFragment.setArguments(args);
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

            // Replace whatever is in the fragment_container view with this fragment,
            // and add the transaction to the back stack so the user can navigate back
            transaction.replace(R.id.fragment_container, newFragment);
            transaction.addToBackStack(null);

            // Commit the transaction
            transaction.commit();
        }
    }
}
