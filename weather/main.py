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
    

    
# how about xml_to_dict() => convert_xml_to_dictionary

# weather_json = open('weather.json', 'a')
# notice a space between 'weather.json', 'a'
# readability FTW!

# what will happen at the end of main()?

# Is it easy for users if they just want to use different files not just weather.xml?
# They are not programmers, what should we do to make it easier for them?

# a good Python style guide
# https://github.com/google/styleguide/blob/gh-pages/pyguide.md

# :)
