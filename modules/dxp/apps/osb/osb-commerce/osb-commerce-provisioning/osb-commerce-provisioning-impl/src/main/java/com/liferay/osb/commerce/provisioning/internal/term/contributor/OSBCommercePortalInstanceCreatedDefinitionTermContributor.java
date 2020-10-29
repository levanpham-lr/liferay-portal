/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * The contents of this file are subject to the terms of the Liferay Enterprise
 * Subscription License ("License"). You may not use this file except in
 * compliance with the License. You can obtain a copy of the License by
 * contacting Liferay, Inc. See the License for the specific language governing
 * permissions and limitations under the License, including but not limited to
 * distribution rights of the Software.
 *
 *
 *
 */

package com.liferay.osb.commerce.provisioning.internal.term.contributor;

import com.liferay.commerce.constants.CommerceDefinitionTermConstants;
import com.liferay.commerce.model.CommerceSubscriptionEntry;
import com.liferay.commerce.order.CommerceDefinitionTermContributor;
import com.liferay.osb.commerce.provisioning.constants.OSBCommerceNotificationConstants;
import com.liferay.osb.commerce.provisioning.constants.OSBCommercePortalInstanceConstants;
import com.liferay.osb.commerce.provisioning.util.OSBCommercePortalInstance;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.util.HashMapBuilder;
import com.liferay.portal.kernel.util.ResourceBundleUtil;
import com.liferay.portal.kernel.util.UnicodeProperties;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Ivica Cardic
 */
@Component(
	immediate = true,
	property = {
		"commerce.definition.term.contributor.key=" + OSBCommercePortalInstanceCreatedDefinitionTermContributor.KEY,
		"commerce.notification.type.key=" + OSBCommerceNotificationConstants.PORTAL_INSTANCE_CREATED
	},
	service = CommerceDefinitionTermContributor.class
)
public class OSBCommercePortalInstanceCreatedDefinitionTermContributor
	implements CommerceDefinitionTermContributor {

	public static final String KEY =
		CommerceDefinitionTermConstants.
			BODY_AND_SUBJECT_DEFINITION_TERMS_CONTRIBUTOR;

	@Override
	public Map<String, String> getDefinitionTerms(Locale locale) {
		Map<String, String> map = new HashMap<>();

		List<String> terms = getTerms();

		for (String term : terms) {
			map.put(term, getLabel(term, locale));
		}

		return map;
	}

	@Override
	public String getFilledTerm(String term, Object object, Locale locale)
		throws PortalException {

		if (!(object instanceof CommerceSubscriptionEntry)) {
			return term;
		}

		if (term.equals(_PORTAL_INSTANCE_URL)) {
			CommerceSubscriptionEntry commerceSubscriptionEntry =
				(CommerceSubscriptionEntry)object;

			UnicodeProperties subscriptionTypeSettingsUnicodeProperties =
				commerceSubscriptionEntry.
					getSubscriptionTypeSettingsProperties();

			return _osbCommercePortalInstance.getPortalInstanceURL(
				subscriptionTypeSettingsUnicodeProperties.get(
					OSBCommercePortalInstanceConstants.
						PORTAL_INSTANCE_VIRTUAL_HOSTNAME));
		}

		return term;
	}

	@Override
	public String getLabel(String term, Locale locale) {
		ResourceBundle resourceBundle = ResourceBundleUtil.getBundle(
			"content.Language", locale, getClass());

		return LanguageUtil.get(
			resourceBundle, _commerceOrderDefinitionTermsMap.get(term));
	}

	@Override
	public List<String> getTerms() {
		return new ArrayList<>(_commerceOrderDefinitionTermsMap.keySet());
	}

	private static final String _PORTAL_INSTANCE_URL =
		"[%PORTAL_INSTANCE_URL%]";

	private static final Map<String, String> _commerceOrderDefinitionTermsMap =
		HashMapBuilder.put(
			_PORTAL_INSTANCE_URL, "portal-instance-url-definition-term"
		).build();

	@Reference
	private OSBCommercePortalInstance _osbCommercePortalInstance;

}