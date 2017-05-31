package com.layer.ui.util.picasso;

import android.content.Context;

import com.layer.sdk.LayerClient;
import com.layer.ui.avatar.Avatar;
import com.layer.ui.util.picasso.requesthandlers.MessagePartRequestHandler;
import com.layer.ui.util.picasso.transformations.CircleTransform;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

public class ImageCachingImpl implements ImageCaching {
    private Picasso mPicasso;
    private Context mContext;
    private LayerClient mLayerClient;


    public ImageCachingImpl(Context context, LayerClient layerClient) {
        mContext = context;
        mLayerClient = layerClient;
    }

    @Override
    public void cancelRequest(Target target) {

    }

    @Override
    public void load(String targetUrl, String tag, Object placeHolder, Object fade, int size,
            int size1, CircleTransform multiTransform, Target imageTarget) {
        if (mPicasso == null) {
            mPicasso = getPicasso();
        }

        mPicasso.load(targetUrl)
                .tag(Avatar.TAG).noPlaceholder().noFade()
                .centerCrop().resize(size, size)
                .transform(multiTransform)
                .into(imageTarget);

    }

    public Picasso getPicasso() {
        if ( mPicasso == null) {
            // Picasso with custom RequestHandler for loading from Layer MessageParts.
            mPicasso = new Picasso.Builder(mContext)
                    .addRequestHandler(new MessagePartRequestHandler(mLayerClient))
                    .build();
        }
        return mPicasso;
    }
}
