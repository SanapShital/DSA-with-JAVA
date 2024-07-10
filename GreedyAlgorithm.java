
// 1.intro
// 2.Activity Selection:-

import java.util.*;*

public class GreedyAlgorithm {
    **
   public static void main(String args[]) {
 * 
 * int start[] = { 1, 3, 0, 5, 8, 5 };
 * int end[] = { 2, 4, 6, 7, 9, 9 };
 * 
 * int maxAct = 0;
 * 
 * ArrayList<Integer> ans = new ArrayList<>();
 * // 1st Activity
 * maxAct = 1;
 * ans.add(0);
 * int lastEnd = end[0];
 * 
 * for (int i = 1; i < end.length; i++) {
 * if (start[i] >= lastEnd) {
 * // max act select
 * maxAct++;
 * ans.add(i);
 * lastEnd = end[i];
 * }
 * }
 * 
 * System.out.println("Maximum Activity:" + maxAct);
 * for (int i = 0; i < ans.size(); i++) {
 * System.out.print("A" + ans.get(i) + " ");
 * 
 * }
 * System.out.println();
 * 
 * }**
}*** // Another Method
**import java.util.*;**

public class GreedyAlgorithm {
    **
   public static void main(String args[]) {
 * 
 * int start[] = { 1, 3, 0, 5, 8, 5 };
 * int end[] = { 2, 4, 6, 7, 9, 9 };
 * 
 * // sorting
 * 
 * int activities[][] = new int[start.length][3];
 * for (int i = 0; i < start.length; i++) {
 * activities[i][0] = i;
 * activities[i][1] = start[i];
 * activities[i][2] = end[i];
 * 
 * }
 * 
 * // lambda function
 * Arrays.sort(activities, Comparator.comparingDouble(o -> o[2]));
 * 
 * int maxAct = 0;
 * 
 * ArrayList<Integer> ans = new ArrayList<>();
 * // 1st Activity
 * maxAct = 1;
 * ans.add(activities[0][0]);
 * int lastEnd = activities[0][2];
 * 
 * for (int i = 1; i < end.length; i++) {
 * if (activities[i][1] >= lastEnd) {
 * // max act select
 * maxAct++;
 * ans.add(activities[i][0]);
 * lastEnd = activities[i][2];
 * }
 * }
 * 
 * System.out.println("Maximum Activity:" + maxAct);
 * for (int i = 0; i < ans.size(); i++) {
 * System.out.print("A" + ans.get(i) + " ");
 * 
 * }
 * System.out.println();
 * 
 * }**
}*** // 2.Fractional Knapsack:
**import java.util.*;**

public class GreedyAlgorithm {
    **
   public static void main(String args[]) {
 * 
 * int val[] = { 60, 100, 120 };
 * int weight[] = { 10, 20, 30 };
 * int w = 50;
 * 
 * double ratio[][] = new double[val.length][2];
 * 
 * for (int i = 0; i < val.length; i++) {
 * ratio[i][0] = i;
 * ratio[i][1] = val[i] / (double) weight[i];
 * 
 * }
 * 
 * Arrays.sort(ratio, Comparator.comparingDouble(o -> o[1]));
 * 
 * int capacity = w;
 * int finalVal = 0;
 * for (int i = ratio.length - 1; i >= 0; i--) {
 * int idx = (int) ratio[i][0];
 * if (capacity >= weight[idx]) {
 * finalVal += val[idx];
 * capacity -= weight[idx];
 * 
 * } else {
 * finalVal += (ratio[i][1] * capacity);
 * capacity = 0;
 * break;
 * }
 * }
 * 
 * System.out.println("Final Value=" + finalVal);
 * 
 * }*
}*** // 3.Minimum Absolute Difference Pairs:-
***
import java.util.*;**

public class GreedyAlgorithm {
    **
   public static void main(String args[]){
 * 
 * //int A[]={1,2,3};
 * //int B[]={2,1,3};
 * 
 * int A[]={4,1,8,7};
 * int B[]={2,3,6,5};
 * 
 * Arrays.sort(A);
 * Arrays.sort(B);
 * int MinDiff=0;
 * 
 * for(int i=0;i<A.length;i++){
 * MinDiff+=Math.abs(A[i]-B[i]);
 * }
 * 
 * System.out.println("Minimum Difference is:"+MinDiff);
 * }*
}**** // 4.Max length chain of Pair:
**import java.util.*;*

