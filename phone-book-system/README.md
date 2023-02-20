**PHONE BOOK SYSTEM - JAVA 17 - SPRING BOOT 3.0.2 - KOTLIN - GRADLE - H2 DATABASE**


**Summary of Service:**
    CRUD operations 
        - Create Contact
        - Update Contact by Id
        - Delete Contact by Id
        - Get all Contacts
        - Get single Contact by Id


**Setup:**

     No setup required, clone project and open in IntelliJ IDE and run. Runs on port 8080.
    Checkout application.properties file for more info.
    
    OR 

    Run " .\gradlew bootRun" in terminal

    OR 

    Build & Run with Dockerfile
        - Build with "docker build . -t phone-book-system" in terminal
        - Run with "docker run -p 8080:8080 phone-book-system" 


**Endpoints & Sample Payload:**
    
    1.  POST --> localhost:8080/api/v1/contacts/
        {
            "name": "name6",
            "phone": "666666",
            "address": "address6"
        }

    2. PUT --> localhost:8080/api/v1/contacts/6
        {
            "name": "name6",
            "phone": "666666",
            "address": "address6"
        }

    3. GET --> localhost:8080/api/v1/contacts/

    4. GET --> localhost:8080/api/v1/contacts/6

    5. DELETE --> localhost:8080/api/v1/contacts/6