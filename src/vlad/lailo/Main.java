package vlad.lailo;

public class Main {

    public static void main(String[] args) {

        final int SIZE = 3;
        int[][] a = randomMatrix(SIZE, 7);
        int[][] c = new int[SIZE][SIZE];

        print(a, SIZE);

        for (int i = 0; i < SIZE; i++) {
            c[i][0] = a[i][0];
        }

        for (int j = 0; j < SIZE; j++) {
            for (int i = 0; i < SIZE; i++) {
                if (i >= 1 && j <= SIZE - 2) { //RIGHT-UP
                    int temp = c[i][j] + a[i-1][j+1];
                    if (c[i-1][j+1] < temp) {
                        c[i-1][j+1] = temp;
                    }
                }
                if (j <= SIZE - 2) { //RIGHT
                    int temp = c[i][j] + a[i][j+1];
                    if (c[i][j+1] < temp) {
                        c[i][j+1] = temp;
                    }
                }
                if (i <= SIZE - 2 && j <= SIZE - 2) { //RIGHT-DOWN
                    int temp = c[i][j] + a[i+1][j+1];
                    if (c[i+1][j+1] < temp) {
                        c[i+1][j+1] = temp;
                    }
                }
            }
        }

        System.out.println("all longest paths tree from initialVertex:");
        int max = 0;
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                int b = c[i][j];
                if (b > max) {
                    max = b;
                }
                System.out.printf("initialVertex -> [%d][%d] = %d\n", i, j, b);
            }
        }
        System.out.printf("longest path tree from vertex 'initialVertex' = %d", max);
    }

    public static void print(int[][] a, int size) {
        System.out.print("\t");
        for (int i = 0; i < size; i++) {
            System.out.print(i + "|\t");
        }
        System.out.println();
        for (int i = 0; i < size; i++) {
            System.out.print(i + "|\t");
            for (int j = 0; j < size; j++) {
                System.out.print(a[i][j] + "\t");
            }
            System.out.println();
        }
    }

    public static int[][] randomMatrix(int size, int max) {
        int[][] a = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                a[i][j] = (int) (Math.random() * max);
            }
        }
        return a;
    }
}
