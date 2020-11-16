import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        //Задание 1
        int n = 5;
        System.out.println(recursion(n));

        //Задание 2
        double[] test = get_random_array(10000);
        Arrays.sort(test);
        long startTime = System.nanoTime();
        System.out.println(force.brut_force(test,5));
        double res1 = ((double)(System.nanoTime()-startTime)/1_000_000_000);
        System.out.println("Времени затрачено на перебор: "+res1);
        startTime = System.nanoTime();
        System.out.println(force.RecursiveSreach(test,2,0,test.length));
        double res2 = ((double)(System.nanoTime()-startTime)/1_000_000_000);
        System.out.println("На двоичный поиск ушло: "+res2);
        System.out.println("разница по времени с перебором - "+(res1-res2));

        //Задание 3
        equation.print();
        System.out.println("Решение: "+equation.solve(0,10));

        //Задание 4
        BinaryTree binaryTree = new BinaryTree(new Node(1));
        BinaryTree ourBin = binaryTree.createBinaryTree();
        ourBin.traverseInOrder(ourBin.root.right.right);

    }

    public static String recursion(int num){
        //Задание 1
        if (num == 1){
            return "1";
        }else{
            return recursion(num-1)+" "+num;
        }
    }

    public static double[] get_random_array(int size){
        //Задание 2
        double[] array = new double[size];
        for(int i=0;i<size;i++){
            array[i] = Math.random();
        }
        return array;
    }
}
