#!/usr/bin/env python3

w=10
h=10
with open('sep.pgm','w') as sep:
	sep.write("P2\n{} {}\n255\n".format(w,h))

	for i in range(h):
		for j in range(w):
			if i<h/2:
				if j<w/2:
					sep.write("255 ")
				else:
					sep.write("170 ")
			else:
				if j<w/2:
					sep.write("85 ")
				else:
					sep.write("0 ")
		sep.write("\n")
	sep.close()
