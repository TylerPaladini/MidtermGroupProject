## Midterm Group Project

### Team Steel Assault

#### Created By Joshua Ciccone-Okodo, Zachary Lamb, Tyler Paladini and Rob Thompson

### Summary
This program was designed out of a need from one of the members of our group. If you have ever had a child in diapers that suddenly has a blow out, your first thought is of trying to find the closest diaper changing table. Every parent has experienced this and knows the struggle of knowing where to go if you are out in public. Our program is crowd sourced for public changing locations. We allow registered users to add locations but anyone is allowed to search for a location. We created this program in a week and a half and finished the program during week ten of the bootcamp. This project was created from scratch. We built the database and full CRUD availability from a website.

### Overview
The program has full web-based C.R.U.D. functionality using Spring MVC and the DAO pattern. The DAO implementation uses JPA to persist and retrieve data.

#### Operation/Description of how the program works:
The landing page of our website allows anyone that comes to the website to search for a location to find a changing table. The search ability looks at all location name or address. If a user has not registered they have the ability to do or login to the website. If a user has logged in they have the ability to add, delete, and update locations. Each location has restrooms which a user can add, delete and update. And a user is able to comment and update their own comments. A comment is also able to be flagged in case of any objections by another user. 

#### Technologies/Techniques Used

| Technologies       |
| ------------------ |
| JPA                |
| JDBC               |
| AWS                |
| Develop Database   |
| MVC                |
| Sprint Tools Suite |
| Enums              |
| Gradle             |
| Entities           |
| Interface          |
| HTML               |
| MAMP               |
| MySQL Workbench    |
| JUnit Jupiter      |
| Tomcat Server      |


#### Lessons Learned
- First and foremost we learned that this was hard. Many times we would be cruising along and come up to a point that we just couldn't get past. It seemed like we would be hitting our heads against the wall until we found the solution.
- We also learned that you can have a lot of fun while programming. Even in the tough times it is fun to try and work out the solution to have the program do what you actually want it to do. After all, a program only does exactly what you tell it to do.
- We learned how to deal with merge conflicts. As time went on we would have less conflicts because our communication got better and better about what each person was working on.
- We learned what it really takes to make a project and the amount of time that goes into making a full scale website. We guessed that in the real world that if you think something is going to take you a week to do that it is probably better to quadruple the time you think.
- If we got stuck on something we would try many different ways to attempt to make the program work. There are too many things to list here on what we learned or solidified how to do in this project.

#### Problems/Issues
We ran into many issues during the process of this project. Listed are a few that we decided to highlight.
- One issue that took us about a day to figure out, was that updating two tables using a single form was extremely difficult. After a day of trying multiple approaches, we found that using two forms instead of a single form would allow us to complete the functionality that we needed. 
- Another problem we ran into was validation. We believe that validation for all of the items that a user would enter into the website is good but it caused some issues while trying to make the project. We would often see a validation error when not working on a validation part of the project. This was because we would be working with an entity that has the validation of each item but in the database.
- When a user would like to make an update to anything and the form has a radio button it does not bring back the previous radio button that was already in the form. These radio buttons are also required items. So if the user does not select one of the buttons it would crash the program. Our work around this is to mark one of them as checked even though that may have not been the option that was previously selected.
- Another issue we ran into was attempting to accept a string and convert it to type Time with validation. 

#### Things we were unable to add or incorporate
- Mapping locations with GPS functionality
- Ability to create a road trip that would map locations along route
- Ability to upload pictures
- Ability to submit the hours for the different days of a location
- Build larger database of confirmed locations
