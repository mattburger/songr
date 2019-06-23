# Lab 11/ Lab 12/ Lab 13
## Lab 11: Building Full-Stack Web Apps
Set up a basic webapp. (Will be used for Labs 12-17)

### Tasks
- Ensure that you can run the Spring app.
- Create a hello world route at /hello, and ensure that you can visit that route in your browser and see data come back.
- Create a route that turns words into UPPER CASE. For instance, I should be able to visit /capitalize/hello and get back the response HELLO, or I could visit /capitalize/this is Kinda Capitalized and get the response THIS IS KINDA CAPITALIZED.
- Write a unit test for the capitalization functionality of that route.
Create a route that reverses the order of the words in a query parameter. For example, if I visit /reverse?sentence=Hello world, it should return world Hello.
- Write a unit test for the word reversing functionality of the above route.

### Testing
- You can test this app be following the link to the test code, clone it, then add and edit to test to your liking.
- [Test Code](https://github.com/mattburger/songr/tree/master/src/test/java/com/bjmbjm/code401d56day12/firstSpringDemo)

## Lab 12: Spring MVC with Databases
Create a simple webapp that retrieves and stores information to a sql db.

### Tasks
- Create an Album model.
    - An Album has a title, an artist, a songCount, a length (in seconds), and an imageUrl that is a link to that album’s art.
- A user should be able to see information about all the albums on the site.
- A user should be able to add albums to the site.

### Run
- ./gradlew bootrun

## Lab 13: Related Resources and Integration Testing
Add addtional functionality

### Tasks
- Create a Song model.
    - A Song has a title, a length (in seconds), a trackNumber, and the album on which that song appears.
    - Ensure that the relationship between Albums and Songs is appropriately set up.
- A user should be able to see information about all the songs on the site.
- A user should be able to view a page with data about one particular album.
- A user should be able to add songs to an album.
    - A user should be able to see the songs that belong to an album when looking at that album.

### Run
- ./gradlew bootrun
- [Test Code](https://github.com/mattburger/songr/tree/master/src/test/java/com/bjmbjm/code401d56day12/firstSpringDemo)