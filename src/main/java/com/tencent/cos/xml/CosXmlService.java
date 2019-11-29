package com.tencent.cos.xml;

import android.content.Context;
import android.util.Log;
import com.tencent.cos.xml.common.MetaDataDirective;
import com.tencent.cos.xml.exception.CosXmlClientException;
import com.tencent.cos.xml.exception.CosXmlServiceException;
import com.tencent.cos.xml.listener.CosXmlBooleanListener;
import com.tencent.cos.xml.listener.CosXmlResultListener;
import com.tencent.cos.xml.model.CosXmlRequest;
import com.tencent.cos.xml.model.CosXmlResult;
import com.tencent.cos.xml.model.bucket.DeleteBucketCORSRequest;
import com.tencent.cos.xml.model.bucket.DeleteBucketCORSResult;
import com.tencent.cos.xml.model.bucket.DeleteBucketLifecycleRequest;
import com.tencent.cos.xml.model.bucket.DeleteBucketLifecycleResult;
import com.tencent.cos.xml.model.bucket.DeleteBucketReplicationRequest;
import com.tencent.cos.xml.model.bucket.DeleteBucketReplicationResult;
import com.tencent.cos.xml.model.bucket.DeleteBucketRequest;
import com.tencent.cos.xml.model.bucket.DeleteBucketResult;
import com.tencent.cos.xml.model.bucket.GetBucketACLRequest;
import com.tencent.cos.xml.model.bucket.GetBucketACLResult;
import com.tencent.cos.xml.model.bucket.GetBucketCORSRequest;
import com.tencent.cos.xml.model.bucket.GetBucketCORSResult;
import com.tencent.cos.xml.model.bucket.GetBucketLifecycleRequest;
import com.tencent.cos.xml.model.bucket.GetBucketLifecycleResult;
import com.tencent.cos.xml.model.bucket.GetBucketLocationRequest;
import com.tencent.cos.xml.model.bucket.GetBucketLocationResult;
import com.tencent.cos.xml.model.bucket.GetBucketReplicationRequest;
import com.tencent.cos.xml.model.bucket.GetBucketReplicationResult;
import com.tencent.cos.xml.model.bucket.GetBucketRequest;
import com.tencent.cos.xml.model.bucket.GetBucketResult;
import com.tencent.cos.xml.model.bucket.GetBucketVersioningRequest;
import com.tencent.cos.xml.model.bucket.GetBucketVersioningResult;
import com.tencent.cos.xml.model.bucket.HeadBucketRequest;
import com.tencent.cos.xml.model.bucket.HeadBucketResult;
import com.tencent.cos.xml.model.bucket.ListBucketVersionsRequest;
import com.tencent.cos.xml.model.bucket.ListBucketVersionsResult;
import com.tencent.cos.xml.model.bucket.ListMultiUploadsRequest;
import com.tencent.cos.xml.model.bucket.ListMultiUploadsResult;
import com.tencent.cos.xml.model.bucket.PutBucketACLRequest;
import com.tencent.cos.xml.model.bucket.PutBucketACLResult;
import com.tencent.cos.xml.model.bucket.PutBucketCORSRequest;
import com.tencent.cos.xml.model.bucket.PutBucketCORSResult;
import com.tencent.cos.xml.model.bucket.PutBucketLifecycleRequest;
import com.tencent.cos.xml.model.bucket.PutBucketLifecycleResult;
import com.tencent.cos.xml.model.bucket.PutBucketReplicationRequest;
import com.tencent.cos.xml.model.bucket.PutBucketReplicationResult;
import com.tencent.cos.xml.model.bucket.PutBucketRequest;
import com.tencent.cos.xml.model.bucket.PutBucketResult;
import com.tencent.cos.xml.model.bucket.PutBucketVersioningRequest;
import com.tencent.cos.xml.model.bucket.PutBucketVersioningResult;
import com.tencent.cos.xml.model.object.CopyObjectRequest;
import com.tencent.cos.xml.model.object.CopyObjectResult;
import com.tencent.cos.xml.model.object.DeleteMultiObjectRequest;
import com.tencent.cos.xml.model.object.DeleteMultiObjectResult;
import com.tencent.cos.xml.model.object.DeleteObjectRequest;
import com.tencent.cos.xml.model.object.GetObjectACLRequest;
import com.tencent.cos.xml.model.object.GetObjectACLResult;
import com.tencent.cos.xml.model.object.HeadObjectRequest;
import com.tencent.cos.xml.model.object.HeadObjectResult;
import com.tencent.cos.xml.model.object.OptionObjectRequest;
import com.tencent.cos.xml.model.object.OptionObjectResult;
import com.tencent.cos.xml.model.object.PutObjectACLRequest;
import com.tencent.cos.xml.model.object.PutObjectACLResult;
import com.tencent.cos.xml.model.object.RestoreRequest;
import com.tencent.cos.xml.model.object.RestoreResult;
import com.tencent.cos.xml.model.object.UploadPartCopyRequest;
import com.tencent.cos.xml.model.object.UploadPartCopyResult;
import com.tencent.cos.xml.model.service.GetServiceRequest;
import com.tencent.cos.xml.model.service.GetServiceResult;
import com.tencent.cos.xml.model.tag.COSMetaData;
import com.tencent.cos.xml.model.tag.ListAllMyBuckets;
import com.tencent.qcloud.core.auth.QCloudCredentialProvider;
import java.util.List;

