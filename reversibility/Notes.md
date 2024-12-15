# chapter 2: Reversibility :
    "Most of the time, calls to third-party products are entangled throughout the code. But if you really abstracted the idea of a database out- to the point where it simply provides persistence as a service - then you have the flexibility to change horses in midstream"

## General Idea :
    Instead of using if-else cases inside repositoryImpl's functions for segregating based on DB vendor, use can create seperate abstract layers for each DB vendor(That makes them persistance as a service) that we can pick and use whenever we want.

### What does it look like in code?
    1. Create a repository Interface for a repository business logic. ex : UserRepository
    2. Create mulitple implementations of that interface for each vendor. ex : PostgresUserRepositoryImpl, MongoUserRepositoryImpl.
    3. Create a bean using UserRepository that returns an implementation of UserRepository based on the DB vendor(which could have been passed as a parameter via external configuration).
    4. Inject that bean into the ServiceImpl business logic.
    5. We now have a clear abstraction of persistence as a service.