package com.study.batch.listener;

import com.study.batch.base.BaseLogger;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;

/**
 * @description
 * @since JDK1.8
 * @createTime 2019/4/22 下午 3:49
 * @author xiechongyang
 */
public class JobResultListener extends BaseLogger implements JobExecutionListener{
    @Override
    public void beforeJob(JobExecution jobExecution) {
        logger.info("JobResultListener called beforeJob()..");

    }

    @Override
    public void afterJob(JobExecution jobExecution) {
        logger.info("JobResultListener called afterJob()..");
    }
}
