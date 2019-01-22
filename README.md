# RestApplication-ws
A Spring Boot Rest Application with CRUDs, JUnits and Embedded database

#Building and running 
Before running the application, the dependencies must be installed. Considering Maven is already installed in your environment, browse the project folder in Terminal and type:

    mvn clean install
    
Now you can run the main method typing `java -jar <path-to-jar-file>` like this:

    java -jar  Z:\...\RestApplication-ws\target\RestApplication-WS.jar
    
It Should build and get your application running! (:   

##
## Application Endpoints

### CityDTO

`Find all cities`
 
    URL: `http://localhost:8080/api/city/all`
    METHOD: GET
    EXPECTED JSON: [
                       {
                           "id": 2,
                           "name": "Bauru",
                           "province": "SP"
                       }
                    ]
     
              
    *should return a list with all cities registerd*

    
`Find cities by city's name`
    
    URL: `http://localhost:8080/api/costumer/findByName/{cityName}`
    METHOD: GET
    URL EXAMPLE: http://localhost:8080/api/city/findByName/Guarulhos
    EXPECTED JSON RESPONSE: [
                               {
                                   "id": 3,
                                   "name": "Guarulhos",
                                   "province": "SP"
                               }
                           ]  


`Find cities by city's province`
    
    URL: `http://localhost:8080/api/city/findByProvince/{province}`
    METHOD: GET
    URL EXAMPLE: http://localhost:8080/api/city/findByProvince/SP
    EXPECTED JSON RESPONSE: [
                                  {
                                      "id": 1,
                                      "name": "Americana",
                                      "province": "SP"
                                  },
                                  {
                                      "id": 2,
                                      "name": "Bauru",
                                      "province": "SP"
                                  },
                                  {
                                      "id": 3,
                                      "name": "Guarulhos",
                                      "province": "SP"
                                  }
                              ]    
    
`Insert new City`
        
        URL: `http://localhost:8080/api/city/insert`
        METHOD: POST
        
        EXAMPLE INPUT JSON: {
                                    "id": 1,
                                    "name": "Americana",
                                    "province": "SP"
                                }
        
        EXPECTED JSON RESPONSE: {
                                    "id": 1,
                                    "name": "Americana",
                                    "province": "SP"
                                }


### CostumerDTO