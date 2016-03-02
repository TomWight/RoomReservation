# RoomReservation
Simple room reservation utility

## Project Outline

- Design
  - Database schema diagram, even if it is a photo of something sketched on paper
  - User stories
 
- Infrastructure
  - Java build using ant/ Gradle/ Maven
  - Place (folders) for Java files, JUnits and so on
  - Eclipse project
  - Database server up and running
  - SQL scripts that can create your database tables 
  - SQL scripts with test data

- Back-end Code
  - DAO for CRUD (create, retrieve, update, delete) operations on each table, with a JUnit test
  - Services for each user story, with a JUnit test
 
- Front-end Code
  - ..

## User Stories
- As a meeting attendee I want to find when and where my next meeting is
-   select * from Meetings where org=MY_ORG and time=TODAY
-   Use join to show org.name
- As a meeting attendee I want to get a list of future meetings
-   select * from Meetings where org=MY_ORG and time>TODAY
-   Use join to show org.name
- As a meeting organizer I want to get a list of available rooms on a given afternoon or evening
-   select * from Rooms where Rooms.id not in (select Rooms.id from Meetings where time=TODAY)
- As a meeting organizer I want to schedule a meeting
-   Insert into Meetings (org_id, room_id, time)
- As a meeting organizer I want to schedule a sequence of monthly meetings
-   Will look into this later, but involves multiple inserts with the date changing
- As a meeting organizer I want to cancel a meeting
-   Delete from Meetings where meeting_id=MY_MEETING_ID
- As the building manager I want to get information on who is using the building
-   select * from Meetings where time = TODAY

## Project Timelines
- Feb 29 - Complete design and infrastructure tasks

