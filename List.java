
class Node {
    int data;
    Node next;
    Node(int data) {
        this.data=data;
    }
}

class List
{
    Node head,tail;
    void insertEnd(int data) {
        Node n=new Node(data);
        if(head==null) {
            head=n;
            tail=n;
        }
        else {
            tail.next=n;
            tail=n;
        }
    }
    void insertBegin(int data) {
        Node n=new Node(data);
        n.next=head;
        head=n;
    }
    void insertPos(int pos,int data) {
        Node temp=head;
        Node n=new Node(data);
        for(int i=1;i<pos-1;i++) {
            temp=temp.next;
        }
        n.next=temp.next;
        temp.next=n;
    }
    void delEnd() {
        Node temp=head;
        while(temp.next!=tail) {
            temp=temp.next;
        }
        temp.next=null;
    }
    void delBegin() {
        head=head.next;
    }
    void delPos(int pos) {
        Node temp=head;
        for(int i=1;i<pos-1;i++) {
            temp=temp.next;
        }
        temp.next=temp.next.next;
    }
    void display() {
        Node temp=head;
        while(temp!=null) {
            System.out.println(temp.data);
            temp=temp.next;
        }
    }
    void reverse() {
        Node curr=head,next,prev=null;
        while(curr!=null) {
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        tail=head;
        head=prev;
    }
    void search(int key) {
        Node temp=head;
        int pos=1;
        while(temp!=null) {
            if(temp.data==key) {
                System.out.println(key+" is present in the "+pos+" position of the list");
                return;
            }
            pos++;
            temp=temp.next;
        }
        System.out.println(key+" is not present in the list");
    }
    void sort() {
        Node end=null;
        boolean swap=true;
        while(swap) {
            swap=false;
            Node curr=head;
            while(curr.next!=end) {
                if(curr.data>curr.next.data) {
                    int temp=curr.data;
                    curr.data=curr.next.data;
                    curr.next.data=temp;
                    swap=true;
                }
                curr=curr.next;
            }
            end=curr;
        }
    }
    int findMax() {
        Node temp=head;
        int max=temp.data;
        while(temp!=null) {
            if(max<temp.data) {
                max=temp.data;
            }
            temp=temp.next;
        }
        return max;
    }
	public static void main (String[] args) throws java.lang.Exception
	{
		List li=new List();
		li.insertEnd(10);
		li.insertEnd(20);
		li.insertEnd(30);
		li.insertBegin(0);
        li.display();
		li.reverse();
        System.out.println("After Reversing the List");
        li.display();
        li.search(20);
        System.out.println("Max of the List "+li.findMax());
        li.sort();
        li.display();
	}
}


