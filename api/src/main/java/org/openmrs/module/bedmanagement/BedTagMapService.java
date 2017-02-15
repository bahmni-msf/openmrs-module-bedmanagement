package org.openmrs.module.bedmanagement;

import org.openmrs.api.OpenmrsService;
import org.openmrs.module.webservices.rest.web.response.IllegalPropertyException;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface BedTagMapService extends OpenmrsService{
    BedTagMap save(BedTagMap bedTagMap) throws IllegalPropertyException;

    void delete(BedTagMap bedTagMap, String reason);

    BedTagMap getBedTagMapByUuid(String bedTagMapUuid);

    BedTagMap getBedTagMapWithBedAndTag(Bed bed, BedTag bedTag);

    Bed getBedByUuid(String bed_uuid);

    BedTag getBedTagByUuid(String bedTagUuid);
}
