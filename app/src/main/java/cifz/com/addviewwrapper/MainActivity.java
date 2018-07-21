package cifz.com.addviewwrapper;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import cifz.com.addviewwrapper.util.ImageLoader;
import cifz.com.addviewwrapper.wrapper.BaseWrapper;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ImageView imageView;

    String url = "https://ss0.bdstatic.com/94oJfD_bAAcT8t7mm9GUKT-xh_/timg?image&quality=100&size=b4000_4000&sec=1532102659&di=2f656ee1efeec2750e526d38d5c6a379&src=http://img.zcool.cn/community/0121bb5608950d32f875a132611ce7.jpg@1280w_1l_2o_100sh.jpg";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        recyclerView = (RecyclerView) findViewById(R.id.rv_test);
//
//        GridLayoutManager manager = new GridLayoutManager(this,2);
//        recyclerView.setLayoutManager(manager);
//        recyclerView.setHasFixedSize(true);
//        AdapterTest adapterTest = new AdapterTest();
//
//        TextView tv = new TextView(this);
//        tv.setText("嘿嘿嘿");
//        tv.setGravity(Gravity.CENTER);
//        BaseWrapper baseAdapter = new BaseWrapper(adapterTest);
//        baseAdapter.addHeaderView(tv);
//        recyclerView.setAdapter(baseAdapter);

        imageView = (ImageView) findViewById(R.id.iv_image);
        ImageLoader imageLoader = new ImageLoader();
        imageLoader.displayImage(url,imageView);

    }
}
