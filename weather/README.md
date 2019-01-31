# XML to JSON Converter

Converts from XML file to JSON file.

## Getting Started

Clone the project.

```
git clone https://github.com/bankkeez/internship.git
```

## Prerequisites

* python 3.5 or above

## Installing

After finish cloning, go into the weather folder.

```
cd internship/weather
```

Install requirements. (If you have only one version of python on yor machine then you can simply enter this command.)

```
pip install requirements.txt
```

In case for python 2.0 above and 3.0 above, use this command.

```
pip3 install requirements.txt
```

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