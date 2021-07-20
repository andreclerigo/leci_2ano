from Figura import Figura
from Geometrics import *

house1 = Figura()      #figure house1

ponto0aux = Ponto(0,9)

base = Rectangulo(Ponto(250,500),500,500,{"color": (255,120,0),"thickness": 0,"filled": "yes", "hidden": "no"})

house1.__appendFig__(base)

draw1 = Figura()
roof1 = Figura()
ponto1aux = Ponto(500,250)
ponto2aux = Ponto(750,500)

l1 = Linha(ponto1aux,ponto2aux,{"color": (255,0,0),"thickness": 5,"filled": "yes", "hidden":"no"})

ponto3aux = Ponto(500,250)
ponto4aux = Ponto(250,500)

l2 = Linha(ponto3aux,ponto4aux,{"color": (255,0,0),"thickness": 5,"filled": "yes", "hidden":"no"})

roof1.__appendFig__(l1)
roof1.__appendFig__(l2)

house1.__appendFig__(roof1)
    
window1 = Rectangulo(Ponto(550,550),150,150,{"color": (0,0,250),"thickness": 0,"filled": "yes", "hidden": "no"})

house1.__appendFig__(window1)

window2 = Rectangulo(Ponto(300,550),150,150,{"color": (0,0,250),"thickness": 0,"filled": "yes", "hidden": "no"})

house1.__appendFig__(window2)

door = Rectangulo(Ponto(445,800),100,200,{"color": (0,0,0),"thickness": 0,"filled": "yes", "hidden": "no"})

house1.__appendFig__(door)

pygame.init()

screen = pygame.display.set_mode([1000,1000])

running = True

while running:
    for event in pygame.event.get():
        if event.type == pygame.QUIT:
            running = False

    screen.fill((255,255,255))

    #pygame.draw.line(screen, (255,0,0), ponto.__pos__(), ponto1.__pos__(),distance)
    '''
    while(house1.get_x() < (1000)):
        screen.fill((255,255,255))
        house1.__setCenter__(Ponto(house1.get_x() + 1, house1.get_y()))
        house1.__draw__(screen)
        pygame.display.update()
        pygame.time.wait(20)

    '''
    house1.__draw__(screen)
    
    pygame.display.flip()
    

pygame.quit()
 