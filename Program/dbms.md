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