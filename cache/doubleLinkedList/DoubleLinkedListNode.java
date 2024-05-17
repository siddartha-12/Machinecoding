package cache.doubleLinkedList;

public class DoubleLinkedListNode <Value>{
    public Value value;
    public DoubleLinkedListNode<Value> left;
    public DoubleLinkedListNode<Value> right;
    public DoubleLinkedListNode(Value value){
        this.value = value;
        left = null;
        right = null;
    }

}
