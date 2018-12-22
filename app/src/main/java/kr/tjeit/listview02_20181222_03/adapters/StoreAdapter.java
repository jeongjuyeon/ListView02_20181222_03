package kr.tjeit.listview02_20181222_03.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import kr.tjeit.listview02_20181222_03.R;
import kr.tjeit.listview02_20181222_03.datas.Store;

public class StoreAdapter extends ArrayAdapter<Store> {

    Context mContext;
    List<Store> mList;
    LayoutInflater inf;

    public StoreAdapter(Context mContext, List<Store> mList) {
        super(mContext, R.layout.store_list_item, mList);

        this.mContext = mContext;
        this.mList = mList;
        this.inf = LayoutInflater.from(mContext);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        if (row == null) {
            row = inf.inflate(R.layout.store_list_item, null);
        }

        TextView storeNameTxt = row.findViewById(R.id.storeNameTxt);
        TextView storeAddressTxt = row.findViewById(R.id.storeAddressTxt);
        Button storeCallBtn = row.findViewById(R.id.storeCallBtn);
        TextView storeOpenTimeTxt = row.findViewById(R.id.storeOpenTimeTxt);

        final Store data = mList.get(position);

        storeNameTxt.setText(data.getName());
        storeAddressTxt.setText(data.getAddress());
        storeOpenTimeTxt.setText(data.getOpenAndCloseTime());

        storeCallBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext, data.getPhoneNum()+"에게 전화를 겁니다.", Toast.LENGTH_SHORT).show();


            }
        });

        return row;
    }
}
