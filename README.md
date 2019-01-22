# RestApplication-ws
A Spring Boot Rest Application with CRUDs, JUnits and Embedded database

#Building and running 
Before running the application, the dependencies must be installed. Considering Maven is already installed in your environment, browse the project folder in Terminal and type:

    mvn clean install
    
Now you can run the main method typing `java -jar <path-to-jar-file>` like this:

    java -jar  Z:\...\RestApplication-ws\target\RestApplication-WS.jar
    
It Should build and get your application up to running! (:   

##
## Application Endpoints

### CityDTO

`Want to see all cities registered?`
 
    URL: `http://localhost:8080/api/city/all`
    METHOD: GET
    EXPECTED JSON: [
                       {
                           "id": 2,
                           "name": "Bauru",
                           "province": "SP"
                       }
                    ]
                    
                        
`Want to find cities by city's name?`
    
    URL: `http://localhost:8080/api/city/findByName/{cityName}`
    METHOD: GET
    URL EXAMPLE: http://localhost:8080/api/city/findByName/Guarulhos
    EXPECTED JSON RESPONSE: [
                               {
                                   "id": 3,
                                   "name": "Guarulhos",
                                   "province": "SP"
                               }
                           ]  


`Want to find cities by city's province?`
    
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
    
`Want to register a new City?`
        
        URL: `http://localhost:8080/api/city/insert`
        METHOD: POST
        HEADERS: {'Content-Type: application/json'}
        
        EXAMPLE INPUT JSON: {
                                    "name": "Americana",
                                    "province": "SP"
                                }
        
        EXPECTED JSON RESPONSE: {
                                    "id": 4,
                                    "name": "Americana",
                                    "province": "SP"
                                }


### CostumerDTO

`Want to see all costumers registered? `
 
    URL: `http://localhost:8080/api/costumer/all`
    METHOD: GET
    EXPECTED JSON: [
                       {
                           "id": 1,
                           "gender": "Masculino",
                           "age": 22,
                           "complete_name": "Yuri Cordeiro",
                           "birth_date": "10/12/1996",
                           "city": {
                               "id": 2,
                               "name": "Bauru",
                               "province": "SP"
                           }
                       },
                       {
                           "id": 2,
                           "gender": "Feminino",
                           "age": 24,
                           "complete_name": "Aline Murback",
                           "birth_date": "10/12/1994",
                           "city": {
                               "id": 1,
                               "name": "Americana",
                               "province": "SP"
                           }
                       },
                       {
                           "id": 3,
                           "gender": "Masculino",
                           "age": 48,
                           "complete_name": "Thomas Murback",
                           "birth_date": "11/12/1970",
                           "city": {
                               "id": 3,
                               "name": "Guarulhos",
                               "province": "SP"
                           }
                       }
                   ]
                   
`Want to find costumers by costumer's complete name?`
       
       URL: `http://localhost:8080/api/costumer/findByCompleteName/{cityName}`
       METHOD: GET
       URL EXAMPLE: http://localhost:8080/api/costumer/findByCompleteName/Yuri Cordeiro
       EXPECTED JSON RESPONSE: [
                                   {
                                       "id": 1,
                                       "gender": "Masculino",
                                       "age": 22,
                                       "complete_name": "Yuri Cordeiro",
                                       "birth_date": "10/12/1996",
                                       "city": {
                                           "id": 2,
                                           "name": "Bauru",
                                           "province": "SP"
                                       }
                                   }
                               ]
                               
                               
`Want to find costumers by costumer's part name? `
       
       URL: `http://localhost:8080/api/costumer/findByNameContaining/{costumersNamePart}`
       METHOD: GET
       URL EXAMPLE: http://localhost:8080/api/costumer/findByNameContaining/Murback
       EXPECTED JSON RESPONSE: [
                                   {
                                       "id": 2,
                                       "gender": "Feminino",
                                       "age": 24,
                                       "complete_name": "Aline Murback",
                                       "birth_date": "10/12/1994",
                                       "city": {
                                           "id": 1,
                                           "name": "Americana",
                                           "province": "SP"
                                       }
                                   },
                                   {
                                       "id": 3,
                                       "gender": "Masculino",
                                       "age": 48,
                                       "complete_name": "Thomas Murback",
                                       "birth_date": "11/12/1970",
                                       "city": {
                                           "id": 3,
                                           "name": "Guarulhos",
                                           "province": "SP"
                                       }
                                   }
                               ]
                               

`Want to find a costumer by id?`
       
       URL: `http://localhost:8080/api/costumer/findById/{costumerId}`
       METHOD: GET
       URL EXAMPLE: http://localhost:8080/api/costumer/findById/3
       EXPECTED JSON RESPONSE: {
                                   "id": 3,
                                   "gender": "Masculino",
                                   "age": 48,
                                   "complete_name": "Thomas Murback",
                                   "birth_date": "11/12/1970",
                                   "city": {
                                       "id": 3,
                                       "name": "Guarulhos",
                                       "province": "SP"
                                   }
                               }
                               
`Want to register a new Costumer?`
        
        URL: `http://localhost:8080/api/costumer/insert`
        METHOD: POST
        HEADERS: {'Content-Type: application/json'}
        
        EXAMPLE INPUT JSON: {
                               "gender": "Feminino",
                               "age": 10,
                               "complete_name": "Thaís Muzzi",
                               "birth_date": "11/12/2009",
                               "city": {
                            	   "name": "Poços de Caldas",
                            	   "province": "MG"
                               }
                            }
        
        EXPECTED JSON RESPONSE: {
                                    "id": 4,
                                    "gender": "Feminino",
                                    "age": 10,
                                    "complete_name": "Thaís Muzzi",
                                    "birth_date": "11/12/2009",
                                    "city": {
                                        "id": 4,
                                        "name": "Poços de Caldas",
                                        "province": "MG"
                                    }
                                }
                                
`Want to update a costumer? `
 
    URL: `http://localhost:8080/api/costumer/update/{costumerId}/{costumerName}`
    URL EXAMPLE: `http://localhost:8080/api/costumer/update/1/Mario`
    METHOD: PUT
    EXPECTED STATUS_CODE: 202
    EXPECTED JSON RESPONSE: {
                                "id": 1,
                                "gender": "Masculino",
                                "age": 22,
                                "complete_name": "Mario",
                                "birth_date": "10/12/1996",
                                "city": {
                                    "id": 2,
                                    "name": "Bauru",
                                    "province": "SP"
                                }
                            }
                            
                            
`Want to remove a costumer? `
 
    URL: `http://localhost:8080/api/costumer/remove/{costumerIdParam}/`
    URL EXAMPLE: `http://localhost:8080/api/costumer/remove/1`
    METHOD: DELETE
    EXPECTED STATUS_CODE: 200