📋 Gym Membership Management System

📖 Project Description
The Gym Membership Management System is a comprehensive application designed to efficiently manage the data of gym members, trainers, and schedules. It enables gym administrators to register new members, update member information, and remove members from the system. This functionality is also extended to trainers and schedules. Built using Java, the project follows Object-Oriented Programming (OOP) principles to ensure robust and scalable code.

🚀 Key Features
Register New Members: Add new members with complete details such as name, address, phone number, and membership type.
Update Member Information: Modify existing member information, including updates to membership type and contact details.
Delete Members: Remove members from the system easily.
Read Members: Read members data from system.
(Also applies to Trainer and Schedule)

🛠️ Technologies Used
Programming Language: Java 17+
Framework: Java Swing (for GUI)
Database: MySQL (for data storage)
Tooling: Maven (for dependency management)

📥 Installation
Prerequisites
Ensure you have the following installed:

Java Development Kit (JDK) 17 or newer
Apache Maven
Installation Steps
Clone the Repository:

git clone https://github.com/username/gym-membership-system.git
cd gym-membership-system
Build the Project:

mvn clean install
Run the Application:


mvn exec:java -Dexec.mainClass="com.example.gym.MainApp"

🚀 Usage

Adding a New Member:
Open the application and select "Member".
Choose "Insert".
Fill in all the required fields with information and click "SAVE".

Editing Member Information:
Open the application and select "Member".
Choose "Update".
Enter the new information in the required fields and click "UPDATE".

Deleting a Member:
Open the application and select "Member".
Choose "Delete".
Enter the member ID and click "DELETE".

Reading the Database:
Open the application and select "Read".
View the list of members, trainers, or schedules.
