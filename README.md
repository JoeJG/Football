# SIS Football Team Java technical task

This is a simple Spring Boot application, allowing the creation of football team objects. These objects are held in a simple List, which is persisted as a Bean within Spring. This would obviously be held in a database in a real world situation, however for the purposes of this task, allows easy storage and retrieval of the team objects. I chose Spring Boot because of the ease of initial setup, I have been using Spring Boot for all of my prototype and live projects, the choice of many useful plugins, allows me to create great applications quickly (great for SOA).

To get started with the application after cloning, simply run the command "spring-boot:run" or alternatively, run the "mvn package" command to generate the jar file in the target directory. Once the app is running you can navigate to it on the following url: <http://localhost:8080/env>
You can also see the metrics for the application (thanks to the actuator plugin) here: <http://localhost:8080/metrics> This allows us to easily see how the application is performing and how fast the HTTP endpoints are responding, great for initial monitoring purposes.

Now if we navigate to the HTTP get request <http://localhost:8080/footballTeams/> we can see our initial list of football teams, I have pre populated this list with Manchester City. We can also create football teams by making a HTTP POST request to the <http://localhost:8080/footballTeams/> endpoint, we have to set our header to "Content-type":"application/json", we can also send in the body a team object like this one:

`{`  
`"name":"Manchester United",`  
`"city":"Manchester",`  
`"owner":"Malcolm Glazer",`  
`"competition":"Premier League",`  
`"players":["Blackett, Tyler","Blind, Daley","Borthwick-Jackson, Cameron","Carrick, Michael","Darmian, Matteo","de Gea, David","Depay, Memphis","Fellaini, Marouane","Fosu-Mensah, Timothy","Herrera, Ander","Januzaj, Adnan","Jones, Phil","Keane, William \"Will\"","Lingard, Jesse","Love, Donald","Martial, Anthony","Mata, Juan","McNair, Paddy","Pereira, Andreas","Poole, Reagan","Powell, Nick","Rashford, Marcus","Riley, Joe","Rojo, Marcos","Romero, Sergio","Rooney, Wayne","Schneiderlin, Morgan","Schweinsteiger, Bastian","Shaw, Luke","Smalling, Chris","Valdes, Victor","Valencia, Antonio","Varela, Guillermo","Weir, James","Wilson, James","Young, Ashley"]`  
`}`

This object will be parsed from the request body and added to the list of available teams. We can now search for this team by name, using the path variable in the url, like so: <http://localhost:8080/footballTeams/Manchester%20United> (It's worth noting that because the team name is used as the ID for these objects, it is possible to return multiple teams which have the same name from this endpoint, within a database we could constrain these names to be unique).

I have also added some info level logging into the TeamController, so we can see when a user makes a request to the application and also what their request was. I've used LOG4J as this implementation because of it's speed and the {} formatting allows easy log creation for the developer.

I wrote some integration tests using Spring's helpful testing annotations and Hamcrest's matchers, these matchers provide much more useful errors when tests fail, allowing much faster understanding of what went wrong and how to fix them (they're also easy to write when you get used to the syntax). Given a bit more time I would have created some controller tests using a mocked repository, however the tests are so lightweight I thought this was a bit unnecessary.

I'm quite happy with how lightweight this application has come out with code, less is more nowadays.
