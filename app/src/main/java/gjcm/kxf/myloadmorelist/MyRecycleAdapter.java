package gjcm.kxf.myloadmorelist;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kxf on 2016/11/10.
 */
public class MyRecycleAdapter extends RecyclerView.Adapter<MyRecycleAdapter.ViewHolder> {
    private Context context;
    private LayoutInflater layoutInflater;
    private ArrayList<String> strings;
    private static final int HIGHT_TYPE = 0;
    private static final int LOW_TYPE = 1;

    public MyRecycleAdapter(Context context, ArrayList<String> strings) {
        this.context = context;
        this.strings = strings;
        layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;
        if (viewType == HIGHT_TYPE) {
            view = layoutInflater.inflate(R.layout.recycle_items, parent, false);
        } else {
            view = layoutInflater.inflate(R.layout.recycle_items, parent, false);
        }
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.txt.setText(strings.get(position));
    }

    @Override
    public int getItemCount() {
        return (strings == null) ? 0 : strings.size();
    }

    @Override
    public int getItemViewType(int position) {
        if (position % 2 ==0 ){
            return HIGHT_TYPE;
        }else {
            return LOW_TYPE;
        }    }

    class ViewHolder extends RecyclerView.ViewHolder {

        private TextView txt;

        ViewHolder(View v) {
            super(v);
            txt = (TextView) v.findViewById(R.id.recycle_item_txt);
        }

    }
}
