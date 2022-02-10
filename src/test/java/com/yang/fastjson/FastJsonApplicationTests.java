package com.yang.fastjson;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.yang.fastjson.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootTest
class FastJsonApplicationTests {
    /**
     * 对象 转 JSON
     * JSON 转 对象
     */
    @Test
    void contextLoads() {
        User user = new User();
        user.setAge(12).setName("zs").setSex(1);
        String s = JSON.toJSONString(user);
        System.out.println(s);

        User user1 = JSON.parseObject(s, User.class);
        System.out.println(user1);

        System.out.println("======================");

        User user2 = new User();
        user2.setSex(2).setAge(14).setName("ls");
        ArrayList<User> users = new ArrayList<>();
        users.add(user);
        users.add(user2);
        String s1 = JSON.toJSONString(users);
        System.out.println(s1);

        List<User> users1 = JSON.parseArray(s1, User.class);
        System.out.println(users1);

        System.out.println("======================");

        HashMap<String, Object> map = new HashMap<>();
        map.put("one",user);
        map.put("two",user2);
        String s2 = JSON.toJSONString(map);
        Map<String, Object> stringObjectMap = JSON.parseObject(s2, new TypeReference<Map<String, Object>>() {
        });
        System.out.println(stringObjectMap);

        System.out.println("=====================");
        HashMap<String, Object> map2 = new HashMap<>();
        map.put("one2",user);
        map.put("two2",user2);
        List<Map<String, Object>> listMaps = new ArrayList<>();
        listMaps.add(map);
        listMaps.add(map2);
        System.out.println("2022");

        String s3 = JSON.toJSONString(listMaps);

        List<Map<String, Object>> maps = JSON.parseObject(s3, new TypeReference<List<Map<String, Object>>>(){});
        System.out.println(maps);
        System.out.println(maps.get(0).get("one"));
    }

    @Test
    void test2(){

    }

}
