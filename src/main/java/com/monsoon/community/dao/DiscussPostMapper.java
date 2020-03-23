package com.monsoon.community.dao;

import com.monsoon.community.entity.DiscussPost;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface DiscussPostMapper {

    /**
     * userId可能会传也可能不会，不传的时候就不用管，传了的话就用传的id，sql里会动态生成
     */
    List<DiscussPost> selectDiscussPosts(int userId, int offset, int limit);

    /**@Param给参数取别名
     * 如果只有一个参数，并且在<if>里使用，就必须加别名
     * 如果需要动态拼一个条件，并且这个方法有且只有这一个条件，这个时候参数前面必须取别名
     */
    int selectDiscussPostRows(@Param("userId") int userId);
}
