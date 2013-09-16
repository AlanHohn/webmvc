package org.anvard.webmvc.googleplaces;


import java.util.List;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Place {
    private Geometry geometry;
    private String icon;
    private String id;
    private String name;
    private double rating;
    private OpeningHours opening_hours;
    private String reference;
    private List<String> types;
    private String vicinity;
    
    public Geometry getGeometry() {
        return geometry;
    }
    
    public void setGeometry(Geometry geometry) {
        this.geometry = geometry;
    }
    
    public String getIcon() {
        return icon;
    }
    
    public void setIcon(String icon) {
        this.icon = icon;
    }
    
    public String getId() {
        return id;
    }
    
    public void setId(String id) {
        this.id = id;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public double getRating() {
        return rating;
    }
    
    public void setRating(double rating) {
        this.rating = rating;
    }
    
    
    public OpeningHours getOpening_hours() {
        return opening_hours;
    }

    
    public void setOpening_hours(OpeningHours opening_hours) {
        this.opening_hours = opening_hours;
    }

    public String getReference() {
        return reference;
    }
    
    public void setReference(String reference) {
        this.reference = reference;
    }
    
    public List<String> getTypes() {
        return types;
    }
    
    public void setTypes(List<String> types) {
        this.types = types;
    }
    
    public String getVicinity() {
        return vicinity;
    }
    
    public void setVicinity(String vicinity) {
        this.vicinity = vicinity;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("  Geometry: " + geometry + "\n");
        sb.append("  Icon: " + icon + "\n");
        sb.append("  Id: " + id + "\n");
        sb.append("  Name: " + name + "\n");
        sb.append("  Rating: " + rating + "\n");
        sb.append("  Opening Hours: " + opening_hours + "\n");
        sb.append("  Reference: " + reference + "\n");
        sb.append("  Vicinity: " + vicinity + "\n");
        if (null != types) {
            sb.append("  Types: ");
            for (String type: types) {
                sb.append(type + " ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }
    
}