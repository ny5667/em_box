package com.supcon.service;

import com.supcon.ao.JsonRootBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;


/**
 * @author zhangjunwei1
 */
@Service
public class EventService {
    private static final Logger logger = LoggerFactory.getLogger(EventService.class);

    private static final BlockingQueue<JsonRootBean> blockingQueue = new ArrayBlockingQueue<>(30);

    private static final String HTTP = "http://";
    private static final String EM_BOX_EVENT_DETAIL_RPC_URL = "/rpc/2.0/cvsaas/v1/event/detail";
    private static final String COLON = ":";

    @Value("${box.server.ip}")
    private String boxServerIp;
    @Value("${box.server.port}")
    private int boxServerPort;
    @Value("${box.resource.storage.dir}")
    private String storageDir;
    @Value("${lamp.close.url}")
    private String lampCloseUrl;
    @Value("${lamp.open.url}")
    private String lampOpenUrl;

    @Value("${box.rate}")
    private int rate;

    public int getRate(){
        return rate;
    }

    public JsonRootBean getDetailByEventId(Long eventId) {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<JsonRootBean> stringResponseEntity = restTemplate.postForEntity(HTTP + boxServerIp + COLON + boxServerPort + EM_BOX_EVENT_DETAIL_RPC_URL, eventId, JsonRootBean.class);
        JsonRootBean jsonRootBean = stringResponseEntity.getBody();
        dealWithResourcePath(jsonRootBean);
        return stringResponseEntity.getBody();
    }

    public void dealWithResourcePath(JsonRootBean jsonRootBean) {
        jsonRootBean.getResult().setOriginImageFileKey(HTTP + boxServerIp + COLON + boxServerPort + storageDir + jsonRootBean.getResult().getOriginImageFileKey());
        jsonRootBean.getResult().setOriginResourceFileKey(HTTP + boxServerIp + COLON + boxServerPort + storageDir + jsonRootBean.getResult().getOriginResourceFileKey());
        jsonRootBean.getResult().setRenderImageFileKey(HTTP + boxServerIp + COLON + boxServerPort + storageDir + jsonRootBean.getResult().getRenderImageFileKey());
        jsonRootBean.getResult().setRenderResourceFileKey(HTTP + boxServerIp + COLON + boxServerPort + storageDir + jsonRootBean.getResult().getRenderResourceFileKey());
    }

    public void open() {
        RestTemplate restTemplate = new RestTemplate();
        String forObject = restTemplate.getForObject(lampOpenUrl, String.class);
        logger.info(forObject);
        logger.info("open");
    }

    public void close() {
        RestTemplate restTemplate = new RestTemplate();
        String forObject = restTemplate.getForObject(lampCloseUrl, String.class);
        logger.info(forObject);
        logger.info("close");
    }


    public void addEvent(JsonRootBean jsonRootBean) {
        blockingQueue.offer(jsonRootBean);
    }

    public BlockingQueue<JsonRootBean> getBlockingQueue() {
        return blockingQueue;
    }
}
