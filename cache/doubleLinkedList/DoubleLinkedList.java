package cache.doubleLinkedList;

import cache.Exceptions.EmptyList;

public class DoubleLinkedList<Key> {
    private DoubleLinkedListNode<Key> front;
    private DoubleLinkedListNode<Key> back;
    public DoubleLinkedList(){
        front=new DoubleLinkedListNode<>(null);
        back=new DoubleLinkedListNode<>(null);
        front.right = back;
        back.left = front;
    }

    public void addNewNode(DoubleLinkedListNode<Key> doubleLinkedListNode){
        DoubleLinkedListNode<Key> backLeft = back.left;
        backLeft.right = doubleLinkedListNode;
        back.left = doubleLinkedListNode;
        doubleLinkedListNode.left = backLeft;
        doubleLinkedListNode.right = back;

    }
    public void addAtFirst(DoubleLinkedListNode<Key> doubleLinkedListNode){
        doubleLinkedListNode.left.right = doubleLinkedListNode.right;
        doubleLinkedListNode.right.left = doubleLinkedListNode.left;
        doubleLinkedListNode.left=null;
        doubleLinkedListNode.right=null;
        doubleLinkedListNode.right = front.right;
        doubleLinkedListNode.right.left = doubleLinkedListNode;
        front.right = doubleLinkedListNode;
        doubleLinkedListNode.left = front;

    }
    public DoubleLinkedListNode<Key> removeLastNode(){
        if (isEmpty()){
            throw new EmptyList();
        }
        DoubleLinkedListNode<Key> removed = back.left;
        removed.left.right = back;
        back.left = removed.left;
        return removed;
    }

    public boolean isEmpty(){
        return front.right==back;
    }

}
