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
     end.setNext(newNode);
     newNode.setPrev(end);
     end = newNode;
     size++;
     }
     return true;
  }
public void add(int index, String value){
  if(index < 0 || index > size){
    throw new IndexOutOfBoundsException("no such element");
  }
  Node newNode = new Node(value);
  if(size == 0){
    start = end = newNode;
    size++;
  }else{
    if(index == 0){
      start.setPrev(newNode);
      newNode.setNext(start);
      start = newNode;
      size++;
    }else{
      if(index == size){
        end.setNext(newNode);
        newNode.setPrev(end);
        end = newNode;
        size++;
      }else{
        Node counter = start;
        for(int i = 0; i < size; i++){
          if(i == index){
            counter.getPrev().setNext(newNode);
            newNode.setPrev(counter.getPrev());
            counter.setPrev(newNode);
            newNode.setNext(counter);
            size++;
          }else{
            counter = counter.getNext();
          }
        }
      }
    }
  }
}
 public String get(int index){
   if(index < 0 || index >= size){
     throw new IndexOutOfBoundsException("no such element");
   }
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
   if(index < 0 || index >= size){
     throw new IndexOutOfBoundsException("no such element");
   }
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
 public String toString(){
   String result = "";
   Node counter = start;
   for(int i = 0; i < size; i++){
     if(counter != end){
       result += counter.getData() + ", ";
       counter = counter.getNext();
     }
     else{
       result += counter.getData();
     }
   }
   return result;
 }
   public String toStringReversed(){
     String result = "";
     Node counter = end;
     for(int i = size-1; i >= 0; i--){
       if(counter != start){
         result += counter.getData() + ", ";
         counter = counter.getPrev();
       }
       else{
         result += counter.getData();
       }
     }
     return result;
 }
//  //Any helper method that returns a Node object MUST BE PRIVATE!
}
