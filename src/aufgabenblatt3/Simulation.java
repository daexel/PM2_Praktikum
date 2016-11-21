package aufgabenblatt3;

import java.util.Observable;


public class Simulation extends Observable implements Runnable{

	private Rangierbahnhof rangierbahnhof;
	
	public static void main(String[]args){
		
		Thread simulation = new Thread(new Simulation());
	    simulation.start();
	}

	@Override
	public void run() {
		rangierbahnhof = new Rangierbahnhof(15);
		 while (!Thread.interrupted()){
		      try {
		        Thread.sleep(1000);
		      }catch (InterruptedException e){
		        e.printStackTrace();
		        return;
		      }
		      int zufallRichtung = (int) (Math.random()*2);
		      System.out.println(zufallRichtung);
		      int gleis = (int) (Math.random()*rangierbahnhof.getAnzahlGleise());
		      System.out.println(gleis);
		      boolean fahrtrichtung=true;
		      if(zufallRichtung<=0){
		    	  fahrtrichtung=false;
		      }
		      new Lokfuehrer(gleis, rangierbahnhof, fahrtrichtung).start();
		      
		}
	}
}
