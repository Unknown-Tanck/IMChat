/**
 *
 */
package com.softtanck.imchat.activity;


import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.SlidingPaneLayout;
import android.support.v4.widget.SlidingPaneLayout.PanelSlideListener;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;

import com.nineoldandroids.view.ViewHelper;
import com.softtanck.imchat.R;
import com.softtanck.imchat.fragment.SlidingContentFragment;
import com.softtanck.imchat.fragment.SlidingMenuFragment;

/**
 * @author Administrator
 */
public class Sliding_Main extends FragmentActivity {

    private SlidingPaneLayout slidingPaneLayout;
    private SlidingMenuFragment menuFragment;
    private SlidingContentFragment contentFragment;
    private int maxMargin = 0;
    private Display defaultDisplay;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);

        Log.d("mybug", "Sliding_Main");

        setContentView(R.layout.slidingpane_background);
        slidingPaneLayout = (SlidingPaneLayout) findViewById(R.id.slidingpanellayout);


        menuFragment = new SlidingMenuFragment(Sliding_Main.this);
        contentFragment = new SlidingContentFragment(Sliding_Main.this);


        FragmentTransaction transaction = getSupportFragmentManager()
                .beginTransaction();
        transaction.add(R.id.slidingpane_content, contentFragment);
        transaction.add(R.id.slidingpane_menu, menuFragment);
        transaction.commit();


        WindowManager windowManager = getWindowManager();
        defaultDisplay = windowManager.getDefaultDisplay();
        maxMargin = defaultDisplay.getHeight() / 10;
        slidingPaneLayout.setPanelSlideListener(new PanelSlideListener() {

            @Override
            public void onPanelSlide(View panel, float slideOffset) {
                ViewHelper.setScaleY(contentFragment.getCurrentView(), (1 - slideOffset * 0.2f));// 设置缩放的基准点
                float scale = 1 - ((1 - slideOffset) * maxMargin * 2)
                        / (float) defaultDisplay.getHeight();
                ViewHelper.setScaleX(menuFragment.getCurrentView(), scale);// 设置缩放的基准点
                ViewHelper.setScaleY(menuFragment.getCurrentView(), scale);// 设置缩放的基准点
                ViewHelper.setPivotX(menuFragment.getCurrentView(), scale);// 设置缩放和选择的点
                ViewHelper.setPivotY(menuFragment.getCurrentView(), defaultDisplay.getHeight() / 2);// 设置缩放和选择的点
                ViewHelper.setAlpha(menuFragment.getCurrentView(), slideOffset);
            }

            @Override
            public void onPanelOpened(View panel) {
                // TODO Auto-generated method stub

            }

            @Override
            public void onPanelClosed(View panel) {
                // TODO Auto-generated method stub

            }
        });

    }

    /**
     * @return the slidingPaneLayout
     */


}
