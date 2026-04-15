public class Linkedlist{

    public static class Node{
        int data;
        Node next;
        
        public Node(int data){
            this.data = data;
            this.next = null;
        }

    }
    public static Node head;
    public static Node tail;
    public static int size;

    public void addfirst(int data){
        // create new node
        Node newNode = new Node(data);
        size++;
        if(head == null){
            head = tail = newNode;
            return;
        }
        newNode.next = head;

        head = newNode;
    }
    public void addend(int data){
        Node newNode = new Node(data);
        size++;
        if(head == null){
            head = tail = null;
            return;
        }
        tail.next = newNode;
        tail = newNode;
    }

    public void addatpos(int index,int data){
        if (index == 0){
            addfirst(data);
            return;
        }
        Node newNode = new Node(data);
        size++;
        Node temp = head;
        int i = 0;
        while( i< index -1){
            temp = temp.next;
            i++;
        }

        newNode.next = temp.next;
        temp.next = newNode;


    }

    public int removefirst(){
        if(size == 0){

            System.out.println("ll is empty");
            return Integer.MIN_VALUE;
        }else if(size == 1){
            int val = head.data;
            head = tail =null;
            size = 0;
            return val;
        }
        int val = head.data;
        head = head.next;
        size--;
        return val;
    }

    public int removeend(){
        if(size == 0){
            System.out.println("ll is empty");
            return Integer.MIN_VALUE;
        }else if(size == 1){
            int val = head.data;
            head = tail =null;
            size =0;
            return val;
        }

        Node prev = head;
        for(int i=0; i<size-2; i++){
            prev = prev.next;
        }
        int val =prev.next.data;
        prev.next = null;
        tail =prev;
        size--;
        return val;
    }
    // itratively search element in ll
    public int findnum(int target){
        if(size == 0){
            System.out.println("ll is empty");
            return Integer.MIN_VALUE;
        }else if(size == 1){
            if(target == head.data){
                return 1;
            }
        }else{
            Node temp = head;
            int i = 0;
            while(temp != null){
                if(temp.data == target){
                    return i;
                }
                i++;
                temp = temp.next;
            } 
        }
        return -1;
    }
    // recursive search element in ll
    public int helper(Node head,int key){
        if(head == null){
            return -1;
        }
        if(head.data == key){
            return 0;
        }
        int idx = helper(head.next,key);
        if(idx == -1){
            return -1;
        }
        return idx + 1;
    }
    public int recsearch(int key){
        return helper(head,key);
    }

    // reverse a linked list

    public void reversell(){
        Node prev = null;
        Node curr = head;
        Node next;

        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev =curr;
            curr = next;
        }
        head = prev;
    }

    //find and remove nth node from end of linked list

    public void rnae(int n){
        int sz = 0;
        Node temp = head;
        while(temp != null){
            temp = temp.next;
            sz++;
        }
        if(sz == n){
            head = head.next;
            return;
        }

        int i = 1;
        int itofind = sz - n;
        Node prev = head;
        while(i < itofind){
            prev = prev.next;
            i++;
        }
        prev.next = prev.next.next;
    }
    //check if linked list is palindrome or not
    public Node midNode(Node head){
        Node slow = head;
        Node fast = head;

        while(fast != null && fast.next != null){
            slow= slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public boolean chexkpalindrom(){
        if(head == null || head.next == null){
            return true;
        }

        Node mid = midNode(head);

        Node prev = null;
        Node curr = mid;
        Node next;

        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        Node right = prev;
        Node left = head;
        while(right != null){
            if(left.data != right.data){
                return false;
            }
            left = left.next;
            right = right.next;
        }
        return true;

    }

    //detect cycle in linked list

    public boolean iscycle(){  //Floyd's cycle detection algorithm
        Node slow =head;
        Node fast = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                return true;
            }
        }
        return false;

    }

    // remove cycle in linked list

    public void removecycle(){
        Node slow = head;
        Node fast = head;
        boolean cycle = false;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                cycle = true;
                break;
            }
        }
        if(cycle == false){
            return;
        }

        Node prev = null;
        slow = head;
        while(slow != fast){
            prev = fast;
            slow = slow.next;
            fast = fast.next;
        }
        prev.next = null;
    }

    // merge two sorted linked list

    public Node findmid(Node head){
        Node slow = head;
        Node fast = head.next;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public Node merge(Node head1,Node head2){
        Node mergell = new Node(-1);
        Node temp = mergell;
        while(head1 != null && head2 != null){
            if(head1.data <= head2.data){
                temp.next = head;
                head1 = head1.next;
                temp = temp.next;
            }else{
                temp.next = head2;
                head2 = head2.next;
                temp = temp.next;
            }
        }
        while(head1 != null){
            temp.next = head1;
            head1 = head1.next;
            temp = temp.next;
        }

        while(head2 != null){
            temp.next = head2;
            head2 = head2.next;
            temp = temp.next;
        }

        return mergell.next;
    }

    public Node mergesortll(Node head){
        if(head == null || head.next == null){
            return head;
        }
        // find mid
        Node mid = findmid(head);
        // left and right merge sort
        Node rightNode = mid.next;
        mid.next = null;

        Node newleft = mergesortll(head);
        Node newright = mergesortll(rightNode);

        return merge(newleft,newright);
    }

    // zigzag linked list

    public void zigzag(){
        // find mid
        Node slow = head;
        Node fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        Node mid = slow;

        // reverse second half

        Node prev = null;
        Node curr = mid.next;
        mid.next = null;
        Node next;
        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

    // merge two halves in zigzag manner
        Node left = head;
        Node right = prev;
        Node nextl,nextr;

        while(left != null && right != null){
            nextl = left.next;
            left.next = right;
            nextr = right.next;
            right.next = nextl;

            left = nextl;
            right = nextr;
        }
    } 

    public void printll(){
        Node temp = head;
        while(temp != null){
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }
    public static void main(String[] args){
        Linkedlist ll = new Linkedlist();
        ll.addfirst(5);
        ll.addfirst(4);
        ll.addfirst(3);
        ll.addfirst(2);
        ll.addfirst(1);
        ll.printll();
        ll.zigzag();
        ll.printll();
        // ll.head = ll.mergesortll(ll.head);
        // ll.printll();
        // // ll.printll();
        // ll.addfirst(10);
        // // ll.printll();
        // ll.addfirst(20);
        // // ll.printll();
        // ll.addfirst(20);
        // ll.printll();
        // ll.addfirst(10);
        // ll.printll();
        // ll.addfirst(50);
        // ll.addatpos(2, 101);
        // ll.printll();
        // ll.removefirst();
        // ll.printll();
        // ll.removeend();
        // ll.printll();
        // ll.reversell();
        // ll.printll();
        // ll.rnae(2);
        // ll.printll();
        // System.out.println(ll.chexkpalindrom());
        // System.out.println( + ll.recsearch(1011));
        // System.out.println(ll.size);

        // head = new Node(1);
        // Node temp = new Node(2);
        // head.next = temp;
        // head.next.next = new Node(3);
        // head.next.next.next = temp;
        // System.out.println(ll.iscycle());
        
        // ll.removecycle();
        // ll.printll();
    }
}