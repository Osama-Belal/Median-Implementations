### Median Implementation
There are three ways to compute the median. <br>
The first use of this repository is to compare their performance. <br>
The three methods are:<br>
- The randomized divide-and-conquer approach [CLRS 9.2].
- The deterministic linear-time selection algorithm using median-of-medians [CLRS9.3].
- The naive method using sorting and returning the k-th smallest number.
<br>
Implemented the first two methods only, and used native sorting for the last one.<br>
The arrays used for the analysis are randomly generated. <br>
For each data point, the average of multiple runs was computed.<br>

### Maximum side length
Given a set of two-dimensional points, the goal is to compute the maximum side length<br>
of the square that can be drawn around each point, such that no two squares intersect,<br>
except at the sides.<br>

Notes:
- Each point will be at the center of the square around it.
- The sides of the squares can only be horizontal and vertical.

This program solves this problem using a divide-and-conquer approach<br>
of finding the closest pair of points.<br>

Input file:
The input to your program is a single file that has one test case. The test case <br>
starts with the number of points on a single line, followed by each point on a separate <br>
line. All inputs will be integers. The number of points can be up to 10^6 points, and each <br>
dimension of the points is in the range -10^6 to 10^6. <br>

**Sample case:** <br>
Input <br> <br>
4 <br>
1 1 <br>
3 3 <br>
5 5 <br>
6 6 <br> <br>
Output <br>
1
