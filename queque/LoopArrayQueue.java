package datastruct.queque;

import java.util.Scanner;

/**
 * @Author: Targue
 * @Date: 2021/6/8-20:17
 * @E-mail: 18961568969@163.com
 * @Description:
 * front需要指向第一个元素
 * rear指向队列最后元素的后一个位置
 * 队列满的时候，(rear+1)%maxsize == front
 * 队列空的时候 rear == front
 **/


class LoopArrQueue{
    private int arr[];
    private int front;
    private int rear;
    private int maxSize;

    public LoopArrQueue(int Size){
        this.maxSize = Size;
        this.front = 0;
        this.rear = 0;
        this.arr = new int[Size];
    }

    //判断是否为空
    public boolean isEmpty(){
        if(this.front == this.rear){
            return true;
        }
        return false;
    }

    //判断是否为满
    public boolean isFull(){
        if((this.rear+1)%this.maxSize == this.front){
            return true;
        }
        return false;
    }

    //入队
    public void addQueue(int n){
        if(this.isFull()){
            System.out.println("队列已满，无法再入队。");
            return;
        }
        this.arr[this.rear] = n;
        this.rear = (this.rear+1)%this.maxSize;

    }

    //出队
    public int popQueue(){
        if(this.isEmpty()){
            throw new RuntimeException("当前队列为空，无法再出队数据。");
        }
        int value = this.arr[this.front];
        this.front = (this.front+1)%this.maxSize;
        return value;
    }

    //打印队列
    public void showQueue(){
        if(this.isEmpty()){
            System.out.println("队列为空。");
            return;
        }
        int front = this.front;
        while(front != this.rear){
            System.out.println("arr["+front+"]"+"="+this.arr[front]);
            front = (front+1)%this.maxSize;
        }
    }

    //取得队首元素
    public int headQueue(){
        if(this.isEmpty()){
            throw new RuntimeException("队列为空，无队首元素");
        }
        return this.arr[this.front];
    }
}

public class LoopArrayQueue {

    public static void main(String[] args) {
        LoopArrQueue loopArrQueue = new LoopArrQueue(5);
        char key = ' ';
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;
        while(loop){
            System.out.println("s(show)：显示队列");
            System.out.println("e(exit)：退出程序");
            System.out.println("a(add)：数据入队");
            System.out.println("g(get)：数据出队");
            System.out.println("h(head)：查看队首数据");
            key = scanner.next().charAt(0);
            switch (key){
                case 's':
                    loopArrQueue.showQueue();
                    break;
                case 'a':
                    System.out.println("输入一个数，进行入队");
                    int value = scanner.nextInt();
                    loopArrQueue.addQueue(value);
                    break;
                case 'g':
                    try{
                        int pop = loopArrQueue.popQueue();
                        System.out.printf("取出的数据为：%d\n",pop);
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h':
                    try{
                        int head = loopArrQueue.headQueue();
                        System.out.printf("队列头数据为：%d\n",head);
                    }catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'e':
                    scanner.close();
                    loop = false;
                    break;
                default:
                    break;

            }
        }
    }
}
