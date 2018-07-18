package cifz.com.addviewwrapper;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.widget.BaseAdapter;
import android.widget.TextView;

import cifz.com.addviewwrapper.wrapper.BaseWrapper;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView) findViewById(R.id.rv_test);

        GridLayoutManager manager = new GridLayoutManager(this,2);
        recyclerView.setLayoutManager(manager);
        recyclerView.setHasFixedSize(true);
        AdapterTest adapterTest = new AdapterTest();

        TextView tv = new TextView(this);
        tv.setText("嘿嘿嘿");
        tv.setGravity(Gravity.CENTER);
        BaseWrapper baseAdapter = new BaseWrapper(adapterTest);
        baseAdapter.addHeaderView(tv);
        recyclerView.setAdapter(baseAdapter);

    }
}
