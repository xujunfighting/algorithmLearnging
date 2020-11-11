package com.zto.newYear;

import java.util.List;

/**
 * Author xujun
 * Create date 2019-08-20.
 * desc:
 */
public class NodeVist {
    public static void main(String[] args) {

    }
    public List<Node> method(List<Node> lists){
        if(lists.size()!=0){
            for(int i=0;i<lists.size();i++){
                Node node=lists.get(i);
                //node的添加删除字段操作
                method(node.getChildren());
            }
        }
        return lists;
    }
}
