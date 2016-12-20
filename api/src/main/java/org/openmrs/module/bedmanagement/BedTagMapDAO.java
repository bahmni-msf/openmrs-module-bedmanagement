package org.openmrs.module.bedmanagement;

public interface BedTagMapDAO {

    BedTagMap assignTagToBed(Bed bed, BedTag bedTag);

    BedTag getBedTagByUuid(String bed_tag_uuid);
}
