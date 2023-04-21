
public class ArraysDemo {
    public static void main(String[] args) {
        int[][] data = {
            {26, 89, 44, 54, 71, 18, 63, 39, 12, 9},
            {62, 98, 22, 45, 17, 81, 36, 93, 21, 90},
            {16, 77, 27, 33, 19, 72, 90, 12, 32, 80}
        };
        
        for(int[] i: data){
            for(int j: i){
                System.out.print(j + " ");
            }
            System.out.println("");
        }
    }
    
    public static void main11(String[] args) {
        int[][] data = {
            {26, 89, 44, 54, 71, 18, 63, 39, 12, 9},
            {62, 98, 22, 45, 17, 81, 36, 93, 21, 90},
            {16, 77, 27, 33, 19, 72, 90, 12, 32, 80}
        };

        int input = 89;
        boolean found = false;
        int count = 0;

        outerSearchLoop:
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                count++;
                if (input == data[i][j]) {
                    found = true;
                    break outerSearchLoop;
                    //break;
                }
            }
        }
        
//        for (int i = 0; i < data.length; i++) {
//            for (int j = 0; j < data[i].length; j++) {
//                count++;
//                if (input == data[i][j]) {
//                    found = true;
//                    break;
//                }
//            }
//            if(found){
//                break;
//            }
//        }

        System.out.println(input + " exists: " + found);
        System.out.println(count);
    }

    public static void main10(String[] args) {
        int[][] a = {
            {10, 20},
            {15, 25, 35, 45},
            {25, 50, 75}
        };

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                System.out.print(a[i][j] + " ");
            }
            System.out.println("");
        }
    }

    public static void main9(String[] args) {
        int a[][], b;
        int[][] m, n;
        int[] k, z[];

        a = new int[2][3];
        m = new int[4][4];
        k = new int[5];
        z = new int[2][6];

        int[][] d;

        d = new int[3][];

        d[0] = new int[2];
        d[2] = new int[3];
        d[1] = new int[4];

        for (int i = 0; i < d.length; i++) {
            for (int j = 0; j < d[i].length; j++) {
                System.out.print(d[i][j] + " ");
            }
            System.out.println("");
        }

    }

    public static void main8(String... args) {//shangeethKumar() {
        int[] data = {26, 89, 44, 54, 71, 18, 63, 39, 12, 9};
        int[] ss = {70, 63, 25};
        boolean s = false;
        int count = 0;
        for (int i = 0; i < ss.length; i++) {
            for (int j = 0; j < data.length; j++) {
                count++;
                if (ss[i] == data[j]) {
                    s = true;
                }
            }
            System.out.println(ss[i] + " is " + s);
            s = false;
        }
        System.out.println(count);
    }

    public static void main7(String[] args) {
        int[] data = {26, 89, 44, 54, 71, 18, 63, 39, 12, 9};
        int[] searchData = {26, 63};
        boolean[] searchResults = new boolean[searchData.length];
        int count = 0;

        for (int i = 0; i < searchData.length; i++) {
            for (int j = 0; j < data.length; j++) {
                count++;
                if (searchData[i] == data[j]) {
                    searchResults[i] = true;
                    break;
                    //continue;
                }
            }
        }

        for (int i = 0; i < searchData.length; i++) {
            System.out.println(searchData[i] + " : " + searchResults[i]);
        }
        System.out.println(count);
    }

    public static void main6(String[] args) {
        int[] a = {26, 89, 44, 54, 71, 18};
        int temp = 44;
        boolean found = false;
        int count = 0;

        for (int i = 0; i < a.length; i++) {
            count++;
            if (a[i] == temp) {
                found = true;
                break;
            }
        }

        System.out.println(temp + " exists: " + found);
        System.out.println(count);

    }

    public static void main5(String[] args) {
        int[] a = {26, 89, 44, 54, 71, 18};
        int max = a[0];
        int sum = max;

        for (int i = 1; i < a.length; i++) {
            if (a[i] > max) {
                max = a[i];
            }
            sum += a[i];
        }
        System.out.println("Max: " + max);
        System.out.println("Sum: " + sum);
        System.out.println("Avg: " + (sum + 0.0) / a.length);
    }

    public static void main4(String[] args) {
        int[] a;
        a = new int[]{10, 100, 1000};

        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }

    public static void main3(String[] args) {
        //declaration and initialization must be done in single statement
        int[] a = {10, 100, 1000};

        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }

    public static void main2(String[] args) {
        int[] a;
        a = new int[3];

        a[1] = 100;

        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }

    }

    public static void main1(String[] args) {
        int a;
        int b[], b2;
        int[] c, c2;
    }

}
