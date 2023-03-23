# Recommendation Service

This project is a recommendation service for cryptocurrencies. It provides several endpoints that allow users to get information on different aspects of cryptocurrencies, such as prices, trends, and rankings.

## Requirements

The recommendation service has the following requirements:

Read all the prices from the csv files.

Calculate the oldest/newest/min/max for each crypto for the whole month.

Expose an endpoint that will return a descending sorted list of all the cryptos, comparing the normalized range (i.e. (max-min)/min).

Expose an endpoint that will return the oldest/newest/min/max values for a requested crypto.

Expose an endpoint that will return the crypto with the highest normalized range for a specific day

## Installation

To install the recommendation service, follow these steps:

Clone this repository.

Start the service by running this command
```bash
./mvnw spring-boot:run
```

## Usage

The recommendation service provides the following endpoints:

GET /api/v1/cryptocurrencies: Returns a descending sorted list of all the cryptos, comparing the normalized range (i.e. (max-min)/min).

GET /api/v1/cryptocurrencies/{crypto}: Returns the oldest/newest/min/max values for a requested crypto.

GET /api/v1/cryptocurrencies/byday?date={date}: Returns the crypto with the highest normalized range for a specific day.

For further information use the [swagger api](http://localhost:8080/swagger-ui/index.html) to overview service.

## Contributing

Pull requests are welcome. For major changes, please open an issue first
to discuss what you would like to change.

## License

[MIT](https://choosealicense.com/licenses/mit/)