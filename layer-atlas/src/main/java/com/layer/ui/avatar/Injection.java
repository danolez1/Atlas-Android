package com.layer.ui.avatar;

import android.content.Context;

import com.google.android.gms.tasks.RuntimeExecutionException;
import com.layer.sdk.LayerClient;
import com.layer.ui.util.picasso.ImageCaching;
import com.layer.ui.util.picasso.ImageCachingImpl;

public class Injection {
    private static ImageCaching sImageCaching;
    private static Context sContext;
    private static LayerClient sLayerClient;

    public static AvatarContract.ViewModel injectAvatarViewModel() {
        return sImageCaching != null ? new AvatarViewModel(sImageCaching)
                                     : new AvatarViewModel(provideImageCachingLibrary());
    }

    public static ImageCaching provideImageCachingLibrary() {
        if (sImageCaching == null) {
            if (sContext == null || sLayerClient == null) {
                throw new RuntimeExecutionException(new Throwable("Context or Layer Client is not set"));
            }
            sImageCaching = new ImageCachingImpl(sContext, sLayerClient);
        }
        return sImageCaching;
    }

    public static void setContextAndLayerClient(Context context, LayerClient layerClient) {
        sContext = context;
        sLayerClient = layerClient;
    }
}
