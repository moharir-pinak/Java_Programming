# COMPREHENSIVE JAVA NOTES

## 1. INTRODUCTION TO JAVA

### What is Java?
Java is a high-level, class-based, object-oriented programming language designed to have as few implementation dependencies as possible. It is:
- Platform-independent
- Object-oriented
- Strongly typed
- Interpreted and compiled
- Multi-threaded
- Distributed
- Dynamic

### Java Language Characteristics:
1. Simple: Easy to learn and use
2. Object-Oriented: Everything is an object
3. Distributed: Can run on multiple systems
4. Robust: Strong memory management and exception handling
5. Secure: Built-in security features
6. Architecture-neutral: Platform-independent
7. Portable: Can run on any platform with JVM
8. High-performance: Just-In-Time compilation
9. Multi-threaded: Can perform multiple tasks simultaneously
10. Dynamic: Can adapt to changing environments

### How Java Works:
1. Write Java code (.java file)
2. Compile to bytecode (.class file) using javac
3. JVM executes the bytecode

### Java Compilation Process:
1. Source Code (.java) → Java Compiler (javac)
2. Bytecode (.class) → JVM
3. JVM → Machine Code

### JVM (Java Virtual Machine):
- Acts as a virtual computer
- Converts bytecode to machine code
- Provides memory management
- Handles garbage collection
- Ensures platform independence

### JVM Architecture:
1. Class Loader:
   - Bootstrap ClassLoader
   - Extension ClassLoader
   - Application ClassLoader
2. Memory Areas:
   - Method Area: Stores class structures
   - Heap: Object storage
   - Stack: Method calls and local variables
   - PC Registers: Current execution point
   - Native Method Stack: Native method calls
3. Execution Engine:
   - Interpreter: Executes bytecode
   - JIT Compiler: Compiles frequently used code
   - Garbage Collector: Memory management

### Garbage Collection:
1. Mark and Sweep Algorithm
2. Generational Garbage Collection
3. Types of GC:
   - Serial GC
   - Parallel GC
   - CMS (Concurrent Mark Sweep)
   - G1 (Garbage First)

## 2. JAVA SYNTAX BASICS

### Variables and Data Types:
```java
// Primitive Types
byte b = 127;          // 8-bit
short s = 32767;       // 16-bit
int i = 2147483647;    // 32-bit
long l = 9223372036854775807L;  // 64-bit
float f = 3.14f;       // 32-bit
double d = 3.14;       // 64-bit
boolean bool = true;   // true/false
char c = 'A';          // 16-bit Unicode

// Reference Types
String str = "Hello";
Integer num = 100;
```

### Operators:
```java
// Arithmetic
+ - * / % ++ --

// Assignment
= += -= *= /= %=

// Comparison
== != > < >= <=

// Logical
&& || !

// Bitwise
& | ^ ~ << >> >>>
```

### Control Flow:
```java
// If-else
if (condition) {
    // code
} else if (condition) {
    // code
} else {
    // code
}

// Switch
switch (variable) {
    case value1:
        // code
        break;
    case value2:
        // code
        break;
    default:
        // code
}

// Loops
// For loop
for (int i = 0; i < 10; i++) {
    // code
}

// While loop
while (condition) {
    // code
}

// Do-while loop
do {
    // code
} while (condition);

// Enhanced for loop
for (String item : array) {
    // code
}
```

## 3. OBJECT-ORIENTED PROGRAMMING

### Classes and Objects:
```java
public class Person {
    // Instance variables
    private String name;
    private int age;
    
    // Constructor
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
    
    // Methods
    public void display() {
        System.out.println("Name: " + name + ", Age: " + age);
    }
}
```

### OOP Principles:
1. Encapsulation:
   - Bundling data and methods
   - Access modifiers (private, protected, public)
   - Getters and setters

2. Inheritance:
```java
public class Employee extends Person {
    private String department;
    
    public Employee(String name, int age, String department) {
        super(name, age);
        this.department = department;
    }
}
```

3. Polymorphism:
   - Method Overriding
   - Method Overloading
   - Dynamic Method Dispatch

4. Abstraction:
   - Abstract classes
   - Interfaces

### Interfaces:
```java
public interface Drawable {
    void draw();
    double getArea();
}

public class Circle implements Drawable {
    @Override
    public void draw() {
        // Implementation
    }
    
    @Override
    public double getArea() {
        // Implementation
        return 0.0;
    }
}
```

## 4. COLLECTIONS FRAMEWORK

### List:
```java
List<String> list = new ArrayList<>();
list.add("Item");
list.get(0);
list.remove(0);
```

### Set:
```java
Set<String> set = new HashSet<>();
set.add("Item");
set.contains("Item");
```

### Map:
```java
Map<String, Integer> map = new HashMap<>();
map.put("Key", 1);
map.get("Key");
```

