package BinaryTree;

public class BTNode {

    private int value;
    private BTNode leftChild;
    private BTNode rightChild;

    public BTNode(int value) {
        this.value = value;
        leftChild = null;
        rightChild = null;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public BTNode getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(BTNode leftChild) {
        this.leftChild = leftChild;
    }

    public BTNode getRightChild() {
        return rightChild;
    }

    public void setRightChild(BTNode rightChild) {
        this.rightChild = rightChild;
    }
}
