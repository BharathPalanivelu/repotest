package com.tencent.qalsdk.im_open;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qalsdk.im_open.common;

public final class stat_hello {

    public static final class ReqBody extends MessageMicro<ReqBody> {
        public static final int BYTES_BIND_QQ_KEY_FIELD_NUMBER = 9;
        public static final int BYTES_GUID_FIELD_NUMBER = 2;
        public static final int STR_DEFINE_VERSION_FIELD_NUMBER = 12;
        public static final int STR_DEV_NAME_FIELD_NUMBER = 3;
        public static final int STR_DEV_TYPE_FIELD_NUMBER = 4;
        public static final int STR_FIRMWARE_VER_FIELD_NUMBER = 6;
        public static final int STR_OS_VER_FIELD_NUMBER = 5;
        public static final int UINT32_INST_TYPE_FIELD_NUMBER = 11;
        public static final int UINT32_PRODUCT_VER_FIELD_NUMBER = 10;
        public static final int UINT32_STATUS_FIELD_NUMBER = 1;
        public static final int UINT64_BIND_QQ_FIELD_NUMBER = 8;
        public static final int VENDER_APPID_FIELD_NUMBER = 7;
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34, 42, 50, 56, 64, 74, 80, 88, 98}, new String[]{"uint32_status", "bytes_guid", "str_dev_name", "str_dev_type", "str_os_ver", "str_firmware_ver", "vender_appid", "uint64_bind_qq", "bytes_bind_qq_key", "uint32_product_ver", "uint32_inst_type", "str_define_version"}, new Object[]{11, ByteStringMicro.EMPTY, "", "", "", "", 0, 0L, ByteStringMicro.EMPTY, 0, 0, ""}, ReqBody.class);
        public final PBBytesField bytes_bind_qq_key = PBField.initBytes(ByteStringMicro.EMPTY);
        public final PBBytesField bytes_guid = PBField.initBytes(ByteStringMicro.EMPTY);
        public final PBStringField str_define_version = PBField.initString("");
        public final PBStringField str_dev_name = PBField.initString("");
        public final PBStringField str_dev_type = PBField.initString("");
        public final PBStringField str_firmware_ver = PBField.initString("");
        public final PBStringField str_os_ver = PBField.initString("");
        public final PBUInt32Field uint32_inst_type = PBField.initUInt32(0);
        public final PBUInt32Field uint32_product_ver = PBField.initUInt32(0);
        public final PBUInt32Field uint32_status = PBField.initUInt32(11);
        public final PBUInt64Field uint64_bind_qq = PBField.initUInt64(0);
        public final PBUInt32Field vender_appid = PBField.initUInt32(0);
    }

    public static final class RspBody extends MessageMicro<RspBody> {
        public static final int ENUM_CMD_ERROR_CODE_FIELD_NUMBER = 1;
        public static final int STR_CLIENT_IP_FIELD_NUMBER = 4;
        public static final int STR_ERR_MSG_FIELD_NUMBER = 2;
        public static final int UINT32_CLIENT_PORT_FIELD_NUMBER = 5;
        public static final int UINT32_HELLO_INTERVAL_FIELD_NUMBER = 3;
        public static final int UINT32_REP_INTERVAL_FIELD_NUMBER = 6;
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 34, 40, 48}, new String[]{"enum_cmd_error_code", "str_err_msg", "uint32_hello_interval", "str_client_ip", "uint32_client_port", "uint32_rep_interval"}, new Object[]{null, "", 300, "", 0, 3600}, RspBody.class);
        public common.CmdErrorCode enum_cmd_error_code = new common.CmdErrorCode();
        public final PBStringField str_client_ip = PBField.initString("");
        public final PBStringField str_err_msg = PBField.initString("");
        public final PBUInt32Field uint32_client_port = PBField.initUInt32(0);
        public final PBUInt32Field uint32_hello_interval = PBField.initUInt32(300);
        public final PBUInt32Field uint32_rep_interval = PBField.initUInt32(3600);
    }

    private stat_hello() {
    }
}
