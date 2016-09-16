package katey2658.com.my.recyclerviewdemo2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;
/*
1。添加库依赖
2. 新建布局 引入RecyclerView
3. 获取RecyclerView控件然后进行设置LayoutManager以及Adapter
4. 自定义一个适配器来进行创建Item view以及绑定数据
5. 分隔线ItemDecoration(并不是强制需要),系统提供 的ItemDecoration是一个抽象类
6. 设置监听事件处理
 */

public class MainActivity extends AppCompatActivity {
    //先设置了一个对象
    private RecyclerView mRecyclerView;
    //数据
    private List<Item_single>mDatas;
    //用来将数据和布局进行绑定
    private SimpleAdapter mAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //初始化数据
        initDatas();
        //做一些初始化视图
        initView();
        //实例化适配器
        mAdapter=new SimpleAdapter(this,mDatas);
        //给view设置适配器
        mRecyclerView.setAdapter(mAdapter);
        //采用LayoutManager来处理recyclerView的布局管理
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        mRecyclerView.setLayoutManager(linearLayoutManager);
        //设置recyclerView的Item间的分割线
        //mRecyclerView.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL_LIST));

    }

    private void initView() {
        mRecyclerView= (RecyclerView) findViewById(R.id.id_recyclerView);
    }

    private void initDatas() {
        mDatas=new ArrayList<Item_single>();
        for (int i='A';i<='z';i++){
            Item_single item_single=new Item_single();
            item_single.setText(i+"");
            ImageView img=new ImageView(this);
            img.setImageResource(R.drawable.girls1);
            item_single.setImg(img);
            mDatas.add(item_single);
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
            case R.id.action_listView:
                mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
                break;
            case R.id.action_gridView:
                mRecyclerView.setLayoutManager(new GridLayoutManager(this,3));
                break;
            case R.id.action_hor_gridView:
                mRecyclerView.setLayoutManager(new StaggeredGridLayoutManager(5,StaggeredGridLayoutManager.HORIZONTAL));
                break;
            case R.id.action_staggered:
                Intent intent=new Intent(this,StraggeredGridLayoutActivity.class);
                startActivity(intent);
                break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
