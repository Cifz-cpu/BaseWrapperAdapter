package cifz.com.addviewwrapper;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Author : cifz
 * Time : 2018/7/18
 * e_mail : wangzhen1798@gmail.com
 * function:
 */
public class AdapterTest extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new TextViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_rv,parent,false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 20;
    }

    class TextViewHolder extends RecyclerView.ViewHolder{

        public TextViewHolder(View itemView) {
            super(itemView);
        }
    }

}
