'''
Define a word as a sequence of consecutive English letters. Find the longest word from the given string.

Example

For text = "Ready, steady, go!", the output should be
longestWord(text) = "steady".
'''
def longestWord(text):
    return max(re.split('[^a-zA-Z]', text), key=len)

