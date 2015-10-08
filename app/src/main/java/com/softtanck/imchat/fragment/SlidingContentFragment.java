/**
 * Copyright © 2014 All rights reserved.
 *
 * @Title: SlidingPaneContentFragment.java
 * @Prject: SlidingPane
 * @Package: com.example.slidingpane
 * @Description: TODO
 * @author: raot  719055805@qq.com
 * @date: 2014年9月5日 上午10:44:01
 * @version: V1.0
 */
package com.softtanck.imchat.fragment;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import android.widget.RadioGroup;

import com.softtanck.imchat.R;
import com.softtanck.imchat.adapter.FragmentTabAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: SlidingPaneContentFragment
 * @Description: TODO
 * @author: raot 719055805@qq.com
 * @date: 2014年9月5日 上午10:44:01
 */
@SuppressLint("ValidFragment")
public class SlidingContentFragment extends Fragment {

    private RadioGroup rgs;
    private List<Fragment> fragments;
    ;
    private View currentView;
    private Context context;

    public SlidingContentFragment(Context context) {
        // TODO Auto-generated constructor stub
    }

    public void setCurrentViewPararms(LayoutParams layoutParams) {
        currentView.setLayoutParams(layoutParams);
    }

    public LayoutParams getCurrentViewParams() {
        return (LayoutParams) currentView.getLayoutParams();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        currentView = inflater.inflate(R.layout.sliding_content_fragment,
                container, false);

        BindFragment();

        Log.d("mybug", "currentView2:" + currentView);

        return currentView;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);


    }

    public View getCurrentView() {
        return currentView;
    }

    public void BindFragment() {

        fragments = new ArrayList<Fragment>();
        fragments.add(new MessageFragment());
        fragments.add(new ContractFragment());
        fragments.add(new DynamicFragment());

        View view = currentView.findViewById(R.id.sliding_content_tab_layout);
        rgs = (RadioGroup) view.findViewById(R.id.tabs_rg);

        FragmentTabAdapter tabAdapter = new FragmentTabAdapter(this, fragments, R.id.tab_content, rgs);

    }
}
