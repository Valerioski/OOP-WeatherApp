package org.app.travelmode.controller;

import org.app.travelmode.model.TravelRequestImpl;
import org.app.travelmode.placeautocomplete.PlaceAutocompletePrediction;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public interface TravelModeController {

    /**
     * Provides a list of {@link PlaceAutocompletePrediction} based on the input text
     *
     * @param input String representing the characters written by the user
     * @return a list of predictions based on the input
     */
    List<PlaceAutocompletePrediction> getPlacePredictions(final String input);

    /**
     * Set the departure location
     *
     * @param departureLocation the name of the departure location
     * @return this builder, for method chaining
     */
    TravelRequestImpl.Builder setDepartureLocation(final String departureLocation);

    /**
     * Set the PlaceId associated with the starting location
     *
     * @param departurePlaceId the PlaceId associated with the starting location
     * @return this builder, for method chaining
     */
    TravelRequestImpl.Builder setDeparturePlaceId(final String departurePlaceId);

    /**
     * Set the arrival location
     *
     * @param arrivalLocation the name of the arrival location
     * @return this builder, for method chaining
     */
    TravelRequestImpl.Builder setArrivalLocation(final String arrivalLocation);

    /**
     * Set the PlaceId associated with the arrival location
     *
     * @param arrivalPlaceId the PlaceId associated with the arrival location
     * @return this builder, for method chaining
     */
    TravelRequestImpl.Builder setArrivalPlaceId(final String arrivalPlaceId);

    /**
     * Set the departure time
     *
     * @param departureTime the departure time
     * @return this builder, for method chaining
     */
    TravelRequestImpl.Builder setDepartureTime(final LocalTime departureTime);

    /**
     * Set the departure date
     *
     * @param departureDate the departure date
     * @return this builder, for method chaining
     */
    TravelRequestImpl.Builder setDepartureDate(final LocalDate departureDate);

    /**
     * Start the analysis of possible routes between the inserted places
     */
    void startRouteAnalysis();

}
