package BinaryTree;

import java.util.LinkedList;

public class BinaryTreeApp {

    public static void main(String[] args) {

        BinaryTree binaryTree = new BinaryTree(3);
        binaryTree.insertNode(10);
        binaryTree.insertNode(20);
        binaryTree.insertNode(4);
        binaryTree.insertNode(2);
        binaryTree.insertNode(9);
        binaryTree.insertNode(17);
        binaryTree.insertNode(1);

        binaryTree.printTreeByLevel();

        LinkedList[] lists = binaryTree.getListOfNodesByLevel();

        for (LinkedList list : lists) {
            Integer[] singleList = (Integer[]) list.toArray(new Integer[list.size()]);
            for (int value : singleList) {
                System.out.print(" " + value);
            }
        }

    }
}
