package gjcm.kxf.myloadmorelist;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import gjcm.kxf.drawview.ListLoad;
import gjcm.kxf.myimpl.LoadMoreFace;

public class MainActivity extends AppCompatActivity implements LoadMoreFace, AdapterView.OnItemClickListener {
    private ListLoad listView;
    private List<String> datas;
    private int pageNow = 0;
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViewEvent();
    }

    private void initViewEvent() {
        setData();
        listView = (ListLoad) findViewById(R.id.mian_list);
        listView.setLoadMoreFace(this);
        listView.setOnItemClickListener(this);
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, datas);
        listView.setAdapter(adapter);


    }

    @Override
    protected void onStart() {
        super.onStart();

    }

    private void setData() {
        datas = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            datas.add("第 " + pageNow + "--->" + i + " 个数据");
        }
    }

    @Override
    public void upLoad() {
        pageNow++;
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                setData();
                Log.i("kxflog", "pageNow:" + pageNow);
                listView.onLoadComplete();
                Toast.makeText(MainActivity.this, "加载完成", Toast.LENGTH_SHORT).show();
                adapter.notifyDataSetChanged();
            }
        }, 2000);


    }

    @Override
    public void downLoad() {

    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

    }
}
