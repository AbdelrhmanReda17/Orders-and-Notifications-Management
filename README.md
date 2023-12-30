# Orders and Notifications Management
This repository contains the backend logic for managing orders and notifications. The system is developed using Spring Boot and implements various design patterns for flexibility, extensibility, and efficient order processing.
## Features
- **Order Management:**
  - Supports simple and compound orders.
  - Validates product availability, user funds, and order consistency.
  - Processes order placement, cancellation, and shipment.

- **Notification Management:**
  - Generates notifications for different order states.
  - Associates notifications with user accounts.
## Patterns
- Command Pattern:
    - The system adopts the Command pattern to enhance flexibility and extensibility in order processing. This allows for easy addition of new functionalities without modifying existing code.
-  Composite Pattern:
    - The system adopts the Composite pattern. This allows us to handle compound orders. These orders can encapsulate multiple individual orders and are managed cohesively.
- Strategy Pattern:
    - Utilized in various packages for different strategies, enhancing the modularity of the code.
- Factory Pattern:
    - Employed in multiple packages, the Factory pattern provides a flexible way to create objects based on different conditions, promoting a clean and maintainable codebase.

## API Structure
The project is organized into several APIs, each with its own set of responsibilities:
- **Orders API**: This API manages all operations related to orders.
  - `Model`: Contains data models related to orders, including `IOrder`, `SimpleOrder`, `CompoundOrder`, `OrderState`, and `ShoppingCartItem`.
  - `Controller`: Contains the `OrderController` class which handles HTTP requests related to orders.
  - `Service`: Contains the `OrderService` class which contains the business logic for managing orders.
  - `Repository`: Contains the `OrderRepository` class which interacts with the database.

- **Products API**: This API manages all operations related to products.
  - `Model`: Contains the `Product` class which represents a product in the system.
  - `Controller`: Contains the `ProductController` class which handles HTTP requests related to products.
  - `Service`: Contains the `ProductService` class which contains the business logic for managing products.
  - `Repository`: Contains the `ProductRepository` class which interacts with the database.

- **Users API**: This API manages all operations related to users.
  - `Model`: Contains classes like `User`, `UserCredentials`, and `IPayment` which represent the users and their payment methods in the system.
  - `Controller`: Contains the `UserController` class which handles HTTP requests related to users.
  - `Service`: Contains the `UserService` class which contains the business logic for managing users.
  - `Repository`: Contains the `UserRepository` class which interacts with the database.

- **Notifications API**: This API manages all operations related to notifications.
  - `Model`: Contains classes like `Notification` and `NotificationFactory` which represent the notifications in the system.
  - `Controller`: Contains the `NotificationsController` class which handles HTTP requests related to notifications.
  - `Service`: Contains the `NotificationsService` class which contains the business logic for managing notifications.
  - `Repository`: Contains the `NotificationsRepository` class which interacts with the database.

Each of these APIs works together to provide a comprehensive solution for managing orders, products, users, and notifications in the system.

## Project Structure
The project is organized into several packages, each with its own set of responsibilities:
- **Application**: This is the main package that contains the application's entry point.
  - `Application.java`: This is the main class that starts the Spring Boot application.

- **Application.Managers**: This package contains various managers that handle different functionalities of the application.
  - `ApplicationManager.java`: This class manages the main operations of the application.
  - `OrderManager`: This package contains classes that manage order operations.
    - `OrderManager.java`: This is an abstract class that defines the operations related to orders.
    - `SimpleOrderManager.java`: This class extends `OrderManager` and implements the operations for simple orders.
    - `CompoundOrderManager.java`: This class extends `OrderManager` and implements the operations for compound orders.
  - `ProductManager`: This package contains the `ProductManager.java` class that manages product operations.
  - `UserManager`: This package contains the `UserManager.java` class that manages user operations.
  - `NotificationManager`: This package contains the `NotificationManager.java` class that manages notifications.

- **Application.Utilities**: This package contains several utility classes and packages that provide various functionalities used across the application.
  - **Database**: This package contains classes related to database operations.
    - `DataRepository.java`: This class provides basic CRUD operations.
    - `DatabaseFactory.java`: This class is used for creating and managing repositories.
  - **Deserializers**: This package contains classes for deserializing JSON data.
    - `IOrderDeserializer.java`: This is an abstract class that defines the operations for deserializing order data.
    - `OrderDeserializer.java`: This class extends `IOrderDeserializer` and implements the operations for deserializing order data.
    - `SimpleOrderDeserializer.java`: This class extends `IOrderDeserializer` and implements the operations for deserializing simple order data.
    - `CompoundOrderDeserializer.java`: This class extends `IOrderDeserializer` and implements the operations for deserializing compound order data.
  - **Serializers**: This package contains the `ShoppingCartItemSerializer.java` class which is used for serializing shopping cart item data.
  - **Template**: This package contains classes for creating templates.
    - `ITemplate.java`: This interface defines the structure of a template.
    - `TemplateFactory.java`: This class is used for creating templates.
    - `EmailTemplate`: This package contains specific implementations of templates for emails.
      - `EmailTemplate.java`: This is an abstract class that defines the operations for email templates.
      - `EmailTemplateFactory.java`: This class is used for creating email templates.
      - `Languages`: This package contains classes for different language templates.
        - `EmailTemplateEN.java`: This class extends `EmailTemplate` and implements the operations for English email templates.
        - `EmailTemplateAR.java`: This class extends `EmailTemplate` and implements the operations for Arabic email templates.
    - `PhoneTemplate`: This package contains specific implementations of templates for phone messages.
      - `PhoneTemplate.java`: This is an abstract class that defines the operations for phone templates.
      - `PhoneTemplateFactory.java`: This class is used for creating phone templates.
      - `Languages`: This package contains classes for different language templates.
        - `PhoneTemplateEN.java`: This class extends `PhoneTemplate` and implements the operations for English phone templates.
        - `PhoneTemplateAR.java`: This class extends `PhoneTemplate` and implements the operations for Arabic phone templates.

## How to Run
1. Clone the repository to your local machine using `git clone https://github.com/AbdelrhmanReda17/Orders-and-Notifications-Management/`.
2. Navigate to the project directory using `cd Orders-and-Notifications-Managementm`.
3. Run the application by executing the `Application` class.

## License
This project is licensed under the MIT License.
