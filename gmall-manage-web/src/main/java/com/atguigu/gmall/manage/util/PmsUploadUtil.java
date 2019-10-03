package com.atguigu.gmall.manage.util;

import org.csource.common.MyException;
import org.csource.fastdfs.ClientGlobal;
import org.csource.fastdfs.StorageClient;
import org.csource.fastdfs.TrackerClient;
import org.csource.fastdfs.TrackerServer;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public class PmsUploadUtil {
    public static String uploadImage(MultipartFile multipartFile) throws IOException, MyException {
        String url = "http://192.168.1.63";
        String s = PmsUploadUtil.class.getResource("/tracker.conf").getPath();
        ClientGlobal.init(s);
        TrackerClient trackerClient = new TrackerClient();
        TrackerServer trackerServer = trackerClient.getConnection();
        StorageClient storageClient = new StorageClient(trackerServer,null);
        byte[] bytes = multipartFile.getBytes();
        String originalFilename = multipartFile.getOriginalFilename();
        int i = originalFilename.lastIndexOf(".");
        String extName =  originalFilename.substring(i+1);
        String[] uploadInfos = storageClient.upload_file(bytes,"jpeg",null);
        for(String uploadInfo : uploadInfos){
            url += "/"+uploadInfo;
        }
        return url;
    }
}
