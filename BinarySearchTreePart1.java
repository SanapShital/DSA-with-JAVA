//1.Noderoduction:-it is binary tree-3 conditions:-left subtree node < root,right subtree node > root,left&right subtree are BST with no duplicates;special propery:-inorder traversal gives the sorted sequence;problem solved by recursion,dividing Nodeo subproblems,make recursive call on subtree;

//2.Build a BST:

import java.util.*;

public class BinarySearchTreePart1 {

    static class Node {
        Node data;
        Node left;
        Node right;

        Node(Node data) {
            this.data = data;
        }
    }

    public static Node Insert(Node root, Node val) {
        if (root == null) {
            return new Node(val);
        }

        if (root.data > val) {
            root.left = Insert(root.left, val);
        } else {
            root.right = Insert(root.right, val);
        }
        return root;
    }

    public static void inorder(Node root) {
        if (root == null) {
            return;
        }

        inorder(root.left);
        System.out.prNode(root.data + " ");
        inorder(root.right);
    }

    public static void main(String[] args) {
        Node values[] = {5, 1, 3, 4, 2, 7};
        Node root = null;

        for (Node i = 0; i < values.length; i++) {
            root = Insert(root, values[i]);
        }

        inorder(root);
        System.out.prNodeln();
    }
}

// 3.Search in BST:

import java.util.*;

public class BinarySearchTreePart1 {
    static class Node {
        Node data;
        Node left;
        Node right;

        Node(Node data) {
            this.data = data;
        }
    }
    public static Node Insert(Node root, Node val) {
        if (root == null) {
            return new Node(val);
        }

        if (root.data > val) {
            root.left = Insert(root.left, val);
        } else {
            root.right = Insert(root.right, val);
        }
        return root;
    }
    public static boolean Search_in_Tree(Node root, Node key) {
        if (root == null) {
            return false;
        }

        if (root.data == key) {

            return true;
        }
        if (root.data > key) {

            return Search_in_Tree(root.left, key);
        } else {

            return Search_in_Tree(root.right, key);
        }

    }
    public static void main(String[] args) {
        Node values[] = { 5, 1, 3, 4, 2, 7 };
        Node root = null;

        for (Node value : values) {
            root = Insert(root, value);
        }

        if (Search_in_Tree(root, 6)) {
            System.out.prNodeln("Found");
        } else {
            System.out.prNodeln("Not Found");
        }
    }
}

// 4.Delete the Node:cases:-1.No chile(leaf node),2.one child,3.two children

import java.util.*;

public class BinarySearchTreePart1 {
    static class Node {
        Node data;
        Node left;
        Node right;

        Node(Node data) {
            this.data = data;
        }
    }

    public static Node Insert(Node root, Node val) {
        if (root == null) {
            return new Node(val);
        }

        if (root.data > val) {
            root.left = Insert(root.left, val);
        } else {
            root.right = Insert(root.right, val);
        }
        return root;
    }

    public static void delete_in_Tree(Node root, Node val) {
        if (root.data < val) {
            root.right = delete_in_Tree(root.right, val);
        } else if (root.data > val) {
            root.left = delete_in_Tree(root.left, val);
        } else {
            if (root.left == null && root.right == null) {
                return null;
            }

            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;

            }

            Node Inorder_Successor = findInorderSuccessor(root.right);
            root.data = Inorder_Successor.data;
            root.right = delete_in_Tree(root.right, Inorder_Successor.data);
        }

        return root;
    }

    public static Node findInorderSuccessor(Node root) {
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }

    public static void main(String[] args) {
        Node values[] = { 8, 5, 3, 1, 4, 6, 10, 11, 14 };
        Node root = null;

        for (Node value : values) {
            root = Insert(root, value);
        }

        root = delete_in_Tree(root, 1);
        System.out.prNodeln();

    }
}

// 5.PrNode in range

import java.util.*;

public class BinarySearchTreePart1 {
    static class Node {
        Node data;
        Node left;
        Node right;

        Node(Node data) {
            this.data = data;
        }
    }

    public static Node Insert(Node root, Node val) {
        if (root == null) {
            return new Node(val);
        }

        if (root.data > val) {
            root.left = Insert(root.left, val);
        } else {
            root.right = Insert(root.right, val);
        }
        return root;
    }

