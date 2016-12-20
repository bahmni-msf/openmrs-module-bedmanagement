package org.openmrs.module.bedmanagement;

import org.openmrs.api.OpenmrsService;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface BedTagMapService extends OpenmrsService{
    BedTagMap save(Bed bed, BedTag bedTag);

    Bed getBedByUuid(String bed_uuid);

    BedTag getBedTagByUuid(String bed_tag_uuid);
}
