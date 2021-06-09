package datastruct.queque;

import java.util.Scanner;

/**
 * @Author: Targue
 * @Date: 2021/6/8-19:49
 * @E-mail: 18961568969@163.com
 * @Description:
 **/
class ArrQueue{
    private int maxSize;
    private int front;
    private int rear;
    private int[] arr;

    //创建队列
    public ArrQueue(int maxSize){
        this.maxSize = maxSize;
        this.arr = new int[maxSize];
        this.front = -1;
        this.rear = -1;//指向队列尾部
    }

    //判断队列是否满
    public boolean isFull(){
        return this.rear == this.maxSize - 1;
    }

    //判断队列空
    public boolean isEmpty(){
        return this.rear == this.front;
    }

    //入队
    public void addQueue(int n ){
        if(this.isFull()){
            System.out.println("队列已经满了，不能加入数据");
            return;
        }
        this.rear++;
        this.arr[this.rear] = n;
    }

    //出队列
    public int popQueue(){
        if(this.isEmpty()){
            throw new RuntimeException("队列为空，不能出队列");
        }
        this.front++;
        return this.arr[this.front];
    }

    //显示队列
    public void showQueue(){
        if(this.isEmpty()){
            System.out.println("队列为空，没有数据可以展示");
            return;
        }
        for(int i=0;i<this.arr.length;i++){
            System.out.println("arr["+i+"]="+this.arr[i]);
        }
    }

    //显示队列的头数据
    public int headQueue(){
        if(this.isEmpty()){
            throw new RuntimeException("队列为空，没有头元素");
        }
        return this.arr[this.front+1];
    }
}


public class ArrayQueue {
    //简单版本，单向的，当一个满队列取出所有元素之后，就不能再存入数据了。
    public static void main(String[] args) {
        ArrQueue arrQueue = new ArrQueue(5);
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
                    arrQueue.showQueue();
                    break;
                case 'a':
                    System.out.println("输入一个数，进行入队");
                    int value = scanner.nextInt();
                    arrQueue.addQueue(value);
                    break;
                case 'g':
                    try{
                        int pop = arrQueue.popQueue();
                        System.out.printf("取出的数据为：%d\n",pop);
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h':
                    try{
                        int head = arrQueue.headQueue();
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
