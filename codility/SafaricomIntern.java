package codility;


/*
 * There are N boxes (number from 0 to N-1) arranged in a row.the Kth box contain A[K] bricks.
 * In one move you can take one brick from some boxes and move it to a box next to it (on the left or on the right).
 * What is the miimum number of moves needed to end up with exactly 10 bricks in every box?
 * 
 * write a function
 * function solution(A);
 * that given an array A of N integers, returns the minimum number of moves needed to end up with exactly 10 bricks in every box.
 * if this is not possile, the funxtion should return -1
 * 
 * Exampls:
 * 1. For A=[7,15,10,8] the function should return 7. You can perform the following sequence of moves:
 *    - move three bricks from box number 1 to the box on the left: [10,12,10,8]
 *    - move two bricks from box number 1 to the box on the right[10,10,12,8]
 *    - finally move two bricks from box number 2 to the last ox [10,10,10,10]
 * 2. For A = [11,10,8,12,8,10,11], the function should return 6. You can perform the following sequence of moves
 *    - move a brick from box number 0 to box number 2 (using two moves)
 *    - move a brick from the last box two position to the left(using two moves)
 *    - move a brick from the middle box to each of its neighbous(another two moves)
 * 3. For A=[7,14,10], the function should return -1. it is not possible to end up with exactly 10 bricks in each box
 * 
 * Assume that:
 *    - N is an integer within the range [1..20]
 *    - each element of array A is an integer within the range[0..200]
 */
class SafaricomIntern {
    public Integer solution(int[] A) {
        int total = 0;
        for (int num : A) {
            total = total + num;
        }
        int N = A.length;
        if (total != 10 * N) {
            return -1;
        }
        
        int moves = 0;
        int allBricks = 0;
        for (int i = 0; i < N; i++) {
            int diff = A[i] - 10;
            allBricks = allBricks+diff;
            if (i < N - 1) {
                moves = moves +  Math.abs(allBricks);
            }
        }
        return moves;
    }
    public static void main(String[] args) {
        SafaricomIntern internQ1 = new SafaricomIntern();
        System.out.println(internQ1.solution(new int[] {7,15,10,8}));
    }


}