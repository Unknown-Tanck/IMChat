/**
 * Copyright © 2014 All rights reserved.
 *
 * @Title: SlidingPaneMenuFragment.java
 * @Prject: SlidingPane
 * @Package: com.example.slidingpane
 * @Description: TODO
 * @author: raot  719055805@qq.com
 * @date: 2014年9月5日 上午10:42:07
 * @version: V1.0
 */
package com.softtanck.imchat.fragment;


import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.softtanck.imchat.R;
import com.softtanck.imchat.activity.Sliding_Main;

/**
 * @ClassName: SlidingPaneMenuFragment
 * @Description: TODO
 * @author: raot 719055805@qq.com
 * @date: 2014年9月5日 上午10:42:07
 */
@SuppressLint("ValidFragment")
public class SlidingMenuFragment extends Fragment {

    private View currentView;
    public ListView listview;
    //	List<SlidingMenuDataset> list=null;
    private Context context;

    public SlidingMenuFragment(Sliding_Main slidingPane) {
        // TODO Auto-generated constructor stub
        context = slidingPane;
    }

    public View getCurrentView() {
        return currentView;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        currentView = inflater.inflate(R.layout.sliding_menu_fragment, container, false);
//		View view = currentView.findViewById(R.id.slidingmenu_layout);
//		listview = (ListView)view.findViewById(R.id.menu_list);
//		listview = (ListView)view.findViewById(android.R.id.list);

        return currentView;

    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);


//		
////		list=new ArrayList<SlidingMenuDataset>();
////		list.add(new SlidingMenuDataset(R.drawable.icon_1, "开通会员",
//				R.drawable.star));
//		list.add(new SlidingMenuDataset(R.drawable.icon_2, "QQ钱包",
//				R.drawable.star));
//		list.add(new SlidingMenuDataset(R.drawable.icon_3, "网上营业厅",
//				R.drawable.star));
//		list.add(new SlidingMenuDataset(R.drawable.icon_3, "个性装扮",
//				R.drawable.star));
//		list.add(new SlidingMenuDataset(R.drawable.icon_4, "我的收藏",
//				R.drawable.star));
//		list.add(new SlidingMenuDataset(R.drawable.icon_5, "我的相册",
//				R.drawable.star));
//		list.add(new SlidingMenuDataset(R.drawable.icon_6, "我的文件",
//				R.drawable.star));
//		SlidingMenuListAdaptor adapter = new SlidingMenuListAdaptor(getActivity() , list);

//		Log.i("com.zqu.bean","listview"+listview);
//		Log.d("mybug","menufragment");
//		
//		Log.d("mybug","listsize:"+list.size());
//		
//		setListAdapter(adapter);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);


    }


}
