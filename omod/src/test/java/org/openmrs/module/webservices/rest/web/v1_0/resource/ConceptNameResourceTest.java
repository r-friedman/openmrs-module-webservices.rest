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
package org.openmrs.module.webservices.rest.web.v1_0.resource;

import org.openmrs.module.webservices.rest.web.v1_0.resource.ConceptNameResource;
import org.openmrs.ConceptName;
import org.openmrs.api.context.Context;
import org.openmrs.module.webservices.rest.web.resource.impl.BaseDelegatingResourceTest;

public class ConceptNameResourceTest extends BaseDelegatingResourceTest<ConceptNameResource, ConceptName> {
	
	@Override
	public ConceptName newObject() {
		return Context.getConceptService().getConceptNameByUuid(getUuidProperty());
	}
	
	@Override
	public void validateDefaultRepresentation() throws Exception {
		super.validateDefaultRepresentation();
		assertPropEquals("name", getObject().getName());
		assertPropEquals("locale", getObject().getLocale());
		assertPropEquals("localePreferred", getObject().getLocalePreferred());
		assertPropEquals("conceptNameType", getObject().getConceptNameType());
	}
	
	@Override
	public void validateFullRepresentation() throws Exception {
		super.validateFullRepresentation();
		assertPropEquals("name", getObject().getName());
		assertPropEquals("locale", getObject().getLocale());
		assertPropEquals("localePreferred", getObject().getLocalePreferred());
		assertPropEquals("conceptNameType", getObject().getConceptNameType());
		assertPropPresent("auditInfo");
	}
	
	@Override
	public String getDisplayProperty() {
		return "YES";
	}
	
	@Override
	public String getUuidProperty() {
		return ResourceTestConstants.CONCEPT_NAME_UUID;
	}
	
}
