package com.softtanck.imchat.adapter;
//package com.zqu.bean;
//
//import java.util.List;
//
//import com.zqu.defineqq.R;
//
//import android.content.Context;
//import android.util.Log;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.BaseAdapter;
//import android.widget.ImageView;
//import android.widget.TextView;
//
//public class SlidingMenuListAdaptor extends BaseAdapter {
//
//	public Context context;
//	public List<SlidingMenuDataset> dataSet = null;
//	public ImageView image1;
//	public TextView menuitem;
//	public ImageView image2;
//
//	public SlidingMenuListAdaptor(Context context, List<SlidingMenuDataset> list) {
//		// TODO Auto-generated constructor stub
//		this.context = context;
//		this.dataSet = list;
//	}
//
//	// 根据数据的数据计算listview的数据条目
//	@Override
//	public int getCount() {
//		// TODO Auto-generated method stub
//		return dataSet.size();
//	}
//
//	@Override
//	public Object getItem(int position) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	// 第几条item
//	@Override
//	public long getItemId(int position) {
//		// TODO Auto-generated method stub
//		return position;
//	}
//
//	// item显示的内容
//	@Override
//	public View getView(int position, View convertView, ViewGroup parent) {
//		// TODO Auto-generated method stub
//		
//		
//		View view;
//		if (convertView == null)
//		// 在数据适配器中调用每一个listview的item布局文件
//		{
//			view = LayoutInflater.from(context).inflate(
//					R.layout.sliding_menu_listitem, null);
//		} else {
//			view = convertView;
//		}
//		
//		// 通过item布局文件 可以查找item布局文件下面的组建（通过id查找）
//
//		image1 = (ImageView) view.findViewById(R.id.menu_image1);
//		menuitem = (TextView) view.findViewById(R.id.menu_text);
//		image2 = (ImageView) view.findViewById(R.id.menu_image2);
//
//		// 为listView条目（item）里面的元素动态绑定数据
////		image1.setImageResource(dataSet.get(position).getImage1());
//		menuitem.setText(dataSet.get(position).getMenuitem());
////		image2.setImageResource(dataSet.get(position).getImage2());
//		Log.d("mybug", "-->getview");
//		return convertView;
//	}
//
//}