## 5. EXCEPTION HANDLING
```java
try {
    // Risky code
} catch (Exception e) {
    // Handle exception
} finally {
    // Cleanup code
}
```

## 6. COMMON INTERVIEW QUESTIONS

### Java Basics:
1. What is the difference between JDK, JRE, and JVM?
   - JDK (Java Development Kit): Development tools + JRE
   - JRE (Java Runtime Environment): JVM + Libraries
   - JVM (Java Virtual Machine): Runtime environment

2. Explain the concept of platform independence in Java.
   - Write Once, Run Anywhere
   - Bytecode is platform-independent
   - JVM is platform-specific

3. What is the difference between == and .equals()?
   - == compares references
   - .equals() compares content

4. What is the difference between String, StringBuilder, and StringBuffer?
   - String: Immutable
   - StringBuilder: Mutable, not thread-safe
   - StringBuffer: Mutable, thread-safe

### OOP:
1. What are the four principles of OOP?
2. What is the difference between abstract class and interface?
3. What is method overloading and overriding?
4. What is the difference between composition and inheritance?

### Collections:
1. What is the difference between ArrayList and LinkedList?
2. What is the difference between HashMap and HashTable?
3. How does HashSet maintain uniqueness?
4. What is the difference between fail-fast and fail-safe iterators?

## 7. DSA SOLUTIONS AND INTERVIEW QUESTIONS

### Arrays and Strings:

1. Find the missing number in an array:
```java
public int findMissingNumber(int[] arr, int n) {
    int expectedSum = n * (n + 1) / 2;
    int actualSum = 0;
    for (int num : arr) {
        actualSum += num;
    }
    return expectedSum - actualSum;
}
```

2. Find duplicates in an array:
```java
public List<Integer> findDuplicates(int[] arr) {
    List<Integer> duplicates = new ArrayList<>();
    Set<Integer> set = new HashSet<>();
    
    for (int num : arr) {
        if (!set.add(num)) {
            duplicates.add(num);
        }
    }
    return duplicates;
}
```

3. Reverse a string:
```java
public String reverseString(String str) {
    // Method 1: Using StringBuilder
    return new StringBuilder(str).reverse().toString();
    
    // Method 2: Using char array
    char[] chars = str.toCharArray();
    int left = 0, right = chars.length - 1;
    while (left < right) {
        char temp = chars[left];
        chars[left] = chars[right];
        chars[right] = temp;
        left++;
        right--;
    }
    return new String(chars);
}
```

4. Check if strings are anagrams:
```java
public boolean areAnagrams(String str1, String str2) {
    if (str1.length() != str2.length()) return false;
    
    int[] charCount = new int[256];
    
    for (char c : str1.toCharArray()) {
        charCount[c]++;
    }
    
    for (char c : str2.toCharArray()) {
        charCount[c]--;
        if (charCount[c] < 0) return false;
    }
    
    return true;
}
```

### Linked Lists:

1. Reverse a linked list:
```java
public ListNode reverseList(ListNode head) {
    ListNode prev = null;
    ListNode current = head;
    
    while (current != null) {
        ListNode next = current.next;
        current.next = prev;
        prev = current;
        current = next;
    }
    
    return prev;
}
```

2. Detect a cycle in a linked list:
```java
public boolean hasCycle(ListNode head) {
    if (head == null || head.next == null) return false;
    
    ListNode slow = head;
    ListNode fast = head;
    
    while (fast != null && fast.next != null) {
        slow = slow.next;
        fast = fast.next.next;
        
        if (slow == fast) return true;
    }
    
    return false;
}
```

### Trees:

1. Binary Tree traversal:
```java
// Inorder Traversal
public void inorderTraversal(TreeNode root) {
    if (root == null) return;
    
    inorderTraversal(root.left);
    System.out.print(root.val + " ");
    inorderTraversal(root.right);
}

// Preorder Traversal
public void preorderTraversal(TreeNode root) {
    if (root == null) return;
    
    System.out.print(root.val + " ");
    preorderTraversal(root.left);
    preorderTraversal(root.right);
}

// Postorder Traversal
public void postorderTraversal(TreeNode root) {
    if (root == null) return;
    
    postorderTraversal(root.left);
    postorderTraversal(root.right);
    System.out.print(root.val + " ");
}
```

2. Check if a tree is balanced:
```java
public boolean isBalanced(TreeNode root) {
    return checkHeight(root) != -1;
}

private int checkHeight(TreeNode root) {
    if (root == null) return 0;
    
    int leftHeight = checkHeight(root.left);
    if (leftHeight == -1) return -1;
    
    int rightHeight = checkHeight(root.right);
    if (rightHeight == -1) return -1;
    
    if (Math.abs(leftHeight - rightHeight) > 1) return -1;
    
    return Math.max(leftHeight, rightHeight) + 1;
}
```

