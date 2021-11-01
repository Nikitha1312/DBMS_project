Frontend:
  - Login page:    
        In this page the user can login into their account if they are existing customer or sign up if new customer.
  - Catalogue page:       
        This page lists out all the available restaurants from which the user can choose. It also has options that can filter out restaurants based on preferences like veg, non-veg or city.
  - Menu pages for each restaurant:         
        On choosing a particular restaurant to order from the user can choose the desired items from the menu.
  - A local array to store the selected items from the menu and displaying the bill:        
        This array will store the selected items, acts like a cart and the bill is displayed towards the end.
  - Connecting these pages to various databases using db connectors

Backend: 

  - It is open for third party vendors to add additional features.
 
Database:
  - Login database:             
      It is a separate database with 'login' table for storing the login credentials details of the customers.
      The table contains the following columns:   
                1. username: primary key, unique varchar(10)    
                2. pwd: varchar
      
  - Catalogue database:           
      It has the following tables:           
                   'Restaurants' table which has the details of various available restuarants that one can order from, with the following columns:     
                                        1. restaurant_id: int,primary key, unique, not null     
                                        2. restaurant_name: varchar(20), unique, not null          
                                        3. veg/non-veg: char(1),not null      
                                        4. city: varchar(20)    
                                        5. image (link to the image)            
                   Menu tables for each restaurant named restaurant_id_menu with the following columns in each menu table:         
                                        1. item_id: int,primary key,unique, not null       
                                        2. item_name: varchar(20)        
                                        3. veg/non-veg: char(1)      
                                        4. price: int     
                                        5. image (link to the image)          
                                        
  - Order database    
          It contains all the orders received so the any particular restaurant can filter out the orders that their restaurant received.
          It has a table 'Orders' with the following columns:                 
                  1. item_name: varchar(20)        
                  2. restaurant_name: varchar(20)            
                  3. price: int         
                  4. no_of_servings: int          
                  5. username: varchar(20)            
     
   - Profile database
 

 Overview:    
 The project is a food ordering system (Desktop Window) for custumers to place online delivery orders. Customers can have a look at various restaurants' menu and order food from their desired restaurant.                  
 We are using Java gui as our frontend to create a desktop window application and connecting it to multiple databases using db connectors to ensure dynamic data flow.
     We are using MySQL for database implementation.
