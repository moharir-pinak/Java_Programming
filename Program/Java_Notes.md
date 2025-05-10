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