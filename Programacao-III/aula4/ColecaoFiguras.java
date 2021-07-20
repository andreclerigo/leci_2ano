package aula4;

import java.util.Arrays;
import java.util.Vector;

import aula3.Ponto;
import aula3.Forma;
public class ColecaoFiguras {
    private double maxArea;
    private Vector<Forma> colecaoFiguras = new Vector<>();

    public ColecaoFiguras(double maxArea){
        this.maxArea = maxArea;
    }

    public Forma[] getFiguras() {
        return colecaoFiguras.toArray(new Forma[colecaoFiguras.size()]);
    }

    public double getAreaMax() {
        return maxArea;
    }

    public boolean addFigura(Forma f){
        if(f.area() <= maxArea && !exists(f)){
            return colecaoFiguras.add(f);
        }
        return false;
    }

    public boolean delFigura(Forma f){
        if (exists(f))
            return colecaoFiguras.remove(f);
        return false;
    }

    public boolean exists(Forma f){
        return colecaoFiguras.contains(f);
    }

    public double areaTotal(){
        double somaArea = 0;
        for(Forma f : colecaoFiguras){
            somaArea += f.area();
        }
        return somaArea;
    }

    public Ponto[] getCentros(){
        Vector<Ponto> centros = new Vector<>();
        for(Forma f : colecaoFiguras){
            centros.add(f.getCenter());
        }
        return centros.toArray(new Ponto[centros.size()]);
    }

    @Override
    public String toString() {
        return "\nA coleção de Figuras tem como àrea máxima: " + this.maxArea
              +"\nA coleção de Figuras tem como àrea total: " + this.areaTotal()
              +"\nA coleção contém estas figuras: " + Arrays.toString(getFiguras());
    }
}