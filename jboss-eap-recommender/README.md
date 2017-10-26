jboss-eap-recommender: Recommender nased on Apache Mahout using assortment of technologies including Arquillian
========================
Author: Javier Gómez
Level: Intermediate  
Technologies: CDI, JSF, JPA, EJB, JPA, JAX-RS, BV  
Summary: Mahout Recommender that incorporates multiple technologies  
Target Product: EAP  
Product Versions: EAP 6.1, EAP 6.2, EAP 6.3  
  

What is it?
-----------

It creates a Mahout recommender from dataset.csv and exposes a REST interface to get recommendations

A Mahout-based collaborative filtering engine takes users’ preferences for items (“tastes”) and returns estimated preferences for other items. For example, a site that sells books or CDs could easily use Mahout to figure out, from past purchase data, which CDs a customer might be interested in listening to.


System requirements
-------------------

The application this project produces is designed to be run on Red Hat JBoss Enterprise Application Platform 6.1 or later. 

All you need to build this project is Java 6.0 (Java SDK 1.6) or later, Maven 3.0 or later.


Access the application 
---------------------

The application will be running at the following URL: <http://localhost:8080/jboss-eap-recommender/>.
Run on Jboss server and execute http://127.0.0.1:8080/jboss-eap-recommender/rest/rec/2 to get 3 uuser-based 
recommendations for user 2

Server Log: Expected warnings and errors
-----------------------------------

_Note:_ You will see the following warnings and errors in the server log. Hibernate attempts to drop the table and constraints before they are created because the `hibernate.hbm2ddl.auto` value is set to `create-drop`. You can ignore these warnings and errors.

        HHH000431: Unable to determine H2 database version, certain features may not work

        HHH000389: Unsuccessful: drop sequence hibernate_sequence
        Sequence "HIBERNATE_SEQUENCE" not found; SQL statement: drop sequence hibernate_sequence [90036-168]




Run the Arquillian Tests 
-------------------------

This quickstart provides Arquillian tests. By default, these tests are configured to be skipped as Arquillian tests require the use of a container. 

_NOTE: The following commands assume you have configured your Maven user settings. If you have not, you must include Maven setting arguments on the command line. See [Run the Arquillian Tests](https://github.com/jboss-developer/jboss-developer-shared-resources/blob/master/guides/RUN_ARQUILLIAN_TESTS.md#run-the-arquillian-tests) for complete instructions and additional options._

1. Make sure you have started the JBoss EAP server as described above.
2. Open a command prompt and navigate to the root directory of this quickstart.
3. Type the following command to run the test goal with the following profile activated:

        mvn clean test -Parq-jbossas-remote 

