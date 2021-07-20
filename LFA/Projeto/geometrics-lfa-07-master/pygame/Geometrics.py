import abc
import math
from typing import Generic
import pygame


colorToRGB = {'red': (255,0,0), 'blue': (0,0,255), 'green': (0,255,0), 'yellow': (255,255,0),
            'black': (0,0,0), 'white': (255,255,255), 'cyan': (0,255,255), 'orange': (255,165,0),
            'purple': (255,0,255), 'pink': (255,20,147), 'brown': (160,82,45), 'grey': (128,128,128)}

class Forma(metaclass = abc.ABCMeta):
    @abc.abstractmethod
    def __setCenter__(self,center):
        pass

    def __getCenter__ (self):
        pass

    #abstract method for area
    def area(self):
        pass
    
    #abastract method for perimeter
    def perimeter(self):
        pass

    def __intercept__(self,other):
        pass

    def __getColor__(self):
        pass

    def __draw__(self,surface):
        pass

    def __setHidden__(self):
        self.width = -1

    def __setNotHidden__(self):
        self.width = 0

    def __animationSetup__(self):
        newFig = self
        self.width = -1
        return newFig

class Ponto:
    def __init__(self, x, y):
        self.x = x
        self.y = y
        self.width = 0
        
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
        return Ponto((self.x + other.x)//2.0, (self.y + other.y)//2.0)

    #method to find the distance between 2 points
    def __distanceTo__(self,other):
        return round(math.sqrt( ((self.x-other.x)**2) + ((self.y-other.y)**2) ))

    def __pos__ (self):
        return (self.x, self.y)

class Linha(Forma):
    def __init__(self, *args):

        if(isinstance(args[0],Ponto) and isinstance(args[1],Ponto) and isinstance(args[2],dict)):
            self.width = 1
            self.ponto = args[0]
            self.ponto2 = args[1]
            self.comprimento = self.ponto.__distanceTo__(self.ponto2)
            self.dict = args[2]

        elif(isinstance(args[0],int) and isinstance(args[1],int) and isinstance(args[2],int) and isinstance(args[3],int) and isinstance(args[4],dict)):
            self.width = 1
            self.ponto = Ponto(args[0],args[1])
            self.ponto2 = Ponto(args[2],[3])
            self.comprimento = self.ponto.__distanceTo__(self.ponto2)
            self.dict = args[4]

        value = self.dict.get('color')
        if(type(value) == str and value.startswith('#')):
            HEXtoRGB(value)
        if(type(value) == str and not value.startswith('#')):
            value = colorToRGB.get(value)
            
        self.color = value
        self.filled = self.dict.get('thickness')
        self.thickness = self.dict.get('thickness')
        self.hidden = self.dict.get('hidden') 
        if(self.hidden == 'yes'):
            self.width = -1
        else:
            if(self.thickness > 0):
                self.width = self.thickness
            else:
                if(self.filled == 'yes'):
                    self.width = 0
            
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
        
        return pygame.draw.line(surface,self.color,pos1,pos2,self.width)
        
    def __setCenter__(self, center):
        currentCenter = self.__getCenter__()
        difX = center.get_x() - currentCenter.get_x()           # difX > 0 novo centro mais à direita
        difY = center.get_y() - currentCenter.get_y()           # difY > 0 novo centro mais abaixo

        self.ponto.set_x(self.ponto.get_x() + difX)
        self.ponto.set_y(self.ponto.get_y() + difY)
        self.ponto2.set_x(self.ponto2.get_x() + difX)
        self.ponto2.set_y(self.ponto2.get_y() + difY)

    def __getCenter__(self):
        return self.ponto.__halfWayTo__(self.ponto2)

    def get_x(self):
        return self.__getCenter__().get_x()
    
    def get_y(self):
        return self.__getCenter__().get_y()

    def __intercept__(self, other):
        pass    

class Circulo(Forma):
    def __init__(self, *args):
        self.width = 0

        if(isinstance(args[0],int) and isinstance(args[1],int) and isinstance(args[2],int) and (isinstance(args[3], dict))):
            self.center = Ponto(args[0],args[1])
            self.radius = args[2]
            self.dict = args[3]
        #if the args are a dot and a int value  (Ponto(10,20),15,Dict)
        elif(isinstance(args[0],Ponto) and isinstance(args[1],int) and (isinstance(args[2], dict))):
            self.center = args[0]
            self.radius = args[1]
            self.color = args[2]
            self.dict = args[2]
        
        value = self.dict.get('color')
        if(type(value) == str and value.startswith('#')):
            HEXtoRGB(value)
        if(type(value) == str and not value.startswith('#')):
            value = colorToRGB.get(value)
            
        self.color = value
        self.filled = self.dict.get('thickness')
        self.thickness = self.dict.get('thickness')
        self.hidden = self.dict.get('hidden') 
        if(self.hidden == 'yes'):
            self.width = -1
        else:
            if(self.thickness > 0):
                self.width = self.thickness
            else:
                if(self.filled == 'yes'):
                    self.width = 0

    def __setCenter__(self,center):
        self.center = center

    def __getCenter__(self):
        return self.center

    def get_x(self):
        return self.center.get_x()
    
    def get_y(self):
        return self.center.get_y()

    def __setColor__(self,color):
        self.color = color

    def __getColor__(self):
        return self.color
    
    def __setRadius__(self,radius):
        self.radius = radius

    def __intercept__(self,other):
        print("hey1")
        return self.center.__distanceTo__(other.center) <= (self.radius + other.radius)

    def __draw__(self,surface):
        center = (self.get_x(), self.get_y())
        return pygame.draw.circle(surface, self.color, center, self.radius, self.width)

class Rectangulo(Forma):
    def __init__(self, *args):
        self.width = 0

        # Rectangle constructor (Ponto(x,y), comprimento, altura)
        if(isinstance(args[0],Ponto) and isinstance(args[1],int) and isinstance(args[2],int) and isinstance(args[3],dict)):
            self.center = args[0]           
            self.comprimento = args[1]
            self.altura = args[2]
            self.top = self.get_y() +  self.altura//2
            self.left = self.get_x() - self.comprimento//2
            self.dict = args[3]
        elif(isinstance(args[0],int) and isinstance(args[1],int) and isinstance(args[2],int) and isinstance(args[3],int) and (isinstance(args[4], dict))):
            self.center = Ponto(args[0],args[1])           
            self.comprimento = args[2]
            self.altura = args[3]
            self.top = self.get_y() +  self.altura//2
            self.left = self.get_x() - self.comprimento//2
            self.dict = args[4]

        value = self.dict.get('color')
        if(type(value) == str and value.startswith('#')):
            HEXtoRGB(value)
        if(type(value) == str and not value.startswith('#')):
            value = colorToRGB.get(value)
                
        self.color = value
        self.filled = self.dict.get('thickness')
        self.thickness = self.dict.get('thickness')
        self.hidden = self.dict.get('hidden') 
        if(self.hidden == 'yes'):
            self.width = -1
        else:
            if(self.thickness > 0):
                self.width = self.thickness
            else:
                if(self.filled == 'yes'):
                    self.width = 0

    def __setCenter__(self,center):
        self.center = center
        self.__setTopLeft__(Ponto(self.get_x() - self.comprimento//2, self.get_y() + self.altura//2))

    def __setTopLeft__(self,topleft):
        self.left = topleft.get_x()
        self.top = topleft.get_y()

    def __setColor__(self,color):
        self.color = color

    def __getCenter__(self):
        return self.center

    def get_x(self):
        return self.center.get_x()
    
    def get_y(self):
        return self.center.get_y()
    
    def __getColor__(self):
        return self.color

    def __intercept__(self, other):
        if(self.bottomLeft.get_x() >= other.topRight.get_y() or self.topRight.get_x() <= other.bottomLeft.get_x() or self.topRight.get_y() <= other.bottomLeft.get_y() or self.bottomLeft.get_y() >= other.topRight.get_y()):
            return False
        else:
            return True

    def __draw__(self, surface):
        color = self.color
        toDrawRect = pygame.Rect(self.left, self.top, self.comprimento, self.altura)
        pygame.draw.rect(surface, color, toDrawRect,self.width)


def HEXtoRGB(str):
    str = str[1:]
    rgb = tuple(int(str[i:i+2], 16) for i in (0, 2, 4))
    return rgb


class Elipse(Forma):
    def __init__(self, *args):
        self.width = 0

        # Rectangle constructor (Ponto(x,y), comprimento, altura)
        if(isinstance(args[0],Ponto) and isinstance(args[1],int) and isinstance(args[2],int) and isinstance(args[3],dict)):
            self.center = args[0]           
            self.comprimento = args[1]
            self.altura = args[2]
            self.top = self.get_y() +  self.altura//2
            self.left = self.get_x() - self.comprimento//2
            self.dict = args[3]
        
        elif(isinstance(args[0],int) and isinstance(args[1],int) and isinstance(args[2],int) and isinstance(args[3],int) and (isinstance(args[4], dict))):
            self.center = Ponto(args[0],args[1])           
            self.comprimento = args[2]
            self.altura = args[3]
            self.top = self.get_y() +  self.altura//2
            self.left = self.get_x() - self.comprimento//2
            self.dict = args[4]

            value = self.dict.get('color')
            if(type(value) == str and value.startswith('#')):
                HEXtoRGB(value)
            if(type(value) == str and not value.startswith('#')):
                value = colorToRGB.get(value)
                
            self.color = value
            self.filled = self.dict.get('thickness')
            self.thickness = self.dict.get('thickness')
            self.hidden = self.dict.get('hidden') 
            if(self.hidden == 'yes'):
                self.width = -1
            else:
                if(self.thickness > 0):
                    self.width = self.thickness
                else:
                    if(self.filled == 'yes'):
                        self.width = 0

    def __setCenter__(self,center):
        self.center = center
        self.__setTopLeft__(Ponto(self.get_x() - self.comprimento//2, self.get_y() + self.altura//2))

    def __setTopLeft__(self,topleft):
        self.left = topleft.get_x()
        self.top = topleft.get_y()

    def __setColor__(self,color):
        self.color = color

    def __getCenter__(self):
        return self.center

    def get_x(self):
        return self.center.get_x()
    
    def get_y(self):
        return self.center.get_y()
    
    def __getColor__(self):
        return self.color

    def __intercept__(self, other):
        if(self.bottomLeft.get_x() >= other.topRight.get_y() or self.topRight.get_x() <= other.bottomLeft.get_x() or self.topRight.get_y() <= other.bottomLeft.get_y() or self.bottomLeft.get_y() >= other.topRight.get_y()):
            return False
        else:
            return True

    def __draw__(self, surface):
        color = self.color
        toDrawRect = pygame.Rect(self.left, self.top, self.comprimento, self.altura)
        pygame.draw.ellipse(surface, color, toDrawRect,self.width)
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