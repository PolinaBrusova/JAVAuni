package com.company;

public class Main {

    public static void main(String[] args) {
        int n = 5;
        System.out.println(recursion(n));

        BinaryTree binaryTree = new BinaryTree(new Node(1));
        BinaryTree ourBin = binaryTree.createBinaryTree();
        ourBin.traverseInOrder(ourBin.root.right.right);

    }

    public static String recursion(int num){
        if (num == 1){
            return "1";
        }else{
            return recursion(num-1)+" "+num;
        }
    }
}
