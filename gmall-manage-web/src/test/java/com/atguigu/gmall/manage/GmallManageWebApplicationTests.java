package com.atguigu.gmall.manage;

import org.csource.common.MyException;
import org.csource.fastdfs.ClientGlobal;
import org.csource.fastdfs.StorageClient;
import org.csource.fastdfs.TrackerClient;
import org.csource.fastdfs.TrackerServer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GmallManageWebApplicationTests {

    @Test
    public void contextLoads() throws IOException, MyException {
        String s = GmallManageWebApplicationTests.class.getResource("/tracker.conf").getPath();
        ClientGlobal.init(s);
        TrackerClient trackerClient = new TrackerClient();
        TrackerServer trackerServer = trackerClient.getConnection();
        StorageClient storageClient = new StorageClient(trackerServer,null);
        String[] uploadInfos = storageClient.upload_file("/home/misty/桌面/timg.jpeg","jpeg",null);
        String url = "http://192.168.1.63";
        for(String uploadInfo : uploadInfos){
            url += "/"+uploadInfo;
        }
        System.out.println(url);


    }

}
