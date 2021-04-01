package de.claudioaltamura.java.java15;

public sealed class Vehicle permits Car, Bike {

	protected final String registrationNumber;

	public Vehicle(String registrationNumber) {
		this.registrationNumber = registrationNumber;
	}

	public String getRegistrationNumber() {
		return registrationNumber;
	}

}
