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
      Node beforeEnd=end.getPrev();
      end=new Node(value);
      prev.setNext(end);
      prev.setPrev(beforeEnd);
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
      Node afterSecond=(start.getNext());
      start=new Node(value);
      start.setNext(second);
      second.setPrev(start);
      second.setNext(afterSecond);
      size++;
      return true;
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
    return true;
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

  public String remove(int index){
    Node deleted=start;
    if (index>=size()||index<0){
      throw new IndexOutOfBoundsException("Index "+index + " is out of bounds.");
    }
    if (index==0){
      start=start.getNext();
      start.setPrev(null);
      size--;
      return deleted.getData();
    }
    if (index==size()-1){
      deleted=end;
      end=end.getPrev();
      end.setNext(null);
      size--;
      return deleted.getData();
    }
    if (size()==1){
      start=null;
      end=null;
      size--;
      return deleted.getData();
    }
    else{
      Node initial=start;
      int counter=0;
      while (counter<index){
        initial=initial.getNext();
        deleted=initial;
        counter++;
      }
      Node temp=initial.getPrev();
      Node temp2=initial.getNext();
      temp.setNext(temp2);
      temp2.setPrev(temp);
      size--;
      return deleted.getData();
    }
  }

  public String toStringReversed(){
    String output="[";
    Node initial=end;
    int count=size()-1;
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
