package com.study.batch.start;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * @description
 * @since JDK1.8
 * @createTime 2019/4/22 下午 3:15
 * @author xiechongyang
 */
@Component
public class Starter implements CommandLineRunner {

    @Autowired
    private JobLauncher jobLauncher;

    @Autowired
    private Job job;

    @Override
    public void run(String... args) throws Exception {
        JobParameters parameters = new JobParametersBuilder()
                .addString("JobID",String.valueOf(System.currentTimeMillis()))
                .toJobParameters();
        jobLauncher.run(job,parameters);
    }
}