public class CosXmlService extends CosXmlSimpleService implements CosXml {
    public CosXmlService(Context context, CosXmlServiceConfig cosXmlServiceConfig, QCloudCredentialProvider qCloudCredentialProvider) {
        super(context, cosXmlServiceConfig, qCloudCredentialProvider);
    }

    public GetServiceResult getService(GetServiceRequest getServiceRequest) throws CosXmlClientException, CosXmlServiceException {
        return (GetServiceResult) execute(getServiceRequest, new GetServiceResult());
    }

    public void getServiceAsync(GetServiceRequest getServiceRequest, CosXmlResultListener cosXmlResultListener) {
        schedule(getServiceRequest, new GetServiceResult(), cosXmlResultListener);
    }

    public DeleteMultiObjectResult deleteMultiObject(DeleteMultiObjectRequest deleteMultiObjectRequest) throws CosXmlClientException, CosXmlServiceException {
        return (DeleteMultiObjectResult) execute(deleteMultiObjectRequest, new DeleteMultiObjectResult());
    }

    public void deleteMultiObjectAsync(DeleteMultiObjectRequest deleteMultiObjectRequest, CosXmlResultListener cosXmlResultListener) {
        schedule(deleteMultiObjectRequest, new DeleteMultiObjectResult(), cosXmlResultListener);
    }

    public GetObjectACLResult getObjectACL(GetObjectACLRequest getObjectACLRequest) throws CosXmlClientException, CosXmlServiceException {
        return (GetObjectACLResult) execute(getObjectACLRequest, new GetObjectACLResult());
    }

    public void getObjectACLAsync(GetObjectACLRequest getObjectACLRequest, CosXmlResultListener cosXmlResultListener) {
        schedule(getObjectACLRequest, new GetObjectACLResult(), cosXmlResultListener);
    }

    public HeadObjectResult headObject(HeadObjectRequest headObjectRequest) throws CosXmlClientException, CosXmlServiceException {
        return (HeadObjectResult) execute(headObjectRequest, new HeadObjectResult());
    }

    public void headObjectAsync(HeadObjectRequest headObjectRequest, CosXmlResultListener cosXmlResultListener) {
        schedule(headObjectRequest, new HeadObjectResult(), cosXmlResultListener);
    }

    public OptionObjectResult optionObject(OptionObjectRequest optionObjectRequest) throws CosXmlClientException, CosXmlServiceException {
        return (OptionObjectResult) execute(optionObjectRequest, new OptionObjectResult());
    }

