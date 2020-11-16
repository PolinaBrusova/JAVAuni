package ДЗ_рекурсии;

public class BinaryTree {
    Node root;
    public BinaryTree(Node node){
        this.root = node;
    }

    private Node addRecursive(Node current, int value) {
        if (current == null) {
            return new Node(value);
        }

        if (value < current.value) {
            current.left = addRecursive(current.left, value);
        } else if (value > current.value) {
            current.right = addRecursive(current.right, value);
        } else {
            //Значение уже существует
            return current;
        }

        return current;
    }

    private boolean containsNodeRecursive(Node current, int value) {
        //рекурсивный поиск узла
        if (current == null) {
            return false;
        }
        if (value == current.value) {
            return true;
        }
        return value < current.value
                ? containsNodeRecursive(current.left, value)
                : containsNodeRecursive(current.right, value);
    }

    public boolean containsNode(int value) {
        return containsNodeRecursive(root, value);
    }

    //Добавление узла
    public void add(int value) {
        root = addRecursive(root, value);
    }

    public BinaryTree createBinaryTree() {
        //Создание бинарного дерева
        BinaryTree bt = new BinaryTree(root);

        bt.add(6);
        bt.add(4);
        bt.add(8);
        bt.add(3);
        bt.add(5);
        bt.add(7);
        bt.add(9);

        return bt;
    }

    public void traverseInOrder(Node node) {
        //поиск по середине
        if (node != null) {
            traverseInOrder(node.left);
            System.out.print(" " + node.value);
            traverseInOrder(node.right);
        }
    }

    public void traversePreOrder(Node node) {
        //Поиск в прямом порядке
        if (node != null) {
            System.out.print(" " + node.value);
            traversePreOrder(node.left);
            traversePreOrder(node.right);
        }
    }

    public void traversePostOrder(Node node) {
        //Поиск в обратном порядке
        if (node != null) {
            traversePostOrder(node.left);
            traversePostOrder(node.right);
            System.out.print(" " + node.value);
        }
    }



}
