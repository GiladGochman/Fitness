# Workout

Craft workout plans suited just for you. This software allows you to randomize exercises from the 'exercise bank' and build yourself a plan such as AB, ABC, ABCD or Full Body.

## How to Run (Users)

### Prerequisites

- Java Runtime Environment (JRE) 8 or higher installed on your system

### Running the Application

1. Locate the `workout.jar` file in the project directory
2. Double-click the `.jar` file, or run from command line:
   ```
   java -jar workout.jar
   ```
3. The application window will launch - start building your custom workout plan!

## How to Compile (Developers)

### Prerequisites

- Java Development Kit (JDK) 8 or higher
- All `.java` source files in the project directory

### Compilation Steps

1. Open a terminal/command prompt in the project directory
2. Compile all Java files:
   ```
   javac *.java
   ```
3. Create a JAR file (optional):
   ```
   jar cfe Fitness.jar MainFrame *.class
   ```
4. The compiled `.class` files will be generated in the same directory

### Project Files

- `MainFrame.java` - Main application entry point
- `workout.java` - Workout plan functionality
- `ABFrame.java`, `ABCFrame.java`, `AddFrame.java` - UI frames for different workout types
- `DeleteFrame.java` - Deletion functionality
- `ManualFrame.java` - Manual workout entry
- `Data.java` - Data management
