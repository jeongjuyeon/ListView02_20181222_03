package kr.tjeit.listview02_20181222_03;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
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
        storeListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                position 변수에는 몇번째 줄이 눌렸는지를 담고 있음.
//                이를 활용해서 상황에 맞는 대처.

//                눌린 가게가 어떤 가게인지?
                Store clickedStore = storeList.get(position);

//                  눌린 가게를 Intent에 첨부해서 가게 상세 화면으로 전달 + 이동.
                Intent intent = new Intent(mContext, StoreDetailActivity.class);
                intent.putExtra("storeData",clickedStore);
                startActivity(intent);

            }
        });
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
        storeList.add(new Store("BBQ1", "종로구 9길", 5, "오전 9:00 ~ 오후 9:00", "1"));
        storeList.add(new Store("BBQ2", "종로구 8길", 6, "오전 9:00 ~ 오후 9:00", "2"));
        storeList.add(new Store("BBQ3", "종로구 7길", 7, "오전 9:00 ~ 오후 9:00", "3"));
        storeList.add(new Store("BBQ4", "종로구 6길", 8, "오전 9:00 ~ 오후 9:00", "4"));
        storeList.add(new Store("BBQ5", "종로구 5길", 9, "오전 9:00 ~ 오후 9:00", "5"));
        storeList.add(new Store("BBQ6", "종로구 4길", 10, "오전 9:00 ~ 오후 9:00", "6"));
    }


    @Override
    public void bindViews() {

        storeListView = findViewById(R.id.storeListView);

    }
}
