
import java.util.Scanner;
// Bai tap duyet node
// 1. dem so luong phan tu, dem so le , tinh tong cac phan tu
// 2.tim phan tu lon nhat
// tao node
class Node {
    int info;
    Node next;

    Node(int x) {
        info = x;
        next = null;
    }

    Node(int x, Node t) {
        info = x;
        next = t;
    }

    public String toString() {
        String t = "" + info + "->";
        return t;
    }
}

public class Mylist {
    Node head;

    Mylist() {
        head = null;
    }

    // funtion add
    void add(int val) {
        head = new Node(val, head);
    }

    // tao danh sach node
    void Create_Node(){
        int x;
        Node last = null; head = null;
        Scanner kb = new Scanner(System.in);
        while (true) {
            System.out.print("\nMoi ban nhap gia tri vao day: ");
            x = kb.nextInt(); if (x == 0) break;
            Node t = new Node(x); // node moi
            if(head == null) head = last = t; // neu them vao dau 
            else{last.next = t ; last = t;}
        }
    }

    // funtion append
    void append(int val){
        // b1 tao node moi chua gia tri do
        Node new_node = new Node(val);
        // b2 node head == rong thi gan head = new_node
        if(head == null){head = new_node;}
        else{

            Node point = head;
            // muon den duoc cuoi danh sach la .next == null
            // con duyet là ơhai khac null
            while (point.next != null) {
                point = point.next;
            }
            point.next = new_node;
        }
    }

    // funtion insert
    void inset(int val,int k){
        // b1 ta can xe vi tri do co chen duoc ko
        if(k < 1){System.out.println("Khong chen duoc");}
        else{
            // neu o vi tri dau thi chen vao dau
            if(k == 1){head = new Node(val);}
            else{
                Node point = head; int vt = 1;
                while (point != null && vt < k - 1) {
                    vt++; point = point.next;
                }
                if(point == null){System.out.println("vi tri chen khong hop le");}
                else{ Node new_node = new Node(val,point.next); point.next = new_node;}
            }
        }
    }

    // funtion delect node first
    void delect_node_first(){
        if(head == null){
            System.out.println("Khong the xoa duoc");
        }
        else{
            head = head.next;
        }
    }

    // funtion delect node last
    void delect_node_last(){
        // kiem tra danh sach xem co xoa duoc k
        if(head == null) {System.out.println("Khong the xoa duoc");}
        // neu danh sach co 1 node thi xoa node do di 
        if(head.next == null){return;}
        else{
            // dat con tro point la tro dau
           Node point = head;
           // duyet den ke cuoi 
           while (point.next.next != null) {
               point = point.next;
           }
           // cho p.next -> null
           point.next = null;
        }
    }
    void Display() {
        Node p = head;
        while (p != null) {
            System.out.print(p);
            p = p.next;
        }
        System.out.print("null\n");
    }

    
    public static void main(String[] args) {
        Mylist l = new Mylist();
        l.Create_Node();
        l.append(12);
        l.inset(90, 5);
        l.Display();
        l.delect_node_last();
        l.Display();
    }
}