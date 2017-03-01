/* Dynamic Programming Java implementation of LCS problem
 * http://www.geeksforgeeks.org/dynamic-programming-set-4-longest-common-subsequence/
 *
 */


package Dynamic_Programming;

public class LCS {

    /* Returns length of LCS for X[0..m-1], Y[0..n-1] */
    public int lcs(String X, String Y, int m, int n) {

        int[][] L = new int[ m + 1][n + 1];
        int i, j;

   /* Following steps build L[m+1][n+1] in bottom up fashion. Note
      that L[i][j] contains length of LCS of X[0..i-1] and Y[0..j-1] */
        for (i = 0; i <= m; i++) {
            for (j = 0; j <= n; j++) {
                if (i == 0 || j == 0)
                    L[i][j] = 0;

                else if (X.charAt(i - 1) == Y.charAt(j - 1))
                    L[i][j] = L[i - 1][j - 1] + 1;

                else
                    L[i][j] = max(L[i - 1][j], L[i][j - 1]);
            }
        }

   /* L[m][n] contains length of LCS for X[0..n-1] and Y[0..m-1] */
        return L[m][n];
    }

    /* Utility function to get max of 2 integers */
    public int max(int a, int b) {
        return (a > b) ? a : b;
    }

    /* Driver program to test above function */
    public static void main(String args[]) {
        LCS go = new LCS();
        String X = "AGGTAB";
        String Y = "GXTXAYB";

        int m = X.length();
        int n = Y.length();

        System.out.printf("Length of LCS is %d\n", go.lcs(X, Y, m, n));
    }
}