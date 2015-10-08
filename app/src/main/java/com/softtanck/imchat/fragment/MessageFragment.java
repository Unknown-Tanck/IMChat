package com.softtanck.imchat.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.softtanck.imchat.R;
import com.softtanck.imchat.activity.MainActivity;
import com.softtanck.imchat.adapter.ContentMsgAdapter;
import com.softtanck.imchat.bean.ContractMsg;

import java.util.ArrayList;
import java.util.List;

/**
 * 消息
 */
public class MessageFragment extends Fragment implements AdapterView.OnItemClickListener {

    private ListView listView;

    private ContentMsgAdapter adapter;

    private List<ContractMsg> list;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.sliding_content_message, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {

        initView(view);
    }

    /**
     * 初始化视图
     *
     * @param view
     */
    private void initView(View view) {
        list = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            list.add(new ContractMsg());
        }
        listView = (ListView) view.findViewById(R.id.content_msg_lv);
        adapter = new ContentMsgAdapter(getActivity().getApplicationContext(), list);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent = new Intent(getActivity().getApplicationContext(), MainActivity.class);
        startActivity(intent);
    }
}
