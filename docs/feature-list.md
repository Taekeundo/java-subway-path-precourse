# Feature List

## [ Domain ]
### 1. Station
 - Description:
    A class containing information and methods for one station.
 - Role:
    Provides comparison or matching methods for route calculations   
 - Components:
    stationName
    stationIdentity?

### 2. Line
 - A class containing information and methods for one subway line.

### 3. StationRepository
 - A class containing information and methods for the entire subway station.

### 4. LineRepository
 - A class containing information and methods for all subway lines.

## [ Service ]
### 1. SearchRoute
 - Calculate `shortest path` between stations based on distance.
 - Calculate `minimum travel time` between stations.

## [ Controller ]
 - Receives userInput via View and validates.
 - Delegates searchRouth to the `service`.
 - Receives results from `service` and forwards them to `View`.
 - It only serves to control the flow.

## [ View: Input ] Getting inputs from the prompt (= User)

### I-1. Select the desired option1
- 1. Search route
- Q. Quit

### I-2. Select the desired option2
- 1. Shortest distance
- 2. Minimum time
- 3. Back to previous option

### I-3. Enter the departure station
- From 'StationRepository' object

### I-4. Enter the Destination station
- From 'StationRepository' object

## [ View: Output ] Prints the appropriate result to the prompt.
### Q-1 ~ Q-8
- Print simple given messages (Check README.md)

### Q9
- Print [ERROR] messages for invalid input.