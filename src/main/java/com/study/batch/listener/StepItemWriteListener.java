package com.study.batch.listener;

import com.study.batch.base.BaseLogger;
import org.springframework.batch.core.ItemWriteListener;

import java.util.List;

/**
 * @description
 * @since JDK1.8
 * @createTime 2019/4/22 下午 4:22
 * @author xiechongyang
 */
public class StepItemWriteListener extends BaseLogger implements ItemWriteListener<Number> {

    @Override
    public void beforeWrite(List<? extends Number> items) {
        logger.info("ItemWriteListener - beforeWrite");
    }

    @Override
    public void afterWrite(List<? extends Number> items) {
        logger.info("ItemWriteListener - afterWrite");
    }

    @Override
    public void onWriteError(Exception exception, List<? extends Number> items) {
        logger.info("ItemWriteListener - onWriteError");
    }
}