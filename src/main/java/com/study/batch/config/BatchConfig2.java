package com.study.batch.config;

import com.study.batch.entity.Employee;
import com.study.batch.processor.ValidationProcessor;
import com.study.batch.writer.ConsoleItemWriter;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

/**
 * @description
 * @since JDK1.8
 * @createTime 2019/4/22 下午 3:02
 * @author xiechongyang
 */

@Configuration
@EnableBatchProcessing
public class BatchConfig2 {

    @Autowired
    private JobBuilderFactory jobs;

    @Autowired
    private StepBuilderFactory steps;

//    @Value("/in.csv")
//    private Resource inputResource;

    @Bean
    public Job readCSVFilesJob(){
        return jobs
                .get("readCSVFilesJob")
                .incrementer(new RunIdIncrementer())
                .start(step1())
                .build();
    }

    @Bean
    public Step step1(){
        return steps
                .get("step1")
                .<Employee,Employee>chunk(1)
                .reader(reader())//读
                .processor(processor())//处理
                .writer(writer())//写
                .build();

    }

    @Bean
    public ItemProcessor<Employee,Employee> processor(){
        return new ValidationProcessor();
    }

    @Bean
    public FlatFileItemReader<Employee> reader(){
        FlatFileItemReader<Employee> itemReader = new FlatFileItemReader<>();
        itemReader.setLineMapper(lineMapper());
        itemReader.setLinesToSkip(1);
        Resource resource = new ClassPathResource("in.csv");
        itemReader.setResource(resource);
        return itemReader;
    }

    @Bean
    public LineMapper<Employee> lineMapper() {
        DefaultLineMapper<Employee> lineMapper = new DefaultLineMapper<>();
        DelimitedLineTokenizer lineTokenizer = new DelimitedLineTokenizer();
        lineTokenizer.setNames(new String[]{"id","firstName","lastName"});
        lineTokenizer.setIncludedFields(new int[]{0,1,2});
        BeanWrapperFieldSetMapper<Employee> fieldSetMapper = new
                BeanWrapperFieldSetMapper<>();
        fieldSetMapper.setTargetType(Employee.class);
        lineMapper.setLineTokenizer(lineTokenizer);
        lineMapper.setFieldSetMapper(fieldSetMapper);
        return lineMapper;
    }

    @Bean
    public ConsoleItemWriter writer(){
        return new ConsoleItemWriter();
    }

}
