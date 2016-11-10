README

Runtime Analysis

The search method for a binary search tree is normally considered O(log n). When
a binary search tree is created, every value that is added is placed in order.
If the value of the root of the tree is null, then the value is added to the root
of the tree. If the value of the root is not null, the value to be added is
checked to see if it is larger or smaller then the root. If it is smaller, the
left child is checked to see if it is null. If it is, the value of the left root 
becomes that of the value to be added. If the left child is not null, it is
compared to the value to be added as if it was a root. If the value to be added
is larger than the root, the right child is checked to see if it is null. If it 
is, the value of the right root becomes that of the value to be added. If the 
right child is not null, it is compared to the value to be added as if it was a
root. 

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
through it is big O O(n), because each number has to be traversed
individually.

Even though this poorly configured binary search tree is possible, we will
just consider binary search trees as a whole as a big O of O(log n). 

Contributors:
	For this assignment, most of the code was already written in the text book,
so I copied what was useful and used it in my assignment. Probably about 80% 
of what is in this project was either copied straight out of the book or
given to us by professor Moore.