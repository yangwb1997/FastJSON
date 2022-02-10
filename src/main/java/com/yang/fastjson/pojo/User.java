package com.yang.fastjson.pojo;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author ：ywb
 * @date ：Created in 2021/10/24 10:26 下午
 * @description：toDo
 */
@Data
@Accessors(chain = true)
public class User {
    private String name;
    private int age;
    private int sex;
}
