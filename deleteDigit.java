/*Given some integer, find the maximal number you can obtain by deleting exactly one digit of the given number.

Example

For n = 152, the output should be
deleteDigit(n) = 52;
For n = 1001, the output should be
deleteDigit(n) = 101.
*/
//Brute Force solution
int deleteDigit(int n) {
		String s = "" + n;
		char[] array = s.toCharArray();
		int max = 0;
		for(int i = 0;i<array.length;i++)	{
			String temp = "";
			System.out.print("Number: ");
			// delete a digit -- or in this case --
			// ignore the current digit/character in focus and concatenate the others
			for(int j = 0;j<array.length;j++)	{
				if(j == i)
					continue;
				System.out.print(array[j]);
				temp+=array[j];
			}System.out.println("");

			// update max
			if(Integer.parseInt(temp) > max)
				max = Integer.parseInt(temp);
		}

		return max;
	}
  
  //Optimised Solution
  int deleteDigit(int n)
{
    int max = 0;
    for (int t = 1; t < n; t *= 10)
        max = Math.max(n / 10 / t * t + n % t, max);
    return max;
}
