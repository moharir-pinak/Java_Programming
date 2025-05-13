# Database Management System (DBMS) Notes

## 1. Introduction to DBMS
- **Definition**: A DBMS is software that manages databases, allowing users to create, read, update, and delete data.
- **Types**: Relational (RDBMS), NoSQL, Object-Oriented, etc.
- **Architecture**: Three-schema architecture (Internal, Conceptual, External).

## 2. Relational Database Concepts
- **Tables**: Collections of rows and columns.
- **Keys**: Primary, Foreign, Candidate, Super, Composite.
- **Normalization**: 1NF, 2NF, 3NF, BCNF, 4NF, 5NF.
- **Transactions**: ACID properties (Atomicity, Consistency, Isolation, Durability).

## 3. SQL Basics
- **DDL**: CREATE, ALTER, DROP.
- **DML**: INSERT, UPDATE, DELETE.
- **DQL**: SELECT.
- **Joins**: INNER, LEFT, RIGHT, FULL.
- **Subqueries**: Nested queries.

## 4. Advanced DBMS Topics
- **Indexing**: B-tree, Hash, Bitmap.
- **Concurrency Control**: Locking, Timestamp, Optimistic.
- **Recovery**: Log-based, Checkpointing.
- **Distributed Databases**: CAP theorem, Sharding.

## 5. Interview Questions

### Basic Questions
1. **What is a DBMS?**
   - A software system that manages databases, allowing users to interact with data efficiently.

2. **What is normalization?**
   - A process to minimize redundancy and dependency by organizing fields and tables.

3. **What are ACID properties?**
   - Atomicity, Consistency, Isolation, Durability ensure reliable transactions.

### Advanced Questions
4. **What is the difference between INNER JOIN and LEFT JOIN?**
   - INNER JOIN returns only matching rows, while LEFT JOIN returns all rows from the left table and matching rows from the right.

5. **What is indexing?**
   - A technique to improve data retrieval speed by creating data structures (indexes) on columns.

6. **What is the CAP theorem?**
   - In distributed systems, you can only guarantee two of Consistency, Availability, and Partition Tolerance.

7. **What is a transaction?**
   - A sequence of operations performed as a single logical unit of work.

8. **What is a deadlock?**
   - A situation where two or more transactions are waiting for each other to release locks, causing a standstill.

9. **What is a view?**
   - A virtual table based on the result of a SELECT query.

10. **What is a stored procedure?**
    - A precompiled collection of SQL statements stored in the database.

## 6. Additional DBMS Topics
- **Data Warehousing**: OLAP, OLTP, Data Marts.
- **Big Data**: Hadoop, MapReduce, NoSQL databases.
- **Cloud Databases**: AWS RDS, Azure SQL, Google Cloud SQL.
- **Security**: Authentication, Authorization, Encryption.
- **Performance Tuning**: Query optimization, Execution plans.

## 7. Important Interview Questions

### Normalization
11. **What is 1NF?**
    - First Normal Form: Eliminates duplicate columns and ensures atomic values.

12. **What is 2NF?**
    - Second Normal Form: Meets 1NF and removes partial dependencies.

13. **What is 3NF?**
    - Third Normal Form: Meets 2NF and removes transitive dependencies.

14. **What is BCNF?**
    - Boyce-Codd Normal Form: A stricter version of 3NF, ensuring all determinants are candidate keys.

15. **What is 4NF?**
    - Fourth Normal Form: Addresses multi-valued dependencies.

16. **What is 5NF?**
    - Fifth Normal Form: Addresses join dependencies.

### Other Important Questions
17. **What is a trigger?**
    - A stored procedure that automatically executes in response to certain events on a table.

18. **What is a cursor?**
    - A database object used to traverse through the rows of a result set.

19. **What is a database schema?**
    - The structure of the database, including tables, fields, relationships, and constraints.

20. **What is a database index?**
    - A data structure that improves the speed of data retrieval operations on a database table.

21. **What is a database transaction log?**
    - A file that records all changes made to the database, used for recovery.

22. **What is a database backup?**
    - A copy of the database used to restore data in case of failure.

23. **What is a database restore?**
    - The process of recovering a database from a backup.

24. **What is a database migration?**
    - The process of moving data from one database to another.

25. **What is a database replication?**
    - The process of copying data from one database to another to ensure redundancy and availability. 