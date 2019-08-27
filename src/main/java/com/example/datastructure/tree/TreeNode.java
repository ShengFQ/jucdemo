package com.example.datastructure.tree;

import com.google.gson.Gson;

/**
 * 定义一个二叉树,二叉树这种数据结构可以用于存储站点信息,
 * 实际意义中的分支结构:菜单,组织,导航站点都可以用树存储,
 * 基于树的算法也很多,有遍历二叉树,翻转二叉树,最短路径计算,
 * 树一般用链表实现 表示算术表达式
 * @author fuqiang.sheng
 * @date 2019年08月03日 下午4:34
 */
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode(int x){
        this.val=x;
    }
    public TreeNode(int x,TreeNode left,TreeNode right){
        this.val=x;
        this.left=left;
        this.right=right;
    }


    @Override
    public String toString() {
        //按前序遍历打印结果
        return new Gson().toJson(this);
    }
}
