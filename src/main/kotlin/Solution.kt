class Solution {
    fun combinationSum(candidates: IntArray, target: Int): List<List<Int>> {
        val  result: ArrayList<List<Int>> = arrayListOf()
        if (candidates.isEmpty()) return result

        candidates.sort()

        val combinations = ArrayList<Int>()

        toFindCombinationsToTarget(result, combinations, candidates, target, 0)
        return result
    }

    private  fun toFindCombinationsToTarget(result: ArrayList<List<Int>>, combinations: ArrayList<Int>, candidates: IntArray, target: Int, startIndex: Int ){
        if (target == 0){
            result.add(combinations.toList())
            return
        }

        for (i in startIndex until candidates.size){
            if (candidates[i] > target) break

            combinations.add(candidates[i])
            toFindCombinationsToTarget(result, combinations, candidates, target- candidates[i], i)
            combinations.removeAt(combinations.size - 1)
        }
    }
}