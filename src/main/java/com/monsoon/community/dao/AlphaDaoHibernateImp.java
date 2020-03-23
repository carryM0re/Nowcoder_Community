package com.monsoon.community.dao;

import org.springframework.stereotype.Repository;

@Repository("AlphaHibernate")
public class AlphaDaoHibernateImp implements AlphaDao{
    @Override
    public String select() {
        return "Hibernate";
    }
}
