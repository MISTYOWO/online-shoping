package com.atguigu.gmall.search;

import com.alibaba.dubbo.config.annotation.Reference;
import com.atguigu.gmall.beans.PmsSearchSkuInfo;
import com.atguigu.gmall.beans.PmsSkuInfo;
import io.searchbox.client.JestClient;
import io.searchbox.core.Index;
import io.searchbox.core.Search;
import io.searchbox.core.SearchResult;
import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.MatchQueryBuilder;
import org.elasticsearch.index.query.TermQueryBuilder;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.atguigu.gmall.services.SkuService;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GmallSearchServiceApplicationTests {
    @Reference
    SkuService skuService;
    @Autowired
    JestClient jestClient;

    @Test
    public void contextLoads() throws IOException {
        put();


    }
    public void put() throws IOException {
        List<PmsSkuInfo> pmsSkuInfoList = new ArrayList<>();
        pmsSkuInfoList = skuService.getAllSku("61");
        List<PmsSearchSkuInfo> pmsSearchSkuInfos = new ArrayList<>();
        for(PmsSkuInfo pmsSkuInfo:pmsSkuInfoList){
            PmsSearchSkuInfo pmsSearchSkuInfo = new PmsSearchSkuInfo();
            BeanUtils.copyProperties(pmsSkuInfo,pmsSearchSkuInfo);
            pmsSearchSkuInfos.add(pmsSearchSkuInfo);
        }
        for(PmsSearchSkuInfo pmsSearchSkuInfo:pmsSearchSkuInfos){
            Index post = new Index.Builder(pmsSearchSkuInfo).index("gmall0105").type("PmsSkuInfo").id(pmsSearchSkuInfo.getId()).build();
            jestClient.execute(post);
        }
    }
}
