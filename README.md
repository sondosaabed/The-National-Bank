# The National Banking Management Solution for TNB

This project was created as part of DATABASE SYSTEMS course. Team work.

# Team:
Sondos Aabed<br />
Eman Khalaf<br />
Hoson Haskoor<br />

# Terms and definitions: 
TNB: The National Bank.<br />
Client: The National Bank.<br />
Manager: refers to the executive of a department.<br />
Employee: A person who is employed by the TNB.<br />
User/s:  Employees of TNB, who needs the system to manage the banking process. <br />
Customer: Client of TNB. <br />
Customer file: Includes all the customer details (attributes).Account: Clients’ of TNB account. <br />
Card: A payment card issued by TNB.<br />
DOB: Date of Birth.<br />

# Project Scope:
In this project a database system is designed for The National Bank (TNB) Ramallah, a financial institution that helps to meet financial and banking needs. It is used to manage the bank accounts data of users, create and view account details. Allow employees to make clients banking services and reach their account status.

# Project Description: 
The bank management system will be designed to manage user’s data, allow employees to control and view operations and make transactions. Saves the time of waiting in the bank rows with a high level of security and ease of the banking process with the booking of rows system.

# About The National Bank:     
Banking Process Specifications: <br />
Each Address has a City-name, Street-name and Postal-code.<br />
Each bank has a bank-name and bank-ID.<br />
Each branch has a branch-name, branch-ID, branch-phone, branch-email and branch-Address.<br />
Each department has department-name, department-ID, department-phone, and department-email.<br /> 
Each Manager has manager-ID, Manager-Name, Address, phone, DOB, Email, Gender, Password, and Salary.<br />
Each Employee has an Employee-ID, Employee-Name, Address, DOB, Phone, Gender, Email, Password and Salary.<br />
Each Customer has her/his customer file, Customer-ID, password, Customer-name, Address, Gender, DOB, and account.<br />
Each Account has an account-number, account-name, open-date and balance.<br />
Each Card has an expiration-date, limit and credit-ID.<br />
Each Current-Account has a current-check.<br />
Each Current-Check has a check-ID, status, date-issued and date-due.<br />
Each Savings-Account has a savings-type.<br />
Each Deposit-Account has a deposit-number, close-date, open-date, and interest-rate.<br />
Each Transaction has a transaction-ID, trans-type, amount and date.<br />
Each Loan has a loan-number, amount, loan-date and loan-type.<br />
Each Payment has a payment-number, payment-amount and payment-date.<br />
A bank may have many branches.<br />
A branch can only be of a one bank, and must have many departments.<br />
A department must have only one manager, and can have many employees.<br />
A manager manages only one department and many employees. <br />
An Employee can work on one department, and can serve many customers.<br /> 
A customer may have many addresses, may have many accounts, may have many cards and may request many transactions. But a customer can only borrow one loan. <br />
An account is either a current or a savings or a deposit.<br />
A transaction is requested by one customer and controlled by one Employee.<br />
A loan is given by a branch and must have many Payments.<br />
A payment is paid by only one customer, and to only one loan.<br />

# Entity-Relationship-Diagram:

