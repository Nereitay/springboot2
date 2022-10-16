package es.kiwi.quartz;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

/**
 * Quartz
 *
 *  工作（Job）：用于定义具体执行的工作
 *  工作明细（JobDetail）：用于描述定时工作相关的信息
 *  触发器（Trigger）：描述了工作明细与调度器的对应关系
 *  调度器（Scheduler）：用于描述触发工作的执行规则，通常使用cron表达式定义规则
 */
public class MyQuartz extends QuartzJobBean {


    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        System.out.println("quartz task run ...");
    }
}
