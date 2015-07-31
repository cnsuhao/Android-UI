package com.bob.bezierview;

import android.app.Activity;
import android.os.Bundle;


public class MainActivity extends Activity {

    private BezierView mBezierView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mBezierView = (BezierView) findViewById(R.id.bezier);
        mBezierView.setText("14");          //设置未读信息数
        //mBezierView.setNewText();     //设置有新的信息状态
    }


}
