package cifz.com.addviewwrapper.wrapper;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.util.SparseArrayCompat;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;

import cifz.com.addviewwrapper.R;

/**
 * Author : cifz
 * Time : 2018/7/19
 * e_mail : wangzhen1798@gmail.com
 * function:
 */
public class CifzRecyclerView extends RecyclerView {

    private View refreshView;

    public CifzRecyclerView(Context context) {
        super(context);
    }

    public CifzRecyclerView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initRefreshView();
    }

    public CifzRecyclerView(Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        initRefreshView();
    }


    private void initRefreshView() {
        refreshView = LayoutInflater.from(getContext()).inflate(R.layout.item_refresh_view,null);
        LayoutParams lp = new LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.WRAP_CONTENT);
        lp.setMargins(0,0,0,0);
        refreshView.setLayoutParams(lp);
        refreshView.setPadding(0,0,0,0);

    }
}
