
//1.Kth level of tree:

import java.util.*;

public class BinaryTreePart3 {
    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }

    }

    public static void Klevel(Node root, int level, int k) {
        if (root == null) {
            return;
        }

        if (level == k) {
            System.out.print(root.data + " ");
            return;
        }

        Klevel(root.left, level + 1, k);
        Klevel(root.right, level + 1, k);
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
        // System.out.println(Diameter_Of_Tree( root).dia);
        // System.out.println(Diameter_Of_Tree( root).ht);
        /*
         * //subroot
         * 2
         * /\
         * 4 5
         */
        Node subroot = new Node(3);
        subroot.left = new Node(4);
        subroot.right = new Node(5);
        // System.out.println(IsSubtree(root, subroot));

        int k = 3;
        Klevel(root, 1, k);

    }
}

// 2.Lowest Common Ancestor:
import java.util.*;

public class BinaryTreePart3 {
    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static boolean getPath(Node root, int n, ArrayList<Node> path) {
        if (root == null) {
            return false;
        }
        path.add(root);

        if (root.data == n) {
            return true;
        }

        if (getPath(root.left, n, path) || getPath(root.right, n, path)) {
            return true;
        }

        path.remove(path.size() - 1);
        return false;
    }

    public static Node Lowest_Common_Ancestor(Node root, int n1, int n2) {
        ArrayList<Node> path1 = new ArrayList<>();
        ArrayList<Node> path2 = new ArrayList<>();

        if (!getPath(root, n1, path1) || !getPath(root, n2, path2)) {
            return null;
        }

        int i;
        for (i = 0; i < path1.size() && i < path2.size(); i++) {
            if (!path1.get(i).equals(path2.get(i))) {
                break;
            }
        }

        return path1.get(i - 1);
    }

    public static void main(String[] args) {
        /*
         *        1
         *       / \
         *      2   3
         *     / \ / \
         *    4  5 6  7
         */

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        int n1 = 4, n2 = 6;
        Node lca = Lowest_Common_Ancestor(root, n1, n2);

        if (lca != null) {
            System.out.println("LCA(" + n1 + ", " + n2 + ") = " + lca.data);
        } else {
            System.out.println("Keys are not present in the tree");
        }
    }
}

// Another Method

import java.util.*;

public class BinaryTreePart3 {
    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static Node lca2(Node root,int n1,int n2){
        if(root==null || root.data!=n1 || root.data!=n2){
            return root;
        }

        Node leftLCA=lca2(root.left,n1,n2);
        Node rightLCA=lca2(root.right,n1,n2);

        if(rightLCA==null){
            return leftLCA;
        }

        if(leftLCA==null){
            return rightLCA;
        }

        return root;

    }

    public static void main(String[] args) {
        /*
         *        1
         *       / \
         *      2   3
         *     / \ / \
         *    4  5 6  7
         
*/
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        int n1 = 4, n2 = 7;
        System.out.println(lca2(root,n1,n2).data);

    }
}

// 3.Minimum distance bet node:-

import java.util.*;

public class BinaryTreePart3 {
    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static Node lca2(Node root, int n1, int n2) {
        if (root == null || root.data != n1 || root.data != n2) {
            return root;
        }

        Node leftLCA = lca2(root.left, n1, n2);
        Node rightLCA = lca2(root.right, n1, n2);

        if (rightLCA == null) {
            return leftLCA;
        }

        if (leftLCA == null) {
            return rightLCA;
        }

        return root;

    }

    public static int lcaDist(Node root, int n) {
        if (root == null) {
            return -1;
        }

        if (root.data == n) {
            return 0;
        }

        int leftDist = lcaDist(root.left, n);
        int rightDist = lcaDist(root.right, n);

        if (leftDist == -1 && rightDist == -1) {
            return -1;
        } else if (leftDist == -1) {
            return rightDist + 1;

        } else {
            return leftDist + 1;
        }

    }

    public static int Minimum_Distance_Bet_Node(Node root, int n1, int n2) {

        Node lca = lca2(root, n1, n2);
        return lcaDist(lca, n1) + lcaDist(lca, n2);

    }

    public static void main(String[] args) {
        /*
         * 1
         * / \
         * 2 3
         * / \ / \
         * 4 5 6 7
         */

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        int n1 = 4, n2 = 2;
        System.out.println(Minimum_Distance_Bet_Node(root, n1, n2));

    }
}

// 4.Kth ancestor of Node:

import java.util.*;

public class BinaryTreePart3 {
        static class Node {
            int data;
            Node left, right;
    
            Node(int data) {
                this.data = data;
                this.left = null;
                this.right = null;
            }
        }

        public static int KthAncestorOfNode(Node root, int n, int k){

            if(root==null){
                return -1;
            }

            if(root.data==n){
                return 0;
            }

            int leftDist=KthAncestorOfNode(root.left,n,k);
            int rightDist=KthAncestorOfNode(root.right,n,k);

            if(leftDist==-1 && rightDist==-1){
                return -1;
            }

            int max=Math.max(leftDist,rightDist);
            if(max+1==k){
                System.out.println(root.data);
            }
            return max+1;


        }

        public static void main(String[] args) {
            /*
             * 1
             * / \
             * 2 3
             * / \ / \
             * 4 5 6 7
             
    */
            Node root = new Node(1);
            root.left = new Node(2);
            root.right = new Node(3);
            root.left.left = new Node(4);
            root.left.right = new Node(5);
            root.right.left = new Node(6);
            root.right.right = new Node(7);
    
            int n = 4, k= 1;
            KthAncestorOfNode(root, n, k);

        }
    }

// 5.Transform to sum tree

import java.util.*;

public class BinaryTreePart3 {
    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static int Transform_to_Sum_Tree(Node root) {
        if (root == null) {
            return 0;
        }

        int leftSum = Transform_to_Sum_Tree(root.left);
        int rightSum = Transform_to_Sum_Tree(root.right);

        int oldVal = root.data;
        root.data = leftSum + rightSum;

        return oldVal + root.data;
    }

    public static void Preorder(Node root) {
        if (root == null) {
            return;
        }

        System.out.print(root.data + " ");
        Preorder(root.left);
        Preorder(root.right);
    }

    public static void main(String[] args) {
        /*
         * 1
         * / \
         * 2 3
         * / \ / \
         * 4 5 6 7
         */
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        Transform_to_Sum_Tree(root);
        Preorder(root); // Should print: 27 9 0 0 13 0 0
    }
}
