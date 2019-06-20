package com.example.maoyanwork.utils;



import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*
 examples:

 List<Integer> list1 = Stream.of(1, 2, 3).collect(Collectors.toList());
 List<Integer> list2 = Stream.of(2, 3, 4, 5).collect(Collectors.toList());

 交集
 intersect(list1, list2).forEach(System.out::println);  //2,3

 并集
 union(list1, list2).forEach(System.out::println);      //1,2,3,4,5

 对称差集
 symmetricDifference(list1, list2).forEach(System.out::println);    //1,4,5

 非对称差集
 difference(list1, list2).forEach(System.out::println); //1

*/

/**
 * Location:com.example.maoyanwork.utils
 * Created by zhangpan
 * Date: 2019-06-20
 * Time: 17:20
 * Description:  description: 集合比较操作工具类(交集/并集/差集)
 */
public class CollectionUtil {

    /**
     * 交集
     *
     * @param first
     * @param second
     * @param <E>
     * @return return a Set that contains all elements which the first contains and the second contains
     */
    public static <E> Set<E> intersect(Collection<? extends E> first, Collection<? extends E> second) {
        Set<E> result = new LinkedHashSet<>(first);
        result.retainAll(second);
        return result;
    }

    /**
     * 并集
     *
     * @param first
     * @param second
     * @param <E>
     * @return return a Set that contains all elements of the first and the second
     */
    public static <E> Set<E> union(Collection<? extends E> first, Collection<? extends E> second) {
        Set<E> result = new LinkedHashSet<>(first);
        result.addAll(second);
        return result;
    }

    /**
     * 对称差集
     *
     * @param first
     * @param second
     * @param <E>
     * @return return a Set that contains all non-repeat elements of the first and the second
     */
    public static <E> Set<E> symmetricDifference(Collection<? extends E> first, Collection<? extends E> second) {
        Set<E> result = union(first, second);
        result.removeAll(intersect(first, second));
        return result;
    }

    /**
     * 非对称差集
     *
     * @param first
     * @param second
     * @param <E>
     * @return return a Set that contains all element of the first and doesn'E contain any element of the second
     */
    public static <E> Set<E> difference(Collection<? extends E> first, Collection<? extends E> second) {
        Set<E> result = union(first, second);
        result.removeAll(second);
        return result;
    }

    /**
     * 按指定的comparator对map进行排序
     *
     * @param oriMap
     * @param comparator
     * @param <K>
     * @param <V>
     * @return
     */
    public static <K, V> Map<K, V> sortMap(Map<K, V> oriMap, Comparator<Map.Entry<K, V>> comparator) {
        return oriMap.entrySet()
                .stream()
                .sorted(comparator)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e2, LinkedHashMap::new));
    }

    public static void main(String[] args) {
        List<Integer> list1 = Stream.of(1, 2, 3).collect(Collectors.toList());
        List<Integer> list2 = Stream.of(2, 3, 4, 5).collect(Collectors.toList());

        System.out.println(intersect(list1, list2));

        System.out.println(union(list1, list2));

        System.out.println(symmetricDifference(list1, list2));

        System.out.println(difference(list1, list2));

        Map<String, Integer> map = new HashMap<>();
        map.put("0", 1);
        map.put("1", 1);
        map.put("2", 1);
        map.put("3", 1);
        map.put("4", 1);
        map.put("5", 1);
        map.put("6", 1);
        map.put("7", 1);
        map.put("8", 1);
        map.put("9", 1);
        map.put("10", 1);
        map.put("11", 1);
        map.put("12", 1);
        map.put("13", 1);
        map.put("14", 1);
        map.put("15", 1);
        map.put("16", 1);
        System.out.println(map);
        map = sortMap(map, Comparator.comparingInt(e -> Integer.valueOf(e.getKey())));
        System.out.println(map);
    }


    @Test
    public void diffTest(){
        List<Integer> list1 = Stream.of(1, 2, 3).collect(Collectors.toList());
        List<Integer> list2 = Stream.of(2, 3, 4, 5).collect(Collectors.toList());
        difference(list1,list2).forEach(System.out::println);

    }
}
