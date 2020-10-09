#!/usr/bin/env python3

from sys import argv

with open(argv[1]) as f:
	s = f.read()
	s=s.replace(',',' ')
	s=s.replace('[','')
	s=s.replace(']','\n')
	s=s.replace('(','')
	s=s.replace(')','')
	s=s.replace('"','')
	s=s.replace('1`','')
	f.close()

sout = argv[1][:-4]+'_out.pgm'
#with open('glass_filtered.pgm','w') as fout:
with open(sout,'w') as fout:
	#fout.write('P2\n320 428\n255\n')
	fout.write(s)
#print(s)
