#!/usr/bin/env python3

from sys import argv

with open(argv[1]) as fin:
	id   = fin.readline()
	hw   = fin.readline().split()
	maxv = fin.readline()
	print(id)
	print(hw)
	print(maxv)
	content = list(filter(('').__ne__,fin.read().replace('\n',' ').split(' ')))
	#print(content[:2000])
	print(len(content))

sout = argv[1][:-4]+'_out.pgm'
print(sout)
p=0
with open(sout,'w') as fout:
	fout.write(id)
	fout.write(hw[0]+' '+hw[1]+'\n')
	fout.write(maxv)
	for i in range(int(hw[1])):
		for j in range(int(hw[0])):
			fout.write(content[p]+' ')
			p+=1
		fout.write('\n')