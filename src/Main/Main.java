package Main;

import ReadFiles.*;
import AssigningPackages.*;

public class Main {
	public static void main(String[] args) throws ErrorHandling, InterruptedException {
		long start = System.nanoTime();
		
		//wczytywanie danych z plików
		ReadFile cities = new Cities();
		ReadFile connections = new Connections();
		ReadFile packages = new Packages();
		cities.read();
		connections.read();
		packages.read();
		
		//tutaj wszystko się dzieje 
		FindPackage findPackage = new FindPackage(1,5);
		findPackage.find();
		
		long czas = ((System.nanoTime() - start)/1000);
		System.out.println("Czas działania programu: " + czas);
	}
}
  