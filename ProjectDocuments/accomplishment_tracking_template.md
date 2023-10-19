# [DES] - [ZODIAK APP] Accomplishment Tracking

Each team member should have their own version of this document.

## Background

It's a great habit to record accomplishments and progress throughout your SDE
career. It's useful to reflect on what you've worked on in the past and comes in
handy during performance reviews and promotion cycles.

## Instructions

**Save a copy of this document in your “private” folder.**

Using the below template, keep track of what you’ve worked on each week during
the unit. 1-3 bullets under each section for each week should suffice. This
should only take 5 - 10 minutes of reflection each week.

As you track your work, think about how it relates to the SDE fundamental skills
laid out in the syllabus and how you are practicing them.

* Converts a design into code and delivers it using best practices
* Writes secure, testable, maintainable code
* Understands when to use (or not) a broad range of data structures and
  algorithms
* Creates unit tests that thoroughly test functionality
* Troubleshoots by debugging and reviewing errors, logfiles, and metrics
* Contributes to planning and design
* Escalates when projects hit roadblocks and risks

The important work samples don’t only include the things you authored, but
should include things like key CRs you reviewed that you are proud of as well!

_You will submit your completed Accomplishment Tracking Document to your
instructors by the end of the unit._

## Week 1

**Goals: Set up my project's Wire Frame and Prototype Designs via Figma **

**Activity: Scaffold code plan and front end wireframe for client facing main menus.**

**Important Docs, Commits, or Code Reviews**:

**Things learned: A prototype of an app idea, can help organize execution of flow within a program being built up, 
this later helps with conceptualizing the Class architecture of the program and which relationships come into 
play in order for the program to work smoothly, this all comes together within the Plant UML diagram.**

## Week 2

**Goals: Map out the exchange of data in my program (what is the currency of information passed), and set up new database tables that will correlate to my program, via a database's CLI program.**

**Activity: Implement all model classes, dao class (with limited logic) and all POJO - database facing classes.**

**Important Docs, Commits, or Code Reviews**:

**Things learned: Using AWS CLI, and a command related to "CLOUDFORMATIONSTACKS", we can deploy directly via terminal, 
our new database tables to intiate via our Database Server, and what their PRIMARY KEY or unique identifiers will be. 
This able to be deployed with a YAML File that provides a server specific steps and values to set up within the table, 
in a format the database server will understand.**

## Week 3

**Goals: Code Implementation begins, starting with 
- Utility app (that holds most of the logic) 
- model classes which are just POJOs that contain dynamodb annotations and help the program connect from data-model classes to real time operations done on our database's table**
- DAO class which will be without business logic, and the only class to touch the dynamodb (database) save and load functions, which perform actual changes, updates and operations to our tables located on the database server.


**Activity: Define where the logic of my program will be done, and set this class' access modifiers so that all classes needing to access this logic (date calculation or customer entry validation) easily. **

**Important Docs, Commits, or Code Reviews**:

**Things learned: Instead of implementing new classes to represent the object of "Zodiac Sign" and "Elemental Sign", 
to simplify the code architecture I let the model classes and api related classes utilize simple Strings that contained an 
Zodiac or Elemental value, and stored this in a dataset that made most sense for accessing it - a hashmap which contained an arraylist .
For focusing on logic, I added in 2 utility classes to handle date calculation and comparison, and evaluating a user's string values.**

## Week 4

**Goals: Define and set up with Swagger and RapiDoc my program's API functions and details for users or other clients to connect to.**

**Activity: Creating test files using Spring Framework tags, and solely writing tests for logic based classes. Reviewing and implementing Swagger's Online API editor in yaml code and json code. Viewing the visual output using Swagger's interface.**

**Important Docs, Commits, or Code Reviews**: External Resources- Swagger, Syntax - RapiDoc/ OpenAPI

**Things learned: Returning to the API Documentation built with OpenAPI's standard rules, I noticed the structure of
defining my program's api functions was very similar to the yaml file created to map out my database's tables as well. 
I also understood the process on creating a well documented API doc for future developers and clients wanting to access these 
API functions (Get) and (Post). I struggled with deployment of the API code to the AWS S3 server, after having created a bucket
I found it difficult to understand how to attach my API documentation via Lambda function or via "Creation of Object Lambda Access Point." **
