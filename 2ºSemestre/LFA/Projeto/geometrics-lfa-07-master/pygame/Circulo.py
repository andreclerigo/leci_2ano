import abc
from Forma import *
from Ponto import *
import math
import pygame

class Circulo(Forma):
    def __init__(self, *args):

        #if there are no args
        if len(args) == 0 :
            self.center = Ponto(0,0)
            self.radius = 0
            self.color = (0,0,0)

        #if the args are three int values
        elif(isinstance(args[0],int) and isinstance(args[1],int) and isinstance(args[2],int) and (isinstance(args[3],tuple) or isinstance(args[3],str))):
            self.center = Ponto(args[0],args[1])
            self.radius = args[2]
            self.color = args[3]

        #if the args are a dot and a int value
        elif(isinstance(args[0],Ponto) and isinstance(args[1],int) and (isinstance(args[2],tuple) or isinstance(args[2],str))):
            self.center = args[0]
            self.radius = args[1]
            self.color = args[2]
        
        #in case that the only args is the radius
        elif(isinstance(args[0],int) and (isinstance(args[1],tuple) or  isinstance(args[1],str))):
            self.center = Ponto(0,0)
            self.radius = args[0]
            self.color = args[1]

    def __setCenter__(self,center):
        self.center = center

    def __getCenter__(self):
        return self.center

    def __setColor__(self,color):
        self.color = color

    def __getColor__(self):
        return self.color
    
    def __setRadius__(self,radius):
        self.radius = radius

    def __getRadius__ (self):
        return self.radius

    def area(self):
        return math.pi * math.pow(self.radius,2)

    def perimeter(self):
        return 2 * math.pi * self.radius

    def __intercept__(self,other):
        return self.center.__distanceTo__(other.center) <= (self.radius + other.radius)

    def __draw__(self,surface):
        color = self.color
        centerx = self.__getCenter__().get_x()
        centery = self.__getCenter__().get_y()
        center = (centerx,centery)
        radius = self.radius       

        return pygame.draw.circle(surface, color,center,radius)