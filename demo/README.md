=====================READ ME=============================================
Requirements:
Apache Maven : 3.6.3 and above
Java Version : 11.0.7 and above
docker-compose : 1.29.2

====================Run Docker==========================================
Use command prompt to enter into the file.
Enter command docker build --tag=ecommerce:latest . to create the base image
To run the image docker run -p8080:8080 ecommerce:latest

====================API explanation ===================================
Get Existing user account with GET HTTP request and the URI "/users/{email}"
	- This will return a HTTP success code of 200 with the success variable and the amount in the account
	- When there are no such email account within the database, the system will throw error 404 with the error message as
	  User for the given email :{email} does not exist

Create user account with POST HTTP request and the URI "/users"
	- This will return a HTTP success code of 200 with the success variable and the amount in the account
	- When there is an account with the same email that already exist within the database, the system will throw error 404 with the error message as
	 User for the given email : {email} already exist
	 
Get user transaction with GET HTTP request and the URI "/transaction/{email}"
	- This will return a HTTP success code of 200 with the success variable and list of past transaction
	- This function will take both the transaction of the account as both the sender and the receiver
	- When there are no such transaction for the specified account within the database, the system will throw error 404 with the error message as
	  Transactions for the given email :{email} does not exist

Create user transaction with POST HTTP request and the URI "/users"
	- This will return a HTTP success code of 200 with the success variable
	- The amount will then be added to the receiver and deducted from the sender
	- If the sender do not have enough balance to send to the receiver, the system will throw error 404 with the error message as
	 Transactions for the given sender email :{email} cannot be completed
	- When there is the email account for both the sender and the receiver does not exist within the database, 
	the system will throw error 404 with the error message as Transactions for the given sender email :{email} cannot be completed