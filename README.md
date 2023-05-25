
## Zodiak App Project
Zodiak is a utility service app that receives a User’s birthdate and predicts their Sun sign, and Elemental Value as dictated by Western Astrology, mapping where the Sun was stationed on the User’s date of birth.

This app takes in a User given birthdate, and name. Then it internally identifies which of the 12 subgroup Classes it belongs to, as organized by Quad Groups (consisting of the 4 Elemental Values = Water, Fire, Air, Earth). 

## Motivation
Zodiak makes predicting a User’s sunSign and elemental qualities quick, easy and fun! Share your sign results with your friends and discuss the nuances of Astrology and personalities.

## Build status
Gradle 
Build status of continuous integration i.e. travis, appveyor etc. Ex. - 

[![Build Status](https://travis-ci.org/akashnimare/foco.svg?branch=master)](https://travis-ci.org/akashnimare/foco)

## Code style
If you're using any code style like xo, standard etc. That will help others while contributing to your project. Ex. -

[![js-standard-style](https://img.shields.io/badge/code%20style-standard-brightgreen.svg?style=flat)](https://github.com/feross/standard)
 
## Screenshots
Include logo/demo screenshot etc.

Zodiak Load Screen 1,2, and Directions
<img src= “https://www.figma.com/file/eC5nieQ8Z6vRwT7bZnhkV1/ZodiakGUIWireFrame?type=design&node-id=1%3A34&t=Qe3w3a9LlQdCeCWN-1“>

## Tech/framework used
Ex. Java language 
Ex. Dagger Framework for Dependencies
Ex. Mockito Framework for Testing 

<b>Built with</b>
- IntelliJ IDE

## Features
What makes your project stand out?

## Code Example

The Zodiak library consists of 2 Utility / Factory Classes that handle logic and invalid User input, Zodiak also has 2 API Status Methods Create and Get. These Classes connect to the server and interacts with a new User request, or fetches saved data for an existing and saved User's Id. User Elemental and Sign information is stored using a DynamoDB Database Table.

 public void saveUser(User user){
        dynamoDbMapper.save(user);
        dynamoDbMapper.save(user.getElemental());
        dynamoDbMapper.save(user.getZodiac());
        dynamoDbMapper.save(user.getPronouns());



## Installation
Provide step by step series of examples and explanations about how to get a development env running.

1. Run with Gradle Compilation
2. Open this program from the template_java_project directory.

Ex: 
In Terminal 
  cd zodiakProjectApp
**cd template_java_project**

[template_java_project]((https://github.com/gbauza3destinee/zodiakApp/blob/bccf1092c8549be63a1c1862f8cba23afccde0e6/template_java_project)) 

## API Reference

### Zodiak's API Syntax Rules 

Searching Requirements 
- The Birthdate of a User may be searched using a string of characters.
- The input is limited to letters, numbers, and special characters '/' and ‘_’.

Listing Requirements 

- The system shall allow the client to request Zodiac and Elemental information for a given birthdate.
- The system shall allow the client to limit the results to a specific birthdate provided (limited to known birthdates starting from one year before 2023).


### Zodiak's API Documentation 
API Swagger YAML File (not hosted)

openapi: 3.0.3
info:
  title: Zodiak App - OpenAPI 3.0
  description: |- Magical App that forecasts your solar sign given the day you were born!
    

tags:
  - name: zodiac
    description: Everything about your Zodiac & Elemental Signs
    externalDocs:
      description: Find out more
      url: http://swagger.io
  - name: user
    description: Operations about user
paths:
  /user/{userName}:
    post:
      tags:
        - user
      summary: A User entering information to save their entry.
      description: Add a new User to the system
      operationId: createUser
      parameters:
        - name: userName
          in: path
          description: userName of user that needs to be updated
          required: true
          schema:
            type: integer
            format: int64
        - name: pronouns
          in: query
          description: Pronouns of user that needs to be saved
          schema:
            type: string
        - name: birthdate
          in: query
          description: Birthdate of user that needs to be updated
          schema:
            type: string
      requestBody:
        description: Create a new User in the store
        content:
          application/json:
            schema:
              $ref: '#/components/schemas/User'
          application/xml:
            schema:
              $ref: '#/components/schemas/User'
          application/x-www-form-urlencoded:
            schema:
              $ref: '#/components/schemas/User'
        required: true
      responses:
        '200':
          description: Successful operation
          content:
            application/json:
              schema:
                $ref: '#/components/schemas/User'
            application/xml:
              schema:
                $ref: '#/components/schemas/User'
        '405':
          description: Invalid input

  /zodiac/user/{userId}:
    get:
      tags:
        - zodiac
      summary: Find zodiac order by userID
      description: For valid response try integer IDs with value <= 5 or > 10. Other values will generate exceptions.
      operationId: getZodiacByUserId
      parameters:
        - name: userId
          in: path
          description: ID of user that needs to be fetched
          required: true
          schema:
            type: integer
            format: int64
      responses:
        '200':
          description: successful operation
          content:
            application/json:
              schema:
                $ref: '#/components/schemas/Zodiac'
            application/xml:
              schema:
                $ref: '#/components/schemas/Zodiac'
        '400':
          description: Invalid user ID supplied
        '404':
          description: User and Zodiac not found

components:
  schemas:
  Zodiac:
      type: String
      properties:
        userid:string
          type: integer
          format: int64
          example: 14045060

  User:
      type: object
      properties:
        username:
          type: string
          example: daisyluv
        pronouns:
          type: string
          example: they them
        birthdate:
          type: integer
          example: 2000-20-02
      xml:
        name: user

  requestBodies:
    User:
      description: User object that needs to be added to the database
      content:
        application/json:
          schema:
            $ref: '#/components/schemas/User'
        application/xml:
          schema:
            $ref: '#/components/schemas/User'
    UserArray:
      description: List of user object
      content:
        application/json:
          schema:
            type: array
            items:
              $ref: '#/components/schemas/User'



## Tests
Describe and show how to run the tests with code examples.

UserGeneratorServiceTest.java
DateCalculatorTest.java
CreateUserActivityTest.java
GetZodiacActivitiyTest.java


## Contribute

You can contribute to this project, by adding in a Class that gives more n Sun and Elemental Signs Descriptions, as well as adding in an API request for User’s time of birth and geolocation birth place, in order to begin adding in more logic for assigning all 11 other signs, a User might want to access.

Let people know how they can contribute into your project. A [contributing guideline](https://github.com/zulip/zulip-electron/blob/master/CONTRIBUTING.md) will be a big plus.

## Credits
Credits to my mentor Swastik, and the Chani Nicholas’ app that inspired me to recreate an interactive Astrological app, but as lightweight as possible.

  
## How to Use this Repository

All project files that you use should be inside this repository. If you're working on a team, all team members should have access to the same repository so you can share your files in one place.

As we mentioned above, we first recommend becoming familiar with the contents of this repository. If you have questions about the requirements of this project, feel free to reach out to the instructor to get any clarification.

We've included a template Java project and webpages. Feel free to use these examples as references as you build out your own project.


## What Files are in This Repository?


#### [Reflection](project_documents/reflection.md)

You can find my reflection notes within the Project_documents directory. Contains learned material, code design decisions, and the evolution progress of the app. 
