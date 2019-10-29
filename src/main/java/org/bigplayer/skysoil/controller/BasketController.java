package org.bigplayer.skysoil.controller;

import lombok.extern.slf4j.Slf4j;
import org.bigplayer.skysoil.service.impl.SkySoilServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;



@Slf4j
@RestController
@RefreshScope
@RequestMapping("/double")
@SuppressWarnings("all")
public class BasketController {
    @Autowired
    SkySoilServiceImpl skySoilService;

    /**
     * 双色球数据
     */
    @PostMapping("/getData")
    public void getData() {
        skySoilService.getDoubleData();
    }

    /**
     * 3D数据
     */
    @PostMapping("/getThreeData")
    public void getThreeData() {
        skySoilService.getThreeData();
    }

    /**
     * 日历
     */
    @PostMapping("/getDryData")
    public void getDryData() {
        skySoilService.getDryData();
    }

















    public static void main(String[] args){
//          String[] ss= {"2","34","56","2","1"};
//        Stream<String> strs=Arrays.stream(ss);
//        ArrayList<Integer> m ;
//        strs.max(String :: compareTo).ifPresent(System.out::println);
//         List<String> as= Arrays.asList(ss) ;
//         Stream<String> str= as.stream().sorted(String::compareTo);
//        str.forEach(s-> System.out.println(s));
//         //最小值
//        Stream<String> min=Arrays.stream(ss);
//        Optional optional= min.min(String :: compareTo);
//        System.out.println(optional.get());

        List<Integer> lists = new ArrayList<>();
        lists.add(1);
        lists.add(2);
        lists.add(3);
        lists.add(4);
        lists.add(5);
        lists.add(6);
//        //求和
//        Optional<Integer> sum = lists.stream().reduce((a, b) -> a + b);
//        if (sum.isPresent()) System.out.println("list的总和为:" + sum.get());
//       //（同）求和
//        Integer sum2 = lists.stream().reduce(0, (a, b) -> a + b);//21
//        System.out.println("list的总和为:" + sum2);
//        // 求指定算法
//        Integer product3 = lists.stream().reduce(1, (a, b) -> {
//            if (b % 2 == 0) return a * b; else return a;
//        });
//        System.out.println("list的偶数的积为:" + product3);//48
        //并行流处理
         Integer  i = lists.parallelStream().reduce(0,(a,b)->a+b);//获取并行流
         System.out.println("list的总和为:" + i);
//        forEach()方法不一定会保留并行流的顺序，如果在对并行流的每个元素执行操作时，也希望保留顺序，那么可以使用forEachOrdered()方法，
        lists.parallelStream().forEachOrdered(System.out::println);//并行流有序遍历

   // 映射
        List<Integer> listz = new ArrayList<>();
        listz.add(1);
        listz.add(2);
        listz.add(3);
        Stream<Integer> maps= listz.parallelStream().map( a ->a*2);
//        Integer m= maps.reduce(1,(a,b)->a*b);
//        System.out.println("productMap:"+m);
//        //收集 把流收集到set
//        lists.parallelStream().collect(Collectors.toSet());

        //迭代器
        while (lists.listIterator().hasNext())
        System.out.println("迭代"+lists.listIterator().next());




    }
}