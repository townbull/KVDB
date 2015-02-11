KVDB
========
A simple in memory key-value datastore system supporting nested transactions. The project is developed in Java and tested in Eclipse (Luna).

# Basic Operations
- SET: set a value to a key
- GET: get the value of a key
- DELETE: delete the key-value pair from the datastore
- COUNT: count the appearance of a specific value
- END: end the program

Example:
```
>>> SET A 10
>>> GET A
10
>>> SET B 10
>>> COUNT 10
2
>>> DELETE B
>>> COUNT 10
1
>>> GET B
NULL
>>> END
```

# Transaction Support
A transaction is a series of revertable commands. It can be committed or rollbacked after it begins.

## Basic Transaction
- BEGIN: set the begin point of a new transaction
- COMMIT: commit all the changes of all the outstanding transactions
- ROLLBACK: rollback the changes of the current transaction

Example:
```
>>> SET A 5
>>> BEGIN
>>> SET A 10
>>> SET A 20
>>> GET A
20
>>> COUNT 5
0
>>> DELETE A
>>> ROLLBACK
>>> GET A
5
```

## Nested Transaction
Nested transactions a useful when only the most recent transaction is required to be rollbacked.

Example:
```
>>> SET A 5
>>> BEGIN
>>> SET A 10
>>> BEGIN
>>> SET A 20
>>> GET A
20
>>> COUNT 5
0
>>> DELETE A
>>> ROLLBACK
>>> GET A
10
```