### Dynamic Programming:

1. Fibonacci sequence:
```java
public int fibonacci(int n) {
    if (n <= 1) return n;
    
    int[] dp = new int[n + 1];
    dp[0] = 0;
    dp[1] = 1;
    
    for (int i = 2; i <= n; i++) {
        dp[i] = dp[i-1] + dp[i-2];
    }
    
    return dp[n];
}
```

2. Longest Common Subsequence:
```java
public int longestCommonSubsequence(String text1, String text2) {
    int m = text1.length();
    int n = text2.length();
    
    int[][] dp = new int[m + 1][n + 1];
    
    for (int i = 1; i <= m; i++) {
        for (int j = 1; j <= n; j++) {
            if (text1.charAt(i-1) == text2.charAt(j-1)) {
                dp[i][j] = dp[i-1][j-1] + 1;
            } else {
                dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
            }
        }
    }
    
    return dp[m][n];
}
```

## 8. ADDITIONAL INTERVIEW QUESTIONS

### System Design:
1. How would you design a parking lot system?
2. Design a URL shortening service
3. Design a rate limiter
4. Design a distributed cache

### Java Concurrency:
1. What is the difference between Thread and Runnable?
2. Explain the concept of thread safety
3. What is the difference between synchronized and volatile?
4. How does the wait() and notify() mechanism work?

### Database:
1. What is the difference between SQL and NoSQL?
2. Explain ACID properties
3. What is normalization?
4. What are indexes and how do they work?

### Spring Framework:
1. What is dependency injection?
2. What is the difference between @Component and @Bean?
3. Explain the concept of AOP
4. What is the difference between @Controller and @RestController?

## 9. BEST PRACTICES

### Code Style:
1. Use meaningful variable names
2. Follow Java naming conventions
3. Write clear comments
4. Keep methods small and focused

### Performance:
1. Use StringBuilder for string concatenation
2. Choose appropriate collections
3. Handle resources properly
4. Use try-with-resources

### Security:
1. Never store sensitive data in plain text
2. Validate user input
3. Use prepared statements for SQL
4. Follow the principle of least privilege

## 10. ADVANCED CONCEPTS

### Multithreading:
```java
public class MyThread extends Thread {
    public void run() {
        // Thread code
    }
}

// Using Runnable
Runnable runnable = () -> {
    // Thread code
};
Thread thread = new Thread(runnable);
```

### Streams API:
```java
List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
numbers.stream()
       .filter(n -> n % 2 == 0)
       .map(n -> n * 2)
       .collect(Collectors.toList());
```

### Lambda Expressions:
```java
List<String> names = Arrays.asList("John", "Jane", "Bob");
names.forEach(name -> System.out.println(name));
```

### Optional Class:
```java
Optional<String> optional = Optional.ofNullable(value);
String result = optional.orElse("default");
```

Remember to:
1. Practice coding regularly
2. Build real-world projects
3. Participate in coding challenges
4. Read and understand other people's code
5. Keep learning and updating your knowledge

The best way to master Java is through consistent practice and building real applications!

## 1. DETAILED JVM ARCHITECTURE

### JVM Components and Their Functions:

#### 1. Class Loader Subsystem:
```java
// Example of class loading
public class ClassLoadingExample {
    public static void main(String[] args) {
        // Bootstrap ClassLoader loads core Java classes
        String str = new String("Hello"); // Loaded by Bootstrap ClassLoader
        
        // Extension ClassLoader loads extension classes
        javax.swing.JFrame frame = new javax.swing.JFrame(); // Loaded by Extension ClassLoader
        
        // Application ClassLoader loads application classes
        MyCustomClass custom = new MyCustomClass(); // Loaded by Application ClassLoader
    }
}
```

**Class Loading Process:**
1. Loading: Loads .class file into memory
2. Linking:
   - Verification: Checks bytecode validity
   - Preparation: Allocates memory for static variables
   - Resolution: Converts symbolic references to direct references
3. Initialization: Executes static initializers

#### 2. Runtime Data Areas:

##### a. Method Area:
```java
public class MethodAreaExample {
    // Stored in Method Area
    private static final String CONSTANT = "Constant";
    private static int counter = 0;
    
    // Method information stored here
    public static void incrementCounter() {
        counter++;
    }
}
```

##### b. Heap:
```java
public class HeapExample {
    public static void main(String[] args) {
        // Objects created in Heap
        String str1 = new String("Hello");
        Integer num = new Integer(100);
        Object[] array = new Object[10];
    }
}
```

##### c. Stack:
```java
public class StackExample {
    public static void main(String[] args) {
        int x = 10; // Stored in stack
        String str = "Hello"; // Reference in stack, object in heap
        method1(x); // New stack frame created
    }
    
    public static void method1(int param) {
        int localVar = 20; // Stored in new stack frame
        // Stack frame contains:
        // - Local variables
        // - Operand stack
        // - Frame data
    }
}
```

