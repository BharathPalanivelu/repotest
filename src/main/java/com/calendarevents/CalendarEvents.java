package com.calendarevents;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.provider.CalendarContract;
import androidx.core.app.a;
import androidx.core.content.b;
import com.facebook.places.model.PlaceFields;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableType;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.bridge.WritableNativeArray;
import com.facebook.react.bridge.WritableNativeMap;
import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.stmt.query.SimpleComparison;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.TimeZone;
import tencent.tls.platform.SigType;

public class CalendarEvents extends ReactContextBaseJavaModule {
    public static int PERMISSION_REQUEST_CODE = 37;
    private static HashMap<Integer, Promise> permissionsPromises = new HashMap<>();
    private ReactContext reactContext;

    public String getName() {
        return "CalendarEvents";
    }

    public CalendarEvents(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
        this.reactContext = reactApplicationContext;
    }

    private void requestCalendarReadWritePermission(Promise promise) {
        Activity currentActivity = getCurrentActivity();
        if (currentActivity == null) {
            promise.reject("E_ACTIVITY_DOES_NOT_EXIST", "Activity doesn't exist");
            return;
        }
        PERMISSION_REQUEST_CODE++;
        permissionsPromises.put(Integer.valueOf(PERMISSION_REQUEST_CODE), promise);
        a.a(currentActivity, new String[]{"android.permission.WRITE_CALENDAR", "android.permission.READ_CALENDAR"}, PERMISSION_REQUEST_CODE);
    }

