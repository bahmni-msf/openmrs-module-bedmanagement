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
package org.openmrs.module.bedmanagement;

import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;

import java.util.HashSet;
import java.util.Set;


public class HibernateBedTagMapDAO implements BedTagMapDAO {
    SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public BedTagMap assignTagToBed(Bed bed, BedTag bedTag) {
        Session session = sessionFactory.getCurrentSession();
        BedTagMap bedTagMap = new BedTagMap();
        bedTagMap.setBed(bed);
        bedTagMap.setBedTag(bedTag);
        session.saveOrUpdate(bedTagMap);
        return bedTagMap;
    }

    @Override
    public BedTag getBedTagByUuid(String bed_tag_uuid) {
        return (BedTag) sessionFactory.getCurrentSession()
                .createQuery("from BedTag where uuid = :uuid")
                .setParameter("uuid", bed_tag_uuid).uniqueResult();
    }
}
