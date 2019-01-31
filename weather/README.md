# XML to JSON Converter

Converts from XML file to JSON file.

## Getting Started

Clone the project.

```
git clone https://github.com/bankkeez/internship.git
```

## Prerequisites

* python 3.5 or above

## Running the program

This command runs the main file.

```
python main.py
```

The default xml file is weather.xml file. Can be change by putting the new file into the internship/weather and edit one line of code in main.py function main and enter the new xml filename.

```
def main():
    texts = open(NEW_XML_FILENAME,'r')
```