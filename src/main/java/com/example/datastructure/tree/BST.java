package com.example.datastructure.tree;

/**
 * 文件描述
 *二叉搜索树,为搜索而生,将无序变成有序
 *  每个节点比左节点要大,比右节点要小
 * @author fuqiang.sheng
 * @date 2019年08月08日 下午4:29
 */
public class BST {
    public  TreeNode root;
    public BST(){
        this.root=null;
    }

    /**
     * search
     * */
    public TreeNode search(int key){
        TreeNode current=root;
        while(current!=null && key !=current.val){
            if(key<current.val){
                current=current.left;
            }else{
                current=current.right;
            }
        }
        return current;
    }

    /**
     * insert
     * */
    public TreeNode insert(int key){
        //add node
        TreeNode newNode=new TreeNode(key);
        //currrent node
        TreeNode current=root;
        //preview node
        TreeNode parent=null;
        if(current==null){
            root=newNode;
            return newNode;
        }
        while (true){
            parent=current;
            if(key<current.val){
                current=current.left;
                if(current==null){
                    parent.left=newNode;
                    return newNode;
                }
            }else{
                current=current.right;
                if(current==null){
                    parent.right=newNode;
                    return newNode;
                }
            }
        }
    }
    /**
     * 删除节点
     * */
    public TreeNode delete(int key){
        TreeNode parent=root;
        TreeNode current=root;
        boolean isLeftChild=false;
        //find target node and exist left node
        while(current.val!=key){
            parent=current;
            if(current.val>key){
                isLeftChild=true;
                current=current.left;
            }else{
                isLeftChild=false;
                current=current.right;
            }
            if(current==null){
                return current;
            }
        }

        //if target.left is null,target.right is null
        if(current.left==null && current.right==null){
            if(current==root){
                root=null;
            }
            //in left
            if(isLeftChild==true){
                parent.left=null;
            }else{
                parent.right=null;
            }
        }

        //target has only one child could be right or left
        else if(current.right==null){
            if(current==root){
                root=current.left;
            }else if(isLeftChild){
                parent.left=current.left;
            }else{
                parent.right=current.left;
            }
        }else if(current.left==null){
            if(current==root){
                root=current.right;
            }else if(isLeftChild){
                parent.left=current.right;
            }else {
                parent.right=current.right;
            }
        }

        //if target child all of could not be null
        else if(current.left!=null && current.right!=null){
            // find target
            TreeNode successor=getDeleteSuccessor(current);
            if(current==root){
                root=successor;
            }else if(isLeftChild){
                parent.left=successor;
            }else {
                parent.right=successor;
            }
            successor.left=current.left;
        }
        return current;
    }

    /**
     * 获取删除节点的后继者
     * 删除节点的后继者是其右节点树最小的节点
     * */
    public TreeNode getDeleteSuccessor(TreeNode deleteNode){
        //后继者
        TreeNode successor=null;
        TreeNode successorParent=null;
        TreeNode current=deleteNode.right;
        while(current!=null){
            successorParent=successor;
            successor=current;
            current=current.left;
        }
        //检查后继者(不可能有左节点树)是否有右节点树
        if(successor!=deleteNode.right){
            successorParent.left=successor.right;
            successor.right=deleteNode.right;
        }
        return successor;
    }
    /**
     * 二叉树的遍历
     * */
    public void toString(TreeNode root){
        if(root!=null){
            toString(root.left);
            System.out.print("value="+root.val+"->");
            toString(root.right);
        }
    }

    /**
     * 二叉树的最大深度
     * */
    public int maxDeath(TreeNode node){
        if(node==null){
            return 0;
        }
        int left=maxDeath(node.left);
        int right=maxDeath(node.right);
        return Math.max(left,right)+1;
    }
    /**
     * 二叉树的最小深度
     * */
    public int getMinDepth(TreeNode root){
        if(root==null){
            return 0;
        }
        return getMin(root);
    }

    public int getMin(TreeNode root){
        if(root==null){
            return Integer.MAX_VALUE;
        }
        if(root.left==null && root.right==null){
            return 1;
        }
        return Math.min(getMin(root.left),getMin(root.right))+1;
    }

    /**
     * 如何确定二叉树是否是平衡二叉树
     * */
    public boolean isBalanced(TreeNode node){
        return MaxDeath2(node)!=-1;
    }

    public int MaxDeath2(TreeNode node){
        if(node==null){
            return 0;
        }
        int left=MaxDeath2(node.left);
        int right=MaxDeath2(node.right);
        if(left==-1 || right==-1 || Math.abs(left-right)>1){
            return -1;
        }
        return Math.max(left,right)+1;
    }

    public static void main(String[] args) {
        BST bst=new BST();
        //插入
        TreeNode node1=bst.insert(5);
        TreeNode node2=bst.insert(2);
        TreeNode node3=bst.insert(3);
        TreeNode node4=bst.insert(4);

        //打印
        bst.toString(bst.root);

        //查找
        TreeNode node5=bst.search(2);
        System.out.println("存在:"+node5);

        //删除
        TreeNode node6= bst.delete(5);
        System.out.println("删除:"+node6.val);
        bst.toString(bst.root);
    }
}
