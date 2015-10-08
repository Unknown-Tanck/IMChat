/**
 * 
 */
package com.softtanck.imchat.activity;


import java.util.ArrayList;

import com.softtanck.imchat.R;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

/**
 * @author Administrator
 *
 */
public class Guidance extends Activity {

	/* (non-Javadoc)
	 * @see android.app.Activity#onCreate(android.os.Bundle)
	 */
	private int sum=1;
	private Button button;
	public final static String IS_FIRST = "is_first";
	private Editor editor;
	
	private ArrayList<View> viewList;
	private ViewPager viewPager;
	
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_guide_viewpager);
		button=(Button)findViewById(R.id.go);
		
		LayoutInflater lf = getLayoutInflater().from(this);  
        View view1 = lf.inflate(R.layout.guide_layout1, null);  
        View view2 = lf.inflate(R.layout.guide_layout2, null);  
        View view3 = lf.inflate(R.layout.guide_layout3, null);  
		viewList = new ArrayList<View>();   
		viewList.add(view1);
		viewList.add(view2);
		viewList.add(view3);

		viewPager = (ViewPager) findViewById(R.id.viewpager);

		PagerAdapter pagerAdapter = new PagerAdapter() {

			@Override
			public boolean isViewFromObject(View arg0, Object arg1) {

				return arg0 == arg1;
			}

			@Override
			public int getCount() {

				return viewList.size();
			}

			@Override
			public void destroyItem(ViewGroup container, int position,
					Object object) {
				container.removeView(viewList.get(position));

			}

			@Override
			public int getItemPosition(Object object) {

				return super.getItemPosition(object);
			}

			// @Override
			// public CharSequence getPageTitle(int position) {
			//
			// return titleList.get(position);
			// }
			//
			@Override
			public Object instantiateItem(ViewGroup container, int position) {
				container.addView(viewList.get(position));
			
				return viewList.get(position);
			}

		};
		viewPager.setAdapter(pagerAdapter);
	}

	public void goQQ(View view){
	
		SharedPreferences sharedPreferences = getSharedPreferences("mydata",Context.MODE_PRIVATE);
		editor=sharedPreferences.edit();
		editor.putBoolean(IS_FIRST, false);
		editor.commit();
		startActivity(new Intent().setClass(Guidance.this, Login.class)); 
		finish();
	}
		
	
}
