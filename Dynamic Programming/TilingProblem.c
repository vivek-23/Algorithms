/*
Given a floor of dimensions 2 x W and tiles of dimensions 2 x 1, write code to find the number of ways the floor can be tiled. A tile can either be placed horizontally i.e as a 1 x 2 tile or vertically i.e as 2 x 1 tile.

Input:

The first line of input contains an integer T denoting the number of test cases.
The first line of each test case is W.

Output:

Print number of ways the floor can be tiled in a separate line.

Constraints:

1 ≤ T ≤ 50
1 ≤ W ≤ 70

Example:

Input
2
5
3

Output
8
3
*/

long long int dp[100]={0};

int max(int a,int b){
  return a > b ? a : b;
}

int min(int a,int b){
  return a < b ? a : b;
}


void someFunction()
{
	int i;
	dp[1] = 1;
	dp[2] = 2;
	for(i=3;i<=70;++i){
	    dp[i] = dp[i-1] + dp[i-2];
	}
}


void input()
{
	int i,n,t;
	scanf("%d",&t);
	someFunction();

	while(t--)
	{
		scanf("%d",&n);
		printf("%lld\n",dp[n]);
	}


}


int main()
{
    input();
	return 0;
}
