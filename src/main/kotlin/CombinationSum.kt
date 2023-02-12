//Given an array of distinct integers candidates and a target integer target, return a list of all unique combinations of candidates where the chosen numbers sum to target. You may return the combinations in any order.
//
//The same number may be chosen from candidates an unlimited number of times. Two combinations are unique if the
//frequency
//of at least one of the chosen numbers is different.
//
//The test cases are generated such that the number of unique combinations that sum up to target is less than 150 combinations for the given input.
class CombinationSum {
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