public class GreedyAlgorithm {
    *
   public static void main(String args[]) {
 * 
 * int pairs[][] = { { 5, 24 }, { 39, 60 }, { 5, 28 }, { 27, 40 }, { 50, 90 } };
 * 
 * Arrays.sort(pairs, Comparator.comparingDouble(o -> o[1]));
 * 
 * int chainLength = 1;
 * int chainEnd = pairs[0][1];
 * 
 * for (int i = 0; i < pairs.length; i++) {
 * if (pairs[i][0] > chainEnd) {
 * chainLength++;
 * chainEnd = pairs[i][1];
 * 
 * }
 * }
 * 
 * System.out.println("Maximum length of chain:" + chainLength);
 * }*
}*** // 5.Indian Coins:
***import java.util.*;*

public class GreedyAlgorithm {
    *
   public static void main(String args[]) {
 * 
 * Integer coins[]={1,2,5,10,20,50,100,200,500,2000};
 * Arrays.sort(coins,Comparator.reverseOrder());
 * int countOfCoins=0;
 * int amount=100;
 * ArrayList<Integer> ans =new ArrayList<>();
 * 
 * for(int i=0;i<coins.length;i++){
 * 
 * if(coins[i]<=amount){
 * while(coins[i]<=amount){
 * countOfCoins++;
 * ans.add(coins[i]);
 * amount-=coins[i];
 * }
 * }
 * }
 * 
 * System.out.println("Total Minimum count of coins:-"+countOfCoins);
 * 
 * for(int i=0;i<ans.size();i++){
 * System.out.print(ans.get(i)+" ");
 * 
 * }
 * 
 * System.out.println();
 * 
 * }
}***** // 6.job sequence Problem:
**import java.util.*;**

public class GreedyAlgorithm {
    **
    static class job {
        *
        int deadline, profit, id;**

   public job(int i, int d, int p) {
 * id = i;
 * deadline = d;
 * profit = p;
 * 
 * }**
    }**

   public static void main(String args[]) {
 * 
 * int jobInfo[][] = { { 4, 20 }, { 1, 10 }, { 1, 40 }, { 1, 30 } };
 * 
 * ArrayList<job> jobs = new ArrayList<>();
 * 
 * for (int i = 0; i < jobInfo.length; i++) {
 * jobs.add(new job(i, jobInfo[i][0], jobInfo[i][1]));
 * 
 * }
 * 
 * Collections.sort(jobs, (obj1, obj2) -> obj2.profit - obj1.profit);
 * 
 * ArrayList<Integer> seq = new ArrayList<>();
 * int time = 0;
 * 
 * for (int i = 0; i < jobs.size(); i++) {
 * job curr = jobs.get(i);
 * if (curr.deadline > time) {
 * seq.add(curr.id);
 * time++;
 * }
 * 
 * }
 * 
 * System.out.println("Max Jobs:-" + seq.size());
 * for (int i = 0; i < seq.size(); i++) {
 * System.out.println(seq.get(i) + " ");
 * }
 * 
 * System.out.println();
 * 
 * }*
}*

// 7.Chocola Problem

import java.util.*;

public class GreedyAlgorithm {
    public static void main(String args[]) {

        int n = 4, m = 6;
        Integer costVer[] = { 2, 1, 3, 1, 4 };// m-1
        Integer costHor[] = { 4, 1, 2 };// n-1

        Arrays.sort(costVer, Collections.reverseOrder());
        Arrays.sort(costHor, Collections.reverseOrder());

        int h = 0, v = 0, hp = 1, vp = 1, cost = 0;

        while (h < costHor.length && v < costVer.length) {
            if (costVer[v] <= costHor[v]) {// horizontal cut
                cost += (costHor[h] * vp);
                hp++;
                h++;
            } else {// vertical cut
                cost += (costVer[v] * hp);
                vp++;
                v++;

            }
        }

        while (h < costHor.length) {
            cost += (costHor[h] * vp);
            hp++;
            h++;
        }

        while (v < costVer.length) {
            cost += (costVer[v] * hp);
            vp++;
            v++;
        }

        System.out.println("Minimum Cut of Chocolate:-" + cost);

    }
}
