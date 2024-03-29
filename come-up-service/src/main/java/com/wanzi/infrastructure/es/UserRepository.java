package com.wanzi.infrastructure.es;

import com.wanzi.domain.aggregateA.entity.User;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 功能描述:
 *
 * @author: qiu wanzi
 * @date: 2024年3月28日 0028
 * @version: 1.0
 */
@Repository
public interface UserRepository extends ElasticsearchRepository<User, String> {


    List<User> findAllByName(String name);
}
