package com.monsoon.community.service;

import com.monsoon.community.dao.AlphaDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Service
//@Scope("prototype")
public class AlphaService {

    @Autowired
    private AlphaDao alphaDao;

    public String find(){
        return alphaDao.select();
    }

    public AlphaService() {
        System.out.println("实例化...");
    }

    @PostConstruct // 在构造器之后进行运行
    public void init() {
        System.out.println("初始化...");
    }

    @PreDestroy
    public void destory() {
        System.out.println("销毁...");
    }
}
