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

import org.openmrs.Encounter;
import org.openmrs.Patient;
import org.openmrs.api.context.Context;
import org.openmrs.module.bedmanagement.Bed;
import org.openmrs.module.bedmanagement.BedDetails;
import org.openmrs.module.bedmanagement.BedManagementService;
import org.openmrs.module.bedmanagement.BedTag;
import org.openmrs.module.bedmanagement.BedTagMap;
import org.openmrs.module.bedmanagement.BedTagMapService;
import org.openmrs.module.webservices.rest.SimpleObject;
import org.openmrs.module.webservices.rest.web.ConversionUtil;
import org.openmrs.module.webservices.rest.web.RequestContext;
import org.openmrs.module.webservices.rest.web.RestConstants;
import org.openmrs.module.webservices.rest.web.annotation.Resource;
import org.openmrs.module.webservices.rest.web.representation.DefaultRepresentation;
import org.openmrs.module.webservices.rest.web.representation.FullRepresentation;
import org.openmrs.module.webservices.rest.web.representation.RefRepresentation;
import org.openmrs.module.webservices.rest.web.representation.Representation;
import org.openmrs.module.webservices.rest.web.resource.api.PageableResult;
import org.openmrs.module.webservices.rest.web.resource.impl.AlreadyPaged;
import org.openmrs.module.webservices.rest.web.resource.impl.DelegatingCrudResource;
import org.openmrs.module.webservices.rest.web.resource.impl.DelegatingResourceDescription;
import org.openmrs.module.webservices.rest.web.response.ResourceDoesNotSupportOperationException;
import org.openmrs.module.webservices.rest.web.response.ResponseException;

import java.util.Arrays;

@Resource(name = RestConstants.VERSION_1 + "/bedTagMap", supportedClass = BedTagMap.class, supportedOpenmrsVersions = {"1.9.*", "1.10.*", "1.11.*", "1.12.*"})
public class BedTagMapResource extends DelegatingCrudResource {

    @Override
    public BedTagMap getByUniqueId(String uniqueId) {
        return null;
    }

    @Override
    protected void delete(Object delegate, String reason, RequestContext context) throws ResponseException {

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
    public BedTagMap create(SimpleObject propertiesToCreate, RequestContext requestContext) {
        BedTagMapService bedTagMapService = Context.getService(BedTagMapService.class);
        Bed bed = bedTagMapService.getBedByUuid((String) propertiesToCreate.get("bed_uuid"));
        BedTag bedTag = bedTagMapService.getBedTagByUuid((String) propertiesToCreate.get("bed_tag_uuid"));
        return bedTagMapService.save(bed, bedTag);
    }
}
