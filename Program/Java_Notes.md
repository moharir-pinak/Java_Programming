# COMPREHENSIVE JAVA NOTES

## 1. JAVA: COMPILED OR INTERPRETED?

Java is both compiled and interpreted, making it a unique hybrid language. Here's how it works:

### Java Compilation Process:
1. **Source Code to Bytecode (Compilation)**
   - Java source code (.java) is compiled into bytecode (.class)
   - This is done by the Java compiler (javac)
   - Bytecode is platform-independent
   - This step is compilation

2. **Bytecode to Machine Code (Interpretation)**
   - JVM interprets the bytecode
   - JIT (Just-In-Time) compiler converts frequently used bytecode to machine code
   - This step is interpretation

### Why This Hybrid Approach?
- **Platform Independence**: Bytecode can run on any platform with JVM
- **Performance**: JIT compilation provides near-native performance
- **Security**: Bytecode is verified before execution
- **Portability**: Write once, run anywhere

### Comparison with Other Languages:
1. **Pure Compiled Languages** (C, C++)
   - Directly compiled to machine code
   - Platform-dependent
   - Faster execution
   - No runtime overhead

2. **Pure Interpreted Languages** (Python, JavaScript)
   - No compilation step
   - Slower execution
   - Platform-independent
   - More flexible

3. **Java (Hybrid)**
   - Combines benefits of both
   - Platform-independent
   - Good performance
   - Secure execution

## 2. IMPORTANT ALGORITHMS

### Sorting Algorithms:

#### 1. Bubble Sort
```java
public void bubbleSort(int[] arr) {
    int n = arr.length;
    for (int i = 0; i < n-1; i++) {
        for (int j = 0; j < n-i-1; j++) {
            if (arr[j] > arr[j+1]) {
                // Swap elements
                int temp = arr[j];
                arr[j] = arr[j+1];
                arr[j+1] = temp;
            }
        }
    }
}
```
**Time Complexity**: O(n²)
**Space Complexity**: O(1)
**Best for**: Small datasets, educational purposes

#### 2. Quick Sort
```java
public void quickSort(int[] arr, int low, int high) {
    if (low < high) {
        int pi = partition(arr, low, high);
        quickSort(arr, low, pi-1);
        quickSort(arr, pi+1, high);
    }
}

private int partition(int[] arr, int low, int high) {
    int pivot = arr[high];
    int i = (low-1);
    
    for (int j = low; j < high; j++) {
        if (arr[j] < pivot) {
            i++;
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }
    
    int temp = arr[i+1];
    arr[i+1] = arr[high];
    arr[high] = temp;
    
    return i+1;
}
```
**Time Complexity**: O(n log n) average, O(n²) worst
**Space Complexity**: O(log n)
**Best for**: Large datasets, general-purpose sorting

#### 3. Merge Sort
```java
public void mergeSort(int[] arr, int left, int right) {
    if (left < right) {
        int mid = (left + right) / 2;
        mergeSort(arr, left, mid);
        mergeSort(arr, mid + 1, right);
        merge(arr, left, mid, right);
    }
}

private void merge(int[] arr, int left, int mid, int right) {
    int n1 = mid - left + 1;
    int n2 = right - mid;
    
    int[] L = new int[n1];
    int[] R = new int[n2];
    
    for (int i = 0; i < n1; i++)
        L[i] = arr[left + i];
    for (int j = 0; j < n2; j++)
        R[j] = arr[mid + 1 + j];
    
    int i = 0, j = 0, k = left;
    while (i < n1 && j < n2) {
        if (L[i] <= R[j]) {
            arr[k] = L[i];
            i++;
        } else {
            arr[k] = R[j];
            j++;
        }
        k++;
    }
    
    while (i < n1) {
        arr[k] = L[i];
        i++;
        k++;
    }
    
    while (j < n2) {
        arr[k] = R[j];
        j++;
        k++;
    }
}
```
**Time Complexity**: O(n log n)
**Space Complexity**: O(n)
**Best for**: Large datasets, stable sorting needed

### Searching Algorithms:

#### 1. Binary Search
```java
public int binarySearch(int[] arr, int target) {
    int left = 0;
    int right = arr.length - 1;
    
    while (left <= right) {
        int mid = left + (right - left) / 2;
        
        if (arr[mid] == target)
            return mid;
            
        if (arr[mid] < target)
            left = mid + 1;
        else
            right = mid - 1;
    }
    
    return -1;
}
```
**Time Complexity**: O(log n)
**Space Complexity**: O(1)
**Best for**: Sorted arrays

