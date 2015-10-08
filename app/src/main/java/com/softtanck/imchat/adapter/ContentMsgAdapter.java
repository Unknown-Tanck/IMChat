package com.softtanck.imchat.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.softtanck.imchat.R;
import com.softtanck.imchat.bean.ContractMsg;
import com.softtanck.imchat.view.imageview.RoundImageView;

import java.util.List;

/**
 * @author : Tanck
 * @Description : TODO
 * @date 10/8/2015
 */
public class ContentMsgAdapter extends BaseAdapter {

    private Context context;

    private List<ContractMsg> list;

    public ContentMsgAdapter(Context context, List<ContractMsg> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public ContractMsg getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder holder = null;
        if (null == convertView) {
            holder = new ViewHolder();
            convertView = View.inflate(context, R.layout.item_msg_contract, null);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        return convertView;
    }

    private class ViewHolder {
        TextView name;
        RoundImageView head;
        TextView lastMsg;
    }
}
