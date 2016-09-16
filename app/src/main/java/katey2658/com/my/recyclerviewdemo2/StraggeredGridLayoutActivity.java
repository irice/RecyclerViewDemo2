package katey2658.com.my.recyclerviewdemo2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

public class StraggeredGridLayoutActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private List<String>mDatas;
    private StaggeredAdapter mAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initDatas();
        initView();
        mAdapter=new StaggeredAdapter(this,mDatas);
        mRecyclerView.setAdapter(mAdapter);

        //设置recyclerView的布局管理
        mRecyclerView.setLayoutManager(new StaggeredGridLayoutManager(3,StaggeredGridLayoutManager.VERTICAL));

        //设置recyclerView的Item间的分割线
        //mRecyclerView.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL_LIST));

    }

    private void initView() {
        mRecyclerView= (RecyclerView) findViewById(R.id.id_recyclerView);
    }

    private void initDatas() {
        mDatas=new ArrayList<String>();
        for (int i='A';i<='z';i++){
            mDatas.add(""+(char)i);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.mymenu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id=item.getItemId();
        switch (id){

        }
        return super.onOptionsItemSelected(item);
    }
}
