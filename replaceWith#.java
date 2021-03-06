/*Implement a function that replaces each digit in the given string with a '#' character.

Example

For input = "There are 12 points", the output should be
replaceAllDigitsRegExp(input) = "There are ## points".
*/


String replaceAllDigitsRegExp(String input) {
    var sb= new StringBuilder();
    for (int i=0; i<input.length(); i++) {
        if (Character.isDigit(input.charAt(i))) {
            sb.append("#");
        } else {
            sb.append(input.charAt(i));
        }
    }
    return sb.toString();

}
