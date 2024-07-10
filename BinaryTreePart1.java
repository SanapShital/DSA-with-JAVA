//1.Intro 
//2.Build Tree Preorder Code:

import java.util.*;

public class BinaryTreePart1 {
    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }

    }

    static class BinaryTree {
        static int idx = -1;

        public static Node BuildTree(int nodes[]) {

            idx++;
            if (nodes[idx] == -1) {
                return null;
            }

            Node newNode = new Node(nodes[idx]);
            newNode.left = BuildTree(nodes);
            newNode.right = BuildTree(nodes);

            return newNode;

        }
    }

    public static void main(String args[]) {

        int nodes[] = { 1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1 };
        BinaryTree tree=new BinaryTree();
        Node root=tree.BuildTree(nodes);
        System.out.println(root.data);
    }
}

// 3.Tree Traversal
// a)Preorder:-root,left,right;

import java.util.*;

public class BinaryTreePart1 {
    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }

    }

    static class BinaryTree {
        static int idx = -1;

        public static Node BuildTree(int nodes[]) {

            idx++;
            if (nodes[idx] == -1) {
                return null;
            }

            Node newNode = new Node(nodes[idx]);
            newNode.left = BuildTree(nodes);
            newNode.right = BuildTree(nodes);

            return newNode;

        }

        public static void preorder(Node root){
            if(root==null){
                return;
            }
            System.out.print(root.data+" ");
            preorder(root.left);
            preorder(root.right);
        }
    }

    public static void main(String args[]) {

        int nodes[] = { 1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1 };
        BinaryTree tree=new BinaryTree();
        Node root=tree.BuildTree(nodes);
        tree.preorder(root);

    }
}

// inorder:-left,root,right;
import java.util.*;

public class BinaryTreePart1 {
    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }

    }

    static class BinaryTree {
        static int idx = -1;

        public static Node BuildTree(int nodes[]) {

            idx++;
            if (nodes[idx] == -1) {
                return null;
            }

            Node newNode = new Node(nodes[idx]);
            newNode.left = BuildTree(nodes);
            newNode.right = BuildTree(nodes);

            return newNode;

        }

        public static void inorder(Node root){
            if(root==null){
                return;
            }
           
            inorder(root.left);
            System.out.print(root.data+" ");
            inorder(root.right);
        }
    }

    public static void main(String args[]) {

        int nodes[] = { 1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1 };
        BinaryTree tree=new BinaryTree();
        Node root=tree.BuildTree(nodes);
        tree.inorder(root);

    }
}

// postorder:-

import java.util.*;

public class BinaryTreePart1 {
        static class Node {
            int data;
            Node left, right;
    
            Node(int data) {
                this.data = data;
                this.left = null;
                this.right = null;
            }
    
        }
    
        static class BinaryTree {
            static int idx = -1;
    
            public static Node BuildTree(int nodes[]) {
    
                idx++;
                if (nodes[idx] == -1) {
                    return null;
                }
    
                Node newNode = new Node(nodes[idx]);
                newNode.left = BuildTree(nodes);
                newNode.right = BuildTree(nodes);
    
                return newNode;
    
            }
    
            public static void postorder(Node root){
                if(root==null){
                    return;
                }
               
                postorder(root.left);
                postorder(root.right);
                System.out.print(root.data+" ");
            }
        }
    
        public static void main(String args[]) {
    
            int nodes[] = { 1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1 };
            BinaryTree tree=new BinaryTree();
            Node root=tree.BuildTree(nodes);
            tree.postorder(root);
    
        }
    }

// 4.LevelOrder Traversal:-

import java.util.*;

public class BinaryTreePart1 {
    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }

    }

    static class BinaryTree {
        static int idx = -1;

        public static Node BuildTree(int nodes[]) {

            idx++;
            if (nodes[idx] == -1) {
                return null;
            }

            Node newNode = new Node(nodes[idx]);
            newNode.left = BuildTree(nodes);
            newNode.right = BuildTree(nodes);

            return newNode;

        }

        public static void postorder(Node root){
            if(root==null){
                return;
            }
           
            postorder(root.left);
            postorder(root.right);
            System.out.print(root.data+" ");
        }

        //level order traversal:
        public static void levelorder(Node root){
            if(root==null){
                return;
            }

            Queue<Node> q=new LinkedList<>();
            q.add(root);
            q.add(null);

            while(!q.isEmpty()){
                Node currNode=q.remove();
                if(currNode==null){
                    System.out.println();
                    if(q.isEmpty()){
                        break;
                    }else{
                        q.add(null);
                    }
                }else{
                    System.out.print(currNode.data+" ");
                    if(currNode.left!=null){
                        q.add(currNode.left);
                    }

                    if(currNode.right!=null){
                        q.add(currNode.right);
                    }
                }
            }
        }
    }

    public static void main(String args[]) {

        int nodes[] = { 1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1 };
        BinaryTree tree=new BinaryTree();
        Node root=tree.BuildTree(nodes);
        tree.levelorder(root);

    }
}

// 5.Height of Tree:

import java.util.*;

public class BinaryTreePart1 {
    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }

    }

    public static int HeightCalculate(Node root){
        if(root==null){
            return 0;
        }

        int lh=HeightCalculate(root.left);
        int rh=HeightCalculate(root.right);
        return Math.max(lh,rh)+1;

    }

public static void main(String args[]) {

/*
         * 1
         * /\
         * 2 3
         * /\ /\
         * 4 5 6 7
         * 
    */     
        Node root = new Node(1);
       // root.left = new Node(2);
        //root.right = new Node(3);
       // root.left.left = new Node(4);
       // root.left.right = new Node(5);
        //root.right.left = new Node(6);
       // root.right.right = new Node(7);
        //System.out.println(HeightCalculate(root));

   // }
}


//6.NodeCount:

import java.util.*;

public class BinaryTreePart1 {
    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }

    }

    public static int NodeCount(Node root){
if(root==null){
    return 0;
}

int leftCount=NodeCount(root.left);
int RightCount=NodeCount(root.right);
return leftCount+RightCount+1;


    }

    public static void main(String args[]) {

        /* 
         * 1
         * /\
         * 2 3
         * /\ /\
         * 4 5 6 7
         */
         
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
       root.left.left = new Node(4);
       root.left.right = new Node(5);
        root.right.left = new Node(6);
       root.right.right = new Node(7);
        System.out.println(NodeCount(root));

    }
}

// 7.Sum of Nodes

import java.util.*;

public class BinaryTreePart1 {
    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }

    }

    public static int SumOfNodes(Node root) {
        if (root == null) {
            return 0;
        }

        int leftSum = SumOfNodes(root.left);
        int RightSum = SumOfNodes(root.right);
        return leftSum + RightSum + root.data;

    }

    public static void main(String args[]) {

        /*
         * 1
         * /\
         * 2 3
         * /\ /\
         * 4 5 6 7
         */

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        System.out.println(SumOfNodes(root));

    }
}