#### 2. Linear Search
```java
public int linearSearch(int[] arr, int target) {
    for (int i = 0; i < arr.length; i++) {
        if (arr[i] == target)
            return i;
    }
    return -1;
}
```
**Time Complexity**: O(n)
**Space Complexity**: O(1)
**Best for**: Unsorted arrays, small datasets

### Graph Algorithms:

#### 1. Breadth-First Search (BFS)
```java
public void bfs(Graph graph, int start) {
    boolean[] visited = new boolean[graph.V];
    Queue<Integer> queue = new LinkedList<>();
    
    visited[start] = true;
    queue.add(start);
    
    while (!queue.isEmpty()) {
        int vertex = queue.poll();
        System.out.print(vertex + " ");
        
        for (int neighbor : graph.adj[vertex]) {
            if (!visited[neighbor]) {
                visited[neighbor] = true;
                queue.add(neighbor);
            }
        }
    }
}
```
**Time Complexity**: O(V + E)
**Space Complexity**: O(V)
**Best for**: Shortest path in unweighted graphs

#### 2. Depth-First Search (DFS)
```java
public void dfs(Graph graph, int start) {
    boolean[] visited = new boolean[graph.V];
    dfsUtil(graph, start, visited);
}

private void dfsUtil(Graph graph, int vertex, boolean[] visited) {
    visited[vertex] = true;
    System.out.print(vertex + " ");
    
    for (int neighbor : graph.adj[vertex]) {
        if (!visited[neighbor])
            dfsUtil(graph, neighbor, visited);
    }
}
```
**Time Complexity**: O(V + E)
**Space Complexity**: O(V)
**Best for**: Cycle detection, topological sorting

### Dynamic Programming:

#### 1. Fibonacci with Memoization
```java
public int fibonacci(int n) {
    int[] memo = new int[n + 1];
    return fibonacciHelper(n, memo);
}

private int fibonacciHelper(int n, int[] memo) {
    if (n <= 1) return n;
    if (memo[n] != 0) return memo[n];
    
    memo[n] = fibonacciHelper(n-1, memo) + fibonacciHelper(n-2, memo);
    return memo[n];
}
```
**Time Complexity**: O(n)
**Space Complexity**: O(n)
**Best for**: Avoiding redundant calculations

#### 2. Longest Common Subsequence
```java
public int lcs(String text1, String text2) {
    int m = text1.length();
    int n = text2.length();
    int[][] dp = new int[m + 1][n + 1];
    
    for (int i = 1; i <= m; i++) {
        for (int j = 1; j <= n; j++) {
            if (text1.charAt(i-1) == text2.charAt(j-1))
                dp[i][j] = dp[i-1][j-1] + 1;
            else
                dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
        }
    }
    return dp[m][n];
}
```
**Time Complexity**: O(mn)
**Space Complexity**: O(mn)
**Best for**: String comparison, DNA sequencing

## 3. ALGORITHM COMPLEXITY ANALYSIS

### Time Complexity:
- O(1): Constant time
- O(log n): Logarithmic time
- O(n): Linear time
- O(n log n): Linearithmic time
- O(n²): Quadratic time
- O(2^n): Exponential time

### Space Complexity:
- O(1): Constant space
- O(n): Linear space
- O(n²): Quadratic space

### Best Practices:
1. Always consider both time and space complexity
2. Choose algorithms based on input size
3. Consider worst-case scenarios
4. Profile your code for real-world performance

## 4. COMMON ALGORITHM PATTERNS

### Two Pointers:
```java
public int[] twoSum(int[] arr, int target) {
    int left = 0;
    int right = arr.length - 1;
    
    while (left < right) {
        int sum = arr[left] + arr[right];
        if (sum == target)
            return new int[]{left, right};
        else if (sum < target)
            left++;
        else
            right--;
    }
    return new int[]{-1, -1};
}
```

### Sliding Window:
```java
public int maxSumSubarray(int[] arr, int k) {
    int maxSum = 0;
    int windowSum = 0;
    int start = 0;
    
    for (int end = 0; end < arr.length; end++) {
        windowSum += arr[end];
        
        if (end >= k - 1) {
            maxSum = Math.max(maxSum, windowSum);
            windowSum -= arr[start];
            start++;
        }
    }
    return maxSum;
}
```

