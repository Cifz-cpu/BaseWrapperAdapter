package cifz.com.addviewwrapper.util;

import android.graphics.Bitmap;
import android.util.LruCache;

/**
 * Author : cifz
 * Time : 2018/7/21
 * e_mail : wangzhen1798@gmail.com
 * function:
 */
public class ImageCache {
    LruCache<String,Bitmap> mImageCache;

    public ImageCache() {
        initCache();
    }

    private void initCache() {
        //计算可使用的最大内存
        final int maxMemory = (int) (Runtime.getRuntime().maxMemory() / 1024);
        //取四分之一作为缓存
        final int cacheSize = maxMemory / 4;
        mImageCache = new LruCache<String,Bitmap>(cacheSize){
            @Override
            protected int sizeOf(String key, Bitmap value) {
                return value.getRowBytes() * value.getHeight() / 1024;
            }
        };
    }

    public void put(String url,Bitmap bitmap){
        mImageCache.put(url,bitmap);
    }

    public Bitmap get(String url){
        return mImageCache.get(url);
    }

}
