package gjcm.kxf.drawview;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ListView;

import gjcm.kxf.myimpl.LoadMoreFace;
import gjcm.kxf.myloadmorelist.R;

/**
 * Created by kxf on 2016/11/9.
 * 自定义 listview
 */
public class ListLoad extends ListView implements AbsListView.OnScrollListener {
    private View footer;
    private int totalItem;
    private int lastItem;
    private boolean isLoading;
    private LoadMoreFace onLoadMore;
    private LayoutInflater inflater;

    public ListLoad(Context context) {
        super(context);
        initViewEvent(context);
    }


    public ListLoad(Context context, AttributeSet attrs) {
        super(context, attrs);
        initViewEvent(context);

    }

    public ListLoad(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initViewEvent(context);
    }

    private void initViewEvent(Context context) {
        inflater = LayoutInflater.from(context);
        footer = inflater.inflate(R.layout.load_footer_layout, null);
        footer.setVisibility(View.GONE);//加 footer
        this.addFooterView(footer);
        this.setOnScrollListener(this);
    }

    @Override
    public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
        this.lastItem = firstVisibleItem+visibleItemCount; // last
        this.totalItem = totalItemCount;// total
    }

    @Override
    public void onScrollStateChanged(AbsListView view, int scrollState) {
        if(this.totalItem == lastItem&&scrollState == SCROLL_STATE_IDLE){
            Log.i("kxflog", "yes");
            if(!isLoading){
                isLoading=true;
                footer.setVisibility(View.VISIBLE);
                onLoadMore.upLoad();
            }
        }
    }
    public void onLoadComplete(){
        footer.setVisibility(View.GONE);
        isLoading = false;
    }
    public void setLoadMoreFace(LoadMoreFace face) {
        this.onLoadMore = face;
    }
}
