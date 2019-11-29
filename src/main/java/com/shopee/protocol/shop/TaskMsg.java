package com.shopee.protocol.shop;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import e.f;

public final class TaskMsg extends Message {
    public static final Integer DEFAULT_EVENT_TIME = 0;
    public static final f DEFAULT_FUNC_PARAMS = f.f32736b;
    public static final Integer DEFAULT_JOB_TYPE = 0;
    public static final Long DEFAULT_OBJID = 0L;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 5, type = Message.Datatype.INT32)
    public final Integer event_time;
    @ProtoField(tag = 4, type = Message.Datatype.BYTES)
    public final f func_params;
    @ProtoField(tag = 3, type = Message.Datatype.INT32)
    public final Integer job_type;
    @ProtoField(tag = 2, type = Message.Datatype.INT64)
    public final Long objid;

    public TaskMsg(Long l, Integer num, f fVar, Integer num2) {
        this.objid = l;
        this.job_type = num;
        this.func_params = fVar;
        this.event_time = num2;
    }

    private TaskMsg(Builder builder) {
        this(builder.objid, builder.job_type, builder.func_params, builder.event_time);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof TaskMsg)) {
            return false;
        }
        TaskMsg taskMsg = (TaskMsg) obj;
        if (!equals((Object) this.objid, (Object) taskMsg.objid) || !equals((Object) this.job_type, (Object) taskMsg.job_type) || !equals((Object) this.func_params, (Object) taskMsg.func_params) || !equals((Object) this.event_time, (Object) taskMsg.event_time)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Long l = this.objid;
        int i2 = 0;
        int hashCode = (l != null ? l.hashCode() : 0) * 37;
        Integer num = this.job_type;
        int hashCode2 = (hashCode + (num != null ? num.hashCode() : 0)) * 37;
        f fVar = this.func_params;
        int hashCode3 = (hashCode2 + (fVar != null ? fVar.hashCode() : 0)) * 37;
        Integer num2 = this.event_time;
        if (num2 != null) {
            i2 = num2.hashCode();
        }
        int i3 = hashCode3 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<TaskMsg> {
        public Integer event_time;
        public f func_params;
        public Integer job_type;
        public Long objid;

        public Builder() {
        }

        public Builder(TaskMsg taskMsg) {
            super(taskMsg);
            if (taskMsg != null) {
                this.objid = taskMsg.objid;
                this.job_type = taskMsg.job_type;
                this.func_params = taskMsg.func_params;
                this.event_time = taskMsg.event_time;
            }
        }

        public Builder objid(Long l) {
            this.objid = l;
            return this;
        }

        public Builder job_type(Integer num) {
            this.job_type = num;
            return this;
        }

        public Builder func_params(f fVar) {
            this.func_params = fVar;
            return this;
        }

        public Builder event_time(Integer num) {
            this.event_time = num;
            return this;
        }

        public TaskMsg build() {
            return new TaskMsg(this);
        }
    }
}
