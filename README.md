# OUTREACH - FEEDBACK MANAGEMENT SYSTEM


This app enables participants to provide feedback , admin to upload events and POC to send reports to BU heads

Various users
  - Admin
  - PMO
  - POC
  - participants

## Software Requirements
 - STS 3.9
 - Node v12.14.1
 - Visual Studio Code 1.44.2
 - Mysql server 8.0.19
 - Mysql workbench CE 8.0.19
 - Postman 7.22.1

## Database
    - MySQL 8 has been used.
    - Import the schema.sql and data.sql from dbscripts to the work bench and run it to create the database.

## MID-TIER - Spring Webflux

#### fms-auth
	- for authentication - user sign and JWT generation
	- Admin can configure user roles
	- Spring 5 security has been used
	- Functional endpoints has been used.
	
- ##### Endpoints , input and output
| Endpoint  | Input   | Output   | Explanation  |
|---|---|---|---|
|  http://localhost:8090/authentication-service/auth/signin [post]|username and password to be provided  | token is generated  |On successful login jwt is generated   |
| http://localhost:8090/authentication-service/configure/111119/POC [put] | provied employee id as path variable along with role  | user role is changed   |  role changed for the required user |

---
#### fms-events
	- for getting all events or event by event number
	- for getting events based on user role
	- Functional endpoints has been used.
- ##### Endpoints , input and output
| Endpoint  | Input   | Output   | Explanation  |
|---|---|---|---|
|http://localhost:8090/event-service/events  [get] | -  |get event list | get all events if admin or get only the events poc is responsible for   |
| http://localhost:8090/event-service/events/EVM2 [get] |provide event number as path variable   | get particular event  | get a particular event detail based on event number  |
|http://localhost:8090/event-service/summary/2  [get] | provide event number in summary  |  get event summary | get event summary based on event number  |
|http://localhost:8090/event-service/dashboard  [get]|-  | get event dashboard for UI   | get sum of events, number of volunteers,number of participants and number of lives impacted   |
|  http://localhost:8090/event-service/createEvent [post]|  body has event data | -  | to create new event and save to database |
|http://localhost:8090/event-service/eventlist   [get]| body has list of events  |  - | to save a list of new events to database  |
---
	
#### fms-feedback
	- for getting all feedback or getting feedback by id
	- update feedback questions or add new feedback or add feedback preanswer.
	- add feedback answer for a feedback
	- REST API endpoints has been used.
- ##### Endpoints , input and output	
| Endpoint  | Input   | Output   | Explanation  |
|---|---|---|---|
| http://localhost:8090/feedback-service/event/feedback [get] |   | get all feedback  | get all feedback   |
| http://localhost:8090/feedback-service/event/feedback/2 [get] |  give feedback id as path variable | get feedback  |  feedback details is got for the feedback provided |
|http://localhost:8090/feedback-service/feedbackDashboard/14  [get] | provide feedback id as path variable   | get feedback along with pre answer  |  get feedback details with pre defined answers provided by admin for the feedback id provided |
| http://localhost:8090/feedback-service/event/feedback [post] | body consist of new feedback to be added along with predefined answers |   | add new feedback to the database  |
|http://localhost:8090/feedback-service/event/feedback [put]  | body consist of feedback to be updated  |   | update feedback in database  |
|http://localhost:8090/feedback-service/event/feedbackAns [post] | body consist of feedback answer for the  feedback along with user id |   | update feedback answer in database  |
| http://localhost:8090/feedback-service/event/feedbackPreAnswer/2 [put] |  provide feedbackId as path variable and body contains feedback to be updated |   | add or update predefined answer for an existing feedback by id.  |
---	
#### fms-data 
	- store data to database from spreadsheet places on share path
	- the spreadsheet is placed in another path with date and time..
	- spreadsheet includes - events, summary , unregistered and not attended volunteers
	- REST API endpoints has been used.
- ##### Endpoints , input and output	
| Endpoint  | Input   | Output   | Explanation  |
|---|---|---|---|
| http://localhost:8090/upload-service/upload/dir/events [post] | file placed in folder -OutReach Event Information.xlsx   | data saved to database  | event details is saved and the file is placed in another location with date and time  |
| http://localhost:8090/upload-service/upload/dir/summary [post] | file placed in folder - Outreach Events Summary.xlsx |  data saved to database   | event summary details is saved and the file is placed in another location with date and time  |
| http://localhost:8090/upload-service/upload/dir/notattended [post] |  file placed in folder -Volunteer_Enrollment Details_Not_Attended.xlsx | data saved to database    | not attended is saved and the file is placed in another location with date and time  |
| http://localhost:8090/upload-service/upload/dir/unregister [post] |  file placed in folder -Volunteer_Enrollment Details_Unregistered .xlsx|  data saved to database   | unregistered details is saved and the file is placed in another location with date and time  |

---	
#### fms-email
	- batch email to all participants - attended,not attented and unregistered participants
	- email reports as .xlsx attachments to BU heads
	- REST API endpoints has been used.
- ##### Endpoints , input and output	
| Endpoint  | Input   | Output   | Explanation  |
|---|---|---|---|
| http://localhost:8086/sendMail/eventMail/subhikshaguha@gmail.com  [post]| provide email id  |  email sent along with event report | email is sent to the provided email id along with events report as an .xlsx attachment  |
| http://localhost:8086/sendMail/mail/146 [post] | provide event id as path variable  |  feedback email is sent |feedback email is sent for participants, not attended and unregistered participants  |

---	
## POSTMAN
    import the json file and to check the end points

## FRONT END - (React - Redux)
- Developed using  react js and redux
- users can view dashboard on login
- role configuration can be made by admin
- event details can be viewed
- new feedback can be added or updated
- axios is used as the http client
