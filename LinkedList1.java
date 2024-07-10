//1.Introduction:-Syntax,Methods;

public class LinkedList1{
    public static class Node{
        int data;
    Node next;

    public Node(int data){
        this.data=data;
        this.next=null;
    }
    }
    public static Node head;
    public static Node tail;
    public static int size;

    public void AddFirst(int data){
        Node newNode=new Node(data);           //step1=create new node
        size++;

        if(head==null){
            head=tail=newNode;
            return;
        }
        newNode.next=head;                     //step-2=link
        head=newNode;                          //step3

    }

    public void AddLast(int data){
        Node newNode=new Node(data);
        size++;
        if(head==null){
            head=tail=newNode;
            return;
        }
        tail.next=newNode;
        tail=newNode;
    }
    public void print(){
        if(head==null){
            System.out.println("LL is empty");
            return;
        }
        Node temp=head;
        while(temp!=null){
            System.out.print(temp.data+ "--> ");
            temp=temp.next;
        }
        System.out.println("null");
    }

    public void AddMiddle(int idx,int data){
        Node newNode=new Node(data);
        size++;
        Node temp=head;
        int i=0;

        while(i<idx-1){
            temp=temp.next;
            i++;
        }
        newNode.next=temp.next;
        temp.next=newNode;
    }
    public int RemoveFirst(){

        //cases
        if(size==0){
            System.out.println("LL is empty");
            return Integer.MIN_VALUE;
        }else if(size==1){
            int val=head.data;
            head=tail=null;
            size=0;
            return val;
        }

        int val=head.data;
        head=head.next;
        size--;
        return val;
    }

    public int RemoveLast(){

        //cases
        if(size==0){
            System.out.println("LL is empty");
            return Integer.MIN_VALUE;
        }else if(size==1){
            int val=head.data;
            head=tail=null;
            size=0;
            return val;
        }

        Node prev=head;
        for(int i=0;i<size-2;i++){
            prev=prev.next;
        }
        int val=prev.next.data;
        prev.next=null;
        tail=prev;
        size--;
        return val;

    }

    public static void main(String args[]){
        LinkedList1 LL = new LinkedList1();
        
        LL.AddFirst(1);  
        LL.AddFirst(2);
        LL.AddLast(3);
        LL.AddLast(4);
        LL.AddMiddle(2,8);
        LL.print();
        System.out.println(LL.size);
        LL.RemoveFirst();
        LL.print();

        LL.RemoveLast();
        LL.print();
        System.out.println(LL.size);
    }

}

//2.Search:-Iterative method:-Search for key in linkedlist.return position where it is found .if not found then return -1.
//delete from nth node
public class LinkedList1{
    public static class Node{
        int data;
    Node next;

    public Node(int data){
        this.data=data;
        this.next=null;
    }
    }
    public static Node head;
    public static Node tail;
    public static int size;
    public int IterativeSearch(int key){
        Node temp=head;
        int i=0;

        while(temp!=null){
            if(temp.data==key){
                return i;

            }
            temp=temp.next;
            i++;
        }
        return -1;
    }

    public void AddFirst(int data){
        Node newNode=new Node(data);           //step1=create new node
        size++;

        if(head==null){
            head=tail=newNode;
            return;
        }
        newNode.next=head;                     //step-2=link
        head=newNode;                          //step3

    }

    public void print(){
        if(head==null){
            System.out.println("LL is empty");
            return;
        }
        Node temp=head;
        while(temp!=null){
            System.out.print(temp.data+ "--> ");
            temp=temp.next;
        }
        System.out.println("null");
    }

    public void AddMiddle(int idx,int data){
        Node newNode=new Node(data);
        size++;
        Node temp=head;
        int i=0;

        while(i<idx-1){
            temp=temp.next;
            i++;
        }
        newNode.next=temp.next;
        temp.next=newNode;
    }
    public void AddLast(int data){
        Node newNode=new Node(data);
        size++;
        if(head==null){
            head=tail=newNode;
            return;
        }
        tail.next=newNode;
        tail=newNode;
    }
//Another Method:-Recursive

public int helper(Node head,int key){
    if(head==null){
        return -1;
    }
    if(head.data==key){
        return 0;
    }
    int idx=helper(head.next,key);
    if(idx==-1){
        return -1;
    }
    return idx+1;

}

public int RecursiveSearch(int key){
    return helper(head,key);
}

public void reverse(){
    Node prev=null;
    Node curr=tail=head;
    Node next;

    while(curr!=null){
        next=curr.next;
        curr.next=prev;
        prev=curr;
        curr=next;
    }
    head=prev;
}


public void DeleteNthNodeFromEnd(int n){                         //Find & Remove Nth Node from end
    //calculate size
    int sz=0;
    Node temp=head;
    while(temp!=null){
        temp=temp.next;
        sz++;
    }
    if(n==sz){
        head=head.next;      //Remove First
        return;
    }
    //sz-n
    int i=1;
    int iToFind=sz-n;
    Node prev=head;
    while(i<iToFind){
        prev=prev.next;
        i++;
    }
    prev.next=prev.next.next;
    return;

}

//Check if LL is palindrome
public Node FindMidNode(Node head){
    Node slow=head;
    Node fast=head;

    while(fast!=null&&fast.next!=null){
        slow=slow.next;   //+1
        fast=fast.next.next;  //+2

    }
    return slow;

}

    public boolean IsPalindrome(){
        //base case
        if(head==null || head.next==null){
            return true;
        }
        //step1 -find midnode;
        Node midnode = FindMidNode(head);
        //step2-reverse 2nd half;
        Node prev=null;
        Node curr=midnode;
        Node next;
        while(curr!=null){
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;

        }
        Node right=prev;
        Node left=head;

        //step3-check left &right half;
        while(right!=null){
            if(left.data!=right.data){
                return false;
            }
            left=left.next;
            right=right.next;
        }
        return true;

    }

    //Detect loop/cycle in LL
    public boolean isCycle(){
        Node slow=head;
        Node fast=head;

        while(fast!=null && fast.next!=null){
            slow=slow.next;  //+1
            fast=fast.next.next;  //+2

            if(slow==fast){
                return true;  //cycle exist
            }

        }
        return false;  //cycle doesnt exist
    }


    public static void main(String args[]){
        LinkedList1 LL = new LinkedList1();
        
        LL.AddLast(1);  
        LL.AddLast(2);
        LL.AddLast(1);
        //LL.AddLast(1);
       // LL.AddMiddle(2,8);
        //LL.print();

        //System.out.println(LL.IterativeSearch(3));
        //System.out.println(LL.IterativeSearch(10));
        //System.out.println(LL.RecursiveSearch(3));
        //LL.reverse();
        //LL.print();

        //LL.DeleteNthNodeFromEnd(3);
        //LL.print();

            LL.print();
            System.out.println(LL.IsPalindrome());
    }
}