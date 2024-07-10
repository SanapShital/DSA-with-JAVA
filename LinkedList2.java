//1.Detect Cycle:

public class LinkedList2 {
    public static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public Node head;

    public boolean isCycle() {
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next; //+1
            fast = fast.next.next; //+2

            if (slow == fast) {
                return true; //cycle exist
            }
        }
        return false; //cycle doesn't exist
    }

    

    public static void main(String args[]) {
        LinkedList2 list = new LinkedList2();
        list.head = new Node(1);
        list.head.next = new Node(2);
        list.head.next.next = new Node(3);
       // list.head.next.next.next = list.head;

        System.out.println(list.isCycle());
    }
}

// 2/Remove Cycle

public class LinkedList2 {
    public static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static Node head;

    public static void RemoveCycle() {
        // step1-detect cycle
        Node slow = head;
        Node fast = head;
        boolean cycle = false;

        while (fast != null && fast.next != null) {
            slow = slow.next; // +1
            fast = fast.next.next; // +2

            if (fast == slow) {
                cycle = true; // cycle exist
                break;
            }

        }
        if (cycle == false) {
            return;
        }
        // find meeting point
        slow = head;
        Node prev = null;
        while (slow != fast) {
            prev = fast;
            slow = slow.next;
            fast = fast.next;

        }

        // remove cycle
        prev.next = null;
    }

    public boolean isCycle() {
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next; // +1
            fast = fast.next.next; // +2

            if (slow == fast) {
                return true; // cycle exist
            }
        }
        return false; // cycle doesn't exist
    }

    public static void main(String args[]) {
        LinkedList2 list = new LinkedList2();
        list.head = new Node(1);
        Node temp = new Node(2);
        list.head.next = temp;
        list.head.next.next = new Node(3);
        list.head.next.next.next = temp;

        System.out.println(list.isCycle());
        RemoveCycle();
        System.out.println(list.isCycle());

    }
}

// 3.LL in collections framework

import java.util.LinkedList;

public class LinkedList2{
    public static void main (String args[]){
        LinkedList<Integer> LL =new LinkedList<>();
        LL.AddLast(1);
        LL.AddLast(2);
        LL.AddLast(3);
        LL.AddFirst(0);

        System.out.println(LL);

        LL.removeLast();
        LL.removeFirst();
        System.out.println(LL);



    }
}

// 4.MergeSort on LinkedList
import java.util.LinkedList;

public class LinkedList2 {
    public static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static Node head;

    private Node getMid(Node head) {
        Node slow = head;
        Node fast = head.next;

        while (head != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow; // mid node
    }

    private Node merge(Node head1, Node head2) {
        Node mergedLL = new Node(-1);
        Node temp = mergedLL;

        while (head1 != null && head2 != null) {
            if (head1.data <= head2.data) {
                temp.next = head1;
                head1 = head1.next;
                temp = temp.next;
            } else {
                temp.next = head2;
                head2 = head2.next;
                temp = temp.next;
            }
        }

        while (head1 != null) {
            temp.next = head1;
            head1 = head1.next;
            temp = temp.next;
        }
        while (head2 != null) {
            temp.next = head2;
            head2 = head2.next;
            temp = temp.next;
        }
        return mergedLL.next;
    }

    public Node MergeSort(Node head) {
        // base case
        if (head == null || head.next == null) {
            return head;
        }
        // find mid
        Node mid = getMid(head);
        // left&right MS
        Node rightHead = mid.next;
        Node newLeft = MergeSort(head);
        Node newRight = MergeSort(rightHead);
        // return merge
        return merge(newLeft, newRight);
    }

    public void print() {
        if (head == null) {
            System.out.println("LL is empty");
            return;
        }
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + "--> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public static void main(String args[]) {


       // LinkedList2.head = new Node(1);
      //  LinkedList2.head.next = new Node(2);
      //  LinkedList2.head.next.next = new Node(3);
      //  LinkedList2.head.next.next.next = new Node(4);
       // LinkedList2.head.next.next.next.next = new Node(5);

       // LL.print();
       // LinkedList2.head = LL.MergeSort(LinkedList2.head);
       // LL.print();
    }
}

// 5.ZigZag on LL
import java.util.LinkedList;

public class LinkedList2 {

    public static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static Node head;
    public static Node tail;
    public static int size;

    public void zigZag() {
        Node slow = head;
        Node fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

        }
        Node mid = slow;
        // Reverse 2nd half
        Node curr = mid.next;
        mid.next = null;
        Node prev = null;
        Node next;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;

        }
        Node left = head;
        Node right = prev;
        Node nextL, nextR;

        while (left != null && right != null) {
            nextL = left.next;
            left.next = right;
            nextR = right.next;
            right.next = nextL;

            left = nextL;
            right = nextR;

        }
    }

    public void AddLast(int data) {
        Node newNode = new Node(data);
        size++;
        if (head == null) {
            head = tail = newNode;
            return;
        }
        tail.next = newNode;
        tail = newNode;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node current = head;
        while (current != null) {
            sb.append(current.data).append(" ");
            current = current.next;
        }
        return sb.toString();
    }

    public static void main(String args[]) {
        LinkedList2 LL = new LinkedList2();
        LL.AddLast(1);
        LL.AddLast(2);
        LL.AddLast(3);
        LL.AddLast(4);
        System.out.println(LL);
        LL.zigZag();
        System.out.println(LL);
    }
}

// 6.Double LL

public class LinkedList2 {
    public class Node {
        int data;
        Node next;
        Node prev;

        public Node(int data) {
            this.data = data;
            this.next = null;
            this.prev = null;

        }
    }

    public static Node head;
    public static Node tail;
    public static int size;

    public void AddFirst(int data) {
        Node newNode = new Node(data);
        size++;
        if (head == null) {
            head = tail = newNode;
            return;
        }
        newNode.next = head;
        head.prev = newNode;
        head = newNode;
    }

    public void print() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + "<->");
            temp = temp.next;
        }
        System.out.println("null");
    }
    // Remove Last

    public int removeFirst() {
        if (head == null) {
            System.out.println("DLL is Empty");
            return Integer.MIN_VALUE;

        }
        if (size == 1) {
            int val = head.data;
            head = tail = null;
            size--;
            return val;

        }
        int val = head.data;
        head = head.next;
        head.prev = null;
        size--;
        return val;

    }

    // Reverse DLL

    public void Reverse() {
        Node curr = head;
        Node prev = null;
        Node next;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            curr.prev = next;

            prev = curr;
            curr = next;

        }
        head = prev;

    }

    public static void main(String args[]) {
        LinkedList2 DLL = new LinkedList2();
        DLL.AddFirst(1);
        DLL.AddFirst(2);
        DLL.AddFirst(3);
        DLL.AddFirst(4);
        /*
         * DLL.print();
         * System.out.println(DLL.size);
         * 
         * DLL.removeFirst();
         * DLL.print();
         * System.out.println(DLL.size);
         */
        DLL.print();
        DLL.Reverse();
        DLL.print();

    }
}