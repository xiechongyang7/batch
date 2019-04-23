package com.study.batch.processor;

import com.study.batch.base.BaseLogger;
import com.study.batch.entity.Employee;
import org.springframework.batch.item.ItemProcessor;

/**
 * @author xiechongyang
 * @description
 * @createTime 2019/4/22 下午 5:04
 * @since JDK1.8
 */
public class ValidationProcessor extends BaseLogger implements ItemProcessor<Employee, Employee> {
    @Override
    public Employee process(Employee employee) throws Exception {

        if (employee.getId() == null) {
            logger.info("Missing employee id : " + employee.getId());
            return null;
        }

        try {
            if (Integer.valueOf(employee.getId()) <= 0) {
                System.out.println("Invalid employee id : " + employee.getId());
                return null;
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid employee id : " + employee.getId());
            return null;
        }

        return employee;
    }
}
