package com.example.boletas;

public class Boleta {
    private int folio;
    private int monto;
    public Boleta(int _folio){
        folio = _folio;
        monto = 0;
    }

    public void setMonto(int _monto){
        monto = _monto;
    }
    public int getMonto(){
        return monto;
    }
    public int getFolio(){
        return folio;
    }
}
