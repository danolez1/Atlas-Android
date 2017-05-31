package com.layer.ui.avatar;

import com.layer.ui.util.picasso.ImageCaching;

public class Injection {
    private static ImageCaching mImageCaching;

    public static AvatarContract.ViewModel injectAvatarViewModel() {
        /*return mImageCaching != null ? new AvatarViewModel(mImageCaching)
                                     : new AvatarViewModel(provideImageCachingLibrary()) ;*/
        return new AvatarViewModel();
    }

    private static ImageCaching provideImageCachingLibrary() {
        if (mImageCaching == null) {
            //mImageCaching = new ImageCachingImpl();
        }
        return mImageCaching;
    }
}
