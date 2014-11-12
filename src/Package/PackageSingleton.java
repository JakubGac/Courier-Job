package Package;

import java.util.Vector;

public class PackageSingleton {
	private static PackageSingleton instance = null;
	private Vector<Package> packagesList;
	
	private PackageSingleton(){
		packagesList = new Vector<Package>();
	}
	
	public static synchronized PackageSingleton getInstance(){
		if(instance == null){
			instance = new PackageSingleton();
			return instance;
		}
		return instance;
	}
	
	public void addPackage(Package p){
		packagesList.addElement(p);
	}
	
	@Override
	public String toString(){
		return packagesList.toString();
	}
}