# Multithreaded Dictionary Application

A Java-based dictionary app that leverages **multithreading** and **SQLite** for real-time word lookups. Built with **JavaFX**, this application demonstrates efficient data handling, asynchronous processing, and responsive user experience.

## Project Overview

This dictionary application showcases a real-world implementation of **multithreading** in Java by creating a responsive and high-performing word search feature. When a user types a term, the application quickly searches through the database, using a separate thread pool to handle search queries and display results without freezing the UI. This design ensures a smooth user experience and is ideal for learning about parallel processing, data handling, and JavaFX.

## Features

- **Fast, Real-Time Search**: Users get immediate results as they type, thanks to a multithreaded search engine
- **SQLite Database Integration**: Word definitions and data are stored and retrieved from an SQLite database
- **Responsive User Interface**: Built with JavaFX, the app offers a clean, easy-to-navigate UI
- **Multithreading with Callable**: Each search query is handled by a new thread, ensuring the main application remains responsive

## Technologies Used

- **JavaFX**: For creating a smooth and visually appealing user interface
- **SQLite**: A lightweight database to store and retrieve dictionary data
- **Multithreading in Java**: To process search queries in parallel
- **Maven**: Project management and dependency management

## Architecture

The dictionary app is structured around three main components:

1. **Database Module**: Connects to the SQLite database, handles queries, and manages connection pooling
2. **Multithreaded Search Engine**: Uses `ExecutorService` and `Callable` to create a thread pool that processes user queries independently
3. **JavaFX UI**: Displays the dictionary entries and interacts with the search engine

### Key Modules

- **DatabaseHandler**: Manages the SQLite connection and performs word lookups
- **SearchTask**: A `Callable` that runs in a thread pool, handling each search request asynchronously
- **Main Application (HelloApplication)**: Initializes the JavaFX UI and connects the components

## Getting Started

### Prerequisites

- **Java Development Kit (JDK)** 17 or above
- **Maven** for dependency management
- Basic knowledge of Java multithreading and JavaFX

### Installation

1. **Clone the Repository**
```bash
git clone https://github.com/yourusername/MultithreadedDictionaryApp.git
cd MultithreadedDictionaryApp
```

2. **Build the Project**
```bash
mvn clean install
```

3. **Run the Application**
```bash
mvn javafx:run
```

## Usage

1. Launch the application
2. In the search bar, type any word you want to look up
3. The dictionary will display matching results as you type, with definitions retrieved in real time

### Example Queries

- **Single-word search**: Type "apple" to see its definition
- **Partial-word search**: Type "app" to see suggestions like "apple," "application," etc.

## Future Improvements

Here are a few ideas for enhancing the functionality of this project:

- **Advanced Search Algorithms**: Improve the search function with fuzzy matching or ranking by relevance
- **Synonym and Antonym Display**: Show related words along with definitions
- **Speech Synthesis**: Add audio pronunciation for each word
- **History and Favorites**: Let users save favorite words and view search history
- **API Integration**: Fetch data from an online dictionary API for an even larger word base

## Contributions

Contributions are welcome! Feel free to submit a pull request or open an issue if you have ideas or bug fixes.

## License

This project is licensed under the MIT License.