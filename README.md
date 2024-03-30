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
              email: Email address of the supplying company.
          Relationships:
              One-to-Many with Item: A supplying company can provide multiple items.

              

![image](https://github.com/Gudogan1202929/inventory-management-system/assets/106726780/57b2c73c-9115-4c8c-a5d8-11c17d48a10e)

![image2](https://github.com/Gudogan1202929/inventory-management-system/assets/106726780/7070ee21-c4d6-449d-94a7-29e70157fec3)

![image3](https://github.com/Gudogan1202929/inventory-management-system/assets/106726780/fa7950d6-3897-467a-9f2c-2905d2104015)

![1](https://github.com/Gudogan1202929/inventory-management-system/assets/106726780/3d3a8c96-b7db-459c-b950-b35400f8026a)

![2](https://github.com/Gudogan1202929/inventory-management-system/assets/106726780/50b60ff1-906c-40f3-b802-95f1aca4e12c)

![3](https://github.com/Gudogan1202929/inventory-management-system/assets/106726780/37ca1958-af9f-49f3-afae-66ef51f2fb42)

![4](https://github.com/Gudogan1202929/inventory-management-system/assets/106726780/b77eb4f5-2d8f-400b-aba9-cc8458debb5b)

![5](https://github.com/Gudogan1202929/inventory-management-system/assets/106726780/c6c4f76e-981b-4911-a431-755b9627bc9b)

![6](https://github.com/Gudogan1202929/inventory-management-system/assets/106726780/c593bf68-06f0-4bed-b8ef-86a93e8b447d)

![7](https://github.com/Gudogan1202929/inventory-management-system/assets/106726780/379cfdee-3816-43c4-97c5-437e02e0a503)



[REST API basics- CRUD, test & variable.postman_collection.json](https://github.com/Gudogan1202929/inventory-management-system/files/14809096/REST.API.basics-.CRUD.test.variable.postman_collection.json)
