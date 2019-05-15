package com.example.myapplication5;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Map;

/**
 */

public class RightAdapter extends BaseAdapter {
    private Context context;
    private OnMyClickListener onMyClickListener;

    public RightAdapter(Context context,OnMyClickListener onMyClickListener) {
        this.context = context;
        this.onMyClickListener = onMyClickListener;
    }

    @Override
    public int getCount() {
        return 40;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        MyViewHolder viewHolder;
        if(view == null){
            view = View.inflate(context, R.layout.layout_right_item,null);
            viewHolder = new MyViewHolder(view,position);
            //viewHolder.mChildRoot.setTag(R.id.view_holder_position,position);
            view.setTag(viewHolder);
            //Log.e("debug",viewHolder.mChildRoot.getTag(R.id.view_holder_position)+"");
        }else {
            viewHolder = (MyViewHolder) view.getTag();
        }

        return view;
    }

    public interface OnMyClickListener{
        //index line 都是以0为开始的
        void onClick(int index,int line,String str);
    }

    class MyViewHolder {
        public LinearLayout mChildRoot;

        public MyViewHolder(View view,int line) {
            mChildRoot = view.findViewById(R.id.ll_child_root);
            //int line = (int)mChildRoot.getTag(R.id.view_holder_position);
            for (int i = 0; i < 20; i++) {
                View inflate = View.inflate(view.getContext(), R.layout.item_child_layout, null);
                //TextView name = inflate.findViewById(R.id.tv);
                EditText name = inflate.findViewById(R.id.et);
                name.addTextChangedListener(new MyTextWatcher(i,line,new MyTextWatcher.OnCallback() {
                    @Override
                    public void callback(int index,int line,String str) {
                        onMyClickListener.onClick(index,line,str);
                    }
                }));
                mChildRoot.addView(inflate);
            }

        }
    }

}
