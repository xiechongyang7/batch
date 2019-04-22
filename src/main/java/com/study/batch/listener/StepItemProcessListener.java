package com.study.batch.listener;

import com.study.batch.base.BaseLogger;
import org.springframework.batch.core.ItemProcessListener;


/**
 * @description
 * @since JDK1.8
 * @createTime 2019/4/22 下午 4:19
 * @author xiechongyang
 */
public class StepItemProcessListener extends BaseLogger implements ItemProcessListener<String,Number> {

    @Override
    public void beforeProcess(String item) {
        logger.info("ItemProcessListener - beforeProcess");
    }

    @Override
    public void afterProcess(String item, Number result) {
        logger.info("ItemProcessListener - afterProcess");
    }

    @Override
    public void onProcessError(String item, Exception e) {
        logger.info("ItemProcessListener - onProcessError");
    }
}
