// 1.diameter of tree:

*

import java.util.*;**

public class BinaryTreePart2 {
    *
    static class Node {
        *
        int data;*
        Node left, right;**

   Node(int data) {
 * this.data = data;
 * this.left = null;
 * this.right = null;
 * }**
    }*

   public static int HeightCalculate(Node root){
 * if(root==null){
 * return 0;
 * }
 * 
 * int lh=HeightCalculate(root.left);
 * int rh=HeightCalculate(root.right);
 * return Math.max(lh,rh)+1;
 * 
 * }**

   public static int Diameter_Of_Tree(Node root){
 * if(root==null){
 * return 0;
 * }
 * 
 * int leftDia=Diameter_Of_Tree(root.left);
 * int leftHt=HeightCalculate(root.left);
 * int rightDia=Diameter_Of_Tree(root.right);
 * int rightHt=HeightCalculate(root.right);
 * 
 * int selfDiam=leftHt+rightHt+1;
 * return Math.max(selfDiam,Math.max(leftDia,rightDia));
 * 
 * }

   public static void main(String args[]) {
 * 
 * /*
 * 1
 * /\
 * 2 3
 * /\ /\
 * 4 5 6 7
 */
 * 
 * Node root = new Node(1);
 * root.left = new Node(2);
 * root.right = new Node(3);
 * root.left.left = new Node(4);
 * root.left.right = new Node(5);
 * root.right.left = new Node(6);
 * root.right.right = new Node(7);
 * System.out.println(Diameter_Of_Tree( root));
 * 
 * }
 * }
 * //Another Method
 * 
 * 
 * 
 * import java.util.*;
 * 
 * public class BinaryTreePart2 {
 * static class Node {
 * int data;
 * Node left, right;
 * 
 * Node(int data) {
 * this.data = data;
 * this.left = null;
 * this.right = null;
 * }
 * 
 * }
 * 
 * public static int HeightCalculate(Node root){
 * if(root==null){
 * return 0;
 * }
 * 
 * int lh=HeightCalculate(root.left);
 * int rh=HeightCalculate(root.right);
 * return Math.max(lh,rh)+1;
 * 
 * }
 * public static int Diameter_Of_Tree(Node root){
 * if(root==null){
 * return 0;
 * }
 * 
 * int leftDia=Diameter_Of_Tree(root.left);
 * int leftHt=HeightCalculate(root.left);
 * int rightDia=Diameter_Of_Tree(root.right);
 * int rightHt=HeightCalculate(root.right);
 * 
 * int selfDiam=leftHt+rightHt+1;
 * return Math.max(selfDiam,Math.max(leftDia,rightDia));
 * 
 * }
 * 
 * 
 * static class Info{
 * int dia,ht;
 * public Info( int dia,int ht){
 * this.dia= dia;
 * this.ht= ht;
 * 
 * }
 * }
 * 
 * public static Info Diameter_Of_Tree(Node root){
 * 
 * if(root==null){
 * return new Info(0,0);
 * }
 * 
 * Info leftInfo=Diameter_Of_Tree(root.left);
 * Info rightInfo=Diameter_Of_Tree(root.right);
 * 
 * int dia = Math.max(Math.max(leftInfo.dia, rightInfo.dia), rightInfo.ht +
 * leftInfo.ht + 1);
 * 
 * int ht=Math.max(leftInfo.ht,rightInfo.ht)+1;
 * 
 * return new Info(dia,ht);
 * 
 * 
 * }
 * 
 * public static void main(String args[]) {
 * 
 * /*
 * 1
 * /\
 * 2 3
 * /\ /\
 * 4 5 6 7
 */
 * 
 * Node root = new Node(1);
 * root.left = new Node(2);
 * root.right = new Node(3);
 * root.left.left = new Node(4);
 * root.left.right = new Node(5);
 * root.right.left = new Node(6);
 * root.right.right = new Node(7);
 * // System.out.println(Diameter_Of_Tree( root).dia);
 * System.out.println(Diameter_Of_Tree( root).ht);
 * 
 * }
 * }
 * 
 * 
 * 
 * //2.Subtree of another tree:-
 * 
 * import java.util.*;
 * 
 * public class BinaryTreePart2 {
 * static class Node {
 * int data;
 * Node left, right;
 * 
 * Node(int data) {
 * this.data = data;
 * this.left = null;
 * this.right = null;
 * }
 * 
 * }
 * 
 * public static boolean isIdentical(Node node, Node subroot) {
 * if (node == null && subroot == null) {
 * return true;
 * } else if (node == null || subroot == null || node.data != subroot.data) {
 * return false;
 * }
 * if (!isIdentical(node.left, subroot.left)) {
 * return false;
 * }
 * 
 * if (!isIdentical(node.right, subroot.right)) {
 * return false;
 * }
 * 
 * return true;
 * 
 * }
 * 
 * public static boolean IsSubtree(Node root, Node subroot) {
 * if (root == null) {
 * return false;
 * }
 * 
 * if (root.data == subroot.data) {
 * if (isIdentical(root, subroot)) {
 * return true;
 * }
 * }
 * 
 * return IsSubtree(root.left, subroot) || IsSubtree(root.right, subroot);
 * 
 * }
 * 
 * public static void main(String args[]) {
 * 
 * /*
 * 1
 * /\
 * 2 3
 * /\ /\
 * 4 5 6 7
 */
 * 
 * Node root = new Node(1);
 * root.left = new Node(2);
 * root.right = new Node(3);
 * root.left.left = new Node(4);
 * root.left.right = new Node(5);
 * root.right.left = new Node(6);
 * root.right.right = new Node(7);
 * // System.out.println(Diameter_Of_Tree( root).dia);
 * // System.out.println(Diameter_Of_Tree( root).ht);
 * /*
 * //subroot
 * 2
 * /\
 * 4 5
 * */
 * Node subroot = new Node(3);
 * subroot.left = new Node(4);
 * subroot.right = new Node(5);
 * 
 * System.out.println(IsSubtree(root, subroot));
 * 
 }
}

// 3.Top View of tree:VIMP
