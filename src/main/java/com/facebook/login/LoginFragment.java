package com.facebook.login;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.c;
import com.facebook.common.R;
import com.facebook.login.LoginClient;

public class LoginFragment extends Fragment {
    static final String EXTRA_REQUEST = "request";
    private static final String NULL_CALLING_PKG_ERROR_MSG = "Cannot call LoginFragment with a null calling package. This can occur if the launchMode of the caller is singleInstance.";
    static final String REQUEST_KEY = "com.facebook.LoginFragment:Request";
    static final String RESULT_KEY = "com.facebook.LoginFragment:Result";
    private static final String SAVED_LOGIN_CLIENT = "loginClient";
    private static final String TAG = "LoginFragment";
    private String callingPackage;
    private LoginClient loginClient;
    private LoginClient.Request request;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle != null) {
            this.loginClient = (LoginClient) bundle.getParcelable(SAVED_LOGIN_CLIENT);
            this.loginClient.setFragment(this);
        } else {
            this.loginClient = createLoginClient();
        }
        this.loginClient.setOnCompletedListener(new LoginClient.OnCompletedListener() {
            public void onCompleted(LoginClient.Result result) {
                LoginFragment.this.onLoginClientCompleted(result);
            }
        });
        c activity = getActivity();
        if (activity != null) {
            initializeCallingPackage(activity);
            Intent intent = activity.getIntent();
            if (intent != null) {
                Bundle bundleExtra = intent.getBundleExtra(REQUEST_KEY);
                if (bundleExtra != null) {
                    this.request = (LoginClient.Request) bundleExtra.getParcelable("request");
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public LoginClient createLoginClient() {
        return new LoginClient((Fragment) this);
    }

    public void onDestroy() {
        this.loginClient.cancelCurrentHandler();
        super.onDestroy();
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(getLayoutResId(), viewGroup, false);
        final View findViewById = inflate.findViewById(R.id.com_facebook_login_fragment_progress_bar);
        this.loginClient.setBackgroundProcessingListener(new LoginClient.BackgroundProcessingListener() {
            public void onBackgroundProcessingStarted() {
                findViewById.setVisibility(0);
            }

            public void onBackgroundProcessingStopped() {
                findViewById.setVisibility(8);
            }
        });
        return inflate;
    }

    /* access modifiers changed from: protected */
    public int getLayoutResId() {
        return R.layout.com_facebook_login_fragment;
    }

    /* access modifiers changed from: private */
    public void onLoginClientCompleted(LoginClient.Result result) {
        this.request = null;
        int i = result.code == LoginClient.Result.Code.CANCEL ? 0 : -1;
        Bundle bundle = new Bundle();
        bundle.putParcelable(RESULT_KEY, result);
        Intent intent = new Intent();
        intent.putExtras(bundle);
        if (isAdded()) {
            getActivity().setResult(i, intent);
            getActivity().finish();
        }
    }

    public void onResume() {
        super.onResume();
        if (this.callingPackage == null) {
            Log.e(TAG, NULL_CALLING_PKG_ERROR_MSG);
            getActivity().finish();
            return;
        }
        this.loginClient.startOrContinueAuth(this.request);
    }

    public void onPause() {
        View view;
        super.onPause();
        if (getView() == null) {
            view = null;
        } else {
            view = getView().findViewById(R.id.com_facebook_login_fragment_progress_bar);
        }
        if (view != null) {
            view.setVisibility(8);
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        this.loginClient.onActivityResult(i, i2, intent);
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putParcelable(SAVED_LOGIN_CLIENT, this.loginClient);
    }

    private void initializeCallingPackage(Activity activity) {
        ComponentName callingActivity = activity.getCallingActivity();
        if (callingActivity != null) {
            this.callingPackage = callingActivity.getPackageName();
        }
    }

    /* access modifiers changed from: package-private */
    public LoginClient getLoginClient() {
        return this.loginClient;
    }
}
