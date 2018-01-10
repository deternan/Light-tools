# coding=utf8
'''
Created on January 08, 2018    11:32 PM

@author: Chao-Hsuan Ke
'''

import random;
# Random 
unsortData = random.sample(range(100), 10)

print("Original Data:", unsortData)

def bubble_sort(lst):    
    j = 0
    tmp = 0
    for i in range(0,len(lst)-1,1):
        j = i
        for k in range(0,len(lst)-1,1):
            if lst[j] < lst[k]:
                j = k
        
                tmp = lst[i]
                lst[i] = lst[j]
                lst[j] = tmp
                    
    return lst
    
sortData = bubble_sort(unsortData)
    
print("Sort", sortData)