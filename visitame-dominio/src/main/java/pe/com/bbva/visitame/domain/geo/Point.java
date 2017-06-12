package pe.com.bbva.visitame.domain.geo;

import com.google.maps.model.LatLng;

public class Point {
	double mLat;
	double mLng;
	
	private LatLng mLatLng = null;

	public Point(double lat,double lng) {
		super();
		this.mLat = lat;
		this.mLng=lng;
	}

	public LatLng getLatLng() {
		if (mLatLng == null) {
			mLatLng = new LatLng(mLat,mLng);
		}
		return mLatLng;
	}
	
	@Override
	public String toString() {
		return "["+mLat+","+mLng+"]";
	}
}
