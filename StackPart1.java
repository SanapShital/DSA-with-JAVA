//1.Stack using Arraylist:

import java.util.ArrayList;

public class StackPart1{
    static class Stack{
        static ArrayList<Integer> list=new ArrayList<>();
        public static boolean isEmpty(){
            return list.size()==0;
        }
        //push
        public static void push(int data){
            list.add(data);
        }
        //pop
        public static int pop(){
            if(isEmpty()){
                return -1;
            }
            int top=list.get(list.size()-1);
            list.remove(list.size()-1);
            return top;

        }
        //peek
        public static int peek(){
            return list.get(list.size()-1);
        }
    }

    public static void main(String args[]){
        Stack S=new Stack();
        S.push(1);
        S.push(2);
        S.push(3);

        while(! S.isEmpty()){
            System.out.println(S.peek());
            S.pop();

        }

    }

}

// 2.Stack using linkedList;

import java.util.ArrayList;

public class StackPart1{

    static class Node{
        int data;
        Node next;
        Node(int data){
            this.data=data;
            this.next=null;

        }
    }

    static class Stack{
        static Node head=null;
    
    public static boolean isEmpty(){
        return head==null;
    }
    public static void push(int data){
        Node newNode=new Node(data);
        if(isEmpty()){
            head=newNode;
            return;
        }
        newNode.next=head;
        head=newNode;

    }


//pop
    public static int pop(){
        if(isEmpty()){
            return -1;
        }

        int top=head.data;
        head=head.next;
        return top;

    }

    //peek
    public static int peek(){
        if(isEmpty()){
            return -1;
        }
        return head.data;
    }
}

    public static void main(String args[]){
        Stack S=new Stack();
        S.push(1);
        S.push(2);
        S.push(3);

        while(! S.isEmpty()){
            System.out.println(S.peek());
            S.pop();

    }
}
}

// 3.Stack using collection frameworks

import java.util.*;

public class StackPart1{

    public static void main(String args[]){
        Stack<Integer> S =new Stack<>();
        S.push(1);
        S.push(2);
        S.push(3);

        while(! S.isEmpty()){
            System.out.println(S.peek());
            S.pop();


    }
}
}

// 4.Push at bottom of stack....IMP-Amazon ask que.

import java.util.*;

public class StackPart1{

    public static void PushAtBottom(Stack<Integer> S,int data){
        if(S.isEmpty()){
            S.push(data);
            return;
        }
        int top=S.pop();
        PushAtBottom(S,data);
        S.push(top);
    }

    public static void main(String args[]){
        Stack<Integer> S =new Stack<>();
        S.push(1);
        S.push(2);
        S.push(3);

       PushAtBottom(S,4);
       while(! S.isEmpty()){
        System.out.println(S.pop());


    }
}
}

// 5.Reverse string using stack---Flipcart,amazon,paytm,micro

import java.util.*;

public class StackPart1{

    public static String ReverseString(String str){
        Stack<Character> S=new Stack<>();
        int idx=0;
        while(idx<str.length()){
            S.push(str.charAt(idx));
            idx++;
        }
        StringBuilder result=new StringBuilder("");
        while(!S.isEmpty()){
            char curr=S.pop();
            result.append(curr);

        }
        return result.toString();

    }

    public static void main(String args[]){
        String str="Hello,Shital!";
        String result=ReverseString(str);
        System.out.println(result);

    }
}

// 6.Reverse a Stack

import java.util.*;

public class StaticPart1{

    public static void PushAtBottom(Stack<Integer> S,int data){
        if(S.isEmpty()){
            S.push(data);
            return;
        }
        int top=S.pop();
        PushAtBottom(S,data);
        S.push(top);
    }

    public static void ReverseStack(Stack<Integer> S){
        if(S.isEmpty()){
            return;
        }
        int top=S.pop();
        ReverseStack(S);
        PushAtBottom(S,top);

    }

    public static void PrintStack(Stack<Integer> S){
        while(!S.isEmpty()){
            System.out.println(S.pop());
        }
    }
    public static void main(String args[]){
        Stack<Integer> S =new Stack<>();
        S.push(1);
        S.push(2);
        S.push(3);

       // PrintStack(S);
        ReverseStack(S);
        PrintStack(S);

    }
}

// VIMP7.Stock Span Problem:- Span:- max no.of consecutive days which
// price<=todays price.
import java.util.*;

public class StackPart1{

    public static void StockSpanProblem(int Stocks[],  int span[]){

        Stack<Integer> S = new Stack<>();
        span[0]=1;
        S.push(0);

        for(int i=1;i<Stocks.length;i++){
            int currPrice=Stocks[i];
            while(!S.isEmpty()&&currPrice>Stocks[S.peek()]){
                S.pop();
            }
            if(S.isEmpty()){
                span[i]=i+1;
            }else{
                int prevHigh=S.peek();
                span[i]=i-prevHigh;
            }
            S.push(i);
        }
    }

    public static void main(String args[]){

        int Stocks[]={100,80,60,70,60,85,100};
        int span[]= new int[Stocks.length];
        StockSpanProblem(Stocks,span);


        for(int i=0;i<Stocks.length;i++){
            System.out.println(span[i]+" ");
        }
    }
}

// VIMP8.Next Greater Element

import java.util.*;

public class StackPart1 {
    public static void main(String args[]) {
        int arr[] = { 6, 8, 0, 1, 3 };
        Stack<Integer> s = new Stack<>();
        int nextGreater[] = new int[arr.length];

        for (int i = arr.length - 1; i >= 0; i--) {
            while (!s.isEmpty() && arr[s.peek()] <= arr[i]) {
                s.pop();
            }
            if (s.isEmpty()) {
                nextGreater[i] = -1;
            } else {
                nextGreater[i] = arr[s.peek()];
            }

            s.push(i);
        }

        for (int i = 0; i < nextGreater.length; i++) {
            System.out.print(nextGreater[i] + " ");

        }
        System.out.println();
    }

}
