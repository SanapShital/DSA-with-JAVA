//Arraylist-inbuilt data_structure;Linear_DS;JAVA collection framework;

//1.Introduction,syntax,package:

import java.util.ArrayList;
import java.util.*;

public class ArrayList{

    public static void main(String args[]){
        ArrayList<Integer> list =new ArrayList<>();
        ArrayList<String> list1 =new ArrayList<>();
        ArrayList<Boolean> list2 =new ArrayList<>();

    }
}
// 2.Operation on ArrayList:Add,Get,Remove,Contains Element;Set element at
// index;
// ...1)AddElement:

import java.util.ArrayList;

public class Arraylist{

    public static void main(String args[]){
        ArrayList<Integer> list =new ArrayList<>();
        ArrayList<String> list1 =new ArrayList<>();
        ArrayList<Boolean> list2 =new ArrayList<>();
        //Add Element
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);

        //Get Element
        int element=list.get(2);
        System.out.println(element);

        System.out.println(list);

        list.remove(2);
        System.out.println(list);

        list.set(2,10);
        System.out.println(list);

        //contains
        System.out.println(list.contains(1));
        System.out.println(list.contains(11));


    }
}

// 3.Size of ArrayList
import java.util.ArrayList;

public class Arraylist{
public static void main(String args[]){

    ArrayList<Integer> list=new ArrayList<>();

    list.add(1);
    list.add(2);
    list.add(3);
    list.add(4);

    System.out.println(list.size());

    //print the arraylist

    for(int i=0;i<list.size();i++){
        System.out.print(list.get(i) + " ");
    }
    System.out.println();
}
}

// 4.Print the reverse of arraylist
import java.util.ArrayList;

public class Arraylist{

    public static void main(String args[]){
        ArrayList<Integer> list = new ArrayList<>();

        list.add(1);
        list.add(2);
        list.add(4);
        list.add(3);
        list.add(7);


        //Reverse array
        for(int i=list.size()-1;i>=0;i--){
            System.out.print(list.get(i) + " ");
        }
        System.out.println();

    }
}

// 5.Find maximum in arraylist
import java.util.ArrayList;

public class Arraylist{
    public static void main(String args[]){

        ArrayList<Integer> list = new ArrayList<>();

        list.add(2);
        list.add(5);
        list.add(9);
        list.add(6);
        list.add(8);

        int max=Integer.MIN_VALUE;
        for(int i=0;i<list.size();i++){
           // if(max<list.get(i)){
               // max=list.get(i);

               max=Math.max(max,list.get(i));     //another method
            }
       // }

        System.out.println("Max Element is " + max);
        


    }
}

// 6.Swap the numbers
import java.util.ArrayList;

public class Arraylist{

    public static void SwapNumbers(ArrayList<Integer> list,int idx1,int idx2){
        int temp=list.get(idx1);
        list.set(idx1,list.get(idx2));
        list.set(idx2,temp);
    }

    public static void main(String args[]){

        ArrayList<Integer> list = new ArrayList<>();

        list.add(2);
        list.add(5);
        list.add(9);
        list.add(3);
        list.add(6);

        int idx1=1,idx2=3;

        System.out.println(list);
        SwapNumbers(list,idx1,idx2);
        System.out.println("------------------");
        System.out.println(list);
    }
}

// 7.Sorting an Arraylist

import java.util.ArrayList;
import java.util.Collections;

public class Arraylist{

    public static void SwapNumbers(ArrayList<Integer> list,int idx1,int idx2){
        int temp=list.get(idx1);
        list.set(idx1,list.get(idx2));
        list.set(idx2,temp);

    }
    public static void main(String args[]){

        ArrayList<Integer> list = new ArrayList<>();
        
        list.add(2);
        list.add(5);
        list.add(9);
        list.add(3);
        list.add(6);
        System.out.println(list);
        Collections.sort(list);  //Ascending order
        System.out.println("--------------");
        System.out.println(list);

        //descending order;
        System.out.println("--------------");
        Collections.sort(list,Collections.reverseOrder());
        System.out.println(list);



    }
}

// 8.Multidimensional Arraylist

import java.util.ArrayList;
import java.util.Collections;

public class Arraylist{

    public static void SwapNumbers(ArrayList<Integer> list,int idx1,int idx2){
        int temp=list.get(idx1);
        list.set(idx1,list.get(idx2));
        list.set(idx2,temp);

    }

    public static void main(String args[]){
        ArrayList<ArrayList<Integer>> mainList = new ArrayList<>();
        ArrayList<Integer> list=new ArrayList<>();
        list.add(1);
        list.add(2);
        mainList.add(list);
        
        ArrayList<Integer> list2=new ArrayList<>();
        list2.add(3);
        list2.add(4);
        mainList.add(list2);

        for(int i=0;i<mainList.size();i++){
            ArrayList<Integer> currlist=mainList.get(i);
            for(int j=0;j<currlist.size();j++){
                System.out.print(currlist.get(j) + " ");
            }
            System.out.println();

        }
        System.out.println(mainList);
    }
}

// ..............................Another
// Method.......................................................