### Backtracking:
```java
public List<List<Integer>> subsets(int[] nums) {
    List<List<Integer>> result = new ArrayList<>();
    backtrack(result, new ArrayList<>(), nums, 0);
    return result;
}

private void backtrack(List<List<Integer>> result, List<Integer> temp, int[] nums, int start) {
    result.add(new ArrayList<>(temp));
    
    for (int i = start; i < nums.length; i++) {
        temp.add(nums[i]);
        backtrack(result, temp, nums, i + 1);
        temp.remove(temp.size() - 1);
    }
}
```

Remember to:
1. Practice implementing these algorithms
2. Understand the time and space complexity
3. Know when to use each algorithm
4. Test with different input sizes
5. Consider edge cases

The best way to master algorithms is through consistent practice and understanding the underlying concepts! 

## 5. ADDITIONAL ALGORITHMS AND REAL-WORLD APPLICATIONS

### Advanced Sorting Algorithms:

#### 1. Heap Sort
```java
public void heapSort(int[] arr) {
    int n = arr.length;
    
    // Build max heap
    for (int i = n/2 - 1; i >= 0; i--)
        heapify(arr, n, i);
    
    // Extract elements from heap
    for (int i = n-1; i > 0; i--) {
        int temp = arr[0];
        arr[0] = arr[i];
        arr[i] = temp;
        
        heapify(arr, i, 0);
    }
}

private void heapify(int[] arr, int n, int i) {
    int largest = i;
    int left = 2*i + 1;
    int right = 2*i + 2;
    
    if (left < n && arr[left] > arr[largest])
        largest = left;
    
    if (right < n && arr[right] > arr[largest])
        largest = right;
    
    if (largest != i) {
        int swap = arr[i];
        arr[i] = arr[largest];
        arr[largest] = swap;
        
        heapify(arr, n, largest);
    }
}
```
**Real-world Application**: Priority queues in task scheduling systems
**Interview Question**: "How would you implement a priority queue using a heap?"

#### 2. Counting Sort
```java
public void countingSort(int[] arr) {
    int max = Arrays.stream(arr).max().getAsInt();
    int[] count = new int[max + 1];
    int[] output = new int[arr.length];
    
    // Count occurrences
    for (int num : arr)
        count[num]++;
    
    // Modify count array
    for (int i = 1; i <= max; i++)
        count[i] += count[i-1];
    
    // Build output array
    for (int i = arr.length-1; i >= 0; i--) {
        output[count[arr[i]]-1] = arr[i];
        count[arr[i]]--;
    }
    
    // Copy output to original array
    System.arraycopy(output, 0, arr, 0, arr.length);
}
```
**Real-world Application**: Sorting by frequency in data analysis
**Interview Question**: "When would you choose counting sort over quicksort?"

### Advanced Searching Algorithms:

#### 1. Interpolation Search
```java
public int interpolationSearch(int[] arr, int target) {
    int low = 0;
    int high = arr.length - 1;
    
    while (low <= high && target >= arr[low] && target <= arr[high]) {
        if (low == high) {
            if (arr[low] == target) return low;
            return -1;
        }
        
        int pos = low + ((target - arr[low]) * (high - low)) / (arr[high] - arr[low]);
        
        if (arr[pos] == target)
            return pos;
        
        if (arr[pos] < target)
            low = pos + 1;
        else
            high = pos - 1;
    }
    return -1;
}
```
**Real-world Application**: Searching in uniformly distributed sorted data
**Interview Question**: "What's the difference between binary search and interpolation search?"

#### 2. Exponential Search
```java
public int exponentialSearch(int[] arr, int target) {
    if (arr[0] == target) return 0;
    
    int i = 1;
    while (i < arr.length && arr[i] <= target)
        i = i * 2;
    
    return binarySearch(arr, target, i/2, Math.min(i, arr.length-1));
}

private int binarySearch(int[] arr, int target, int left, int right) {
    while (left <= right) {
        int mid = left + (right - left) / 2;
        
        if (arr[mid] == target)
            return mid;
        
        if (arr[mid] < target)
            left = mid + 1;
        else
            right = mid - 1;
    }
    return -1;
}
```
**Real-world Application**: Searching in unbounded arrays
**Interview Question**: "How would you search in an infinite sorted array?"

### Advanced Graph Algorithms:

