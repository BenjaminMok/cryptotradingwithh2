Testing Application - Crypto Trading Platform with H2 database
Using spring boot and h2 database for this project.

Prepopulated data
The following data will be prepopulated into the H2 database.
3 tables will be created 
1.	Customer
  a.	Contains all the customer details
2.	Crypto
  a.	Contains all the crypto pair details
3.	Transactions
  a.	Store all the transactions that the customer made


Customer: 2 customers with 50,000.00 account balance

Crypto: 2 crypto pairs - ETHUSDT & BTCUSDT*

*prices will be updated in the code. 

Transaction:
Fields:
1.	ID
2.	CustomerID
3.	Customer name 
4.	Price
5.	Quantity
6.	Total amount (Price*Quantity)
7.	Crypto pair
8.	Transaction type (BUY/SELL)
9.	Status (OPEN/CLOSED)
10.	Timestamp

APIs: 
The list of APIs details are stated below. Where the URL is the link to connect to the API, param is the parameters required for the retrieve specific data and an example of a working URL is provided. A screenshot will be provided to show sample output. 

1. Get best aggregated bid and ask price for all symbols (ETHUSDT & BTCUSDT) -- GET
URL: http://localhost:8080/api/v1/ticker

2. Get best aggregated bid and ask price for specific symbol -- GET
URL: http://localhost:8080/api/v1/ticker/prices
Param: symbol=BTCUSDT/ETHUSDT
Example: http://localhost:8080/api/v1/ticker/prices?symbol=BTCUSDT
 
3. Get the list of customers -- GET
URL: http://localhost:8080/api/v1/users

4. Get the details of specific customer  -- GET
URL: http://localhost:8080/api/v1/customers/name
Param: custName=David
Example: http://localhost:8080/api/v1/customers/name?custName=David
 
5. Get all wallet details -- GET
URL: http://localhost:8080/api/v1/wallets

6. Get wallet details for specific customer -- GET
URL: http://localhost:8080/api/v1/wallets/name
Param: custName=David
Example: http://localhost:8080/api/v1/wallets/name?custName=David 

7. Get all transactions -- GET
URL: http://localhost:8080/api/v1/transcations
 
8. Get transactions perform by specific customer -- GET
URL: http://localhost:8080/api/v1/transactions/history
Param: customer=David
Example: http://localhost:8080/api/v1/transactions/history?customer=David
 
9. Perform a trade -- POST
URL: http://localhost:8080/api/v1/openTrade 
Params: customerName=David & cryptoPair=BTCUSDT & quantity=0.4 & action=BUY
Example: http://localhost:8080/api/v1/openTrade?customerName=David&cryptoPair=BTCUSDT&quantity=0.4&action=BUY 

10. Close the trade
URL: http://localhost:8080/api/v1/closeTrade
Param: customerName=David & Id = 1 (Transaction ID)
Example: http://localhost:8080/api/v1/closeTrade?Id=1&customerName=David
 

