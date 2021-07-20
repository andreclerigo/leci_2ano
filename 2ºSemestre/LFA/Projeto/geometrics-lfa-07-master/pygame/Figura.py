from Forma import Forma
from Geometrics import *
import abc
import math
import pygame
import time

class Figura(Forma):
    def __init__(self):
        self.figuras = []

    def __draw__(self, surface):
        pass

    def __setCenter__(self, destPoint):
        for figura in self.figuras:      
            difX = self.get_x() - figura.get_x()        # difX > 0      Destpoint da shape vai ser mais a esquerda
            difY = self.get_y() - figura.get_y()        # difY > 0      Destpoint da shape vai ser mais acima
            
            aux = Ponto(destPoint.get_x() - difX, destPoint.get_y() - difY)

            FiF = figura
            if(isinstance(FiF,Figura)):
                for figura1 in FiF.figuras:
                    difX1 = self.get_x() - figura.get_x()        # difX > 0      Destpoint da shape vai ser mais a esquerda
                    difY1 = self.get_y() - figura.get_y()        # difY > 0      Destpoint da shape vai ser mais acima
            
                    aux1 = Ponto(destPoint.get_x() - difX1, destPoint.get_y() - difY1)

                    if (figura1.get_x() < aux1.get_x()):
                        figura1.__setCenter__( Ponto( figura1.get_x() + 1, figura1.get_y()) )
                    elif (figura1.get_x() > aux1.get_x()):
                        figura1.__setCenter__( Ponto( figura1.get_x() - 1, figura1.get_y()) )
                    
                    if (figura1.get_y() < aux1.get_y()):
                        figura1.__setCenter__( Ponto( figura1.get_x(), figura1.get_y() + 1) )
                    elif (figura1.get_y() > aux1.get_y()):
                        figura1.__setCenter__( Ponto( figura1.get_x(), figura1.get_y() - 1) )
            else:
                if (figura.get_x() < aux.get_x()):
                    figura.__setCenter__( Ponto( figura.get_x() + 1, figura.get_y()) )
                elif (figura.get_x() > aux.get_x()):
                    figura.__setCenter__( Ponto( figura.get_x() - 1, figura.get_y()) )
                
                if (figura.get_y() < aux.get_y()):
                    figura.__setCenter__( Ponto( figura.get_x(), figura.get_y() + 1) )
                elif (figura.get_y() > aux.get_y()):
                    figura.__setCenter__( Ponto( figura.get_x(), figura.get_y() - 1) )

    def __getCenter__(self):
        centerSumX = 0
        centerSumY = 0
        numOfObjs = 0
        for figura in self.figuras:
            numOfObjs = numOfObjs + 1
            FiF = figura
            if(hasattr(FiF, 'figuras')):
                for figura1 in FiF.figuras:
                    centerSumX = centerSumX + figura1.__getCenter__().get_x()
                    centerSumY = centerSumY+ figura1.__getCenter__().get_y()
            else:
                centerSumX = centerSumX + figura.__getCenter__().get_x()
                centerSumY = centerSumY + figura.__getCenter__().get_y()

        return Ponto(centerSumX // numOfObjs, centerSumY // numOfObjs)

    def get_x(self):
        return self.__getCenter__().get_x()

    def get_y(self):
        return self.__getCenter__().get_y()

    def __getFiguras__(self):
        return self.figuras

    def __appendFig__(self,other):
        self.figuras.append(other)

    def __remove__(self,other):
        self.figuras.remove(other)

    def area(self):
        pass

    def perimeter(self):
        pass

    def __intercept__(self, other):
        pass
    
    def __getColor__(self):
        pass
    
    def __draw__(self,surface):
        for figura in self.figuras:
            FiF = figura
            if(isinstance(FiF,Figura)):
                for figura1 in FiF.figuras:
                    figura1.__draw__(surface)
            else:
                figura.__draw__(surface)

    def __translate__(self, surface, backgroundColor, destPoint, tick,staticFigs):
        staticFigs.__remove__(self)
        while(self.get_x() != destPoint.get_x() or self.get_y() != destPoint.get_y()):
            surface.fill(backgroundColor)
            if(self.get_x() < destPoint.get_x()):
                self.__setCenter__(Ponto(self.get_x() + 1, self.get_y()))
            else:
                if(self.get_x() > destPoint.get_x()):
                    self.__setCenter__(Ponto(self.get_x() - 1, self.get_y()))
            
            if(self.get_y() < destPoint.get_y()):
                self.__setCenter__(Ponto(self.get_x(), self.get_y() + 1))
            else:
                if(self.get_y() > destPoint.get_y()):
                    self.__setCenter__(Ponto(self.get_x(), self.get_y() - 1))
            '''print("AAAAA")
            if(self.__intercept__(staticFigs)):
                print("hey")
                self.__setColor__((255,0,0))'''
            self.__draw__(surface)
            staticFigs.__draw__(surface)

            pygame.display.update()
            #pygame.time.wait(100)
            pygame.time.wait(tick)
        staticFigs.__appendFig__(self)