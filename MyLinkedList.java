public class MyLinkedList{
 private int size;
 private Node start,end;
 public MyLinkedList(){
   size = 0;
 }
 public int size(){
   return size;
 }
 public boolean add(String value){
   Node newNode = new Node(value);
   if(size == 0){
     start = end = newNode;
     size++;
   }else{
     Node holder = end;
     end.setNext(newNode);
     end = newNode;
     newNode.setNext(null);
     size++;
     }
     return true;
  }
// public void add(int index, String value);
 public String get(int index){
   Node counter = start;
   for(int i = 0; i < size; i++){
     if(i == index){
       return counter.getData();
     }
     else{
       counter = counter.getNext();
     }
  }
  return "throw here jordan";
}
 public String set(int index, String value){
   Node counter = start;
   for(int i = 0; i < size; i++){
     if(i == index){
       String holder = counter.getData();
       counter.setData(value);
       return holder;
     }else{
       counter = counter.getNext();
     }
   }
   return"throw here jordan";
 }
//  public String toString();
//  //Any helper method that returns a Node object MUST BE PRIVATE!
}
