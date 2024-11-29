package org.app.travelmode.directions;

import java.util.List;

public class DirectionsRoute {

    private Bounds bounds;
    private List<DirectionsLeg> legs;
    private DirectionsPolyline overview_polyline;
    private String summary;

    public Bounds getBounds() {
        return this.bounds;
    }

    public List<DirectionsLeg> getLegs() {
        return this.legs;
    }

    public DirectionsPolyline getOverview_polyline() {
        return this.overview_polyline;
    }

    public String getSummary() {
        return this.summary;
    }

    @Override
    public String toString() {
        return "{Bounds: " + bounds + "\nOverview Polyline: " + overview_polyline +
                "\nSummary: " + summary + "\nLegs: " + legs + "}";
    }


    public static class Bounds {
        private LatLngLiteral northeast;
        private LatLngLiteral southwest;

        public LatLngLiteral getNortheast() {
            return this.northeast;
        }

        public LatLngLiteral getSouthwest() {
            return this.southwest;
        }

        @Override
        public String toString() {
            return "{North-East: " + northeast + "\nSouth-West: " + southwest + "}";
        }
    }
}