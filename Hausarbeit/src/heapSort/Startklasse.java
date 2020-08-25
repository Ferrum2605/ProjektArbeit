package heapSort;

public class Startklasse {

    public static void main(String[] args) {

        int [] array = {55, 22, 15, 12, 48, 36, 88, 85};
        //hallo
        

        heapSort(array);
    }
    
    
    //n = letzte Stelle des Baumes die betrachet werden soll
    
    public static void heapSort(int[] array) {
        generateMaxHeap(array);							// Erstellung BinärBaum
        printArray(array);								
        for(int index = array.length - 1; index > 0; index--) {
            swap(array, index, 0);									
            printArray(array);
            compareAndSwap(array, 0, index);
            printArray(array);
        }
    }
    
    //Erstellt MaxHeapBaum im Array
    public static void generateMaxHeap(int[] array) {

        for(int i = (array.length / 2) - 1; i >= 0; i--) {		// geteilt durch 2, da bei jedem Swap 2 Zahlen vertauscht werden und Index bei 0 beginnt
            compareAndSwap(array, i, array.length);
            //System.out.println(i);
        }
    }
     
    public static void compareAndSwap(int[] array, int parentIndex, int lastIndex) {

        while(parentIndex <= (lastIndex / 2) - 1) {
            int childIndex = ((parentIndex + 1) * 2) - 1;  //Index des linken Kindes

            if (childIndex + 1 <= (lastIndex - 1)) {	//Prüfung, ob es ein Parent hat
                if(array[childIndex] < array[childIndex + 1]) {  //Vergleich der Kinder 
                    childIndex++;
                }
            }

            //Prüfung ob Swap nötig ist
            if(array[parentIndex] < array[childIndex]) {
                swap(array, parentIndex, childIndex);
                parentIndex = childIndex;				
            }else break;
        }


    }
    
    public static void swap(int[] array, int parentIndex, int childIndex) {
        int z = array[parentIndex];
        array[parentIndex] = array[childIndex];
        array[childIndex] = z;
    }

   
   

    
     public static void printArray(int arr[]) 			//Ausgabe, nur schön mit zweistelligen Werten ;)
        { 
            int n = arr.length; 
           
                System.out.println(" " +" " + " " + " " + " " + " " + arr[0]+" "); 
                System.out.println(" " +" " + " " + " " + " " + "/ " + " \\");
            	System.out.println(" " +" " + " " + " " + arr[1] + " " +  " " + " " + arr[2]);
            	System.out.println(" " +" " + " /" + " \\" + "   /" + " \\ ");
            	System.out.println("  " + arr[3] + " " +  arr[4] + " " + arr[5] + " " + arr[6]);
            	System.out.println(" /");
            	System.out.println(arr[7]);
            System.out.println(); 
        } 
}

