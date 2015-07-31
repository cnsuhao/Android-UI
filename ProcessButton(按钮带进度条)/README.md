##	按钮带有进度条特效 ##
###使用一：
<code>

	 	<com.bob.library.impl.ActionProcessButton
        android:id="@+id/btnAction"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:text="@string/Upload"
        android:textColor="@android:color/white"
        android:textSize="18sp"
        custom:pb_textComplete="@string/Done"
        custom:pb_textProgress="@string/Uploading"
        custom:pb_textError="Error"/>
</code>

效果图：

![]('pic/sample1.gif')

###使用二：
<code>

  	<com.bob.library.impl.SubmitProcessButton
        android:id="@+id/btnSubmit"
        android:layout_width="match_parent"
        android:layout_height="48dp"
        android:layout_marginTop="16dp"
        android:text="@string/Upload"
        android:textColor="@android:color/white"
        android:textSize="18sp"
        custom:pb_textComplete="@string/Done"
        custom:pb_textProgress="@string/Uploading"
        custom:pb_textError="Error"/>

</code>

效果图：
![]("pic/sample2.gif")


###使用三：
<code>

  	 <com.bob.library.impl.GenerateProcessButton
        android:id="@+id/btnGenerate"
        android:layout_width="match_parent"
        android:layout_height="48dp"
        android:layout_marginTop="16dp"
        android:text="@string/Upload"
        android:textColor="@android:color/white"
        android:textSize="18sp"
        custom:pb_textComplete="@string/Done"
        custom:pb_textProgress="@string/Uploading"
        custom:pb_textError="Error"/>

</code>

效果图：
![]("pic/sample3.gif")

比较全的属性说明：
<code>

  		xmlns:custom="http://schemas.android.com/apk/res-auto"
	  	<com.bob.library.impl.ActionProcessButton
            android:id="@+id/btnSignIn"
            android:layout_width="match_parent"
            android:layout_height="48dp"
            android:layout_marginBottom="16dp"
            android:text="@string/Sign_in"
            android:textColor="@android:color/white"
            android:textSize="18sp"
            custom:pb_colorComplete="@color/green_complete"
            custom:pb_colorNormal="@color/blue_normal"
            custom:pb_colorPressed="@color/blue_pressed"
            custom:pb_colorProgress="@color/purple_progress"
            custom:pb_textComplete="@string/Success"
            custom:pb_textProgress="@string/Loading" />

</code>

###代码：
<code>

	 mBtnAction = (ActionProcessButton) findViewById(R.id.btnAction);
	 mBtnAction.setProgress(50);	//进度的数值
	mBtnAction.setMode(ActionProcessButton.Mode.ENDLESS);//模式切换
</code>



###其他效果图展示：
######注：可以使用Mode来切换显示的模式，展示不同的特效。

![]('pic/sample4.gif')

![]('pic/sample5.gif')


###结构图：
![]('pic/diagram-v-0-0-2.png')