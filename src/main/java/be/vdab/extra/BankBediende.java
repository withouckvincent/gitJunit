package be.vdab.extra;

import be.vdab.extra.Rekening;
import be.vdab.extra.Spaarrekening;
import be.vdab.extra.Zichtrekening;
import be.vdab.extra.RekeningNummerException;

/**
 *
 * @author Vincent Media 
 */
public class BankBediende {
    public static void main(String[] args) {
    Rekening[] rekeningen = new Rekening[7];
    
    try {
        rekeningen[0] = new Spaarrekening("BE68 1234 5678 9002", 1.5);
        rekeningen[0].storten(100.0);        
        System.out.println("afhalen");
        rekeningen[0].afhalen(400.0);
        System.out.println("afhalen3");
    }
    catch (RekeningNummerException ex) {
        System.out.println(ex.getMessage() + ": " + ex.getFoutRekeningNummer() );
    }
    
    try {
        rekeningen[1] = new Zichtrekening(null, 1500);
        rekeningen[1].storten(200.0);
    }
        catch (RekeningNummerException ex) {
        System.out.println(ex.getMessage() + ": " + ex.getFoutRekeningNummer() );
    }
    
    try {
        rekeningen[2] = new Zichtrekening("BE68 1234 5678 9103", 2000);
        rekeningen[2].storten(300.0);
        
    }
    
        catch (RekeningNummerException ex) {
        System.out.println(ex.getMessage() + ": " + ex.getFoutRekeningNummer() );
    }
    
    try {
        rekeningen[3] = new Zichtrekening("", 1500);
        rekeningen[3].storten(400.0);
    }
        catch (RekeningNummerException ex) {
        System.out.println(ex.getMessage() + ": " + ex.getFoutRekeningNummer() );
    }
    
    try {
        rekeningen[4] = new Zichtrekening("AB68 1234", 1500);
        rekeningen[6] = new Zichtrekening(null, 1500);
        rekeningen[4].storten(500.0);
    }
    
        catch (RekeningNummerException ex) {
        System.out.println(ex.getMessage() + ": " + ex.getFoutRekeningNummer() );
    }
    
    try {
        rekeningen[5] = new Zichtrekening("BEZZ 1112 2444 4891", 1500);
        rekeningen[5].storten(600.0);
    }
        catch (RekeningNummerException ex) {
        System.out.println(ex.getMessage() + ": " + ex.getFoutRekeningNummer() );
    }
    
    try {
        rekeningen[6] = new Spaarrekening("BE68 1234 5678 9204", 1.5);
        rekeningen[6].storten(400.0);
    }
        catch (RekeningNummerException ex) {
        System.out.println(ex.getMessage() + ": " + ex.getFoutRekeningNummer() );
    }
    
    for (Rekening rekening: rekeningen) {
        if (rekening != null) {
            System.out.println("\n" + rekening + "\nSaldo van de " +
            "rekening: " + rekening.getSaldo());
            }
        }
    }
}