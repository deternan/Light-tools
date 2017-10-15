# coding=utf8

import re

'''
version: October 15, 2017 05:27 PM
Last revision: October 15, 2017 05:27 PM
  
 Author : Chao-Hsuan Ke

@author: user
'''
pattern_str = '[a-z]+'
pattern_num = '[0-9]+'

input_str = "1102abc";

p = re.compile(pattern_num);
#print(p.match(input_str))
m = re.search(pattern_num, input_str)
print(m.group())
