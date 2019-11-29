package com.airpay.paysdk.core;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.airpay.paysdk.base.bean.BPOrderInfo;
import com.airpay.paysdk.base.bean.BPPaymentOrderInfo;
import com.airpay.paysdk.base.proto.ActionProto;
import com.airpay.paysdk.base.proto.AuthMethodVerifyReplyProto;
import com.airpay.paysdk.base.proto.AuthMethodVerifyRequestProto;
import com.airpay.paysdk.base.proto.BankAccountListGetReplyProto;
import com.airpay.paysdk.base.proto.CashCurrentGetReplyProto;
import com.airpay.paysdk.base.proto.CashCurrentGetRequestProto;
import com.airpay.paysdk.base.proto.ChannelListGetReplyProto;
import com.airpay.paysdk.base.proto.ChannelListGetRequestProto;
import com.airpay.paysdk.base.proto.PaymentConfirmDetailReplyProto;
import com.airpay.paysdk.base.proto.PaymentOrderActionRequestProto;
import com.airpay.paysdk.base.proto.PaymentOrderCancelRequestProto;
import com.airpay.paysdk.base.proto.PaymentOrderExecuteReplyProto;
import com.airpay.paysdk.base.proto.PaymentOrderExecuteRequestProto;
import com.airpay.paysdk.base.proto.PaymentOrderInitReplyProto;
import com.airpay.paysdk.base.proto.PaymentOrderInitRequestProto;
import com.airpay.paysdk.base.proto.PaymentOrderPrecheckReplyProto;
import com.airpay.paysdk.base.proto.PaymentOrderPrecheckRequestProto;
import com.airpay.paysdk.base.proto.PaymentPasswordResetInitReplyProto;
import com.airpay.paysdk.base.proto.QRCodeActivePaymentInfoProto;
import com.airpay.paysdk.base.proto.QRCodeGetReplyProto;
import com.airpay.paysdk.base.proto.QRCodeGetRequestProto;
import com.airpay.paysdk.base.proto.QRCodeScanReplyProto;
import com.airpay.paysdk.base.proto.QRCodeScanRequestProto;
import com.airpay.paysdk.base.proto.QRCodeTopupInfoGetReplyProto;
import com.airpay.paysdk.base.proto.SdkLoginForShopeeReplyProto;
import com.airpay.paysdk.base.proto.SdkLoginForShopeeRequestProto;
import com.airpay.paysdk.base.proto.ShoppingCartProto;
import com.airpay.paysdk.c;
import com.airpay.paysdk.common.net.a.a.g;
import com.airpay.paysdk.common.net.tcp.b.b;
import com.airpay.paysdk.common.net.tcp.b.e;
import com.airpay.paysdk.common.net.tcp.proto.BasicPacketProto;
import com.airpay.paysdk.common.net.tcp.proto.PacketHeaderProto;
import com.airpay.paysdk.core.bean.ChannelInfo;
import com.airpay.paysdk.core.bean.ChannelListInfo;
import com.airpay.paysdk.libs.wire.Message;
import com.airpay.paysdk.pay.password.BPPaymentProcessingInfo;
import com.airpay.paysdk.pay.password.InitPasswordResetResultInfo;
import com.airpay.paysdk.pay.password.PasswordResultInfo;
import com.airpay.paysdk.pay.password.PaymentConfirmDetailInfo;
import com.airpay.paysdk.pay.password.PaymentOrderExecuteResultInfo;
import com.airpay.paysdk.pay.password.PaymentOrderInitResultInfo;
import com.airpay.paysdk.pay.password.ShoppingCartInfo;
import com.airpay.paysdk.pay.password.VerifyAuthMehodResultInfo;
import com.airpay.paysdk.pay.password.VerifyResultFullInfo;
import com.airpay.paysdk.qrcode.model.BankAccountListInfo;
import com.airpay.paysdk.qrcode.model.QRCodeGetInfo;
import com.airpay.paysdk.qrcode.model.QRCodeTopupInfo;
import com.google.android.gms.location.LocationSettingsStatusCodes;
import com.tencent.imsdk.TIMGroupManager;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class a {
    private a() {
    }

    public static a a() {
        return new a();
    }

    private PacketHeaderProto a(b bVar) {
        return new PacketHeaderProto.Builder().id(Integer.valueOf(bVar.b())).source(1).build();
    }

    public com.airpay.paysdk.common.net.a.a.b a(boolean z, int i, String str, final com.airpay.paysdk.common.net.a.a.a<QRCodeGetInfo> aVar) {
        b a2 = new b.a().a();
        QRCodeGetRequestProto.Builder builder = new QRCodeGetRequestProto.Builder();
        builder.header(a(a2));
        builder.use_cash(Boolean.valueOf(z));
        if (i > 0) {
            builder.topup_channel_id(Integer.valueOf(i));
        }
        if (!TextUtils.isEmpty(str)) {
            builder.topup_account_id(str);
        }
        return com.airpay.paysdk.common.net.a.a().a((g) new e(a2, 8534, (Message) builder.build()), QRCodeGetReplyProto.class, new com.airpay.paysdk.common.net.a.a.a<QRCodeGetReplyProto>() {
            public void a(QRCodeGetReplyProto qRCodeGetReplyProto) {
                QRCodeGetInfo qRCodeGetInfo = new QRCodeGetInfo(qRCodeGetReplyProto);
                com.airpay.paysdk.common.net.a.a.a aVar = aVar;
                if (aVar != null) {
                    aVar.a(qRCodeGetInfo);
                }
            }

            public void a(int i, String str) {
                com.airpay.paysdk.common.net.a.a.a aVar = aVar;
                if (aVar != null) {
                    aVar.a(i, str);
                }
            }
        });
    }

    public com.airpay.paysdk.common.net.a.a.b a(final com.airpay.paysdk.common.net.a.a.a<QRCodeTopupInfo> aVar) {
        b a2 = new b.a().a();
        BasicPacketProto.Builder builder = new BasicPacketProto.Builder();
        builder.header(a(a2));
        return com.airpay.paysdk.common.net.a.a().a((g) new e(a2, 8536, (Message) builder.build()), QRCodeTopupInfoGetReplyProto.class, new com.airpay.paysdk.common.net.a.a.a<QRCodeTopupInfoGetReplyProto>() {
            public void a(QRCodeTopupInfoGetReplyProto qRCodeTopupInfoGetReplyProto) {
                QRCodeTopupInfo qRCodeTopupInfo = new QRCodeTopupInfo(qRCodeTopupInfoGetReplyProto);
                com.airpay.paysdk.common.net.a.a.a aVar = aVar;
                if (aVar != null) {
                    aVar.a(qRCodeTopupInfo);
                }
            }

            public void a(int i, String str) {
                com.airpay.paysdk.common.net.a.a.a aVar = aVar;
                if (aVar != null) {
                    aVar.a(i, str);
                }
            }
        });
    }

    public com.airpay.paysdk.common.net.a.a.b b(final com.airpay.paysdk.common.net.a.a.a<BankAccountListInfo> aVar) {
        b a2 = new b.a().a();
        BasicPacketProto.Builder builder = new BasicPacketProto.Builder();
        builder.header(a(a2));
        return com.airpay.paysdk.common.net.a.a().a((g) new e(a2, 8546, (Message) builder.build()), BankAccountListGetReplyProto.class, new com.airpay.paysdk.common.net.a.a.a<BankAccountListGetReplyProto>() {
            public void a(BankAccountListGetReplyProto bankAccountListGetReplyProto) {
                BankAccountListInfo bankAccountListInfo = new BankAccountListInfo(bankAccountListGetReplyProto);
                com.airpay.paysdk.base.b.b.a().a(bankAccountListInfo.f4362a);
                com.airpay.paysdk.common.net.a.a.a aVar = aVar;
                if (aVar != null) {
                    aVar.a(bankAccountListInfo);
                }
            }

            public void a(int i, String str) {
                com.airpay.paysdk.common.net.a.a.a aVar = aVar;
                if (aVar != null) {
                    aVar.a(i, str);
                }
            }
        });
    }

    public com.airpay.paysdk.common.net.a.a.b a(ShoppingCartInfo shoppingCartInfo, long j, com.airpay.paysdk.common.net.a.a.a<PaymentOrderPrecheckReplyProto> aVar) {
        b a2 = new b.a().a();
        PaymentOrderPrecheckRequestProto.Builder builder = new PaymentOrderPrecheckRequestProto.Builder();
        builder.header(a(a2));
        if (shoppingCartInfo != null) {
            builder.shopping_cart(shoppingCartInfo.b());
        }
        if (j > 0) {
            builder.payment_payable_amount(Long.valueOf(j));
        }
        return com.airpay.paysdk.common.net.a.a().a((g) new e(a2, 8568, (Message) builder.build()), PaymentOrderPrecheckReplyProto.class, aVar);
    }

    public com.airpay.paysdk.common.net.a.a.b a(ChannelInfo channelInfo, String str, int i, String str2, long j, String str3, com.airpay.paysdk.common.net.a.a.a<PaymentOrderPrecheckReplyProto> aVar) {
        b a2 = new b.a().a();
        PaymentOrderPrecheckRequestProto.Builder builder = new PaymentOrderPrecheckRequestProto.Builder();
        builder.header(a(a2));
        if (!TextUtils.isEmpty(str)) {
            builder.account_id(str);
        }
        if (channelInfo != null && channelInfo.a() > -1) {
            builder.payment_channel_id(Integer.valueOf(channelInfo.a()));
        }
        if (channelInfo != null && !TextUtils.isEmpty(channelInfo.c())) {
            builder.currency(channelInfo.c());
        }
        if (j > 0) {
            builder.payment_payable_amount(Long.valueOf(j));
        }
        if (i > -1) {
            builder.item_amount(Integer.valueOf(i));
        }
        if (!TextUtils.isEmpty(str2)) {
            builder.item_id(str2);
        }
        if (!TextUtils.isEmpty(str3)) {
            builder.extra_data(str3);
        }
        return com.airpay.paysdk.common.net.a.a().a((g) new e(a2, 8568, (Message) builder.build()), PaymentOrderPrecheckReplyProto.class, aVar);
    }

    public com.airpay.paysdk.common.net.a.a.b a(int i, com.airpay.paysdk.common.net.a.a.a<ChannelListInfo> aVar) {
        return a((List<Integer>) Collections.singletonList(Integer.valueOf(i)), aVar);
    }

    public com.airpay.paysdk.common.net.a.a.b a(List<Integer> list, com.airpay.paysdk.common.net.a.a.a<ChannelListInfo> aVar) {
        return a("method_by_ids", list, aVar);
    }

    public com.airpay.paysdk.common.net.a.a.b b(List<Integer> list, com.airpay.paysdk.common.net.a.a.a<ChannelListInfo> aVar) {
        return a("method_by_types", list, aVar);
    }

    private com.airpay.paysdk.common.net.a.a.b a(String str, List<Integer> list, final com.airpay.paysdk.common.net.a.a.a<ChannelListInfo> aVar) {
        b a2 = b.a();
        ChannelListGetRequestProto.Builder builder = new ChannelListGetRequestProto.Builder();
        builder.header(a(a2));
        if (str.equals("method_by_ids")) {
            builder.channel_id_list(list);
        } else if (str.equals("method_by_types")) {
            builder.channel_type_list(list);
        }
        return com.airpay.paysdk.common.net.a.a().a((g) new e(a2, 8545, (Message) builder.build()), ChannelListGetReplyProto.class, new com.airpay.paysdk.common.net.a.a.a<ChannelListGetReplyProto>() {
            public void a(ChannelListGetReplyProto channelListGetReplyProto) {
                ChannelListInfo channelListInfo = new ChannelListInfo(channelListGetReplyProto);
                com.airpay.paysdk.common.net.a.a.a aVar = aVar;
                if (aVar != null) {
                    aVar.a(channelListInfo);
                }
            }

            public void a(int i, String str) {
                com.airpay.paysdk.common.net.a.a.a aVar = aVar;
                if (aVar != null) {
                    aVar.a(i, str);
                }
            }
        });
    }

    public void a(String str, com.airpay.paysdk.common.net.a.a.a<SdkLoginForShopeeReplyProto> aVar) {
        b a2 = b.a();
        PacketHeaderProto a3 = a(a2);
        SdkLoginForShopeeRequestProto.Builder builder = new SdkLoginForShopeeRequestProto.Builder();
        com.airpay.paysdk.base.different.netserver.a c2 = com.airpay.paysdk.a.a().c();
        builder.session_key = str;
        builder.header = a3;
        builder.device_key = c2.h();
        builder.device_type = Integer.valueOf(c2.f());
        builder.language = com.airpay.paysdk.base.different.a.a().d();
        builder.device_os_version = String.valueOf(Build.VERSION.SDK_INT);
        builder.shopee_version = c2.d();
        builder.version = Integer.valueOf(c2.e());
        com.airpay.paysdk.common.net.a.a().a(1, new e(a2, 9282, (Message) builder.build()), SdkLoginForShopeeReplyProto.class, aVar);
    }

    public PaymentOrderInitRequestProto.Builder a(BPPaymentOrderInfo bPPaymentOrderInfo, long j) {
        PaymentOrderInitRequestProto.Builder builder = new PaymentOrderInitRequestProto.Builder();
        builder.header(a(b.a()));
        builder.item_amount(Integer.valueOf(bPPaymentOrderInfo.itemCount));
        builder.item_id(bPPaymentOrderInfo.itemId);
        builder.currency(bPPaymentOrderInfo.paymentChannelCurrecy);
        builder.payment_payable_amount(Long.valueOf(bPPaymentOrderInfo.paymentPayable));
        builder.currency_amount(Long.valueOf(bPPaymentOrderInfo.currencyAmount));
        builder.topup_payable_amount(Long.valueOf(bPPaymentOrderInfo.topupPayable));
        builder.payment_channel_id(Integer.valueOf(bPPaymentOrderInfo.paymentChannelId));
        builder.account_id(bPPaymentOrderInfo.accountId);
        builder.topup_channel_id(Integer.valueOf(bPPaymentOrderInfo.topupChannelId));
        builder.topup_cash_amount(Long.valueOf(j));
        if (bPPaymentOrderInfo.eventId != null) {
            builder.event_id(bPPaymentOrderInfo.eventId);
        }
        if (bPPaymentOrderInfo.bankAccountId != null) {
            builder.bank_account_id(bPPaymentOrderInfo.bankAccountId);
        }
        return builder;
    }

    public com.airpay.paysdk.common.net.a.a.b b(final String str, final com.airpay.paysdk.common.net.a.a.a<VerifyResultFullInfo> aVar) {
        b a2 = new b.a().a();
        AuthMethodVerifyRequestProto.Builder builder = new AuthMethodVerifyRequestProto.Builder();
        builder.header(a(a2));
        builder.auth_method(1);
        builder.auth_key(com.airpay.paysdk.base.d.a.b(str));
        return com.airpay.paysdk.common.net.a.a().a((g) new e(a2, 8505, (Message) builder.build()), AuthMethodVerifyReplyProto.class, new com.airpay.paysdk.common.net.a.a.a<AuthMethodVerifyReplyProto>() {
            public void a(AuthMethodVerifyReplyProto authMethodVerifyReplyProto) {
                VerifyAuthMehodResultInfo verifyAuthMehodResultInfo = new VerifyAuthMehodResultInfo(authMethodVerifyReplyProto);
                VerifyResultFullInfo verifyResultFullInfo = new VerifyResultFullInfo(verifyAuthMehodResultInfo, new PasswordResultInfo(0, com.airpay.paysdk.base.d.a.b(str), verifyAuthMehodResultInfo.a()));
                com.airpay.paysdk.common.net.a.a.a aVar = aVar;
                if (aVar != null) {
                    aVar.a(verifyResultFullInfo);
                }
            }

            public void a(int i, String str) {
                com.airpay.paysdk.common.net.a.a.a aVar = aVar;
                if (aVar != null) {
                    aVar.a(i, str);
                }
            }
        });
    }

    public com.airpay.paysdk.common.net.a.a.b c(final com.airpay.paysdk.common.net.a.a.a<InitPasswordResetResultInfo> aVar) {
        b a2 = new b.a().a();
        BasicPacketProto.Builder builder = new BasicPacketProto.Builder();
        builder.header(a(a2));
        return com.airpay.paysdk.common.net.a.a().a((g) new e(a2, (int) LocationSettingsStatusCodes.SETTINGS_CHANGE_UNAVAILABLE, (Message) builder.build()), PaymentPasswordResetInitReplyProto.class, new com.airpay.paysdk.common.net.a.a.a<PaymentPasswordResetInitReplyProto>() {
            public void a(PaymentPasswordResetInitReplyProto paymentPasswordResetInitReplyProto) {
                InitPasswordResetResultInfo initPasswordResetResultInfo = new InitPasswordResetResultInfo(paymentPasswordResetInitReplyProto);
                com.airpay.paysdk.common.net.a.a.a aVar = aVar;
                if (aVar != null) {
                    aVar.a(initPasswordResetResultInfo);
                }
            }

            public void a(int i, String str) {
                com.airpay.paysdk.common.net.a.a.a aVar = aVar;
                if (aVar != null) {
                    aVar.a(i, str);
                }
            }
        });
    }

    public com.airpay.paysdk.common.net.a.a.b a(BPPaymentProcessingInfo bPPaymentProcessingInfo, final com.airpay.paysdk.common.net.a.a.a<PaymentOrderInitResultInfo> aVar) {
        String str;
        b a2 = new b.a().a();
        PaymentOrderInitRequestProto.Builder newBuilder = bPPaymentProcessingInfo.f4208a.newBuilder();
        JSONObject a3 = a(com.airpay.paysdk.pay.b.a.a(newBuilder.extra_data));
        if (a3 == null) {
            str = "";
        } else {
            str = a3.toString();
        }
        newBuilder.extra_data(str);
        PaymentOrderInitRequestProto.Builder newBuilder2 = newBuilder.build().newBuilder();
        newBuilder2.header(a(a2));
        return com.airpay.paysdk.common.net.a.a().a((g) new e(a2, 8564, (Message) newBuilder2.build()), PaymentOrderInitReplyProto.class, new com.airpay.paysdk.common.net.a.a.a<PaymentOrderInitReplyProto>() {
            public void a(PaymentOrderInitReplyProto paymentOrderInitReplyProto) {
                PaymentOrderInitResultInfo paymentOrderInitResultInfo = new PaymentOrderInitResultInfo(paymentOrderInitReplyProto);
                com.airpay.paysdk.common.net.a.a.a aVar = aVar;
                if (aVar != null) {
                    aVar.a(paymentOrderInitResultInfo);
                }
            }

            public void a(int i, String str) {
                com.airpay.paysdk.common.net.a.a.a aVar = aVar;
                if (aVar != null) {
                    aVar.a(i, str);
                }
            }
        });
    }

    private JSONObject a(JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        try {
            JSONObject jSONObject2 = jSONObject.has("payment") ? jSONObject.getJSONObject("payment") : new JSONObject();
            jSONObject2.put("txn_source", 0);
            jSONObject.put("payment", jSONObject2);
        } catch (JSONException e2) {
            com.airpay.paysdk.common.b.a.a((Throwable) e2);
        }
        return jSONObject;
    }

    public com.airpay.paysdk.common.net.a.a.b a(long j, String str, String str2, final com.airpay.paysdk.common.net.a.a.a<PaymentOrderExecuteResultInfo> aVar) {
        b a2 = new b.a().a();
        PaymentOrderExecuteRequestProto.Builder builder = new PaymentOrderExecuteRequestProto.Builder();
        builder.header(a(a2));
        builder.order_id(Long.valueOf(j));
        if (str != null) {
            builder.extra_data(str);
        }
        builder.secure_token(str2);
        return com.airpay.paysdk.common.net.a.a().a((g) new e(a2, 8565, (Message) builder.build()), PaymentOrderExecuteReplyProto.class, new com.airpay.paysdk.common.net.a.a.a<PaymentOrderExecuteReplyProto>() {
            public void a(PaymentOrderExecuteReplyProto paymentOrderExecuteReplyProto) {
                PaymentOrderExecuteResultInfo paymentOrderExecuteResultInfo = new PaymentOrderExecuteResultInfo(paymentOrderExecuteReplyProto);
                com.airpay.paysdk.common.net.a.a.a aVar = aVar;
                if (aVar != null) {
                    aVar.a(paymentOrderExecuteResultInfo);
                }
            }

            public void a(int i, String str) {
                com.airpay.paysdk.common.net.a.a.a aVar = aVar;
                if (aVar != null) {
                    aVar.a(i, str);
                }
            }
        });
    }

    public com.airpay.paysdk.common.net.a.a.b a(long j, final com.airpay.paysdk.common.net.a.a.a<Void> aVar) {
        b a2 = new b.a().a();
        PacketHeaderProto.Builder builder = new PacketHeaderProto.Builder();
        builder.id = Integer.valueOf(a2.b());
        PaymentOrderCancelRequestProto.Builder builder2 = new PaymentOrderCancelRequestProto.Builder();
        builder2.header = builder.build();
        builder2.order_id = Long.valueOf(j);
        return com.airpay.paysdk.common.net.a.a().a((g) new e(a2, 8563, (Message) builder2.build()), BasicPacketProto.class, new com.airpay.paysdk.common.net.a.a.a<BasicPacketProto>() {
            public void a(BasicPacketProto basicPacketProto) {
                com.airpay.paysdk.common.net.a.a.a aVar = aVar;
                if (aVar != null) {
                    aVar.a(null);
                }
            }

            public void a(int i, String str) {
                com.airpay.paysdk.common.net.a.a.a aVar = aVar;
                if (aVar != null) {
                    aVar.a(i, str);
                }
            }
        });
    }

    public com.airpay.paysdk.common.net.a.a.b c(String str, final com.airpay.paysdk.common.net.a.a.a<ShoppingCartInfo> aVar) {
        b a2 = new b.a().a();
        QRCodeScanRequestProto.Builder builder = new QRCodeScanRequestProto.Builder();
        builder.header(a(a2));
        builder.qr_code(str);
        builder.source_info((String) null);
        return com.airpay.paysdk.common.net.a.a().a((g) new e(a2, 8528, (Message) builder.build()), QRCodeScanReplyProto.class, new com.airpay.paysdk.common.net.a.a.a<QRCodeScanReplyProto>() {
            public void a(QRCodeScanReplyProto qRCodeScanReplyProto) {
                List<ActionProto> list = qRCodeScanReplyProto.actions;
                if (list == null || list.isEmpty()) {
                    a(-1, "the data get error of the qrcode.");
                    return;
                }
                ActionProto actionProto = list.get(0);
                int intValue = actionProto.cmd.intValue() ^ TIMGroupManager.TIM_GET_GROUP_BASE_INFO_FLAG_GROUP_TYPE;
                if (intValue != 2340) {
                    Context b2 = com.airpay.paysdk.a.a().b();
                    a(intValue, intValue != 2342 ? b2.getString(c.i.airpay_title_merchantservice_ask_the_merchant_to_check) : b2.getString(c.i.airpay_qrcode_own_shop_error));
                    return;
                }
                try {
                    ShoppingCartInfo shoppingCartInfo = new ShoppingCartInfo(QRCodeActivePaymentInfoProto.ADAPTER.decode(actionProto.data).shopping_cart);
                    List<BPOrderInfo> a2 = shoppingCartInfo.a();
                    ArrayList arrayList = new ArrayList();
                    for (BPOrderInfo next : a2) {
                        arrayList.add(Integer.valueOf(next.getPaymentChannelId()));
                        arrayList.add(Integer.valueOf(next.getTopupChannelId()));
                    }
                    com.airpay.paysdk.qrcode.a.a().a((List<Integer>) arrayList);
                    com.airpay.paysdk.common.net.a.a.a aVar = aVar;
                    if (aVar != null) {
                        aVar.a(shoppingCartInfo);
                    }
                } catch (IOException e2) {
                    a(-1, e2.getMessage());
                }
            }

            public void a(int i, String str) {
                com.airpay.paysdk.common.net.a.a.a aVar = aVar;
                if (aVar != null) {
                    aVar.a(i, str);
                }
            }
        });
    }

    public com.airpay.paysdk.common.net.a.a.b d(final com.airpay.paysdk.common.net.a.a.a<PaymentOrderExecuteReplyProto> aVar) {
        return com.airpay.paysdk.common.net.a.a().a(18729, PaymentOrderExecuteReplyProto.class, new com.airpay.paysdk.common.net.a.a.a<PaymentOrderExecuteReplyProto>() {
            public void a(PaymentOrderExecuteReplyProto paymentOrderExecuteReplyProto) {
                aVar.a(paymentOrderExecuteReplyProto);
            }

            public void a(int i, String str) {
                aVar.a(i, str);
            }
        });
    }

    public com.airpay.paysdk.common.net.a.a.b e(final com.airpay.paysdk.common.net.a.a.a<PaymentConfirmDetailInfo> aVar) {
        return com.airpay.paysdk.common.net.a.a().a(18728, PaymentConfirmDetailReplyProto.class, new com.airpay.paysdk.common.net.a.a.a<PaymentConfirmDetailReplyProto>() {
            public void a(PaymentConfirmDetailReplyProto paymentConfirmDetailReplyProto) {
                PaymentConfirmDetailInfo paymentConfirmDetailInfo = new PaymentConfirmDetailInfo(paymentConfirmDetailReplyProto.detail);
                com.airpay.paysdk.common.net.a.a.a aVar = aVar;
                if (aVar != null) {
                    aVar.a(paymentConfirmDetailInfo);
                }
            }

            public void a(int i, String str) {
                com.airpay.paysdk.common.net.a.a.a aVar = aVar;
                if (aVar != null) {
                    aVar.a(i, str);
                }
            }
        });
    }

    public com.airpay.paysdk.common.net.a.a.b d(String str, final com.airpay.paysdk.common.net.a.a.a<com.airpay.paysdk.base.b.c> aVar) {
        b a2 = new b.a().a();
        CashCurrentGetRequestProto.Builder builder = new CashCurrentGetRequestProto.Builder();
        builder.header(a(a2));
        builder.currency(str);
        return com.airpay.paysdk.common.net.a.a().a((g) new e(a2, 8570, (Message) builder.build()), CashCurrentGetReplyProto.class, new com.airpay.paysdk.common.net.a.a.a<CashCurrentGetReplyProto>() {
            public void a(CashCurrentGetReplyProto cashCurrentGetReplyProto) {
                com.airpay.paysdk.base.b.c a2 = com.airpay.paysdk.base.b.c.a();
                a2.a(cashCurrentGetReplyProto.currency, cashCurrentGetReplyProto.cash_balance.longValue(), cashCurrentGetReplyProto.update_time.intValue(), -1);
                com.airpay.paysdk.common.net.a.a.a aVar = aVar;
                if (aVar != null) {
                    aVar.a(a2);
                }
            }

            public void a(int i, String str) {
                com.airpay.paysdk.common.net.a.a.a aVar = aVar;
                if (aVar != null) {
                    aVar.a(i, str);
                }
            }
        });
    }

    public com.airpay.paysdk.common.net.a.a.b a(ShoppingCartProto shoppingCartProto, String str, final com.airpay.paysdk.common.net.a.a.a<PaymentOrderExecuteResultInfo> aVar) {
        b a2 = new b.a().a();
        PaymentOrderActionRequestProto.Builder builder = new PaymentOrderActionRequestProto.Builder();
        builder.header(a(a2));
        builder.shopping_cart(shoppingCartProto);
        builder.secure_token(str);
        return com.airpay.paysdk.common.net.a.a().a((g) new e(a2, 8577, (Message) builder.build()), PaymentOrderExecuteReplyProto.class, new com.airpay.paysdk.common.net.a.a.a<PaymentOrderExecuteReplyProto>() {
            public void a(PaymentOrderExecuteReplyProto paymentOrderExecuteReplyProto) {
                PaymentOrderExecuteResultInfo paymentOrderExecuteResultInfo = new PaymentOrderExecuteResultInfo(paymentOrderExecuteReplyProto);
                com.airpay.paysdk.common.net.a.a.a aVar = aVar;
                if (aVar != null) {
                    aVar.a(paymentOrderExecuteResultInfo);
                }
            }

            public void a(int i, String str) {
                com.airpay.paysdk.common.net.a.a.a aVar = aVar;
                if (aVar != null) {
                    aVar.a(i, str);
                }
            }
        });
    }
}
