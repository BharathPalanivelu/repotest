package com.path.android.jobqueue.persistentQueue.sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.j256.ormlite.field.FieldType;
import com.litesuits.orm.db.assit.SQLBuilder;
import com.path.android.jobqueue.persistentQueue.sqlite.SqlHelper;

public class DbOpenHelper extends SQLiteOpenHelper {
    static final SqlHelper.Property BASE_JOB_COLUMN = new SqlHelper.Property("base_job", "byte", 4);
    static final int COLUMN_COUNT = 9;
    static final SqlHelper.Property CREATED_NS_COLUMN = new SqlHelper.Property("created_ns", "long", 5);
    private static final int DB_VERSION = 4;
    static final SqlHelper.Property DELAY_UNTIL_NS_COLUMN = new SqlHelper.Property("delay_until_ns", "long", 6);
    static final SqlHelper.Property GROUP_ID_COLUMN = new SqlHelper.Property("group_id", "text", 2);
    static final SqlHelper.Property ID_COLUMN = new SqlHelper.Property(FieldType.FOREIGN_ID_FIELD_SUFFIX, "integer", 0);
    static final String JOB_HOLDER_TABLE_NAME = "job_holder";
    static final String JOB_TAGS_TABLE_NAME = "job_holder_tags";
    static final SqlHelper.Property PRIORITY_COLUMN = new SqlHelper.Property("priority", "integer", 1);
    static final SqlHelper.Property REQUIRES_NETWORK_COLUMN = new SqlHelper.Property("requires_network", "integer", 8);
    static final SqlHelper.Property RUNNING_SESSION_ID_COLUMN = new SqlHelper.Property("running_session_id", "long", 7);
    static final SqlHelper.Property RUN_COUNT_COLUMN = new SqlHelper.Property("run_count", "integer", 3);
    static final int TAGS_COLUMN_COUNT = 3;
    static final SqlHelper.Property TAGS_ID_COLUMN = new SqlHelper.Property(FieldType.FOREIGN_ID_FIELD_SUFFIX, "integer", 0);
    static final SqlHelper.Property TAGS_JOB_ID_COLUMN = new SqlHelper.Property("job_id", "integer", 1, new SqlHelper.ForeignKey(JOB_HOLDER_TABLE_NAME, ID_COLUMN.columnName));
    static final SqlHelper.Property TAGS_NAME_COLUMN = new SqlHelper.Property("tag_name", "text", 2);
    static final String TAG_INDEX_NAME = "TAG_NAME_INDEX";

    public DbOpenHelper(Context context, String str) {
        super(context, str, (SQLiteDatabase.CursorFactory) null, 4);
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL(SqlHelper.create(JOB_HOLDER_TABLE_NAME, ID_COLUMN, PRIORITY_COLUMN, GROUP_ID_COLUMN, RUN_COUNT_COLUMN, BASE_JOB_COLUMN, CREATED_NS_COLUMN, DELAY_UNTIL_NS_COLUMN, RUNNING_SESSION_ID_COLUMN, REQUIRES_NETWORK_COLUMN));
        sQLiteDatabase.execSQL(SqlHelper.create(JOB_TAGS_TABLE_NAME, TAGS_ID_COLUMN, TAGS_JOB_ID_COLUMN, TAGS_NAME_COLUMN));
        sQLiteDatabase.execSQL("CREATE INDEX IF NOT EXISTS TAG_NAME_INDEX ON job_holder_tags(" + TAGS_NAME_COLUMN.columnName + SQLBuilder.PARENTHESES_RIGHT);
    }

    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        sQLiteDatabase.execSQL(SqlHelper.drop(JOB_HOLDER_TABLE_NAME));
        sQLiteDatabase.execSQL(SqlHelper.drop(JOB_TAGS_TABLE_NAME));
        sQLiteDatabase.execSQL("DROP INDEX IF EXISTS TAG_NAME_INDEX");
        onCreate(sQLiteDatabase);
    }
}
