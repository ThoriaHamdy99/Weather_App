package com.example.weather_app.domain.exceptions

class NoLocationFoundException : Exception("No Location found")
class NoWeatherFoundException : Exception("No weather found")
class InvalidInput : Exception("Invalid input")