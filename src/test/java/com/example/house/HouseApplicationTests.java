package com.example.house;

import com.example.house.Config.Md5;
import com.example.house.Dao.DistrictDao;
import com.example.house.Dao.HouseDao;
import com.example.house.Dao.UsersDao;
import com.example.house.Entity.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

@SpringBootTest
class HouseApplicationTests {

    @Autowired
    HouseDao districtDao;

    private final String name = "sd";

    @Test
    void contextLoads() {
        hashTableandhashMap();
    }

    public void hashTableandhashMap() {
        Hashtable<String, String> hashtable = new Hashtable<>();
        HashMap<String, String> map = new HashMap();
        //hashtable方法有synchronized修饰
        hashtable.put(" xasdasda", "asdadads");
//        hashtable.put(null, "asdadads");键不能为空
        hashtable.put("", "sdasdas");//值不能为空
        hashtable.put("", "sdasdas");
        //没有synchronized 效率高
        map.put("sdasd", "sadasda");
        map.put("", "sadasda");
        map.put("", null);
        System.out.println(map.get(""));
        System.out.println(map.size());
        System.out.println(hashtable.size());
        System.out.println(hashtable);
        System.out.println(map);
    }

    public void testList() {
        LinkedList<Integer> linkedlist = new LinkedList<>();
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < 8000; i++) {
            linkedlist.add(i);
            arrayList.add(i);
        }
        long start = System.nanoTime();
            linkedlist.remove(50);
        long twe = System.nanoTime();
            arrayList.remove(50);
        long one = System.nanoTime();
        long Linked = twe - start;
        long Array = one - twe;
        System.out.println("Linked" + Linked);
        System.out.println("Array" + Array);
        if (Array > Linked) {
            System.out.println("Linked更快" + Linked + "" + (Linked - Array));
        } else {
            System.out.println("Array更快" + Array + "差多少" + (Array - Linked));
        }
    }

}
