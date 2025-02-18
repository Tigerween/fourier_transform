import numpy as np
import matplotlib.pyplot as plt
pi = 3.1415926535897932384626433832

# Setup
xpts = np.array([]) # x-values
ypts = np.array([]) # y values passed into mystery sinusoidal function

###arr = [0.0, 1.639577591586553, 1.6204892843216263, 1.3898941318376798, -1.022469625000494, -0.7368191040021725, -1.9469242928862358, 0.5398895844953732, -0.43777111747015396, 1.5358501139490666]

def mystery():
    t = xpts[i]
    return np.sin(t)+np.sin(3*t)+np.sin(7*t)

for i in range(5000):
    xpts = np.append(xpts, i)

for i in range(len(xpts)):
    ypts = np.append(ypts, mystery())

"""for i in range(10):
    xpts = np.append(xpts,i)
    ypts = np.append(ypts,arr[i])"""

# Function to determine the Fourier Transform for a particular frequency
def four(arr_x,arr_y,freq):
    func_re = 0
    for i in range(len(arr_y)):
        func_re += xpts[1] * arr_y[i] * np.cos(freq * arr_x[i])

    func_im = 0
    for i in range(len(arr_y)):
        func_im += xpts[1] * arr_y[i] * np.sin(freq * arr_x[i])

    return np.sqrt(func_re**2 + func_im**2)

# Sets up graph
x = np.array([]) # x axis
y = np.array([]) # y axis (the transformed graph)
y_o = np.array([]) # original graph
##y_expect = np.array([])

# fill x array
for i in range(1,100):
    x = np.append(x, i/10)

# fill y array with all of the fourier transform values
for i in range(len(x)):
    y = np.append(y,four(xpts, ypts, x[i]))

# original graph
"""for i in range(len(x)):
    y_o = np.append(y_o,four(x, y, x[i]))
"""

# not necessary (used for checking)
"""
for i in range(len(x)):
    y_expect = np.append(y_expect, 1/(1-x[i]**2))
"""

##plt.plot(xpts, ypts)
##plt.plot(x,y_expect)
plt.plot(x,y)
##plt.plot(x, y_o)
plt.show()