#### 1. Dijkstra's Algorithm
```java
public int[] dijkstra(int[][] graph, int source) {
    int V = graph.length;
    int[] dist = new int[V];
    boolean[] visited = new boolean[V];
    
    Arrays.fill(dist, Integer.MAX_VALUE);
    dist[source] = 0;
    
    for (int count = 0; count < V-1; count++) {
        int u = minDistance(dist, visited);
        visited[u] = true;
        
        for (int v = 0; v < V; v++) {
            if (!visited[v] && graph[u][v] != 0 && 
                dist[u] != Integer.MAX_VALUE && 
                dist[u] + graph[u][v] < dist[v])
                dist[v] = dist[u] + graph[u][v];
        }
    }
    return dist;
}

private int minDistance(int[] dist, boolean[] visited) {
    int min = Integer.MAX_VALUE;
    int min_index = -1;
    
    for (int v = 0; v < dist.length; v++) {
        if (!visited[v] && dist[v] <= min) {
            min = dist[v];
            min_index = v;
        }
    }
    return min_index;
}
```
**Real-world Application**: GPS navigation systems
**Interview Question**: "How would you modify Dijkstra's algorithm to find the k shortest paths?"

#### 2. Kruskal's Algorithm (Minimum Spanning Tree)
```java
public class KruskalMST {
    class Edge implements Comparable<Edge> {
        int src, dest, weight;
        
        public int compareTo(Edge compareEdge) {
            return this.weight - compareEdge.weight;
        }
    }
    
    class Subset {
        int parent, rank;
    }
    
    public void kruskalMST(Edge[] edges, int V) {
        Edge[] result = new Edge[V-1];
        int e = 0;
        int i = 0;
        
        Arrays.sort(edges);
        
        Subset[] subsets = new Subset[V];
        for (int v = 0; v < V; v++) {
            subsets[v] = new Subset();
            subsets[v].parent = v;
            subsets[v].rank = 0;
        }
        
        while (e < V-1) {
            Edge next_edge = edges[i++];
            
            int x = find(subsets, next_edge.src);
            int y = find(subsets, next_edge.dest);
            
            if (x != y) {
                result[e++] = next_edge;
                union(subsets, x, y);
            }
        }
    }
    
    private int find(Subset[] subsets, int i) {
        if (subsets[i].parent != i)
            subsets[i].parent = find(subsets, subsets[i].parent);
        return subsets[i].parent;
    }
    
    private void union(Subset[] subsets, int x, int y) {
        int xroot = find(subsets, x);
        int yroot = find(subsets, y);
        
        if (subsets[xroot].rank < subsets[yroot].rank)
            subsets[xroot].parent = yroot;
        else if (subsets[xroot].rank > subsets[yroot].rank)
            subsets[yroot].parent = xroot;
        else {
            subsets[yroot].parent = xroot;
            subsets[xroot].rank++;
        }
    }
}
```
**Real-world Application**: Network design, clustering
**Interview Question**: "What's the difference between Kruskal's and Prim's algorithms?"

### Advanced Dynamic Programming:

#### 1. Knapsack Problem
```java
public int knapsack(int[] weights, int[] values, int capacity) {
    int n = weights.length;
    int[][] dp = new int[n+1][capacity+1];
    
    for (int i = 1; i <= n; i++) {
        for (int w = 0; w <= capacity; w++) {
            if (weights[i-1] <= w)
                dp[i][w] = Math.max(values[i-1] + dp[i-1][w-weights[i-1]], dp[i-1][w]);
            else
                dp[i][w] = dp[i-1][w];
        }
    }
    return dp[n][capacity];
}
```
**Real-world Application**: Resource allocation, investment optimization
**Interview Question**: "How would you modify the knapsack algorithm to handle fractional items?"

#### 2. Matrix Chain Multiplication
```java
public int matrixChainOrder(int[] p) {
    int n = p.length;
    int[][] m = new int[n][n];
    
    for (int i = 1; i < n; i++)
        m[i][i] = 0;
    
    for (int L = 2; L < n; L++) {
        for (int i = 1; i < n-L+1; i++) {
            int j = i+L-1;
            m[i][j] = Integer.MAX_VALUE;
            
            for (int k = i; k < j; k++) {
                int q = m[i][k] + m[k+1][j] + p[i-1]*p[k]*p[j];
                m[i][j] = Math.min(m[i][j], q);
            }
        }
    }
    return m[1][n-1];
}
```
**Real-world Application**: Matrix operations in scientific computing
**Interview Question**: "How would you modify this algorithm to also return the optimal parenthesization?"

