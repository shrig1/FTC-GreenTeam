import subprocess
import sys

packages = ["matplotlib", "numpy", "keras", "tensorflow", "Pillow", "scikit-learn", "opencv-python"] 

def install(package):
    for package in packages:
      subprocess.call([sys.executable, "-m", "pip", "install", package])
     
print("yeet")


  
  
