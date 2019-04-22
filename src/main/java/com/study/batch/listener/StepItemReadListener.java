package com.study.batch.listener;

import com.study.batch.base.BaseLogger;
import org.springframework.batch.core.ItemReadListener;

/**
 * @description
 * @since JDK1.8
 * @createTime 2019/4/22 下午 4:13
 * @author xiechongyang
 */
public class StepItemReadListener extends BaseLogger implements ItemReadListener<String> {


    @Override
    public void beforeRead() {
        logger.info("ItemReadListener - beforeRead");
    }

    @Override
    public void afterRead(String s) {
        logger.info("ItemReadListener - afterRead");
    }

    @Override
    public void onReadError(Exception e) {
        logger.info("ItemReadListener - onReadError");
    }
}
