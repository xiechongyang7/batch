package com.study.batch.listener;

import com.study.batch.base.BaseLogger;
import org.springframework.batch.core.SkipListener;

/**
 * @description
 * @since JDK1.8
 * @createTime 2019/4/22 下午 4:25
 * @author xiechongyang
 */
public class StepSkipListener extends BaseLogger implements SkipListener<String, Number> {

    @Override
    public void onSkipInRead(Throwable t) {
        logger.info("StepSkipListener - onSkipInRead");
    }

    @Override
    public void onSkipInWrite(Number item, Throwable t) {
        logger.info("StepSkipListener - afterWrite");
    }

    @Override
    public void onSkipInProcess(String item, Throwable t) {
        logger.info("StepSkipListener - onWriteError");
    }
}