##### d. PC Registers:
- Each thread has its own PC register
- Points to current execution instruction
- Changes with each instruction execution

##### e. Native Method Stack:
```java
public class NativeMethodExample {
    // Native method declaration
    public native void nativeMethod();
    
    static {
        // Load native library
        System.loadLibrary("nativeLib");
    }
}
```

#### 3. Execution Engine:

##### a. Interpreter:
- Reads and executes bytecode line by line
- Slower but requires less memory

##### b. JIT Compiler:
```java
public class JITExample {
    public static void main(String[] args) {
        // This method will be JIT compiled after multiple executions
        for (int i = 0; i < 10000; i++) {
            hotMethod();
        }
    }
    
    public static void hotMethod() {
        // Frequently executed code
        int sum = 0;
        for (int i = 0; i < 1000; i++) {
            sum += i;
        }
    }
}
```

##### c. Garbage Collector:
```java
public class GCExample {
    public static void main(String[] args) {
        // Objects eligible for garbage collection
        Object obj1 = new Object();
        Object obj2 = new Object();
        
        obj1 = null; // obj1 eligible for GC
        obj2 = new Object(); // Previous obj2 eligible for GC
    }
}
```

## 2. DETAILED OBJECT-ORIENTED PROGRAMMING

### 1. Encapsulation:
```java
public class BankAccount {
    // Private fields - data hiding
    private String accountNumber;
    private double balance;
    private String accountHolder;
    
    // Constructor
    public BankAccount(String accountNumber, String accountHolder) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = 0.0;
    }
    
    // Public methods - controlled access
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        }
    }
    
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
        }
    }
    
    // Getters and setters
    public double getBalance() {
        return balance;
    }
    
    public String getAccountNumber() {
        return accountNumber;
    }
}
```

### 2. Inheritance:
```java
// Base class
public class Animal {
    protected String name;
    protected int age;
    
    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }
    
    public void makeSound() {
        System.out.println("Some sound");
    }
    
    public void displayInfo() {
        System.out.println("Name: " + name + ", Age: " + age);
    }
}

// Derived class
public class Dog extends Animal {
    private String breed;
    
    public Dog(String name, int age, String breed) {
        super(name, age); // Call parent constructor
        this.breed = breed;
    }
    
    @Override
    public void makeSound() {
        System.out.println("Woof!");
    }
    
    public void fetch() {
        System.out.println(name + " is fetching the ball");
    }
}
```

### 3. Polymorphism:
```java
// Method Overloading
public class Calculator {
    public int add(int a, int b) {
        return a + b;
    }
    
    public double add(double a, double b) {
        return a + b;
    }
    
    public int add(int a, int b, int c) {
        return a + b + c;
    }
}

// Method Overriding
public class Shape {
    public double getArea() {
        return 0;
    }
}

public class Circle extends Shape {
    private double radius;
    
    public Circle(double radius) {
        this.radius = radius;
    }
    
    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }
}

// Runtime Polymorphism
public class PolymorphismExample {
    public static void main(String[] args) {
        Shape shape1 = new Circle(5);
        Shape shape2 = new Rectangle(4, 6);
        
        System.out.println("Circle Area: " + shape1.getArea());
        System.out.println("Rectangle Area: " + shape2.getArea());
    }
}
```

### 4. Abstraction:
```java
// Abstract class
public abstract class Vehicle {
    protected String brand;
    protected String model;
    
    public Vehicle(String brand, String model) {
        this.brand = brand;
        this.model = model;
    }
    
    // Abstract method
    public abstract void start();
    
    // Concrete method
    public void displayInfo() {
        System.out.println("Brand: " + brand + ", Model: " + model);
    }
}

// Interface
public interface Drivable {
    void accelerate();
    void brake();
    void turn(String direction);
}

// Implementing class
public class Car extends Vehicle implements Drivable {
    public Car(String brand, String model) {
        super(brand, model);
    }
    
    @Override
    public void start() {
        System.out.println("Car engine started");
    }
    
    @Override
    public void accelerate() {
        System.out.println("Car is accelerating");
    }
    
    @Override
    public void brake() {
        System.out.println("Car is braking");
    }
    
    @Override
    public void turn(String direction) {
        System.out.println("Car is turning " + direction);
    }
}
```

## 3. COLLECTION CONVERSIONS

### Array to List:
```java
// Using Arrays.asList()
String[] stringArray = {"apple", "banana", "orange"};
List<String> stringList = Arrays.asList(stringArray);

// Using ArrayList constructor
List<String> stringList2 = new ArrayList<>(Arrays.asList(stringArray));

// Using Stream
List<String> stringList3 = Arrays.stream(stringArray)
                                .collect(Collectors.toList());

// For primitive arrays
int[] intArray = {1, 2, 3, 4, 5};
List<Integer> intList = Arrays.stream(intArray)
                             .boxed()
                             .collect(Collectors.toList());
```

