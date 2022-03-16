# QAProject
## Final Project by Bhavneesh Khosla

### Why are we doing this?

This project is a SpringBoot API with full CRUD functionality.

The API is for Student's Exam Results to be used for applications to access databases that store exam results. It allows for students to read entries and for administrators to update and delete entries. 

The application back-end is in Java 11. The managed database is local using MySQL. 

The datasource connection must be configured in the application-prod.properties file. A H2 database is utilised for testing.

Jira was used for project management, Git for version source control and Github for remote repository.


### How I expected the project to go?

The project to create a fully functional CRUD API seemed like a tough challenge after only 8 weeks of coding. To design the create and delete functions seemed the easiest, whilst designing a good structure for the code and the update function seemed most difficult. I expected the project to be challenging at best.

###What went well?
Designing the back-end was tricky, but it went well. All the features work. There are two user stories that did not get completed, these were both low priority and moved back to the project backlog. Unit testing went well and the postman requests work fine.

### Even better if?

I didn't manage to complete the low-level priority user stories to create a function to call one's results by their name and to call all student's results given a grade parameter.

Unfortunately, I was unable to get some of my integration tests to work. The error message displayed on the last line of each test was the same: 'No such elementException: No value present'.
All the integration tests were difficult to carry out but I managed to do most of them.
I had trouble with the Update method integration test;
I tried to troubleshoot the data-test.sql file to see if that was causing the problem but it seemed like the root of the problem was elsewhere. I then tried exploring the problem further tracing back the Junit failure trace, however I was unable to discern the exact problem and where the unparseable JSON string is.
I also tried troubleshooting using resources on the internet but I've been unable to find a solution that works or  that relate to the problem I have.
This was my last test and given the time contraints and my limited knowledge at the time, I've commented the specific failed line, and this enables me to build my project.
![Screenshot 2022-03-16 at 15 17 27](https://user-images.githubusercontent.com/97600800/158624718-4fa5f539-0bb2-47d7-8984-f38f8596210f.png)


### Possible improvements for future revisions of the project

The first improvement is to create functioning integration tests by solving the error: Unparsable JSON string.

I would improve the security of the student's exam results by making the student type the id of the result they want to read, but also confirm their name to check it corresponds with the id. I would also make sure that when students are given access to their results, they get given their id's individually so that students can't see other's results. There may be more possible improvements of this kind to ensure student's data is safe. Perhaps a unique password for each result that gets given to each student and is asked for. 

I would also create an admin password that is required to update and delete records so that only administators have access to these methods.

I would also imporve the API, by creating more functions that enable you to see all students who achieved a certain result. 

Another possible improvement would be to create a table for students details and then an associated table for results so that we can store students individually with a one to many relationship to the results table that stores the each result of each student. 

### Package

![Screenshot 2022-03-16 at 11 56 50](https://user-images.githubusercontent.com/97600800/158588382-f1c2c181-3eff-4f2e-ba9e-0bb73869d581.png)
![Screenshot 2022-03-16 at 11 57 01](https://user-images.githubusercontent.com/97600800/158588499-6177da0f-d8c8-4d17-b1f9-1e7916ae7592.png)


### Paths
Create student result  Post  /Create
Read a student's result  Get  /Read/{id}
Read all student's results  Get  /Read/All
Update a student's result  Put  /Update/{id}
Delete a Student's result  Delete  /Delete/{id}
Delete all student's results  Delete  /Delete

### Pre-Risk Assesment

![Screenshot 2022-03-16 at 15 51 21](https://user-images.githubusercontent.com/97600800/158632043-85387950-ee09-4f1a-93c9-5b1d94bb615f.png)
![Screenshot 2022-03-16 at 15 51 28](https://user-images.githubusercontent.com/97600800/158632297-d170dbeb-c06a-44ed-ba49-25f49864292e.png)
![Screenshot 2022-03-16 at 15 51 32](https://user-images.githubusercontent.com/97600800/158632388-ca267b62-7de4-43f3-9f4e-4707e993ecdf.png)


### Postman Screenshots

Starting the application from the terminal
![Screenshot 2022-03-16 at 11 46 23](https://user-images.githubusercontent.com/97600800/158586545-ecb3b916-cb4d-4960-ad29-b2d3de830f30.png)
![Screenshot 2022-03-16 at 11 46 36](https://user-images.githubusercontent.com/97600800/158586614-d5850464-a4a9-4739-8dbb-c2318ea04a69.png)

Using Create 
![Screenshot 2022-03-16 at 11 47 02](https://user-images.githubusercontent.com/97600800/158586694-bac46f28-d98a-4ce1-8463-dbacf5dccc53.png)
![Screenshot 2022-03-16 at 11 47 26](https://user-images.githubusercontent.com/97600800/158587237-c82c83e6-4c80-4f24-a607-9d5457ca017b.png)
![Screenshot 2022-03-16 at 11 47 41](https://user-images.githubusercontent.com/97600800/158587288-e592a79b-ebec-44fb-bdfc-b1a4fd6b9aea.png)

Get  /Read/{id}
![Screenshot 2022-03-16 at 11 47 58](https://user-images.githubusercontent.com/97600800/158587394-4d934045-0e22-4a5d-820e-12429e6f82c6.png)

Get  /Read/All
![Screenshot 2022-03-16 at 11 48 20](https://user-images.githubusercontent.com/97600800/158587567-b707b1c3-b186-402d-920d-1b934f5ddbbc.png)

Put  /Update/{id}
![Screenshot 2022-03-16 at 11 50 21](https://user-images.githubusercontent.com/97600800/158587676-926653be-6a3b-4f86-a4d2-c6a038e42c36.png)

Delete  /Delete/{id}
![Screenshot 2022-03-16 at 11 50 55](https://user-images.githubusercontent.com/97600800/158587879-9b229c3c-3ca4-4ac1-8112-8d4bec7ef27a.png)

Proof of update and delete by id
![Screenshot 2022-03-16 at 11 51 26](https://user-images.githubusercontent.com/97600800/158587972-115bf75b-49ce-490c-984a-f8dce3f6fcad.png)

Delete  /Delete
![Screenshot 2022-03-16 at 11 51 44](https://user-images.githubusercontent.com/97600800/158588014-e3cf7155-b239-49d7-85b0-5e5f48dab4fa.png)

Proof of delete all
![Screenshot 2022-03-16 at 11 51 56](https://user-images.githubusercontent.com/97600800/158588087-e02e9d61-9602-42f6-a71e-ea3cbbe1384a.png)

Data persistance - I entered data for four entries and then used Workbench to show the table to show the data persisted
![Screenshot 2022-03-16 at 11 54 40](https://user-images.githubusercontent.com/97600800/158588154-9cb7de85-ef28-4511-8f5e-e7c2d3f084af.png)

### Testing

![Screenshot 2022-03-16 at 11 58 25](https://user-images.githubusercontent.com/97600800/158588624-10b777d2-adc8-4be2-885b-fda154e63fc0.png)
![Screenshot 2022-03-16 at 15 20 23](https://user-images.githubusercontent.com/97600800/158625316-9b503b30-19b1-470a-9d04-3cfaeab118ee.png)


### Jira Link
For Jira, I implemented user stories with sub-tasks as acceptance criteria to complete the user story. There are estimations using story points. I used MoSCoW prioritisation in the form of priorities in Jira: The highest/high priority user-stories are Must-Have's, the Medium are Should-Have's and the low/lowest are Could-Have's.
The Could-Have's did not get complete during this sprint and is now in the backlog.
![Screenshot 2022-03-16 at 10 53 52](https://user-images.githubusercontent.com/97600800/158590150-4e98a5f7-cd7f-48ef-aa28-7ad399e6e463.png)
![Screenshot 2022-03-16 at 10 54 12](https://user-images.githubusercontent.com/97600800/158590251-1fbe5e66-ed0a-4816-b55f-08f5dc3c4404.png)

![Screenshot 2022-03-16 at 10 55 06](https://user-images.githubusercontent.com/97600800/158590284-940634d4-e4e1-40ca-92a5-0303eff82f66.png)


Jira : https://bk12.atlassian.net/jira/software/projects/QPR/boards/2/backlog

### Risk Assesment
![Screenshot 2022-03-16 at 15 51 48](https://user-images.githubusercontent.com/97600800/158632544-5e32f620-236b-4510-bd50-a8dc22f3fa97.png)
![Screenshot 2022-03-16 at 15 51 54](https://user-images.githubusercontent.com/97600800/158632613-43aa6299-91b9-4899-ae75-ef21e16857ae.png)
![Screenshot 2022-03-16 at 15 52 01](https://user-images.githubusercontent.com/97600800/158632670-566d7c45-b6ed-4c39-9334-3b503f43fff5.png)
![Screenshot 2022-03-16 at 15 52 06](https://user-images.githubusercontent.com/97600800/158632723-836f4695-9077-48c3-9c03-cf29522f9e8f.png)


### Extra Information
For the project you will need: Java, Springboot, Eclipse IDE, MySQL, Maven, h2, Postman.
The pom.xml file has the dependancies.
The target folder in the repo contains the .jar build for the project.

![Screenshot 2022-03-09 at 16 48 06](https://user-images.githubusercontent.com/97600800/158589838-bf23e002-ce7a-47cf-a30e-56c207c09531.png)