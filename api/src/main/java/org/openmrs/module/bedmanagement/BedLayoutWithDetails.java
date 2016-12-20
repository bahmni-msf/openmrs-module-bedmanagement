package org.openmrs.module.bedmanagement;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@JsonIgnoreProperties({"patient"})
public class BedLayoutWithDetails {
    private Integer rowNumber;
    private Integer columnNumber;
    private String location;
    private Bed bed;

    public Integer getRowNumber() {
        return rowNumber;
    }

    public void setRowNumber(Integer rowNumber) {
        this.rowNumber = rowNumber;
    }

    public Integer getColumnNumber() {
        return columnNumber;
    }

    public void setColumnNumber(Integer columnNumber) {
        this.columnNumber = columnNumber;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Bed getBed() {
        return bed;
    }

    public void setBed(Bed bed) {
        this.bed = bed;
    }

    public BedLayout convertToBedLayout() {
        BedLayout bedLayout = new BedLayout();
        bedLayout.setRowNumber(this.rowNumber);
        bedLayout.setColumnNumber(this.columnNumber);
        bedLayout.setLocation(this.location);
        bedLayout.setBedNumber(this.bed.getBedNumber());
        bedLayout.setBedId(this.bed.getId());
        bedLayout.setStatus(this.bed.getStatus());
        bedLayout.setBedType(this.bed.getBedType());
        Set<String> bedTagList = new HashSet<>();
        for(BedTagMap bedTagMap : this.bed.getBedTagMap()) {
            bedTagList.add(bedTagMap.getBedTag().getName());
        }
        bedLayout.setTags(bedTagList);
        return bedLayout;
    }
}
