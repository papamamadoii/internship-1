from xml.etree import cElementTree as ElementTree
from xmlparser import xml_to_dict
import json

def main():
    texts = open('weather.xml','r')
    tree = ElementTree.parse(texts)
    root = tree.getroot()
    xmldict = xml_to_dict().parse(root)
    weather_json = open('weather.json','a')
    weather_json.write(json.dumps(xmldict))

if __name__ == '__main__':
    main()