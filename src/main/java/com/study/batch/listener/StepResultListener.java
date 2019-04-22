package com.study.batch.listener;

import com.study.batch.base.BaseLogger;
import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.StepExecutionListener;

/**
 * @description
 * @since JDK1.8
 * @createTime 2019/4/22 下午 4:01
 * @author xiechongyang
 */
public class StepResultListener extends BaseLogger implements StepExecutionListener {
    @Override
    public void beforeStep(StepExecution stepExecution) {
        logger.info("StepResultListener called beforeJob()..");
    }

    @Override
    public ExitStatus afterStep(StepExecution stepExecution) {
        logger.info("StepResultListener called afterJob()..");
        return ExitStatus.COMPLETED;
    }
}
