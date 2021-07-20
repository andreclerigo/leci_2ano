import abc
from Forma import *
import math
from Ponto import *
import pygame

class Rectangulo(Forma):
    def __init__(self, *args):

        #if there are no args
        if len(args) == 0 :
            self.center = Ponto(0,0)
            self.bottomLeft = Ponto(0,0)
            self.topRight = Ponto(0,0)
            self.side = 0
            self.height = 0
            self.width = 0
            self.color = (0,0,0)

        #if the args are two dots
        elif(isinstance(args[0],Ponto) and isinstance(args[1],Ponto)):
            self.center =  args[0].__halfWayTo__(args[1])
            self.bottomLeft = args[0]
            self.topRight = args[1]
            self.height = self.topRight.get_y() - self.bottomLeft.get_y()
            self.width = self.topRight.get_x() - self.bottomLeft.get_x()
            self.color = args[2]
            self.top = self.bottomLeft.get_x()
            self.left = self.bottomLeft.get_y() + self.height

        #in case that the only args are the width and height values
        elif(isinstance(args[0],int) and isinstance(args[1],int) and isinstance(args[2],tuple)):
            self.bottomLeft = Ponto(args[0],0)
            self.topRight = Ponto(0,args[1])
            self.center = self.bottomLeft.__halfWayTo__(self.topRight)
            self.height = args[1]
            self.width = args[0]
            self.color = args[2]
            self.top = self.bottomLeft.get_x()
            self.left = self.bottomLeft.get_y() + self.height

        #in case that are provided four int values
        elif(isinstance(args[0],int) and isinstance(args[1],int) and isinstance(args[2],int) and isinstance(args[3],int and isinstance(args[4],tuple))):
            self.center = Ponto(args[0],args[1])
            self.height = args[2]
            self.width = args[3]
            self.bottomLeft = Ponto(args[0] - args[3]/2, args[1] - args[2]/2)
            self.topRight = Ponto(args[0] + args[3]/2, args[1] + args[2]/2)
            self.color = args[4]
            self.left = self.bottomLeft.get_x()
            self.top = self.topRight.get_y() - self.width


    def __draw__(self, surface):
        toDrawRect = pygame.Rect(self.left, self.top, self.width, self.height)
        pygame.draw.rect(surface, self.color, toDrawRect)

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
    
    def __setRadius__(self,radius):
        self.radius = radius

    def area(self):
        return self.height * self.width

    def perimeter(self):
        return 2 * self.height + 2 * self.width

    def __intercept__(self, other):
        if(self.bottomLeft.get_x() >= other.topRight.get_y() or self.topRight.get_x() <= other.bottomLeft.get_x() or self.topRight.get_y() <= other.bottomLeft.get_y() or self.bottomLeft.get_y() >= other.topRight.get_y()):
            return False
        else:
            return True
