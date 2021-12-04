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
  -  Register table:             
      For storing the details of the customers.
      The table contains the following columns:   
                1. Username: primary key, unique varchar(45)    
                2. Password: varchar(45)
                3. Birthday:date
                4. CellPhone:varchar(45)
                5. Email:varchar(45)
                6. address:varchar(45)
      
  -  Manager Table:
                1.ManagerName:varchar(45)
                2.ManagerPassword:varchar(45)
  -  Menu Table:
                1.FoodID:int(11),primary key
                2.FoodName:varchar(45)
                3.FoodPrice:bigint(4)
                4.Description:varchar(255)
                5.Comment:varchar(255)
                6.1Star:int(11)
                7.2Star:int(11)
                8.3Star:int(11)
                9.4Star:int(11)
                10.5Star:int(11)
   - OrderFood Table:
                1.UserName:varchar(45),primary key
                2.Orders:varchar(45)
               
      
                 

 Overview:    
 The project is a food ordering system (Desktop Window) for custumers to place online delivery orders. Customers can have a look at various restaurants' menu and order food from their desired restaurant.                  
 We are using Java gui as our frontend to create a desktop window application and connecting it to multiple databases using db connectors to ensure dynamic data flow.
     We are using MySQL for database implementation.