### Array to Set:
```java
// Using HashSet constructor
String[] stringArray = {"apple", "banana", "orange"};
Set<String> stringSet = new HashSet<>(Arrays.asList(stringArray));

// Using Stream
Set<String> stringSet2 = Arrays.stream(stringArray)
                              .collect(Collectors.toSet());

// For primitive arrays
int[] intArray = {1, 2, 3, 4, 5};
Set<Integer> intSet = Arrays.stream(intArray)
                           .boxed()
                           .collect(Collectors.toSet());
```

### Array to Map:
```java
// Using Stream
String[] stringArray = {"apple", "banana", "orange"};
Map<String, Integer> stringMap = IntStream.range(0, stringArray.length)
    .boxed()
    .collect(Collectors.toMap(
        i -> stringArray[i],
        i -> i
    ));

// Using traditional approach
Map<String, Integer> stringMap2 = new HashMap<>();
for (int i = 0; i < stringArray.length; i++) {
    stringMap2.put(stringArray[i], i);
}
```

### String to List/Set:
```java
// String to List of Characters
String str = "hello";
List<Character> charList = str.chars()
                             .mapToObj(c -> (char) c)
                             .collect(Collectors.toList());

// String to Set of Characters
Set<Character> charSet = str.chars()
                           .mapToObj(c -> (char) c)
                           .collect(Collectors.toSet());

// String to List of Words
String sentence = "hello world java";
List<String> wordList = Arrays.asList(sentence.split(" "));
```

## 4. DETAILED INTERVIEW QUESTIONS AND ANSWERS

### Java Basics:

1. **What is the difference between JDK, JRE, and JVM?**
   - JDK (Java Development Kit):
     - Complete development package
     - Includes JRE and development tools
     - Contains compiler, debugger, and other tools
     - Used for developing Java applications
   
   - JRE (Java Runtime Environment):
     - Runtime environment for Java applications
     - Includes JVM and core libraries
     - Used for running Java applications
     - Does not include development tools
   
   - JVM (Java Virtual Machine):
     - Virtual machine that executes Java bytecode
     - Platform-dependent
     - Provides memory management and garbage collection
     - Ensures platform independence

2. **Explain the concept of platform independence in Java.**
   - Write Once, Run Anywhere (WORA)
   - Java source code is compiled to bytecode
   - Bytecode is platform-independent
   - JVM is platform-specific
   - JVM interprets bytecode for specific platform
   - Example:
     ```java
     // Same bytecode runs on different platforms
     public class PlatformIndependent {
         public static void main(String[] args) {
             System.out.println("Hello, World!");
         }
     }
     ```

3. **What is the difference between == and .equals()?**
   - == operator:
     - Compares object references
     - Checks if two objects point to same memory location
     - Used for primitive types
   
   - .equals() method:
     - Compares object contents
     - Can be overridden for custom comparison
     - Used for objects
   
   Example:
   ```java
   String str1 = new String("hello");
   String str2 = new String("hello");
   
   System.out.println(str1 == str2);        // false (different references)
   System.out.println(str1.equals(str2));   // true (same content)
   ```

4. **What is the difference between String, StringBuilder, and StringBuffer?**
   - String:
     - Immutable
     - Thread-safe
     - Best for small, fixed strings
   
   - StringBuilder:
     - Mutable
     - Not thread-safe
     - Better performance
     - Best for single-threaded operations
   
   - StringBuffer:
     - Mutable
     - Thread-safe
     - Synchronized methods
     - Best for multi-threaded operations
   
   Example:
   ```java
   // String
   String str = "hello";
   str = str + " world"; // Creates new object
   
   // StringBuilder
   StringBuilder sb = new StringBuilder("hello");
   sb.append(" world"); // Modifies existing object
   
   // StringBuffer
   StringBuffer sbf = new StringBuffer("hello");
   sbf.append(" world"); // Thread-safe modification
   ```

### OOP Questions:

1. **What are the four principles of OOP?**
   - Encapsulation:
     - Bundling data and methods
     - Data hiding
     - Access control
   
   - Inheritance:
     - Code reuse
     - Parent-child relationship
     - Method overriding
   
   - Polymorphism:
     - Multiple forms
     - Method overloading
     - Method overriding
   
   - Abstraction:
     - Hide implementation details
     - Abstract classes
     - Interfaces