    public void optionObjectAsync(OptionObjectRequest optionObjectRequest, CosXmlResultListener cosXmlResultListener) {
        schedule(optionObjectRequest, new OptionObjectResult(), cosXmlResultListener);
    }

    public PutObjectACLResult putObjectACL(PutObjectACLRequest putObjectACLRequest) throws CosXmlClientException, CosXmlServiceException {
        return (PutObjectACLResult) execute(putObjectACLRequest, new PutObjectACLResult());
    }

    public void putObjectACLAsync(PutObjectACLRequest putObjectACLRequest, CosXmlResultListener cosXmlResultListener) {
        schedule(putObjectACLRequest, new PutObjectACLResult(), cosXmlResultListener);
    }

    public CopyObjectResult copyObject(CopyObjectRequest copyObjectRequest) throws CosXmlClientException, CosXmlServiceException {
        return (CopyObjectResult) execute(copyObjectRequest, new CopyObjectResult());
    }

    public void copyObjectAsync(CopyObjectRequest copyObjectRequest, CosXmlResultListener cosXmlResultListener) {
        schedule(copyObjectRequest, new CopyObjectResult(), cosXmlResultListener);
    }

    public UploadPartCopyResult copyObject(UploadPartCopyRequest uploadPartCopyRequest) throws CosXmlClientException, CosXmlServiceException {
        return (UploadPartCopyResult) execute(uploadPartCopyRequest, new UploadPartCopyResult());
    }

    public void copyObjectAsync(UploadPartCopyRequest uploadPartCopyRequest, CosXmlResultListener cosXmlResultListener) {
        schedule(uploadPartCopyRequest, new UploadPartCopyResult(), cosXmlResultListener);
    }

    public RestoreResult restoreObject(RestoreRequest restoreRequest) throws CosXmlClientException, CosXmlServiceException {
        return (RestoreResult) execute(restoreRequest, new RestoreResult());
    }

    public void restoreObjectAsync(RestoreRequest restoreRequest, CosXmlResultListener cosXmlResultListener) {
        schedule(restoreRequest, new RestoreResult(), cosXmlResultListener);
    }

    public DeleteBucketCORSResult deleteBucketCORS(DeleteBucketCORSRequest deleteBucketCORSRequest) throws CosXmlClientException, CosXmlServiceException {
        return (DeleteBucketCORSResult) execute(deleteBucketCORSRequest, new DeleteBucketCORSResult());
    }

    public void deleteBucketCORSAsync(DeleteBucketCORSRequest deleteBucketCORSRequest, CosXmlResultListener cosXmlResultListener) {
        schedule(deleteBucketCORSRequest, new DeleteBucketCORSResult(), cosXmlResultListener);
    }

    public DeleteBucketLifecycleResult deleteBucketLifecycle(DeleteBucketLifecycleRequest deleteBucketLifecycleRequest) throws CosXmlClientException, CosXmlServiceException {
        return (DeleteBucketLifecycleResult) execute(deleteBucketLifecycleRequest, new DeleteBucketLifecycleResult());
    }

    public void deleteBucketLifecycleAsync(DeleteBucketLifecycleRequest deleteBucketLifecycleRequest, CosXmlResultListener cosXmlResultListener) {
        schedule(deleteBucketLifecycleRequest, new DeleteBucketLifecycleResult(), cosXmlResultListener);
    }

    public DeleteBucketResult deleteBucket(DeleteBucketRequest deleteBucketRequest) throws CosXmlClientException, CosXmlServiceException {
        return (DeleteBucketResult) execute(deleteBucketRequest, new DeleteBucketResult());
    }

    public void deleteBucketAsync(DeleteBucketRequest deleteBucketRequest, CosXmlResultListener cosXmlResultListener) {
        schedule(deleteBucketRequest, new DeleteBucketResult(), cosXmlResultListener);
    }

    public GetBucketACLResult getBucketACL(GetBucketACLRequest getBucketACLRequest) throws CosXmlClientException, CosXmlServiceException {
        return (GetBucketACLResult) execute(getBucketACLRequest, new GetBucketACLResult());
    }