## 6. COMMON INTERVIEW QUESTIONS AND SOLUTIONS

### Array/String Questions:

1. **Find the longest palindromic substring**
```java
public String longestPalindrome(String s) {
    if (s == null || s.length() < 1) return "";
    
    int start = 0, end = 0;
    for (int i = 0; i < s.length(); i++) {
        int len1 = expandAroundCenter(s, i, i);
        int len2 = expandAroundCenter(s, i, i+1);
        int len = Math.max(len1, len2);
        
        if (len > end - start) {
            start = i - (len-1)/2;
            end = i + len/2;
        }
    }
    return s.substring(start, end + 1);
}

private int expandAroundCenter(String s, int left, int right) {
    while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
        left--;
        right++;
    }
    return right - left - 1;
}
```

2. **Find the median of two sorted arrays**
```java
public double findMedianSortedArrays(int[] nums1, int[] nums2) {
    int m = nums1.length;
    int n = nums2.length;
    int left = (m + n + 1) / 2;
    int right = (m + n + 2) / 2;
    
    return (findKth(nums1, 0, nums2, 0, left) + 
            findKth(nums1, 0, nums2, 0, right)) / 2.0;
}

private int findKth(int[] nums1, int i, int[] nums2, int j, int k) {
    if (i >= nums1.length) return nums2[j + k - 1];
    if (j >= nums2.length) return nums1[i + k - 1];
    if (k == 1) return Math.min(nums1[i], nums2[j]);
    
    int midVal1 = (i + k/2 - 1 < nums1.length) ? nums1[i + k/2 - 1] : Integer.MAX_VALUE;
    int midVal2 = (j + k/2 - 1 < nums2.length) ? nums2[j + k/2 - 1] : Integer.MAX_VALUE;
    
    if (midVal1 < midVal2) {
        return findKth(nums1, i + k/2, nums2, j, k - k/2);
    } else {
        return findKth(nums1, i, nums2, j + k/2, k - k/2);
    }
}
```

### Tree Questions:

1. **Serialize and Deserialize Binary Tree**
```java
public String serialize(TreeNode root) {
    if (root == null) return "null";
    return root.val + "," + serialize(root.left) + "," + serialize(root.right);
}

public TreeNode deserialize(String data) {
    Queue<String> queue = new LinkedList<>(Arrays.asList(data.split(",")));
    return buildTree(queue);
}

private TreeNode buildTree(Queue<String> queue) {
    String val = queue.poll();
    if (val.equals("null")) return null;
    
    TreeNode node = new TreeNode(Integer.parseInt(val));
    node.left = buildTree(queue);
    node.right = buildTree(queue);
    return node;
}
```

2. **Validate Binary Search Tree**
```java
public boolean isValidBST(TreeNode root) {
    return validate(root, null, null);
}

private boolean validate(TreeNode node, Integer min, Integer max) {
    if (node == null) return true;
    
    if ((min != null && node.val <= min) || 
        (max != null && node.val >= max))
        return false;
    
    return validate(node.left, min, node.val) && 
           validate(node.right, node.val, max);
}
```

### Dynamic Programming Questions:

1. **Longest Increasing Subsequence**
```java
public int lengthOfLIS(int[] nums) {
    int[] dp = new int[nums.length];
    int len = 0;
    
    for (int num : nums) {
        int i = Arrays.binarySearch(dp, 0, len, num);
        if (i < 0) i = -(i + 1);
        dp[i] = num;
        if (i == len) len++;
    }
    return len;
}
```

2. **Edit Distance**
```java
public int minDistance(String word1, String word2) {
    int m = word1.length();
    int n = word2.length();
    int[][] dp = new int[m+1][n+1];
    
    for (int i = 0; i <= m; i++) dp[i][0] = i;
    for (int j = 0; j <= n; j++) dp[0][j] = j;
    
    for (int i = 1; i <= m; i++) {
        for (int j = 1; j <= n; j++) {
            if (word1.charAt(i-1) == word2.charAt(j-1))
                dp[i][j] = dp[i-1][j-1];
            else
                dp[i][j] = 1 + Math.min(dp[i-1][j-1], 
                              Math.min(dp[i-1][j], dp[i][j-1]));
        }
    }
    return dp[m][n];
}
```

