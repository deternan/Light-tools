# coding=utf8
'''
Created on January 10, 2018    11:30 PM

@author: Chao-Hsuan Ke
'''

import datetime

time_str = datetime.time(13, 5)
date_str = datetime.date(2018,1,10)

now = datetime.datetime.now()

dateandtime_1 = datetime.datetime(2018,1,2,1,9,19)
dateandtime_2 = datetime.datetime(2018,1,11,0,36,46)

print(time_str)
print(date_str)
print(now)

print(dateandtime_2 - dateandtime_1)

