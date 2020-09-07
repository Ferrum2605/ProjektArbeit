package heapSort;

public class Startklasse {

    public static void main(String[] args) {

        int [] array = {55, 22, 15, 12, 48, 36, 88, 85};
        
        heapSort(array);
    }
    
    public static void heapSort(int[] array) {
    	System.out.println("1. Unsortierter, erster Binärbaum:");
    	printArray(array);
        generateMaxHeap(array);	
        System.out.println(" 2. Durch die Methode \"generateMaxHeap\" generierter Binärbaum: ");
        printArray(array);
        System.out.println("3. Weitere Binärbäume: ");
        
        for(int lastIndex = array.length - 1; lastIndex > 0; lastIndex--) {
            swap(array, lastIndex, 0);									
            printArray(array);
            compareAndSwap(array, 0, lastIndex);
            printArray(array);
        }
    }
    
    public static void generateMaxHeap(int[] array) {

        for(int i = (array.length / 2) - 1; i >= 0; i--) {		
            compareAndSwap(array, i, array.length);
            
        }
    }
    
    public static void compareAndSwap(int[] array, int parentIndex, int lastIndex) {
    														
        while(parentIndex <= (lastIndex / 2) - 1) {			
            int childIndex = ((parentIndex + 1) * 2) - 1; 	

            if (childIndex + 1 <= (lastIndex - 1)) {			
                if(array[childIndex] < array[childIndex + 1]) {   
                    childIndex++;
                }
            }

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
    
    
     public static void printArray(int arr[]) 			
        { 
            int n = arr.length; 
            	System.out.println();
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

