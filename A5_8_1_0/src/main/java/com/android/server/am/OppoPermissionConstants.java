package com.android.server.am;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OppoPermissionConstants {
    public static final List<String> CALENDAR_PERMISSIONS = new ArrayList();
    public static final List<String> CAMERA_PERMISSIONS = new ArrayList();
    public static final List<String> CONTACTS_PERMISSIONS = new ArrayList();
    public static final List<String> LOCATION_PERMISSIONS = new ArrayList();
    public static final Map<String, List<String>> MAP_DANGEROUS_PERMISSON_GROUP = new HashMap();
    public static final Map<String, String> MAP_OPPO_DEFINED_TO_ORIGINAL = new HashMap();
    public static final long MASK_BIT_FIRST = 1;
    public static final List<String> MICROPHONE_PERMISSIONS = new ArrayList();
    public static final int PERMISSION_ACCEPT = 1;
    public static final String PERMISSION_ACCESS = "android.permission.ACCESS_FINE_LOCATION";
    public static final String PERMISSION_ADD_VOICEMAIL = "com.android.voicemail.permission.ADD_VOICEMAIL";
    public static final String PERMISSION_BLUETOOTH = "android.permission.BLUETOOTH_ADMIN";
    public static final String PERMISSION_CALL_PHONE = "android.permission.CALL_PHONE";
    public static final String PERMISSION_CAMERA = "android.permission.CAMERA";
    public static final String PERMISSION_DELETE_CALENDAR = "android.permission.WRITE_CALENDAR_DELETE";
    public static final String PERMISSION_DELETE_CALL = "android.permission.WRITE_CALL_LOG_DELETE";
    public static final String PERMISSION_DELETE_CONTACTS = "android.permission.WRITE_CONTACTS_DELETE";
    public static final String PERMISSION_DELETE_MMS = "android.permission.WRITE_MMS_DELETE";
    public static final String PERMISSION_DELETE_SMS = "android.permission.WRITE_SMS_DELETE";
    public static final String PERMISSION_EXTERNAL_STORAGE = "android.permission.WR_EXTERNAL_STORAGE";
    public static final String PERMISSION_GET_ACCOUNTS = "android.permission.GET_ACCOUNTS";
    public static final String PERMISSION_GPRS = "android.permission.CHANGE_NETWORK_STATE";
    public static final String PERMISSION_NFC = "android.permission.NFC";
    public static final int PERMISSION_NONE = 3;
    public static final String PERMISSION_PROCESS_OUTGOING_CALLS = "android.permission.PROCESS_OUTGOING_CALLS";
    public static final int PERMISSION_PROMPT = 0;
    public static final String PERMISSION_READ_CALENDAR = "android.permission.READ_CALENDAR";
    public static final String PERMISSION_READ_CALL_LOG = "android.permission.READ_CALL_LOG";
    public static final String PERMISSION_READ_CONTACTS = "android.permission.READ_CONTACTS";
    public static final String PERMISSION_READ_HISTORY_BOOKMARKS = "com.android.browser.permission.READ_HISTORY_BOOKMARKS";
    public static final String PERMISSION_READ_MMS = "android.permission.READ_MMS";
    public static final String PERMISSION_READ_PHONE_STATE = "android.permission.READ_PHONE_STATE";
    public static final String PERMISSION_READ_SMS = "android.permission.READ_SMS";
    public static final String PERMISSION_RECEIVE_MMS = "android.permission.RECEIVE_MMS";
    public static final String PERMISSION_RECEIVE_SMS = "android.permission.RECEIVE_SMS";
    public static final String PERMISSION_RECEIVE_WAP_PUSH = "android.permission.RECEIVE_WAP_PUSH";
    public static final String PERMISSION_RECORD_AUDIO = "android.permission.RECORD_AUDIO";
    public static final int PERMISSION_REJECT = 2;
    public static final String PERMISSION_SEND_MMS = "android.permission.SEND_MMS";
    public static final String PERMISSION_SEND_MMS_INTERNET = "android.permission.INTERNET";
    public static final String PERMISSION_SEND_SMS = "android.permission.SEND_SMS";
    public static final String PERMISSION_SENSORS = "android.permission.BODY_SENSORS";
    public static final String PERMISSION_USE_SIP = "android.permission.USE_SIP";
    public static final String PERMISSION_WIFI = "android.permission.CHANGE_WIFI_STATE";
    public static final String PERMISSION_WRITE_CALENDAR = "android.permission.WRITE_CALENDAR";
    public static final String PERMISSION_WRITE_CALL_LOG = "android.permission.WRITE_CALL_LOG";
    public static final String PERMISSION_WRITE_CONTACTS = "android.permission.WRITE_CONTACTS";
    public static final String PERMISSION_WRITE_MMS = "android.permission.WRITE_MMS";
    public static final String PERMISSION_WRITE_SMS = "android.permission.WRITE_SMS";
    public static final List<String> PHONE_PERMISSIONS = new ArrayList();
    public static final List<String> SENSORS_PERMISSIONS = new ArrayList();
    public static final List<String> SMS_PERMISSIONS = new ArrayList();
    public static final List<String> STORAGE_PERMISSIONS = new ArrayList();

    static {
        PHONE_PERMISSIONS.add(PERMISSION_CALL_PHONE);
        PHONE_PERMISSIONS.add(PERMISSION_READ_CALL_LOG);
        PHONE_PERMISSIONS.add(PERMISSION_WRITE_CALL_LOG);
        PHONE_PERMISSIONS.add(PERMISSION_DELETE_CALL);
        PHONE_PERMISSIONS.add(PERMISSION_GET_ACCOUNTS);
        PHONE_PERMISSIONS.add(PERMISSION_READ_PHONE_STATE);
        PHONE_PERMISSIONS.add(PERMISSION_ADD_VOICEMAIL);
        PHONE_PERMISSIONS.add(PERMISSION_USE_SIP);
        PHONE_PERMISSIONS.add(PERMISSION_PROCESS_OUTGOING_CALLS);
        CONTACTS_PERMISSIONS.add(PERMISSION_READ_CONTACTS);
        CONTACTS_PERMISSIONS.add(PERMISSION_WRITE_CONTACTS);
        CONTACTS_PERMISSIONS.add(PERMISSION_DELETE_CONTACTS);
        LOCATION_PERMISSIONS.add(PERMISSION_ACCESS);
        CALENDAR_PERMISSIONS.add(PERMISSION_READ_CALENDAR);
        CALENDAR_PERMISSIONS.add(PERMISSION_WRITE_CALENDAR);
        CALENDAR_PERMISSIONS.add(PERMISSION_DELETE_CALENDAR);
        SMS_PERMISSIONS.add(PERMISSION_SEND_SMS);
        SMS_PERMISSIONS.add(PERMISSION_SEND_MMS);
        SMS_PERMISSIONS.add(PERMISSION_SEND_MMS_INTERNET);
        SMS_PERMISSIONS.add(PERMISSION_WRITE_SMS);
        SMS_PERMISSIONS.add(PERMISSION_WRITE_MMS);
        SMS_PERMISSIONS.add(PERMISSION_READ_SMS);
        SMS_PERMISSIONS.add(PERMISSION_READ_MMS);
        SMS_PERMISSIONS.add(PERMISSION_RECEIVE_SMS);
        SMS_PERMISSIONS.add(PERMISSION_RECEIVE_MMS);
        SMS_PERMISSIONS.add(PERMISSION_RECEIVE_WAP_PUSH);
        SMS_PERMISSIONS.add(PERMISSION_DELETE_SMS);
        SMS_PERMISSIONS.add(PERMISSION_DELETE_MMS);
        MICROPHONE_PERMISSIONS.add(PERMISSION_RECORD_AUDIO);
        CAMERA_PERMISSIONS.add(PERMISSION_CAMERA);
        SENSORS_PERMISSIONS.add(PERMISSION_SENSORS);
        STORAGE_PERMISSIONS.add(PERMISSION_EXTERNAL_STORAGE);
        MAP_DANGEROUS_PERMISSON_GROUP.put("android.permission-group.CALENDAR", CALENDAR_PERMISSIONS);
        MAP_DANGEROUS_PERMISSON_GROUP.put("android.permission-group.CAMERA", CAMERA_PERMISSIONS);
        MAP_DANGEROUS_PERMISSON_GROUP.put("android.permission-group.CONTACTS", CONTACTS_PERMISSIONS);
        MAP_DANGEROUS_PERMISSON_GROUP.put("android.permission-group.LOCATION", LOCATION_PERMISSIONS);
        MAP_DANGEROUS_PERMISSON_GROUP.put("android.permission-group.MICROPHONE", MICROPHONE_PERMISSIONS);
        MAP_DANGEROUS_PERMISSON_GROUP.put("android.permission-group.PHONE", PHONE_PERMISSIONS);
        MAP_DANGEROUS_PERMISSON_GROUP.put("android.permission-group.SENSORS", SENSORS_PERMISSIONS);
        MAP_DANGEROUS_PERMISSON_GROUP.put("android.permission-group.SMS", SMS_PERMISSIONS);
        MAP_DANGEROUS_PERMISSON_GROUP.put("android.permission-group.STORAGE", STORAGE_PERMISSIONS);
        MAP_OPPO_DEFINED_TO_ORIGINAL.put(PERMISSION_SEND_MMS, PERMISSION_SEND_SMS);
        MAP_OPPO_DEFINED_TO_ORIGINAL.put(PERMISSION_SEND_MMS_INTERNET, PERMISSION_SEND_SMS);
        MAP_OPPO_DEFINED_TO_ORIGINAL.put(PERMISSION_WRITE_MMS, PERMISSION_SEND_SMS);
        MAP_OPPO_DEFINED_TO_ORIGINAL.put(PERMISSION_READ_MMS, PERMISSION_SEND_SMS);
        MAP_OPPO_DEFINED_TO_ORIGINAL.put(PERMISSION_EXTERNAL_STORAGE, "android.permission.READ_EXTERNAL_STORAGE");
        MAP_OPPO_DEFINED_TO_ORIGINAL.put(PERMISSION_DELETE_CALL, PERMISSION_WRITE_CALL_LOG);
        MAP_OPPO_DEFINED_TO_ORIGINAL.put(PERMISSION_DELETE_CONTACTS, PERMISSION_WRITE_CONTACTS);
        MAP_OPPO_DEFINED_TO_ORIGINAL.put(PERMISSION_DELETE_SMS, PERMISSION_WRITE_SMS);
        MAP_OPPO_DEFINED_TO_ORIGINAL.put(PERMISSION_DELETE_MMS, PERMISSION_SEND_SMS);
        MAP_OPPO_DEFINED_TO_ORIGINAL.put(PERMISSION_DELETE_CALENDAR, PERMISSION_WRITE_CALENDAR);
    }
}