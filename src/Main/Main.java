package Main;

import ReadFiles.*;
import AssigningPackages.*;

public class Main {
	public static void main(String[] args) throws ErrorHandling, InterruptedException {
		
		//wczytywanie danych z plików
		ReadFile cities = new Cities();
		ReadFile connections = new Connections();
		ReadFile packages = new Packages();
		cities.read();
		connections.read();
		packages.read();
		
		//tutaj wszystko się dzieje 
		FindPackage findPackage = new FindPackage(3,1);
		findPackage.find();
		
	}
}
  