import java.util.ArrayList;
import java.util.Collections;

public class Arraylist{
    public static void main(String args[]){
        ArrayList<ArrayList<Integer>> mainList = new ArrayList<>();
        ArrayList<Integer> list1=new ArrayList<>();
        ArrayList<Integer> list2=new ArrayList<>();
        ArrayList<Integer> list3=new ArrayList<>();

        for(int i=1;i<=5;i++){
            list1.add(i*1);
            list2.add(i*2);
            list3.add(i*3);

        }
        mainList.add(list1);
        mainList.add(list2);
        mainList.add(list3);

        System.out.println(mainList);

        //nested loops
        for(int i=0;i<mainList.size();i++){
            ArrayList<Integer> currlist=mainList.get(i);
            for(int j=0;j<currlist.size();j++){
                System.out.print(currlist.get(j)+ " ");
            }

            System.out.println();
        }
    }
}

// 9.Container with Most water

import java.util.ArrayList;

public class Arraylist{
    public static int StoreWater(ArrayList<Integer> height){
        int maxWater=0;

        //Brute Force===O(n^2)
        for(int i=0;i<height.size();i++){
            for(int j=i+1;j<height.size();j++){
                int ht=Math.min(height.get(i),height.get(j));
                int width=j-i;
                int currWater=ht*width;
                maxWater=Math.max(maxWater,currWater);
            }
        }
        return maxWater;
    }

    public static void main(String args[]){
        ArrayList<Integer> height=new ArrayList<>();

        height.add(1);
        height.add(8);
        height.add(6);
        height.add(2);
        height.add(5);
        height.add(4);
        height.add(8);
        height.add(3);
        height.add(7);

        System.out.println(StoreWater(height));
    }
}

// ---------------AnotherMethod------------------
// Two pointer Approach===O(n)

import java.util.ArrayList;

public class Arraylist{

        public static int StoreWater(ArrayList<Integer> height){
            int maxWater=0;
            int lp=0;
            int rp=height.size()-1;

            while(lp<rp){
                //cal water area
                int ht=Math.min(height.get(lp),height.get(rp));
                int width=rp-lp;

                int currWater=ht * width;
                maxWater=Math.max(maxWater,currWater);

                //Update Pointer

                if(height.get(lp)<height.get(rp)){
                    lp++;
                }else{
                    rp--;
                }

            }
            return maxWater;
        }
    
        public static void main(String args[]){
            ArrayList<Integer> height=new ArrayList<>();
    
            height.add(1);
            height.add(8);
            height.add(6);
            height.add(2);
            height.add(5);
            height.add(4);
            height.add(8);
            height.add(3);
            height.add(7);
    
            System.out.println(StoreWater(height));
        }

    }

// 10.Pair sum1
// find if any pair in sorted arraylist has target sum.
// list=[1,2,3,4,5,6],target=5;

import java.util.ArrayList;

public class Arraylist{
    //Brute Force

    public static boolean PairSum1(ArrayList<Integer> list,int target){

        for(int i=0;i<list.size()-1;i++){
            for(int j=i+1;j<list.size();j++){
                if(list.get(i)+list.get(j)==target){
                    return true;
                }
            }
        }

        return false;
    }

    public static void main(String args[]){
        ArrayList<Integer> list=new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        int target=12;
        System.out.println(PairSum1(list,target));

    }
}

------------AnotherMethod--------------------
// Two pointer Approach:-

import java.util.ArrayList;

public class Arraylist {

    public static boolean PairSum1(ArrayList<Integer> list, int target) {
        int lp = 0;
        int rp = list.size() - 1;
        while (lp != rp) {
            // case1
            if (list.get(lp) + list.get(rp) == target) {
                return true;
            }

            // case2
            if (list.get(lp) + list.get(rp) < target) {
                lp++;
            } else {
                rp--;
            }
        }
        return false;
    }

    public static void main(String args[]) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        int target = 5;
        System.out.println(PairSum1(list, target));

    }
}

// 11.Pair_Sum2
// find if any pair in sorted & rotated arraylist has target sum.
// list=[11,5,6,8,9,10],target=16;

import java.util.ArrayList;

public class Arraylist{

    public static boolean PairSum2(ArrayList<Integer> list,int target){

        int bp=-1;
        int n=list.size()-1;
        for(int i=0;i<list.size()-1;i++){
            if(list.get(i)>list.get(i+1)){
                bp=i;
                break;
            }
        }

        int lp=bp+1;
        int rp=bp;

        while(lp!=rp){
            //case1
            if(list.get(lp)+list.get(rp)==target){
                return true;
            }

            //case2

            if(list.get(lp)+list.get(rp)<target){
                lp=(lp+1)%n;
            }else{
                rp=(n+rp-1)%n;
            }
        }

        return false;
    }

    
    public static void main(String args[]){
        ArrayList<Integer> list=new ArrayList<>();
        list.add(11);
        list.add(15);
        list.add(6);
        list.add(8);
        list.add(9);
        list.add(10);
        int target=16;
        System.out.println(PairSum2(list,target));

    }
}