    public void getBucketACLAsync(GetBucketACLRequest getBucketACLRequest, CosXmlResultListener cosXmlResultListener) {
        schedule(getBucketACLRequest, new GetBucketACLResult(), cosXmlResultListener);
    }

    public GetBucketCORSResult getBucketCORS(GetBucketCORSRequest getBucketCORSRequest) throws CosXmlClientException, CosXmlServiceException {
        return (GetBucketCORSResult) execute(getBucketCORSRequest, new GetBucketCORSResult());
    }

    public void getBucketCORSAsync(GetBucketCORSRequest getBucketCORSRequest, CosXmlResultListener cosXmlResultListener) {
        schedule(getBucketCORSRequest, new GetBucketCORSResult(), cosXmlResultListener);
    }

    public GetBucketLifecycleResult getBucketLifecycle(GetBucketLifecycleRequest getBucketLifecycleRequest) throws CosXmlClientException, CosXmlServiceException {
        return (GetBucketLifecycleResult) execute(getBucketLifecycleRequest, new GetBucketLifecycleResult());
    }

    public void getBucketLifecycleAsync(GetBucketLifecycleRequest getBucketLifecycleRequest, CosXmlResultListener cosXmlResultListener) {
        schedule(getBucketLifecycleRequest, new GetBucketLifecycleResult(), cosXmlResultListener);
    }

    public GetBucketLocationResult getBucketLocation(GetBucketLocationRequest getBucketLocationRequest) throws CosXmlClientException, CosXmlServiceException {
        return (GetBucketLocationResult) execute(getBucketLocationRequest, new GetBucketLocationResult());
    }

    public void getBucketLocationAsync(GetBucketLocationRequest getBucketLocationRequest, CosXmlResultListener cosXmlResultListener) {
        schedule(getBucketLocationRequest, new GetBucketLocationResult(), cosXmlResultListener);
    }

    public GetBucketResult getBucket(GetBucketRequest getBucketRequest) throws CosXmlClientException, CosXmlServiceException {
        return (GetBucketResult) execute(getBucketRequest, new GetBucketResult());
    }

    public void getBucketAsync(GetBucketRequest getBucketRequest, CosXmlResultListener cosXmlResultListener) {
        schedule(getBucketRequest, new GetBucketResult(), cosXmlResultListener);
    }

    public HeadBucketResult headBucket(HeadBucketRequest headBucketRequest) throws CosXmlClientException, CosXmlServiceException {
        return (HeadBucketResult) execute(headBucketRequest, new HeadBucketResult());
    }

    public void headBucketAsync(HeadBucketRequest headBucketRequest, CosXmlResultListener cosXmlResultListener) {
        schedule(headBucketRequest, new HeadBucketResult(), cosXmlResultListener);
    }

    public ListMultiUploadsResult listMultiUploads(ListMultiUploadsRequest listMultiUploadsRequest) throws CosXmlClientException, CosXmlServiceException {
        return (ListMultiUploadsResult) execute(listMultiUploadsRequest, new ListMultiUploadsResult());
    }

    public void listMultiUploadsAsync(ListMultiUploadsRequest listMultiUploadsRequest, CosXmlResultListener cosXmlResultListener) {
        schedule(listMultiUploadsRequest, new ListMultiUploadsResult(), cosXmlResultListener);
    }

    public PutBucketACLResult putBucketACL(PutBucketACLRequest putBucketACLRequest) throws CosXmlClientException, CosXmlServiceException {
        return (PutBucketACLResult) execute(putBucketACLRequest, new PutBucketACLResult());
    }

    public void putBucketACLAsync(PutBucketACLRequest putBucketACLRequest, CosXmlResultListener cosXmlResultListener) {
        schedule(putBucketACLRequest, new PutBucketACLResult(), cosXmlResultListener);
    }

    public PutBucketCORSResult putBucketCORS(PutBucketCORSRequest putBucketCORSRequest) throws CosXmlClientException, CosXmlServiceException {
        return (PutBucketCORSResult) execute(putBucketCORSRequest, new PutBucketCORSResult());
    }

