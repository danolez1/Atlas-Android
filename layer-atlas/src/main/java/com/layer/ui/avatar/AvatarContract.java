package com.layer.ui.avatar;

import com.layer.sdk.messaging.Identity;
import com.layer.ui.util.picasso.ImageCacheWrapper;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface AvatarContract {

    interface ViewModel {

        void update();

        void setParticipants(Identity[] participants);

        void setParticipants(Set<Identity> participants);

        Set<Identity> getParticipants();

        int getInitialSize();

        Set<Map.Entry<Identity, String>> getEntrySet();

        UiImageTarget getImageTarget(Identity key);

        void setClusterSizes();

        //TODO Change flag to Enum incase user has more than one transformation
        void loadImage(String targetUrl, String tag, Object placeHolder, Object fade, int size, int size1,
                boolean flag, ImageCacheWrapper.ImageTarget imageTarget);

        void setView(AvatarContract.View avatar);
    }

    interface View {

        Avatar getAvatar();

        boolean setClusterSizes(Map<Identity, String> initials, List<UiImageTarget> pendingLoads);

        void revalidateView();

        Avatar setParticipants(Identity... participants);

        Avatar setParticipants(Set<Identity> participants);

        String getInitials(Identity added);
    }

}
