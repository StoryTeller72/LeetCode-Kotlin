class Solution {
    fun climbStairs(n: Int): Int {
        if(n <= 1) return 1

        val ways = IntArray(n+1)
        ways[0] = 1
        ways[1] = 1

        for(i in 2 .. n){
            ways[i] = ways[i - 2] + ways[i - 1]
        }
        return ways[n]
    }
}