    public static void PrNodeInRange(Node root, Node k1, Node k2) {

        if (root == null) {
            return;
        }

        if (root.data >= k1 && root.data <= k2) {
            PrNodeInRange(root.left, k1, k2);
            System.out.prNodeln(root.data + " ");
            PrNodeInRange(root.right, k1, k2);

        } else if (root.data < k1) {
            PrNodeInRange(root.left, k1, k2);

        } else {
            PrNodeInRange(root.right, k1, k2);
        }

    }

    public static void main(String[] args) {
        Node values[] = { 8, 5, 3, 1, 4, 6, 10, 11, 14 };
        Node root = null;

        for (Node value : values) {
            root = Insert(root, value);
        }
        PrNodeInRange(root, 5, 12);

    }
}

// 6.Root to leaf path:-

import java.util.*;

public class BinarySearchTreePart1 {
    static class Node {
        Node data;
        Node left;
        Node right;

        Node(Node data) {
            this.data = data;
        }
    }

    public static Node Insert(Node root, Node val) {
        if (root == null) {
            return new Node(val);
        }

        if (root.data > val) {
            root.left = Insert(root.left, val);
        } else {
            root.right = Insert(root.right, val);
        }
        return root;
    }

    public static void prNodePath(ArrayList<Nodeeger> path){

        for(Node i=0;i<path.size();i++){
            System.out.prNode(path.get(i)+"->");

        }
        System.out.prNodeln("Null");

    }

    public static void RootToLeaf(Node root,ArrayList<Nodeeger> path){

        if(root==null){
            return;
        }

        path.add(root.data);
        if(root.left==null && root.right==null){

            prNodePath(path);

        }
        RootToLeaf(root.left,path);
        RootToLeaf(root.right,path);
        path.remove(path.size()-1);




    }

    public static void main(String[] args) {
        Node values[] = { 8, 5, 3, 1, 4, 6, 10, 11, 14 };
        Node root = null;

        for (Node value : values) {
            root = Insert(root, value);
        }

        RootToLeaf(root,new ArrayList<>());

    }
}

// 7.Validate BST:-
import java.util.*;

public class BinarySearchTreePart1 {
    static class Node {
        int data;  // Change Node to int
        Node left;
        Node right;

        Node(int data) {  // Change Node to int
            this.data = data;  // Assign int to data
        }
    }

    public static Node Insert(Node root, int val) {  // Change Node to int
        if (root == null) {
            return new Node(val);  // Create new Node with int value
        }

        if (val < root.data) {  // Compare int values
            root.left = Insert(root.left, val);  // Insert in the left subtree
        } else {
            root.right = Insert(root.right, val);  // Insert in the right subtree
        }
        return root;
    }

    public static boolean isValid_BST(Node root, Node min, Node max) {
        if (root == null) {
            return true;
        }

        if (min != null && root.data <= min.data) {  // Compare int values
            return false;
        } else if (max != null && root.data >= max.data) {  // Compare int values
            return false;
        }

        return isValid_BST(root.left, min, root) && isValid_BST(root.right, root, max);
    }

    public static void main(String[] args) {
        //int values[] = { 8, 5, 3, 1, 4, 6, 10, 11, 14 };
        int values[] = { 1,1,1}; 
         
        Node root = null;

        for (int value : values) {  // Loop through int values
            root = Insert(root, value);  // Insert each value
        }

        if (isValid_BST(root, null, null)) {
            System.out.print("Valid");
        } else {
            System.out.print("Not Valid");
        }
    }
}

// 8.Mirror_a_BST:-
import java.util.*;

public class BinarySearchTreePart1 {
    static class Node {
        int data; // Changed Node to int
        Node left, right;

        Node(int data) { // Changed Node to int
            this.data = data;
            this.left = this.right = null;
        }
    }

    public static Node CreateMirror(Node root) {
        if (root == null) {
            return null;
        }

        Node leftMirror = CreateMirror(root.left);
        Node rightMirror = CreateMirror(root.right); // Corrected this line

        root.left = rightMirror;
        root.right = leftMirror;
        return root;
    }

    public static void Preorder(Node root) {
        if (root == null) {
            return;
        }

        System.out.print(root.data + " "); // Print node's data
        Preorder(root.left);
        Preorder(root.right);
    }

