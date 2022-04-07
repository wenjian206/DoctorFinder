# DoctorFinder

## Project Description

DoctorFinder is an app where you can sign in as a Patient to book an appointment, check your bills, update your profile, and search doctors by name or specialty. You can also sign in as a Doctor and view all patients assigned to you, view all pending appointments as well as reject any that you do not want to accept, create bills for patients, and update your profile. This app’s backend is built in Spring Boot using Java, Hibernate, Tomcat, and connects to our database in PostgreSQL via the driver dependency. We connect to our frontend built in Angular utilizing components, models, services to create a fully functioning application thats entirely customizable.

## Technologies Used

* Java - version 1.8.0_321
* Spring Boot - version 2.6.4
* PostgreSQL - version 14.2
* Angular - version 13.0.4
* Typescript - version 4.6.2
* Selenium - version 4.1.3
* JUnit - version 4.13.2
* Lombok - version 1.18.18
* Log4J - version 1.2.17

## Features

Doctor Functionality-

* Doctor can create an account.
* Doctor can view doctor profile.
* Doctor can update their profile with name, specialty, etc.
* Doctor can approve/reject pending appointments. 
* Doctor can view all patients assigned to him/her.

Patient Functionality-

* Patient can create an account.
* Patient can view patient profile.
* Patient can update patient profile.
* Patient can search a doctor by specialty.
* Patient can book an appointment with their doctor.
* Patient can see all bills.

To-do list:
* Patient can recover password (if needed).
* Patient and doctor are emailed on registration and for password recovery.

## Getting Started

* git remote add origin https://github.com/TUC01108/DOCTORFINDER
* git clone https://github.com/TUC01108/DOCTORFINDER.git

* Eclipse- Backend
* VSCode- Frontend
* DBeaver- Database
* Postman- HTTP

Backend-
Start server in Eclipse by right clicking on project and selecting >Run as>Spring Boot App.
Default is port 5050

Frontend-
Install dependencies for project with npm install
Start server in VsCode with npm start
Default is 4200

To get started type into browser- http://localhost:4200/

## Usage

The application starts on the login screen. From there you can click on Register to test out registering a patient or doctor.
Choose Patient register and type in name, email, password, city, doctor assigned (if you have), symptom, doctor Id (if you have).
Choose Doctor register and type in name, email, password, specialty, and city.
Click on Patient home above to be directed to the patient home page from there you can see all bill info, appointment into, add appointment, search doctor by specialty, or edit profile information.
Click on Doctor home on task bar to be directed to the doctor home page. From there you can see add bill, search patient by doctor assigned, approve/reject appointments, edit profile.


## Contributors

* Devyn Rucker
* Wenjian Zhang
* Thomas Winter

## License

This project does not use any license.

