import abc
from Forma import *
import math
from Ponto import *
import pygame

class Linha(Forma):

    def __init__(self, *args):
        
         #if there are no args
        if len(args) == 0 :
            self.ponto = Ponto(0,0)
            self.ponto2 = Ponto(0,0)
            self.comprimento = 0
            self.color = (0,0,0)

        #if the args are two dots
        elif(isinstance(args[0],Ponto) and isinstance(args[1],Ponto)):
            self.ponto = args[0]
            self.ponto2 = args[1]
            self.comprimento = self.ponto.__distanceTo__(self.ponto2)
            self.color = (0,0,0)

        elif(isinstance(args[0],Ponto) and isinstance(args[1],Ponto) and isinstance(args[2],tuple)):
            self.ponto = args[0]
            self.ponto2 = args[1]
            self.comprimento = self.ponto.__distanceTo__(self.ponto2)
            self.color = args[2]

        
    
    #setter method to change the value of the x coordinate
    def set_ponto(self,ponto):
        self.ponto = ponto

    #setter method to change the value of the y coordinate
    def set_ponto2(self,ponto2):
        self.ponto2 = ponto2 
    
    #getter method to get x coordinate
    def get_ponto(self):
        return self.ponto
    
    #getter method to get y coordinate
    def get_ponto2(self):
        return self.ponto2
    
    def __setColor__(self,color):
        self.color = color

    def __getColor__(self):
        return self.color

    def __draw__(self,surface):
        color = self.color
        pos1 = self.ponto.__pos__()
        pos2 = self.ponto2.__pos__()
        
        return pygame.draw.line(surface,color,pos1,pos2,5)
    
    def __setCenter__(self, center):
        pass

    def __getCenter__(self):
        pass

    def area(self):
        pass

    def perimeter(self):
        pass

    def __intercept__(self, other):
        pass

    

    