package arrays;

public class Arrays {
    public static void main(String[] args) {
        Arrays arr =  new Arrays();
        int[] array = new int[] {8,9,3,0,7,63,90,24,5};
        arr.printArray(array);
        int[] res = removingEvenInt(array);
        arr.printArray(res);

        int[] result = reverseArray(array);
        arr.printArray(result);
        int min = findMin(array);
        System.out.println(min);
        findMaxAndSecondMax(array);

        int[] movetoend = moveToEndOfArray(new int[] {0,1,2,2,5,0,12,2},2);
        arr.printArray(movetoend);
        int[] resized =resizeArray(array,array.length*2);
        arr.printArray(resized);
        int missingNumber = arr.findMissingNumber(new int[] {6,7,4,3,2,1});
        System.out.print(missingNumber);;
    }


    // printing arrays
    public  void printArray(int[] args){
        for (int arg : args) {
            System.out.print(arg + " ");
        }
        System.out.println();
    }

    // removing even integers from the array
    public static int[] removingEvenInt(int[] args){
        int oddCount = 0;
        for(int arr: args){
            if(arr%2!=0){
                oddCount++;
            }
        }
        //initializing result with assigning the size of an array with odd count
        int[] res = new int[oddCount];
        int idx = 0;
        //older way
        for (int i=0;i<args.length;i++){
            if (args[i]%2!=0){
                res[idx] = args[i];
                idx++;
            }
        }
        return res;

    }

    // Reversing an array
    public static  int[] reverseArray(int[] args){
        int start=0;
        int end = args.length - 1;
        while (start < end){
            int temp= args[start];
            args[start]= args[end];
            args[end]= temp;
            start++;
            end--;
        }
        return args;
    }

    //Finding minimum value in an array
    public static int findMin(int[] args){
        int min= args[0];
        for (int arr: args){
            if (arr<min){
                min = arr;
            }
        }
        return min;
    }

    //finding maximum and second maximum value in an array
    public static void findMaxAndSecondMax(int[] arr){
        int max = Integer.MIN_VALUE;
        int secondMax = Integer.MIN_VALUE;
        for (int num: arr){
            if (num>max){
                secondMax = max;
                max= num;
            } else if (num > secondMax && num !=max) {
                secondMax = num;
            }
        }
        System.out.println("Max number: " + max);
        System.out.println("Second Max number: " + secondMax);
    }
    //moving numbers to the end off an array for example zeros
    public static  int[] moveToEndOfArray(int[] array,int value){
        int j = 0;
        int n = array.length;
        for (int i = 0;i<n;i++){
            if (array[i] != value && array[j] == value){
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
            if (array[j]!=value){
                j++;
            }
        }
        return array;
    }

    // Resizing an array
    public static int[] resizeArray(int[] array,int capacity){
        int[] temp = new int[capacity];
        for (int i = 0;i<array.length;i++){
            temp[i] = array[i];
        }
        return temp;
    }

    //Finding the missing number in an array in o(n) complexity
    public int findMissingNumber(int[] arr){
        int n = arr.length + 1;
        int sum = n*(n+1)/2;
        for (int num: arr){
            sum = sum - num;
        }
        return sum;
    }

}
