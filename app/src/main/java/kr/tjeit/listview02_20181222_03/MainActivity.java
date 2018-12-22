package kr.tjeit.listview02_20181222_03;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import kr.tjeit.listview02_20181222_03.adapters.StoreAdapter;
import kr.tjeit.listview02_20181222_03.datas.Store;

public class MainActivity extends BaseActivity {

    ListView storeListView;
    List<Store> storeList = new ArrayList<Store>();
    StoreAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bindViews();
        setupEvents();
        setValues();
    }

    @Override
    public void setupEvents() {

    }

    @Override
    public void setValues() {
        fillStores();

        mAdapter = new StoreAdapter(mContext, storeList);
        storeListView.setAdapter(mAdapter);
    }

    //    가게 데이터를 채우기 위함 임시 메쏘드
    void fillStores() {
        storeList.clear();

        storeList.add(new Store("BBQ", "종로구 10길", 4, "오전 9:00 ~ 오후 9:00", "010123456789"));
        storeList.add(new Store("BBQ1", "종로구 9길", 5, "오전 9:00 ~ 오후 9:00", "146514561153"));
        storeList.add(new Store("BBQ2", "종로구 8길", 6, "오전 9:00 ~ 오후 9:00", "0113212313213"));
        storeList.add(new Store("BBQ3", "종로구 7길", 7, "오전 9:00 ~ 오후 9:00", "010123456789"));
        storeList.add(new Store("BBQ4", "종로구 6길", 8, "오전 9:00 ~ 오후 9:00", "010123456789"));
        storeList.add(new Store("BBQ5", "종로구 5길", 9, "오전 9:00 ~ 오후 9:00", "010123456789"));
        storeList.add(new Store("BBQ6", "종로구 4길", 10, "오전 9:00 ~ 오후 9:00", "010123456789"));
    }


    @Override
    public void bindViews() {

        storeListView = findViewById(R.id.storeListView);

    }
}
