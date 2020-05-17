/* Define a word as a sequence of consecutive English letters. Find the longest word from the given string.

Example

For text = "Ready, steady, go!", the output should be
longestWord(text) = "steady".
*/
String longestWord(String text) {
    String[] arr = text.split("[^a-zA-Z]");
    String t ="";
    for (int i=0; i<arr.length; i++) {
        if (arr[i].length()>t.length()) {
            t= arr[i];
        }
    }
    return t;

}
