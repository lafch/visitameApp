package pe.com.bbva.visitame.domain.geo;


import java.util.ArrayList;
import java.util.List;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import com.google.maps.model.LatLng;
public class UbicationParser {

	public List<Direction> parse(JSONObject jObject) {
		
		List<Direction> directionsList = null;
		Direction currentGDirection = null;
		List<Legs> legs = null;	
		Legs currentLeg = null;
		List<Path> paths = null;
		Path currentPath = null;
		JSONArray jRoutes = null;
		JSONObject jRoute;
		JSONObject jBound;
		JSONArray jLegs = null;
		JSONObject jLeg;
		JSONArray jSteps = null;
		JSONObject jStep;
		String polyline = "";
		
		try {
			jRoutes = jObject.getJSONArray("routes");
			directionsList = new ArrayList<Direction>();
			
			for (int i = 0; i < jRoutes.length(); i++) {
				jRoute=(JSONObject) jRoutes.get(i);
				jLegs = jRoute.getJSONArray("legs");
				legs = new ArrayList<Legs>();
				
				for (int j = 0; j < jLegs.length(); j++) {
					jLeg=(JSONObject) jLegs.get(j);
					jSteps = jLeg.getJSONArray("steps");
					paths = new ArrayList<Path>();
					
					for (int k = 0; k < jSteps.length(); k++) {
						jStep = (JSONObject) jSteps.get(k);
						polyline = (String) ((JSONObject) (jStep).get("polyline")).get("points");
						List<Point> list = decodePoly(polyline);
						currentPath = new Path(list);
						currentPath.setDistance(((JSONObject)jStep.get("distance")).getInt("value"));
						currentPath.setDuration(((JSONObject)jStep.get("duration")).getInt("value"));
						currentPath.setHtmlText(jStep.getString("html_instructions"));
						currentPath.setTravelMode(jStep.getString("travel_mode"));
						paths.add(currentPath);
					}
					
					currentLeg = new Legs(paths);
					currentLeg.setmDistance(((JSONObject)jLeg.get("distance")).getInt("value"));
					currentLeg.setmDuration(((JSONObject)jLeg.get("duration")).getInt("value"));
					currentLeg.setmEndAddress(jLeg.getString("end_address"));
					currentLeg.setmStartAddress(jLeg.getString("start_address"));
					legs.add(currentLeg);
				}
				
				currentGDirection = new Direction(legs);
				jBound=(JSONObject)jRoute.get("bounds");
				currentGDirection.setmNorthEastBound(new LatLng(
						((JSONObject)jBound.get("northeast")).getDouble("lat"),
						((JSONObject)jBound.get("northeast")).getDouble("lng")));
				currentGDirection.setmSouthWestBound(new LatLng(
						((JSONObject)jBound.get("southwest")).getDouble("lat"),
						((JSONObject)jBound.get("southwest")).getDouble("lng")));
				currentGDirection.setCopyrights(jRoute.getString("copyrights"));
				directionsList.add(currentGDirection);
			}

		} catch (JSONException e) {
			return null;
		} catch (Exception e) {
			return null;
		}
		return directionsList;
	}

	private List<Point> decodePoly(String encoded) {

		List<Point> poly = new ArrayList<Point>();
		int index = 0, len = encoded.length();
		int lat = 0, lng = 0;

		while (index < len) {
			int b, shift = 0, result = 0;
			do {
				b = encoded.charAt(index++) - 63;
				result |= (b & 0x1f) << shift;
				shift += 5;
			} while (b >= 0x20);
			int dlat = ((result & 1) != 0 ? ~(result >> 1) : (result >> 1));
			lat += dlat;

			shift = 0;
			result = 0;
			do {
				b = encoded.charAt(index++) - 63;
				result |= (b & 0x1f) << shift;
				shift += 5;
			} while (b >= 0x20);
			int dlng = ((result & 1) != 0 ? ~(result >> 1) : (result >> 1));
			lng += dlng;
			poly.add(new Point((double) lat / 1E5, (double) lng / 1E5));
		}

		return poly;
	}
}
