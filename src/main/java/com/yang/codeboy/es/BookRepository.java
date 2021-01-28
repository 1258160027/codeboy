package com.yang.codeboy.es;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author: zl
 * @date: 2020-12-11
 */
public interface BookRepository extends ElasticsearchRepository<Book,Long> {

    Book getById(Long id);
}
