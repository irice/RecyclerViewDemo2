package katey2658.com.my.recyclerviewdemo2;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by 11456 on 2016/9/15.
 */
public class SimpleAdapter  extends RecyclerView.Adapter<MyViewHolder>{
    private LayoutInflater mInflater;
    private Context mContext;
    private List<Item_single>mDatas;
    public  SimpleAdapter(Context context, List<Item_single> datas){
        this.mContext=context;
        this.mDatas=datas;
        //初始化相关视图数据
        mInflater=LayoutInflater.from(context);
    }
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //绑定需要加载的item布局视图
        View view=mInflater.inflate(R.layout.item_singele_textview,parent,false);
        //ViewHolder承载视图子布局
        MyViewHolder viewHolder=new MyViewHolder(view);
        return viewHolder;
    }
    /*
    数据绑定和显示
     */

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.tv.setText(mDatas.get(position).getText());
        holder.id_img=mDatas.get(position).getImg();
    }

    @Override
    public int getItemCount() {
        return mDatas.size();
    }
}
//自定的ViewHolder，持有item所有的界面元素
class MyViewHolder extends RecyclerView.ViewHolder{
    ImageView id_img;
    TextView tv;
    public MyViewHolder(View itemView) {
        super(itemView);
        tv= (TextView) itemView.findViewById(R.id.id_tv);
        id_img= (ImageView) itemView.findViewById(R.id.id_img);
    }
}
