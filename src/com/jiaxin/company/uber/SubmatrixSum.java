//submatrix sum
//O(n^3)
precompute can be done like this ..

sum[0][0] = matrix[0][0]
for first row
sum[0][j] = sum[0][j-1] + matrix[0][j]
for first column
sum[i][0] = sum[i-1][0] + matrix[i][0]
for all other rows and columns
sum[i][j] = matrix[i][j] + sum[i-1][j] + sum[i][j-1] - sum[i-1][j-1]


// a is input array .. filled with sample inputs
int a[][] = {
{1,1,1,1,1},
{2,2,2,2,2},
{3,3,3,3,3},
{4,4,4,4,4},
{5,5,5,5,5}
};
int sum[][] = new int[a.length][a[0].length];
sum[0][0] = a[0][0];
for(int i=1;i<a.length;i++){
sum[i][0] = sum[i-1][0] + a[i][0];
}
for(int j=1;j<a[0].length;j++){
sum[0][j] = sum[0][j-1] + a[0][j];
}
for(int i=1; i<a.length;i++) {
for(int j=1; j<a[0].length;j++) {
sum[i][j] = a[i][j]
+ sum[i][j-1]
+ sum[i-1][j]
- sum[i-1][j-1];
}
}

public class Solution {
    /**
     * @param matrix an integer matrix
     * @return the coordinate of the left-up and right-down number
     */
    public int[][] submatrixSum(int[][] matrix) {
        int[][] result = new int[2][2];
        int M = matrix.length;
        if (M == 0) return result;
        int N = matrix[0].length;
        if (N == 0) return result;
        // pre-compute: sum[i][j] = sum of submatrix [(0, 0), (i, j)]
        int[][] sum = new int[M+1][N+1];
        for (int j=0; j<=N; ++j) sum[0][j] = 0;
        for (int i=1; i<=M; ++i) sum[i][0] = 0;
        for (int i=0; i<M; ++i) {
            for (int j=0; j<N; ++j)
                sum[i+1][j+1] = matrix[i][j] + sum[i+1][j] + sum[i][j+1] - sum[i][j];
        }
        for (int l=0; l<M; ++l) {
            for (int h=l+1; h<=M; ++h) {
                Map<Integer, Integer> map = new HashMap<Integer, Integer>();
                for (int j=0; j<=N; ++j) {
                    int diff = sum[h][j] - sum[l][j];
                    if (map.containsKey(diff)) {
                        int k = map.get(diff);
                        result[0][0] = l;   result[0][1] = k;
                        result[1][0] = h-1; result[1][1] = j-1;
                        return result;
                    } else {
                        map.put(diff, j);
                    }
                }
            }
        }
        return result;
    }
}