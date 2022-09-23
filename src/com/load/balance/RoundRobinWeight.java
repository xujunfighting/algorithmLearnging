package com.load.balance;

import com.newChallenge.tree.WeightNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RoundRobinWeight {
    public static void main(String[] args) {
       List<WeightNode> lists=new ArrayList<>();
        lists.add(new WeightNode("a",5));
        lists.add(new WeightNode("b",2));
        lists.add(new WeightNode("c",1));
       for(int i=0;i<8;i++){
           String result = getResult(i, lists);
           System.out.println(result);
       }
    }

    public static String getResult(Integer sequence, List<WeightNode> list){
        Integer maxWight=0;
        Integer minWight=Integer.MAX_VALUE;
        Integer totalWight=0;
        Integer length=list.size();
        Map<String,Integer> maps=new HashMap<>();
        /**
         * 计算总权重 和最大最小权重 如果最大和最小权重相等 直接轮询获取
         */
        for(WeightNode weightNode:list){
            /**
             * 将节点信息填充到新的map集合中 不对原来的集合权重产生影响
             */
            maps.put(weightNode.getNodeName(),weightNode.getWeight());
            maxWight= Math.max(weightNode.getWeight(),maxWight);
            minWight=Math.min(weightNode.getWeight(),minWight);
            totalWight+=weightNode.getWeight();
        }
        if(maxWight>minWight){
           sequence=sequence%totalWight;
           for(int i=0;i<totalWight;i++){
                for(Map.Entry<String,Integer> map:maps.entrySet()){
                    /**
                     * 获取权重值大于0的元素 等于0的表明已经被获取过且次数已满
                     */
                   if(sequence==0&&map.getValue()>0){
                       return map.getKey();
                   }
                   if(map.getValue()>0) {
                       /**
                        * 每次轮询当前选中的节点权重减1
                        */
                       map.setValue(map.getValue()-1);
                       sequence--;
                   }
                }
           }
        }
        return list.get(sequence%length).getNodeName();
    }
}
