# BetApp
Reactive bet application

## Requirements
JRE 8+
Maven 3+

## Compile
Using maven: `mvn clean install`

## Run
As a jar: `java -jar target/bet-app-0.0.1-SNAPSHOT.war`

Then go to: http://localhost:8080/

## Functionality
### Basic
Displaying real-time bet options to user, with option to place actual bet (actuality validation).
Generation of bet option odds is random.

### Reports
#### Overall count of bets placed by user with ip
GET `/reports/bets/ip/{ipAddress}/count`

#### Get all bets with Win odd for match Germany - Italy
GET `/reports/bets`

    data:
      name: 'Germany - Italy'
      odd: 'Win'

#### Delete loan by timestamp
DELETE `/reports/timestamp/{timestamp}`

## Example of json from get second example
