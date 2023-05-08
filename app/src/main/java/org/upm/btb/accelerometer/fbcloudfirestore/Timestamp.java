package org.upm.btb.accelerometer.fbcloudfirestore;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Timestamp {
    private String dia;
    private String mes;
    private String anio;
    private String hora;
    private long timestamp;

    public static final String KEY_DIA="dia";
    public static final String KEY_MES="mes";
    public static final String KEY_ANYO="anio";
    public static final String KEY_HORA="hora";
    public static final String KEY_TIMESTAMP ="timestamp";

    public Timestamp(String dia, String mes, String anio, String hora, long timestamp) {
        this.dia = dia;
        this.mes = mes;
        this.anio = anio;
        this.hora = hora;
        this.timestamp = timestamp;
    }

    public Timestamp(Map<String,Object> tsMap){
        setDia((String)tsMap.get(KEY_DIA));
        setMes((String)tsMap.get(KEY_MES));
        setAnio((String)tsMap.get(KEY_ANYO));
        setHora((String)tsMap.get(KEY_HORA));
        setTimestamp((Long)tsMap.get(KEY_TIMESTAMP));
    }

    public Timestamp(){
        Date d = new Date();
        SimpleDateFormat sdfD = new SimpleDateFormat("dd");
        SimpleDateFormat sdfM = new SimpleDateFormat("MMMM");
        SimpleDateFormat sdfY = new SimpleDateFormat("yyyy");
        SimpleDateFormat sdfHMS = new SimpleDateFormat("HH:mm:ss");

        setDia(sdfD.format(d));
        setMes(sdfM.format(d));
        setAnio(sdfY.format(d));
        setHora(sdfHMS.format(d));
        setTimestamp(d.getTime());
    }

    public Map<String,Object> getTimestampMap(){
        Map<String,Object> m = new HashMap<>();
        m.put(KEY_DIA, getDia());
        m.put(KEY_MES, getMes());
        m.put(KEY_ANYO, getAnio());
        m.put(KEY_HORA, getHora());
        m.put(KEY_TIMESTAMP, getTimestamp());

        return m;
    }

    public String getFormattedTimestamp(){
        return getAnio()+"/"+getMes()+"/"+getDia()+" "+getHora();
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public String getMes() {
        return mes;
    }

    public void setMes(String mes) {
        this.mes = mes;
    }

    public String getAnio() {
        return anio;
    }

    public void setAnio(String anio) {
        this.anio = anio;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }



}
