package Tree;

import java.util.Scanner;

public class BinaryTree {
    private static class Node{
        int value;
        Node left;
        Node right;
        public Node(int value){
            this.value = value;
        }
    }
    public BinaryTree(){
    }
    private Node root;

    public void insert(Scanner scanner){
        System.out.println("Enter root value: ");
        int value = scanner.nextInt();
        root  =  new Node(value);
        insert(scanner, root);
    }
    private void insert(Scanner scanner,Node node){
        if(node == null){
            return;
        }
        System.out.println("Do you want to insert into "+node.value+"?");
        boolean insert = scanner.nextBoolean();
        System.out.println("Enter value to insert into "+node.value+": ");
        int value = scanner.nextInt();
        if(insert){
            node.left = new Node(value);
            insert(scanner, node.left);
        }
        else{
            node.right = new Node(value);
            insert(scanner, node.right);
        }
    }
}