    public void putBucketCORSAsync(PutBucketCORSRequest putBucketCORSRequest, CosXmlResultListener cosXmlResultListener) {
        schedule(putBucketCORSRequest, new PutBucketCORSResult(), cosXmlResultListener);
    }

    public PutBucketLifecycleResult putBucketLifecycle(PutBucketLifecycleRequest putBucketLifecycleRequest) throws CosXmlClientException, CosXmlServiceException {
        return (PutBucketLifecycleResult) execute(putBucketLifecycleRequest, new PutBucketLifecycleResult());
    }

    public void putBucketLifecycleAsync(PutBucketLifecycleRequest putBucketLifecycleRequest, CosXmlResultListener cosXmlResultListener) {
        schedule(putBucketLifecycleRequest, new PutBucketLifecycleResult(), cosXmlResultListener);
    }

    public PutBucketResult putBucket(PutBucketRequest putBucketRequest) throws CosXmlClientException, CosXmlServiceException {
        return (PutBucketResult) execute(putBucketRequest, new PutBucketResult());
    }

    public void putBucketAsync(PutBucketRequest putBucketRequest, CosXmlResultListener cosXmlResultListener) {
        schedule(putBucketRequest, new PutBucketResult(), cosXmlResultListener);
    }

    public GetBucketVersioningResult getBucketVersioning(GetBucketVersioningRequest getBucketVersioningRequest) throws CosXmlClientException, CosXmlServiceException {
        return (GetBucketVersioningResult) execute(getBucketVersioningRequest, new GetBucketVersioningResult());
    }

    public void getBucketVersioningAsync(GetBucketVersioningRequest getBucketVersioningRequest, CosXmlResultListener cosXmlResultListener) {
        schedule(getBucketVersioningRequest, new GetBucketVersioningResult(), cosXmlResultListener);
    }

    public PutBucketVersioningResult putBucketVersioning(PutBucketVersioningRequest putBucketVersioningRequest) throws CosXmlClientException, CosXmlServiceException {
        return (PutBucketVersioningResult) execute(putBucketVersioningRequest, new PutBucketVersioningResult());
    }

    public void putBucketVersionAsync(PutBucketVersioningRequest putBucketVersioningRequest, CosXmlResultListener cosXmlResultListener) {
        schedule(putBucketVersioningRequest, new PutBucketVersioningResult(), cosXmlResultListener);
    }

    public GetBucketReplicationResult getBucketReplication(GetBucketReplicationRequest getBucketReplicationRequest) throws CosXmlClientException, CosXmlServiceException {
        return (GetBucketReplicationResult) execute(getBucketReplicationRequest, new GetBucketReplicationResult());
    }

    public void getBucketReplicationAsync(GetBucketReplicationRequest getBucketReplicationRequest, CosXmlResultListener cosXmlResultListener) {
        schedule(getBucketReplicationRequest, new GetBucketReplicationResult(), cosXmlResultListener);
    }

    public PutBucketReplicationResult putBucketReplication(PutBucketReplicationRequest putBucketReplicationRequest) throws CosXmlClientException, CosXmlServiceException {
        return (PutBucketReplicationResult) execute(putBucketReplicationRequest, new PutBucketReplicationResult());
    }

    public void putBucketReplicationAsync(PutBucketReplicationRequest putBucketReplicationRequest, CosXmlResultListener cosXmlResultListener) {
        schedule(putBucketReplicationRequest, new PutBucketReplicationResult(), cosXmlResultListener);
    }

    public DeleteBucketReplicationResult deleteBucketReplication(DeleteBucketReplicationRequest deleteBucketReplicationRequest) throws CosXmlClientException, CosXmlServiceException {
        return (DeleteBucketReplicationResult) execute(deleteBucketReplicationRequest, new DeleteBucketReplicationResult());
    }

    public void deleteBucketReplicationAsync(DeleteBucketReplicationRequest deleteBucketReplicationRequest, CosXmlResultListener cosXmlResultListener) {
        schedule(deleteBucketReplicationRequest, new DeleteBucketReplicationResult(), cosXmlResultListener);
    }

