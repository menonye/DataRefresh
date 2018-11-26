# DataRefresh
I have run: mvn eclipse:eclipse, which should allow eclipse IDE users to download and run the code successfully;
by adding the project and classPath respectively
In application.properties: to run this application using Oracle, you need to replace the mysql details with Oraclke Database details
The DBInitializer should be uncommented and a;llowed to run only once, as soon as the database table is populated and commented again
The FLOW object is running perfectly and populating the db table (fully tested); you can uncomment some of the test cases
The flow-configuration has been developed but not tested yet
Restful API can be tested using this URL:
//http://localhost:8080/api/jsonValidate/2 --->works good
//http://localhost:8080/api/jsonValidate/9 ----> well formated Error message
