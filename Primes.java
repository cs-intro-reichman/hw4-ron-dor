public class Primes {
    public static void main(String[] args) {
        // Replace this statement with your code
        int nMax = Integer.parseInt(args[0]);
        boolean[] numArray = new boolean[nMax+1];
        // Initialize an array where arr[i>1]=T.
        for (int i = 0; i < numArray.length; i++) {
            if (i >= 2) {
                numArray[i] = true;
            } else {
                numArray[i] = false;
            }
        }
        for (int i = 0; i <= Math.sqrt(nMax); i++) {
            if (numArray[i] == true) {
                for (int j = i*i; j <= nMax; j+=i) {
                    numArray[j] = false;
                }
            }
        }
        int countPrime = 0;
        for (int i = 0; i < numArray.length; i++) {
            if (numArray[i] == true) {
                System.out.println(i);
                countPrime++;
            }
        }
        int pctCountInt = (int) (((double) countPrime / nMax) * 100);
        System.out.println("There are " + countPrime + " primes between 2 and " + nMax + " (" + pctCountInt + "% are primes)");
    }
}