public class Node{
  public Node(String value){
    data = value;
  }
  private String data;
  private Node next,prev;
  //write get/set methods for all three instance variables.

  public String getData(){
    return data;
  }

  public void setData(String value){
    data = value;
  }

  public Node getNext(){
    return next;
  }

  public void setNext(Node ne){
    next = ne;
  }

  public Node getPrev(){
    return prev;
  }

  public void setPrev(Node ne){
    prev = ne;
  }
}
