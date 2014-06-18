MongoClient
===========
1.Main.java-
Call the interact function from CLOps to interact with the user.

2.CLOps.java
This class is used to do the command line operations. Options to
 * 1.Generate Test Data
 * 2.Insert Test Data
 * 3.Perform a Read Speed Test
 * 4.CRUD Options

3.GenTestData.java-
Generates Test Data (1,000,000 records). 
The data is genrated in JSON format using UUID and ouput to a file.

4.TestData.java-
Used to insert test data. Reads from a file and inserts the records.
Also gives the time take for insertion.

5.ReadPerfTest.java-
Used to measure time taken to search for 10,000 records.

6.ConfigManager.java-
Creates a singleton object of itself.
Reads from the config file and selects the database type to be used.

7.CRUD.java-
Interface for CRUD operations

8.DBClient.java-
Returns an object of type CRUD. Used to create an object specific to the chosen database.

9.Device.java-
Stores the details of the device object.

10.MongoCRUD-
Implements CRUD for MongoDB



