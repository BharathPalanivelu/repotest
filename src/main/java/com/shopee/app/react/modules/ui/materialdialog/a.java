package com.shopee.app.react.modules.ui.materialdialog;

import android.app.Activity;
import android.content.DialogInterface;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import com.afollestad.materialdialogs.f;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.modules.core.DeviceEventManagerModule;
import com.google.a.o;
import com.shopee.app.react.modules.ui.materialdialog.a;
import com.shopee.app.react.protocol.ButtonData;
import com.shopee.app.react.protocol.NumericInputData;
import com.shopee.app.react.protocol.TextInputData;
import com.shopee.app.ui.common.passcode.PasscodeView;
import com.shopee.app.web.WebRegister;
import com.shopee.id.R;
import com.shopee.react.sdk.bridge.modules.base.c;
import com.shopee.react.sdk.bridge.protocol.PopupData;
import com.shopee.react.sdk.bridge.protocol.PopupResponse;

public class a extends com.shopee.react.sdk.bridge.modules.ui.dialog.a {

    /* renamed from: a  reason: collision with root package name */
    private final int f18889a = 1;

    /* renamed from: b  reason: collision with root package name */
    private final int f18890b = 0;

    /* renamed from: c  reason: collision with root package name */
    private final int f18891c = 2;

    /* renamed from: com.shopee.app.react.modules.ui.materialdialog.a$a  reason: collision with other inner class name */
    private interface C0287a {
        String getValue();
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ String a() {
        return null;
    }

    public void a(Activity activity, ReactApplicationContext reactApplicationContext, int i, PopupData popupData, c<PopupResponse> cVar) {
        if (!activity.isFinishing()) {
            f.a a2 = new f.a(activity).a((CharSequence) popupData.getTitle()).e((CharSequence) popupData.getCancelText()).c((CharSequence) popupData.getOkText()).a(popupData.isAutoDismiss());
            int contentViewType = popupData.getContentViewType();
            if (contentViewType == 1) {
                TextInputData textInputData = (TextInputData) WebRegister.GSON.a(popupData.getContentView(), TextInputData.class);
                RelativeLayout relativeLayout = (RelativeLayout) activity.getLayoutInflater().inflate(R.layout.password_dialog_layout, (ViewGroup) null);
                EditText editText = (EditText) relativeLayout.findViewById(R.id.edit_text);
                editText.setHint(textInputData.getPlaceholder());
                if (textInputData.isPassword()) {
                    editText.setInputType(129);
                }
                Button button = (Button) relativeLayout.findViewById(R.id.button);
                if (textInputData.getButton() == null) {
                    button.setVisibility(8);
                } else {
                    ButtonData button2 = textInputData.getButton();
                    button.setText(button2.getTitle());
                    button.setTextColor(button2.getColor());
                    button.setTextSize(button2.getFontSize());
                    button.setOnClickListener(new View.OnClickListener(i, button2, reactApplicationContext) {
                        private final /* synthetic */ int f$0;
                        private final /* synthetic */ ButtonData f$1;
                        private final /* synthetic */ ReactApplicationContext f$2;

                        {
                            this.f$0 = r1;
                            this.f$1 = r2;
                            this.f$2 = r3;
                        }

                        public final void onClick(View view) {
                            a.b(this.f$0, this.f$1, this.f$2, view);
                        }
                    });
                }
                a2.a((View) relativeLayout, false);
                a(a2, cVar, (C0287a) new C0287a(editText) {
                    private final /* synthetic */ EditText f$0;

                    {
                        this.f$0 = r1;
                    }

                    public final String getValue() {
                        return this.f$0.getText().toString();
                    }
                });
                a2.c();
            } else if (contentViewType != 2) {
                a2.b((CharSequence) popupData.getContent());
                a(a2, cVar, (C0287a) $$Lambda$a$6TkjGEEIGj0pTMwnR6PGN5thFJg.INSTANCE);
                a2.c();
            } else {
                NumericInputData numericInputData = (NumericInputData) WebRegister.GSON.a(popupData.getContentView(), NumericInputData.class);
                RelativeLayout relativeLayout2 = (RelativeLayout) activity.getLayoutInflater().inflate(R.layout.passcode_dialog_layout, (ViewGroup) null);
                PasscodeView passcodeView = (PasscodeView) relativeLayout2.findViewById(R.id.edit_text);
                passcodeView.a(numericInputData.getNumberOfDigits());
                Button button3 = (Button) relativeLayout2.findViewById(R.id.button);
                if (numericInputData.getButton() == null) {
                    button3.setVisibility(8);
                } else {
                    ButtonData button4 = numericInputData.getButton();
                    button3.setText(button4.getTitle());
                    button3.setTextColor(button4.getColor());
                    button3.setTextSize(button4.getFontSize());
                    button3.setOnClickListener(new View.OnClickListener(i, button4, reactApplicationContext) {
                        private final /* synthetic */ int f$0;
                        private final /* synthetic */ ButtonData f$1;
                        private final /* synthetic */ ReactApplicationContext f$2;

                        {
                            this.f$0 = r1;
                            this.f$1 = r2;
                            this.f$2 = r3;
                        }

                        public final void onClick(View view) {
                            a.a(this.f$0, this.f$1, this.f$2, view);
                        }
                    });
                }
                a2.a((View) relativeLayout2, false);
                passcodeView.getClass();
                a(a2, cVar, (C0287a) new C0287a() {
                    public final String getValue() {
                        return PasscodeView.this.getPasscode();
                    }
                });
                passcodeView.setDialog(a2.c());
            }
        }
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void b(int i, ButtonData buttonData, ReactApplicationContext reactApplicationContext, View view) {
        o oVar = new o();
        oVar.a("reactTag", (Number) Integer.valueOf(i));
        oVar.a("eventID", buttonData.getEventID());
        ((DeviceEventManagerModule.RCTDeviceEventEmitter) reactApplicationContext.getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)).emit("didTapDialogButton", oVar.toString());
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void a(int i, ButtonData buttonData, ReactApplicationContext reactApplicationContext, View view) {
        o oVar = new o();
        oVar.a("reactTag", (Number) Integer.valueOf(i));
        oVar.a("eventID", buttonData.getEventID());
        ((DeviceEventManagerModule.RCTDeviceEventEmitter) reactApplicationContext.getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)).emit("didTapDialogButton", oVar.toString());
    }

    private void a(f.a aVar, final c<PopupResponse> cVar, final C0287a aVar2) {
        aVar.a((f.b) new f.b() {
            public void onPositive(f fVar) {
                super.onPositive(fVar);
                fVar.dismiss();
                cVar.a(new PopupResponse.Builder().action(1).value(aVar2.getValue()).build());
            }

            public void onNegative(f fVar) {
                super.onNegative(fVar);
                fVar.dismiss();
                cVar.a(new PopupResponse.Builder().action(0).value(aVar2.getValue()).build());
            }
        });
        aVar.a((DialogInterface.OnCancelListener) new DialogInterface.OnCancelListener(aVar2, cVar) {
            private final /* synthetic */ a.C0287a f$1;
            private final /* synthetic */ c f$2;

            {
                this.f$1 = r2;
                this.f$2 = r3;
            }

            public final void onCancel(DialogInterface dialogInterface) {
                a.this.a(this.f$1, this.f$2, dialogInterface);
            }
        });
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(C0287a aVar, c cVar, DialogInterface dialogInterface) {
        cVar.a(new PopupResponse.Builder().action(2).value(aVar.getValue()).build());
    }
}