## 7. REAL-WORLD APPLICATIONS

### Sorting Applications:
1. **E-commerce**: Product sorting by price, rating, popularity
2. **Database Systems**: Index creation and maintenance
3. **Operating Systems**: Process scheduling
4. **Graphics**: Depth sorting for 3D rendering

### Searching Applications:
1. **Web Search**: Indexing and retrieval
2. **Database Systems**: Record lookup
3. **File Systems**: File search
4. **Network Routing**: Path finding

### Graph Applications:
1. **Social Networks**: Friend suggestions
2. **GPS Navigation**: Shortest path finding
3. **Network Design**: Minimum spanning trees
4. **Game Development**: Path finding

### Dynamic Programming Applications:
1. **Natural Language Processing**: Spell checking
2. **Image Processing**: Seam carving
3. **Bioinformatics**: DNA sequence alignment
4. **Finance**: Portfolio optimization

Remember to:
1. Practice implementing these algorithms
2. Understand the time and space complexity
3. Know when to use each algorithm
4. Test with different input sizes
5. Consider edge cases
6. Study real-world applications
7. Prepare for common interview questions

The best way to master algorithms is through consistent practice and understanding the underlying concepts! 

## 8. DETAILED PROGRAM EXPLANATIONS

### Sorting Algorithms Explained:

#### 1. Bubble Sort
```java
public void bubbleSort(int[] arr) {
    int n = arr.length;
    for (int i = 0; i < n-1; i++) {
        for (int j = 0; j < n-i-1; j++) {
            if (arr[j] > arr[j+1]) {
                // Swap elements
                int temp = arr[j];
                arr[j] = arr[j+1];
                arr[j+1] = temp;
            }
        }
    }
}
```
**How it works:**
1. Compare adjacent elements
2. Swap if they are in wrong order
3. Repeat for each pair
4. After each pass, largest element "bubbles up" to end

**Example:**
```
Initial: [5, 3, 8, 4, 2]
Pass 1: [3, 5, 4, 2, 8]
Pass 2: [3, 4, 2, 5, 8]
Pass 3: [3, 2, 4, 5, 8]
Pass 4: [2, 3, 4, 5, 8]
```

**Time Complexity Analysis:**
- Best Case: O(n) - Array already sorted
- Average Case: O(n²) - Random array
- Worst Case: O(n²) - Array in reverse order

**Space Complexity:** O(1) - In-place sorting

**When to use:**
- Small datasets
- Educational purposes
- When memory is limited
- When stability is required

#### 2. Quick Sort
```java
public void quickSort(int[] arr, int low, int high) {
    if (low < high) {
        int pi = partition(arr, low, high);
        quickSort(arr, low, pi-1);
        quickSort(arr, pi+1, high);
    }
}

private int partition(int[] arr, int low, int high) {
    int pivot = arr[high];
    int i = (low-1);
    
    for (int j = low; j < high; j++) {
        if (arr[j] < pivot) {
            i++;
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }
    
    int temp = arr[i+1];
    arr[i+1] = arr[high];
    arr[high] = temp;
    
    return i+1;
}
```
**How it works:**
1. Choose a pivot element
2. Partition array around pivot
3. Recursively sort sub-arrays
4. Combine results

**Example:**
```
Initial: [7, 2, 1, 6, 8, 5, 3, 4]
Pivot: 4
After partition: [2, 1, 3, 4, 8, 5, 7, 6]
Recursive calls on [2, 1, 3] and [8, 5, 7, 6]
```

**Time Complexity Analysis:**
- Best Case: O(n log n) - Balanced partitions
- Average Case: O(n log n) - Random array
- Worst Case: O(n²) - Unbalanced partitions

**Space Complexity:** O(log n) - Recursion stack

**When to use:**
- Large datasets
- General-purpose sorting
- When average performance is important
- When memory is not a constraint

