'''
For the opening ceremony of the upcoming sports event an even number of athletes were picked. They formed a correct lineup, i.e. such a lineup in which no two boys or two girls stand together. The first person in the lineup was a girl. As a part of the performance, adjacent pairs of athletes (i.e. the first one together with the second one, the third one together with the fourth one, etc.) had to swap positions with each other.

Given a list of athletes, return the list of athletes after the changes, i.e. after each adjacent pair of athletes is swapped.

Example

For athletes = [1, 2, 3, 4, 5, 6], the output should be
correctLineup(athletes) = [2, 1, 4, 3, 6, 5].
'''

def correctLineup(athletes):
    return [val for item in [a for a  in zip([e for i, e in enumerate(athletes) if i % 2 !=0],[e for i, e in enumerate(athletes) if i % 2 ==0])] for val in item]
