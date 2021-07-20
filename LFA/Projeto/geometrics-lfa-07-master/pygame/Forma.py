import abc
from Ponto import *
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