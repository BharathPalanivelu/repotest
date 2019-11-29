package com.shopee.protocol.shop;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import e.f;

public final class TaskRunner extends Message {
    public static final Integer DEFAULT_CTIME = 0;
    public static final Integer DEFAULT_EVENT_TIME = 0;
    public static final f DEFAULT_FUNC_PARAMS = f.f32736b;
    public static final Integer DEFAULT_JOB_TYPE = 0;
    public static final Integer DEFAULT_MTIME = 0;
    public static final Long DEFAULT_OBJID = 0L;
    public static final Integer DEFAULT_STATUS = 0;
    public static final Long DEFAULT_TASKID = 0L;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 7, type = Message.Datatype.INT32)
    public final Integer ctime;
    @ProtoField(tag = 5, type = Message.Datatype.INT32)
    public final Integer event_time;
    @ProtoField(tag = 4, type = Message.Datatype.BYTES)
    public final f func_params;
    @ProtoField(tag = 3, type = Message.Datatype.INT32)
    public final Integer job_type;
    @ProtoField(tag = 8, type = Message.Datatype.INT32)
    public final Integer mtime;
    @ProtoField(tag = 2, type = Message.Datatype.INT64)
    public final Long objid;
    @ProtoField(tag = 6, type = Message.Datatype.INT32)
    public final Integer status;
    @ProtoField(tag = 1, type = Message.Datatype.INT64)
    public final Long taskid;

    public TaskRunner(Long l, Long l2, Integer num, f fVar, Integer num2, Integer num3, Integer num4, Integer num5) {
        this.taskid = l;
        this.objid = l2;
        this.job_type = num;
        this.func_params = fVar;
        this.event_time = num2;
        this.status = num3;
        this.ctime = num4;
        this.mtime = num5;
    }

    private TaskRunner(Builder builder) {
        this(builder.taskid, builder.objid, builder.job_type, builder.func_params, builder.event_time, builder.status, builder.ctime, builder.mtime);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof TaskRunner)) {
            return false;
        }
        TaskRunner taskRunner = (TaskRunner) obj;
        if (!equals((Object) this.taskid, (Object) taskRunner.taskid) || !equals((Object) this.objid, (Object) taskRunner.objid) || !equals((Object) this.job_type, (Object) taskRunner.job_type) || !equals((Object) this.func_params, (Object) taskRunner.func_params) || !equals((Object) this.event_time, (Object) taskRunner.event_time) || !equals((Object) this.status, (Object) taskRunner.status) || !equals((Object) this.ctime, (Object) taskRunner.ctime) || !equals((Object) this.mtime, (Object) taskRunner.mtime)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Long l = this.taskid;
        int i2 = 0;
        int hashCode = (l != null ? l.hashCode() : 0) * 37;
        Long l2 = this.objid;
        int hashCode2 = (hashCode + (l2 != null ? l2.hashCode() : 0)) * 37;
        Integer num = this.job_type;
        int hashCode3 = (hashCode2 + (num != null ? num.hashCode() : 0)) * 37;
        f fVar = this.func_params;
        int hashCode4 = (hashCode3 + (fVar != null ? fVar.hashCode() : 0)) * 37;
        Integer num2 = this.event_time;
        int hashCode5 = (hashCode4 + (num2 != null ? num2.hashCode() : 0)) * 37;
        Integer num3 = this.status;
        int hashCode6 = (hashCode5 + (num3 != null ? num3.hashCode() : 0)) * 37;
        Integer num4 = this.ctime;
        int hashCode7 = (hashCode6 + (num4 != null ? num4.hashCode() : 0)) * 37;
        Integer num5 = this.mtime;
        if (num5 != null) {
            i2 = num5.hashCode();
        }
        int i3 = hashCode7 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<TaskRunner> {
        public Integer ctime;
        public Integer event_time;
        public f func_params;
        public Integer job_type;
        public Integer mtime;
        public Long objid;
        public Integer status;
        public Long taskid;

        public Builder() {
        }

        public Builder(TaskRunner taskRunner) {
            super(taskRunner);
            if (taskRunner != null) {
                this.taskid = taskRunner.taskid;
                this.objid = taskRunner.objid;
                this.job_type = taskRunner.job_type;
                this.func_params = taskRunner.func_params;
                this.event_time = taskRunner.event_time;
                this.status = taskRunner.status;
                this.ctime = taskRunner.ctime;
                this.mtime = taskRunner.mtime;
            }
        }

        public Builder taskid(Long l) {
            this.taskid = l;
            return this;
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

        public Builder status(Integer num) {
            this.status = num;
            return this;
        }

        public Builder ctime(Integer num) {
            this.ctime = num;
            return this;
        }

        public Builder mtime(Integer num) {
            this.mtime = num;
            return this;
        }

        public TaskRunner build() {
            return new TaskRunner(this);
        }
    }
}
