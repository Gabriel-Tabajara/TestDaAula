package pucrs.myflight.modelo;

public class Geo {
	private double latitude;
	private double longitude;
	
	public Geo(double latitude, double longitude) {
		this.latitude = latitude;
		this.longitude = longitude;
	}
	
	public double getLatitude() {
		return latitude;
	}
	
	public double getLongitude() {
		return longitude;
	}

	public String toString() {
		return String.format("%f, %f",latitude, longitude);
	}

	public static double distancia(Geo g1, Geo g2){
		int raioTerra = 6371;

		double latitudeG1 = Math.toRadians(g1.getLatitude());
		double latitudeG2 = Math.toRadians(g2.getLatitude());
		double longitudeG1 = Math.toRadians(g1.getLongitude());
		double longitudeG2 = Math.toRadians(g2.getLongitude());

		double p1 = 2 * raioTerra;
		double p2 = Math.pow(Math.sin((latitudeG1 - latitudeG2) / 2), 2);
		double p3 = Math.pow(Math.sin((longitudeG1 - longitudeG2) / 2), 2);
		double p4 = Math.cos(latitudeG1) * Math.cos(latitudeG2);

		double distancia = p1 * Math.asin(Math.sqrt(p2 + p3 * p4)) ;
		return distancia;
	}

	public double distancia(Geo g1){
		Geo g2 = new Geo(latitude, longitude);
		return distancia(g1, g2);
	}
}
