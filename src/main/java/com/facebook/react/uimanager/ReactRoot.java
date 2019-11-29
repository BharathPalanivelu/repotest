package com.facebook.react.uimanager;

import android.os.Bundle;
import android.view.ViewGroup;

public interface ReactRoot {
    Bundle getAppProperties();

    String getInitialUITemplate();

    ViewGroup getRootViewGroup();

    int getRootViewTag();

    int getUIManagerType();

    void onStage(int i);

    void runApplication();

    void setRootViewTag(int i);
}
