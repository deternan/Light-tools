# coding=utf8
'''
 version: October 15, 2017 05:59 PM
 Last revision: October 15, 2017 05:59 PM
  
 Author : Chao-Hsuan Ke
 
 Reference
 https://docs.python.org/3/library/random.html
 https://github.com/python/cpython/blob/3.6/Lib/random.py
 
'''
from random import randint

min = 0;
max = 3;

for i in range(1, 11):
    print(randint(min,max))
