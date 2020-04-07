package com.monsoon.community.dao;

import com.monsoon.community.entity.LoginTicket;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
@Deprecated // 声明不推荐使用
public interface LoginTicketMapper {

    @Insert({ // 每句话后面最好加一个空格，以免拼的时候挨在一起
            "insert into login_ticket(user_id,ticket,status,expired) ",
            "values(#{userId},#{ticket},#{status},#{expired})"
    })
    @Options(useGeneratedKeys = true, keyProperty = "id") // 自动生成主键并注入
    int insertLoginTicket(LoginTicket loginTicket);

    @Select({
            "select id,user_id,ticket,status,expired ",
            "from login_ticket where ticket=#{ticket}"
    })
    LoginTicket selectByTicket(String ticket);

    @Update({ // 演示一下动态sql
            "<script> ",
            "update login_ticket set status=#{status} ",
            "where ticket = #{ticket} ",
            "<if test=\"ticket!=null\"> ",
            "and 1=1 ",
            "</if> ",
            "</script> "
    })
    int updateStatus(String ticket, int status);
}
