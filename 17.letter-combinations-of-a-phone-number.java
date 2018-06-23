/*
 * [17] Letter Combinations of a Phone Number
 *
 * https://leetcode.com/problems/letter-combinations-of-a-phone-number/description/
 *
 * algorithms
 * Medium (36.97%)
 * Total Accepted:    248.2K
 * Total Submissions: 668.5K
 * Testcase Example:  '"23"'
 *
 * Given a string containing digits from 2-9 inclusive, return all possible
 * letter combinations that the number could represent.
 * 
 * A mapping of digit to letters (just like on the telephone buttons) is given
 * below. Note that 1 does not map to any letters.
 * 
 * 
 * 
 * Example:
 * 
 * 
 * Input: "23"
 * Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * 
 * 
 * Note:
 * 
 * Although the above answer is in lexicographical order, your answer could be
 * in any order you want.
 * 
 */
class Solution {
    public List<String> letterCombinations(String digits) {
	List<String> res = new LinkedList<String>();
	if (digits.contains("1") || digits.length() == 0) return res;
	HashMap<Character, String[]> map = new HashMap<Character, String[]>();
	map.put('2', new String[] {"a", "b", "c"});
	map.put('3', new String[] {"d", "e", "f"});
	map.put('4', new String[] {"g", "h", "i"});
	map.put('5', new String[] {"j", "k", "l"});
	map.put('6', new String[] {"m", "n", "o"});
	map.put('7', new String[] {"p", "q", "r", "s"});
	map.put('8', new String[] {"t", "u", "v"});
	map.put('9', new String[] {"w", "x", "y", "z"});
	char[] digitsChar = digits.toCharArray();
	for (int i = 0; i < digitsChar.length; i++) {
	    char c = digitsChar[i];
	    int currSize = res.size();
	    if (currSize == 0) {
		assert(i == 0);
	    	for (String s : (String[]) map.get(c)) res.add(s); 
		continue;
	    }
	    for (int m = currSize - 1; m >= 0; m--) {
	    	String cand = res.remove(0);
		for (String s : (String[]) map.get(c)) {
		    res.add(cand + s);
		}
	    }
	}
	return res;        
    }
}