    public ListBucketVersionsResult listBucketVersions(ListBucketVersionsRequest listBucketVersionsRequest) throws CosXmlClientException, CosXmlServiceException {
        return (ListBucketVersionsResult) execute(listBucketVersionsRequest, new ListBucketVersionsResult());
    }

    public void listBucketVersionsAsync(ListBucketVersionsRequest listBucketVersionsRequest, CosXmlResultListener cosXmlResultListener) {
        schedule(listBucketVersionsRequest, new ListBucketVersionsResult(), cosXmlResultListener);
    }

    public boolean doesBucketExist(String str) throws CosXmlClientException, CosXmlServiceException {
        try {
            getBucketACL(new GetBucketACLRequest(str));
            return true;
        } catch (CosXmlServiceException e2) {
            if (e2.getStatusCode() == 301 || "AccessDenied".equals(e2.getErrorCode())) {
                return true;
            }
            if (e2.getStatusCode() == 404) {
                return false;
            }
            throw e2;
        }
    }

    public void doesBucketExistAsync(String str, final CosXmlBooleanListener cosXmlBooleanListener) {
        getBucketACLAsync(new GetBucketACLRequest(str), new CosXmlResultListener() {
            public void onSuccess(CosXmlRequest cosXmlRequest, CosXmlResult cosXmlResult) {
                cosXmlBooleanListener.onSuccess(true);
            }

            public void onFail(CosXmlRequest cosXmlRequest, CosXmlClientException cosXmlClientException, CosXmlServiceException cosXmlServiceException) {
                if (cosXmlClientException == null && cosXmlServiceException != null) {
                    if (cosXmlServiceException.getStatusCode() == 301 || "AccessDenied".equals(cosXmlServiceException.getErrorCode())) {
                        cosXmlBooleanListener.onSuccess(true);
                    }
                    if (cosXmlServiceException.getStatusCode() == 404) {
                        cosXmlBooleanListener.onSuccess(false);
                    }
                }
                cosXmlBooleanListener.onFail(cosXmlClientException, cosXmlServiceException);
            }
        });
    }

