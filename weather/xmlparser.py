from xml.etree import cElementTree as ElementTree

class xml_to_dict():
    '''
    A utility class for converting xml file into a json file.
    '''
    def parse(self, tree):
        '''
        Parses the file from xml to json.
        :param tree: XML tag as an ElementTree
        :return : Converted file
        '''
        xmldict = dict()
        if tree.items():
            xmldict.update(dict(tree.items()))
        for element in tree:
            if element:
                if len(element) == 1 or element[0].tag != element[1].tag:
                    tmp_dict = self.parse(element)
                xmldict.update({element.tag: tmp_dict})
            elif element.items():
                xmldict.update({element.tag: dict(element.items())})
            else:
                xmldict.update({element.tag: element.text})
        return xmldict

    
