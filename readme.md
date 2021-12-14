
# Food ordering System




## Description
   We designed a portal for the restaurant "Itsay Dine-IN" for customers to order
food online and make payment easier.This portal is user friendly. The manager of the 
restaurant can also use the portal at his convenience.
We used java Awt and swing packages for the frontend and mysql for the database.


## Documentation

https://github.com/Nikitha1312/DBMS_project/tree/main/Documentation

 1. Compile all the java files   
      1.Deposit page  
      2.FoodMenu page  
      3.Register page   
      4.CustomerLogin page   
      5.ManagerAccess page  
      6.ManagerLogin page  
      7.Retrieve page  
      8.Review page  
      9.StartPage   
 2.Execute the start class using "java StartPage" which will open the start page window where the user is given a choice 
 to choose from the following:  
    1. Login:   
           On choosing this option,if the user is already a registered customer then he/she will login using login credentials
           and then it will be directed to the menu page where the user can choose the food items they wish to order and pay.
           In the menu page, we have an option called deposit which will direct the user to the deposit page where the user can
           deposit a certain amount to their account. When the user clicks the "pay balance" button in the menu page,the cost of the order 
           will be deducted from deposited amount.This eases the process of ordering as the user need not to enter the bank credentials everytime
           they order.   
           If the user is a new customer they have to signup and enter their details to create their account.  
    2. Manager:   
           By selecting this option you will be directed to manager login page where manager enters his credentials. From there 
           he/she goes to "ManagerAccess page" where he/she can manage the order,delete the user and view the menu and ratings given by customers.  
    3. Surfer:   
           On choosing this button it will direct to "Retrieve Page" where user can view the dishes available on the menu and on entering the
           corresponding FoodID the details like Foodname,price and description are displayed.   
    4. Review:   
           By selecting this button it will take us to the "Review Page" where the user has enter the foodname and gives review accordingly.   

We have one database called restaurant which has four tables register, Menu, OrderFood and Manager. 
           


      
## Libraries Required
https://github.com/Nikitha1312/DBMS_project/tree/main/Requirements/lib

## Authors

1.Sai Nikitha Kommepalli   
2.Sai Shreya Veguru   
3.Gayathri Bodipudi


