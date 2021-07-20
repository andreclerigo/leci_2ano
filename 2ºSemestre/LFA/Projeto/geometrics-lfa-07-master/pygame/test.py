from Geometrics import *
import pygame
import math

ponto = Ponto(120,250)

figuras = []

print('X ponto : ' + str(ponto.get_x()))

ponto1 = Ponto(120,500)

print('X ponto1 : ' + str(ponto1.get_x()))

l1 = Linha(ponto,ponto1,(255,0,0))



distance = ponto.__distanceTo__(ponto1)

print('Comprimento' + str(distance))

print(ponto.__equals__(ponto1))

c1 = Circulo(120,120,50,{"color": "#FFABAB", "thickness": 10, "filled": "yes", "hidden": "no"})





pygame.init()

screen = pygame.display.set_mode([500,500])

running = True
ponto1aux = Ponto(120,250)
ponto2aux = Ponto(120,500)

l1 = Linha(ponto1aux,ponto2aux,(0,255,0))

while running:
    for event in pygame.event.get():
        if event.type == pygame.QUIT:
            running = False

    screen.fill((255,255,255))

    #pygame.draw.line(screen, (255,0,0), ponto.__pos__(), ponto1.__pos__(),distance)

    figuras.append(c1)
    figuras.append(l1)

    for figura in figuras:
        figura.__draw__(screen)
    

    pygame.display.flip()

pygame.quit()




