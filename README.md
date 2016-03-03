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
- As an org member I want to find when and where my next meeting is
   - Find the first meeting in the Meetings table that has my org and has a date and time > now.
   - Will want to show the org, meeting name, room, date, and time.
   - Should also allow searching by meeting name.
- As an org member I want to get a list of future meetings
   - Find all of the meetings in the Meetings table that has my org and has a date and time > now.
   - Will want to show the org, meeting name, room, date, and time.
   - Should also allow searching by meeting name.
- As an org leader I want to get a list of available rooms on a given day
   - Find all rooms in the Room table that do not have a meeting scheduled in the given day.
   - Show the name and occupancy limit for each room
- As an org leader I want to schedule a meeting
   - Add an entry to the Meetings table that has the org, room, meeting info (name, date, time duration)
- As an org leader I want to cancel a meeting
   - Find the meeting and then remove it from the Meetings table.
   - If we find that there is a reason to keep the meeting information around, 
      - we can add set a Canceled flag instead of removing the entry.
      - As long as there is an easy way to create meetings, this does not seem necessary.
- As the building admin I want to get information on who is using the building
   - Find all of the meetings in the Meeting table that have a meeting_date of today.
   - Show the org name, meeting name, room, time, and duration for each meeting.
- As the building admin, I want to create the Rooms table
   - Add an entry for each room in the building.
   - This will not need to change much.
- As the building admin, I want to create the Orgs table
   - Add an entry for each org.
   - Entries may be added and removed as orgs come and go.
- As the building admin, I want to change the org_leader info.
   - Find the org in the Org table
   - Change the org_leader information

## User Stories for future features
- As an org leader I want to schedule a sequence of monthly meetings
-   Will look into this later, but involves adding multiple meetings into the Meeting table with only the date changing



## Project Timelines
- Feb 29 - Complete design and infrastructure tasks

