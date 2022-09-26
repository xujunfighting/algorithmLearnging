package com.load.balance;

import com.newChallenge.tree.WeightNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomWeight {

    public static void main(String[] args) {
        List<WeightNode> lists=new ArrayList<>();
        lists.add(new WeightNode("a",5));
        lists.add(new WeightNode("b",2));
        lists.add(new WeightNode("c",4));
        for(int i=0;i<10;i++){
            System.out.println(getResult(lists));
        }
    }

    public static String getResult(List<WeightNode> lists){
        Boolean sameWight=true;
        Integer totalWight=0;
        Integer preWeight=0;
        Integer curWeight=0;
        for(int i=0;i<lists.size();i++){
            totalWight+=lists.get(i).getWeight();
            if(i>0){
                preWeight=curWeight;
            }
            curWeight=lists.get(i).getWeight();
            if(preWeight!=curWeight){
                sameWight=false;
            }
        }

        if(!sameWight){
            int curRandom=new Random().nextInt(totalWight);
            for(int i=0;i<lists.size();i++){
                curRandom-=lists.get(i).getWeight();
                if(curRandom<=0){
                    return lists.get(i).getNodeName();
                }
            }
        }
        return lists.get(new Random().nextInt(lists.size()-1)).getNodeName();
    }
}
