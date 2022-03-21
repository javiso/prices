# prices - Instructions

APIS:
In this section, you will find instructions of how to send the request as well as the possible responses obtained. 
Note: The data will be stored in H2 database. These are loaded during the run process of the app. 
The server runs in localhost:8080.

Database credentials:
  - jdbc url: jdbc:h2:mem:mydb
  - username: sa
  - password: password

PRICE'S ENPOINTS

- Get: v1/price
- Inputs: Query params
- Parameters: application_date: date to search price. (Format: yyyy-mm-dd hh:mm:ss)
- product_id: product's id.
- brand_id: brand's id. 

Description: It fetches the price according to application_date, product, brand and priority(if applicable).

Example: Get v1/price

application_date: 2020-06-14 16:00:00

product_id: 35455

brand_id: 1

Result: 

    "startDate": "2020-06-14 15:00:00",
    "endDate": "2020-06-14 18:30:00",
    "productId": 35455,
    "price": 25.45
    "brandId": 1  
