/*
Given a rectangular matrix containing only digits, calculate the number of different 2 × 2 squares in it.

Example

For

matrix = [[1, 2, 1],
          [2, 2, 2],
          [2, 2, 2],
          [1, 2, 3],
          [2, 2, 1]]
the output should be
differentSquares(matrix) = 6.

Here are all 6 different 2 × 2 squares:

1 2
2 2
2 1
2 2
2 2
2 2
2 2
1 2
2 2
2 3
2 3
2 1
Input/Output

[execution time limit] 3 seconds (java)

[input] array.array.integer matrix

Guaranteed constraints:
1 ≤ matrix.length ≤ 100,
1 ≤ matrix[i].length ≤ 100,
0 ≤ matrix[i][j] ≤ 9.
*/

int differentSquares(int[][] matrix) {
    Set<String> hashSet = new HashSet<>();
    for (int i=1; i<matrix.length; i++) {
        for (int j=1; j<matrix[i].length; j++) {
            hashSet.add(matrix[i-1][j-1]+""+matrix[i-1][j]+""+matrix[i][j-1]+matrix[i][j]);
        }
    }
    return hashSet.size();

}
