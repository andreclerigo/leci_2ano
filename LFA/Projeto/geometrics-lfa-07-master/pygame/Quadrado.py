import abc
from Forma import *
import math
from Ponto import *
import pygame

class Quadrado(Forma):
    def __init__(self, *args):

        #if there are no args
        if len(args) == 0 :
            self.center = Ponto(0,0)
            self.bottomLeft = Ponto(0,0)
            self.topRight = Ponto(0,0)
            self.side = 0
            self.color = (0,0,0)
            self.left = 0
            self.top = 0

        #if the args are two dots
        elif(isinstance(args[0],Ponto) and isinstance(args[1],Ponto) and isinstance(args[2],tuple)):
            temp = Ponto(args[0].get_x(), args[1].get_y())

            assert args[0].__distanceTo__(temp) == args[1].__distanceTo__(temp)

            self.center =  args[0].__halfWayTo__(args[1])
            self.bottomLeft = args[0]
            self.topRight = args[1]
            self.side = args[0].__distanceTo__(temp)
            self.color = args[2]
            self.top = self.bottomLeft.get_x()
            self.left = self.bottomLeft.get_y() + self.side

        #in case that the only args is the side
        elif(isinstance(args[0],int)):
            self.center = Ponto(0,0)
            self.side = args[0]
            self.color = args[1]
            self.top = 0 - self.side/2
            self.left = 0 + self.side/2


        #in case that are provided three int values
        elif(isinstance(args[0],int) and isinstance(args[1],int) and isinstance(args[2],int) and isinstance(args[3],tuple)):
            self.center = Ponto(args[0],args[1])
            self.side = args[2]
            self.bottomLeft = Ponto(args[0]-args[2]/2,args[1]-args[2]/2)    #Ponto(0,-250) BottomLeft
            self.topRight = Ponto(args[0]+args[2]/2, args[1] + args[2]/2)   #Ponto(750,250)
            self.color = args[3]
            self.top = self.topRight.get_y() - self.side              
            self.left = self.bottomLeft.get_x()




        

    def __setCenter__(self,center):
        self.center = center

    def __getCenter__(self):
        return self.center

    def __getbottomLeft__(self):
        return self.bottomLeft

    def __gettopRight__(self):
        return self.topRight
    
    def __getColor__(self):
        return self.color
    
    def area(self):
        return math.pow(self.side,2)

    def perimeter(self):
        return 4 * self.side

    def __intercept__(self, other):
        if(self.bottomLeft.get_x() >= other.topRight.get_y() or self.topRight.get_x() <= other.bottomLeft.get_x() or self.topRight.get_y() <= other.bottomLeft.get_y() or self.bottomLeft.get_y() >= other.topRight.get_y()):
            return False
        else:
            return True

    def __draw__(self, surface):
        toDrawRect = pygame.Rect(self.left, self.top, self.side, self.side)
        pygame.draw.rect(surface, self.color, toDrawRect)



