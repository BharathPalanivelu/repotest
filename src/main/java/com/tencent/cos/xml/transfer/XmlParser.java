package com.tencent.cos.xml.transfer;

import android.util.Xml;
import com.appsflyer.share.Constants;
import com.tencent.cos.xml.model.tag.AccessControlPolicy;
import com.tencent.cos.xml.model.tag.CORSConfiguration;
import com.tencent.cos.xml.model.tag.CopyObject;
import com.tencent.cos.xml.model.tag.CopyPart;
import com.tencent.cos.xml.model.tag.DeleteResult;
import com.tencent.cos.xml.model.tag.LifecycleConfiguration;
import com.tencent.cos.xml.model.tag.ListAllMyBuckets;
import com.tencent.cos.xml.model.tag.ListBucket;
import com.tencent.cos.xml.model.tag.ListBucketVersions;
import com.tencent.cos.xml.model.tag.ListMultipartUploads;
import com.tencent.cos.xml.model.tag.LocationConstraint;
import com.tencent.cos.xml.model.tag.ReplicationConfiguration;
import com.tencent.cos.xml.model.tag.VersioningConfiguration;
import com.tencent.qcloud.core.http.HttpConstants;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class XmlParser extends XmlSlimParser {
    public static void parseListAllMyBucketsResult(InputStream inputStream, ListAllMyBuckets listAllMyBuckets) throws XmlPullParserException, IOException {
        XmlPullParser newPullParser = Xml.newPullParser();
        newPullParser.setInput(inputStream, "UTF-8");
        ListAllMyBuckets.Bucket bucket = null;
        for (int eventType = newPullParser.getEventType(); eventType != 1; eventType = newPullParser.next()) {
            if (eventType != 0) {
                if (eventType == 2) {
                    String name = newPullParser.getName();
                    if (name.equalsIgnoreCase("Owner")) {
                        listAllMyBuckets.owner = new ListAllMyBuckets.Owner();
                    } else if (name.equalsIgnoreCase("ID")) {
                        newPullParser.next();
                        listAllMyBuckets.owner.id = newPullParser.getText();
                    } else if (name.equalsIgnoreCase("DisplayName")) {
                        newPullParser.next();
                        listAllMyBuckets.owner.disPlayName = newPullParser.getText();
                    } else if (name.equalsIgnoreCase("Buckets")) {
                        listAllMyBuckets.buckets = new ArrayList();
                    } else if (name.equalsIgnoreCase("Bucket")) {
                        bucket = new ListAllMyBuckets.Bucket();
                    } else if (name.equalsIgnoreCase("Name")) {
                        newPullParser.next();
                        bucket.name = newPullParser.getText();
                    } else if (name.equalsIgnoreCase(Constants.HTTP_REDIRECT_URL_HEADER_FIELD)) {
                        newPullParser.next();
                        bucket.location = newPullParser.getText();
                    } else if (name.equalsIgnoreCase("CreationDate")) {
                        newPullParser.next();
                        bucket.createDate = newPullParser.getText();
                    }
                } else if (eventType == 3 && newPullParser.getName().equalsIgnoreCase("Bucket")) {
                    listAllMyBuckets.buckets.add(bucket);
                    bucket = null;
                }
            }
        }
    }

    public static void parseListBucketResult(InputStream inputStream, ListBucket listBucket) throws XmlPullParserException, IOException {
        XmlPullParser newPullParser = Xml.newPullParser();
        newPullParser.setInput(inputStream, "UTF-8");
        listBucket.contentsList = new ArrayList();
        listBucket.commonPrefixesList = new ArrayList();
        ListBucket.Contents contents = null;
        ListBucket.Owner owner = null;
        ListBucket.CommonPrefixes commonPrefixes = null;
        for (int eventType = newPullParser.getEventType(); eventType != 1; eventType = newPullParser.next()) {
            if (eventType == 2) {
                String name = newPullParser.getName();
                if (name.equalsIgnoreCase("Name")) {
                    newPullParser.next();
                    listBucket.name = newPullParser.getText();
                } else if (name.equalsIgnoreCase("Encoding-Type")) {
                    newPullParser.next();
                    listBucket.encodingType = newPullParser.getText();
                } else if (name.equalsIgnoreCase("Marker")) {
                    newPullParser.next();
                    listBucket.marker = newPullParser.getText();
                } else if (name.equalsIgnoreCase("MaxKeys")) {
                    newPullParser.next();
                    listBucket.maxKeys = Integer.parseInt(newPullParser.getText());
                } else if (name.equalsIgnoreCase("Delimiter")) {
                    newPullParser.next();
                    listBucket.delimiter = newPullParser.getText();
                } else if (name.equalsIgnoreCase("NextMarker")) {
                    newPullParser.next();
                    listBucket.nextMarker = newPullParser.getText();
                } else if (name.equalsIgnoreCase("IsTruncated")) {
                    newPullParser.next();
                    listBucket.isTruncated = Boolean.parseBoolean(newPullParser.getText());
                } else if (name.equalsIgnoreCase("Prefix")) {
                    newPullParser.next();
                    if (commonPrefixes == null) {
                        listBucket.prefix = newPullParser.getText();
                    } else {
                        commonPrefixes.prefix = newPullParser.getText();
                    }
                } else if (name.equalsIgnoreCase("Contents")) {
                    contents = new ListBucket.Contents();
                } else if (name.equalsIgnoreCase("Key")) {
                    newPullParser.next();
                    contents.key = newPullParser.getText();
                } else if (name.equalsIgnoreCase("LastModified")) {
                    newPullParser.next();
                    contents.lastModified = newPullParser.getText();
                } else if (name.equalsIgnoreCase("ETag")) {
                    newPullParser.next();
                    contents.eTag = newPullParser.getText();
                } else if (name.equalsIgnoreCase("Size")) {
                    newPullParser.next();
                    contents.size = Long.parseLong(newPullParser.getText());
                } else if (name.equalsIgnoreCase("StorageClass")) {
                    newPullParser.next();
                    contents.storageClass = newPullParser.getText();
                } else if (name.equalsIgnoreCase("Owner")) {
                    owner = new ListBucket.Owner();
                } else if (name.equalsIgnoreCase("ID")) {
                    newPullParser.next();
                    owner.id = newPullParser.getText();
                } else if (name.equalsIgnoreCase("CommonPrefixes")) {
                    commonPrefixes = new ListBucket.CommonPrefixes();
                }
            } else if (eventType == 3) {
                String name2 = newPullParser.getName();
                if (name2.equalsIgnoreCase("Contents")) {
                    listBucket.contentsList.add(contents);
                    contents = null;
                } else if (name2.equalsIgnoreCase("Owner")) {
                    contents.owner = owner;
                    owner = null;
                } else if (name2.equalsIgnoreCase("CommonPrefixes")) {
                    listBucket.commonPrefixesList.add(commonPrefixes);
                    commonPrefixes = null;
                }
            }
        }
    }

    public static void parseAccessControlPolicy(InputStream inputStream, AccessControlPolicy accessControlPolicy) throws XmlPullParserException, IOException {
        XmlPullParser newPullParser = Xml.newPullParser();
        newPullParser.setInput(inputStream, "UTF-8");
        accessControlPolicy.accessControlList = new AccessControlPolicy.AccessControlList();
        accessControlPolicy.accessControlList.grants = new ArrayList();
        AccessControlPolicy.Owner owner = null;
        AccessControlPolicy.Grant grant = null;
        AccessControlPolicy.Grantee grantee = null;
        for (int eventType = newPullParser.getEventType(); eventType != 1; eventType = newPullParser.next()) {
            if (eventType == 2) {
                String name = newPullParser.getName();
                if (name.equalsIgnoreCase("Owner")) {
                    owner = new AccessControlPolicy.Owner();
                } else if (name.equalsIgnoreCase("ID")) {
                    newPullParser.next();
                    if (owner != null) {
                        owner.id = newPullParser.getText();
                    } else if (grantee != null) {
                        grantee.id = newPullParser.getText();
                    }
                } else if (name.equalsIgnoreCase("DisplayName")) {
                    newPullParser.next();
                    if (owner != null) {
                        owner.displayName = newPullParser.getText();
                    } else if (grantee != null) {
                        grantee.displayName = newPullParser.getText();
                    }
                } else if (name.equalsIgnoreCase("Grant")) {
                    grant = new AccessControlPolicy.Grant();
                } else if (name.equalsIgnoreCase("Grantee")) {
                    grantee = new AccessControlPolicy.Grantee();
                } else if (name.equalsIgnoreCase("Permission")) {
                    newPullParser.next();
                    grant.permission = newPullParser.getText();
                }
            } else if (eventType == 3) {
                String name2 = newPullParser.getName();
                if (name2.equalsIgnoreCase("Owner")) {
                    accessControlPolicy.owner = owner;
                    owner = null;
                } else if (name2.equalsIgnoreCase("Grant")) {
                    accessControlPolicy.accessControlList.grants.add(grant);
                    grant = null;
                } else if (name2.equalsIgnoreCase("Grantee")) {
                    grant.grantee = grantee;
                    grantee = null;
                }
            }
        }
    }

    public static void parseCORSConfiguration(InputStream inputStream, CORSConfiguration cORSConfiguration) throws XmlPullParserException, IOException {
        XmlPullParser newPullParser = Xml.newPullParser();
        newPullParser.setInput(inputStream, "UTF-8");
        cORSConfiguration.corsRules = new ArrayList();
        CORSConfiguration.CORSRule cORSRule = null;
        for (int eventType = newPullParser.getEventType(); eventType != 1; eventType = newPullParser.next()) {
            if (eventType == 2) {
                String name = newPullParser.getName();
                if (name.equalsIgnoreCase("CORSRule")) {
                    cORSRule = new CORSConfiguration.CORSRule();
                } else if (name.equalsIgnoreCase("ID")) {
                    newPullParser.next();
                    cORSRule.id = newPullParser.getText();
                } else if (name.equalsIgnoreCase("AllowedOrigin")) {
                    newPullParser.next();
                    cORSRule.allowedOrigin = newPullParser.getText();
                } else if (name.equalsIgnoreCase("AllowedMethod")) {
                    newPullParser.next();
                    if (cORSRule.allowedMethod == null) {
                        cORSRule.allowedMethod = new ArrayList();
                    }
                    cORSRule.allowedMethod.add(newPullParser.getText());
                } else if (name.equalsIgnoreCase("AllowedHeader")) {
                    newPullParser.next();
                    if (cORSRule.allowedHeader == null) {
                        cORSRule.allowedHeader = new ArrayList();
                    }
                    cORSRule.allowedHeader.add(newPullParser.getText());
                } else if (name.equalsIgnoreCase("ExposeHeader")) {
                    newPullParser.next();
                    if (cORSRule.exposeHeader == null) {
                        cORSRule.exposeHeader = new ArrayList();
                    }
                    cORSRule.exposeHeader.add(newPullParser.getText());
                } else if (name.equalsIgnoreCase("MaxAgeSeconds")) {
                    newPullParser.next();
                    cORSRule.maxAgeSeconds = Integer.parseInt(newPullParser.getText());
                }
            } else if (eventType == 3 && newPullParser.getName().equalsIgnoreCase("CORSRule")) {
                cORSConfiguration.corsRules.add(cORSRule);
                cORSRule = null;
            }
        }
    }

    public static void parseReplicationConfiguration(InputStream inputStream, ReplicationConfiguration replicationConfiguration) throws XmlPullParserException, IOException {
        XmlPullParser newPullParser = Xml.newPullParser();
        newPullParser.setInput(inputStream, "UTF-8");
        replicationConfiguration.rules = new ArrayList();
        ReplicationConfiguration.Rule rule = null;
        ReplicationConfiguration.Destination destination = null;
        for (int eventType = newPullParser.getEventType(); eventType != 1; eventType = newPullParser.next()) {
            if (eventType == 2) {
                String name = newPullParser.getName();
                if (name.equalsIgnoreCase("Role")) {
                    newPullParser.next();
                    replicationConfiguration.role = newPullParser.getText();
                } else if (name.equalsIgnoreCase("Rule")) {
                    rule = new ReplicationConfiguration.Rule();
                } else if (name.equalsIgnoreCase("Status")) {
                    newPullParser.next();
                    rule.status = newPullParser.getText();
                } else if (name.equalsIgnoreCase("ID")) {
                    newPullParser.next();
                    rule.id = newPullParser.getText();
                } else if (name.equalsIgnoreCase("Prefix")) {
                    newPullParser.next();
                    rule.prefix = newPullParser.getText();
                } else if (name.equalsIgnoreCase("Destination")) {
                    destination = new ReplicationConfiguration.Destination();
                } else if (name.equalsIgnoreCase("Bucket")) {
                    newPullParser.next();
                    destination.bucket = newPullParser.getText();
                } else if (name.equalsIgnoreCase("StorageClass")) {
                    newPullParser.next();
                    destination.storageClass = newPullParser.getText();
                }
            } else if (eventType == 3) {
                String name2 = newPullParser.getName();
                if (name2.equalsIgnoreCase("Rule")) {
                    replicationConfiguration.rules.add(rule);
                    rule = null;
                } else if (name2.equalsIgnoreCase("Destination")) {
                    rule.destination = destination;
                    destination = null;
                }
            }
        }
    }

    public static void parseVersioningConfiguration(InputStream inputStream, VersioningConfiguration versioningConfiguration) throws XmlPullParserException, IOException {
        XmlPullParser newPullParser = Xml.newPullParser();
        newPullParser.setInput(inputStream, "UTF-8");
        for (int eventType = newPullParser.getEventType(); eventType != 1; eventType = newPullParser.next()) {
            if (eventType == 2 && newPullParser.getName().equalsIgnoreCase("Status")) {
                newPullParser.next();
                versioningConfiguration.status = newPullParser.getText();
            }
        }
    }

    public static void parseLifecycleConfiguration(InputStream inputStream, LifecycleConfiguration lifecycleConfiguration) throws XmlPullParserException, IOException {
        LifecycleConfiguration.AbortIncompleteMultiUpload abortIncompleteMultiUpload;
        LifecycleConfiguration lifecycleConfiguration2 = lifecycleConfiguration;
        XmlPullParser newPullParser = Xml.newPullParser();
        newPullParser.setInput(inputStream, "UTF-8");
        int eventType = newPullParser.getEventType();
        lifecycleConfiguration2.rules = new ArrayList();
        LifecycleConfiguration.Rule rule = null;
        LifecycleConfiguration.Filter filter = null;
        LifecycleConfiguration.Transition transition = null;
        LifecycleConfiguration.NoncurrentVersionExpiration noncurrentVersionExpiration = null;
        LifecycleConfiguration.NoncurrentVersionTransition noncurrentVersionTransition = null;
        LifecycleConfiguration.Expiration expiration = null;
        LifecycleConfiguration.AbortIncompleteMultiUpload abortIncompleteMultiUpload2 = null;
        while (eventType != 1) {
            LifecycleConfiguration.AbortIncompleteMultiUpload abortIncompleteMultiUpload3 = abortIncompleteMultiUpload2;
            String str = "AbortIncompleteMultipartUpload";
            if (eventType != 2) {
                if (eventType == 3) {
                    String name = newPullParser.getName();
                    if (name.equalsIgnoreCase("Rule")) {
                        lifecycleConfiguration2.rules.add(rule);
                        abortIncompleteMultiUpload2 = abortIncompleteMultiUpload3;
                        rule = null;
                    } else if (name.equalsIgnoreCase("Filter")) {
                        rule.filter = filter;
                        abortIncompleteMultiUpload2 = abortIncompleteMultiUpload3;
                        filter = null;
                    } else if (name.equalsIgnoreCase("Transition")) {
                        rule.transition = transition;
                        abortIncompleteMultiUpload2 = abortIncompleteMultiUpload3;
                        transition = null;
                    } else if (name.equalsIgnoreCase("NoncurrentVersionExpiration")) {
                        rule.noncurrentVersionExpiration = noncurrentVersionExpiration;
                        abortIncompleteMultiUpload2 = abortIncompleteMultiUpload3;
                        noncurrentVersionExpiration = null;
                    } else if (name.equalsIgnoreCase("NoncurrentVersionTransition")) {
                        rule.noncurrentVersionTransition = noncurrentVersionTransition;
                        abortIncompleteMultiUpload2 = abortIncompleteMultiUpload3;
                        noncurrentVersionTransition = null;
                    } else if (name.equalsIgnoreCase("Expiration")) {
                        rule.expiration = expiration;
                        abortIncompleteMultiUpload2 = abortIncompleteMultiUpload3;
                        expiration = null;
                    } else if (name.equalsIgnoreCase(str)) {
                        rule.abortIncompleteMultiUpload = abortIncompleteMultiUpload3;
                        abortIncompleteMultiUpload2 = null;
                    }
                    eventType = newPullParser.next();
                    lifecycleConfiguration2 = lifecycleConfiguration;
                }
                abortIncompleteMultiUpload = abortIncompleteMultiUpload3;
            } else {
                abortIncompleteMultiUpload = abortIncompleteMultiUpload3;
                String str2 = str;
                String name2 = newPullParser.getName();
                if (name2.equalsIgnoreCase("Rule")) {
                    rule = new LifecycleConfiguration.Rule();
                } else if (name2.equalsIgnoreCase("ID")) {
                    newPullParser.next();
                    rule.id = newPullParser.getText();
                } else if (name2.equalsIgnoreCase("Filter")) {
                    filter = new LifecycleConfiguration.Filter();
                } else if (name2.equalsIgnoreCase("Prefix")) {
                    newPullParser.next();
                    filter.prefix = newPullParser.getText();
                } else if (name2.equalsIgnoreCase("Status")) {
                    newPullParser.next();
                    rule.status = newPullParser.getText();
                } else if (name2.equalsIgnoreCase("Transition")) {
                    transition = new LifecycleConfiguration.Transition();
                } else if (name2.equalsIgnoreCase("Expiration")) {
                    expiration = new LifecycleConfiguration.Expiration();
                } else if (name2.equalsIgnoreCase("Days")) {
                    newPullParser.next();
                    if (transition != null) {
                        transition.days = Integer.parseInt(newPullParser.getText());
                    } else if (rule.expiration != null) {
                        expiration.days = Integer.parseInt(newPullParser.getText());
                    }
                } else if (name2.equalsIgnoreCase(HttpConstants.Header.DATE)) {
                    newPullParser.next();
                    if (transition != null) {
                        transition.date = newPullParser.getText();
                    } else if (expiration != null) {
                        expiration.date = newPullParser.getText();
                    }
                } else if (name2.equalsIgnoreCase("ExpiredObjectDeleteMarker")) {
                    newPullParser.next();
                    expiration.expiredObjectDeleteMarker = newPullParser.getText();
                } else if (name2.equalsIgnoreCase(str2)) {
                    abortIncompleteMultiUpload2 = new LifecycleConfiguration.AbortIncompleteMultiUpload();
                    eventType = newPullParser.next();
                    lifecycleConfiguration2 = lifecycleConfiguration;
                } else if (name2.equalsIgnoreCase("DaysAfterInitiation")) {
                    newPullParser.next();
                    abortIncompleteMultiUpload.daysAfterInitiation = Integer.parseInt(newPullParser.getText());
                } else if (name2.equalsIgnoreCase("NoncurrentVersionExpiration")) {
                    noncurrentVersionExpiration = new LifecycleConfiguration.NoncurrentVersionExpiration();
                } else if (name2.equalsIgnoreCase("NoncurrentVersionTransition")) {
                    noncurrentVersionTransition = new LifecycleConfiguration.NoncurrentVersionTransition();
                } else if (name2.equalsIgnoreCase("NoncurrentDays")) {
                    newPullParser.next();
                    if (noncurrentVersionExpiration != null) {
                        noncurrentVersionExpiration.noncurrentDays = Integer.parseInt(newPullParser.getText());
                    } else if (noncurrentVersionTransition != null) {
                        noncurrentVersionTransition.noncurrentDays = Integer.parseInt(newPullParser.getText());
                    }
                } else if (name2.equalsIgnoreCase("StorageClass")) {
                    newPullParser.next();
                    if (transition != null) {
                        transition.storageClass = newPullParser.getText();
                    } else if (noncurrentVersionTransition != null) {
                        noncurrentVersionTransition.storageClass = newPullParser.getText();
                    }
                }
            }
            abortIncompleteMultiUpload2 = abortIncompleteMultiUpload;
            eventType = newPullParser.next();
            lifecycleConfiguration2 = lifecycleConfiguration;
        }
    }

    public static void parseLocationConstraint(InputStream inputStream, LocationConstraint locationConstraint) throws XmlPullParserException, IOException {
        XmlPullParser newPullParser = Xml.newPullParser();
        newPullParser.setInput(inputStream, "UTF-8");
        for (int eventType = newPullParser.getEventType(); eventType != 1; eventType = newPullParser.next()) {
            if (eventType == 2 && newPullParser.getName().equalsIgnoreCase("LocationConstraint")) {
                newPullParser.next();
                locationConstraint.location = newPullParser.getText();
            }
        }
    }

    public static void parseListMultipartUploadsResult(InputStream inputStream, ListMultipartUploads listMultipartUploads) throws XmlPullParserException, IOException {
        XmlPullParser newPullParser = Xml.newPullParser();
        newPullParser.setInput(inputStream, "UTF-8");
        listMultipartUploads.uploads = new ArrayList();
        listMultipartUploads.commonPrefixes = new ArrayList();
        ListMultipartUploads.Upload upload = null;
        ListMultipartUploads.CommonPrefixes commonPrefixes = null;
        ListMultipartUploads.Owner owner = null;
        ListMultipartUploads.Initiator initiator = null;
        for (int eventType = newPullParser.getEventType(); eventType != 1; eventType = newPullParser.next()) {
            if (eventType == 2) {
                String name = newPullParser.getName();
                if (name.equalsIgnoreCase("Bucket")) {
                    newPullParser.next();
                    listMultipartUploads.bucket = newPullParser.getText();
                } else if (name.equalsIgnoreCase("Encoding-Type")) {
                    newPullParser.next();
                    listMultipartUploads.encodingType = newPullParser.getText();
                } else if (name.equalsIgnoreCase("KeyMarker")) {
                    newPullParser.next();
                    listMultipartUploads.keyMarker = newPullParser.getText();
                } else if (name.equalsIgnoreCase("UploadIdMarker")) {
                    newPullParser.next();
                    listMultipartUploads.uploadIdMarker = newPullParser.getText();
                } else if (name.equalsIgnoreCase("NextKeyMarker")) {
                    newPullParser.next();
                    listMultipartUploads.nextKeyMarker = newPullParser.getText();
                } else if (name.equalsIgnoreCase("NextUploadIdMarker")) {
                    newPullParser.next();
                    listMultipartUploads.nextUploadIdMarker = newPullParser.getText();
                } else if (name.equalsIgnoreCase("MaxUploads")) {
                    newPullParser.next();
                    listMultipartUploads.maxUploads = newPullParser.getText();
                } else if (name.equalsIgnoreCase("IsTruncated")) {
                    newPullParser.next();
                    listMultipartUploads.isTruncated = Boolean.parseBoolean(newPullParser.getText());
                } else if (name.equalsIgnoreCase("Prefix")) {
                    newPullParser.next();
                    if (commonPrefixes == null) {
                        listMultipartUploads.prefix = newPullParser.getText();
                    } else {
                        commonPrefixes.prefix = newPullParser.getText();
                    }
                } else if (name.equalsIgnoreCase("Delimiter")) {
                    newPullParser.next();
                    listMultipartUploads.delimiter = newPullParser.getText();
                } else if (name.equalsIgnoreCase("Upload")) {
                    upload = new ListMultipartUploads.Upload();
                } else if (name.equalsIgnoreCase("Key")) {
                    newPullParser.next();
                    upload.key = newPullParser.getText();
                } else if (name.equalsIgnoreCase("UploadID")) {
                    newPullParser.next();
                    upload.uploadID = newPullParser.getText();
                } else if (name.equalsIgnoreCase("StorageClass")) {
                    newPullParser.next();
                    upload.storageClass = newPullParser.getText();
                } else if (name.equalsIgnoreCase("Initiator")) {
                    initiator = new ListMultipartUploads.Initiator();
                } else if (name.equalsIgnoreCase("UIN")) {
                    newPullParser.next();
                    if (initiator != null) {
                        initiator.uin = newPullParser.getText();
                    }
                } else if (name.equalsIgnoreCase("Owner")) {
                    owner = new ListMultipartUploads.Owner();
                } else if (name.equalsIgnoreCase("UID")) {
                    newPullParser.next();
                    if (owner != null) {
                        owner.uid = newPullParser.getText();
                    }
                } else if (name.equalsIgnoreCase("ID")) {
                    newPullParser.next();
                    if (owner != null) {
                        owner.id = newPullParser.getText();
                    } else if (initiator != null) {
                        initiator.id = newPullParser.getText();
                    }
                } else if (name.equalsIgnoreCase("DisplayName")) {
                    newPullParser.next();
                    if (owner != null) {
                        owner.displayName = newPullParser.getText();
                    } else if (initiator != null) {
                        initiator.displayName = newPullParser.getText();
                    }
                } else if (name.equalsIgnoreCase("Initiated")) {
                    newPullParser.next();
                    upload.initiated = newPullParser.getText();
                } else if (name.equalsIgnoreCase("CommonPrefixs")) {
                    commonPrefixes = new ListMultipartUploads.CommonPrefixes();
                }
            } else if (eventType == 3) {
                String name2 = newPullParser.getName();
                if (name2.equalsIgnoreCase("Upload")) {
                    listMultipartUploads.uploads.add(upload);
                    upload = null;
                } else if (name2.equalsIgnoreCase("CommonPrefixs")) {
                    listMultipartUploads.commonPrefixes.add(commonPrefixes);
                    commonPrefixes = null;
                } else if (name2.equalsIgnoreCase("Owner")) {
                    upload.owner = owner;
                    owner = null;
                } else if (name2.equalsIgnoreCase("Initiator")) {
                    upload.initiator = initiator;
                    initiator = null;
                }
            }
        }
    }

    public static void parseDeleteResult(InputStream inputStream, DeleteResult deleteResult) throws XmlPullParserException, IOException {
        XmlPullParser newPullParser = Xml.newPullParser();
        newPullParser.setInput(inputStream, "UTF-8");
        deleteResult.errorList = new ArrayList();
        deleteResult.deletedList = new ArrayList();
        DeleteResult.Deleted deleted = null;
        DeleteResult.Error error = null;
        for (int eventType = newPullParser.getEventType(); eventType != 1; eventType = newPullParser.next()) {
            if (eventType == 2) {
                String name = newPullParser.getName();
                if (name.equalsIgnoreCase("Deleted")) {
                    deleted = new DeleteResult.Deleted();
                } else if (name.equalsIgnoreCase("Error")) {
                    error = new DeleteResult.Error();
                } else if (name.equalsIgnoreCase("Key")) {
                    newPullParser.next();
                    if (deleted != null) {
                        deleted.key = newPullParser.getText();
                    } else if (error != null) {
                        error.key = newPullParser.getText();
                    }
                } else if (name.equalsIgnoreCase("VersionId")) {
                    newPullParser.next();
                    if (deleted != null) {
                        deleted.versionId = newPullParser.getText();
                    } else if (error != null) {
                        error.versionId = newPullParser.getText();
                    }
                } else if (name.equalsIgnoreCase("DeleteMarker")) {
                    newPullParser.next();
                    deleted.deleteMarker = Boolean.parseBoolean(newPullParser.getText());
                } else if (name.equalsIgnoreCase("DeleteMarkerVersionId")) {
                    newPullParser.next();
                    deleted.deleteMarkerVersionId = newPullParser.getText();
                } else if (name.equalsIgnoreCase("Message")) {
                    newPullParser.next();
                    error.message = newPullParser.getText();
                }
            } else if (eventType == 3) {
                String name2 = newPullParser.getName();
                if (name2.equalsIgnoreCase("Deleted")) {
                    deleteResult.deletedList.add(deleted);
                    deleted = null;
                } else if (name2.equalsIgnoreCase("CosError")) {
                    deleteResult.errorList.add(error);
                    error = null;
                }
            }
        }
    }

    public static void parseCopyObjectResult(InputStream inputStream, CopyObject copyObject) throws XmlPullParserException, IOException {
        XmlPullParser newPullParser = Xml.newPullParser();
        newPullParser.setInput(inputStream, "UTF-8");
        for (int eventType = newPullParser.getEventType(); eventType != 1; eventType = newPullParser.next()) {
            if (eventType == 2) {
                String name = newPullParser.getName();
                if (name.equalsIgnoreCase("ETag")) {
                    newPullParser.next();
                    copyObject.eTag = newPullParser.getText();
                } else if (name.equalsIgnoreCase("LastModified")) {
                    newPullParser.next();
                    copyObject.lastModified = newPullParser.getText();
                }
            }
        }
    }

    public static void parseCopyPartResult(InputStream inputStream, CopyPart copyPart) throws XmlPullParserException, IOException {
        XmlPullParser newPullParser = Xml.newPullParser();
        newPullParser.setInput(inputStream, "UTF-8");
        for (int eventType = newPullParser.getEventType(); eventType != 1; eventType = newPullParser.next()) {
            if (eventType == 2) {
                String name = newPullParser.getName();
                if (name.equalsIgnoreCase("ETag")) {
                    newPullParser.next();
                    copyPart.eTag = newPullParser.getText();
                } else if (name.equalsIgnoreCase("LastModified")) {
                    newPullParser.next();
                    copyPart.lastModified = newPullParser.getText();
                }
            }
        }
    }

    public static void parseListBucketVersions(InputStream inputStream, ListBucketVersions listBucketVersions) throws XmlPullParserException, IOException {
        ListBucketVersions.ObjectVersion version;
        XmlPullParser newPullParser = Xml.newPullParser();
        newPullParser.setInput(inputStream, "UTF-8");
        listBucketVersions.objectVersionList = new ArrayList();
        ListBucketVersions.Version version2 = null;
        ListBucketVersions.Owner owner = null;
        for (int eventType = newPullParser.getEventType(); eventType != 1; eventType = newPullParser.next()) {
            if (eventType == 2) {
                String name = newPullParser.getName();
                if (name.equalsIgnoreCase("Name")) {
                    newPullParser.next();
                    listBucketVersions.name = newPullParser.getText();
                } else if (name.equalsIgnoreCase("Prefix")) {
                    newPullParser.next();
                    listBucketVersions.prefix = newPullParser.getText();
                } else if (name.equalsIgnoreCase("KeyMarker")) {
                    newPullParser.next();
                    listBucketVersions.keyMarker = newPullParser.getText();
                } else if (name.equalsIgnoreCase("VersionIdMarker")) {
                    newPullParser.next();
                    listBucketVersions.versionIdMarker = newPullParser.getText();
                } else if (name.equalsIgnoreCase("MaxKeys")) {
                    newPullParser.next();
                    listBucketVersions.maxKeys = Long.parseLong(newPullParser.getText());
                } else if (name.equalsIgnoreCase("IsTruncated")) {
                    newPullParser.next();
                    listBucketVersions.isTruncated = Boolean.parseBoolean(newPullParser.getText());
                } else if (name.equalsIgnoreCase("NextKeyMarker")) {
                    newPullParser.next();
                    listBucketVersions.nextKeyMarker = newPullParser.getText();
                } else if (name.equalsIgnoreCase("NextVersionIdMarker")) {
                    newPullParser.next();
                    listBucketVersions.nextVersionIdMarker = newPullParser.getText();
                } else {
                    if (name.equalsIgnoreCase("DeleteMarker")) {
                        version = new ListBucketVersions.DeleteMarker();
                    } else if (name.equalsIgnoreCase("Version")) {
                        version = new ListBucketVersions.Version();
                    } else if (name.equalsIgnoreCase("Key")) {
                        newPullParser.next();
                        version2.key = newPullParser.getText();
                    } else if (name.equalsIgnoreCase("VersionId")) {
                        newPullParser.next();
                        version2.versionId = newPullParser.getText();
                    } else if (name.equalsIgnoreCase("IsLatest")) {
                        newPullParser.next();
                        version2.isLatest = Boolean.parseBoolean(newPullParser.getText());
                    } else if (name.equalsIgnoreCase("LastModified")) {
                        newPullParser.next();
                        version2.lastModified = newPullParser.getText();
                    } else if (name.equalsIgnoreCase("Owner")) {
                        owner = new ListBucketVersions.Owner();
                    } else if (name.equalsIgnoreCase("UID")) {
                        newPullParser.next();
                        owner.uid = newPullParser.getText();
                    } else if (name.equalsIgnoreCase("ETag")) {
                        newPullParser.next();
                        version2.eTag = newPullParser.getText();
                    } else if (name.equalsIgnoreCase("Size")) {
                        newPullParser.next();
                        version2.size = Long.parseLong(newPullParser.getText());
                    } else if (name.equalsIgnoreCase("StorageClass")) {
                        newPullParser.next();
                        version2.storageClass = newPullParser.getText();
                    }
                    version2 = version;
                }
            } else if (eventType == 3) {
                String name2 = newPullParser.getName();
                if (name2.equalsIgnoreCase("Owner")) {
                    version2.owner = owner;
                    owner = null;
                } else {
                    if (name2.equalsIgnoreCase("DeleteMarker")) {
                        listBucketVersions.objectVersionList.add(version2);
                    } else if (name2.equalsIgnoreCase("Version")) {
                        listBucketVersions.objectVersionList.add(version2);
                    }
                    version2 = null;
                }
            }
        }
    }
}
