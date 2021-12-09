Frontend:

   -Start Page: 
        This page has the following options:
        1.Registered Customer : which will take user to the Customer Login Page, where existing can login into their account and new customers can sign up.  
        2.Manager : which will take user to manager login page , where manager can login and access the manager access page.    
        3.Surfer : which will take user to the Retrieve page and will allow user to view the food items. 
        4.Review : which will allow the customer give their review on the food items.  
  - Menu page:         
        The user can choose the desired items from the menu and final cost is displayed at the rightmost corner and at the bottom of the page the ordered items along with
        quantity is displayed.
  - Deposit page:
        This page is the payment page.     
 
  - Connecting these pages to Restaurant database using db connectors.

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
