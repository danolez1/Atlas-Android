package com.layer.ui.util.picasso;

import com.layer.ui.util.picasso.transformations.CircleTransform;
import com.squareup.picasso.Target;

public interface ImageCaching {

    void cancelRequest(Target target);

    void load(String targetUrl, String tag, Object placeHolder, Object fade, int size, int size1,
            CircleTransform multiTransform, Target imageTarget);
    /*
        mPicasso.load(targetUrl)
                            .tag(Avatar.TAG).noPlaceholder().noFade()
                            .centerCrop().resize(size, size)
                            .transform((avatarCount > 1) ? MULTI_TRANSFORM : SINGLE_TRANSFORM)
                            .into(imageTarget);
     */

}
