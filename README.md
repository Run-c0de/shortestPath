### Shortest Path

#### Problem Description
The task is to implement a function called `ShortestPath` that takes an array of strings `strArr` as input, which models a non-looping graph. The array `strArr` represents the structure of the graph, where the first element is the number of nodes `N`, followed by `N` elements representing the nodes themselves, and finally, the connections between the nodes. The connections are represented as pairs of nodes connected by a hyphen (e.g., "A-B", "B-C").

The function should return the shortest path from the first node to the last node in the array separated by dashes. If no path exists between the first and last node, the function should return -1.

#### Examples

- Input: `["5","A","B","C","D","F","A-B","A-C","B-C","C-D","D-F"]`
  Output: `A-C-D-F`

- Input: `["4","X","Y","Z","W","X-Y","Y-Z","X-W"]`
  Output: `X-W`

#### Function Signature
```javascript
function ShortestPath(strArr: string[]): string | number