#### 3. Merge Sort
```java
public void mergeSort(int[] arr, int left, int right) {
    if (left < right) {
        int mid = (left + right) / 2;
        mergeSort(arr, left, mid);
        mergeSort(arr, mid + 1, right);
        merge(arr, left, mid, right);
    }
}

private void merge(int[] arr, int left, int mid, int right) {
    int n1 = mid - left + 1;
    int n2 = right - mid;
    
    int[] L = new int[n1];
    int[] R = new int[n2];
    
    for (int i = 0; i < n1; i++)
        L[i] = arr[left + i];
    for (int j = 0; j < n2; j++)
        R[j] = arr[mid + 1 + j];
    
    int i = 0, j = 0, k = left;
    while (i < n1 && j < n2) {
        if (L[i] <= R[j]) {
            arr[k] = L[i];
            i++;
        } else {
            arr[k] = R[j];
            j++;
        }
        k++;
    }
    
    while (i < n1) {
        arr[k] = L[i];
        i++;
        k++;
    }
    
    while (j < n2) {
        arr[k] = R[j];
        j++;
        k++;
    }
}
```
**How it works:**
1. Divide array into two halves
2. Recursively sort each half
3. Merge sorted halves
4. Use temporary arrays for merging

**Example:**
```
Initial: [38, 27, 43, 3, 9, 82, 10]
Divide: [38, 27, 43, 3] and [9, 82, 10]
Recursive sort: [3, 27, 38, 43] and [9, 10, 82]
Merge: [3, 9, 10, 27, 38, 43, 82]
```

**Time Complexity Analysis:**
- Best Case: O(n log n)
- Average Case: O(n log n)
- Worst Case: O(n log n)

**Space Complexity:** O(n) - Temporary arrays

**When to use:**
- Large datasets
- When stability is required
- When worst-case performance is important
- External sorting

### Searching Algorithms Explained:

#### 1. Binary Search
```java
public int binarySearch(int[] arr, int target) {
    int left = 0;
    int right = arr.length - 1;
    
    while (left <= right) {
        int mid = left + (right - left) / 2;
        
        if (arr[mid] == target)
            return mid;
            
        if (arr[mid] < target)
            left = mid + 1;
        else
            right = mid - 1;
    }
    
    return -1;
}
```
**How it works:**
1. Compare target with middle element
2. If equal, return index
3. If target is smaller, search left half
4. If target is larger, search right half
5. Repeat until found or search space is empty

**Example:**
```
Array: [1, 3, 5, 7, 9, 11, 13, 15]
Target: 7
Step 1: Compare with 7 (middle)
Found at index 3
```

**Time Complexity Analysis:**
- Best Case: O(1) - Target is middle element
- Average Case: O(log n)
- Worst Case: O(log n)

**Space Complexity:** O(1) - Iterative approach

**When to use:**
- Sorted arrays
- Large datasets
- When random access is available
- When memory is limited

#### 2. Linear Search
```java
public int linearSearch(int[] arr, int target) {
    for (int i = 0; i < arr.length; i++) {
        if (arr[i] == target)
            return i;
    }
    return -1;
}
```
**How it works:**
1. Start from first element
2. Compare each element with target
3. Return index if found
4. Return -1 if not found

**Example:**
```
Array: [4, 2, 7, 1, 9, 3]
Target: 7
Step 1: Compare 4
Step 2: Compare 2
Step 3: Compare 7 (found)
Return index 2
```

**Time Complexity Analysis:**
- Best Case: O(1) - Target is first element
- Average Case: O(n)
- Worst Case: O(n)

**Space Complexity:** O(1)

**When to use:**
- Unsorted arrays
- Small datasets
- When array is not random access
- When simplicity is preferred

### Graph Algorithms Explained:

#### 1. Breadth-First Search (BFS)
```java
public void bfs(Graph graph, int start) {
    boolean[] visited = new boolean[graph.V];
    Queue<Integer> queue = new LinkedList<>();
    
    visited[start] = true;
    queue.add(start);
    
    while (!queue.isEmpty()) {
        int vertex = queue.poll();
        System.out.print(vertex + " ");
        
        for (int neighbor : graph.adj[vertex]) {
            if (!visited[neighbor]) {
                visited[neighbor] = true;
                queue.add(neighbor);
            }
        }
    }
}
```
**How it works:**
1. Start at given vertex
2. Visit all neighbors
3. Add unvisited neighbors to queue
4. Process queue until empty

**Example:**
```
Graph:
    1
   / \
  2   3
 / \   \
4   5   6

BFS Order: 1, 2, 3, 4, 5, 6
```

**Time Complexity Analysis:**
- Time: O(V + E) - V vertices, E edges
- Space: O(V) - Queue and visited array

**When to use:**
- Shortest path in unweighted graphs
- Level-order traversal
- Web crawling
- Social network analysis

