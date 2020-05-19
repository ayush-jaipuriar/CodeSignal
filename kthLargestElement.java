/*
Note: Avoid using built-in std::nth_element (or analogous built-in functions in languages other than C++) when solving this challenge. Implement them yourself, since this is what you would be asked to do during a real interview.

Find the kth largest element in an unsorted array. This will be the kth largest element in sorted order, not the kth distinct element.

Example

For nums = [7, 6, 5, 4, 3, 2, 1] and k = 2, the output should be
kthLargestElement(nums, k) = 6;
For nums = [99, 99] and k = 1, the output should be
kthLargestElement(nums, k) = 99.
*/
int kthLargestElement(int[] nums, int k) {
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    for (int val: nums) {
        pq.add(val);
        if (pq.size()>k) {
            pq.remove();
        }
    }
    return pq.peek();

}
