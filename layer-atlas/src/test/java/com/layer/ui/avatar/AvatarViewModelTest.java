package com.layer.ui.avatar;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.layer.sdk.messaging.Identity;
import com.layer.ui.util.picasso.ImageCacheWrapper;

import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class AvatarViewModelTest {
    @Mock
    Identity mMockIdentity, mMockIdentity2;

    @Mock
    AvatarContract.View mMockView;

    AvatarViewModel mAvatarViewModel;

    @Mock
    ImageCacheWrapper mMockImageCacheWrapper;


    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        mAvatarViewModel = new AvatarViewModel(mMockImageCacheWrapper);
        mAvatarViewModel.setView(mMockView);
    }

    @Test
    public void testIfIdentityIsSet() {
        mAvatarViewModel.update();
        verify(mMockView).setClusterSizes(ArgumentMatchers.<Identity, String>anyMap(), ArgumentMatchers.<UiImageTarget>anyList());
        verify(mMockView).revalidateView();
    }

    @Test
    public void testSetParticipantUpdatesTheView() {
        Identity[] identityList = {mMockIdentity, mMockIdentity2};
        when(mMockView.getInitials(any(Identity.class))).thenReturn("");
        mAvatarViewModel.setParticipants(identityList);
        verify(mMockView).setClusterSizes(ArgumentMatchers.<Identity, String>anyMap(), ArgumentMatchers.<UiImageTarget>anyList());
        verify(mMockView).revalidateView();
    }

}