#### 2. Depth-First Search (DFS)
```java
public void dfs(Graph graph, int start) {
    boolean[] visited = new boolean[graph.V];
    dfsUtil(graph, start, visited);
}

private void dfsUtil(Graph graph, int vertex, boolean[] visited) {
    visited[vertex] = true;
    System.out.print(vertex + " ");
    
    for (int neighbor : graph.adj[vertex]) {
        if (!visited[neighbor])
            dfsUtil(graph, neighbor, visited);
    }
}
```
**How it works:**
1. Start at given vertex
2. Visit first unvisited neighbor
3. Recursively explore that path
4. Backtrack when no more neighbors

**Example:**
```
Graph:
    1
   / \
  2   3
 / \   \
4   5   6

DFS Order: 1, 2, 4, 5, 3, 6
```

**Time Complexity Analysis:**
- Time: O(V + E) - V vertices, E edges
- Space: O(V) - Recursion stack

**When to use:**
- Cycle detection
- Topological sorting
- Maze solving
- Game state exploration

### Dynamic Programming Explained:

#### 1. Fibonacci with Memoization
```java
public int fibonacci(int n) {
    int[] memo = new int[n + 1];
    return fibonacciHelper(n, memo);
}

private int fibonacciHelper(int n, int[] memo) {
    if (n <= 1) return n;
    if (memo[n] != 0) return memo[n];
    
    memo[n] = fibonacciHelper(n-1, memo) + fibonacciHelper(n-2, memo);
    return memo[n];
}
```
**How it works:**
1. Store previously calculated values
2. Check memo before calculating
3. Calculate and store new values
4. Return stored value if available

**Example:**
```
n = 5
memo[0] = 0
memo[1] = 1
memo[2] = 1
memo[3] = 2
memo[4] = 3
memo[5] = 5
```

**Time Complexity Analysis:**
- Time: O(n) - Each value calculated once
- Space: O(n) - Memo array

**When to use:**
- Recursive problems with overlapping subproblems
- When same calculations are repeated
- When memory is available for caching
- When time is more important than space

#### 2. Longest Common Subsequence
```java
public int lcs(String text1, String text2) {
    int m = text1.length();
    int n = text2.length();
    int[][] dp = new int[m + 1][n + 1];
    
    for (int i = 1; i <= m; i++) {
        for (int j = 1; j <= n; j++) {
            if (text1.charAt(i-1) == text2.charAt(j-1))
                dp[i][j] = dp[i-1][j-1] + 1;
            else
                dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
        }
    }
    return dp[m][n];
}
```
**How it works:**
1. Create DP table
2. Fill table based on character matches
3. Take maximum of previous values
4. Return final cell value

**Example:**
```
text1 = "ABCDGH"
text2 = "AEDFHR"
LCS = "ADH" (length 3)
```

**Time Complexity Analysis:**
- Time: O(mn) - m, n are string lengths
- Space: O(mn) - DP table

**When to use:**
- String comparison
- DNA sequence alignment
- File difference detection
- Plagiarism detection

## 9. COMMON PITFALLS AND BEST PRACTICES

### Common Pitfalls:
1. **Array Index Out of Bounds**
   - Always check array bounds
   - Use length property correctly
   - Handle edge cases

2. **Null Pointer Exceptions**
   - Check for null before accessing
   - Initialize objects properly
   - Use Optional when appropriate

3. **Infinite Loops**
   - Set proper termination conditions
   - Check loop variables
   - Use appropriate loop types

4. **Memory Leaks**
   - Close resources properly
   - Use try-with-resources
   - Clear references when done

### Best Practices:
1. **Code Organization**
   - Use meaningful names
   - Follow Java conventions
   - Write clear comments
   - Keep methods small

2. **Error Handling**
   - Use appropriate exceptions
   - Provide meaningful messages
   - Handle all cases
   - Log errors properly

3. **Performance**
   - Choose right data structures
   - Optimize critical paths
   - Profile your code
   - Consider memory usage

4. **Testing**
   - Write unit tests
   - Test edge cases
   - Use assertions
   - Document test cases

Remember to:
1. Practice implementing these algorithms
2. Understand the time and space complexity
3. Know when to use each algorithm
4. Test with different input sizes
5. Consider edge cases
6. Study real-world applications
7. Prepare for common interview questions

The best way to master algorithms is through consistent practice and understanding the underlying concepts! 