2. **What is the difference between abstract class and interface?**
   - Abstract Class:
     - Can have concrete methods
     - Can have constructors
     - Single inheritance
     - Can have instance variables
   
   - Interface:
     - All methods are abstract (before Java 8)
     - Can have default methods
     - Multiple inheritance
     - Only static final variables
   
   Example:
   ```java
   // Abstract class
   public abstract class Animal {
       protected String name;
       
       public Animal(String name) {
           this.name = name;
       }
       
       public abstract void makeSound();
       
       public void sleep() {
           System.out.println("Sleeping...");
       }
   }
   
   // Interface
   public interface Flyable {
       void fly();
       
       default void land() {
           System.out.println("Landing...");
       }
   }
   ```

3. **What is method overloading and overriding?**
   - Method Overloading:
     - Same method name
     - Different parameters
     - Same or different return type
     - Compile-time polymorphism
   
   - Method Overriding:
     - Same method signature
     - Different implementation
     - Runtime polymorphism
     - @Override annotation
   
   Example:
   ```java
   // Overloading
   public class Calculator {
       public int add(int a, int b) {
           return a + b;
       }
       
       public double add(double a, double b) {
           return a + b;
       }
   }
   
   // Overriding
   public class Animal {
       public void makeSound() {
           System.out.println("Some sound");
       }
   }
   
   public class Dog extends Animal {
       @Override
       public void makeSound() {
           System.out.println("Woof!");
       }
   }
   ```

4. **What is the difference between composition and inheritance?**
   - Composition:
     - "Has-a" relationship
     - More flexible
     - Better encapsulation
     - Loose coupling
   
   - Inheritance:
     - "Is-a" relationship
     - Tight coupling
     - Code reuse
     - Less flexible
   
   Example:
   ```java
   // Composition
   public class Car {
       private Engine engine;
       private Wheel[] wheels;
       
       public Car() {
           engine = new Engine();
           wheels = new Wheel[4];
       }
   }
   
   // Inheritance
   public class SportsCar extends Car {
       private boolean turbo;
       
       public void enableTurbo() {
           turbo = true;
       }
   }
   ```

## 5. DATA STRUCTURE MANIPULATIONS AND DSA SOLUTIONS

### 1. Array Manipulations:

#### Basic Array Operations:
```java
public class ArrayOperations {
    // Find array length
    public static int getLength(int[] arr) {
        return arr.length;
    }
    
    // Find element at index
    public static int getElement(int[] arr, int index) {
        if (index < 0 || index >= arr.length) {
            throw new IndexOutOfBoundsException();
        }
        return arr[index];
    }
    
    // Update element at index
    public static void updateElement(int[] arr, int index, int value) {
        if (index < 0 || index >= arr.length) {
            throw new IndexOutOfBoundsException();
        }
        arr[index] = value;
    }
    
    // Insert element at index
    public static int[] insertElement(int[] arr, int index, int value) {
        int[] newArr = new int[arr.length + 1];
        for (int i = 0; i < index; i++) {
            newArr[i] = arr[i];
        }
        newArr[index] = value;
        for (int i = index; i < arr.length; i++) {
            newArr[i + 1] = arr[i];
        }
        return newArr;
    }
    
    // Delete element at index
    public static int[] deleteElement(int[] arr, int index) {
        int[] newArr = new int[arr.length - 1];
        for (int i = 0; i < index; i++) {
            newArr[i] = arr[i];
        }
        for (int i = index + 1; i < arr.length; i++) {
            newArr[i - 1] = arr[i];
        }
        return newArr;
    }
    
    // Reverse array
    public static void reverseArray(int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }
    
    // Rotate array by k positions
    public static void rotateArray(int[] arr, int k) {
        k = k % arr.length;
        reverseArray(arr, 0, arr.length - 1);
        reverseArray(arr, 0, k - 1);
        reverseArray(arr, k, arr.length - 1);
    }
    
    private static void reverseArray(int[] arr, int start, int end) {
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
}
```

#### Common Array Problems:

1. **Find Missing Number**:
```java
public class ArrayProblems {
    // Using sum formula
    public static int findMissingNumber(int[] arr, int n) {
        int expectedSum = n * (n + 1) / 2;
        int actualSum = 0;
        for (int num : arr) {
            actualSum += num;
        }
        return expectedSum - actualSum;
    }
    
    // Using XOR
    public static int findMissingNumberXOR(int[] arr, int n) {
        int xor = 0;
        for (int i = 1; i <= n; i++) {
            xor ^= i;
        }
        for (int num : arr) {
            xor ^= num;
        }
        return xor;
    }
}
```

2. **Find Duplicates**:
```java
public class DuplicateProblems {
    // Using HashSet
    public static List<Integer> findDuplicates(int[] arr) {
        List<Integer> duplicates = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        
        for (int num : arr) {
            if (!set.add(num)) {
                duplicates.add(num);
            }
        }
        return duplicates;
    }
    
    // Using sorting
    public static List<Integer> findDuplicatesSort(int[] arr) {
        List<Integer> duplicates = new ArrayList<>();
        Arrays.sort(arr);
        
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == arr[i-1]) {
                duplicates.add(arr[i]);
            }
        }
        return duplicates;
    }
}
```

