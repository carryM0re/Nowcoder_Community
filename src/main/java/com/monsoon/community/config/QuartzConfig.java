package com.monsoon.community.config;


import com.monsoon.community.quartz.AlphaJob;
import com.monsoon.community.quartz.PostScoreRefreshJob;
import org.quartz.JobDataMap;
import org.quartz.JobDetail;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.JobDetailFactoryBean;
import org.springframework.scheduling.quartz.SimpleTriggerFactoryBean;

// 只有第一次配置有用，配置好了以后，每次都是通过数据库来调用
@Configuration
public class QuartzConfig {

    // BeanFactory是容器的顶层接口
    // 而FactoryBean可简化Bean的实例化过程：相当于这个类里面封装了详细的JobDetail实例化过程
    // 1.Spring通过FactoryBean封装了Bean的实例化过程
    // 2.将FactoryBean装配到Spring容器里
    // 3.将FactoryBean注入给其他的Bean
    // 4.那么其他的Bean得到的是FactoryBean所管理的对象实例

    // 配置JobDetail
    // @Bean
    public JobDetailFactoryBean alphaJobDetail(){
        JobDetailFactoryBean factoryBean = new JobDetailFactoryBean();
        factoryBean.setJobClass(AlphaJob.class);
        factoryBean.setName("alphaJob");
        factoryBean.setGroup("alphaJobGroup");
        factoryBean.setDurability(true); // 是否持久保存
        factoryBean.setRequestsRecovery(true); // 是否可恢复
        return factoryBean;
    }

    // 配置Trigger（可使用SimpleTriggerFactoryBean或CronTriggerFactoryBean）
    // @Bean
    public SimpleTriggerFactoryBean alphaTrigger(JobDetail alphaJobDetail){ //当Bean多了之后，会优先注入同名的
        SimpleTriggerFactoryBean factoryBean = new SimpleTriggerFactoryBean();
        factoryBean.setJobDetail(alphaJobDetail);
        factoryBean.setName("alphaTrigger");
        factoryBean.setGroup("alphaTriggerGroup");
        factoryBean.setRepeatInterval(3000); // 频率
        factoryBean.setJobDataAsMap(new JobDataMap());
        return factoryBean;
    }

    // 刷新帖子分数任务
    @Bean
    public JobDetailFactoryBean postScoreRefreshJobDetail(){
        JobDetailFactoryBean factoryBean = new JobDetailFactoryBean();
        factoryBean.setJobClass(PostScoreRefreshJob.class);
        factoryBean.setName("postScoreRefreshJob");
        factoryBean.setGroup("communityJobGroup");
        factoryBean.setDurability(true); // 是否持久保存
        factoryBean.setRequestsRecovery(true); // 是否可恢复
        return factoryBean;
    }

    @Bean
    public SimpleTriggerFactoryBean postScoreRefreshTrigger(JobDetail postScoreRefreshJobDetail){ //当Bean多了之后，会优先注入同名的
        SimpleTriggerFactoryBean factoryBean = new SimpleTriggerFactoryBean();
        factoryBean.setJobDetail(postScoreRefreshJobDetail);
        factoryBean.setName("postScoreRefreshTrigger");
        factoryBean.setGroup("communityTriggerGroup");
        factoryBean.setRepeatInterval(1000 * 60 * 5); // 频率
        factoryBean.setJobDataAsMap(new JobDataMap());
        return factoryBean;
    }


}
