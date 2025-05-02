# Feature List

## [ Domain ]
### 1. Station
 - Description:
    A class containing information and methods for one station.
    = Represents a single subway station with its name.
 - Role:
    Provides comparison or matching methods for route calculations
    = Can be compared by its name.
 - Components:
   `name` (stationName)

### 2. Line
 - Description:
    A class containing information and methods for one subway line.
    = Represents a subway line, contains and manages a sequence of stations.
 - Role:
   Save the ordered list of stations belonging to the given subway line.
    = Provides methods to add stations and retrieve the current list of stations.
 - Components
    name(lineName)
    stations(list of station in order)

### 3. StationRepository
 - Description:
    A class containing information and methods for the entire subway station.
    = Manages and stores all stations.
 - Role: 5 Methods
    Show, add, delete, deleteAll, Search(findByName) stations.

### 4. LineRepository
 - Description:
    A class containing information and methods for all subway lines.
    = Manages and stores all subway lines.
 - Role: 5 Methods
   Show, add, delete, deleteAll, Search(findByName) lines.

## [ Service ]
### 1. SearchRoute // Calculate only
 - Calculate `shortest path` between stations based on distance.
 - Calculate `minimum travel time` between stations.

### 2. ResultRoute // Store only
 - Store calculatedPath, totalDistance, totalTime.
 - Return results to the `Controller`. 

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