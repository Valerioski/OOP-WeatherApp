package org.app.travelmode.model;

import java.time.LocalDate;
import java.time.LocalTime;

public class TravelRequestImpl implements TravelRequest {

    private final String departureLocation;
    private final String departurePlaceId;
    private final String arrivalLocation;
    private final String arrivalPlaceId;
    private final LocalTime departureTime;
    private final LocalDate departureDate;

    private TravelRequestImpl(final String departureLocation, final String departurePlaceId, final String arrivalLocation, final String arrivalPlaceId, final LocalTime departureTime, final LocalDate departureDate) {
        this.departureLocation = departureLocation;
        this.departurePlaceId = departurePlaceId;
        this.arrivalLocation = arrivalLocation;
        this.arrivalPlaceId = arrivalPlaceId;
        this.departureTime = departureTime;
        this.departureDate = departureDate;
    }

    @Override
    public String getDepartureLocation() {
        return this.departureLocation;
    }

    @Override
    public String getDepartureLocationPlaceId() {
        return this.departurePlaceId;
    }

    @Override
    public String getArrivalLocation() {
        return this.arrivalLocation;
    }

    @Override
    public String getArrivalLocationPlaceId() {
        return this.arrivalPlaceId;
    }

    @Override
    public LocalTime getDepartureTime() {
        return this.departureTime;
    }

    @Override
    public LocalDate getDepartureDate() {
        return this.departureDate;
    }

    public boolean isConsistent() {
        return departureLocation != null && !departureLocation.isBlank()
                && departurePlaceId != null && !departurePlaceId.isBlank()
                && arrivalLocation != null && !arrivalLocation.isBlank()
                && arrivalPlaceId != null && !arrivalPlaceId.isBlank()
                && departureTime != null && departureDate != null;
    }


    /**
     * Constructor class of a TravelReqestImpl object
     */
    public static class TravelRequestBuilder {

        private static final LocalTime DEPARTURE_TIME = LocalTime.now();
        private static final LocalDate DEPARTURE_DATE = LocalDate.now();

        private String departureLocation;
        private String departurePlaceId;
        private String arrivalLocation;
        private String arrivalPlaceId;
        private LocalTime departureTime = DEPARTURE_TIME;
        private LocalDate departureDate = DEPARTURE_DATE;
        private boolean consumed;

        /**
         * Set the departure location
         *
         * @param departureLocation the name of the departure location
         * @return this builder, for method chaining
         */
        public TravelRequestBuilder setDepartureLocation(final String departureLocation) {
            this.departureLocation = departureLocation;
            return this;
        }

        /**
         * Set the PlaceId associated with the starting location
         *
         * @param departurePlaceId the PlaceId associated with the starting location
         * @return this builder, for method chaining
         */
        public TravelRequestBuilder setDeparturePlaceId(final String departurePlaceId) {
            this.departurePlaceId = departurePlaceId;
            return this;
        }

        /**
         * Set the arrival location
         *
         * @param arrivalLocation the name of the arrival location
         * @return this builder, for method chaining
         */
        public TravelRequestBuilder setArrivalLocation(final String arrivalLocation) {
            this.arrivalLocation = arrivalLocation;
            return this;
        }

        /**
         * Set the PlaceId associated with the arrival location
         *
         * @param arrivalPlaceId the PlaceId associated with the arrival location
         * @return this builder, for method chaining
         */
        public TravelRequestBuilder setArrivalPlaceId(final String arrivalPlaceId) {
            this.arrivalPlaceId = arrivalPlaceId;
            return this;
        }

        /**
         * Set the departure time
         *
         * @param departureTime the departure time
         * @return this builder, for method chaining
         */
        public TravelRequestBuilder setDepartureTime(final LocalTime departureTime) {
            this.departureTime = departureTime;
            return this;
        }

        /**
         * Set the departure date
         *
         * @param departureDate the departure date
         * @return this builder, for method chaining
         */
        public TravelRequestBuilder setDepartureDate(final LocalDate departureDate) {
            this.departureDate = departureDate;
            return this;
        }

        /**
         * @return a TravelRequestImpl
         */
        public final TravelRequestImpl build() {
            if (consumed) {
                throw new IllegalStateException("The builder can only be used once");
            }
            consumed = true;
            return new TravelRequestImpl(departureLocation, departurePlaceId, arrivalLocation, arrivalPlaceId, departureTime, departureDate);
        }
    }
}
