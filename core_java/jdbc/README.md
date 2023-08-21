# Introduction
The goal of this project was to develop a Java application that connects to and communicates with a PSQL (PostgreSQL) database using the JDBC API. To make it easier to manipulate data in our PSQL database, we introduced basic CRUD actions including Create, Read, Update, and Delete. A docker container image that runs PSQL was made using Docker. We constructed the CRUD operations after connecting Java and PSQL, and we checked our solution by consulting our database. We ran CRUD operations on a variety of default values that we loaded into the table. Several dependencies were created and managed using Maven. We checked by running a SELECT statement and selecting the ID to look for in the WHERE clause. 

# Implementaiton
## ER Diagram
ER diagram
![ER Diagram](/core_java/jdbc/assets/ERD-jdbc.png?raw=true)

## Design Patterns
The DAO (Data Access Object) and Repository design patterns are both implemented as part of the project.

The CRUD actions in a database are made easier by the classes and interfaces that are created as part of the abstract design process known as the DAO pattern. The DAO design is used in the project to develop a class that represents the 'Customers' table. With class attributes matching the columns in the database table, each instance of this class represents a row within the table. The class's methods are in charge of carrying out CRUD tasks including adding new entries, modifying rows that already exist, reading data, and deleting rows.

The Repository design pattern, on the other hand, is comparable to DAO but focuses solely on a single table per class. The DAO implementation for the 'Customers' table in our project follows the Repository design pattern as well. Despite the fact that both DAO and Repository designs interact with the database and abstract access to it, DAOs are typically created to be more versatile and deal with a variety of object kinds. Repositories, in contrast, perform more like a collection and serve as a particular kind of object search, providing CRUD activities, specifically for the 'Customers' table.

When these design patterns are used, an organized and effective connection with the database is ensured, as well as a distinct separation of concerns, code reuse, and maintainability.

# Test
DBeaver was used to create the database, and DDL SQL commands were used to generate the tables based on sample data.
Manual testing of CRUD functions from DAO classes and comparing the results to those from DBeaver performing the same queries was utilised to test the JDBC application.
