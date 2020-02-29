package com.example.mvp.util;

import android.graphics.Bitmap;
import android.util.LruCache;
import android.widget.ImageView;

import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;
import com.example.mvp.network.RequestManager;

/**
 * @author Quincy
 * @Date 2020/2/16
 * @Description
 */

public class ImageUtil {
    public  static void loadImage(String url, ImageView iv, int placeHolder,int errorHolder){
        ImageLoader loader = new ImageLoader(
                RequestManager.getInstance().getRequestQueue(),new BitmapCache());
        if (iv instanceof NetworkImageView) {
            ((NetworkImageView) iv).setDefaultImageResId(placeHolder);
            ((NetworkImageView) iv).setErrorImageResId(errorHolder);
            ((NetworkImageView) iv).setImageUrl(url, loader);
        } else {
            ImageLoader.ImageListener listener = ImageLoader.getImageListener(iv,
                    placeHolder, errorHolder);
            loader.get(url, listener);
        }
    }
    private static class BitmapCache implements ImageLoader.ImageCache {
        private LruCache<String, Bitmap> cache;
        private final int maxSize = 10 * 1024 * 1024;//缓存大小设为10M

        BitmapCache() {
            cache = new LruCache<String, Bitmap>(maxSize) {
                @Override
                protected int sizeOf(String key, Bitmap value) {
                    return value.getByteCount() / 1024;
                }
            };
        }

        @Override
        public Bitmap getBitmap(String url) {
            return cache.get(url);
        }

        @Override
        public void putBitmap(String url, Bitmap bitmap) {
            cache.put(url, bitmap);
        }
    }
}
