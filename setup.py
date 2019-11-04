import subprocess
import sys

packages = ["matplotlib", "numpy", "keras", "tensorflow", "Pillow", "scikit-learn", "opencv-python", "theano"] 

def install():
    for package in packages:
      subprocess.call([sys.executable, "-m", "pip", "install", package])

install()
print("yeet")


  
  
