class Solution {
    public void rotate(int[][] ma) {
        int n = ma.length;

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int temp = ma[i][j];
                ma[i][j] = ma[j][i];
                ma[j][i] = temp;
            }
        }

        int i = 0, j = n - 1;

        while (i <= j) {
            for (int k = 0; k < n; k++) {
                int temp = ma[k][i];
                ma[k][i] = ma[k][j];
                ma[k][j] = temp;
            }
            i++;
            j--;
        }

    }
}