3. **Find Maximum Subarray Sum**:
```java
public class SubarrayProblems {
    // Kadane's Algorithm
    public static int maxSubarraySum(int[] arr) {
        int maxSoFar = arr[0];
        int maxEndingHere = arr[0];
        
        for (int i = 1; i < arr.length; i++) {
            maxEndingHere = Math.max(arr[i], maxEndingHere + arr[i]);
            maxSoFar = Math.max(maxSoFar, maxEndingHere);
        }
        return maxSoFar;
    }
    
    // Find subarray with given sum
    public static int[] subarrayWithSum(int[] arr, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (sum == target) {
                return new int[]{0, i};
            }
            if (map.containsKey(sum - target)) {
                return new int[]{map.get(sum - target) + 1, i};
            }
            map.put(sum, i);
        }
        return new int[]{-1, -1};
    }
}
```

### 2. String Manipulations:

#### Basic String Operations:
```java
public class StringOperations {
    // Get string length
    public static int getLength(String str) {
        return str.length();
    }
    
    // Get character at index
    public static char getChar(String str, int index) {
        return str.charAt(index);
    }
    
    // Convert to char array
    public static char[] toCharArray(String str) {
        return str.toCharArray();
    }
    
    // Convert char array to string
    public static String toString(char[] arr) {
        return new String(arr);
    }
    
    // Reverse string
    public static String reverse(String str) {
        char[] chars = str.toCharArray();
        int left = 0;
        int right = chars.length - 1;
        
        while (left < right) {
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;
            left++;
            right--;
        }
        return new String(chars);
    }
    
    // Check if palindrome
    public static boolean isPalindrome(String str) {
        int left = 0;
        int right = str.length() - 1;
        
        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
```

#### Common String Problems:

1. **Longest Palindromic Substring**:
```java
public class StringProblems {
    public static String longestPalindrome(String s) {
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
    
    private static int expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }
}
```

2. **String Permutations**:
```java
public class PermutationProblems {
    public static List<String> getPermutations(String str) {
        List<String> result = new ArrayList<>();
        permute(str, 0, str.length() - 1, result);
        return result;
    }
    
    private static void permute(String str, int left, int right, List<String> result) {
        if (left == right) {
            result.add(str);
            return;
        }
        
        for (int i = left; i <= right; i++) {
            str = swap(str, left, i);
            permute(str, left + 1, right, result);
            str = swap(str, left, i);
        }
    }
    
    private static String swap(String str, int i, int j) {
        char[] chars = str.toCharArray();
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
        return new String(chars);
    }
}
```

### 3. Linked List Manipulations:

#### Basic LinkedList Operations:
```java
public class LinkedListOperations {
    // Node class
    static class Node {
        int data;
        Node next;
        
        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
    
    // Insert at beginning
    public static Node insertAtBeginning(Node head, int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        return newNode;
    }
    
    // Insert at end
    public static Node insertAtEnd(Node head, int data) {
        Node newNode = new Node(data);
        if (head == null) {
            return newNode;
        }
        
        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
        return head;
    }
    
    // Delete node
    public static Node deleteNode(Node head, int key) {
        if (head == null) return null;
        
        if (head.data == key) {
            return head.next;
        }
        
        Node current = head;
        while (current.next != null) {
            if (current.next.data == key) {
                current.next = current.next.next;
                break;
            }
            current = current.next;
        }
        return head;
    }
    
    // Reverse linked list
    public static Node reverse(Node head) {
        Node prev = null;
        Node current = head;
        
        while (current != null) {
            Node next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }
}
```

#### Common LinkedList Problems:

1. **Detect Cycle**:
```java
public class LinkedListProblems {
    public static boolean hasCycle(Node head) {
        if (head == null || head.next == null) return false;
        
        Node slow = head;
        Node fast = head;
        
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            
            if (slow == fast) return true;
        }
        return false;
    }
    
    // Find cycle start node
    public static Node findCycleStart(Node head) {
        if (head == null || head.next == null) return null;
        
        Node slow = head;
        Node fast = head;
        boolean hasCycle = false;
        
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            
            if (slow == fast) {
                hasCycle = true;
                break;
            }
        }
        
        if (!hasCycle) return null;
        
        slow = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}
```

2. **Merge K Sorted Lists**:
```java
public class MergeKSortedLists {
    public static Node mergeKLists(Node[] lists) {
        if (lists == null || lists.length == 0) return null;
        
        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> a.data - b.data);
        
        for (Node list : lists) {
            if (list != null) {
                pq.offer(list);
            }
        }
        
        Node dummy = new Node(0);
        Node current = dummy;
        
        while (!pq.isEmpty()) {
            Node node = pq.poll();
            current.next = node;
            current = current.next;
            
            if (node.next != null) {
                pq.offer(node.next);
            }
        }
        
        return dummy.next;
    }
}
```

