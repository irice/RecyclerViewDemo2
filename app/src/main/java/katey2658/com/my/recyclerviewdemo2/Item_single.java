package katey2658.com.my.recyclerviewdemo2;

import android.widget.ImageView;

/**
 * Created by 11456 on 2016/9/16.
 */
public class Item_single {
    private String text;
    private ImageView img;

    public void setImg(ImageView img) {
        this.img = img;
    }

    public ImageView getImg() {
        return img;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}
