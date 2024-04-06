# inventory-management-system

inventory management system for managing the inventory from distributors , suppliers ,orders and items with APIs for controlling all the entities and the relations

invintory mangment system to mange our inventory contain 4 core intities with add APIs to mange it from add, update, delete, retrive and APIs for relations:

  Item: 
        Represents an item in the inventory.
          Attributes:
              id: Unique identifier for the item.
              name: Name of the item.
              quantity: Quantity of the item available in the inventory.
              price: Price of the item.
          Relationships:
              Many-to-Many with Order: An item can be included in multiple orders.
              Many-to-One with SupplyingCompany: Each item is supplied by a single supplying company.
              
Distributors : 
      Represents a distributor.
          Attributes:
              id: Unique identifier for the distributor.
              name: Name of the distributor.
              address: Address of the distributor.
              phone: Phone number of the distributor.
              email: Email address of the distributor.
          Relationships:
              One-to-Many with Order: A distributor can have multiple orders.

      
Order :
      Represents an order placed by a distributor.
        Attributes:
              id: Unique identifier for the order.
              status: Current status of the order (Pending, Shipped, Delivered).
              date: Date when the order was placed.
        Relationships:
              Many-to-Many with Item: An order can contain multiple items.
              Many-to-One with Distributors: Each order is placed by a single distributor.

OrderStatus:
        Enum representing the status of an order (Pending, Shipped, Delivered).

SupplyingCompany:
        Represents a company that supplies items.
          Attributes:
              id: Unique identifier for the supplying company.
              companyName: Name of the supplying company.
              phoneNumber: Phone number of the supplying company.
              location: Location of the supplying company.
              

![image](https://github.com/Gudogan1202929/inventory-management-system/assets/106726780/57b2c73c-9115-4c8c-a5d8-11c17d48a10e)

My Swagger 3.1.0 and my designed APIs :

https://app.swaggerhub.com/apis/MOHAMMADNMOSLEH123/inventory-manegment_system_open_api_3_0/1.0.12#/SupplyingCompany/updateSupplyingCompany

Table for clarify every API on the system and every thing about it :

https://docs.google.com/document/d/12HoYUR2xIl385S2lZjXxbPg81MvmU96Xt4jWaHD5JY4/edit?usp=sharing[REST API basics- CRUD, test & variable.postman_collection.json](https://github.com/Gudogan1202929/inventory-management-

My Collection postman (all my APIs) :

system/files/14894268/REST.API.basics-.CRUD.test.variable.postman_collection.json)
