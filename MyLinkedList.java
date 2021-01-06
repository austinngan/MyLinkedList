public class MyLinkedList{
  private int size;
  private Node start,end;

  public MyLinkedList(){
    size=0;
  }

  public int size(){
    return size;
  }

  public boolean add(String value){
    if (size==0){
      start=new Node(value);
      end=start;
      size++;
    }
    else{
      Node prev=end;
      end=new Node(value);
      prev.setNext(end);
      end.setPrev(prev);
      size++;
    }
    return true;
  }
  // public boolean add(int index, String value);
  // public String get(int index);
  // public String set(int index, String value);
  // public String toString();
}
