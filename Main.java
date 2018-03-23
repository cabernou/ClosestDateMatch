from sys import stdin 
 
#Read the input using stdin
input = stdin.readlines()
D = input[0].replace('\n', '')
date = D.split('/')
for i in range(len(date)):
	date[i] = int(date[i])
D2 = input[1].replace('\n', '')
date2 = D2.split(',')

for i in range(len(date2)):
	date2[i] = date2[i].split('/')
# next thing to convert strings into ints
for i in range(len(date2)):
	for k in range(2):
		date2[i][k] = int(date2[i][k])
month = [31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31]
#turns the dates into day of the year format
def dayOfYear(lst):
    day = 0
    for i in range(lst[0]-1):
        day = day + month[i]
    day = day + lst[1]
    return day
#creating a list of the day values of the dates
values = []
for i in date2:
	if dayOfYear(i) >= dayOfYear(date):
		values.append(dayOfYear(i)-dayOfYear(date))
	else:
		values.append(dayOfYear(i) - dayOfYear(date)+365)
		#make sure that date is bigger, else do date2 - date +365
#finding the smallest value in the values list, and the index which will correspond
#to the date2
mini = min(values)
index = values.index(mini)
#fixing all the problems with single digit months, if the month or day is less
#than ten, it prints a 0 before the number
if date2[index][0] <10 and date2[index][1] <10:
	print '0' +str(date2[index][0])+ '/' + '0' +str(date2[index][1])
elif date2[index][0] <10:
	print '0' +str(date2[index][0])+ '/' + str(date2[index][1])
else:
	print str(date2[index][0])+ '/' + str(date2[index][1])	
	
		


