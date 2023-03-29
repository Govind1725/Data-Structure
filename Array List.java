import javax.swing.plaf.IconUIResource;
import java.net.BindException;
import java.util.Arrays;
import java.util.Scanner;
class List {
    private static final int initialCapacity = 3;
    int arr[];
    private int size;
    private int capacity;

    List() {
        size = 0;
        arr = new int[initialCapacity];
        capacity = initialCapacity;
    }

    public void add(int val) {
        if (size == capacity) {
            expand();
        }
        arr[size++] = val;
    }

    private void expand() {
        capacity *= capacity;
        arr = java.util.Arrays.copyOf(arr, capacity);
    }

    public void display() {
        for (int i = 0; i < size; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public void insertPosition(int val, int pos) {
        if (size == capacity) {
            expand();
        }
        if (pos > size) {
            System.out.println("enter position within" + size);
        }
        for (int i = size - 1; i >= pos; i--)
            arr[i + 1] = arr[i];
        arr[pos] = val;
        size++;
    }

    public void delete(int pos) {
        if(pos == size){
            size--;
        }
        for (int i = pos + 1; i < size; i++) {
            arr[i - 1] = arr[i];
            size--;
            if (capacity > initialCapacity && capacity > capacity * 3) {
                reduce();
            }
        }
    }
    private void reduce(){
        capacity/=2;
        arr= java.util.Arrays.copyOf(arr,capacity);
    }
    public void deleteLast(){
        size--;
    }
    public void deleteFirst(){
        int pos = 0;
        delete(pos);
    }
    public void addFirst(int val){
        int pos= 0;
        insertPosition(val,pos);
    }
    public void getindex(int val){
        System.out.println(arr[val]);
    }
    public void indextoadd(int val , int index){
        arr[index] = val;
    }
    public void search(int val){
        for (int i=0; i< size; i++)
        {
            if(val == arr[i]){
                System.out.println(i);
            }
        }
    }
    public void clear(){
        size=0;
    }
}
public class Govindh {
    public static void main(String arg[]) {
        Scanner sc = new Scanner(System.in);
        List list = new List();
        int val,pos,index=0;
       while (true){
           System.out.println("---------------------------------------");
           System.out.println("1-->add");
           System.out.println("2-->display");
           System.out.println("3-->insert at position");
           System.out.println("4-->delete at position");
           System.out.println("5-->delete at the end ");
           System.out.println("6-->delete from begining");
           System.out.println("7-->insert from begining");
           System.out.println("8-->get index");
           System.out.println("9-->update index");
           System.out.println("10-->search val");
           System.out.println("11-->clear");
           System.out.println("12-->exit");
           System.out.println("----------------------------------------");
           int choice = sc.nextInt();
           switch (choice){
               case(1):
                   System.out.println("enter the value to add");
                   val =sc.nextInt();
                   list.add(val);
                   break;
               case(2):
                   list.display();
                   break;
               case(3):
                   System.out.println("enter the value to add");
                    val= sc.nextInt();
                    pos= sc.nextInt();
                    list.insertPosition(val,pos);
                   break;
               case(4):
                   System.out.println("enter the position to delete");
                   pos= sc.nextInt();
                   list.delete(pos);
                   break;
               case(5):
                   list.deleteLast();
                   break;
               case(6):
                   list.deleteFirst();
                   break;
               case(7):
                   System.out.println("enter the element to add begining");
                   val = sc.nextInt();
                   list.addFirst(val);
                   break;
               case(8):
                   System.out.println("enter the index");
                   val= sc.nextInt();
                   list.getindex(val);
                   break;
               case(9):
                   System.out.println(" enter the val, and index");
                   val =sc.nextInt();
                   index = sc.nextInt();
                   list.indextoadd(val, index);
                   break;
               case(10):
                   System.out.println("enter the seach valvue");
                   val =sc.nextInt();
                   list.search(val);
                   break;
               case(11):
                   list.clear();
                   break;
               case (12):
                   System.exit(0);
           }
       }
    }
}
