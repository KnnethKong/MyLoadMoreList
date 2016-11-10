package gjcm.kxf.myloadmorelist;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;

import java.util.ArrayList;

import gjcm.kxf.drawview.MyItemDecoration;
import gjcm.kxf.drawview.RecyclerLoadView;

/**
 * Created by kxf on 2016/11/10.
 */
public class MianRecycler extends AppCompatActivity {
    private RecyclerLoadView recyclerLoad;
    private ArrayList<String> strings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recycler_main_layout);
        strings = new ArrayList<>();
        for (int i = 0; i < 30; i++)
            strings.add("正常的" + i);
        recyclerLoad = (RecyclerLoadView) findViewById(R.id.recycler_main);
        recyclerLoad.setLayoutManager(new LinearLayoutManager(this));
        recyclerLoad.addItemDecoration(new MyItemDecoration(this,10));
        MyRecycleAdapter adapter = new MyRecycleAdapter(this, strings);
        recyclerLoad.setLoadMoreListener(new RecyclerLoadView.LoadMoreListener() {
            @Override
            public void onLoadMore() {
                loadMoreData();
            }
        });
        recyclerLoad.setPullToRefreshListener(new RecyclerLoadView.PullToRefreshListener() {
            @Override
            public void onRefreshing() {
                refreshData();
            }
        });
        recyclerLoad.setAdapter(adapter);
    }

    Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg.what == 1) {
                for (int i = 0; i < 5; i++)
                    strings.add(0, "PullToRefresh" + i);
                recyclerLoad.setRefreshComplete();
            }
            //bn
            if (msg.what == 2) {
                for (int i = 0; i < 5; i++)
                    strings.add("LoadMore" + i);
                recyclerLoad.setLoadMoreComplete();
            }
        }
    };

    public void refreshData() {
        mHandler.sendEmptyMessageDelayed(1, 1500);
    }

    public void loadMoreData() {
        mHandler.sendEmptyMessageDelayed(2, 1500);
    }

}
