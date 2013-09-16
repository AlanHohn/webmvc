package org.anvard.webmvc.googleplaces;

import java.util.List;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PlaceResponse {

    private List<String> html_attributions;
    private List<Place> results;
    private String status;
    
    
    public List<String> getHtml_attributions() {
        return html_attributions;
    }


    
    public void setHtml_attributions(List<String> html_attributions) {
        this.html_attributions = html_attributions;
    }


    public List<Place> getResults() {
        return results;
    }

    
    public void setResults(List<Place> results) {
        this.results = results;
    }

    
    public String getStatus() {
        return status;
    }

    
    public void setStatus(String status) {
        this.status = status;
    }
    
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Status: " + status + "\n");
        if (null != html_attributions) {
            sb.append("Attributions:\n");
            for (String attr: html_attributions) {
                sb.append("  " + attr + "\n");
            }
        }
        if (null != results) {
            sb.append("Places:\n");
            for (Place place: results) {
                sb.append(place.toString() + "\n");
            }
        }
        return sb.toString();
    }
}
