README

Runtime Analysis

The search method for a binary search tree is normally considered O(log n). When
a binary search tree is created, every value that is added is placed in order.
If the value of the root of the tree is null, then the value is added to the root
of the tree. If the value of the root is not null, the value to be added is
checked to see if it is larger or smaller then the root. If it is smaller, the
left child is checked to see if it is null. If it is, the value of the left child
becomes that of the value to be added. If the left child is not null, it is
compared to the value to be added as if the left child was a root. If the value
to be added is larger than the root, the right child is checked to see if it is
null. If it is, the value of the right child becomes that of the value to be
added. If the right child is not null, it is compared to the value to be added as
if the right child was a root. 

	This structure looks something like this:

										12
                                     ___/\___
                                    /        \
                                   9         13
                               ___/            \___
                              /                    \
                             8                     27
                         ___/                  ___/  \___
                        /                     /          \
                       4                     20          73
                   ___/ \___                  \          /
                  /         \                  \        /
                 1           7                 25      41
                            /                         /
                           /                         /
                          5                         30
                          \
                           \
                            6 

This type of structure allows the tree to be searched one level at a time. In
an ideal situation, the tree would have had numbers added to it so that each 
node has two children. In that case, each level traversed would get rid of
half of the numbers left. When this happens, the big O really is O(log n). 

However, it really depends on how the tree is structured. If the list was sorted
before adding it to the tree, then the tree would look like this.

   1
    \
     4
      \
       5
        \
         6
          \
           7
            \
             8
              \
               9
                \
                 12  ... and so on all the way to  73

This is basically a singularly linked list. Which means that searching
through it is O(n), because each node has to be traversed
individually.

Even though this poorly configured binary search tree is possible, we will
just consider binary search trees, as a whole, O(log n). 

The big O of the add method, which does the sorting in the binary search tree
is O(n log n) this is because the search method is O(log n) and the find method
searches for every item that it adds.

O(n log n) is a pretty good big O for a sort method. Some of the other methods
that we have used earlier in the semester are much less efficient, being O(n^2).

Selection sort, insertion sort and bubble sort are all O(n^2). From the earlier
assignments, we have seen that Selection sort is typically the most efficient of
the three, followed by Insertion Sort and lastly Bubble Sort. To see how much of
a difference there is between O(n^2) and O(n log n), the methods have each been
tested sorting 5000 random numbers 1000 times and then the average amount of 
time for those 1000 sorts has been recorded in the file "sortTest.txt".

These are the results:


Bubble Sort 
Average number of comparisons: 12492676
Average number of swaps: 6247651
Average sort time: 137819419 nano Seconds 

Insertion Sort 
Average number of comparisons: 6250810
Average number of swaps: 6245811
Average sort time: 74272457 nano Seconds 

Selection Sort 
Average number of comparisons: 12502499
Average number of swaps: 32490
Average sort time: 73505216 nano Seconds 

Binary Search Tree Sort 
Average sort time: 2279681 nano Seconds 

These results are from sorting 5000 random numbers. It is easy to see that
the Binary Search Tree does the best job. However with the numbers already
sorted, the Binary Search Tree is much less efficient. Here are the results
for sorting 5000 numbers that are already sorted, the first is for sorting
ascending numbers (0 - 4999) and the second is for sorting numbers (4999 -
0). The slight difference in the two average times (about .2 seconds) is 
most likely due to the way that the sort is written to check for smaller
numbers first and larger numbers second. That means that each time the 
sort checks for the numbers in the ascending case, it first checks if the
number is smaller, realizes that it is not, and then checks to see if the 
number is larger, while sorting the descending case, it only checks to see
if the number is smaller, and since it is every time, it does not have to
check to see if the number is larger.

Binary Search Tree Sort 
Corner case: ascending 
Average sort time: 161446700 nano Seconds 

Binary Search Tree Sort 
Corner case: descending 
Average sort time: 137502267 nano Seconds 

Contributors:
	Professor Moore.
	There was a lot of code already written in the text book "Data Structures:
		Abstraction and Design using Java"
