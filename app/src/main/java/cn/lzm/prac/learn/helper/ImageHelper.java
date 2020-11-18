package cn.lzm.prac.learn.helper;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;

import androidx.databinding.BindingAdapter;

import com.bumptech.glide.Glide;

public class ImageHelper {
    /**
     * 1.加载图片,无需手动调用此方法
     *      * 2.使用@BindingAdapter注解设置自定义属性的名称，imageUrl就是属性的名称，
     *      * 当ImageView中使用imageUrl属性时，会自动调用loadImage方法，
     *
     */

    @BindingAdapter(value = {"imageUrl", "placeHolder", "bind:error"}, requireAll = false)
    public static void loadImage(ImageView imageView, String url, Drawable holderDrawable, Drawable errorDrawable) {
        Glide.with(imageView.getContext())
                .load(url)
                .placeholder(holderDrawable)
                .error(errorDrawable)
                .into(imageView);
    }
}
