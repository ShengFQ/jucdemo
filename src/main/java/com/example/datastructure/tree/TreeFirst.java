package com.example.datastructure.tree;

import com.google.gson.Gson;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 * 二叉树的常用算法
 *二叉树这种结构存储数据,便于查找
 * @author fuqiang.sheng
 * @date 2019年08月03日 下午4:36
 */
public class TreeFirst {
    private TreeNode mTree;
    private TreeNode initTree(){
        TreeNode root=new TreeNode(1);
        TreeNode leftFirst=new TreeNode(2);
        TreeNode rightFirst=new TreeNode(3);
        TreeNode oneSecond=new TreeNode(4);
        TreeNode twoSecond=new TreeNode(5);
        TreeNode threeSecond=new TreeNode(6);
        TreeNode fourSecond=new TreeNode(7);
        root.left=leftFirst;
        root.right=rightFirst;
        leftFirst.left=oneSecond;
        leftFirst.right=twoSecond;
        rightFirst.left=threeSecond;
        rightFirst.right=fourSecond;
        return root;
    }

    public TreeFirst(){
        this.mTree=initTree();
    }

    public TreeNode getmTree(){
        return mTree;
    }

    /**
     * 翻转二叉树,二叉树这种链表结构,只需要抓住root就能输出整个树
     * 反转一颗空树结果还是一颗空树。对于一颗根为 rr，左子树为 \mbox{right}，
     * 右子树为 \mbox{left} 的树来说，它的反转树是一颗根为 rr，
     * 左子树为 \mbox{right} 的反转树，右子树为 \mbox{left} 的反转树的树。
     * **/
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode right = invertTree(root.right);
        TreeNode left = invertTree(root.left);
        root.left = right;
        root.right = left;
        return root;
    }
    public TreeNode invertTrees(TreeNode root) {
        //递归结束条件
        if(root == null || (root.right == null && root.left == null) )
            return root;
        //临时变量记录左右节点地址
        TreeNode left = root.left;
        TreeNode right = root.right;
        //交换左右节点
        root.right = invertTrees(left);
        root.left = invertTrees(right);
        return root;

    }
    /**
     * 翻转二叉树:队列遍历
     * 我们的想法是，我们需要交换树中所有节点的左右子节点。
     * 因此，我们创建一个队列来存储其左右孩子尚未交换的节点。
     * 最初，只有根位于队列中。只要队列不为空，就从队列中取出下一个节点，交换其子节点，然后将子节点添加到队列中。
     * 空节点不添加到队列中。最终，队列将为空并且所有子项都交换，我们返回原始根。
     *
     * */
    public TreeNode invertTree2(TreeNode root) {
        if (root == null) return null;
        // LinkedList实现了集合框架的Queue接口
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root); // 加入元素
        while (!queue.isEmpty()) {
            // 获取并移出元素
            TreeNode current = queue.poll();

            //交换左右子树
            TreeNode temp = current.left;
            current.left = current.right;
            current.right = temp;

            //左子树不为空，将左子树入栈
            if (current.left != null) queue.add(current.left);
            //右子树不为空，将右子树入栈
            if (current.right != null) queue.add(current.right);
        }
        return root;
    }

    /**
     * 翻转二叉树:使用栈
     * */
    public TreeNode invertTree3(TreeNode root) {
        if (root == null) return null;

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);//先将根节点压入堆栈
        while (stack.size() > 0) {
            //根据栈的先进后出操作，获取栈中最后一个元素，即最先入栈的元素
            TreeNode temp = stack.lastElement();
            stack.pop();//弹出栈顶元素

            //交换左右子树
            TreeNode tempLeft = temp.left;
            temp.left = temp.right;
            temp.right = tempLeft;

            //左子树不为空，将左子树入栈
            if (temp.left != null) {
                stack.push(temp.left);
            }
            //右子树不为空，将右子树入栈
            if (temp.right != null) {
                stack.push(temp.right);
            }
        }
        return root;
    }
    /**
     * 二叉树展开为链表
     * 递归写法
     * */
    public void flatten1(TreeNode root) {
        if(root == null) return;
        flatten1(root.left);
        flatten1(root.right);
        TreeNode tmp = root.right;
        root.right = root.left;
        root.left = null;
        while(root.right != null) {
            root = root.right;
        }
        root.right = tmp;
    }

    /**
     * 二叉树展开为链表
     * 非递归写法
     * */
    public void flatten2(TreeNode root) {
        Stack<TreeNode> stack = new Stack();
        while (root != null || !stack.isEmpty()){
            while (root != null){
                stack.push(root);
                root = root.left;
            }

            if (!stack.isEmpty()){
                TreeNode node = stack.pop();
                TreeNode tmp = node.right;
                node.right = node.left;
                node.left = null;

                while(node.right != null) {
                    node = node.right;
                }
                node.right = tmp;
                root = tmp;
            }
        }
    }


    /**
     * 二叉树的遍历
     * 业务: 前序、中序、后序、层次遍历
     * 方式:递归/非递归
     * */
    //前序遍历
    public void treePrint1(TreeNode treeNode, List<Integer> data){
        if(treeNode==null){
            return;
        }
        System.out.printf("value:{%d}",treeNode.val);
        if(data!=null){
            data.add(treeNode.val);
        }
        treePrint1(treeNode.left,data);
        treePrint1(treeNode.right,data);
    }
    /**
     * 对于任一结点P：
     *
     * 访问结点P，并将结点P入栈;
     *
     * 判断结点P的左孩子是否为空，若为空，则取栈顶结点并进行出栈操作，并将栈顶结点的右孩子置为当前的结点P，循环至1);
     * 若不为空，则将P的左孩子置为当前的结点P;
     *
     * 直到P为NULL并且栈为空，则遍历结束。
     * */
    //前序遍历的非递归写法,初始化输出根节点,入队列,指针向左,左边完毕,
    public void preOrderTraverse2(TreeNode root) {
        LinkedList<TreeNode> stack = new LinkedList<>();
        TreeNode pNode = root;
        while (pNode != null || !stack.isEmpty()) {
            if (pNode != null) {
                System.out.print(pNode.val+"  ");
                //先加根
                stack.push(pNode);
                //指针转向左节点
                pNode = pNode.left;
            } else { //pNode == null && !stack.isEmpty()
                TreeNode node = stack.pop();
                pNode = node.right;
            }
        }
    }
    //中序遍历
    public void treePrint2(TreeNode treeNode){
        if(treeNode==null){
            return;
        }
        treePrint2(treeNode.left);
        System.out.printf("value:{%d}",treeNode.val);
        treePrint2(treeNode.right);
    }
    /**
     * 对于任一结点P，
     *
     * 若其左孩子不为空，则将P入栈并将P的左孩子置为当前的P，然后对当前结点P再进行相同的处理；
     *
     * 若其左孩子为空，则取栈顶元素并进行出栈操作，访问该栈顶结点，然后将当前的P置为栈顶结点的右孩子；
     *
     * 直到P为NULL并且栈为空则遍历结束
     * */
    //中序遍历的非递归写法
    public void inOrderTraverse2(TreeNode root) {
        LinkedList<TreeNode> stack = new LinkedList<>();
        TreeNode pNode = root;
        while (pNode != null || !stack.isEmpty()) {
            if (pNode != null) {
                stack.push(pNode);
                pNode = pNode.left;
            } else { //pNode == null && !stack.isEmpty()
                TreeNode node = stack.pop();
                System.out.print(node.val+"  ");
                pNode = node.right;
            }
        }
    }

    //后序遍历
    public void treePrint3(TreeNode treeNode){
        if(treeNode==null){
            return;
        }
        treePrint3(treeNode.left);
        treePrint3(treeNode.right);
        System.out.printf("value:{%d}",treeNode.val);
    }
    //层次遍历
    public void treePrint4(TreeNode treeNode){
        if(treeNode==null){
            return;
        }
        Queue<TreeNode> queue=new LinkedList();
        queue.offer(treeNode);
        while(!queue.isEmpty()){
            TreeNode node=queue.remove();
            System.out.printf("value:{%d}",node.val);
            if(node.left!=null){
                queue.offer(node.left);
            }
            if(node.right!=null){
                queue.offer(node.right);
            }
        }
        System.out.printf("queue:{%s}",new Gson().toJson(queue));
    }

    //深度遍历
    public void depthOrderTraverse(TreeNode root) {
        if (root == null) {
            return;
        }
        LinkedList<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            System.out.print(node.val+"  ");
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
    }

    public static void main(String[] args) {
        TreeFirst first=new TreeFirst();
        List<Integer> result=new LinkedList<>();
        System.out.println(first.getmTree());
        //层级遍历:1,2,3,4,5,6,7
        //前序遍历
        System.out.println();
        first.treePrint1(first.mTree,result);
        System.out.println(new Gson().toJson(result));
//        System.out.println();
//        first.preOrderTraverse2(first.mTree);

        //中序遍历
//        System.out.println();
//        first.treePrint2(first.mTree);
        System.out.println();
        first.inOrderTraverse2(first.mTree);
//        //后序遍历
//        System.out.println();
//        first.treePrint3(first.mTree);
//        //层次遍历
//        System.out.println();
//        first.treePrint4(first.mTree);
//        System.out.println();
//        //深度遍历
//        first.depthOrderTraverse(first.mTree);
//        System.out.println();
    }
}
