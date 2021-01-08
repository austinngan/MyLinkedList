public class MyLinkedList{
  private int size;
  private Node start,end;

  public MyLinkedList(){
    size=0;
  }

  public int size(){
    return size;
  }

  public void add(String value){
    if (size==0){
      start=new Node(value);
      end=start;
      size++;
    }
    else{
      Node prev=end;
      Node beforeEnd=end.getPrev();
      end=new Node(value);
      prev.setNext(end);
      prev.setPrev(beforeEnd);
      end.setPrev(prev);
      size++;
    }
  }

  public void add(int index, String value){
    if (index>size()||index<0){
      throw new IndexOutOfBoundsException("Index "+index + " is out of bounds.");
    }
    if (index==size()){
      return add(value);
    }
    if (index==0){
      Node second=start;
      Node afterSecond=(start.getNext());
      start=new Node(value);
      start.setNext(second);
      second.setPrev(start);
      second.setNext(afterSecond);
    }
    else{
      Node initial=start;
      int counter=0;
      while (counter<index){
        initial=initial.getNext();
        counter++;
      }
      Node insert=new Node(value);
      Node temp=initial.getPrev();
      temp.setNext(insert);
      insert.setNext(initial);
      insert.setPrev(temp);
      initial.setPrev(insert);
      size++;
    } 
  }

  public String get(int index){
    if (index>size()||index<0){
      throw new IndexOutOfBoundsException("Index "+index + " is out of bounds.");
    }
    else{
      Node initial=start;
      int counter=0;
      while (counter<index){
        initial=initial.getNext();
        counter++;
      }
      return initial.getData();
    }
  }

  public String set(int index, String value){
    if (index>size()||index<0){
      throw new IndexOutOfBoundsException("Index "+index + " is out of bounds.");
    }
    else{
      Node toChange=start;
      int counter=0;
      while (counter<index){
        toChange=toChange.getNext();
        counter++;
      }
      String newValue="";
      toChange.setData(value);
      newValue=toChange.getData();
      return newValue;
    }
  }

  public String toString(){
    String output="[";
    Node initial=start;
    int count=0;
    if (size==0){
      return "[]";
    }
    while (count<size){
      if (count==size-1){
        output+=initial.getData()+"]";
        count++;
      }
      else{
        output+=initial.getData()+", ";
        initial=initial.getNext();
        count++;
      }
    }
    return output;
  }

  public String toStringReversed(){
    String output="[";
    Node initial=end;
    int count=size()+1;
    if (size==0){
      return "[]";
    }
    while (count>=0){
      if (count==0){
        output+=initial.getData()+"]";
        count--;
      }
      else{
        output+=initial.getData()+", ";
        initial=initial.getPrev();
        count--;
      }
    }
    return output;
  }
}
