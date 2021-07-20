import math
class Ponto:

    def __init__(self, x, y):
        self.x = x
        self.y = y
    
    #setter method to change the value of the x coordinate
    def set_x(self,x):
        self.x = x

    #setter method to change the value of the y coordinate
    def set_y(self,y):
        self.y = y 
    
    #getter method to get x coordinate
    def get_x(self):
        return self.x
    
    #getter method to get y coordinate
    def get_y(self):
        return self.y
    
    #method to add 2 points
    def __add__(self,other):
        self.x += other.x
        self.y += other.y


    ## Estas duas podem dar jeito para a linha principalmente a distance
    #method to find the halfway point
    def __halfWayTo__(self,other):
        return Ponto((self.x + other.x)/2.0,(self.y + other.y)/2.0)


    #method to find the distance between 2 points
    def __distanceTo__(self,other):
        return round(math.sqrt( ((self.x-other.x)**2) + ((self.y-other.y)**2) ))

    # nao é necessario
    def __equals__(self,other):
        if(self.x == other.x and self.y == other.y):
            return True
        else:
            return False

    def __pos__ (self):
        return (self.x, self.y)

    


    