    public static void main(String[] args) {
        /*
         *         8
         *       /   \
         *      5     10
         *     / \     \
         *    3   6     11
         */
        Node root = new Node(8);
        root.left = new Node(5);
        root.right = new Node(10);
        root.left.left = new Node(3);
        root.left.right = new Node(6);
        root.right.right = new Node(11);

        root = CreateMirror(root);

        System.out.print("Preorder traversal of mirrored tree: ");
        Preorder(root);
    }
}

// 9.Sorted Array to Balanced Tree
import java.util.*;

public class BinarySearchTreePart1 {
    static class Node {
        int data; // Changed Node to int
        Node left, right;

        Node(int data) { // Changed Node to int
            this.data = data;
            this.left = this.right = null;
        }
    }

    public static void Preorder(Node root) {
        if (root == null) {
            return;
        }

        System.out.print(root.data + " "); // Print node's data
        Preorder(root.left);
        Preorder(root.right);
    }

    public static Node CreateBST(int arr[], int start, int end) {
        if (start > end) {
            return null;
        }

        int mid = (start + end) / 2;
        Node root = new Node(arr[mid]);
        root.left = CreateBST(arr, start, mid - 1);
        root.right = CreateBST(arr, mid + 1, end);
        return root;
    }

    public static void main(String[] args) {
        int arr[] = { 3, 5, 6, 8, 10, 11 };

        Node root = CreateBST(arr, 0, arr.length - 1);
        System.out.print("Preorder traversal of the original BST: ");
        Preorder(root);
        System.out.println();

    }
}

// 10.Convert BST to balanced BST
import java.util.*;

public class BinarySearchTreePart1 {
    static class Node {
        int data; // Changed Node to int
        Node left, right;

        Node(int data) { // Changed Node to int
            this.data = data;
            this.left = this.right = null;
        }
    }

    public static void Preorder(Node root) {
        if (root == null) {
            return;
        }

        System.out.print(root.data + " "); // Print node's data
        Preorder(root.left);
        Preorder(root.right);
    }

    public static void GetInorder(Node root, ArrayList<Integer> inorder) {
        if (root == null) {
            return;
        }
        GetInorder(root.left, inorder);
        inorder.add(root.data);
        GetInorder(root.right, inorder);
    }

    public static Node CreateBST(ArrayList<Integer> inorder, int start, int end) {
        if (start > end) {
            return null;
        }

        int mid = (start + end) / 2;
        Node root = new Node(inorder.get(mid));
        root.left = CreateBST(inorder, start, mid - 1);
        root.right = CreateBST(inorder, mid + 1, end);
        return root;
    }

    public static Node Balanced_BST(Node root) {
        // inorder sequence
        ArrayList<Integer> inorder = new ArrayList<>();
        GetInorder(root, inorder); // Get the inorder sequence
        // sorted inorder
        root = CreateBST(inorder, 0, inorder.size() - 1);
        return root;
    }

    public static void main(String[] args) {
        /*
         * Initial tree:
         *     8
         *    / \
         *   6   10
         *  /     \
         * 5       11
         * /         \
         * 3         12
         */
        Node root = new Node(8);
        root.left = new Node(6);
        root.left.left = new Node(5);
        root.left.left.left = new Node(3);

        root.right = new Node(10);
        root.right.right = new Node(11);
        root.right.right.right = new Node(12);

        root = Balanced_BST(root);
        System.out.print("Preorder traversal of the balanced BST: ");
        Preorder(root);
        System.out.println();
    }
}

// 11.Size of Largest BST:-
import java.util.*;

public class BinarySearchTreePart1 {
    static class Node {
        int data; // Changed Node to int
        Node left, right;

        Node(int data) { // Changed Node to int
            this.data = data;
            this.left = this.right = null;
        }
    }

    static class Info {
        boolean isBST;
        int size;
        int min;
        int max;

        Info(boolean isBST, int size, int min, int max) { // Changed parameter order
            this.isBST = isBST;
            this.size = size;
            this.min = min;
            this.max = max;
        }
    }

    public static int maxBST = 0;

