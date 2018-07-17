package cifz.com.addviewwrapper.wrapper;

import android.support.v4.util.SparseArrayCompat;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

/**
 * Author : cifz
 * Time : 2018/7/17
 * e_mail : wangzhen1798@gmail.com
 * function:
 */
public class BaseWrapper extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static final int BASE_HEADER_VIEW_TYPE = 100000;
    private static final int Base_FOOTER_VIEW_TYPE = 200000;

    private RecyclerView.Adapter innerAdapter;

    private SparseArrayCompat<View> mHeaderViews = new SparseArrayCompat<>();
    private SparseArrayCompat<View> mFooterViews = new SparseArrayCompat<>();

    public BaseWrapper(RecyclerView.Adapter innerAdapter) {
        this.innerAdapter = innerAdapter;
    }

    public boolean isHeaderVeiw(int pos){
        return pos < getHeaderViewCount();
    }

    public boolean isFooterView(int pos){
        return pos >= getHeaderViewCount() + innerAdapter.getItemCount();
    }

    public int getHeaderViewCount(){
        return mHeaderViews.size();
    }

    public int getFooterViewCount(){
        return mFooterViews.size();
    }

    public void addHeaderView(View view) {
        mHeaderViews.put(BASE_HEADER_VIEW_TYPE + getHeaderViewCount(), view);
    }

    public void addFooterView(View view){
        mFooterViews.put(Base_FOOTER_VIEW_TYPE + getFooterViewCount(),view);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if(mHeaderViews.get(viewType) != null){
            SimpleViewHolder simpleViewHolder = new SimpleViewHolder(mHeaderViews.get(viewType));
            return simpleViewHolder;
        }else if(mFooterViews.get(viewType) != null){
            SimpleViewHolder simpleViewHolder = new SimpleViewHolder(mFooterViews.get(viewType));
            return simpleViewHolder;
        }
        return innerAdapter.createViewHolder(parent,viewType);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if(isHeaderVeiw(position) || isFooterView(position)){
            return;
        }
        //position 一定要减去头view数量才是子Adapter要处理的view
        innerAdapter.onBindViewHolder(holder,position - getHeaderViewCount());
    }

    @Override
    public int getItemViewType(int position) {
        if(isHeaderVeiw(position)){
            return mHeaderViews.keyAt(position);
        }else if(isFooterView(position)){
            return mFooterViews.keyAt(position - getHeaderViewCount() - innerAdapter.getItemCount());
        }

        return innerAdapter.getItemViewType(position - getHeaderViewCount());
    }

    @Override
    public int getItemCount() {
        return innerAdapter.getItemCount() + getHeaderViewCount() + getFooterViewCount();
    }

    static class SimpleViewHolder extends RecyclerView.ViewHolder{

        public SimpleViewHolder(View itemView) {
            super(itemView);
        }
    }

}
