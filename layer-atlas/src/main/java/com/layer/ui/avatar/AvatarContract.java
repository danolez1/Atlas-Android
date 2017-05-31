package com.layer.ui.avatar;

import com.layer.sdk.messaging.Identity;
import com.layer.ui.util.picasso.transformations.CircleTransform;
import com.squareup.picasso.Target;

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

        Avatar.ImageTarget getImageTarget(Identity key);

        void setClusterSizes();

        void loadImage(String targetUrl, String tag, Object placeHolder, Object fade, int size, int size1,
                CircleTransform multiTransform, Target imageTarget);

        void setView(AvatarContract.View avatar);
    }

    interface View {

        Avatar getAvatar();

        boolean setClusterSizes(Map<Identity, String> initials, List<Avatar.ImageTarget> pendingLoads);

        void revalidateView();
    }

}
