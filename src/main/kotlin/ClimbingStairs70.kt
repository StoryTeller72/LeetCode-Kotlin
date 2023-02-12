
//You are climbing a staircase. It takes n steps to reach the top.
//Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
class ClimbingStairs70 {
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