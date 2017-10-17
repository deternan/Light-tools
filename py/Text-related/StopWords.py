# coding=utf8

'''
 version: October 16, 2017 10:51 PM
 Last revision: October 16, 2017 10:51 PM

@author: user
'''

# file related
folder = ''
file = 'stopwords.txt'
stopwords_file = open(folder+file, 'r')
    
stopwords_array = []
       
for line in stopwords_file: 
    stopwords_array.append(line)
    print(line)