![4](https://user-images.githubusercontent.com/65151701/157894387-69c12ea9-b207-4577-8a74-c19a96389ccf.jpg)

# MySQL database code:
https://github.com/sondosaabed/TNB-MySQL-

# Technology needed: 
Computer, laptop.

# Technology used: 
Hardware: Intel® Core™ i7-10510U CPU, 12GB RAM. <br />
Operating System: Microsoft Windows 10 pro.<br />
Programming language: DB: MySQL, UI: (JavaFX) Back-end: Java. <br />

# Possible Evolution: 
Booking Management System: As the clients of banks usually needs to save time of waiting in line Bank, this booking system would manage the booking and saves time. <br />

Provide more high security: At some point of the process, the project might face security issues, that’s why the project system might need more safety and security.<br />

# App screenshots:
Welcome to TNB:

![1](https://user-images.githubusercontent.com/65151701/157894486-f05dfd61-f291-48f7-b34e-b8deb4a627a4.png)

Home:

![2](https://user-images.githubusercontent.com/65151701/157894573-b828665c-abc0-4894-9bf3-22945620c9c9.png)

What's user option:

![3](https://user-images.githubusercontent.com/65151701/157894660-6df8766b-46aa-4b4f-b585-ad77d357ec6a.png)

Adding new employee:

![40](https://user-images.githubusercontent.com/65151701/157894775-85476bcc-4326-41d9-9929-2c6969e04fa4.png)

Add new Manager:

![5](https://user-images.githubusercontent.com/65151701/157894845-18f9b1b7-70c8-4478-b5e4-98b9f94bae0b.png)

Add new Customer:

![6](https://user-images.githubusercontent.com/65151701/157894925-586cd207-bd57-47ef-87de-94e2eb26f6e1.png)

Add a new Account:

![7](https://user-images.githubusercontent.com/65151701/157895017-8089e3ce-b91b-4a98-84dc-5bf11405493f.png)

Add a new Loan:

![8](https://user-images.githubusercontent.com/65151701/157895096-352f0739-3688-4654-9450-9663c8b5fccb.png)

Add a new Payment: 
When a user adds a new payment for their loan this transaction updates the amount of their loan

![9](https://user-images.githubusercontent.com/65151701/157895255-58803567-631d-43ad-b3c5-4e18dc319450.png)

Add a new card:

![10](https://user-images.githubusercontent.com/65151701/157895551-c0ae1cd5-11c6-4934-a29b-692870f1dd15.png)

Make a new transaction:
When a user makes a new transaction their accoun't amount changes base on the transaction type (withdraw "-" or deposit "+") 
![11](https://user-images.githubusercontent.com/65151701/157895652-25e61948-a348-437f-ad8d-0030f670f0d2.png)

Successfully inserted:

![12](https://user-images.githubusercontent.com/65151701/157895982-2bc2aa96-1e38-4a36-ac06-d90464658f7c.png)


![13](https://user-images.githubusercontent.com/65151701/157896095-fa5d3569-c995-4242-8952-201baa6f29f9.png)


![14](https://user-images.githubusercontent.com/65151701/157896106-c2f2045c-5d85-47a7-b5fa-58767d928dcb.png)


![15](https://user-images.githubusercontent.com/65151701/157896111-d7edd199-aa69-4b80-a594-afe5d1bafc72.png)


![16](https://user-images.githubusercontent.com/65151701/157896125-f19d37a0-da88-4f7d-97f4-9c7fc985e3ab.png)


![17](https://user-images.githubusercontent.com/65151701/157896313-002ce90f-fec8-4725-882f-9057b6eeaf12.png)

![18](https://user-images.githubusercontent.com/65151701/157896321-a8760d44-9eef-42b3-9194-ce012c6338e2.png)

![19](https://user-images.githubusercontent.com/65151701/157896333-7d971277-1937-4db7-8389-aac595caa104.png)

![20](https://user-images.githubusercontent.com/65151701/157896340-f88da163-8383-4f21-9d80-d56fe93254b1.png)

![21](https://user-images.githubusercontent.com/65151701/157896449-2aad2eba-b094-4555-94a8-0842637d4b56.png)

![22](https://user-images.githubusercontent.com/65151701/157896460-0747df45-f03e-4a62-bd4a-0fc837011fc8.png)

![23](https://user-images.githubusercontent.com/65151701/157896474-a743314b-76ef-4ed8-9552-8865c2afb22f.png)

![24](https://user-images.githubusercontent.com/65151701/157896480-d52e064e-a6cb-4735-ba47-46d9c1bfef11.png)

![25](https://user-images.githubusercontent.com/65151701/157896488-01756f39-ce4a-428e-b853-4e6f82f5ae13.png)

![26](https://user-images.githubusercontent.com/65151701/157896499-41eb84fe-d249-40df-8cf5-239a8f63d6dc.png)

![27](https://user-images.githubusercontent.com/65151701/157896513-2531b87a-4038-478d-9bd0-5b229da09ed8.png)

![28](https://user-images.githubusercontent.com/65151701/157896546-5ff79f12-f140-40e2-bbcb-3cdcdbf781db.png)

![29](https://user-images.githubusercontent.com/65151701/157896561-8d442027-d03a-42d2-a67c-833a96971e75.png)

![30](https://user-images.githubusercontent.com/65151701/157896565-5d9f3e6b-5b23-43d1-a004-a3ae313a32d1.png)

![31](https://user-images.githubusercontent.com/65151701/157896569-1c87e042-5ab7-4d86-8c8a-29db1493dfed.png)

![32](https://user-images.githubusercontent.com/65151701/157896589-803dba22-b2d4-47dc-b8d4-36286534db95.png)

![33](https://user-images.githubusercontent.com/65151701/157896591-22efe4bd-006f-4b67-8944-5e0008d8ee9c.png)

![34](https://user-images.githubusercontent.com/65151701/157896621-949f5275-23fd-4be9-9d20-827cd7078e75.png)

![36](https://user-images.githubusercontent.com/65151701/157896641-0af7d936-dc2e-47ba-8daf-b1a138a3c795.png)

![37](https://user-images.githubusercontent.com/65151701/157896712-ee859e8f-f235-4e2d-bfe4-61b6efb11ec3.png)

![38](https://user-images.githubusercontent.com/65151701/157896725-e4236ec3-0529-4340-bdfd-9288d69ba7b5.png)

![39](https://user-images.githubusercontent.com/65151701/157896738-344e762c-48d9-4e93-8ce3-4b7b172c16c5.png)
