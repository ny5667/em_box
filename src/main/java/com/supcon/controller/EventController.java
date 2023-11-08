package com.supcon.controller;

import com.google.gson.Gson;
import com.supcon.ao.EventNotify;
import com.supcon.ao.JsonRootBean;
import com.supcon.ao.Result;
import com.supcon.service.EventService;
import com.supcon.websocket.AlarmSocket;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * @author zhangjunwei1
 */
@RequestMapping("/event")
@RestController
public class EventController {

    private static final Logger logger = LoggerFactory.getLogger(EventNotify.class);

    private static final Gson gson = new Gson();


    @Autowired
    private EventService eventService;
    @Autowired
    private AlarmSocket alarmSocket;

    /**
     * 推送示例：
     * <p>
     * {
     * "eventId":47,
     * "skillId":10,
     * "deviceToken":"EHBU-LRMR-HLHT-26TX"
     * }
     * 业务系统接收到推送请求后，应返回（code==0表示接收推送成功）：
     * <p>
     * {
     * "code":0,
     * "message":"success"
     * }
     * 如果业务系统无响应，或者code!=0，则会根据retry-times和retry-interval进行重试推送。
     *
     * @param eventNotify
     */
    @PostMapping("")
    public void create(@RequestBody EventNotify eventNotify) {
        logger.info("推送事件 {}", eventNotify);
        JsonRootBean jsonRootBean = eventService.getDetailByEventId(eventNotify.getEventId());
        eventService.addEvent(jsonRootBean);


    }

    @PostMapping("/test")
    public void test(@RequestBody JsonRootBean jsonRootBean) {
        eventService.dealWithResourcePath(jsonRootBean);
        logger.info("人工推送事件 {}", jsonRootBean.getResult());
        eventService.addEvent(jsonRootBean);
    }
}