### 4. Tree Manipulations:

#### Basic Tree Operations:
```java
public class TreeOperations {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        
        TreeNode(int val) {
            this.val = val;
        }
    }
    
    // Insert node
    public static TreeNode insert(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }
        
        if (val < root.val) {
            root.left = insert(root.left, val);
        } else {
            root.right = insert(root.right, val);
        }
        
        return root;
    }
    
    // Delete node
    public static TreeNode delete(TreeNode root, int val) {
        if (root == null) return null;
        
        if (val < root.val) {
            root.left = delete(root.left, val);
        } else if (val > root.val) {
            root.right = delete(root.right, val);
        } else {
            if (root.left == null) return root.right;
            if (root.right == null) return root.left;
            
            TreeNode min = findMin(root.right);
            root.val = min.val;
            root.right = delete(root.right, min.val);
        }
        
        return root;
    }
    
    private static TreeNode findMin(TreeNode node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }
}
```

#### Common Tree Problems:

1. **Level Order Traversal**:
```java
public class TreeProblems {
    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            List<Integer> currentLevel = new ArrayList<>();
            
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();
                currentLevel.add(node.val);
                
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
            
            result.add(currentLevel);
        }
        
        return result;
    }
}
```

2. **Validate Binary Search Tree**:
```java
public class BSTProblems {
    public static boolean isValidBST(TreeNode root) {
        return validate(root, null, null);
    }
    
    private static boolean validate(TreeNode node, Integer min, Integer max) {
        if (node == null) return true;
        
        if ((min != null && node.val <= min) || 
            (max != null && node.val >= max)) {
            return false;
        }
        
        return validate(node.left, min, node.val) && 
               validate(node.right, node.val, max);
    }
}
```

### 5. Graph Manipulations:

#### Basic Graph Operations:
```java
public class GraphOperations {
    static class Graph {
        private int V;
        private List<List<Integer>> adj;
        
        Graph(int V) {
            this.V = V;
            adj = new ArrayList<>();
            for (int i = 0; i < V; i++) {
                adj.add(new ArrayList<>());
            }
        }
        
        void addEdge(int v, int w) {
            adj.get(v).add(w);
        }
        
        List<Integer> getAdjacent(int v) {
            return adj.get(v);
        }
    }
    
    // DFS traversal
    public static void dfs(Graph graph, int start) {
        boolean[] visited = new boolean[graph.V];
        dfsUtil(graph, start, visited);
    }
    
    private static void dfsUtil(Graph graph, int v, boolean[] visited) {
        visited[v] = true;
        System.out.print(v + " ");
        
        for (int neighbor : graph.getAdjacent(v)) {
            if (!visited[neighbor]) {
                dfsUtil(graph, neighbor, visited);
            }
        }
    }
    
    // BFS traversal
    public static void bfs(Graph graph, int start) {
        boolean[] visited = new boolean[graph.V];
        Queue<Integer> queue = new LinkedList<>();
        
        visited[start] = true;
        queue.offer(start);
        
        while (!queue.isEmpty()) {
            int v = queue.poll();
            System.out.print(v + " ");
            
            for (int neighbor : graph.getAdjacent(v)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.offer(neighbor);
                }
            }
        }
    }
}
```

#### Common Graph Problems:

1. **Topological Sort**:
```java
public class GraphProblems {
    public static List<Integer> topologicalSort(Graph graph) {
        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[graph.V];
        
        for (int i = 0; i < graph.V; i++) {
            if (!visited[i]) {
                topologicalSortUtil(graph, i, visited, stack);
            }
        }
        
        List<Integer> result = new ArrayList<>();
        while (!stack.isEmpty()) {
            result.add(stack.pop());
        }
        return result;
    }
    
    private static void topologicalSortUtil(Graph graph, int v, 
                                          boolean[] visited, Stack<Integer> stack) {
        visited[v] = true;
        
        for (int neighbor : graph.getAdjacent(v)) {
            if (!visited[neighbor]) {
                topologicalSortUtil(graph, neighbor, visited, stack);
            }
        }
        
        stack.push(v);
    }
}
```

2. **Dijkstra's Algorithm**:
```java
public class ShortestPathProblems {
    public static int[] dijkstra(int[][] graph, int source) {
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
                    dist[u] + graph[u][v] < dist[v]) {
                    dist[v] = dist[u] + graph[u][v];
                }
            }
        }
        return dist;
    }
    
    private static int minDistance(int[] dist, boolean[] visited) {
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
}
```

Remember to:
1. Practice implementing these algorithms
2. Understand the time and space complexity
3. Test with different input sizes
4. Consider edge cases
5. Optimize for performance when needed

The best way to master DSA is through consistent practice and understanding the underlying concepts!
