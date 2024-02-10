# Sales Forecast Service

## Table of Contents

- [Getting Started](#getting-started)
- [Endpoints](#endpoints)
- [Prerequisites](#prerequisites)
- [Installation](#installation)
- [Testing](#testing)

## Getting Started

Clone this repository.
Once the application is running, you can use the provided REST API to interact with sales forecasts and weather forecasts.

## Endpoints

### Get Sales Forecast for Date Range

- **GET /api/sales/{location}/forecast**
    - Get sales forecasts for a specific location and date range.
    - Parameters:
        - `{location}`: The location for which forecasts are requested.
        - `startDate`: The start date of the date range (format: yyyy-MM-dd).
        - `endDate`: The end date of the date range (format: yyyy-MM-dd).

### Compare Sales Forecasts with Weather Forecasts

- **GET /api/sales/{location}/compare-forecasts**
    - Compare sales forecasts with weather forecasts for a specific location and date range.
    - Parameters:
        - `{location}`: The location for which forecasts are compared.
        - `startDate`: The start date of the date range (format: yyyy-MM-dd).
        - `endDate`: The end date of the date range (format: yyyy-MM-dd).

## Prerequisites

- Java 17 or higher
- Maven for building the project
- An IDE of your choice (e.g., IntelliJ IDEA, Eclipse)
- External Weather API key (specified in application properties)

## Installation

1. Clone the repository to your local machine.
2. Build the project using Maven:
3. Run the application:

## Testing

To run the unit tests, execute the following command:
mvn test
