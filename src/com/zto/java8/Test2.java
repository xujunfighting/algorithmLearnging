package com.zto.java8;

import com.zto.algorithm.TreeNode;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Author xujun
 * Create date 2019-08-21.
 * desc:
 */
public class Test2 {
    public static void main(String[] args) {
        List<TreeNode> maps=new ArrayList<>();
        maps.add(new TreeNode(1));
        maps.add(new TreeNode(1));
        maps.add(new TreeNode(3));
        maps.add(new TreeNode(4));
        //Map<Integer,List<TreeNode>> nodes=getMap(maps);
        List<Integer> integers=new ArrayList<>();
        integers.add(1);
        integers.add(3);
        integers.add(4);
        List<TreeNode> lists=getFilterList(maps,integers);
        System.out.println("123");
        Thread thread=new Thread(()->{

        });
    }
    public static Map<Integer,List<TreeNode>>  getMap(List<TreeNode> lists){

        Map<Integer,List<TreeNode>> maps=lists.stream().collect(Collectors.groupingBy(TreeNode::getVal
        ));
                return maps;
    }
    public static List<TreeNode> getFilterList(List<TreeNode> lists,List<Integer> values){
        return lists.stream().filter(list->{
           return  values.stream().anyMatch(e->list.getVal()==e
            );
       }).collect(Collectors.toList());
    }

}
