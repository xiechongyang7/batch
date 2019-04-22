package com.study.batch.tasks;

import com.study.batch.base.BaseLogger;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;

/**
 * @description
 * @since JDK1.8
 * @createTime 2019/4/22 下午 3:03
 * @author xiechongyang
 */
public class MyTaskOne extends BaseLogger implements Tasklet {

    @Override
    public RepeatStatus execute(StepContribution stepContribution, ChunkContext chunkContext) throws Exception {

        logger.info("MyTaskOne start ...");


        logger.info("MyTaskOne done ...");

        return RepeatStatus.FINISHED;
    }

}
