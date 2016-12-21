/**
 * The contents of this file are subject to the OpenMRS Public License
 * Version 1.0 (the "License"); you may not use this file except in
 * compliance with the License. You may obtain a copy of the License at
 * http://license.openmrs.org
 *
 * Software distributed under the License is distributed on an "AS IS"
 * basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
 * License for the specific language governing rights and limitations
 * under the License.
 *
 * Copyright (C) OpenMRS, LLC.  All Rights Reserved.
 */
package org.openmrs.module.bedmanagement.rest.resource;

import org.openmrs.api.context.Context;
import org.openmrs.module.bedmanagement.Bed;
import org.openmrs.module.bedmanagement.BedTag;
import org.openmrs.module.bedmanagement.BedTagMap;
import org.openmrs.module.bedmanagement.BedTagMapService;
import org.openmrs.module.webservices.rest.SimpleObject;
import org.openmrs.module.webservices.rest.web.RequestContext;
import org.openmrs.module.webservices.rest.web.RestConstants;
import org.openmrs.module.webservices.rest.web.annotation.Resource;
import org.openmrs.module.webservices.rest.web.representation.Representation;
import org.openmrs.module.webservices.rest.web.resource.impl.DelegatingCrudResource;
import org.openmrs.module.webservices.rest.web.resource.impl.DelegatingResourceDescription;
import org.openmrs.module.webservices.rest.web.response.ResponseException;

@Resource(name = RestConstants.VERSION_1 + "/bedTagMap", supportedClass = BedTagMap.class, supportedOpenmrsVersions = {"1.9.*", "1.10.*", "1.11.*", "1.12.*"})
public class BedTagMapResource extends DelegatingCrudResource {

    @Override
    public BedTagMap getByUniqueId(String uniqueId) {
        BedTagMapService bedTagMapService = Context.getService(BedTagMapService.class);
        return bedTagMapService.getBedTagMapByUuid(uniqueId);
    }

    @Override
    protected void delete(Object delegate, String reason, RequestContext context) throws ResponseException {
        BedTagMapService bedTagMapService = Context.getService(BedTagMapService.class);
        bedTagMapService.delete((BedTagMap) delegate, reason);
    }

    @Override
    public Object newDelegate() {
        return null;
    }

    @Override
    public Object save(Object delegate) {
        return null;
    }

    @Override
    public void purge(Object delegate, RequestContext context) throws ResponseException {

    }

    @Override
    public DelegatingResourceDescription getRepresentationDescription(Representation rep) {
        return null;
    }

    @Override
    public BedTagMap create(SimpleObject propertiesToCreate, RequestContext requestContext) throws ResponseException {
        BedTagMapService bedTagMapService = Context.getService(BedTagMapService.class);
        Bed bed = bedTagMapService.getBedByUuid((String) propertiesToCreate.get("bed_uuid"));
        BedTag bedTag = bedTagMapService.getBedTagByUuid((String) propertiesToCreate.get("bed_tag_uuid"));
        return bedTagMapService.save(bed, bedTag);
    }
}
