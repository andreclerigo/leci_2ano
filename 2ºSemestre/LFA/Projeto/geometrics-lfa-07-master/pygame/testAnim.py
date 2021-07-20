
from Geometrics import *
import pygame
import math

conjunto1 = Figura()
conjunto2 = Figura()
toBlip = Figura()
staticFigs = Figura()

#c1 = Circulo(320,120,50,{"color": "#FFABAB", "thickness": 10, "filled": "yes", "hidden": "no"})
#c2 = Circulo(320,60,30,{"color": "#FFAFFA", "thickness": 20, "filled": "yes", "hidden": "no"})
#c3 = Circulo(550,300,30,{"color": "#03A20C", "thickness": 0, "filled": "yes", "hidden": "no"})
#r1 = Rectangulo(Ponto(380,500),100,100,{"color": "red","thickness": 0,"filled": "yes", "hidden": "no"})
#el1 = Elipse(Ponto(500,500),50,100,{"color": "red","thickness": 0,"filled": "yes", "hidden": "no"})
#l1 = Linha(Ponto(50,198),Ponto(100,660),{"color": "blue","thickness": 10,"filled": "yes", "hidden": "no"})

cara = Circulo(270,500,200,{"color": "yellow", "thickness": 0, "filled" : "yes", "hidden": "no"})
olho1 = Circulo(170,425,25,{"color": "blue", "thickness": 0, "filled": "yes", "hidden": "no"})
olho2 = Circulo(350,425,25,{"color": "blue", "thickness": 0, "filled": "yes", "hidden": "no"})
boca = Linha(Ponto(180,550),Ponto(350,550),{"color": "red", "thickness": 5, "filled": "yes", "hidden": "no"})

pontoacomer = Circulo(800,500,25,{"color": "#00008B", "thickness": 0, "filled": "yes", "hidden": "no"})
pygame.init()

screen = pygame.display.set_mode([1000,1000])

#conjunto1.__appendFig__(c3) #vai para a esquerda
#conjunto1.__appendFig__(c1)
#conjunto1.__appendFig__(c2)
#conjunto1.__appendFig__(r1)
#conjunto1.__appendFig__(el1)
#conjunto1.__appendFig__(l1)

conjunto1.__appendFig__(cara)
conjunto1.__appendFig__(olho1)
conjunto1.__appendFig__(olho2)
conjunto1.__appendFig__(boca)

staticFigs.__appendFig__(conjunto1)
staticFigs.__appendFig__(pontoacomer)

backgroundColor = (255,255,255)
screen.fill(backgroundColor)

running = True
while running:
    for event in pygame.event.get():
        if event.type == pygame.QUIT:
            running = False

    conjunto1.__translate__(screen,(255,255,255),Ponto(800,500), 5,staticFigs)
    

    pygame.display.update()
    
    pygame.display.flip()

pygame.quit()