    @Deprecated
    private boolean doesBucketExistByGetService(GetServiceResult getServiceResult, String str) {
        if (!(getServiceResult == null || getServiceResult.listAllMyBuckets == null)) {
            List<ListAllMyBuckets.Bucket> list = getServiceResult.listAllMyBuckets.buckets;
            Log.d("tag", "buckets number is " + list.size());
            if (list == null) {
                return false;
            }
            for (ListAllMyBuckets.Bucket next : list) {
                Log.d("tag", "bucket name is " + next.name);
                String str2 = next.name;
                if (str2.equals(str + "-" + this.appid)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean doesObjectExist(String str, String str2) throws CosXmlClientException, CosXmlServiceException {
        try {
            headObject(new HeadObjectRequest(str, str2));
            return true;
        } catch (CosXmlServiceException e2) {
            if (e2.getStatusCode() == 404) {
                return false;
            }
            throw e2;
        }
    }

    public void doesObjectExistAsync(String str, String str2, final CosXmlBooleanListener cosXmlBooleanListener) {
        headObjectAsync(new HeadObjectRequest(str, str2), new CosXmlResultListener() {
            public void onSuccess(CosXmlRequest cosXmlRequest, CosXmlResult cosXmlResult) {
                cosXmlBooleanListener.onSuccess(true);
            }

            public void onFail(CosXmlRequest cosXmlRequest, CosXmlClientException cosXmlClientException, CosXmlServiceException cosXmlServiceException) {
                if (cosXmlServiceException == null || cosXmlServiceException.getStatusCode() != 404) {
                    cosXmlBooleanListener.onFail(cosXmlClientException, cosXmlServiceException);
                } else {
                    cosXmlBooleanListener.onSuccess(false);
                }
            }
        });
    }

    public boolean deleteObject(String str, String str2) throws CosXmlClientException, CosXmlServiceException {
        deleteObject(new DeleteObjectRequest(str, str2));
        return true;
    }

    public void deleteObjectAsync(String str, String str2, final CosXmlBooleanListener cosXmlBooleanListener) {
        deleteObjectAsync(new DeleteObjectRequest(str, str2), new CosXmlResultListener() {
            public void onSuccess(CosXmlRequest cosXmlRequest, CosXmlResult cosXmlResult) {
                cosXmlBooleanListener.onSuccess(true);
            }

            public void onFail(CosXmlRequest cosXmlRequest, CosXmlClientException cosXmlClientException, CosXmlServiceException cosXmlServiceException) {
                cosXmlBooleanListener.onFail(cosXmlClientException, cosXmlServiceException);
            }
        });
    }

    public boolean updateObjectMeta(String str, String str2, COSMetaData cOSMetaData) throws CosXmlClientException, CosXmlServiceException {
        CopyObjectRequest copyObjectRequest = new CopyObjectRequest(str, str2, new CopyObjectRequest.CopySourceStruct(this.appid, str, this.region, str2));
        copyObjectRequest.setCopyMetaDataDirective(MetaDataDirective.REPLACED);
        for (String next : cOSMetaData.keySet()) {
            copyObjectRequest.setXCOSMeta(next, cOSMetaData.get(next));
        }
        copyObject(copyObjectRequest);
        return true;
    }

    public void updateObjectMetaAsync(String str, String str2, COSMetaData cOSMetaData, final CosXmlBooleanListener cosXmlBooleanListener) {
        CopyObjectRequest copyObjectRequest;
        try {
            copyObjectRequest = new CopyObjectRequest(str, str2, new CopyObjectRequest.CopySourceStruct(this.appid, str, this.region, str2));
            try {
                copyObjectRequest.setCopyMetaDataDirective(MetaDataDirective.REPLACED);
                for (String next : cOSMetaData.keySet()) {
                    copyObjectRequest.setXCOSMeta(next, cOSMetaData.get(next));
                }
            } catch (CosXmlClientException e2) {
                e = e2;
                cosXmlBooleanListener.onFail(e, (CosXmlServiceException) null);
                copyObjectAsync(copyObjectRequest, (CosXmlResultListener) new CosXmlResultListener() {
                    public void onSuccess(CosXmlRequest cosXmlRequest, CosXmlResult cosXmlResult) {
                        cosXmlBooleanListener.onSuccess(true);
                    }

                    public void onFail(CosXmlRequest cosXmlRequest, CosXmlClientException cosXmlClientException, CosXmlServiceException cosXmlServiceException) {
                        cosXmlBooleanListener.onFail(cosXmlClientException, cosXmlServiceException);
                    }
                });
            }
        } catch (CosXmlClientException e3) {
            e = e3;
            copyObjectRequest = null;
            cosXmlBooleanListener.onFail(e, (CosXmlServiceException) null);
            copyObjectAsync(copyObjectRequest, (CosXmlResultListener) new CosXmlResultListener() {
                public void onSuccess(CosXmlRequest cosXmlRequest, CosXmlResult cosXmlResult) {
                    cosXmlBooleanListener.onSuccess(true);
                }

                public void onFail(CosXmlRequest cosXmlRequest, CosXmlClientException cosXmlClientException, CosXmlServiceException cosXmlServiceException) {
                    cosXmlBooleanListener.onFail(cosXmlClientException, cosXmlServiceException);
                }
            });
        }
        copyObjectAsync(copyObjectRequest, (CosXmlResultListener) new CosXmlResultListener() {
            public void onSuccess(CosXmlRequest cosXmlRequest, CosXmlResult cosXmlResult) {
                cosXmlBooleanListener.onSuccess(true);
            }

            public void onFail(CosXmlRequest cosXmlRequest, CosXmlClientException cosXmlClientException, CosXmlServiceException cosXmlServiceException) {
                cosXmlBooleanListener.onFail(cosXmlClientException, cosXmlServiceException);
            }
        });
    }
}
