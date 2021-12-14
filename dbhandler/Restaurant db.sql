-- create a database called Restaurant
create database Restaurant;

use Restaurant;

-- create a table called Manager which will have the manager login credentials
CREATE TABLE Manager ( ManagerName varchar(45) NOT NULL,  ManagerPassword varchar(45) NOT NULL,  PRIMARY KEY (ManagerName,ManagerPassword));

-- adding manager username and password
insert into manager values("admin","admin");

-- display the manager table
select * from Manager;

-- create a table called Menu which will have all the food items available
CREATE TABLE Menu (  FoodID int(11) NOT NULL,  FoodName varchar(45) NOT NULL,  FoodPrice bigint(4) NOT NULL,  Description varchar(255) NOT NULL,  Comment varchar(255) DEFAULT NULL,  1Star int(11) DEFAULT NULL,  2Star int(11) DEFAULT NULL,  3Star int(11) DEFAULT NULL,  4Star int(11) DEFAULT NULL,  5Star int(11) DEFAULT NULL, FoodImage varchar(100),  PRIMARY KEY (FoodID));

-- inserting the food items into the menu table
Insert into Menu values(1,"Hara Bhara Kebab", 270,"It is vegetable cutlets made with greens and vegetables","Mild in Spice",0,0,1,0,0,C:\Users\Clg\Downloads\Dbms_project\FoodList\1.jpeg);

Insert into Menu values(2,"Paneer tikka", 300,"It is tender paneer charred and cooked in the tandoori oven with a blend of spices and masala","Fast selling",0,0,1,0,0,C:\Users\Clg\Downloads\Dbms_project\FoodList\2.jpeg);

Insert into Menu values(3,"Tangdi Kebab", 400,"It is tender chicken legs charred and cooked to perfectionn with masala","Must try",0,0,0,1,0,C:\Users\Clg\Downloads\Dbms_project\FoodList\3.jpeg);

 Insert into Menu values(4,"Chicken tikka", 350,"It is tender chicken charred and cooked in the tandoori oven with a blend of spices and masala","Chef's special",0,0,0,1,0,C:\Users\Clg\Downloads\Dbms_project\FoodList\4.jpeg);

Insert into Menu values(5,"Mutton Seekh Kebab", 400,"It is tender minced mutton cooked and grilled","Super Spicy",0,0,0,0,1,C:\Users\Clg\Downloads\Dbms_project\FoodList\5.jpeg);

Insert into Menu values(6,"Garlic Naan", 50,"It is Indian Flatbread with roasted garlic","Must try combo with curries",0,0,1,0,0,C:\Users\Clg\Downloads\Dbms_project\FoodList\6.jpeg);

Insert into Menu values(7,"Butter Naan", 50,"It is Indian Flatbread with generous amounts of butter","Must try combo with curries",0,0,0,1,0,C:\Users\Clg\Downloads\Dbms_project\FoodList\7.jpeg);

Insert into Menu values(8,"Mushroom curry", 200,"Mushrooms cooked in special masala gravy","Very delicious",0,0,1,0,0,C:\Users\Clg\Downloads\Dbms_project\FoodList\8.jpeg);

Insert into Menu values(9,"Vegetable pulao", 250,"It is flavoured basmati rice cooked with masala gravy and vegetables","Vegetarian's dream platter",0,0,1,0,0,C:\Users\Clg\Downloads\Dbms_project\FoodList\9.jpeg);

Insert into Menu values(10,"Chicken Dum Biryani",300,"It is flavoured basmati rice cooked with masala gravy and tender chicken","Non Vegetarian's dream platter",0,0,3,0,0,C:\Users\Clg\Downloads\Dbms_project\FoodList\10.jpeg);

Insert into Menu values(11, "Gulab Jamoon",150,"It is luxurious spongy balls in sugar syrup ","The best in town",0,0,2,0,0,C:\Users\Clg\Downloads\Dbms_project\FoodList\11.jpeg);

Insert into Menu values(12,"Rasgulla",160,"It is white luxurious spongy balls in sugar syrup ","The bengali dream",0,0,0,1,0,C:\Users\Clg\Downloads\Dbms_project\FoodList\12.jpeg);

Insert into Menu values(13,"Kulfi",60,"It is heavy cream with indian flavours set dessert","Rich and creamy",0,0,0,1,0,C:\Users\Clg\Downloads\Dbms_project\FoodList\13.jpeg);

Insert into Menu values(14,"Palkova",100,"It is milk and heavy cream dessert","Decadent",0,0,1,0,0,C:\Users\Clg\Downloads\Dbms_project\FoodList\14.jpeg);

Insert into Menu values(15,"Falooda",180,"It is layered dessert with rose milk, sevaiya and basil seeds, cream, froth ","Marvelous",0,0,0,0,2,C:\Users\Clg\Downloads\Dbms_project\FoodList\15.jpeg);

-- create a table called OrderFood which will get updated on the user ordering 
CREATE TABLE OrderFood (UserName varchar(45),Orders varchar(255) DEFAULT NULL);

-- create a table called Register which will have the user login credentials and details 
CREATE TABLE Register(UserName varchar(45) NOT NULL,Birthday date NOT NULL,CellPhone varchar(45) NOT NULL,Email varchar(45) NOT NULL,Password varchar(45) NOT NULL,Address varchar(45) NOT NULL, Deposit int(10),Spent int(10),PRIMARY KEY (UserName));

-- inserting values into the  register table
INSERT INTO Register VALUES ('Nik','2001-12-13','9456766666','nik123@gmail.com','nik123','Flat No.45, Raj Nagar, Hyd, 500011'),('Gayu','2001-09-19','9666575346','gayu123@gmail.com','gayu123','Villa NO.17, Alwal, Hyd,500800'),('Shrey','2001-06-24','9188765544','shrey123@gmail.com','shrey123','Flat No.16, Hira Apts, KPHB, Hyd, 500049');




