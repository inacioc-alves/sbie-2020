fcontent = ""
w = ''
h = ''
matriz = []
max_pixel = ''

with open ("lena2.pgm") as f:
  magic = f.readline()
  w, h = f.readline().split()
  #w = int(w)
  #h = int(h)
  max_pixel = f.readline()[:-1]

  text = f.readlines()
  i = 0
  for i in range( int(h) ):
    l = []
    i = 0
    for j in range( int(w) ):
      l.append(text[i][:-1])
      i = i + 1
    matriz.append(l)

f.close()

with open ("lena3.pgm", "w") as f:
  f.write("P2\n"+w+" "+h+"\n"+max_pixel+"\n")

  for i in range( int(h) ):
    for j in range( int(w) ):
      f.write("{:>3s} ".format(matriz[i][j]))
    f.write("\n")

f.close()