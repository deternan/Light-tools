# coding: utf-8

'''
Created on April 23, 2018 08:13 PM

@author: Phelps
'''

import threading
import time

def worker(num):    
    #print ('Worker: %s' % num)
    print(num)
    return

threads = []
for i in range(5):
    t = threading.Thread(target=worker, args=(i,))
    threads.append(t)
    t.start()
    'delay'
    time.sleep(5)