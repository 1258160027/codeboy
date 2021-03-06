package com.yang.codeboy.es;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author: zl
 * @date: 2020-12-11
 */
@Data
@Document(indexName = "index_book",replicas = 0,shards = 1)
public class Book {
    @Id
    private Long id;
    private String name;
    private Float price;
    private String type;
    private Date buyDate;

}
