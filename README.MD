#BusyFlight

mvn clean spring-boot:run

#Assumptions
- Test cases are listed up-front without actual implementations. With the provided time frame and notice given by agency I can only proceed this way.
- Providers are in memory model without implementing the actual search functions
- AspectJ is not being used in logging details but I would if provided longer notice.
- No data post processing after receiving JSON responses from each provider
- Search functions are not implemented over aggregated result.

- http://localhost:8080/provider/crazyair
{
	"origin":"IOP",
    "destination":"BJI",
    "departureDate":"2017-12-12",
    "returnDate":"2017-12-22",
	"numberOfPassengers":1	
}

- http://localhost:8080/provider/toughjet
{
	"from":"IOP",
    "to":"BJI",
    "departureDay":12,
    "departureMonth":12,
    "departureYear":2017,
    "returnDay":22,
    "returnMonth":12,
    "returnYear":2017,
	"numberOfAdults":1
}

- http://localhost:8080/search
{
	"origin":"IOP",
    "destination":"BJI",
    "departureDate":"2017-12-12",
    "returnDate":"2017-12-22",
	"numberOfPassengers":1	
}