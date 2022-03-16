package bsu.comp250;

public class BinarySearch {
    public static void main(String[] args) {
        int size = 1000000000;
        int[] nums = new int[size];
        int n = size-1;
        int times = 15;

        for(int i = 1; i <= size; ++i) {
            nums[i-1] = i;
        }

        double timeSoFar = 0;

        for(int i = 0; i < times; ++i) {
            double start = System.nanoTime();
            binarySearch(nums, 0, nums.length-1, n);
            double end = System.nanoTime();
            double time = (end - start) / 1000000;
            timeSoFar += time;
        }

        System.out.printf("Finding %d in nums of size %d took %f milliseconds on average.\n", n, nums.length, (timeSoFar/times));
        double timeSoFar2 = 0;

        for(int i = 0; i < times; ++i) {
            double start2 = System.nanoTime();
            linearSearch(nums, n);
            double end2 = System.nanoTime();
            double time2 = (end2 - start2) / 1000000;
            timeSoFar2 += time2;
        }

        System.out.printf("Finding %d in nums of size %d took %f milliseconds on average.\n", n, nums.length, (timeSoFar2/times));

//        if(result)
//            System.out.println("Number " + n + " was found in nums!");
//        else
//            System.out.println("Number " + n + " wasn't found in nums!");
    }

    public static boolean binarySearch(int[] nums, int low, int high, int target) {
        if(low > high)
            return false;

        int mid = (low + high) / 2;

        if(nums[mid] == target)
            return true;
        else if(target < nums[mid])
            return binarySearch(nums, low, mid - 1, target);
        else
            return binarySearch(nums, mid + 1, high, target);
    }

    public static boolean linearSearch(int[] nums, int target) {
        for(int i = 0; i < nums.length; ++i) {
            if(i == target) {
                return true;
            }
        }
        return false;
    }
}
