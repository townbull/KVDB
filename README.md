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
## Basic Transaction
- BEGIN:
- COMMIT:
- ROLLBACK:

## Nested Transaction