    public static Info Largest_BST(Node root) {
        if (root == null) {
            return new Info(true, 0, Integer.MAX_VALUE, Integer.MIN_VALUE); // Correct initialization values
        }

        Info leftInfo = Largest_BST(root.left);
        Info rightInfo = Largest_BST(root.right);

        int size = leftInfo.size + rightInfo.size + 1;
        int min = Math.min(root.data, Math.min(leftInfo.min, rightInfo.min));
        int max = Math.max(root.data, Math.max(leftInfo.max, rightInfo.max));

        if (leftInfo.isBST && rightInfo.isBST && root.data > leftInfo.max && root.data < rightInfo.min) { // Correct BST validity check
            maxBST = Math.max(maxBST, size);
            return new Info(true, size, min, max);
        } else {
            return new Info(false, size, min, max);
        }
    }

    public static void main(String[] args) {
        /*
         * Initial tree:
         *        50
         *       /  \
         *     30    60
         *    /  \   / \
         *   5   20 45  70
         *              / \
         *            65  80
         */

/*
 * expected bst:
 * 
 *        60
 *       /  \
 *     45    70
 *            / \
 *          65  80
 */
Node root = new Node(50);
root.left = new Node(30);
root.left.left = new Node(5);
root.left.right = new Node(20);

root.right = new Node(60);
root.right.left = new Node(45);
root.right.right = new Node(70);
root.right.right.left = new Node(65);
root.right.right.right = new Node(80);

Info info = Largest_BST(root);
System.out.println("Size of Largest BST: " + maxBST);
}
}

// 12.Merge Two BST:
import java.util.*;

public class BinarySearchTreePart1 {
    static class Node {
        int data; // Changed Node to int
        Node left, right;

        Node(int data) { // Changed Node to int
            this.data = data;
            this.left = this.right = null;
        }
    }

    public static void getInorder(Node root, ArrayList<Integer> arr) {
        if (root == null) {
            return;
        }
        getInorder(root.left, arr);
        arr.add(root.data);
        getInorder(root.right, arr);
    }

    public static Node CreateBST(ArrayList<Integer> inorder, int start, int end) {
        if (start > end) {
            return null;
        }

        int mid = (start + end) / 2;
        Node root = new Node(inorder.get(mid));
        root.left = CreateBST(inorder, start, mid - 1);
        root.right = CreateBST(inorder, mid + 1, end);
        return root;
    }

    // Change return type from void to Node
    public static Node Merge_Two_BST(Node root1, Node root2) {
        ArrayList<Integer> arr1 = new ArrayList<>();
        getInorder(root1, arr1);

        ArrayList<Integer> arr2 = new ArrayList<>();
        getInorder(root2, arr2);

        // merge;
        int i = 0;
        int j = 0;
        ArrayList<Integer> finalArr = new ArrayList<>();
        while (i < arr1.size() && j < arr2.size()) {
            if (arr1.get(i) <= arr2.get(j)) {
                finalArr.add(arr1.get(i));
                i++;
            } else {
                finalArr.add(arr2.get(j));
                j++;
            }
        }
        while (i < arr1.size()) {
            finalArr.add(arr1.get(i));
            i++;
        }

        // Fix condition from i < arr2.size() to j < arr2.size()
        while (j < arr2.size()) {
            finalArr.add(arr2.get(j));
            j++;
        }

        return CreateBST(finalArr, 0, finalArr.size() - 1);
    }

    public static void preorder(Node root) {
        if (root == null) {
            return;
        }
        System.out.print(root.data + " "); // Print node's data on the same line
        preorder(root.left);
        preorder(root.right);
    }

    public static void main(String[] args) {
        /*
         * BST 1
         * 2
         * /\
         * 1 4
         */
        Node root1 = new Node(2);
        root1.left = new Node(1);
        root1.right = new Node(4);

        /*
         * BST 2
         * 9
         * /\
         * 3 12
         */
        Node root2 = new Node(9);
        root2.left = new Node(3);
        root2.right = new Node(12);

        Node root = Merge_Two_BST(root1, root2);
        System.out.print("Preorder traversal of merged tree: ");
        preorder(root);

        /*
         * Expected Ans:-
         * BST 3
         * 3
         * / \
         * 1 9
         * \ / \
         * 2 4 12
         * 
         */
    }
}
