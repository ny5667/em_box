package com.supcon.command;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.supcon.ao.JsonRootBean;
import com.supcon.service.EventService;
import com.supcon.websocket.AlarmSocket;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

@Component
public class TaskCommand implements CommandLineRunner {


    private static final Logger logger = LoggerFactory.getLogger(TaskCommand.class);

    private static final AtomicBoolean alarm = new AtomicBoolean(false);
    private static final Gson gson = new GsonBuilder().serializeNulls().create();

    private static final ThreadPoolExecutor threadPoll = new ThreadPoolExecutor(4, 4, 2, TimeUnit.SECONDS, new ArrayBlockingQueue<>(3), new ThreadPoolExecutor.DiscardOldestPolicy());


    @Autowired
    private EventService eventService;

    @Override
    public void run(String... args) throws Exception {
        int rate = eventService.getRate();
        while (true) {
            try {
                JsonRootBean jsonRootBean = eventService.getBlockingQueue().poll(rate, TimeUnit.MILLISECONDS);
                if (jsonRootBean == null) {
                    jsonRootBean = new JsonRootBean();
                    jsonRootBean.setError_code(0);
                    jsonRootBean.setLog_id(0);
                    jsonRootBean.setResult(null);
                    jsonRootBean.setTrace_id("");
                    if (alarm.get()) {
                        logger.info("begin close");
                        alarm.compareAndSet(true, false);
                        threadPoll.execute(() -> eventService.close());
                    }
                } else {
                    logger.info("begin open");
                    alarm.getAndSet(true);
                    threadPoll.execute(() -> eventService.open());
                }
                logger.info("push to ws client: {}", jsonRootBean);
                AlarmSocket.pushData(gson.toJson(jsonRootBean));
            } catch (Exception e) {
                logger.error(e.getMessage());
            }
        }
    }
}
