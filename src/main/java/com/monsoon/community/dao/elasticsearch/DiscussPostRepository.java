package com.monsoon.community.dao.elasticsearch;

import com.monsoon.community.entity.DiscussPost;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository // 这里就不能用mapper了，应为mapper是Mybatis专有的注解，这里就是spring认为的一个普通的数据库
public interface DiscussPostRepository extends ElasticsearchRepository<DiscussPost, Integer> { // 处理的类型与主键类型
    // 父接口已实现对ES的增删改查业务，所以不需要在里面写任何业务代码
}
