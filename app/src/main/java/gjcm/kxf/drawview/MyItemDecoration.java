package gjcm.kxf.drawview;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import gjcm.kxf.myloadmorelist.R;

/**
 * Created by kxf on 2016/11/10.
 * http://www.tuicool.com/articles/fIbuYfI
 */
public class MyItemDecoration extends RecyclerView.ItemDecoration {
    private Drawable drawable;
    private int space;

    public MyItemDecoration(Context context, int space) {
        drawable = context.getResources().getDrawable(R.mipmap.ic_launcher);
        this.space = space;
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        outRect.set(0, 0, 0, drawable.getIntrinsicHeight());

        outRect.left = space;
        outRect.right = space;
        outRect.bottom = space;
        int position = parent.getChildAdapterPosition(view);
        if (position == 0) {
            outRect.top = space;
        }
    }
}
