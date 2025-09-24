# Rick & Morty Android App

A modern Android application showcasing Rick and Morty characters and episodes using the Rick and Morty API, built with 100% Kotlin and following clean architecture principles.

## 🌟 Overview

This project is a learning-focused Android application that demonstrates modern Android development practices, architectural patterns, and best practices in Kotlin. It uses the [Rick and Morty API](https://rickandmortyapi.com/) to display information about characters and episodes from the show.

## 🛠 Tech Stack & Architecture

### Architecture
- **Clean Architecture** with 3 layers:
  - Data Layer (Repository pattern)
  - Domain Layer (Use Cases)
  - Presentation Layer (MVVM)

### Technologies & Libraries
- **100% Kotlin** based
- **Coroutines** for asynchronous operations
- **Flow** for reactive programming
- **Jetpack Components**:
  - ViewModel
  - Navigation Component
  - DataBinding/ViewBinding
  - Room Database (for offline caching)
  - Lifecycle Components
- **Dependency Injection** with Hilt
- **Retrofit2** for REST API integration
- **Coil** for image loading
- **Material Design** components

## 🎯 Features

- Browse Rick and Morty characters
- View detailed character information
- Search functionality
- Episode listings
- Offline support
- Dark/Light theme support

## 📱 Screenshots

[Screenshots to be added]

## 🚀 Getting Started

### Prerequisites
- Android Studio Arctic Fox or later
- Minimum SDK 21
- Target SDK 33+
- JDK 11

### Installation
1. Clone the repository:
```bash
git clone https://github.com/rimshadpcs/rick-morty.git
```

2. Open in Android Studio

3. Sync project with Gradle files

4. Run on an emulator or physical device

## 🏗 Project Structure

```
app/
├── data/
│   ├── remote/
│   ├── local/
│   └── repository/
├── domain/
│   ├── model/
│   ├── repository/
│   └── usecase/
├── presentation/
│   ├── ui/
│   ├── viewmodel/
│   └── adapter/
└── di/
```

## 🧪 Testing

The project includes:
- Unit Tests
- Integration Tests
- UI Tests using Espresso

## 🤝 Contributing

Contributions are welcome! Please feel free to submit a Pull Request.

1. Fork the Project
2. Create your Feature Branch (`git checkout -b feature/AmazingFeature`)
3. Commit your Changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the Branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

## 📝 License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## 📬 Contact

Mohamed Rimshad - [@rimshadpcs](https://github.com/rimshadpcs)

Project Link: [https://github.com/rimshadpcs/rick-morty](https://github.com/rimshadpcs/rick-morty)

## 🙏 Acknowledgments

- [Rick and Morty API](https://rickandmortyapi.com/)
- All the awesome libraries and tools used in this project
