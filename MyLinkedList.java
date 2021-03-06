public class MyLinkedList{
 private int size;
 private Node start,end;
 public MyLinkedList(){
   size = 0;
   start = null;
   end = null;
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
   String result = "[";
   if(size == 0){
     return "[]";
   }
   Node counter = start;
   for(int i = 0; i < size; i++){
     if(counter != end){
       result += counter.getData() + ", ";
       counter = counter.getNext();
     }
     else{
       result += counter.getData() + "]";
     }
   }
   return result;
 }
   public String toStringReversed(){
     if(size == 0){
       return "[]";
     }
     String result = "[";
     Node counter = end;
     for(int i = size-1; i >= 0; i--){
       if(counter != start){
         result += counter.getData() + ", ";
         counter = counter.getPrev();
       }
       else{
         result += counter.getData() + "]";
       }
     }
     return result;
 }
   public String remove(int index){
     if(index < 0 || index >= size || size == 0){
       throw new IndexOutOfBoundsException("no such element");
     }
     if(size == 1){
       Node holder = start;
       start = null;
       end = null;
       size--;
       return holder.getData();
     }else{
       if(index == 0){
         Node holder = start;
         start = start.getNext();
         start.getPrev().setNext(null);
         start.setPrev(null);
         size--;
         return holder.getData();
       }else{
         if(index == size-1){
           Node holder = end;
           end = end.getPrev();
           end.getNext().setPrev(null);
           end.setNext(null);
           size--;
           return holder.getData();
         }else{
           Node counter = start;
           for(int i = 0; i < size; i++){
             if(index == i){
               Node holder = counter;
               counter.getPrev().setNext(counter.getNext());
               counter.getNext().setPrev(counter.getPrev());
               // counter.setNext(null);
               // counter.setPrev(null);
               size--;
               return holder.getData();
             }else{
               counter = counter.getNext();
             }
           }
         }
       }
     }
     return "Something went wrong...";
   }
     public void empty(){
       size = 0;
       end = null;
       start = null;
     }
     private void link(Node other){
       start.setPrev(other);
       other.setNext(start);
       start = other;
     }
     public void extend(MyLinkedList other){
       if(other.size() != 0){
         if(size != 0){
           size += other.size();
           other.link(end);
           end = other.end;
           other.empty();
         }else{
           size = other.size();
           start = other.start;
           end = other.end;
           other.empty();
         }
       }
     }
//  //Any helper method that returns a Node object MUST BE PRIVATE!
}
