package com.salesforce.android.chat.ui.internal.prechat.viewholder;

import androidx.recyclerview.widget.RecyclerView;
import com.salesforce.android.chat.core.model.PreChatField;
import com.salesforce.android.chat.ui.internal.prechat.viewholder.PreChatViewHolder;
import com.salesforce.android.service.common.ui.internal.text.SalesforceTextWatcher;
import com.salesforce.android.service.common.ui.views.SalesforceTextInputLayout;

@Deprecated
public class StringEditViewHolder extends RecyclerView.w implements PreChatViewHolder {
    private PreChatViewHolder.OnUpdateListener mOnUpdateListener;
    private PreChatField mPreChatField;
    private final SalesforceTextInputLayout mSalesforceTextInputLayout;

    public StringEditViewHolder(SalesforceTextInputLayout salesforceTextInputLayout) {
        super(salesforceTextInputLayout);
        this.mSalesforceTextInputLayout = salesforceTextInputLayout;
        this.mSalesforceTextInputLayout.getEditText().addTextChangedListener(new SalesforceTextWatcher() {
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                StringEditViewHolder.this.processUpdate(charSequence);
            }
        });
    }

    /* JADX WARNING: Code restructure failed: missing block: B:22:0x00b1, code lost:
        if (r8.equals(com.salesforce.android.chat.core.model.PreChatField.STRING) != false) goto L_0x00b5;
     */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x00b7  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00ca  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void setData(com.salesforce.android.chat.core.model.ChatUserData r8) {
        /*
            r7 = this;
            boolean r0 = r8 instanceof com.salesforce.android.chat.core.model.PreChatField
            if (r0 != 0) goto L_0x0005
            return
        L_0x0005:
            com.salesforce.android.chat.core.model.PreChatField r8 = (com.salesforce.android.chat.core.model.PreChatField) r8
            r7.mPreChatField = r8
            com.salesforce.android.chat.core.model.PreChatField r8 = r7.mPreChatField
            java.lang.String r8 = r8.getDisplayName()
            com.salesforce.android.chat.core.model.PreChatField r0 = r7.mPreChatField
            java.lang.Boolean r0 = r0.isRequired()
            boolean r0 = r0.booleanValue()
            if (r0 == 0) goto L_0x002c
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r8)
            java.lang.String r8 = "*"
            r0.append(r8)
            java.lang.String r8 = r0.toString()
        L_0x002c:
            com.salesforce.android.service.common.ui.views.SalesforceTextInputLayout r0 = r7.mSalesforceTextInputLayout
            android.widget.EditText r0 = r0.getEditText()
            com.salesforce.android.service.common.ui.views.SalesforceTextInputLayout r1 = r7.mSalesforceTextInputLayout
            r1.setHint(r8)
            com.salesforce.android.service.common.ui.views.SalesforceTextInputLayout r8 = r7.mSalesforceTextInputLayout
            com.salesforce.android.chat.core.model.PreChatField r1 = r7.mPreChatField
            java.lang.Integer r1 = r1.getMaxValueLength()
            int r1 = r1.intValue()
            r8.setCounterMaxLength(r1)
            com.salesforce.android.service.common.ui.views.SalesforceTextInputLayout r8 = r7.mSalesforceTextInputLayout
            r1 = 1
            r8.setCounterEnabled(r1)
            com.salesforce.android.chat.core.model.PreChatField r8 = r7.mPreChatField
            java.lang.String r8 = r8.getFieldName()
            int r8 = r8.hashCode()
            r0.setId(r8)
            com.salesforce.android.chat.core.model.PreChatField r8 = r7.mPreChatField
            java.lang.Object r8 = r8.getValue()
            java.lang.String r8 = r8.toString()
            r0.setText(r8)
            r0.setSingleLine(r1)
            com.salesforce.android.chat.core.model.PreChatField r8 = r7.mPreChatField
            java.lang.Boolean r8 = r8.isReadOnly()
            boolean r8 = r8.booleanValue()
            r2 = 0
            if (r8 == 0) goto L_0x007b
            com.salesforce.android.service.common.ui.views.SalesforceTextInputLayout r8 = r7.mSalesforceTextInputLayout
            r8.setEnabled(r2)
        L_0x007b:
            com.salesforce.android.chat.core.model.PreChatField r8 = r7.mPreChatField
            java.lang.String r8 = r8.getType()
            r3 = -1
            int r4 = r8.hashCode()
            r5 = -891985903(0xffffffffcad56011, float:-6991880.5)
            r6 = 2
            if (r4 == r5) goto L_0x00ab
            r2 = 96619420(0x5c24b9c, float:1.8271447E-35)
            if (r4 == r2) goto L_0x00a1
            r2 = 106642798(0x65b3d6e, float:4.1234453E-35)
            if (r4 == r2) goto L_0x0097
            goto L_0x00b4
        L_0x0097:
            java.lang.String r2 = "phone"
            boolean r8 = r8.equals(r2)
            if (r8 == 0) goto L_0x00b4
            r2 = 1
            goto L_0x00b5
        L_0x00a1:
            java.lang.String r2 = "email"
            boolean r8 = r8.equals(r2)
            if (r8 == 0) goto L_0x00b4
            r2 = 2
            goto L_0x00b5
        L_0x00ab:
            java.lang.String r4 = "string"
            boolean r8 = r8.equals(r4)
            if (r8 == 0) goto L_0x00b4
            goto L_0x00b5
        L_0x00b4:
            r2 = -1
        L_0x00b5:
            if (r2 == 0) goto L_0x00ca
            if (r2 == r1) goto L_0x00c5
            if (r2 == r6) goto L_0x00bf
            r0.setInputType(r1)
            goto L_0x00cd
        L_0x00bf:
            r8 = 32
            r0.setInputType(r8)
            goto L_0x00cd
        L_0x00c5:
            r8 = 3
            r0.setInputType(r8)
            goto L_0x00cd
        L_0x00ca:
            r0.setInputType(r1)
        L_0x00cd:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.salesforce.android.chat.ui.internal.prechat.viewholder.StringEditViewHolder.setData(com.salesforce.android.chat.core.model.ChatUserData):void");
    }

    public void setOnUpdateListener(PreChatViewHolder.OnUpdateListener onUpdateListener) {
        this.mOnUpdateListener = onUpdateListener;
    }

    /* access modifiers changed from: private */
    public void processUpdate(CharSequence charSequence) {
        PreChatField preChatField = this.mPreChatField;
        if (preChatField != null) {
            boolean booleanValue = preChatField.isSatisfied().booleanValue();
            this.mPreChatField.setValue(charSequence.toString());
            boolean booleanValue2 = this.mPreChatField.isSatisfied().booleanValue();
            PreChatViewHolder.OnUpdateListener onUpdateListener = this.mOnUpdateListener;
            if (onUpdateListener != null && booleanValue2 != booleanValue) {
                onUpdateListener.onPreChatFieldUpdate(this.mPreChatField);
            }
        }
    }
}
