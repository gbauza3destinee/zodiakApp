# [team name] Design Document

## Instructions

*Save a copy of this template for your team in the same folder that contains
this template.*

*Replace italicized text (including this text!) with details of the design you
are proposing for your team project. (Your replacement text shouldn't be in
italics)*

*You should take a look at the example design document in the same folder as
this template for more guidance on the types of information to capture, and the
level of detail to aim for.*

## *Project Title* Design

## 1. Problem Statement

*This App predicts a User's strengths and preferred workflow, by taking in a valid birthdate and returning Astrological Information .*


## 2. Top Questions to Resolve in Review

*List the most important questions you have about your design, or things that
you are still debating internally that you might like help working through.*

1. Setting up the relationship between Elemental Classes (4) and the Zodiac SuperClass -  
which functionality should be hidden (in Zodiac Class), and which should be open to use?
2. Setting up the Elemental + Zodiac HashMap 
3. Date Calculator Class, takes in User input (birthdate)  -
what is the simplest way to sort a User Input and match it to it's corresponding Sun Sign Element? 

## 3. Use Cases

*This is where we work backwards from the customer and define what our customers
would like to do (and why). You may also include use cases for yourselves, or
for the organization providing the product to customers.*

U1. *As a [Zodiak] customer, I want to `<generate my Sun Sign information>` when I `<enter my birthdate>`*

U2. *As a [Zodiak] customer, I want to generate my overarching energy to lean it, when I enter my birthdate. 

U3. *As a [Zodiak] customer, I want to be able to save my entry and be able to view my report, when I first run the program.

## 4. Project Scope

*Clarify which parts of the problem you intend to solve. It helps reviewers know
what questions to ask to make sure you are solving for what you say and stops
discussions from getting sidetracked by aspects you do not intend to handle in
your design.*

* The [Zodiak] app will help users find their preferred flow of productivity and inspiration, 
* by producing a custom and easy streamlined program that takes in a User Birthdate, and returns to them a unique report.
* This report, can later be accessed and saved in a [UserId] and be able to access it to view the report through producing an API Request to "view"

### 4.1. In Scope

*Which parts of the problem defined in Sections 1 and 3 will you solve with this
design?*

* I will provide a reliable Class Architecture that will allow a User to connect to the API to manage their input and generated report, 
* by receiving it through API Request / Result Classes and a Database Table Design that uses unique UserId's for saving a selected entry, for later viewing.

### 4.2. Out of Scope

*Based on your problem description in Sections 1 and 3, are there any aspects
you are not planning to solve? Do potential expansions or related problems occur
to you that you want to explicitly say you are not worrying about now? Feel free
to put anything here that you think your team can't accomplish in the unit, but
would love to do with more time.*

With this app, I will not be focusing on the expanded features of a Zodiac Full Report (i.e. each of the 12 Houses and descriptors,
instead this program will focus on a User's dominant energy as provided in their Sun Sign, and the overarching related Elemental Values to provide the user basic insight.

# 5. Proposed Architecture Overview

*Describe broadly how you are proposing to solve for the requirements you
described in Section 3.*

*This may include class diagram(s) showing what components you are planning to
build.*

*You should argue why this architecture (organization of components) is
reasonable. That is, why it represents a good data flow and a good separation of
concerns. Where applicable, argue why this architecture satisfies the stated
requirements.*

 [ See ZodiakClass.puml file for proposed Class Diagram]

# 6. API

Offers Users a "POST" API status method only.

## 6.1. Public Models

*Define the data models your service will expose in its responses via your
*`-Model`* package. These will be equivalent to the *`PlaylistModel`* and
*`SongModel`* from the Unit 3 project.*

## 6.2. *First Endpoint*

*Describe the behavior of the first endpoint you will build into your service
API. This should include what data it requires, what data it returns, and how it
will handle any known failure cases. You should also include a sequence diagram
showing how a user interaction goes from user to website to service to database,
and back. This first endpoint can serve as a template for subsequent endpoints.
(If there is a significant difference on a subsequent endpoint, review that with
your team before building it!)*

*(You should have a separate section for each of the endpoints you are expecting
to build...)*

## 6.3 *Second Endpoint*

*(repeat, but you can use shorthand here, indicating what is different, likely
primarily the data in/out and error conditions. If the sequence diagram is
nearly identical, you can say in a few words how it is the same/different from
the first endpoint)*

# 7. Tables

*Define the DynamoDB tables you will need for the data your service will use. It
may be helpful to first think of what objects your service will need, then
translate that to a table structure, like with the *`Playlist` POJO* versus the
`playlists` table in the Unit 3 project.*

# 8. Pages

*Include mock-ups of the web pages you expect to build. These can be as
sophisticated as mockups/wireframes using drawing software, or as simple as
hand-drawn pictures that represent the key customer-facing components of the
pages. It should be clear what the interactions will be on the page, especially
where customers enter and submit data. You may want to accompany the mockups
with some description of behaviors of the page (e.g. “When customer submits the
submit-dog-photo button, the customer is sent to the doggie detail page”)*
