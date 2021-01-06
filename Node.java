public class Node{
  public Node(String value){
    data=value;
  }
  
  private String data;
  private Node next,prev;

  public Node getNext(){
    return next;
  }

  public Node getPrev(){
    return prev;
  }

  public String getData(){
    return data;
  }

  public void setNext(Node second){
    this.next=second;
  }

  public void setPrev(Node second){
    this.prev=second;
  }

  public void setData(String second){
    this.data=second;
  }

}
