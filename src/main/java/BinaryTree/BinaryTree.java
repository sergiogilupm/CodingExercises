package BinaryTree;

import java.util.LinkedList;
import java.util.Stack;

public class BinaryTree {

    private BTNode root;

    public BinaryTree() {
        this.root = null;
    }

    public BinaryTree(int value) {
        this.root = new BTNode(value);
    }

    public void insertNode(int newValue) {
        if (root == null) {
            root = new BTNode(newValue);
        } else {
            insertNodeRecursive(root, newValue);
        }
    }

    public int getHeight(){
        return getHeight(root);
    }

    private int getHeight(BTNode currentNode) {
        if (currentNode == null) {
            return 0;
        } else {
            int leftHeight = getHeight(currentNode.getLeftChild());
            int rightHeight = getHeight(currentNode.getRightChild());

            int maxHeight = (leftHeight > rightHeight) ? leftHeight : rightHeight;

            return maxHeight + 1;
        }
    }


    private void insertNodeRecursive(BTNode currentNode, int newValue) {
        int currentNodeValue = currentNode.getValue();
        if (newValue < currentNodeValue) {
            BTNode leftChild = currentNode.getLeftChild();
            if (leftChild != null) {
                insertNodeRecursive(leftChild, newValue);
            } else {
                currentNode.setLeftChild(new BTNode(newValue));
            }
        } else {
            BTNode rightChild = currentNode.getRightChild();
            if (rightChild != null) {
                insertNodeRecursive(rightChild, newValue);
            } else {
                currentNode.setRightChild(new BTNode(newValue));
            }
        }
    }

    public void printTreeByLevel() {
        Stack<BTNode> stack = new Stack<>();
        if (root != null) {
            stack.push(root);
            printTreeRecursive(stack, 0);
        }
        LinkedList<Integer> myLinkedList = new LinkedList<>();
    }

    public LinkedList[] getListOfNodesByLevel() {
        LinkedList[] lists = new LinkedList[getHeight()];
        insertNewElementInList(root, lists, 0);
        return lists;
    }

    private void insertNewElementInList(BTNode node, LinkedList[] listOfNodes, int currentHeight) {

        if (node == null) {
            return;
        }
        LinkedList listByCurrentHeight = listOfNodes[currentHeight];
        if (listByCurrentHeight == null) {
            listByCurrentHeight = new LinkedList();
        }

        listByCurrentHeight.addLast(node.getValue());
        listOfNodes[currentHeight] = listByCurrentHeight;
        insertNewElementInList(node.getLeftChild(), listOfNodes, currentHeight + 1);
        insertNewElementInList(node.getRightChild(), listOfNodes, currentHeight + 1);
    }

    private void printTreeRecursive(Stack<BTNode> currentLevelNodes, int level) {
        Stack<BTNode> nextLevelNodes = new Stack<>();
        String levelPrint = "Printing level " + level + ": ";
        while (!currentLevelNodes.empty()) {
            BTNode currentNode = currentLevelNodes.pop();
            levelPrint = levelPrint + currentNode.getValue() + " ";
            BTNode leftChild = currentNode.getLeftChild();
            BTNode rightChild = currentNode.getRightChild();
            if (rightChild != null) {
                nextLevelNodes.push(rightChild);
            }
            if (leftChild != null) {
                nextLevelNodes.push(leftChild);
            }
        }
        System.out.println(levelPrint);
        System.out.flush();

        if (!nextLevelNodes.empty()){
            printTreeRecursive(nextLevelNodes, level + 1);
        }

    }

    public BTNode getRoot() {
        return root;
    }

    public void setRoot(BTNode root) {
        this.root = root;
    }
}
