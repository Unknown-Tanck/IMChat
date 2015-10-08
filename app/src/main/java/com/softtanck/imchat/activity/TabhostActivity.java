/**
 * 
 */
package com.softtanck.imchat.activity;

import com.softtanck.imchat.R;
import android.app.TabActivity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TabHost;
import android.widget.TabWidget;
import android.widget.TextView;
import android.widget.TabHost.OnTabChangeListener;

/**
 * @author Administrator
 *
 */
public class TabhostActivity extends TabActivity {

	/*
	 * (non-Javadoc)
	 * 
	 * @see android.app.Activity#onCreate(android.os.Bundle)
	 */
	private TabHost tabhost;
	private TabHost.TabSpec first;
	private TabHost.TabSpec second;
	private TabHost.TabSpec third;


	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// TODO Auto-generated method stub
//		setContentView(R.layout.main_tabhost);
		getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS); //通知栏设为透明  android系统4.4以上才有效
		tabhost = getTabHost();
		//设置tabwidget位于屏幕下方
	    TabWidget tabWidget = tabhost.getTabWidget();  
	    LinearLayout lLayout = (LinearLayout) tabhost.getChildAt(0);  
	    lLayout.removeViewAt(0);  
	    lLayout.addView(tabWidget);  
		
		LayoutInflater.from(this).inflate(R.layout.activity_sliding_content_tabhost, tabhost.getTabContentView(),true);
		
		init();
	}

	public void init() {
       
		first = tabhost.newTabSpec("first");
		second = tabhost.newTabSpec("second");
		third = tabhost.newTabSpec("third");

		first.setIndicator(createContent("消息", R.drawable.first_tab));
		second.setIndicator(createContent("联系人", R.drawable.two_tab));
		third.setIndicator(createContent("动态", R.drawable.third_tab));

		// 绑定显示的页面
		// //first.setContent(R.id.ll_first);
		 first.setContent(new Intent(this, Message.class));
		 second.setContent(new Intent(this, Contact.class));
		 third.setContent(new Intent(this, Dynamic.class));

		// 将选项卡加进TabHost
		tabhost.addTab(first);
		tabhost.addTab(second);
		tabhost.addTab(third);
		
		// 设置tabHost切换时动态更改图标
		tabhost.setOnTabChangedListener(new OnTabChangeListener() {

			@Override
			public void onTabChanged(String tabId) {
				tabChanged(tabId);
			}

		});
	}
	
	// 返回单个选项
	private View createContent(String text, int resid) {
		View view = LayoutInflater.from(this).inflate(R.layout.tabcard_layout, null,
				false);
		TextView tv_name = (TextView) view.findViewById(R.id.tv_name);
		ImageView iv_icon = (ImageView) view.findViewById(R.id.img_name);
		tv_name.setText(text);
		iv_icon.setBackgroundResource(resid);
		return view;
	}
	
	// 捕获tab变化事件
		private void tabChanged(String tabId) {
			// 当前选中项
			if (tabId.equals("first")) {
				tabhost.setCurrentTabByTag("消息");
			} else if (tabId.equals("second")) {
				tabhost.setCurrentTabByTag("联系人");
			} else if (tabId.equals("third")) {
				tabhost.setCurrentTabByTag("动态");
			} else if (tabId.equals("fourth")) {
				tabhost.setCurrentTabByTag("更多");
			}else{
				tabhost.setCurrentTabByTag("Test");   //````````````````````````````````````````````````Add
			}

		}
}
