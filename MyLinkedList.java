public class MyLinkedList{
  private int size;
  private Node start,end;

  public MyLinkedList(){
    size=0;
    start=null;
    end=null;
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

  public boolean add(int index, String value){
    if (index>size()||index<0){
      throw new IndexOutOfBoundsException("Index "+index + " is out of bounds.");
    }
    if (index==size()){
      return add(value);
    }
    if (index==0){
      Node second=start;
      start=new Node(value);
      start.setNext(second);
      second.setPrev(start);
      return true;
    }
    else{
      Node initial=start;
      int counter=0;
      while (counter<index-1){
        initial=initial.getNext();
        counter++;
      }
      Node insert=new Node(value);
      Node temp=initial.getPrev();
      temp.setNext(insert);
      insert.setNext(initial);
      insert.setPrev(initial.getPrev());
      initial.setPrev(insert);
      size++;
    }
    return true;
  }

  public String get(int index){
    if (index>size()||index<0){
      throw new IndexOutOfBoundsException("Index "+index + " is out of bounds.");
    }
    else{
      Node initial=start;
      int counter=0;
      while (counter<index-1){
        initial=initial.getNext();
        counter++;
      }
      return initial.getData();
    }
  }
  // public String set(int index, String value);
  // public String toString();
}
