package com.example.datastructure.stack;

class Node {
	public int data;
	public Node next;

	public Node(int data, Node next) {
		this.data = data;
		this.next = next;
	}
}

class LinkStack {
	private Node top;
	private int count;

	// 初始化链栈，一个空链表
	public void init() {
		top = null;
		count = 0;
	}

	// 判空
	public boolean isEmpty() {
		return (count == 0);
	}

	// 构造器，构造链栈
	public LinkStack(int data) {
		top = new Node(data, null);
		count++;
	}

	// 获取链栈长度
	public int getLength() {
		return count;
	}

	// 进栈
	public void push(int data) {
		// 因为是链栈也就不用判断大小了。
		top = new Node(data, top);
		count++;
	}

	// 出栈
	public int pop() {
		if (count == 0) {
			System.out.println("栈为空！！");
			return -1;
		} 
		
			Node htempNode = top;
			top = top.next;
			
			htempNode.next = null;
			count--;
			return htempNode.data;
		
	}

	// 获取栈顶元素
	public int getTop() {
		if (count == 0) {
			return -1;
		}
		return top.data;
	}

	// 清空栈
	public void clear() {
		top = null;
		count = 0;
	}

	
}

public class LinkStackList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 以指定第一个元素和底层数组长度的方式构建顺序栈
		LinkStack linkStack = new LinkStack(1);
		System.out.println("当前所含内容" + linkStack);

		// 压入数据元素,元素格式大于了定义栈时底层数组的长度
		linkStack.push(2);
		linkStack.push(3);
		linkStack.push(4);
		// 发现是先入后出的方式打印的
		System.out.println("当前所含内容" + linkStack);
		// 获取栈中元素个数
		System.out.println("当前栈中元素个数是：" + linkStack.getLength());
		// 获取栈顶元素
		System.out.println("当前栈顶元素是：" + linkStack.getTop());

		// 弹出元素
		System.out.println("弹出元素：" + linkStack.pop());
		// 发现是先入后出的方式打印的
		System.out.println("当前所含内容" + linkStack);
		// 获取栈顶元素
		System.out.println("当前栈顶元素是：" + linkStack.getTop());
		// 获取栈中元素个数
		System.out.println("当前栈中元素个数是：" + linkStack.getLength());

		// 判断是否为空栈
		System.out.println("当前栈是否为空：" + linkStack.isEmpty());
		// 清空栈
		linkStack.clear();
		// 判断是否为空栈
		System.out.println("当前栈是否为空：" + linkStack.isEmpty());
		// 获取栈顶元素,空栈时返回null
		System.out.println("当前栈顶元素是：" + linkStack.getTop());
		// 获取栈中元素个数
		System.out.println("当前栈中元素个数是：" + linkStack.getLength());

		// 空栈时进行弹出元素
		System.out.println("弹出元素：" + linkStack.pop());
	}

}
