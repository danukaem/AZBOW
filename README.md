AZBOW Application
Overview
The AZBOW application is a Spring Boot-based project designed to manage agents and leads. It provides RESTful APIs for creating and managing agents and leads, and integrates with a MySQL database.


Features
Create and manage agents
Create and manage leads
Assign leads to agents
Search leads by agent or status
Technologies Used
Java 21
Spring Boot 3.4.3
Spring Data JPA
MySQL
Maven
Lombok
Springdoc OpenAPI
Prerequisites
Java 21
Maven
MySQL
Setup
Database Configuration
Create a MySQL database named AZBOWDB.
Update the database configuration in src/main/resources/application.properties:
spring.datasource.url=jdbc:mysql://localhost:3306/AZBOWDB?createDatabaseIfNotExist=true
spring.datasource.username=root
spring.datasource.password=1234
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.jpa.database-platform=org.hibernate.dialect.MySQL8Dialect
spring.jpa.hibernate.ddl-auto=update
Build and Run
Clone the repository:
git clone https://github.com/your-username/azbow.git
cd azbow
Build the project using Maven:
mvn clean install
Run the application:
mvn spring-boot:run
API Endpoints
Agent Endpoints
Create Agent
URL: /api/agents
Method: POST
Request Body:
{
    "name": "John Doe",
    "contactInfo": "john.doe@example.com"
}
Response:
{
    "agentId": 1,
    "message": "Agent created successfully"
}
Lead Endpoints
Create Lead


URL: /api/leads
Method: POST
Request Body:
{
    "name": "Jane Smith",
    "contactInfo": "jane.smith@example.com",
    "status": "UNASSIGNED"
}
Response:
{
    "leadId": 1,
    "message": "Lead created successfully"
}
Assign Lead to Agent


URL: /api/leads/assign
Method: POST
Request Body:
{
    "leadId": 1,
    "agentId": 1
}
Response:
{
    "message": "Agent assigned successfully"
}
Search Leads


URL: /api/leads/search
Method: GET
Query Parameters:
searchBy (values: agent, status)
searchValue (e.g., ASSIGNED, UNASSIGNED)
Response:
[
    {
        "leadId": 1,
        "name": "Jane Smith",
        "status": "ASSIGNED"
    }
]
Running Tests
To run the tests, use the following command:
mvn test
