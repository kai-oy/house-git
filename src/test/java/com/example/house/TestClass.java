package com.example.house;

import com.example.house.Entity.Street;

import java.util.*;

public class TestClass {
    public void palinDromic(String str) {
        char[] chars = str.toCharArray();
        HashMap<Character, Integer> map = new HashMap<>();
        for (char aChar : chars) {
            map.put(aChar, map.get(aChar) == null ? 1 : map.get(aChar) + 1);
        }
        Collection<Integer> values = map.values();
        for (Integer value : values) {
            if (value > 1) {

            }
        }
        System.out.println(map);
        String s = "";
        Set<Character> characters = map.keySet();
        for (Character character : characters) {
            if (map.get(character) > 1) {
                for (Integer i = 0; i < map.get(character); i++) {
                    s += character;
                }
            }
        }
        System.out.println(s);
        System.out.println(map);
    }

    public void testSta() {
        Stack<Integer> stack = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        for (int i = 0; i < 10; i++) {
            addStack(stack, i);
        }
        solution(stack, stack2);
        System.out.println("stack2"+stack2);
        while (!stack2.empty()) {
            Integer pop = stack2.pop();
            System.out.println(pop);
        }
        System.out.println("stack2"+stack2);
    }

    public void addStack(Stack<Integer> stack, Integer integer) {
        stack.push(integer);
    }

    public void solution(Stack<Integer> stack, Stack<Integer> stack2) {
        if (stack.empty() && stack2.empty()) {
            throw new RuntimeException("队列为空");
        }
        if (!stack.empty()) {
            while (!stack.empty()) {
                stack2.push(stack.pop());
            }
        }
    }


    public static String replaceSpace(String[] strs) {
        if (!chechStrs(strs)) {
            return "";
        }// 数组⻓度
        int len = strs.length;
        // ⽤于保存结果
        StringBuilder res = new StringBuilder();// 给字符串数组的元素按照升序排序(包含数字的话，数字会排在前⾯)
        for (String str : strs) {
            System.out.println(str);
        }
        Arrays.sort(strs);
        System.out.println(strs.toString());
        for (String str : strs) {
            System.out.println(str);
        }
        int m = strs[0].length();
        int n = strs[len - 1].length();
        int num = Math.min(m, n);
        for (int i = 0; i < num; i++) {
            if (strs[0].charAt(i) == strs[len - 1].charAt(i)) {
                res.append(strs[0].charAt(i));
            } else
                break;
        }
        return res.toString();
    }

    private static boolean chechStrs(String[] strs) {
        boolean flag = false;
        if (strs != null) {
            for (int i = 0; i < strs.length; i++) {
                if (strs[i] != null && strs[i].length() != 0) {
                    flag = true;
                } else {
                    flag = false;
                    break;
                }
            }
        }
        return flag;
    }

    public String TestStrign(String str, String strTwo) {
        char[] chars = str.toCharArray();
        char[] chars1 = strTwo.toCharArray();
        boolean b = true;
        int strIn = 0;
        int strInTwo = 0;
        while (b) {
            if (strInTwo == chars1.length) {
                b = false;
            } else if (chars[strIn] == chars1[strInTwo]) {
                strIn++;
                strInTwo++;
            } else {
                strIn++;
                strInTwo = 0;
                if (strIn == chars.length) {
                    break;
                }
            }

        }
        return b ? "不存在" : strInTwo + "存在" + strIn;
    }


    public void testStack() {

        Stack stack = new Stack();
        for (int i = 0; i < 10; i++) {
            boolean add = stack.add(i);
        }
        System.out.println(stack);
        for (Object o : stack) {
            System.out.println(o);
        }
        Stack stack2 = new Stack();

        for (int i = 0; i < 10; i++) {
            Object push = stack2.push(i);
        }
        System.out.println(stack2);
    }

    public void testVector() {
        Vector vector = new Vector();
        vector.add("sd");
        System.out.println(vector);
    }

    public void testIterator() {
        ArrayList<Street> list = new ArrayList();
        Street street = new Street(1, "一", 2);
        list.add(street);
        Street street2 = new Street(2, "二", 4);
        list.add(street2);
        Street street3 = new Street(3, "三", 5);
        list.add(street3);
        System.out.println(list);
        for (Street street1 : list) {
            street1.setName("不知道");
        }
        System.out.println(list);
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
        StringBuilder stringBuilder = new StringBuilder();
        StringBuffer stringBuffer = new StringBuffer();
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
