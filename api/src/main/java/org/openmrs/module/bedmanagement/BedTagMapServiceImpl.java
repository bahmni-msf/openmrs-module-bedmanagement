package org.openmrs.module.bedmanagement;


import org.openmrs.api.context.Context;
import org.openmrs.api.impl.BaseOpenmrsService;

public class BedTagMapServiceImpl extends BaseOpenmrsService implements BedTagMapService{

    BedTagMapDAO dao;

    public void setDao(BedTagMapDAO dao) {
        this.dao = dao;
    }

    @Override
    public BedTagMap save(Bed bed, BedTag bedTag) {
        return dao.assignTagToBed(bed, bedTag);
    }

    @Override
    public Bed getBedByUuid(String bed_uuid) {
        BedManagementService bedManagementService = Context.getService(BedManagementService.class);
        BedDetails bedDetails = bedManagementService.getBedDetailsByUuid(bed_uuid);
        return bedDetails.getBed();
    }

    @Override
    public BedTag getBedTagByUuid(String bed_tag_uuid) {
        return dao.getBedTagByUuid(bed_tag_uuid);
    }
}
