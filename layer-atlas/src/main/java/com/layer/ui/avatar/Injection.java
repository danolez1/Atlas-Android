package com.layer.ui.avatar;

import android.content.Context;

import com.google.android.gms.tasks.RuntimeExecutionException;
import com.layer.sdk.LayerClient;
import com.layer.ui.util.ImageTransformImpl;
import com.layer.ui.util.picasso.ImageCacheWrapper;
import com.layer.ui.util.picasso.ImageCacheWrapperImpl;

public class Injection {
    private static ImageCacheWrapper sImageCacheWrapper;
    private static Context sContext;
    private static LayerClient sLayerClient;

    public static AvatarContract.ViewModel provideAvatarViewModel() {
        return sImageCacheWrapper != null ? new AvatarViewModel(sImageCacheWrapper)
                                     : new AvatarViewModel(provideImageCachingLibrary());
    }

    public static ImageCacheWrapper provideImageCachingLibrary() {
        if (sImageCacheWrapper == null) {
            if (sContext == null || sLayerClient == null) {
                throw new RuntimeExecutionException(new Throwable("Context or Layer Client is not set"));
            }
            sImageCacheWrapper = new ImageCacheWrapperImpl(sContext, sLayerClient, new ImageTransformImpl());
        }
        return sImageCacheWrapper;
    }

    public static void setContextAndLayerClient(Context context, LayerClient layerClient) {
        sContext = context;
        sLayerClient = layerClient;
    }

    public static ImageCacheWrapper.ImageTransform provideImageTransform() {
        return new ImageTransformImpl();
    }
}