    public static void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (permissionsPromises.containsKey(Integer.valueOf(i))) {
            Promise promise = permissionsPromises.get(Integer.valueOf(i));
            if (iArr.length > 0 && iArr[0] == 0) {
                promise.resolve("authorized");
            } else if (iArr.length > 0 && iArr[0] == -1) {
                promise.resolve("denied");
            } else if (permissionsPromises.size() == 1) {
                promise.reject("permissions - unknown error", iArr.length > 0 ? String.valueOf(iArr[0]) : "Request was cancelled");
            }
            permissionsPromises.remove(Integer.valueOf(i));
        }
    }

    private boolean haveCalendarReadWritePermissions() {
        return b.b((Context) this.reactContext, "android.permission.WRITE_CALENDAR") == 0;
    }

    public WritableNativeArray findEvents(String str, String str2) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
        Calendar instance = Calendar.getInstance();
        Calendar instance2 = Calendar.getInstance();
        try {
            instance.setTime(simpleDateFormat.parse(str));
            instance2.setTime(simpleDateFormat.parse(str2));
        } catch (ParseException e2) {
            e2.printStackTrace();
        }
        return serializeEvents(this.reactContext.getContentResolver().query(CalendarContract.Events.CONTENT_URI, new String[]{FieldType.FOREIGN_ID_FIELD_SUFFIX, "title", "description", "dtstart", "dtend", "allDay", "eventLocation", "rrule"}, "((dtstart >= " + instance.getTimeInMillis() + ") AND (" + "dtend" + " <= " + instance2.getTimeInMillis() + ") AND (" + "deleted" + " != 1))", (String[]) null, (String) null));
    }

    public WritableNativeMap findEventsById(String str) {
        WritableNativeMap writableNativeMap;
        new WritableNativeMap();
        Cursor query = this.reactContext.getContentResolver().query(ContentUris.withAppendedId(CalendarContract.Events.CONTENT_URI, (long) Integer.parseInt(str)), new String[]{FieldType.FOREIGN_ID_FIELD_SUFFIX, "title", "description", "dtstart", "dtend", "allDay", "eventLocation", "rrule"}, "((deleted != 1))", (String[]) null, (String) null);
        if (query.getCount() > 0) {
            query.moveToFirst();
            writableNativeMap = serializeEvent(query);
        } else {
            writableNativeMap = null;
        }
        query.close();
        return writableNativeMap;
    }

    public WritableMap addEvent(String str, ReadableMap readableMap) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
        ContentResolver contentResolver = this.reactContext.getContentResolver();
        ContentValues contentValues = new ContentValues();
        WritableMap createMap = Arguments.createMap();
        contentValues.put("calendar_id", 1);
        if (str != null) {
            contentValues.put("title", str);
        }
        if (readableMap.hasKey("notes")) {
            contentValues.put("description", readableMap.getString("notes"));
        }
        if (readableMap.hasKey(PlaceFields.LOCATION)) {
            contentValues.put("eventLocation", readableMap.getString(PlaceFields.LOCATION));
        }
        if (readableMap.hasKey("startDate")) {
            Calendar instance = Calendar.getInstance();
            try {
                instance.setTime(simpleDateFormat.parse(readableMap.getString("startDate")));
                contentValues.put("dtstart", Long.valueOf(instance.getTimeInMillis()));
            } catch (ParseException e2) {
                e2.printStackTrace();
                throw e2;
            }
        }
        if (readableMap.hasKey("endDate")) {
            Calendar instance2 = Calendar.getInstance();
            try {
                instance2.setTime(simpleDateFormat.parse(readableMap.getString("endDate")));
                contentValues.put("dtend", Long.valueOf(instance2.getTimeInMillis()));
            } catch (ParseException e3) {
                e3.printStackTrace();
                throw e3;
            }
        }
        if (readableMap.hasKey("recurrence")) {
            String createRecurrenceRule = createRecurrenceRule(readableMap.getString("recurrence"));
            if (createRecurrenceRule != null) {
                contentValues.put("rrule", createRecurrenceRule);
            }
        }
        if (readableMap.hasKey("allDay")) {
            contentValues.put("allDay", Boolean.valueOf(readableMap.getBoolean("allDay")));
        }
        contentValues.put("eventTimezone", TimeZone.getDefault().getID());
        if (readableMap.hasKey("alarms")) {
            contentValues.put("hasAlarm", true);
        }
        if (readableMap.hasKey("id")) {
            contentResolver.update(ContentUris.withAppendedId(CalendarContract.Events.CONTENT_URI, (long) Integer.parseInt(readableMap.getString("id"))), contentValues, (String) null, (String[]) null);
            createMap.putInt("eventID", Integer.parseInt(readableMap.getString("id")));
        } else {
            int parseInt = Integer.parseInt(contentResolver.insert(CalendarContract.Events.CONTENT_URI, contentValues).getLastPathSegment());
            if (readableMap.hasKey("alarms")) {
                createRemindersForEvent(contentResolver, parseInt, readableMap.getArray("alarms"));
            }
            createMap.putInt("eventID", parseInt);
        }
        return createMap;
    }

    public boolean removeEvent(String str) {
        int i;
        try {
            i = this.reactContext.getContentResolver().delete(ContentUris.withAppendedId(CalendarContract.Events.CONTENT_URI, (long) Integer.parseInt(str)), (String) null, (String[]) null);
        } catch (Exception e2) {
            e2.printStackTrace();
            i = 0;
        }
        if (i > 0) {
            return true;
        }
        return false;
    }

    private void createRemindersForEvent(ContentResolver contentResolver, int i, ReadableArray readableArray) {
        for (int i2 = 0; i2 < readableArray.size(); i2++) {
            ReadableMap map = readableArray.getMap(i2);
            if (map.getType("date") == ReadableType.Number) {
                ContentValues contentValues = new ContentValues();
                contentValues.put("event_id", Integer.valueOf(i));
                contentValues.put("minutes", Integer.valueOf(-map.getInt("date")));
                contentValues.put("method", 1);
                contentResolver.insert(CalendarContract.Reminders.CONTENT_URI, contentValues);
            }
        }
    }

    private String createRecurrenceRule(String str) {
        if (str.equals("daily")) {
            return "FREQ=DAILY";
        }
        if (str.equals("weekly")) {
            return "FREQ=WEEKLY";
        }
        if (str.equals("monthly")) {
            return "FREQ=MONTHLY";
        }
        if (str.equals("yearly")) {
            return "FREQ=YEARLY";
        }
        return null;
    }

    public WritableNativeArray serializeEvents(Cursor cursor) {
        WritableNativeArray writableNativeArray = new WritableNativeArray();
        while (cursor.moveToNext()) {
            writableNativeArray.pushMap(serializeEvent(cursor));
        }
        cursor.close();
        return writableNativeArray;
    }

    public WritableNativeMap serializeEvent(Cursor cursor) {
        String str;
        String str2;
        WritableNativeMap writableNativeMap = new WritableNativeMap();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
        Calendar instance = Calendar.getInstance();
        Calendar instance2 = Calendar.getInstance();
        String str3 = "";
        if (cursor.getString(3) != null) {
            instance.setTimeInMillis(Long.parseLong(cursor.getString(3)));
            str = simpleDateFormat.format(instance.getTime());
        } else {
            str = str3;
        }
        if (cursor.getString(4) != null) {
            instance2.setTimeInMillis(Long.parseLong(cursor.getString(4)));
            str2 = simpleDateFormat.format(instance2.getTime());
        } else {
            str2 = str3;
        }
        boolean z = (cursor.getString(5) == null || Integer.parseInt(cursor.getString(5)) == 0) ? false : true;
        if (cursor.getString(7) != null) {
            str3 = cursor.getString(7).split(SimpleComparison.EQUAL_TO_OPERATION)[1].toLowerCase();
        }
        writableNativeMap.putString("id", cursor.getString(0));
        writableNativeMap.putString("title", cursor.getString(cursor.getColumnIndex("title")));
        writableNativeMap.putString("description", cursor.getString(2));
        writableNativeMap.putString("startDate", str);
        writableNativeMap.putString("endDate", str2);
        writableNativeMap.putBoolean("allDay", z);
        writableNativeMap.putString(PlaceFields.LOCATION, cursor.getString(6));
        writableNativeMap.putString("recurrence", str3);
        return writableNativeMap;
    }

    @ReactMethod
    public void getCalendarPermissions(Promise promise) {
        if (haveCalendarReadWritePermissions()) {
            promise.resolve("authorized");
        } else {
            promise.resolve("denied");
        }
    }

    @ReactMethod
    public void requestCalendarPermissions(Promise promise) {
        if (haveCalendarReadWritePermissions()) {
            promise.resolve("authorized");
        } else {
            requestCalendarReadWritePermission(promise);
        }
    }

    @ReactMethod
    public void saveEvent(String str, ReadableMap readableMap, Promise promise) {
        if (haveCalendarReadWritePermissions()) {
            try {
                promise.resolve(Integer.valueOf(addEvent(str, readableMap).getInt("eventID")));
            } catch (Exception e2) {
                promise.reject("add event error", e2.getMessage());
            }
        } else {
            promise.reject("add event error", "you don't have permissions to add an event to the users calendar");
        }
    }

    @ReactMethod
    public void findAllEvents(String str, String str2, Promise promise) {
        if (haveCalendarReadWritePermissions()) {
            try {
                promise.resolve(findEvents(str, str2));
            } catch (Exception e2) {
                promise.reject("find event error", e2.getMessage());
            }
        } else {
            promise.reject("find event error", "you don't have permissions to read an event from the users calendar");
        }
    }

    @ReactMethod
    public void findById(String str, Promise promise) {
        if (haveCalendarReadWritePermissions()) {
            try {
                promise.resolve(findEventsById(str));
            } catch (Exception e2) {
                promise.reject("find event error", e2.getMessage());
            }
        } else {
            promise.reject("find event error", "you don't have permissions to read an event from the users calendar");
        }
    }

    @ReactMethod
    public void removeEvent(String str, Promise promise) {
        if (haveCalendarReadWritePermissions()) {
            try {
                promise.resolve(Boolean.valueOf(removeEvent(str)));
            } catch (Exception e2) {
                promise.reject("error removing event", e2.getMessage());
            }
        } else {
            promise.reject("remove event error", "you don't have permissions to remove an event from the users calendar");
        }
    }

    @ReactMethod
    public void openEventInCalendar(int i) {
        Intent data = new Intent("android.intent.action.VIEW").addFlags(SigType.TLS).setData(ContentUris.withAppendedId(CalendarContract.Events.CONTENT_URI, (long) i));
        if (data.resolveActivity(this.reactContext.getPackageManager()) != null) {
            this.reactContext.startActivity(data);
        }
    }

    @ReactMethod
    public void uriForCalendar(Promise promise) {
        promise.resolve(CalendarContract.Events.CONTENT_URI.toString());
    }
}
