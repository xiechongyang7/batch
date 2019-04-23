package com.study.batch.writer;

import com.study.batch.base.BaseLogger;
import com.study.batch.entity.Employee;
import org.springframework.batch.item.ItemWriter;

import java.util.List;

/**
 * @description
 * @since JDK1.8
 * @createTime 2019/4/23 下午 3:43
 * @author xiechongyang
 */
public class ConsoleItemWriter extends BaseLogger implements ItemWriter<Employee> {
    /**
     * Process the supplied data element. Will not be called with any null items
     * in normal operation.
     *
     * @param items items to be written
     * @throws Exception if there are errors. The framework will catch the
     *                   exception and convert or rethrow it as appropriate.
     */
    @Override
    public void write(List<? extends Employee> items) throws Exception {
        logger.info(items.toString());
    }
}
