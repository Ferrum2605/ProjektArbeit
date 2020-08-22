package HeapSort2;


public class Startklasse {

    public static void main(String[] args) {

        int [] array = {5, 2, 15, 12, 48, 36, 88, 85};

        heapSort(array);

    }
    //i = Elternelement, das ggf. nach unten verschoben werden muss
    //n = letzte Stelle des Baumes die betrachet werden soll
    public static void compareAndSwap(int[] a, int i, int n) {

        while(i <= (n / 2) - 1) {
            int childIndex = ((i + 1) * 2) - 1; //Index des linken Kindes

            if (childIndex + 1 <= (n - 1)) {
                if(a[childIndex] < a[childIndex + 1]) { //Vergleich der Kinder 
                    childIndex++;
                }
            }

            //prüfung ob Swap nötig ist
            if(a[i] < a[childIndex]) {
                swap(a, i, childIndex);
                i = childIndex;
            }else break;
        }


    }

    public static void swap(int[] a, int i, int childIndex) {
        int z = a[i];
        a[i] = a[childIndex];
        a[childIndex] = z;
    }
    //Erstellt MaxHeapBaum im Array
    public static void generateMaxHeap(int[] a) {

        for(int i = (a.length / 2) - 1; i >= 0; i--) {
            compareAndSwap(a, i, a.length);
        }
    }

    public static void heapSort(int[] a) {
        generateMaxHeap(a);
        printArray(a);
        for(int i = a.length - 1; i > 0; i--) {
            swap(a, i, 0);
            printArray(a);
            compareAndSwap(a, 0, i);
            printArray(a);
        }
    }
     public static void printArray(int arr[]) 
        { 
            int n = arr.length; 
            for (int i=0; i<n; ++i) 
                System.out.print(arr[i]+" "); 
            System.out.println(); 
        } 
}
