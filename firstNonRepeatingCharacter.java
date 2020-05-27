/*
Given a string s consisting of small English letters, find and return the first instance of a non-repeating character in it. If there is no such character, return '_'.

Example

For s = "abacabad", the output should be
firstNotRepeatingCharacter(s) = 'c'.

There are 2 non-repeating characters in the string: 'c' and 'd'. Return c since it appears in the string first.

For s = "abacabaabacaba", the output should be
firstNotRepeatingCharacter(s) = '_'.

There are no characters in this string that do not repeat.
*/

char firstNotRepeatingCharacter(String s) {
    Map<Character, Integer> hash = new HashMap<>();
    for (int i=0; i<s.length(); i++) {
        Character ch = s.charAt(i);
        if (!hash.containsKey(ch)) {
            hash.put(ch, 1);
        } else {
            hash.put(ch, hash.get(ch)+1);
        }
    }
    for (int i=0; i<s.length(); i++) {
        Character ch = s.charAt(i);
        if (hash.get(ch)==1) {
            return ch;
        }
    }
    return '_';
    
}
