package org.app.travelmode.model;

import org.app.travelmode.directions.LatLng;

import java.util.ArrayList;
import java.util.List;

public class PolylineDecoder {

    public PolylineDecoder(){
    }

    /**
     * Decodes a polyline into a list of coordinates.
     *
     * @param encodedPolyline The encoded polyline.
     * @return A list of LatLngs representing the points on the polyline.
     */
    public static List<LatLng> decode(final String encodedPolyline){
        final List<LatLng> polyline = new ArrayList<>();
        int index = 0;
        int len = encodedPolyline.length();
        int lat = 0;
        int lng = 0;

        while (index < len) {
            int shift = 0;
            int result = 0;
            int b;
            do {
                b = encodedPolyline.charAt(index++) - 63;
                result |= (b & 0x1F) << shift;
                shift += 5;
            } while (b >= 0x20);
            int deltaLat = ((result & 1) != 0 ? ~(result >> 1) : (result >> 1));
            lat += deltaLat;

            shift = 0;
            result = 0;
            do {
                b = encodedPolyline.charAt(index++) - 63;
                result |= (b & 0x1F) << shift;
                shift += 5;
            } while (b >= 0x20);
            int deltaLng = ((result & 1) != 0 ? ~(result >> 1) : (result >> 1));
            lng += deltaLng;

            polyline.add(new LatLng(lat / 1e5, lng / 1e5));
        }

        return polyline;
    }
}
